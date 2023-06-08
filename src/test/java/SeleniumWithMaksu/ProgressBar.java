package SeleniumWithMaksu;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProgressBar {
    static WebDriver driver;
    static String url = "https://demoqa.com/progress-bar";

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);

        WebElement startStopButton = driver.findElement(By.id("startStopButton"));
        startStopButton.click();

        WebElement progressBar = driver.findElement(By.cssSelector("div[role='progressbar']"));

        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(15));
        wait.pollingEvery(Duration.ofMillis(50));
        wait.until(ExpectedConditions.attributeToBe(progressBar,"aria-valuenow", "50"));

        startStopButton.click();
        Thread.sleep(3000);
        startStopButton.click();

        wait.until(ExpectedConditions.attributeToBe(By.cssSelector("button[class='mt-3 btn btn-primary"),"id", "resetButton"));
        WebElement resetButton = driver.findElement(By.cssSelector("button[class='mt-3 btn btn-primary"));

        Thread.sleep(1000);
        resetButton.click();
    }
}
