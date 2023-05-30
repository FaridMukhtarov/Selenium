package SeleniumWithEmrahSAGLAM;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class ScreenShot_Element {

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

        // 1 ScreenShot edeceyimiz element locate  edirik
        WebElement search = driver.findElement(By.id("nav-search-bar-form"));
        // 2 Yadasa vereceyim fayl-i yaradiram
        String output = System.getProperty("user.dir") + "/ScreenShot/SearchBox.png";
        File elementScreenShot = new File(output);
        // 3 Bir fayl daha yaradiram ve search locate  ile ekran goruntusu alma prosseini ededcem
        File muveqqetiSekil = search.getScreenshotAs(OutputType.FILE);
        // 4 muvveqeti sekili isdediyim esil fayl-la copy emeliyati edirem
        FileUtils.copyFile(muveqqetiSekil, elementScreenShot);

        Thread.sleep(2000);
        driver.quit();
    }
}
