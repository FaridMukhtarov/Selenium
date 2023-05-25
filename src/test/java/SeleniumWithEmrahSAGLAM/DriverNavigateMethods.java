package SeleniumWithEmrahSAGLAM;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverNavigateMethods {
    static WebDriver driver;
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        // get() metodu ile eyni isi gorur Url-e gedir
        driver.navigate().to("https://www.amazon.com/");
        Thread.sleep(2000);

        // Hazirda oldugu url-eden bir basqa url-e gedir
        driver.navigate().to("https://www.youtube.com/");
        Thread.sleep(2000);

        // geri bir onceki url-e qayidir
        driver.navigate().back();
        Thread.sleep(2000);

        // ikinic url-e gedir yani ireliye
        driver.navigate().forward();
        Thread.sleep(2000);

        // seyfeni yenileyir
        driver.navigate().refresh();
        Thread.sleep(2000);

    }
}
