package day06;

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

//https://demoqa.com/select-menu
//Get all the options of the dropdown
//Options size
//Print all test
//Verify the dropdown has option "Black"
//Print FirstSelectedOptionTest
//Select option "Yellow"
public class C05DropDownExercise {
    static WebDriver driver;
    @BeforeClass
    public static void setUp(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/select-menu");
    }
    @AfterClass
    public static void tearDown(){
        //driver.quit();
    }
    @Test
    public void test(){
        //Get all the options of the dropdown
        WebElement oldStyle = driver.findElement(By.id("oldSelectMenu"));
        Select select = new Select(oldStyle);
        List<WebElement> oldStyleOptions= select.getOptions();

        // Options size
        int sizeOfOptions = oldStyleOptions.size();

        // Print all test
        for (WebElement option : oldStyleOptions){
            System.out.println(option.getText());
        }// using for each loop

        for (int i=0; i<sizeOfOptions; i++){
            System.out.println("Option "+i+" is : "+oldStyleOptions.get(i).getText());
        }// using for loop


        // Verify the dropdown has option "Black"
        List<String> colourList = new ArrayList<>();
        for (WebElement option:oldStyleOptions){
            colourList.add(option.getText());
        }
        Assert.assertTrue(colourList.contains("Black"));

        // Print FirstSelectedOptionTest
        System.out.println("First Selected Option is : " + select.getFirstSelectedOption().getText());

        // Select option "Yellow"
        select.selectByVisibleText("Yellow");

    }
}
