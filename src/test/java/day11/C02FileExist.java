package day11;

import java.nio.file.Files;
import java.nio.file.Path;

public class C02FileExist  {
    public static void main(String[] args) {
        String userDir = System.getProperty("user.dir");
        String separator = System.getProperty("file.separator");
        String path = userDir+separator+"FileExist";

        System.out.println("path = " + path);

        boolean isExists = Files.exists(Path.of(path));
        System.out.println("is Exists = " + isExists);
    }


}
