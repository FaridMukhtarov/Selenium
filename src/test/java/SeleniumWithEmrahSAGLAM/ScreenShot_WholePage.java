package SeleniumWithEmrahSAGLAM;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class ScreenShot_WholePage {

    static WebDriver driver;
    static String url = "https://www.amazon.com/";

        public static void main(String[] args) throws InterruptedException, IOException {

            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.get(url);

            WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
            searchBox.sendKeys("Apple");
            searchBox.submit();

            // 1 ScreenShot Object yaradiram
            TakesScreenshot screenshot = (TakesScreenshot) driver;
            // 2 Yadasa vereceyim fayl-i yaradiram
            String output = System.getProperty("user.dir") + "/ScreenShot/page.png";
            File pagetScreenShot = new File(output);
            // 3 Bir fayl daha yaradiram ve ScreenShot object-i ile ekran goruntusu alma prosseini ededcem
            File muveqqetiSekil = screenshot.getScreenshotAs(OutputType.FILE);
            // muvveqeti sekili isdediyim esil fayl-la copy emeliyati edirem
            FileUtils.copyFile(muveqqetiSekil, pagetScreenShot);

            Thread.sleep(2000);
            driver.quit();
    }
}
