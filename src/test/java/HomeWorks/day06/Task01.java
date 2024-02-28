package HomeWorks.day06;
//Go to URL: https://the-internet.herokuapp.com/dropdown
//Select Option 1 using index .
//Select Option 2 by value.
//Select Option 1 value by visible text.
//Print all dropdown value.
//Verify the dropdown has Option 2 text.
//Print first selected option.
//Find the size of the dropdown, Print "Expected Is Not Equal Actual" if there are not 3 elements in the dropdown.

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Task01 {
    static WebDriver driver;
    @BeforeClass
    public static void setUp(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/dropdown");
    }
    @AfterClass
    public static void tearDown(){
        //driver.quit();
    }
    @Test
    public void task1Test(){
        WebElement dropdownList = driver.findElement(By.id("dropdown"));
        dropdownList.click();
        Select select = new Select(dropdownList);

       //Select Option 1 using index .
        select.selectByIndex(1);

       //Select Option 2 by value.
        select.selectByValue("2");

       //Select Option 1 value by visible text.
        select.selectByVisibleText("Option 1");

       //Print all dropdown value.
        List<WebElement> options = select.getOptions();
        for (WebElement option:options){
            System.out.println(option.getText());}

       //Verify the dropdown has Option 2 text.
        List<String> toCheck = new ArrayList<>();
        for (WebElement option:options){
            toCheck.add(option.getText());}
        Assert.assertTrue(toCheck.contains("Option 2"));

       //Print first selected option.
        System.out.println("First Selected Option is : "+select.getFirstSelectedOption().getText());

        //Find the size of the dropdown, Print "Expected Is Not Equal Actual" if there are not 3 elements in the dropdown.
        int size = options.size();
        Assert.assertEquals(3,size);
        System.out.println("The size is true");

        Assert.assertNotEquals(3,size);
        System.out.println("Expected Is Not Equal Actual");
    }

}
