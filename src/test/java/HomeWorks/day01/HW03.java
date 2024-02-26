package HomeWorks.day01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class HW03 {
    public static void main(String[] args) {

        // 1- Invoke FireFox Driver
        WebDriver driver = new FirefoxDriver();

        // 2- Go to https://www.youtube.com/
        driver.get("https://www.youtube.com/");

        // 3- Verify the page title contains the word "video"
        System.out.println("Title = " + driver.getTitle());

        if(driver.getTitle().contains("video")){
            System.out.println("Title contains the word \"video\"");
        }else {
            System.out.println("Title does not contains the word \"video\"");
        }

        // 4- Close the driver
        driver.quit();
    }
}
