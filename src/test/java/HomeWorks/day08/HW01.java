package HomeWorks.day08;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;
import java.util.List;

public class HW01 extends TestBase {
    @Test
    public void hw1Test() throws InterruptedException {
        //Go to URL: http://demo.guru99.com/test/guru99home/
        driver.get("http://demo.guru99.com/test/guru99home/");
        String handle = driver.getWindowHandle();

        //Find the number of iframes on the page.
        By NumOfIframes = By.tagName("iframe");
        List<WebElement> ListOfIframes= driver.findElements(NumOfIframes);
        System.out.println("Number Of iFrames is : " + ListOfIframes.size());

        //Link to the third iframe (JMeter Made Easy) (https://www.guru99.com/live selenium project.html) click here.
        driver.switchTo().frame(ListOfIframes.get(3));
        By JMeter = By.xpath("//*[@src='Jmeter720.png']");
        WebElement JMeterElement = driver.findElement(JMeter);
        JMeterElement.click();

        //Exit the iframe and return to the main page.
        driver.switchTo().window(handle);
        driver.switchTo().defaultContent();
    }
}
