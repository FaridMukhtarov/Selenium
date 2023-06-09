package SeleniumWithMaksu;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;

public class Accordian {
    static WebDriver driver;
    static String url = "https://demoqa.com/accordian";
    JavascriptExecutor js;

    public static void main(String[] args) throws InterruptedException, IOException {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);

        WebElement text = driver.findElement(By.cssSelector("div[id='section1Content'] p"));
        System.out.println(text.getText());

        WebElement value = driver.findElement(By.xpath("//*[@id=\"accordianContainer\"]/div/div[1]/div[2]"));
        System.out.println("Aciqdir: " + value.getAttribute("class"));

        WebElement closeAcordion = driver.findElement(By.id("section1Heading"));
        closeAcordion.click();

        value = driver.findElement(By.xpath("//*[@id='accordianContainer']/div/div[1]/div[2]"));
        System.out.println("Baglanir: " + value.getAttribute("class"));

        Thread.sleep(2000);
        System.out.println("Baglandi: " + value.getAttribute("class"));

        driver.quit();
    }
}
