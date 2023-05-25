package SeleniumWithEmrahSAGLAM;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.Set;

public class DriverGetMethods{

    static WebDriver driver;
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Qeyd edilen url-e gedir
        driver.get("https://www.amazon.com/");

        // Web sayitin Ure-lesini getiri
        String currentUrl = driver.getCurrentUrl();
        System.out.println("Amazon Url: " + currentUrl);

        // Web seyfenin basliq adini getirir
        String title = driver.getTitle();
        System.out.println("Seyfenin adi: " + title);

        // Seyfenin Codunu getirir
        String htmlCode = driver.getPageSource();
        System.out.println("Seyfenin Codu: " + htmlCode);

        // Seyefenin unique Hash cod-un verir
        Set<String> hashCode = driver.getWindowHandles();
        System.out.println(hashCode);

        // Driver Class novunuy verir
        String classType = String.valueOf(driver.getClass());
        System.out.println("Driver Class Novu: " + classType);

        Thread.sleep(5000);
        driver.quit();
    }
}
