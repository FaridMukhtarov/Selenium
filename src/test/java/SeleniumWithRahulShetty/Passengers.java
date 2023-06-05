package SeleniumWithRahulShetty;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Passengers {
    static WebDriver driver;
    static String url = "https://rahulshettyacademy.com/dropdownsPractise/";
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(url);

        WebElement divpaxinfo = driver.findElement(By.id("divpaxinfo"));
        System.out.println("Before Info: " + divpaxinfo.getText());
        divpaxinfo.click();

        WebElement hrefIncAdt = driver.findElement(By.id("hrefIncAdt"));
        for (int i = 0; i <= 4; i++) {
            hrefIncAdt.click();
        }
        WebElement hrefIncChd = driver.findElement(By.id("hrefIncChd"));
        for (int i = 0; i < 2; i++) {
            hrefIncChd.click();
        }
        WebElement hrefIncInf = driver.findElement(By.id("hrefIncInf"));
        for (int i = 0; i < 1; i++) {
            hrefIncInf.click();
        }

        WebElement done = driver.findElement(By.id("btnclosepaxoption"));
        done.click();

        System.out.println("After Info: " + divpaxinfo.getText());
        Thread.sleep(5000);
        driver.quit();
    }
}
