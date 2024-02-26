package HomeWorks.day04;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Challange1 {
    @Test
    public void challangetest(){
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        // first check
        Assert.assertNotNull(driver);

        driver.get("https://automationexercise.com/");
        boolean logo = driver.findElement(By.xpath("//img[contains(@src,'logo')]")).isDisplayed();
        Assert.assertTrue(logo);

        driver.findElement(By.xpath("//*[text()=' Signup / Login']")).click();
        Assert.assertEquals("https://automationexercise.com/login",driver.getCurrentUrl());
        boolean login = driver.findElement(By.xpath("//h2[text()='Login to your account']")).isDisplayed();
        Assert.assertTrue(login);


        driver.findElement(By.xpath("//input[@data-qa='login-email']")).sendKeys("sda@test.com");
        driver.findElement(By.xpath("//input[@data-qa='login-password']")).sendKeys("sdainclasstask");
        driver.findElement(By.xpath("//button[@data-qa='login-button']")).click();
        boolean deletebutton =driver.findElement(By.xpath("//a[@href='/delete_account']")).isDisplayed();
        Assert.assertTrue(deletebutton);
    }
}
