package HomeWorks.day11;

import org.junit.Assert;

import java.nio.file.Files;
import java.nio.file.Path;

public class HW02 {
    public static void main(String[] args) {
        //Create a File on Desktop
        //Verify that the file exists
        String fileName = "ToTest";
        String desktop = "Desktop";
        String userHome = System.getProperty("user.home");
        String separator = System.getProperty("file.separator");

        String path = userHome+separator+desktop+separator+fileName;
        System.out.println("path = " + path);

        boolean isExists = Files.exists(Path.of(path));
        System.out.println("is Exists = " + isExists);
        Assert.assertTrue(isExists);
    }
}
