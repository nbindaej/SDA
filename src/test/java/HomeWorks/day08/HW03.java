package HomeWorks.day08;

import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.util.Iterator;
import java.util.Set;

public class HW03 extends TestBase {
    @Test
    public void test() {
        By tabElement = By.id("tabButton");
        By windElement = By.id("windowButton");
        By messageElement = By.id("messageWindowButton");
        By messageOnTab = By.id("sampleHeading");

        // Go to URL: https://demoqa.com/browser-windows
        driver.get("https://demoqa.com/browser-windows");

        // Click on all the child windows.
        driver.findElement(tabElement).click();
        driver.findElement(windElement).click();
        driver.findElement(messageElement).click();

        // Print the text present on all the child windows in the console.
        Set<String> handles = driver.getWindowHandles();
        Iterator<String> itr = handles.iterator();

        // Getting all handles one by one:
        String handleMain = itr.next();
        String handleTab = itr.next();
        String handleNewWind = itr.next();
        String handleWindMessage = itr.next();

        //Print the heading of the parent window in the console.
        // To
        driver.switchTo().window(handleTab);
        System.out.println(driver.findElement(messageOnTab).getText());

        driver.switchTo().window(handleNewWind);
        System.out.println(driver.findElement(messageOnTab).getText());
    }
}