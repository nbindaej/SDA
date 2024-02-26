package HomeWorks.day02;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC04 {
    public static void main(String[] args) {
        // Go to the w3school URL : https://www.w3schools.com/
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.w3schools.com/");

        // Print the position and size of the page.

        System.out.println(" Position = "+driver.manage().window().getPosition());
        System.out.println(" Size = "+driver.manage().window().getSize());

        // Adjust the position and size of the page as desired.
        driver.manage().window().setPosition(new Point(10, 10));
        driver.manage().window().setSize(new Dimension(800, 800));


        // Test that the page is in the position and size you want. // Close the page.
        int x = driver.manage().window().getPosition().getX();
        int y = driver.manage().window().getPosition().getY();
        int width = driver.manage().window().getSize().width;
        int height = driver.manage().window().getSize().height;
        System.out.println("x="+x +" y="+y +" width="+width +" height="+height); // to check the expected result

        if(x==8 && y==8 && width==802 && height==771){
            System.out.println("PASSED");
        } else {
            System.out.println("FAILED");
        }

        // Close the page.
        driver.quit();

    }
}
