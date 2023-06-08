package SeleniumWithMaksu;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class ToolTips {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demoqa.com/tool-tips");

        WebElement toolTipButton = driver.findElement(By.id("toolTipButton"));
        Actions action = new Actions(driver);
        action.moveToElement(toolTipButton).perform();

        WebElement tooltipInner = driver.findElement(By.className("tooltip-inner"));

        String actualResult = tooltipInner.getText();
        String expectedResult = "You hovered over the Button";

        if (actualResult.equals(expectedResult)){
            System.out.println("Test Passed");
        }else
            System.out.println("Test Failed");

        Thread.sleep(3000);
        driver.quit();
    }
}
