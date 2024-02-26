package day03;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02AssertionTest {
    /*
    Go to Google homepage
    Do the following tasks by creating 3 different test methods.
    1- Test if the URL contains google.
    2- Test if the title does not contain Facebook.
    3- Test that the Google logo appears on the page.
     */
    static WebDriver driver;
    @BeforeClass
    public static void setUp(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://google.com/");
    }
    @AfterClass
    public static void tearDown(){
        //driver.quit();
    }

    // 1- Test if the URL contains google.
    @Test
    public void urlTest(){
        String actualUrl = driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains("google"));
    }

    // 2- Test if the title does not contain Facebook.
    @Test
    public void titleTest(){
        String actualTitle = driver.getTitle();
        Assert.assertFalse(actualTitle.contains("Facebook"));
    }

    // 3- Test that the Google logo appears on the page.
    @Test
    public void logoTest(){
        WebElement logo = driver.findElement(By.className("lnXdpd"));
        Assert.assertTrue(logo.isDisplayed());
    }
}
