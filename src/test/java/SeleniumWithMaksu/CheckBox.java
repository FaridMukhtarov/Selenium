package SeleniumWithMaksu;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class CheckBox {
    static WebDriver driver;
    static String url = "https://demoqa.com/checkbox";
    JavascriptExecutor js;

    public static void main(String[] args) throws InterruptedException, IOException {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebElement toggleButton = driver.findElement(By.xpath("//button[@title='Toggle']"));
        toggleButton.click();

        WebElement desktop = driver.findElement(By.xpath("//*[@id='tree-node']/ol/li/ol/li[1]/span/label/span[1]"));
        boolean isEnabled = desktop.isEnabled();


        if (isEnabled){
            desktop.click();
            WebElement result = driver.findElement(By.id("result"));
            System.out.println(result.getText());
        }else
            System.out.println("Test Passed");
        toggleButton.click();


        WebElement result = driver.findElement(By.id("result"));
        String cixis = "/Users/farid/IdeaProjects/SeleniumTraining/ScreenShot/selected.png";
        File elementScreenShot = new File(cixis);
        File hellelik = result.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(hellelik, elementScreenShot);

        Thread.sleep(2000);
        driver.quit();
    }
}
