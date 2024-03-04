package day09;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C05KeyBoardActions extends TestBase {
    @Test
    public void test(){
        By boxId = By.id("autoCompleteMultipleContainer");
        //Go to URL: https://demoqa.com/auto-complete
        driver.get("https://demoqa.com/auto-complete");
        WebElement textBox = driver.findElement(boxId);

        //In the Type single color name section, print "Exceptional" by using the action methods.


        actions
                .scrollToElement(textBox)
                .click(textBox)
                .keyDown(Keys.SHIFT)
                .sendKeys("e")
                .keyUp(Keys.SHIFT)
                .sendKeys("xceptional")
                .build()
                .perform();
    }
}
