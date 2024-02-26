package HomeWorks.day03;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Task03 {

   //Go to https://id.heroku.com/login.
   //Enter an e-mail address.
   //Enter a password.
   //Click on the Login button.
   //There was a problem with your login.
   //If text is visible, print "Registration Failed".
   //If the text is not visible, print "Registered".
   //Close all pages.
    @Test
    public void Task03() {

        //Go to https://id.heroku.com/login.
        WebDriver driver = new ChromeDriver();
        driver.get("https://id.heroku.com/login");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();

        //Enter an e-mail address.
        driver.findElement(By.id("email")).sendKeys("Norah@gmail.com");

        //Enter a password.
        driver.findElement(By.id("password")).sendKeys("Norah1234");

        //Click on the Login button.
        driver.findElement(By.name("commit")).click();

        //There was a problem with your login.
        boolean isTextVisible = driver.findElement(By.xpath("//div[@class='alert alert-danger']")).isDisplayed();

        //If text is visible, print "Registration Failed".
        Assert.assertTrue(isTextVisible);
        System.out.println("Registration Failed");

        //If the text is not visible, print "Registered".
        Assert.assertFalse(isTextVisible);
        System.out.println("Registered");

        //Close all pages.
        driver.quit();
    }

}
