package HomeWorks.day11;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Duration;

public class HW03 extends TestBase {
    @Test
    public void test() throws InterruptedException {

        //Go to URL: https://opensource-demo.orangehrmlive.com/
        driver.get("https://opensource-demo.orangehrmlive.com/");

        DownloadCSVfile(driver);
        VerifyIsDownloaded("importData.csv");

    }

    public void DownloadCSVfile(WebDriver driver) throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        By username = By.name("username");
        By password = By.name("password");
        By submit = By.xpath("//*[@type='submit']");
        By pim = By.linkText("PIM");
        By config = By.xpath("//*[@class='oxd-topbar-body-nav-tab --parent']");
        By dataImport = By.xpath("//*[text()='Data Import']");
        By download = By.linkText("Download");

        //Login page valid credentials.
        WebElement usernameElement = driver.findElement(username);
        usernameElement.sendKeys("Admin");

        WebElement passwordElement = driver.findElement(password);
        passwordElement.sendKeys("admin123");

        WebElement submitButton = driver.findElement(submit);
        submitButton.click();

        //Click PIM on the left side bar
        WebElement pimButton = driver.findElement(pim);
        wait.until(ExpectedConditions.elementToBeClickable(pimButton));
        pimButton.click();

        //Click Configuration and select Data Import
        WebElement configButton = driver.findElement(config);
        wait.until(ExpectedConditions.visibilityOf(configButton));
        configButton.click();

        WebElement dataImportButton = driver.findElement(dataImport);
        dataImportButton.click();

        //Download sample CSV file.
        WebElement downloadButton = driver.findElement(download);
        downloadButton.click();
        Thread.sleep(1000);

    }
    public void VerifyIsDownloaded(String myFile){
        //Verify if the file downloaded successfully.
        String fileName = myFile;
        String downloads = "Downloads";
        String userHome = System.getProperty("user.home");
        String separator = System.getProperty("file.separator");

        String path = userHome+separator+downloads+separator+fileName;
        System.out.println("path = " + path);

        boolean isExists = Files.exists(Path.of(path));
        System.out.println("is Exists = " + isExists);
        Assert.assertTrue(isExists);
    }
}
