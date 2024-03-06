package day11;

import org.junit.Test;

public class FileInfo {
    @Test
    public void test1() {

        // PROVIDES THE CHARACTER THAT SEPARATES FILE PATHS
        System.out.println("1) " + System.getProperty("file.separator"));

        // DISPLAYS THE PROJECT'S INSTALLED ADDRESS AND THE ADDRESSES OF INSTALLED JAR FILES
        System.out.println("2) " + System.getProperty("java.class.path"));

        // JAVA RUNTIME ENVIRONMENT (JRE) INSTALLATION DIRECTORY
        System.out.println("3) " + System.getProperty("java.home"));

        // JRE VENDOR NAME
        System.out.println("4) " + System.getProperty("java.vendor"));

        // JRE VENDOR URL
        System.out.println("5) " + System.getProperty("java.vendor.url"));

        // JRE VERSION NUMBER
        System.out.println("6) " + System.getProperty("java.version"));

        // OPERATING SYSTEM NAME
        System.out.println("7) " + System.getProperty("os.name"));

        // OPERATING SYSTEM VERSION
        System.out.println("8) " + System.getProperty("os.version"));

        // USED PATH SEPARATOR CHARACTER
        System.out.println("9) " + System.getProperty("path.separator"));

        // USER WORKING DIRECTORY - the content root of the project
        System.out.println("10) " + System.getProperty("user.dir"));

        // USER HOME DIRECTORY - the user's name under C on Windows
        System.out.println("11) " + System.getProperty("user.home"));

        // USER ACCOUNT NAME
        System.out.println("12) " + System.getProperty("user.name"));

        // FILE SEPARATOR: '\' for Windows, '/' for Mac
        System.out.println("13) "+ System.getProperty("file.separator"));
    }
}
