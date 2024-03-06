package day11;

import org.junit.Test;
import org.openqa.selenium.Cookie;
import utilities.TestBase;

import java.util.Iterator;
import java.util.Set;

public class C01Cookies extends TestBase {
    @Test
    public void test(){
        //Go to URL: https://kitchen.applitools.com/ingredients/cookie
        driver.get("https://kitchen.applitools.com/ingredients/cookie");

        //Print all the cookies.
        Set<Cookie> cookies = driver.manage().getCookies();
        for (Cookie w : cookies) {
            System.out.println(w);}
        System.out.println("__________________________________");

        // Get Cookie.
        Cookie secondCookie = driver.manage().getCookieNamed("vegetable");
        System.out.println("second Cookie is : " + secondCookie);
        System.out.println("__________________________________");


        //Find the total number of cookies.
        int sizeOfCookies = cookies.size();
        System.out.println("size Of Cookies is : " + sizeOfCookies);
        System.out.println("__________________________________");

        //Add Cookie.
        Cookie newCookie = new Cookie("fruits","mango");
        driver.manage().addCookie(newCookie);
        driver.manage().getCookies().forEach(t-> System.out.println(t));
        System.out.println("__________________________________");

        //Edit Cookie.
        Cookie anotherCookie = new Cookie("fruits","apple");
        driver.manage().addCookie(anotherCookie);
        System.out.println(driver.manage().getCookieNamed("fruits"));
        System.out.println("__________________________________");

        //Delete Cookie.
        driver.manage().deleteCookie(secondCookie);
        driver.manage().deleteCookieNamed("fruits");
        driver.manage().getCookies().forEach(t-> System.out.println(t));
        System.out.println("__________________________________");

        //Delete All Cookies.
        driver.manage().deleteAllCookies();
        driver.manage().getCookies().forEach(t-> System.out.println(t));
        System.out.println("_______________THE END________________");
    }

}
