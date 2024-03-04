package HomeWorks.day08;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.Iterator;
import java.util.Set;

public class HW02 extends TestBase {
    @Test
    public void hw2Test(){

        By text = By.xpath("//*[text()='Opening a new window']");
        By Click = By.linkText("Click Here");


        //Go to URL: https://the-internet.herokuapp.com/windows
        driver.get("https://the-internet.herokuapp.com/windows");

        //Verify the text: “Opening a new window”
        WebElement textElement = driver.findElement(text);
        Assert.assertEquals("Opening a new window",textElement.getText());

        //Verify the title of the page is “The Internet”
        Assert.assertTrue(driver.getTitle().contains("The Internet"));

        //Click on the “Click Here” button
        WebElement ClickHere = driver.findElement(Click);
        ClickHere.click();

        //Verify the new window title is “New Window”
        Set<String> handlesSet =driver.getWindowHandles();
        Iterator<String> handlesItr = handlesSet.iterator();

        String InternetHandle = handlesItr.next();
        String newWindHandle = handlesItr.next();

        driver.switchTo().window(newWindHandle);
        Assert.assertTrue(driver.getTitle().contains("New Window"));

        //Go back to the previous window and then verify the title: “The Internet”
        driver.switchTo().window(InternetHandle);
        Assert.assertTrue(driver.getTitle().contains("The Internet"));

    }
}
