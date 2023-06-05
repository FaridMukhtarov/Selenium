package SeleniumWithRahulShetty;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class AutoSuggestiveDropDown {
    static WebDriver driver;
    static String url = "https://rahulshettyacademy.com/dropdownsPractise/";
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(url);

        WebElement autosuggest = driver.findElement(By.id("autosuggest"));
        autosuggest.sendKeys("us");

        List<WebElement> options = driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));
        for (WebElement option : options) {
            if (option.getText().equals("Cyprus")){
                System.out.println(option.getText());
                option.click();
                break;
            }
        }
        Thread.sleep(2000);
        driver.quit();
    }
}
