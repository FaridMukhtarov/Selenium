package SeleniumWithMaksu;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;

public class NestedFrames {
    static WebDriver driver;
    static String url = "https://demoqa.com/nestedframes";
    JavascriptExecutor js;

    public static void main(String[] args) throws InterruptedException, IOException {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);

        WebElement parentFrame = driver.findElement(By.id("frame1"));
        driver.switchTo().frame(parentFrame);
        WebElement textParent = driver.findElement(By.xpath("//body[.='Parent frame']"));
        System.out.println(textParent.getText());

        driver.switchTo().frame(0);
        WebElement texChild = driver.findElement(By.xpath("//body[.='Child Iframe']"));
        System.out.println(texChild.getText());

        driver.switchTo().defaultContent();
        WebElement parentFrameText = driver.findElement(By.xpath("//div[@id='framesWrapper']/div[1]"));
        System.out.println(parentFrameText.getText());

    }
}
