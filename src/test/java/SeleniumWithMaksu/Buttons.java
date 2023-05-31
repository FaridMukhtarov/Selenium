package SeleniumWithMaksu;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.io.IOException;
import java.time.Duration;

public class Buttons {
    static WebDriver driver;
    static String url = "https://demoqa.com/buttons";
    JavascriptExecutor js;

    public static void main(String[] args) throws InterruptedException, IOException {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        Actions action = new Actions(driver);

        // Double Click
        WebElement doubleClickBtn = driver.findElement(By.id("doubleClickBtn"));
        action.doubleClick(doubleClickBtn).perform();

        Thread.sleep(2000);

        // Right Click
        WebElement rightClickBtn = driver.findElement(By.id("rightClickBtn"));
        action.contextClick(rightClickBtn).perform();

        Thread.sleep(2000);

        WebElement dynamicClickButton = driver.findElement(By.xpath("//button[.='Click Me']"));
        dynamicClickButton.click();


        WebElement doubleClickMessage = driver.findElement(By.id("doubleClickMessage"));
        System.out.println("Double Click Message: " + doubleClickMessage.getText());

        WebElement rightClickMessage = driver.findElement(By.id("rightClickMessage"));
        System.out.println("Right Click Message: " + rightClickMessage.getText());

        WebElement dynamicClickMessage = driver.findElement(By.id("dynamicClickMessage"));
        System.out.println("Dynamic Click Message: " + dynamicClickMessage.getText());


        driver.quit();
    }
}
