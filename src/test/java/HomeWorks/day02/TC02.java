package HomeWorks.day02;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC02 {
    public static void main(String[] args) {
        // Go to www.yahoo.com
        WebDriver driver = new ChromeDriver();
        driver.get("https://yahoo.com/");
        // Maximize Window
        driver.manage().window().maximize();
        // Go to www.amazon.com
        driver.get("https://amazon.com/");
        // Maximize Window
        driver.manage().window().maximize();
        // Navigate Back
        driver.navigate().back();
        // Navigate Forward
        driver.navigate().forward();
        // Refresh The Page
        driver.navigate().refresh();

    }
}
