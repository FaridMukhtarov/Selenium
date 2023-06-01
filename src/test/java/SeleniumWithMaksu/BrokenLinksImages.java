package SeleniumWithMaksu;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;

public class BrokenLinksImages {
    static WebDriver driver;
    static String url = "https://demoqa.com/broken";
    JavascriptExecutor js;

    public static void main(String[] args) throws InterruptedException, IOException {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);

        // Valid Link
        HttpClient client = HttpClientBuilder.create().build();
        HttpGet requestValid = new HttpGet("http://demoqa.com/");
        HttpResponse responseValid = client.execute(requestValid);
        int responseCodeValid = responseValid.getStatusLine().getStatusCode();
        System.out.println("Status Code: " + responseCodeValid);

        // Broken Link
        HttpGet requestBroken = new HttpGet("http://the-internet.herokuapp.com/status_codes/500");
        HttpResponse responseBroken = client.execute(requestBroken);
        int responseCodeBroken = responseBroken.getStatusLine().getStatusCode();
        System.out.println("Status Code: " + responseCodeBroken);


        // Broken Image
        WebElement brokenImage = driver.findElement(By.xpath("//div/img[2]"));
        String brokenImageLink = brokenImage.getAttribute("src");

        HttpGet requestBrokenImage = new HttpGet(brokenImageLink);
        HttpResponse responseBrokenImage = client.execute(requestBrokenImage);
        int responseBrokenImageCode = responseBrokenImage.getStatusLine().getStatusCode();
        System.out.println("Broken Image Status Code: " + responseBrokenImageCode);


        // Valid Image
        WebElement validImage = driver.findElement(By.xpath("//div/img[1]"));
        String validImageUrl = validImage.getAttribute("src");

        HttpClient client1 = HttpClientBuilder.create().build();
        HttpGet requestValidImageUrl = new HttpGet(validImageUrl);
        HttpResponse responseValidImageUrl = client1.execute(requestValidImageUrl);
        int responseValidImageCode = responseValidImageUrl.getStatusLine().getStatusCode();
        System.out.println("Valid Image Status Code: " + responseValidImageCode);

        if (responseValidImageCode == 200){
            System.out.println("Test Passed");
        }else
            System.out.println("Test Failed");

        driver.quit();
    }
}
