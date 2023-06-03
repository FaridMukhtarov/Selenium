package SeleniumWithMaksu;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.io.IOException;
import java.time.Duration;

public class Slider {
    static WebDriver driver;
    static String url = "https://demoqa.com/slider";
    JavascriptExecutor js;

    public static void main(String[] args) throws InterruptedException, IOException {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        int xOffset = 20;
        WebElement slider = driver.findElement(By.xpath("//input[@type='range']"));
        Actions action = new Actions(driver);
        action.dragAndDropBy(slider, xOffset, 0).perform();

        WebElement sliderValue = driver.findElement(By.id("sliderValue"));

        String sliderValueTextOutput = sliderValue.getAttribute("value");
        String sliderTextInput = slider.getAttribute("value");

        if (sliderValueTextOutput.equals(sliderTextInput)){
            System.out.println("Test Passed");
        }else
            System.out.println("Test Failed");
    }
}
