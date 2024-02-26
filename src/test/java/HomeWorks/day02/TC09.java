package HomeWorks.day02;

import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC09 {
    // Go to w3school homepage
    // Do the following tasks by creating 3 different test methods.
    // Print "STARTED" before all test() methods run
    // Print "FINISHED" after all test() methods run.
    // Before all test() methods run, print "Test has started"
    // Print "method name + running" in all test methods
    // After all test() methods run, print "Test finished"
    // Test if the title contains "w3school" when the page window is minimize
    // Test if the title does not contain "boss" when the page window is fullscreen

    static WebDriver driver;
    @BeforeClass
    public static void w3school(){
        System.out.println("STARTED");
        driver = new ChromeDriver();
        driver.get("https://w3schools.com/");
    }
    @AfterClass
    public static void Quit(){
        System.out.println("FINISHED");
        driver.quit();
    }

    @Before
    public void BeforeEachTest(){
        System.out.println("Test has started");
    }

    @After
    public void AfterEachTest(){
        System.out.println("Test finished");
    }

    @Test
    public void TitleContainM(){
        String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
        System.out.println(methodName+" running");

        driver.manage().window().minimize();
        String TitleMin = driver.getTitle();

        if (TitleMin.contains("w3school")){
            System.out.println("title contains \"w3school\"");
        }else {
            System.out.println("title does not contains \"w3school\"");
        }

    }

    @Test
    public void TitleContainF(){
        String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
        System.out.println(methodName+" running");

        driver.manage().window().fullscreen();
        String TitleFS = driver.getTitle();

        if (TitleFS.contains("boss")){
            System.out.println("title contain \"boss\"");
        }else {
            System.out.println("title does not contain \"boss\"");
        }
    }

}
