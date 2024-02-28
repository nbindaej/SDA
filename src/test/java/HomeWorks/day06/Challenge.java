package HomeWorks.day06;

import com.github.javafaker.Faker;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Challenge {
    static WebDriver driver;
    @BeforeClass
    public static void setup() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        driver.get("https://thinking-tester-contact-list.herokuapp.com");
    }

    @AfterClass
    public static void tearDown() {
        // driver.quit();
    }
    @Test
    public void test() {

        WebElement element=  driver.findElement(By.id("email"));
        element.sendKeys("sda232@gmail.com");

        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("sda@321");

        WebElement submit = driver.findElement(By.id("submit"));
        submit.click();

        WebElement addContact = driver.findElement(By.id("add-contact"));
        addContact.click();

        //WebElement cancel = driver.findElement(By.id("cancel"));
        //Assert.assertTrue(cancel.isDisplayed());

        WebElement Title = driver.findElement(By.xpath("//h1[text()='Add Contact']"));
        Assert.assertTrue(Title.isDisplayed());

        Faker faker = new Faker();

        //

        String first = faker.name().firstName();
        WebElement firstname=  driver.findElement(By.id("firstName"));
        firstname.sendKeys(first);

        String second = faker.name().lastName();
        WebElement lastname=  driver.findElement(By.id("lastName"));
        lastname.sendKeys(second);

        String date = "1999-01-19";
        WebElement DOF= driver.findElement(By.id("birthdate"));
        DOF.sendKeys(date);

        String Email = faker.internet().emailAddress();
        WebElement email = driver.findElement(By.id("email"));
        email.sendKeys(Email);

        String phonenumber = faker.number().digits(10);
        WebElement phone = driver.findElement(By.id("phone"));
        phone.sendKeys(phonenumber);

        String street1 = faker.address().streetName();
        WebElement address1=  driver.findElement(By.id("street1"));
        address1.sendKeys(street1);

        String street2 = faker.address().streetAddress();
        WebElement address2 =  driver.findElement(By.id("street2"));
        address2.sendKeys(street2);

        String City = faker.address().city();
        WebElement city = driver.findElement(By.id("city"));
        city.sendKeys(City);

        String State = faker.address().state();
        WebElement state = driver.findElement(By.id("stateProvince"));
        state.sendKeys(State);

        String postalCode = faker.address().zipCode();
        WebElement postal = driver.findElement(By.id("postalCode"));
        postal.sendKeys(postalCode);

        String Country = faker.address().country();
        WebElement country = driver.findElement(By.id("country"));
        country.sendKeys(Country);

        WebElement submit1 = driver.findElement(By.id("submit"));
        submit1.click();


        List<WebElement> tableContent = driver.findElements(By.xpath("//*[@class='contactTableBodyRow']"));
        List<String> tableToCheck = new ArrayList<>();
        for (WebElement row : tableContent){
            tableToCheck.add(row.getText());
        }

        List<String> table = new ArrayList<String>();
        table.add(first);
        table.add(second);
        table.add(date);
        table.add(Email);
        table.add(phonenumber);
        table.add(street1);
        table.add(street2);
        table.add(City);
        table.add(State);
        table.add(postalCode);
        table.add(Country);

        Assert.assertTrue(tableToCheck.retainAll(table));
    }
}

