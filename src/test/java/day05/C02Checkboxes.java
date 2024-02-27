package day05;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;

public class C02Checkboxes {
    // 1- Go to https://the-internet.herokuapp.com/checkboxes
    static WebDriver driver;
    @BeforeClass
    public static void setUp(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
        driver.get("https://the-internet.herokuapp.com/checkboxes");
    }
    @AfterClass
    public static void tearDown(){
        //driver.quit();
    }

    @Test
    public void checkboxText(){
        //Locate the elements of checkboxes.
        List<WebElement> checkboxes = driver.findElements(By.xpath("//*[@type='checkbox']"));
        
        //Then click on checkbox 1 if box is not selected.
        /*Assert.assertFalse(checkboxes.get(0).isSelected());
        checkboxes.get(0).click();
        //Then click on checkbox 2 if box is not selected.
        Assert.assertTrue(checkboxes.get(1).isSelected());*/

        //Then click on checkbox 1 if box is not selected.
        if(!checkboxes.get(0).isSelected()){
            checkboxes.get(0).click();
            System.out.println("checkbox 1 is selected ");
        } else {
            System.out.println("checkbox 1 is already selected ");
        }

        //Then click on checkbox 2 if box is not selected.
        if(!checkboxes.get(1).isSelected()){
            checkboxes.get(1).click();
            System.out.println("checkbox 2 is selected ");
        } else {
            System.out.println("checkbox 2 is already selected ");
        }

        //Then verify that checkbox 1 is checked.
        Assert.assertTrue(checkboxes.get(0).isSelected());
        Assert.assertTrue(checkboxes.get(0).isSelected());


    }

}
