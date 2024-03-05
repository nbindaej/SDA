package HomeWorks.day10;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Challenge extends TestBase {
    @Test
    public void test() throws AWTException, InterruptedException {

        By search = By.name("search_query");
        String topic = "Saudi Digital Academy";


        driver.get("https://www.youtube.com");
        WebElement searchBox = driver.findElement(search);

        actions
                .click(searchBox)
                .sendKeys(topic)
                .sendKeys(Keys.ENTER)
                .build()
                .perform();

        Thread.sleep(5000);
        List<WebElement> videos = driver.findElements(By.id("video-title"));

        for (int i=0; i<videos.size(); i++){
            boolean isTitle = videos.get(i).getText().contains(topic);
            if(isTitle == true){
                videos.get(i).click();}
        }

        String videoHandle = driver.getWindowHandle();
        driver.switchTo().window(videoHandle);
        Assert.assertTrue(driver.getTitle().contains(topic));

    }
}
