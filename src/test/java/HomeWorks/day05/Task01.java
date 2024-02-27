package HomeWorks.day05;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.Driver;
import java.time.Duration;

public class Task01 {
    //Go to URL: https://demoqa.com/radio-button
    //Verify whether all 3 options given to the question can be selected.
    //When each option is selected, print the following texts on the console.
    static WebDriver driver;
    @BeforeClass
    public static void setUp(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }
    @AfterClass
    public static void quit(){
        driver.quit();
    }
    @Test
    public void task1() throws InterruptedException {
        driver.get("https://demoqa.com/radio-button");
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Select Yes Button and check if its selected
        WebElement yesButton = driver.findElement(By.id("yesRadio"));
        js.executeScript("arguments[0].click()",yesButton);
        Assert.assertTrue(yesButton.isSelected());

        // Check if "You have selected Yes" is Displayed and print it
        WebElement YesSelected = driver.findElement(By.xpath("//*[@class='mt-3']"));
        Assert.assertTrue(YesSelected.isDisplayed());
        System.out.println(YesSelected.getText());

        // Select impressive Button and check if its selected
        WebElement impressiveButton = driver.findElement(By.id("impressiveRadio"));
        js.executeScript("arguments[0].click",impressiveButton);
        Assert.assertTrue(impressiveButton.isSelected());

        // Check if "You have selected Yes" is Displayed and print it
        WebElement ImpressiveSelected = driver.findElement(By.xpath("//*[@class='mt-3']"));
        Assert.assertTrue(ImpressiveSelected.isDisplayed());
        System.out.println(impressiveButton.getText());

        // Select No Button and check if its selected
        WebElement noButton = driver.findElement(By.id("noRadio"));
        js.executeScript("arguments[0].click",noButton);
        Assert.assertTrue(noButton.isSelected());

    }

}
