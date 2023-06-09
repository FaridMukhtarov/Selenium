package SeleniumWithMaksu;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import static org.openqa.selenium.support.locators.RelativeLocator.with;


public class Sortable {
    static WebDriver driver;
    static String url = "https://demoqa.com/sortable";
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);

        Actions action = new Actions(driver);

        // List
        WebElement listOne = driver.findElement(By.xpath("(//div[.='One'])[1]"));
        WebElement listThree = driver.findElement(By.xpath("(//div[.='Three'])[1]"));
        action.dragAndDrop(listOne, listThree).perform();

        WebElement tabGrid = driver.findElement(By.id("demo-tab-grid"));
        tabGrid.click();

        // Grid
        WebElement gridFive = driver.findElement(By.xpath("(//div[.='Five'])[2]"));
        WebElement gridSix = driver.findElement(with(By.tagName("div")).toRightOf(gridFive));
        action.dragAndDrop(gridFive, gridSix).perform();

        Thread.sleep(3000);
        driver.quit();
    }
}
