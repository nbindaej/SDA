package HomeWorks.day07;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Challenge {
    static WebDriver driver;
    @BeforeClass
    public static void setUp(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://chercher.tech/practice/explicit-wait-sample-selenium-webdriver");
    }
    @AfterClass
    public static void tearDown(){
        driver.quit();
    }

    @Test
    public void challenge(){

        //2. click on "Click me, to Open an alert after 5 seconds" button
        driver.findElement(By.id("alert")).click();
        WebDriverWait wait_5sec = new WebDriverWait(driver,Duration.ofSeconds(5));
        wait_5sec.until(ExpectedConditions.alertIsPresent());

        //3. click on accept alert
        driver.switchTo().alert().accept();

        //4. click on "Change Text to Selenium Webdriver"
        driver.findElement(By.id("populate-text")).click();
        WebElement text = driver.findElement(By.id("h2"));
        WebDriverWait wait_10sec = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait_10sec.until(ExpectedConditions.textToBePresentInElement(text,"Selenium Webdriver"));

        //5. verify "Selenium Webdriver" message is displayed
        Assert.assertEquals(text.isDisplayed(),text.getText().contains("Selenium Webdriver"));

        //6. click on "Display button after 10 seconds" button
        driver.findElement(By.id("display-other-button")).click();
        WebElement button1 = driver.findElement(By.id("hidden"));
        wait_10sec.until(ExpectedConditions.visibilityOf(button1));

        //7. verify the button is displayed
        Assert.assertTrue(button1.isDisplayed());

        //8. click on "Enable button after 10 seconds" button
        driver.findElement(By.id("enable-button")).click();
        WebElement button2 = driver.findElement(By.id("disable"));
        wait_10sec.until(ExpectedConditions.elementToBeClickable(button2));

        //9. verify the button is enabled
        Assert.assertTrue(button2.isEnabled());

        //10. click on "Check Checkbox after 10 seconds" button
        driver.findElement(By.id("checkbox")).click();
        WebElement checkbox = driver.findElement(By.id("ch"));
        wait_10sec.until(ExpectedConditions.elementToBeSelected(checkbox));

        //11. verify the checkbox is checked
        Assert.assertTrue(checkbox.isSelected());

    }
}
