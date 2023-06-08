package SeleniumWithRahulShetty;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class WindowsHandle {
    static WebDriver driver;
    static String url = "https://rahulshettyacademy.com/loginpagePractise/";
    public static void main(String[] args) throws InterruptedException, IOException {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(url);

        WebElement linkWindow = driver.findElement(By.partialLinkText("Free Access to InterviewQues"));
        linkWindow.click();

        List<String> windows = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(windows.get(1));

        String text = driver.findElement(By.xpath("//p[@class='im-para red']")).getText();
        text = text.split("at")[1].split("with")[0].trim();
        System.out.println(driver.getCurrentUrl() + "\n" + text);

        driver.switchTo().window(windows.get(0));
        WebElement username = driver.findElement(By.id("username"));
        username.sendKeys(text);

        Thread.sleep(5000);
        driver.quit();

    }
}
