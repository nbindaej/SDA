package day09;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.Scanner;


public class C03ActionsClass02 extends TestBase {
    String url = "http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html";
    @Test
    public void test(){

        driver.get(url);

        dragCapitolInCountryBox("Madrid","Spain");
        dragCapitolInCountryBox("Washington","United States");
        dragCapitolInCountryBox("Rome","Italy");
        dragCapitolInCountryBox("Seoul","South Korea");
        dragCapitolInCountryBox("Copenhagen","Denmark");
        dragCapitolInCountryBox("Oslo","Norway");
        dragCapitolInCountryBox("Stockholm","Sweden");

    }
    public void dragCapitolInCountryBox(String capital, String country){
        By cap = By.xpath("//div[text()='"+ capital +"'][2]");
        By count = By.xpath("//div[text()='"+country+"']");

        WebElement capitalBox = driver.findElement(cap);
        WebElement countryBox = driver.findElement(count);
        actions.dragAndDrop(capitalBox,countryBox).perform();
    }
}
