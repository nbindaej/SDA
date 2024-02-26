package HomeWorks.day02;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC01 {
    public static void main(String[] args) {
        // TC - 01
// Invoke Chrome Browser
    WebDriver driver = new ChromeDriver();
// Navigate to URL: https://www.w3schools.com/
    driver.navigate().to("https://www.w3schools.com/");
// Navigate to URL: https://stackoverflow.com/
    driver.navigate().to("https://stackoverflow.com/");
// Come back to the w3schools using the back command.
    driver.navigate().back();
// Again go back to the stackoverflow website using forward command
    driver.navigate().forward();
// Refresh the Browser using refresh command.
    driver.navigate().refresh();
// Close the Browser.
    driver.quit();
    }
}
