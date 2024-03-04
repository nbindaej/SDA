package day09;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.time.Duration;

public class C04HorizantalSlider extends TestBase {
    @Test
    public void test(){
        By slider = By.xpath("//div[@class='range-slider vertical-range']/span[1]");

        //Go to URL: https://foundation.zurb.com/sites/docs/v/5.5.3/components/range_slider.html
        driver.get("https://foundation.zurb.com/sites/docs/v/5.5.3/components/range_slider.html");

        WebElement sliderButton = driver.findElement(slider);
        actions
                .dragAndDropBy(sliderButton,0,-45)
                .pause(Duration.ofSeconds(2))
                .dragAndDropBy(sliderButton,0,60)
                .build()
                .perform();


    }

}
