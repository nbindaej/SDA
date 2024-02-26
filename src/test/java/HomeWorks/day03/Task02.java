package HomeWorks.day03;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Task02 {
   //Navigate to website  https://testpages.herokuapp.com/styled/index.html
   //Under the Examples
   //Click on Locators - Find By Playground Test Page
   //Print the URL
   //Navigate back
   //Print the URL
   //Click on WebDriver Example Page
   //Print the URL
   //Enter value 🡪 20 and Enter to "Enter Some Numbers inputBox"
   //And then verify 'two, zero' message is displayed on page
   //Close driver.

    static WebDriver driver;
    @BeforeClass
    public static void setUp(){
        driver=new ChromeDriver();
        driver.get("https://testpages.herokuapp.com/styled/index.html");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }
    @Test
    public  void test1(){
        //Click on Locators - Find By Playground Test Page
        driver.findElement(By.id("findbytest")).click();

        //Print the URL
        String firstURL = driver.getCurrentUrl();
        System.out.println("firstURL = " + firstURL);

        //Navigate back
       driver.navigate().back();

        //Print the URL
        String seconedURL = driver.getCurrentUrl();
        System.out.println("seconedURL = " + seconedURL);

        //Click on WebDriver Example Page
        driver.findElement(By.id("webdriverexamplepage")).click();

        //Print the URL
        String thirdURL = driver.getCurrentUrl();
        System.out.println("thirdURL = " + thirdURL);

        //Enter value 🡪 20 and Enter to "Enter Some Numbers inputBox"
        driver.findElement(By.xpath("//input[@name='number-entry']")).sendKeys("20"+ Keys.ENTER);

        //And then verify 'two, zero' message is displayed on page
        boolean isMessageDisplayed = driver.findElement(By.id("message")).isDisplayed();
        Assert.assertTrue(isMessageDisplayed);
    }
    @AfterClass
    public static void quit(){
        driver.quit();
    }

}
