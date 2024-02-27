package HomeWorks.day05;

import com.google.common.io.ByteArrayDataOutput;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Task02 {
    // breakout task: (in a separate class)
    // navigate to this url https://www.saucedemo.com/v1/inventory.html
    // add the first item you find to your cart
    // open your cart*
    // assert that the item name is correct inside the cart
    static WebDriver driver;
    @BeforeClass
    public static void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @AfterClass
    public static void teardown(){
        driver.quit();
    }
    @Test
    public void addToCart(){
        driver.get("https://www.saucedemo.com/v1/inventory.html");


        // add the first item you find to your cart
        WebElement firstItem = driver.findElement(By.xpath("(//div[@class='inventory_item_name'])[1]"));
        String firstItemName = firstItem.getText();
        firstItem.click();
        driver.findElement(By.xpath("//*[text()='ADD TO CART']")).click();

        // open your cart
        driver.findElement(By.xpath("//*[@data-icon='shopping-cart']")).click();

        // assert that the item name is correct inside the cart
        WebElement itemInCart = driver.findElement(By.xpath("//div[@class='inventory_item_name']"));
        String itemInCartName = itemInCart.getText();

        // assert that the item name is correct inside the cart
        Assert.assertEquals(firstItemName,itemInCartName);
    }

}
