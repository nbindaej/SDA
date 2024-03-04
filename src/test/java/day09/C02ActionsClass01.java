package day09;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C02ActionsClass01 extends TestBase {
    /*
Mouse Actions
click(): Used to click on the current position.
doubleClick(): Used to perform a double-click at the mouse pointer's location.
clickAndHold(): Used to perform a click without releasing the mouse button.
contextClick(): Used to perform a right-click at the current mouse position.
moveToElement(WebElement target): Used to move the mouse pointer to the center of the target location.
dragAndDrop(WebElement source, WebElement target): Used to drag an element from the source and drop it to the target location.
dragAndDropBy(source, xOffset, yOffset): This method clicks and holds the source element, moves it by a specified offset, and then releases the mouse. Offsets are defined with x & y. (X = Horizontal Scroll, Y = Vertical Scroll)
release(): Used to release the left mouse button at the current position.
perform(): Executes an action. This should be used at the end to perform the action.
Don't forget to use perform()!

*/
// Go to URL: https://demoqa.com/buttons
// Run the buttons on the page using the Actions Class.
// Verify the texts that appear after the buttons are operated.

    @Test
    public void test () {

        By doubleClick = By.id("doubleClickBtn");
        By rightClick = By.id("rightClickBtn");
        By click = By.xpath("//*[@class='mt-4'][2]/button");
        By doubleClickMessage = By.id("doubleClickMessage");
        By rightClickMessage = By.id("rightClickMessage");
        By clickMessage = By.id("dynamicClickMessage");

        driver.get("https://demoqa.com/buttons");

        WebElement doubleClickElement = driver.findElement(doubleClick);
        WebElement rightClickElement = driver.findElement(rightClick);
        WebElement clickElement = driver.findElement(click);


        // Defined a variable to execute actions through the driver
        Actions actions = new Actions(driver);

        // Methods in the actions object can be chained.
        actions.scrollToElement(clickElement).perform();

        actions
                .doubleClick(doubleClickElement)
                .contextClick(rightClickElement)
                .click(clickElement)
                .perform();

        WebElement msj = driver.findElement(clickMessage);
        actions.scrollToElement(msj).perform();

        // actions.moveToElement(doubleClickButton).pause(Duration.ofSeconds(1)).doubleClick().build().perform(); This is another way (pauses for 1 second)

        // With the actions object, we can perform right-click, double click, hover over an element, and scroll actions.
        // However, these operations won't work unless perform() is called after these methods are invoked.

        // Verify the texts that appear after the buttons are operated.
        Assert.assertTrue(driver.findElement(rightClickMessage).isDisplayed());
        Assert.assertTrue(driver.findElement(doubleClickMessage).isDisplayed());
        Assert.assertTrue(driver.findElement(clickMessage).isDisplayed());

    }
}
