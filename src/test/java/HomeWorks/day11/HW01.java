package HomeWorks.day11;

import org.junit.Test;
import org.openqa.selenium.Cookie;
import utilities.TestBase;

public class HW01 extends TestBase {
    @Test
    public void test(){
        // Go to URL: http://facebook.com
        driver.get("http://facebook.com");

        // getCookies
        System.out.println("______________Get All Cookies______________");
        driver.manage().getCookies().forEach(t-> System.out.println(t));

        // addCookie
        System.out.println("______________New Cookie Added______________");
        Cookie newCookie = new Cookie("myCookie","hello");
        driver.manage().addCookie(newCookie);
        driver.manage().getCookies().forEach(t-> System.out.println(t));

        // deleteCookie Named,
        System.out.println("______________New Cookie Deleted______________");
        driver.manage().deleteCookieNamed("myCookie");
        driver.manage().getCookies().forEach(t-> System.out.println(t));

        // deleteAllCookies.
        System.out.println("______________All Cookies Deleted______________");
        driver.manage().deleteAllCookies();
        driver.manage().getCookies().forEach(t-> System.out.println(t));

    }

}
