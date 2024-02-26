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
        WebDriver driver = new ChromeDriver();
        driver.get("https://id.heroku.com/login");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();

        driver.findElement(By.id("email")).sendKeys("Norah@gmail.com");
        driver.findElement(By.id("password")).sendKeys("Norah1234");
        driver.findElement(By.name("commit")).click();
        boolean isTextVisible = driver.findElement(By.xpath("//div[@class='alert alert-danger']")).isDisplayed();
        //if (isTextVisible==true){
        //    System.out.println("Registration Failed");
        //}else {
        //    System.out.println("Registered");
        //}

    }

}
