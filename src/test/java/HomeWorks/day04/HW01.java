package HomeWorks.day04;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class HW01 {

    @Test
    public void temo() {
        //1.Go to https://www.temu.com/. --> i change it with extra website
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.extra.com/en-sa/");

        //2.Type "iphone" in the search bar and click ENTER.
        driver.findElement(By.id("search-input")).sendKeys("iphone"+Keys.ENTER);

        //3.Print the result number.
        String result = driver.findElement(By.xpath("//section[starts-with(@class,'product-count')]")).getText();
        System.out.println("result = " + result);

        //4.Click on the first product that appears.
        driver.findElement(By.xpath("//*[@id=\"product-lising-search-page\"]/div/section[2]/section[2]/section[2]/section[4]/section[1]/section/a/div")).click();
        //5.Add to cart.
        driver.findElement(By.xpath("/html/body/div[2]/main/main/div/div[4]/section/div/div[2]/div/div/div/button/div")).click();
        //6.Click on the cart icon.
        driver.findElement(By.id("link-to-checkout")).click();
        //7.Print the product price
        String productprice = driver.findElement(By.className("js-vas-carttotal")).getText();
        System.out.println("productprice = " + productprice);
        //8.Complete your shopping..
        //9.Turn off the driver.
        driver.quit();
    }
}