package SeleniumWithMaksu;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;

public class ModalDialogs {
    static WebDriver driver;
    static String url = "https://demoqa.com/modal-dialogs";
    JavascriptExecutor js;

    public static void main(String[] args) throws InterruptedException, IOException {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);

        WebElement showSmallModal = driver.findElement(By.id("showSmallModal"));
        showSmallModal.click();

        Thread.sleep(2000);

        WebElement bodyText = driver.findElement(By.xpath("//div[@class='modal-body']"));
        System.out.println(bodyText.getText());

        WebElement closeSmallModal = driver.findElement(By.id("closeSmallModal"));
        closeSmallModal.click();
        driver.quit();
    }
}
