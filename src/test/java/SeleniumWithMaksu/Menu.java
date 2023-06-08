package SeleniumWithMaksu;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class Menu {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demoqa.com/menu");
        Actions action = new Actions(driver);

        WebElement menuItemTwo = driver.findElement(By.xpath("//a[.='Main Item 2']"));
        System.out.println(menuItemTwo.getText());
        action.moveToElement(menuItemTwo).perform();

        WebElement subList = driver.findElement(By.xpath("//a[.='SUB SUB LIST »']"));
        System.out.println(subList.getText());
        action.moveToElement(subList).perform();

        WebElement subItem = driver.findElement(By.xpath("//a[.='Sub Sub Item 2']"));
        System.out.println(subItem.getText());
        action.moveToElement(subItem).perform();

        Thread.sleep(3000);
        driver.quit();
    }
}
