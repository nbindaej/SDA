package day04;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C02Example {

//   http://the-internet.herokuapp.com/add_remove_elements/
//   Click on the "Add Element" button 100 times.
//   Write a function that takes a number, and clicks the "Delete" button.
//   Given number of times, and then validates that given number of buttons was deleted.

    //. Method: createButtons(100)
//. Method: DeleteButtonsAndValidate(
    WebDriver driver;

    @Test
    public void createDeleteTest() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("http://the-internet.herokuapp.com/add_remove_elements/");
        createButtons(20);
        DeleteButtonsAndValidate(5);
    }

    public void createButtons(int numberOfButtons) {
        WebElement addbuttun = driver.findElement(By.xpath("//*[text()='Add Element']"));
        for (int i = 0; i < numberOfButtons; i++) {
            addbuttun.click();
        }
    }

    public void DeleteButtonsAndValidate(int numberOfDelete) throws InterruptedException {
        List <WebElement> deletebutton = driver.findElements(By.id("//button[text()='Delete']"));
        for (int i = 0; i < numberOfDelete; i++) {
            deletebutton.get(i).click();
        }

    }
}
