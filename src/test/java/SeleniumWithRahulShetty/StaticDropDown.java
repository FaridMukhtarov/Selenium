package SeleniumWithRahulShetty;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class StaticDropDown {
    static WebDriver driver;
    static String url = "https://rahulshettyacademy.com/dropdownsPractise/";
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(url);

        WebElement dropDown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
        dropDown.click();

        Select select = new Select(dropDown);

        select.selectByVisibleText("USD");
        System.out.println(select.getFirstSelectedOption().getText());


        select.selectByValue("INR");
        System.out.println(select.getFirstSelectedOption().getText());


        select.selectByIndex(2);
        System.out.println(select.getFirstSelectedOption().getText());

        dropDown.click();


        Thread.sleep(3000);
        driver.quit();

    }
}
