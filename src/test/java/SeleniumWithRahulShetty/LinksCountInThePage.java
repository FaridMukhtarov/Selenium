package SeleniumWithRahulShetty;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class LinksCountInThePage {
    static WebDriver driver;
    static String url = "https://rahulshettyacademy.com/AutomationPractice/";
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(url);

        // give me the count of links on the page
        List<WebElement>  linkSizePage = driver.findElements(By.tagName("a"));
        System.out.println("Count of links on the page: " + linkSizePage.size());

        // Footer links
        WebElement footer = driver.findElement(By.id("gf-BIG"));
        List<WebElement> footerLinks = footer.findElements(By.tagName("a"));
        System.out.println("Count of links on the Footer: " + footerLinks.size());

        WebElement discountCouponsTable = driver.findElement(By.xpath("(//td/ul)[1]"));
        List<WebElement> links = discountCouponsTable.findElements(By.tagName("a"));
        System.out.println("Count of links on the Table of Footer: " + links.size());

        for ( WebElement link : links) {
            String url = link.getAttribute("href");
            link.click();

            String pageTitle = driver.getTitle();
            System.out.println("Link: " + url +", Page Title: " + pageTitle);
            driver.navigate().back();
        }

        Thread.sleep(3000);
        driver.quit();

    }
}
