package SeleniumWithRahulShetty;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.IOException;
import java.time.Duration;

public class DisabledOrEnabledCalendar {
    static WebDriver driver;
    static String url = "https://rahulshettyacademy.com/dropdownsPractise/";

    public static void main(String[] args) throws InterruptedException, IOException {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(url);

        WebElement viewData = driver.findElement(By.id("Div1"));
        String value = viewData.getAttribute("style");

        System.out.println("After: " + value);
        if (value.contains("block; opacity: 0.5;")) {
            System.out.println("is not Enabled");
        }
        WebElement roundTrip = driver.findElement(By.xpath("//label[.='Round Trip']"));
        boolean isEnabled = roundTrip.isEnabled();
        if (isEnabled){
            System.out.println("Round Trip is clickable");
            roundTrip.click();
        }else
            System.out.println("Round Trip is not clickable");

        Thread.sleep(3000);
        value = viewData.getAttribute("style");
        System.out.println("Before: " + value);
        driver.quit();
    }
}
