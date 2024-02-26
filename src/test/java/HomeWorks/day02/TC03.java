package HomeWorks.day02;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC03 {
    public static void main(String[] args) {

        // Expected Title
        // Set Path of the Chrome driver
        // Launch Chrome browser
        WebDriver driver = new ChromeDriver();

        // Open URL of Website
        driver.get("https://sda.edu.sa/");

        // Maximize Window
        driver.manage().window().maximize();

        // Get Title of current Page
        String Title = driver.getTitle();
        System.out.println("Title = " + Title); //title is in arabic language

        // Validate/Compare Page Title
        if (Title.contains("SDA")){
            System.out.println(" Title contain SDA");
        } else {
            System.out.println("Title does not contain SDA");
        }

        // Close Browser
        driver.quit();

    }
}
