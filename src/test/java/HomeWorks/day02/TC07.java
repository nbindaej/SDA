package HomeWorks.day02;

import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC07 {

        // Go to YouTube homepage
        static WebDriver driver;

        @BeforeClass
        public static void GoToYoutube(){
            driver = new ChromeDriver();
            driver.get("https://youtube.com/");
        }
        @AfterClass
        public static void Quit(){
            driver.quit();
        }

        // Do the following tasks by creating 4 different test methods.
        // Print "Test is running" before each test() method
    @Before
    public void beforeEachTest(){
        System.out.println("Test is running");
    }

        // Print "Test finished" after each test() method
    @After
    public void afterEachTest(){
        System.out.println("Test finished");
    }

        // Test if the currentURL contains "youtube"
    @Test
    public void urlContainYoutube(){
            if (driver.getCurrentUrl().contains("youtube")){
                System.out.println("currentURL contains \"youtube\"");
            } else {
                System.out.println("currentURL does not contains \"youtube\"");
            }
    }

        // Test if the title does not contain "Video".
    @Test
    public void titleContainVideo(){
        if(driver.getTitle().contains("video")){
            System.out.println("Title contains the word \"video\"");
        }else {
            System.out.println("Title does not contains the word \"video\"");
        }
    }
        // Test if the URL contains "youtube".
        @Test
        public void urlContainYoutube2(){
            if (driver.getCurrentUrl().contains("youtube")){
                System.out.println("currentURL contains \"youtube\"");
            } else {
                System.out.println("currentURL does not contains \"youtube\"");
            }
        }
        // Test if the sourcePage contains "youtube".
        @Test
        public void SPContainYoutube(){
            if (driver.getPageSource().contains("youtube")){
                System.out.println("sourcePage contains \"youtube\"");
            } else {
                System.out.println("sourcePage does not contains \"youtube\"");
            }
        }


}
