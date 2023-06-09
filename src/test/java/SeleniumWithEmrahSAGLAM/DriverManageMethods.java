package SeleniumWithEmrahSAGLAM;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverManageMethods {

    static WebDriver driver;
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.amazon.com/");

        driver.manage().window().getPosition();

        // seyfenin olcusunu verir
        Dimension getSize = driver.manage().window().getSize();
        System.out.println("Seyfenin olcusu: " + getSize);

        Point point = driver.manage().window().getPosition();
        System.out.println("Seyfenin yerlesimi: " + point);

        // seyfeni boyudur
        driver.manage().window().maximize();

        // seyfeni ful screen edir
        driver.manage().window().fullscreen();

        // seyfeni kicildir
        driver.manage().window().minimize();

        // seyfeye istediyimiz yeri vere bilerik
        driver.manage().window().setPosition(new Point (454,234));

        // seyfeye istediyimiz olcuyu  vere bilerik
        driver.manage().window().setSize(new Dimension(500, 800));
        System.out.println(driver.manage().window().getPosition());

        driver.quit();


    }
}
