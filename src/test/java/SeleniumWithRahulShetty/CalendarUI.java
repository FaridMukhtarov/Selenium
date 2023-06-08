package SeleniumWithRahulShetty;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class CalendarUI {
    static WebDriver driver;
    static String url = "https://www.path2usa.com/travel-companion/";

    public static void main(String[] args) throws InterruptedException, IOException {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(url);


        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,900)");
        Thread.sleep(1000);

        WebElement dateOfTravel = driver.findElement(By.cssSelector("input[id='form-field-travel_comp_date']"));
        dateOfTravel.click();

        WebElement buttonMonth = driver.findElement(By.cssSelector(".flatpickr-next-month"));
        WebElement month = driver.findElement(By.cssSelector(".flatpickr-current-month"));


//        String month = driver.findElement(By.className("cur-month")).getText();
//        WebElement buttonTop = driver.findElement(By.className("arrowUp"));
//        String currentYear = driver.findElement(By.cssSelector(".numInput.cur-year")).getText();
//        List<WebElement> days = driver.findElements(By.cssSelector(".flatpickr-day "));
    }
}