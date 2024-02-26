package HomeWorks.day03;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

public class Task05 {
    //Go to URL: https://www.linkedin.com/
    //Locate the "Email or phone", "password", "Sign in" button using absolute xpath and relative xpath.

    static WebDriver driver;
    @BeforeClass
    public static void linkedinSetUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    @AfterClass
    public static void quit(){
        driver.quit();
    }
    @Test
    public void absoluteXpath() {
        driver.get("https://www.linkedin.com/");

        //locating with absolute xpath

        WebElement email = driver.findElement(By.xpath("/html/body/main/section[1]/div/div/form/div[1]/div[1]/div/div/input"));
        //check if the email xpath is true by sending value
        email.sendKeys("it worked!");

        WebElement password = driver.findElement(By.xpath("/html/body/main/section[1]/div/div/form/div[1]/div[2]/div/div/input"));
        //check if the password xpath is true by sending value
        password.sendKeys("it worked!");

        //check if the signin xpath is true by clicking it
        WebElement signin = driver.findElement(By.xpath("/html/body/main/section[1]/div/div/form/div[2]/button"));
        signin.click();
    }
    @Test
    public void relativeXpath(){
        driver.get("https://www.linkedin.com/");

        //locating with relative xpath and relative locaters

        By emailField = RelativeLocator.with(By.xpath("//input[@id='session_key']")).above(By.id("session_password"));
        //check if the email xpath is true by sending value
        driver.findElement(emailField).sendKeys("relative xpath worked");

        By passwordField = RelativeLocator.with(By.xpath("//input[@id='session_password']")).below(By.id("session_key"));
        //check if the password xpath is true by sending value
        driver.findElement(passwordField).sendKeys("relative xpath worked");

        By signinButton = RelativeLocator.with(By.xpath("//button[@type='submit']")).below(By.xpath("//a[contains(@data-id,'forgot-password')]"));
        //check if the signin xpath is true by clicking it
        driver.findElement(signinButton).click();
    }
}
