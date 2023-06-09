package SeleniumWithRahulShetty;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.time.Duration;

public class Miscellaneous {
    static WebDriver driver;
    static String url = "https://www.google.com";

    public static void main(String[] args) throws InterruptedException, IOException {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(url);

        driver.manage().deleteAllCookies();
        System.out.println(driver.manage().getCookies().size());
        driver.manage().deleteCookieNamed("cooking");
        driver.quit();
    }
}
