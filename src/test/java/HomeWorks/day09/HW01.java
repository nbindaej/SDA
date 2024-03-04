package HomeWorks.day09;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class HW01 extends TestBase {
    @Test
    public void test(){
        By perfect = By.xpath("//*[text()='Perfect!']");

        //Go to URL: http://demo.guru99.com/test/drag_drop.html
        driver.get("http://demo.guru99.com/test/drag_drop.html");

        //Drag and drop the BANK button to the Account section in DEBIT SIDE
        dragAndDrop(" BANK ","bank");

        //Drag and drop the SALES button to the Account section in CREDIT SIDE
        dragAndDrop(" SALES ","loan");

        //Drag and drop the 5000 button to the Amount section in DEBIT SIDE
        dragAndDrop(" 5000 ","amt7");

        //Drag and drop the second 5000 button to the Amount section in CREDIT SIDE
        dragAndDrop(" 5000","amt8");

        //Verify the visibility of Perfect text.
        WebElement perfectMessage = driver.findElement(perfect);
        Assert.assertTrue(perfectMessage.isDisplayed());

    }
    public void dragAndDrop(String button,String section){
        By OrangeButton = By.xpath("//*[text()='"+ button +"']");
        By sectionBox = By.xpath("//ol[@id='"+section+"']//li[@class='placeholder']");

        WebElement buttonToDrag = driver.findElement(OrangeButton);
        WebElement sectionToDrop = driver.findElement(sectionBox);
        actions
                .dragAndDrop(buttonToDrag,sectionToDrop)
                .perform();
    }

}
