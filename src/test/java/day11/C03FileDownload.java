package day11;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Path;

public class C03FileDownload extends TestBase {
    @Test
    public void test() throws InterruptedException {

        // Go to URL: https://the-internet.herokuapp.com/download
        driver.get("https://the-internet.herokuapp.com/download");

        // Download selenium-snapshot.png
        driver.findElement(By.linkText("selenium-snapshot.png")).click();
        Thread.sleep(500);

        // Verify if the file downloaded successfully.
        String userHome = System.getProperty("user.home");
        String separator = System.getProperty("file.separator");

        String path = userHome+separator+"Downloads"+separator+"selenium-snapshot.png";
        System.out.println("path = " + path);

        boolean isExists = Files.exists(Path.of(path));
        System.out.println("is Exists = " + isExists);
        Assert.assertTrue(isExists);
    }
}
