package SeleniumWithEmrahSAGLAM;

import org.openqa.selenium.WebDriver;

import java.nio.file.Files;
import java.nio.file.Paths;

public class FileExist {
    static WebDriver driver;

    public static void main(String[] args) {

        String pathFolder = System.getProperty("user.dir");
        System.out.println(pathFolder); // /Users/farid/IdeaProjects/SeleniumTraining

        String pathUser = System.getProperty("user.home") + "/Desktop/yoxlama.txt";
        boolean resualt = Files.exists(Paths.get(pathUser));

        if (resualt){
            System.out.println("Var");
        }else
            System.out.println("Yoxdur");
    }
    // System.out.println(pathUser); // /Users/farid
}
