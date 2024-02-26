package HomeWorks.day01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HW02 {
    public static void main(String[] args) {

        // 1- Invoke Chrome Driver
        WebDriver driver = new ChromeDriver();

        // 2- Navigate to Facebook homepage URL: https://www.facebook.com/
        driver.get("https://www.facebook.com/");

        // 3- Verify expected URL equals to the actual URL.
        String expectedUrl = "https://www.facebook.com/";
        String actualUrl = driver.getCurrentUrl();
        if (expectedUrl.equals(actualUrl)){
            System.out.println("They are the same");
        } else {
            System.out.println("They are different");
        }

        // 4- Verify pagesource of FaceBook contains "Facebook" .
        String pageSource = driver.getPageSource();
        if (pageSource.contains("Facebook")) {
            System.out.println("Page source of FaceBook contains \"Facebook\"");
        } else {
            System.out.println("Page source of FaceBook doesn't contains \"Facebook\"");
        }

        //5- Close The Driver
        driver.quit();

    }
}
