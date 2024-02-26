package HomeWorks.day02;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC05 {
    public static void main(String[] args) throws InterruptedException {
        // Invoke Chrome Browser
        WebDriver driver = new ChromeDriver();

        // Open URL: https: https://www.w3schools.com/
        driver.get("https://www.w3schools.com/");

        // Maximize the window.
        driver.manage().window().maximize();

        // Print the position and size of the page.
        System.out.println("Position = "+driver.manage().window().getPosition());
        System.out.println("Size = "+driver.manage().window().getSize());

        // Minimize the page.
        driver.manage().window().minimize();

        // Wait 7 seconds in the icon state and maximize the page.
        Thread.sleep(7000);
        driver.manage().window().maximize();

        // Print the position and dimensions of the page in maximized state.
        System.out.println("Position = "+driver.manage().window().getPosition());
        System.out.println("Size = "+driver.manage().window().getSize());

        // Make the page fullscreen.
        driver.manage().window().fullscreen();

        // Close the Browser.
        driver.quit();

    }
}
