package SeleniumWithRahulShetty;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class Checkbox {
    static WebDriver driver;
    static String url = "https://rahulshettyacademy.com/dropdownsPractise/";
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(url);

        WebElement student = driver.findElement(By.id("ctl00_mainContent_chk_StudentDiscount"));
        student.click();

        Thread.sleep(2000);
        driver.quit();
    }
}
