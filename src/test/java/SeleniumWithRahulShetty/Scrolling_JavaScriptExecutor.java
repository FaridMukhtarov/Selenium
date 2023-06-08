package SeleniumWithRahulShetty;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Scrolling_JavaScriptExecutor {
    static WebDriver driver;
    static String url = "https://rahulshettyacademy.com/AutomationPractice/";

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,400)");
        js.executeScript("document.querySelector(\".tableFixHead\").scrollTop=500");

        List<WebElement> eachPrice = driver.findElements(By.xpath("//div[@class='tableFixHead']//tbody/tr/td[4]"));
        int sum = 0;

        for (WebElement price : eachPrice) {
            Integer number = Integer.parseInt(price.getText());
            sum += number;
        }

        String totalAmount = driver.findElement(By.className("totalAmount")).getText();
        Integer actualAmount = Integer.parseInt(totalAmount.split(":")[1].trim());

        if (actualAmount.equals(sum)){
            System.out.println("Test Passed");
        }else
            System.out.println("Test Failed");

        Thread.sleep(3000);
        driver.quit();
    }
}
