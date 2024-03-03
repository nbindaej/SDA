package HomeWorks.day08;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class HW02 extends TestBase {
    @Test
    public void hw2Test(){
        //Go to URL: https://the-internet.herokuapp.com/windows
        driver.get("https://the-internet.herokuapp.com/windows");
        String InternetPageHandle = driver.getWindowHandle();

        //Verify the text: “Opening a new window”
        By text = By.xpath("//*[text()='Opening a new window']");
        WebElement textElement = driver.findElement(text);
        Assert.assertEquals("Opening a new window",textElement.getText());

        //Verify the title of the page is “The Internet”
        Assert.assertTrue(driver.getTitle().contains("The Internet"));

        //Click on the “Click Here” button
        By Click = By.linkText("Click Here");
        WebElement ClickHere = driver.findElement(Click);
        ClickHere.click();

        //Verify the new window title is “New Window”
        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);}

        Assert.assertTrue(driver.getTitle().contains("New Window"));

        //Go back to the previous window and then verify the title: “The Internet”
        driver.switchTo().window(InternetPageHandle);
        Assert.assertTrue(driver.getTitle().contains("The Internet"));

    }
}
