package day11;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C04FileUpload extends TestBase {
    @Test
    public void test(){
        By upload = By.id("file-submit");
        By choose = By.id("file-upload");
        By uploadMessage = By.xpath("//h3['File Uploaded!']");

        String userDir = System.getProperty("user.dir");
        String separator = System.getProperty("file.separator");
        String fileName = "FileExist";
        String path = userDir+separator+fileName;


        //Go to URL: https://the-internet.herokuapp.com/upload
        driver.get("https://the-internet.herokuapp.com/upload");

        //Find the path of the file that you want to upload.
        WebElement chooseFile = driver.findElement(choose);
        chooseFile.sendKeys(path);

        //Click on Upload button.
        WebElement uploadButton = driver.findElement(upload);
        uploadButton.click();

        //Verify the upload message.
        WebElement uploadMsj = driver.findElement(uploadMessage);
        Assert.assertTrue(uploadMsj.isDisplayed());

    }
}
