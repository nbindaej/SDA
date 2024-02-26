package HomeWorks.day03;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Task01 {
    //Create the driver with BeforeClass and make it static inside the class.
    //Go to http://www.google.com

    By SearchBox  = By.id("APjFqb");
    By ResultNum = By.id("result-stats");
    static WebDriver driver;
    @BeforeClass
    public static void setup(){
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://www.google.com/");
    }

    //Type "Green Mile" in the search box and print the number of results.
    @Test
    public void greenMileTest(){
        driver.findElement(SearchBox).sendKeys("Green Mile"+Keys.ENTER);
        System.out.println(driver.findElement(ResultNum).getText());
        driver.findElement(By.id("APjFqb")).clear();

    }

    //Type "Premonition" in the search box and print the number of results.
    @Test
    public void premonitionTest(){
        driver.findElement(SearchBox).sendKeys("Premonition"+Keys.ENTER);
        System.out.println(driver.findElement(ResultNum).getText());
        driver.findElement(SearchBox).clear();
    }

    //Type "The Curious Case of Benjamin Button" in the search box and print the number of results.
    @Test
    public void BenjaminTest(){
        driver.findElement(SearchBox).sendKeys("The Curious Case of Benjamin Button"+Keys.ENTER);
        System.out.println(driver.findElement(ResultNum).getText());
    }

    //Close with AfterClass.
    @AfterClass
    public static void quit(){
        driver.quit();
    }
}
