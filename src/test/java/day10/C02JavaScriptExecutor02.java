package day10;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.JScriptUtilities;
import utilities.TestBase;

import javax.swing.*;

public class C02JavaScriptExecutor02 extends TestBase {
    @Test
    public void test(){
        By iframe = By.xpath("//iframe");
        By BlueBox = By.cssSelector("body>div");
        By searchBox = By.name("s");
        By YellowBox = By.xpath("//*[@class='dbl']");

        // Go to URL: https://api.jquery.com/dblclick/
        driver.get("https://api.jquery.com/dblclick/");

        // Switch to iframe
        WebElement iframeElement = driver.findElement(iframe);
        driver.switchTo().frame(iframeElement);
        WebElement BlueBoxElement = driver.findElement(BlueBox);

        //Double click on the blue square at the bottom of the page
        JScriptUtilities.scrollIntoViewJS(driver,iframeElement);
        actions
                .doubleClick(BlueBoxElement)
                .perform();

        //Write the changed color on search box on the top of the page
        String colorCode= BlueBoxElement.getCssValue("background-color");
        driver.switchTo().defaultContent();

        JScriptUtilities.scrollAllUpByJS(driver);

        driver.findElement(By.name("s")).sendKeys(colorCode);

        //Click "jQuery in Action" at the bottom of the page.
        JScriptUtilities.scrollDownByJS(driver);
        driver.findElement(By.xpath("//a[@href = 'https://www.manning.com/books/jquery-in-action-third-edition']")).click();
    }
}
