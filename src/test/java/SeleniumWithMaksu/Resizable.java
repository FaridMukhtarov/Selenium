package SeleniumWithMaksu;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Resizable {
    static WebDriver driver;
    static String url = "https://demoqa.com/resizable";
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);

        Actions action = new Actions(driver);

        // big
        WebElement bigResizable = driver.findElement(By.xpath("(//span[@class='react-resizable-handle react-resizable-handle-se'])[1]"));
        action.dragAndDropBy(bigResizable, 300, 100).perform();

        // small
        WebElement smallResizable = driver.findElement(By.xpath("(//span[@class='react-resizable-handle react-resizable-handle-se'])[2]"));
        action.dragAndDropBy(smallResizable, 300, 100).perform();

        Thread.sleep(3000);
        driver.quit();

    }
}
