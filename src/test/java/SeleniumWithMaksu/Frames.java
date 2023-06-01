package SeleniumWithMaksu;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;

public class Frames {
    static WebDriver driver;
    static String url = "https://demoqa.com/frames";
    JavascriptExecutor js;

    public static void main(String[] args) throws InterruptedException, IOException {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);

        WebElement parentFrameText = driver.findElement(By.xpath("//div[@id='framesWrapper']/div[1]"));
        System.out.println(parentFrameText.getText());

        driver.switchTo().frame("frame1");

        WebElement childFrameFirst = driver.findElement(By.id("sampleHeading"));
        System.out.println("First Child Frame: " +childFrameFirst.getText());

        driver.switchTo().defaultContent();

        driver.switchTo().frame(1);
        WebElement sampleHeading = driver.findElement(By.id("sampleHeading"));
        System.out.println("Second Child Frame: " + sampleHeading.getText());

        driver.switchTo().parentFrame();
        driver.quit();


    }
}
