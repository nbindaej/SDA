package day05;

import org.junit.AfterClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class C01ChromeOptions {
    /*
        ChromeOptions Class

       It is a concept used in Selenium WebDriver to modify various properties of the Chrome driver.
       start-maximized: Opens Chrome in maximize mode.
       incognito: Opens Chrome in incognito mode.
       headless: Runs Chrome in headless mode (without displaying).
       disable-extensions: Disables existing extensions in the Chrome browser.
       disable-popup-blocking: Disables pop-up blocking in the Chrome browser.
       make-default-browser: Sets Chrome as the default browser.
       version: Prints the Chrome browser version.
       disable-infobars: Prevents Chrome from displaying the "Chrome is being controlled by automated software" notification.
       */
    static WebDriver driver;

    @Test
    public void test() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("incognito");
        //options.addArguments("headless");
        options.addArguments("disable-popup-blocking");
        options.addArguments("disable-infobars");
        driver = new ChromeDriver(options);
        driver.get("https://google.com/");
    }

    @AfterClass
    public static void tearDown(){
        //driver.close();
        //driver.quit();
    }
}
