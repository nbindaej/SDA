package day05;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C04RadioButtons {

    @Test
    public void radioButtonTest() throws InterruptedException {
        //Go to URL:  https://www.facebook.com/
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://www.facebook.com/");

        //Click on Create an Account button.
        driver.findElement(By.xpath("//*[starts-with(@id,'u_0_0')]")).click();
        //Then click on the radio buttons.
        List<WebElement> radButtons = driver.findElements(By.xpath("//input[@type='radio']"));
        radButtons.get(0).click();
        Assert.assertTrue(radButtons.get(0).isSelected());
        radButtons.get(1).click();
        Assert.assertTrue(radButtons.get(1).isSelected());
        radButtons.get(2).click();
        Assert.assertTrue(radButtons.get(2).isSelected());


        /*for (WebElement Button:radButtons){
            Button.click();
            Assert.assertTrue(Button.isSelected());
        }*/


    }

}
