package SeleniumWithRahulShetty;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class DynamicDropDown {
    static WebDriver driver;
    static String url = "https://rahulshettyacademy.com/dropdownsPractise/";
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(url);

        WebElement from = driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXTaction"));
        from.click();

        WebElement departureCity = driver.findElement(By.xpath("//a[@text='Jaipur (JAI)']"));
        departureCity.click();

        WebElement arrivalCity = driver.findElement(By.xpath("(//a[@text='Hyderabad (HYD)'])[2]"));
        arrivalCity.click();

        Thread.sleep(4000);

        driver.quit();
    }
}
