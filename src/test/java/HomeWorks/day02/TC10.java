package HomeWorks.day02;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC10 {
    // Go to Automation Exercises homepage
    // Find the locators of the relevant areas and click on them
    // https://automationexercise.com/
    static WebDriver driver;

    @BeforeClass
    public static void AEH() {
        driver = new ChromeDriver();
        driver.get("https://automationexercise.com/");
    }

    @AfterClass
    public static void Quit() {
        driver.quit();
    }

    // Task 01 --> " Home "
    @Test
    public void HomeTest() throws InterruptedException {
        WebElement Home = driver.findElement(By.linkText("Home"));
        Home.click();
        Thread.sleep(5000);
    }

    // Task 02 --> " Products "
    @Test
    public void ProductTest() throws InterruptedException {
        WebElement Products = driver.findElement(By.xpath("//i[@class='material-icons card_travel']"));
        Products.click();
        Thread.sleep(5000);
    }

    // Task 03 --> " Cart "
    @Test
    public void CartTest() throws InterruptedException {
        WebElement cart = driver.findElement(By.linkText("Cart"));
        cart.click();
        Thread.sleep(5000);
    }
    // Task 04 --> " Signup / Login "
    @Test
    public void LoginTest() throws InterruptedException {
        WebElement Login = driver.findElement(By.linkText("Signup / Login"));
        Login.click();
        Thread.sleep(5000);
        }
    // Task 05 --> " Test Cases "
    @Test
    public void TestCases() throws InterruptedException {
        WebElement TestCase = driver.findElement(By.linkText("Test Cases"));
        TestCase.click();
        Thread.sleep(5000);
    }
    // Task 06 --> " API Testing "
    @Test
    public void API() throws InterruptedException {
        WebElement APITest = driver.findElement(By.linkText("API Testing"));
        APITest.click();
        Thread.sleep(5000);
    }
    // Task 07 --> " Video Tutorials "
    @Test
    public void VideoTut() throws InterruptedException {
        WebElement Video = driver.findElement(By.linkText("Video Tutorials"));
        Video.click();
        Thread.sleep(5000);
    }
    // Task 08 --> " Contact us "
    @Test
    public void ContactUs() throws InterruptedException {
        WebElement Contact = driver.findElement(By.linkText("Contact us"));
        Contact.click();
        Thread.sleep(5000);
    }

}