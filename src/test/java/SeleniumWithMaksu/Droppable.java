package SeleniumWithMaksu;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Droppable {
    static WebDriver driver;
    static String url = "https://demoqa.com/droppable";
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);

        Actions action = new Actions(driver);

        WebElement draggable = driver.findElement(By.id("draggable"));
        WebElement droppable = driver.findElement(By.xpath("(//div[@id='droppable'])[1]"));

        action.dragAndDrop(draggable, droppable).perform();

        String textResult = driver.findElement(By.xpath("(//div[@id='droppable']/p)[1]")).getText();
        String textExpected = "Dropped!";

        if (textResult.equals(textExpected)){
            System.out.println("Test Passed");
        }else
            System.out.println("Test Failed");

        Thread.sleep(3000);
        driver.quit();

    }
}
