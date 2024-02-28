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
import java.util.List;

public class C04DropdownExercise {
     /*
    Launch the browser.
    Open "https://demoqa.com/select-menu".
    Select the Standard Multi-Select using the element id.
    Verifying that the element is multi-select.
    Select 'Opel' using the index and deselect the same using index.
    Select 'Saab' using value and deselect the same using value.
    Deselect all the options.
    Close the browser.
     */
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
        // 1- Select the Standard Multi-Select using the element id.
        WebElement carsSelection = driver.findElement(By.id("cars"));
        Select select = new Select(carsSelection);

        // 2- Verifying that the element is multi-select.
        Assert.assertTrue(select.isMultiple());

        // 3- Select 'Opel' using the index and deselect the same using index.
        select.selectByIndex(2);

        // Verify that Opel is selected
        List<WebElement> carsOptions = select.getOptions();
        Assert.assertTrue(carsOptions.get(2).isSelected());

        select.deselectByIndex(2);
        // Verify that Opel is deselected
        Assert.assertFalse(carsOptions.get(2).isSelected());

        // 4- Select 'Saab' using value and deselect the same using value.
        select.selectByValue("saab");
        select.getAllSelectedOptions().size();
        Assert.assertEquals(1,select.getAllSelectedOptions().size());
        select.deselectByValue("saab");

        // 5- Deselect all the options.
        select.deselectAll();
    }
}
