package SeleniumWithMaksu;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class Links {
    static WebDriver driver;
    static String url = "https://demoqa.com/broken";
    public static void main(String[] args) throws InterruptedException, IOException {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(url);

        WebElement wholePage = driver.findElement(By.xpath("//div[@class='col-12 mt-4 col-md-6']"));
        List<WebElement> wholePageLinks = wholePage.findElements(By.tagName("a"));

        System.out.println("Links Size: " + wholePageLinks.size());

        HttpClient client = HttpClientBuilder.create().build();
        for (WebElement link : wholePageLinks) {

            String href = link.getAttribute("href");

            HttpGet request = new HttpGet(href);
            HttpResponse response = client.execute(request);
            int responseCode = response.getStatusLine().getStatusCode();

            if (responseCode == 200){
                System.out.println("Ok: " + responseCode + " " + request);
            } else if (responseCode == 500) {
                System.out.println("Server error: " + responseCode + " " +request);
            }else
                System.out.println("Other response code");
        }
    }
}
