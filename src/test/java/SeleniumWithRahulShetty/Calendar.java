package SeleniumWithRahulShetty;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class Calendar {
    static WebDriver driver;
    static String url = "https://rahulshettyacademy.com/dropdownsPractise/";
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(url);

        WebElement calendar = driver.findElement(By.id("ctl00_mainContent_view_date1"));
        calendar.click();

        List<WebElement> days = driver.findElements(By.cssSelector(".ui-state-default"));
        for ( WebElement day : days) {
            if (day.getText().equals("20")){
                System.out.println("You have chosen the " + day.getText() + "th of the month");
                day.click();
                break;
            }
        }


        Thread.sleep(3000);
        driver.quit();

    }
}
