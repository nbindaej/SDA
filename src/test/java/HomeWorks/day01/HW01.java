package HomeWorks.day01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HW01 {
    public static void main(String[] args) {

        // 1- Create chrome driver
        WebDriver driver=new ChromeDriver();

        // 2- Open google home page: https://www.google.com
        driver.get("https://www.google.com");

        // 3- Print Title on page
        String title = driver.getTitle();
        System.out.println("The Title is : "+title);

        // 4- Print Current URL on page
        String url = driver.getCurrentUrl();
        System.out.println("The URL is :"+url);

        // 5- Close/Quit the browser
        // driver.close();
        driver.quit();
    }
}
