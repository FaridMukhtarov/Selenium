package SeleniumWithRahulShetty;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Alerts {
    static WebDriver driver;
    static String url = "https://rahulshettyacademy.com/AutomationPractice/";
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(url);


        WebElement alertbtn = driver.findElement(By.id("alertbtn"));
        alertbtn.click();
        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();


        WebElement confirmbtn = driver.findElement(By.id("confirmbtn"));
        confirmbtn.click();
        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().dismiss();


        WebElement name = driver.findElement(By.id("name"));
        name.sendKeys("Farid");
        confirmbtn.click();
        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();

        Thread.sleep(3000);
        driver.quit();
    }
}
