package SeleniumWithEmrahSAGLAM;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Synchronization_FluentWait {

    public static void main(String[] args) {

    }

    /*
    3-) Fluent Wait

    * Selenium’da Fluent Wait, web sürücüsünün bir koşulu beklemesi için maksimum süreyi ve Exception’ını
    atmadan önce koşulu kontrol etmek istediğimiz sıklığı tanımlamak için kullanılır.Nesne bulunana veya zaman aşımı
    gerçekleşene kadar düzenli aralıklarla web elementini kontrol eder.

    * Syntax:

      Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
        .withTimeout(Duration.ofSeconds(30))
        .pollingEvery(Duration.ofSeconds(5))
        .ignoring(Exception.class);

      WebElement foo = wait.until(driver -> {
        return driver.findElement(By.id("foo"));
      });


 Not :
    Selenium Documents : https://www.selenium.dev/documentation/webdriver/waits/
     */

    }

