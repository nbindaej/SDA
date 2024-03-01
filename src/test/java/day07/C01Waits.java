package day07;

import com.sun.jdi.ByteType;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class C01Waits {
    // Some websites introduce waiting times between operations; hence, we use waiting methods.
// Selenium waits are a critical concept for synchronized locating of elements and preventing errors like elementnotfound.

// Implicit Wait
// Explicit Wait *
// Fluent Wait

    static WebDriver driver;

    @BeforeClass
    public static void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterClass
    public static void tearDown() {
        //driver.quit();
    }

    @Test
    public void hardWait() {

        // unconditional synchronization - static wait
        // static wait shows the timeout value on its own and allows the tool to proceed only when the specified time has elapsed
        // We use Thread.sleep() method in Java with Selenium to provide static waiting.

        driver.get("https://seleniumatfingertips.wordpress.com/");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            System.out.println("message can be given or something else...");
        }
        driver.findElement(By.xpath("//a[.='Home']"));

    }

    @Test
    public void pageLoadTimeout() {
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        //driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.MICROSECONDS);
        // Wait for the page to load for 30 seconds, if it doesn't load within this time, it throws a timeout error
        // It waits for the page to be completely loaded for the specified time.
        driver.get("https://seleniumatfingertips.wordpress.com/");
    }

    @Test
    public void implicitWait() {
    /* Implicit wait:
   It assigns a waiting time for all elements. However, it does not wait longer once the element is found.
   It waits up to the specified time to avoid NoSuchElement errors for all elements.
   It is global, waits for all web elements.
     */
        driver.get("https://seleniumatfingertips.wordpress.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Test the visibility of the "Group Test in TestNg" text
        WebElement groupTxt = driver.findElement(By.partialLinkText("Group Tes"));
        Assert.assertTrue(groupTxt.isDisplayed());
    }

    @Test
    public void explicitWait() {
    /*
    It specifies the condition and time WebDriver should wait.
    Practically, WebDriverWait and explicitly wait are synonymous since their definitions and uses perfectly match.
    //How to use Explicit wait
    // 1- Create a WebDriverWait object
    // 2- Provide the desired condition in the until method of the wait object
     */
        driver.get("https://webdriveruniversity.com/Ajax-Loader/index.html");
        WebElement button = driver.findElement(By.id("button1"));

        // At this point, our code is in the process of loading the element,
        // it can be located but may not be clickable; in this case, ElementNotClickable error is thrown.
        // We provide the desired condition in the wait object's until method.

        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(button));
        button.click();

        // only time is defined, not active yet
        // It does not have to wait for 15 seconds; it continues as soon as the element is clickable.

        //wait.until(ExpectedConditions.visibilityOf(button)); // wait until it is visible
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("click"))); // wait until located
        // It is a local type of wait, used when implicitly wait is insufficient.
    }

    @Test
    public void fluentWait() {
        // Almost never used.
        // It checks whether the elements satisfy the condition for the specified time.
        // It continues if the condition is met; otherwise, it throws an exception.

        driver.get("https://webdriveruniversity.com/Ajax-Loader/index.html");
        WebElement button = driver.findElement(By.id("button1"));

        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10)) // total waiting time when the page is first opened
                .pollingEvery(Duration.ofMillis(20)) // polling every 20 milliseconds for the presence check
                .ignoring(NoSuchElementException.class); // ignores or prevents the NoSuchElementException// .

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("button1"))));
        // wait for 10 seconds for a web element to be on the page, check its presence every 20 milliseconds
    }
}
