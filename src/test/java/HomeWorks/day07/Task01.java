package HomeWorks.day07;

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

public class Task01 {
    static WebDriver driver;
    @BeforeClass
    public static void setUp(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
    }
    @AfterClass
    public static void tearDown(){
        driver.quit();
    }

    @Test
    public void task1() throws InterruptedException {
        // 1- Click for JS Alert
        // Click on the first button (JS Alert) and accept the alert
        WebElement jsAlert = driver.findElement(By.xpath("//button[contains(text(),'JS Alert')]"));
        jsAlert.click();
        driver.switchTo().alert().accept();

        // find the result and print it
        WebElement result1 = driver.findElement(By.id("result"));
        String resultText = result1.getText();
        System.out.println("result is : " + resultText);

        // verify the message is appeared and true
        Assert.assertTrue(result1.isDisplayed());
        Assert.assertEquals("You successfully clicked an alert",resultText);


        // 2- Click for JS Confirm
        // Click on the second button (JS Confirm) and cancel the alert
        WebElement jsConfirm = driver.findElement(By.xpath("//button[contains(text(),'JS Confirm')]"));
        jsConfirm.click();
        driver.switchTo().alert().dismiss();

        // find the result and print it
        WebElement result2 = driver.findElement(By.id("result"));
        String resultText2 = result2.getText();
        System.out.println("result is : " + resultText2);

        // verify the message is appeared and true
        Assert.assertTrue(result2.isDisplayed());
        Assert.assertEquals("You clicked: Cancel",resultText2);


        // 3- Click for JS Prompt
        // Click on the third button (JS Prompt)
        WebElement jsPrompt = driver.findElement(By.xpath("//button[contains(text(),'JS Prompt')]"));
        jsPrompt.click();

        // write "Hello everyone!" and click OK
        driver.switchTo().alert().sendKeys("Hello everyone!");
        driver.switchTo().alert().accept();

        // find the result and print it
        WebElement result3 = driver.findElement(By.id("result"));
        String resultText3 = result3.getText();
        System.out.println("result is : " + resultText3);

        // verify the message is appeared and true
        Assert.assertTrue(result3.isDisplayed());
        Assert.assertEquals("You entered: Hello everyone!",resultText3);

    }
}
