package HomeWorks.day03;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task04 {
    //Navigate to https://testpages.herokuapp.com/styled/index.html
    //Click on Simple Calculator under Micro Apps.
    //Type any number in the first input.
    //Type any number in the second input.
    //Click on Calculate.
    //Get the result.
    //Print the result.
    @Test
    public void task4(){
        //Navigate to https://testpages.herokuapp.com/styled/index.html
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://testpages.herokuapp.com/styled/index.html");

        //Click on Simple Calculator under Micro Apps.
        driver.findElement(By.id("calculatetest")).click();

        //Type any number in the first input.
        driver.findElement(By.id("number1")).sendKeys("10");

        //Type any number in the second input.
        driver.findElement(By.id("number2")).sendKeys("15");

        //Click on Calculate.
        driver.findElement(By.id("calculate")).click();

        //Get the result.
        String result = driver.findElement(By.id("answer")).getText();

        //Print the result.
        System.out.println("result = " + result);


    }
}
