package SeleniumWithMaksu;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class Selectable {
    static WebDriver driver;
    static String url = "https://demoqa.com/selectable";
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);

        Actions action = new Actions(driver);

        // List
        WebElement listDapibus = driver.findElement(By.xpath("//li[.='Dapibus ac facilisis in']"));
        listDapibus.click();

        WebElement listPorta = driver.findElement(By.xpath("//li[.='Porta ac consectetur ac']"));
        listPorta.click();

        WebElement tabGrid = driver.findElement(By.id("demo-tab-grid"));
        tabGrid.click();

        List<WebElement> numbers = driver.findElements(By.xpath("//li[@class='list-group-item list-group-item-action']"));
        for (WebElement number : numbers) {
            number.click();
        }
        WebElement five = driver.findElement(By.xpath("//li[.='Five']"));
        five.click();

        Thread.sleep(3000);
        driver.quit();
    }
}
