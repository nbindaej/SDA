package HomeWorks.day09;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.time.Duration;

public class HW02 extends TestBase {
    @Test
    public void test(){
        By slider = By.xpath("//*[@id='js-rangeslider-0']/div[2]");
        By output = By.id("js-output");

        //Go to URL: https://rangeslider.js.org/
        driver.get("https://rangeslider.js.org/");

        WebElement resultBefore = driver.findElement(output);
        System.out.println("output before shifting = " + resultBefore.getText());

        //Shift 100 units to the right and 100 units to the left on the horizontal axis
        WebElement sliderButton = driver.findElement(slider);
        actions
                .dragAndDropBy(sliderButton,100,0)
                .pause(Duration.ofSeconds(2))
                .dragAndDropBy(sliderButton,-100,0)
                .build()
                .perform();

        WebElement resultAfter = driver.findElement(output);
        System.out.println("output after shifting = " + resultAfter.getText());
        Assert.assertEquals(resultBefore.getText(),resultAfter.getText());

    }
}
