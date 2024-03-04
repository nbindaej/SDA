package day09;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.Iterator;
import java.util.Set;

public class C01HandlesOfMultipleWindows extends TestBase {
    @Test
    public void test() throws InterruptedException {
        //Go to URL: https://demoqa.com/browser-windows
        driver.get("https://demoqa.com/browser-windows");

        //Click on the windows - "WindowButton"
        By newTab = By.id("tabButton");
        By newWindow = By.id("windowButton");
        By newMessage = By.id("messageWindowButton");
        By messageOnTab = By.id("sampleHeading");


        //Click on all the child windows.
        WebElement newTabElement = driver.findElement(newTab);
        newTabElement.click();
        Thread.sleep(5000);
        WebElement newWindowElement = driver.findElement(newWindow);
        newWindowElement.click();
        Thread.sleep(5000);
        WebElement newMessageElement = driver.findElement(newMessage);
        newMessageElement.click();

        //Print the text present on all the child windows in the console.
        Set<String> handlesSet =driver.getWindowHandles();
        Iterator<String> handlesItr = handlesSet.iterator();

        // Getting first handle
        String mainHandle = handlesItr.next();
        String newTabHandle = handlesItr.next();
        String newWindowHandle = handlesItr.next();
        String newMessageHandle = handlesItr.next();

        //Print the heading of the parent window in the console.
        driver.switchTo().window(newTabHandle);
        System.out.println(driver.findElement(messageOnTab).getText());
    }
}
