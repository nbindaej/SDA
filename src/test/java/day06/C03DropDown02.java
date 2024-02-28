package day06;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class C03DropDown02 {
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
    public void dropdownTest() throws InterruptedException {
        // 1- locate WebElement with select tag
        WebElement oldStyle = driver.findElement(By.id("oldSelectMenu"));

        // 2- Create select object by passing select element into constructor
        Select select = new Select(oldStyle); // The tag name must be <select> to use select method

        // 3- Select By Index method
        select.selectByIndex(3);
        Thread.sleep(2000);

        // 4- Select By Value
        select.selectByValue("4");
        Thread.sleep(2000);
        select.selectByValue("red");

        // 5- Select By visible text
        select.selectByVisibleText("Purple");

        // Check of oldStyle is multiple check , it returns true or false
        System.out.println("Old Style selection = " + select.isMultiple()); // --> false

        WebElement standardMulti = driver.findElement(By.id("cars"));
        Select select2 = new Select(standardMulti);
        System.out.println("Standard Multi Selection = " + select2.isMultiple()); // --> true

    }
}
