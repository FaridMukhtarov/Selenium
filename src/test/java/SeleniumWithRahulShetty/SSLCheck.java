package SeleniumWithRahulShetty;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;

public class SSLCheck {
    public static void main(String[] args) throws InterruptedException {


        // ssl accepted

         ChromeOptions options = new ChromeOptions();
        // FirefoxOptions options = new FirefoxOptions();
        // EdgeOptions options = new EdgeOptions();
        // SafariOptions options = new SafariOptions();

        options.setAcceptInsecureCerts(true);
        System.out.println(options.getBrowserName()); // browser adini verir
        System.out.println(options.getBrowserVersion()); // browser versiyonunu verir

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(options); // options here
        driver.get("https://expired.badssl.com/");
        System.out.println(driver.getTitle());

        Thread.sleep(3000);
        driver.quit();
    }
}
