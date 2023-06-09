package SeleniumWithMaksu;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;

public class Alerts {
    static WebDriver driver;
    static String url = "https://demoqa.com/alerts";
    JavascriptExecutor js;

    public static void main(String[] args) throws InterruptedException, IOException {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);

        // On button click, alert will appear after 5 seconds
        WebElement timerAlertButton = driver.findElement(By.id("timerAlertButton"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        timerAlertButton.click();

        wait.until(ExpectedConditions.alertIsPresent());
        String text = driver.switchTo().alert().getText();
        System.out.println(text);
        driver.switchTo().alert().accept();

        // Click Button to see alert
        WebElement alertButton = driver.findElement(By.id("alertButton"));
        alertButton.click();
        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();

        // On button click, confirm box will appear
        WebElement confirmButton = driver.findElement(By.id("confirmButton"));
        confirmButton.click();
        driver.switchTo().alert().dismiss();

        // On button click, prompt box will appear
        WebElement promtButton = driver.findElement(By.id("promtButton"));
        promtButton.click();
        driver.switchTo().alert().sendKeys("Farid");
        driver.switchTo().alert().accept();

        driver.quit();
    }
}
