package day08;

import org.junit.Test;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

public class C04WindowHandle01 extends TestBase {

    // driver.getWindowHandle(); -> Returns the window handle (ID) of the active window or tab.
    // driver.getWindowHandles(); -> Returns all window handles (IDs) of open windows or tabs as a Set.
    // driver.switchTo().window(id); -> Allows us to switch to the window or tab with the specified window handle (ID).
    // driver.switchTo().newWindow(TAB); -> Creates a new tab.
    // driver.switchTo().newWindow(WINDOW); -> Creates a new window.

    // We open browser using TestBase

    @Test
    public void test(){
        // Open https://www.amazon.com/ in the open tab
        driver.get("https://www.amazon.com/");
        String amazonHandle = driver.getWindowHandle();

        // Create a new tab
        driver.switchTo().newWindow(WindowType.TAB);

        // Open https://www.linkedin.com/ in the open tab
        driver.get("https://www.linkedin.com/");
        String linkedinHandle = driver.getWindowHandle();

        // Go back to amazon window
        driver.switchTo().window(amazonHandle);

        // Create a new window
        driver.switchTo().newWindow(WindowType.WINDOW);
        String newWindowHandle = driver.getWindowHandle();

        // Open https://opensource-demo.orangehrmlive.com/web/index.php/auth/login in the window that opens
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

    }
}
