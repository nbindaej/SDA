package day03;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class C03Locators {
    /* There are 8 locator types (element positioners) in Selenium:
        - ID
            * The ID locator is actually the id attribute of a web element.
            * If it is in the form id="value," we locate the element with the value.
        - NAME
            * The NAME locator is the name attribute of a web element.
            * If it is in the form name="value," we locate the element with the value.
        - CLASS
            * The CLASS locator is the class attribute of a web element.
            * If it is in the form class="value," we locate the element with the value.
        - TAGNAME
            * It is a strategy for locating elements using HTML element tags.
            * If <tagName></tagName> is present, we locate this element with the tagName value.
        - LINK TEXT
            * The linkText locator is only found in <a> elements.
        - PARTIAL LINK TEXT
            * Similar to linkText, but it is sufficient to get a part of the text.

        -CSS
        -XPATH
       */

    static WebDriver driver;

    By FirstFieldId =By.id("session_key");

    @BeforeClass
    public static void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.linkedin.com");
    }

    @Test
    public void locatorId(){
        WebElement firstField = driver.findElement(By.id("session_key"));
        WebElement firstField2 = driver.findElement(FirstFieldId);
        firstField.click();
    }
    @Test
    public void locatorName() throws InterruptedException {
        driver.findElement(By.name("session_key"));
    }
    @Test
    public void locatorClass() throws InterruptedException {
        driver.findElement(By.className("text-color-text font-sans text-md outline-0 bg-color-transparent grow"));
    }
    @Test
    public void locatorTagName() throws InterruptedException {
        driver.findElement(By.tagName("input"));
    }
    @Test
    public void locatorLinkText() throws InterruptedException {
        driver.findElement(By.linkText("User Agreement"));
    }
    @Test
    public void locatorPartialLinkText() throws InterruptedException {
       driver.findElement(By.partialLinkText("User Agreemen"));
    }
    @AfterClass
    public static void tearDown(){
        // driver.close();
    }
}
// /html/body/div[1]/header/div/div[1]/div[2]/div/form/div[2]/div[1]/input