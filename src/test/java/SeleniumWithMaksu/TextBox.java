package SeleniumWithMaksu;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class TextBox {
    static WebDriver driver;
    static String url = "https://demoqa.com/text-box";
    JavascriptExecutor js;

    public static void main(String[] args) throws InterruptedException, IOException {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebElement fullName = driver.findElement(By.id("userName"));
        fullName.sendKeys("Farid Mukhtarov");

        WebElement email = driver.findElement(By.id("userEmail"));
        email.sendKeys("ferid@gmail.com");

        WebElement currentAddress = driver.findElement(By.id("currentAddress"));
        currentAddress.sendKeys("Baku, Azerbaijan");

        WebElement permanentAddress = driver.findElement(By.id("currentAddress"));
        permanentAddress.sendKeys("Baku, Azerbaijan");

        WebElement submitButton = driver.findElement(By.id("submit"));
        submitButton.click();

        WebElement output = driver.findElement(By.id("output"));

        String expected = "Name:Farid Mukhtarov\n" +
                "Email:ferid@gmail.com\n" +
                "Current Address :Baku, AzerbaijanBaku, Azerbaijan";


        if (output.getText().contains(expected)){
            System.out.println("Test Passed: \n" + output.getText());
        } else
            System.out.println("Test Failed");

        String cixis = "/Users/farid/IdeaProjects/SeleniumTraining/ScreenShot/outputResult.png";
        File elementScreenShot = new File(cixis);
        File hellelik = output.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(hellelik, elementScreenShot);

        Thread.sleep(2000);
        driver.quit();
    }
}
