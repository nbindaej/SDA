package day10;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.awt.*;
import java.awt.event.KeyEvent;

public class C03RobotClass extends TestBase {
    @Test
    public void test() throws AWTException {
        By search = By.id("gh-ac");

        driver.get("https://www.ebay.com");

        Robot robot = new Robot();
        WebElement searchBox = driver.findElement(search);
        searchBox.click();
        robot.keyPress(KeyEvent.VK_SHIFT);
        robot.keyPress(KeyEvent.VK_A);
        robot.keyRelease(KeyEvent.VK_SHIFT);
        robot.keyRelease(KeyEvent.VK_A);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

        robot.mouseWheel(30);
    }
}
