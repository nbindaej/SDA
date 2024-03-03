package HomeWorks.day08;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.util.List;

public class Challenge extends TestBase {
    By Title = By.xpath("//*[text()='Registration Form']");
    By firstName = By.xpath("//*[contains(@aria-labelledby,'Name0')]");
    By lastName = By.xpath("//*[contains(@aria-labelledby,'Name1')]");
    By radioButtons = By.xpath("//span[contains(@class,'cusChoiceSpan')]");
    By radioButtonCheck = By.id("Radio_3");
    By DropDown = By.id("Dropdown-arialabel");
    By CheckBoxes = By.xpath("//*[@class='checkChoice cusChoiceLabel']");
    By CheckBox = By.id("Checkbox_2");
    By Rating = By.xpath("//*[@class='icon icon-star']");
    By submit = By.xpath("//*[text()='Submit']");
    By message = By.xpath("//*[@elname='thankyouMsgText']");
    @Test
    public void ChallengeTest() throws InterruptedException {


        // 1- Go to Clarusway Registration Form
        driver.get("https://clarusway.getlearnworlds.com/sda-test-registration-form");

        // 2- Verify that form is opened successfully
        Assert.assertTrue(driver.findElement(Title).isDisplayed());

        // 3- Fill the form
        // first I need to switch to another frame
        driver.switchTo().frame(0); // 0 because we only have one frame

        // 4- Fill the first and last name
        WebElement firstNameElement = driver.findElement(firstName);
        WebElement lastNameElement = driver.findElement(lastName);

        firstNameElement.sendKeys("Norah");
        lastNameElement.sendKeys("Bin Daej");

        // 5- Select a Radio button
        List<WebElement> radioButtonList = driver.findElements(radioButtons);
        radioButtonList.get(2).click();
        WebElement radioButtonCheckElement = driver.findElement(radioButtonCheck);
        Assert.assertTrue(radioButtonCheckElement.isSelected());


        // 6- Select DropDown
        WebElement dropDownElement = driver.findElement(DropDown);
        Select select = new Select(dropDownElement);
        select.selectByIndex(2);

        // 7- Check the Single line
        By SingleLine = By.id("SingleLine-arialabel");
        WebElement singleLineElement = driver.findElement(SingleLine);
        Assert.assertFalse(singleLineElement.isEnabled());

        // 8- Select the third Checkbox
        List<WebElement> CheckBoxList= driver.findElements(CheckBoxes);
        CheckBoxList.get(1).click();
        WebElement CheckBoxElement = driver.findElement(CheckBox);
        Assert.assertTrue(CheckBoxElement.isSelected());


        // 9- use the Rating
        List<WebElement> RatingStars = driver.findElements(Rating);
        RatingStars.get(2).click();
        Assert.assertFalse(RatingStars.get(3).isSelected());
        Assert.assertFalse(RatingStars.get(4).isSelected());

        // 10- Click Submit
        WebElement submitElement = driver.findElement(submit);
        submitElement.click();

        // 11- Check if you submitted successfully
        WebElement messageElement = driver.findElement(message);
        Assert.assertTrue(messageElement.isDisplayed());
    }

    @Test
    public void WrongInfo(){
        // 1- Go to Clarusway Registration Form
        driver.get("https://clarusway.getlearnworlds.com/sda-test-registration-form");

        // 2- Verify that form is opened successfully
        Assert.assertTrue(driver.findElement(Title).isDisplayed());

        // 3- Fill the form
        // first I need to switch to another frame
        driver.switchTo().frame(0); // 0 because we only have one frame

        // 4- try to click submit without filling any thing
        WebElement submitElement = driver.findElement(submit);
        submitElement.click();

        WebElement error1 = driver.findElement(By.id("error-Name"));
        Assert.assertTrue(error1.isDisplayed());

        WebElement error2 = driver.findElement(By.id("error-Dropdown"));
        Assert.assertTrue(error2.isDisplayed());
    }

}
