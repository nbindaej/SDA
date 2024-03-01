package HomeWorks.day07;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Task02 {
    static WebDriver driver;
    @BeforeClass
    public static void setUp(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/basic_auth");
    }
    @AfterClass
    public static void tearDown(){
        driver.quit();
    }
    @Test
    public void task2(){
        // navigate to another URL that contains the username and password
        // username:admin , password:admin
        driver.navigate().to("https://admin:admin@the-internet.herokuapp.com/basic_auth");

        // get the current url and print it
        System.out.println("Current URL is :" + driver.getCurrentUrl());

        // get the page content and print it
        WebElement pageContent = driver.findElement(By.id("content"));
        System.out.println(pageContent.getText());

        // verify that Login done successfully
        Assert.assertTrue(pageContent.getText().contains("Congratulations!"));
    }
}
