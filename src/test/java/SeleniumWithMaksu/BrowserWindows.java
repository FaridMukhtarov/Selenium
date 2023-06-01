package SeleniumWithMaksu;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class BrowserWindows {
    static WebDriver driver;
    static String url = "https://demoqa.com/browser-windows";
    JavascriptExecutor js;

    public static void main(String[] args) throws InterruptedException, IOException {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);

        WebElement newTab = driver.findElement(By.id("tabButton"));
        newTab.click();

        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        System.out.println(tabs.size());

        driver.switchTo().window(tabs.get(1));
        System.out.println(driver.getCurrentUrl());
        WebElement sampleHeading = driver.findElement(By.id("sampleHeading"));
        System.out.println(sampleHeading.getText());

        Thread.sleep(2000);
        driver.close();


    }
}
