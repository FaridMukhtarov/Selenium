package SeleniumWithRahulShetty;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
import static org.openqa.selenium.support.locators.RelativeLocator.with;
public class RelativeLocators {
    static WebDriver driver;
    static String url = "https://rahulshettyacademy.com/angularpractice/";
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        WebElement name = driver.findElement(By.xpath("(//input[@name='name'] )[1]"));
        name.sendKeys("Farid");

        // Uzerinde
        WebElement nameWrite = driver.findElement(with(By.tagName("label")).above((name)));
        System.out.println(nameWrite.getText());

        // Altinda
        WebElement email = driver.findElement(with(By.tagName("input")).below(name));
        email.sendKeys("ferid@gmail.com");

        WebElement exampleCheck1 = driver.findElement(By.id("exampleCheck1"));
        exampleCheck1.click();

        // Saginda
        WebElement checkText = driver.findElement(with(By.tagName("label")).toRightOf(exampleCheck1));
        System.out.println(checkText.getText());

        WebElement employed = driver.findElement(By.id("inlineRadio2"));
        employed.click();

        // Solunda
        WebElement student = driver.findElement(with(By.tagName("input")).toLeftOf(employed));
        student.click();

        Thread.sleep(2000);
        driver.quit();
    }
}

