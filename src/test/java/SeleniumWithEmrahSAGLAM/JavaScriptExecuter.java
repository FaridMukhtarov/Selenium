package SeleniumWithEmrahSAGLAM;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.time.Duration;

public class JavaScriptExecuter {
    static WebDriver driver;
    static String url = "https://www.amazon.com/";

    public static void main(String[] args) throws InterruptedException, IOException {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(url);

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        WebElement sell = driver.findElement(By.xpath("//a[.='Sell products on Amazon']"));

        jse.executeScript("arguments[0].scrollIntoView(true);", sell);
        jse.executeScript("arguments[0].click();", sell);

        driver.quit();
    }
}
