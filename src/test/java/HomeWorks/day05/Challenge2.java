package HomeWorks.day05;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;


public class Challenge2 {

    //***** The SAME Challenge BUT in different way ****//
    WebDriver driver;

    @Test
    public void test01(){
        driver = new ChromeDriver();
        driver.get("https://webdriveruniversity.com/To-Do-List/index.html");

        String todoText = "test TODO";
        driver.findElement(By.tagName("input")).sendKeys(todoText + Keys.ENTER);
        List<WebElement> todoList = driver.findElements(By.xpath("//ul/li"));

        boolean result = false;
        for (WebElement w: todoList){
            if (w.getText().equals(todoText)){
                result = true;
            }
        }
        Assert.assertTrue(result);

        driver.findElement(By.xpath("//*[contains(text(), 'test')]/span/i")).click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        todoList = driver.findElements(By.xpath("//ul/li"));
        for (WebElement w: todoList){
            if (w.getText().equals(todoText)){
                result = false;
            }
        }
        Assert.assertTrue(result);
        WebElement completedTODO = driver.findElement(By.xpath("//li[contains(text(), 'Go to potion class')]"));
        completedTODO.click();
        result = completedTODO.getAttribute("class").equals("completed");
        Assert.assertTrue(result);
    }
}
