package SeleniumWithMaksu;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class DatePicker {
    static WebDriver driver;
    static String url = "https://demoqa.com/date-picker";
    JavascriptExecutor js;

    public static void main(String[] args) throws InterruptedException, IOException {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        dataSelect("January", "1995", "1" );

        Thread.sleep(3000);
        driver.quit();

    }
    public static void dataSelect(String month, String year, String day){
        WebElement datePickerMonthYearInput = driver.findElement(By.id("datePickerMonthYearInput"));
        datePickerMonthYearInput.click();

        // Month
        WebElement monthSelect = driver.findElement(By.cssSelector(".react-datepicker__month-select"));
        Select select = new Select(monthSelect);
        select.selectByVisibleText(month);

        // Years
        WebElement yearSelect = driver.findElement(By.cssSelector(".react-datepicker__year-select"));
        select = new Select(yearSelect);
        select.selectByVisibleText(year);

        List<WebElement> days = driver.findElements(By.cssSelector(".react-datepicker__day"));
        for (WebElement each : days) {
            if (each.getText().equals(day)){
                each.click();
                break;
            }
        }
        System.out.println(day + " " + month + " " + year);
    }
}
