package day10;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.JScriptUtilities;
import utilities.TestBase;
 /*
    JavascriptExecutor js = (JavascriptExecutor)driver;
    The first step to using JavascriptExecutor is to cast the driver to the JavascriptExecutor interface.
    This interface enables scrolling the page and executing JavaScript commands.

    The most commonly used method is the executescript() method

    executeScript - ScrollBy() moves the web page forward by the given pixel value.
    executeScript("window.scrollBy(x-pixel, y-pixel)"); or js.executeScript("scroll(x, y);");
    x-pixel is the number on the x-axis, moving left if positive and right if negative.
    y-pixel is the number on the y-axis, moving down if positive and up if negative.

    js.executeScript("window.scrollBy(0, 1000)"); → Scrolls down vertically by 1000 pixel
    executeScript - ScrollTo() takes the web page to the given pixel value.
    js.executeScript("window.scrollTo(0, 0)"); → Scrolls to the top of the browser.
    js.executeScript("window.scrollTo(0, document.body.scrollHeight)"); → Scrolls to the bottom of the browser.

    js.executeScript("arguments[0].click()", element); → Clicks on the element.
    scrollIntoView() scrolls based on the visibility of an element on the web page.
    js.executeScript("arguments[0].scrollIntoView();", WebElement);
*/

public class C01JavaScriptExecutor extends TestBase {
    @Test
    public void test(){
        By getStarted = By.xpath("//*[contains(text(),'Get started')]");

        driver.get("https://linkedin.com");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("alert(\"hi\");");

        // handle the alert
        driver.switchTo().alert().accept();

        // Scrolling down using JavaScript
        // 1) "window.scrollBy(horizontal,vertical);"
        js.executeScript("window.scrollBy(0,3000);");

        // 2) "window.scrollTo(x,y);"
        WebElement getStartedButton = driver.findElement(getStarted);
        int x = getStartedButton.getLocation().getX();
        int y = getStartedButton.getLocation().getY();

        js.executeScript("window.scrollTo("+x+","+y+");");

        // 3) executeScript("arguments[0].scrollIntoView();",element)
        js.executeScript("arguments[0].scrollIntoView();",getStartedButton);

        JScriptUtilities.clickElementByJS(driver,getStartedButton);

    }
}
