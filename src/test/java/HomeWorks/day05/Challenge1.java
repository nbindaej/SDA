package HomeWorks.day05;

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

public class Challenge1 {
    static WebDriver driver;
    @BeforeClass
    public static void setUp(){
        // 1- Launch Browser
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }
    @AfterClass
    public static void quit(){
        driver.quit();
    }
    @Test
    public void challenge1Test() throws InterruptedException {
        // 2- Navigate to the application
        driver.get("https://webdriveruniversity.com/To-Do-List/index.html");


        // 3 - Add a task to the list
        WebElement textBox = driver.findElement(By.xpath("//*[@type='text']"));
        textBox.sendKeys("Finish homework 1"+ Keys.ENTER);
        Assert.assertTrue(textBox.isEnabled());
        Thread.sleep(5000);

        // 4- verify if the task added
        WebElement textAdded = driver.findElement(By.xpath("//*[text()=' Finish homework 1']"));
        Assert.assertTrue(textAdded.isDisplayed());

        // 5- Mark a task as completed
        textAdded.click();
        Thread.sleep(5000);

        // 6- Check if task is completed
        WebElement completed = driver.findElement(By.xpath("//*[@class='completed']"));
        Assert.assertTrue(completed.isDisplayed());

        // 7- Remove the task you have added
        driver.findElement(By.xpath("//*[@class='completed']//i[@class='fa fa-trash']")).click();
        Thread.sleep(5000);

        // 8- Check if the task is removed
        Assert.assertFalse(completed.isDisplayed());
    }
}
