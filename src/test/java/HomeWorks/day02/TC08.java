package HomeWorks.day02;

import org.checkerframework.checker.units.qual.C;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC08 {
    // Go to google homepage
    static WebDriver driver;

    @BeforeClass
    public static void GoToGoogle(){
        driver = new ChromeDriver();
        driver.get("https://google.com/");
    }
    @AfterClass
    public static void Quit(){
        driver.quit();
    }
    // Do the following tasks by creating 3 different test methods.
    // Print "Tests are starting to run" before each test() method
    @Before
    public void BeforeEachTest(){
        System.out.println("Tests are starting to run");
    }

    // Print "Tests have finished running" after each test() method
    @After
    public void AfterEachTest(){
        System.out.println("Tests have finished running");
    }

    // Test if the title is the same when the page window is maximize and minimize
    @Test
    public void MaxMin() throws InterruptedException {
        driver.manage().window().maximize();
        String TitleMax = driver.getTitle();
        System.out.println("Title when the page is maximize: "+TitleMax);

        driver.manage().window().minimize();
        String TitleMin = driver.getTitle();
        System.out.println("Title when the page is Minimize: "+TitleMin);

        if (TitleMax.equals(TitleMin)){
            System.out.println("Title is the same ");
        }else {
            System.out.println("Title is not the same");
        }

    }

    // Test if the title does not contain "Video" when the page window is fullscreen
    @Test
    public void fullscreen(){
        driver.manage().window().fullscreen();
        String TitleFS = driver.getTitle();
        System.out.println("Title when the page is fullscreen: "+TitleFS);
        if(TitleFS.contains("video")){
            System.out.println("Title contain \"Video\"");
        }else {
            System.out.println("Title does not contain \"Video\"");
        }
    }

    // Test if the URL contains "google"
    @Test
    public void urlContainGoogle(){
        String CurrentURL = driver.getCurrentUrl();
        if (CurrentURL.contains("google")){
            System.out.println("URL contains \"google\"");
        }else {
            System.out.println("URL does not contains \"google\"");
        }
    }

}
