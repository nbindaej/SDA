package HomeWorks.day02;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TC06 {
    public static void main(String[] args) {
        // Invoke FireFox Driver
        WebDriver driver = new FirefoxDriver();

        // Go to https://www.youtube.com/
        driver.get("https://www.youtube.com/");

        // Maximize the window
        driver.manage().window().maximize();

        // Verify the page title contains the word video.
        System.out.println("Title = " + driver.getTitle());

        if(driver.getTitle().contains("video")){
            System.out.println("Title contains the word \"video\"");
        }else {
            System.out.println("Title does not contains the word \"video\"");
        }

        // Minimize the window
        driver.manage().window().minimize();

        // Verify the page title contains the word video.
        System.out.println("Title = " + driver.getTitle());

        if(driver.getTitle().contains("video")){
            System.out.println("Title contains the word \"video\"");
        }else {
            System.out.println("Title does not contains the word \"video\"");
        }

        // Make the page fullscreen
        driver.manage().window().fullscreen();

        // Close the driver.
        driver.quit();

    }
}
