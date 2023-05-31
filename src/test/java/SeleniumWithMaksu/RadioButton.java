package SeleniumWithMaksu;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.time.Duration;

public class RadioButton {
    static WebDriver driver;
    static String url = "https://demoqa.com/radio-button";
    JavascriptExecutor js;

    public static void main(String[] args) throws InterruptedException, IOException {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


        WebElement yesRadio = driver.findElement(By.xpath("//label[@for='yesRadio']"));
        if (yesRadio.isEnabled()){
            yesRadio.click();
            WebElement selectedYes = driver.findElement(By.cssSelector("p.mt-3"));
            System.out.println(selectedYes.getText());
        }else {
            System.out.println("yesRadio Button is not enabled");
        }

        WebElement noRadioButton = driver.findElement(By.id("noRadio"));
        String result = noRadioButton.isEnabled() ? "Radio Button is enabled" : "Radio Button is not enabled";
        System.out.println(result);

        driver.quit();
    }
}
