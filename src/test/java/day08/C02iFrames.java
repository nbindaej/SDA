package day08;

import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C02iFrames {
    static WebDriver driver;

    @BeforeClass
    public static void setup () {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @Test
    public void test(){
        //Go to https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/.
        driver.get("https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/");

        //Maximize the website.
        driver.manage().window().maximize();

        //Click on the second emoji.
        driver.switchTo().frame("emoojis");
        By allEmojis = By.xpath("//div[@class='mdl-tabs__tab-bar']/a");
        List<WebElement> listOfEmojis = driver.findElements(allEmojis);
        listOfEmojis.get(1).click();

        //Click on all second emoji items.
        //Return to the parent iframe.
        driver.switchTo().defaultContent();

        //Fill out the form (Fill the form with the text you want) and press the apply button.
        driver.findElement(By.id("smiles")).sendKeys("animal");
    }
}
