package SeleniumWithMaksu;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;

public class DynamicProperties {
    static WebDriver driver;
    static String url = "https://demoqa.com/dynamic-properties";
    JavascriptExecutor js;

    public static void main(String[] args) throws InterruptedException, IOException {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement randomId = driver.findElement(By.xpath("This text has random Id"));
        System.out.println(randomId.getText());

        WebElement enableAfter = driver.findElement(By.id("enableAfter"));
        wait.until(ExpectedConditions.elementToBeClickable(enableAfter));
        enableAfter.click();

        WebElement colorChange = driver.findElement(By.id("colorChange"));
        String attribute = colorChange.getAttribute("class");
        System.out.println("Before: " + attribute);
        wait.until(ExpectedConditions.attributeToBe(colorChange, "class", "mt-4 text-danger btn btn-primary"));
        attribute = colorChange.getAttribute("class");

        if (attribute.equals("mt-4 text-danger btn btn-primary")){
            colorChange.click();
            System.out.println("After: " + attribute);
        }else
            System.out.println("Do not enough time");

        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("#visibleAfter")));

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.cssSelector("#visibleAfter")).click();
    }
}
