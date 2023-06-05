package SeleniumWithRahulShetty;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

public class LocatorsPractice {
    static WebDriver driver;
    static String url = "https://rahulshettyacademy.com/locatorspractice/";

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get(url);

        WebElement inputUsername = driver.findElement(By.id("inputUsername"));
        inputUsername.sendKeys("Farid");

        WebElement inputPassword = driver.findElement(By.name("inputPassword"));
        inputPassword.sendKeys("12345");

        WebElement chkboxOne = driver.findElement(By.id("chkboxOne"));
        chkboxOne.click();

        WebElement chkboxTwo = driver.findElement(By.id("chkboxTwo"));
        chkboxTwo.click();

        WebElement signIn = driver.findElement(By.className("submit"));
        signIn.click();

        WebElement errorText  = driver.findElement(By.xpath("//form/p[@class='error']"));
        System.out.println("Error Text: " + errorText.getText());

        WebElement forgetPasswordLink = driver.findElement(By.linkText("Forgot your password?"));
        forgetPasswordLink.click();

        // New Account Information
        WebElement name = driver.findElement(By.cssSelector("input[placeholder='Name']"));
        name.sendKeys("Farid");
        WebElement email = driver.findElement(By.cssSelector("input[placeholder='Email']"));
        email.sendKeys("ferid@gmail.com");
        WebElement phoneNumber = driver.findElement(By.cssSelector("input[placeholder='Phone Number']"));
        phoneNumber.sendKeys("215346");


        Thread.sleep(1000);
        WebElement  resetLogin = driver.findElement(By.cssSelector("button[class='reset-pwd-btn']"));
        resetLogin.click();

        String splitPassword = driver.findElement(By.cssSelector(".infoMsg")).getText();
        String[] pass = splitPassword.split("'");
        String password = pass[1].split("'")[0];

        Thread.sleep(1000);
        WebElement  gotToLogin = driver.findElement(By.cssSelector(".go-to-login-btn"));
        gotToLogin.click();


        Thread.sleep(1000);
        inputUsername = driver.findElement(By.id("inputUsername"));
        inputUsername.sendKeys("Farid");

        Thread.sleep(1000);
        inputPassword = driver.findElement(By.name("inputPassword"));
        inputPassword.sendKeys(password);

        signIn = driver.findElement(By.className("submit"));
        signIn.click();

        String expected = "You are successfully logged in.";
        WebElement syccessfully = driver.findElement(By.xpath("//p[.='You are successfully logged in.']"));

        if (syccessfully.getText().equals(expected)){
            System.out.println("Test Passed");
        }else
            System.out.println("Test Failed");

        WebElement helloUser = driver.findElement(By.xpath("//div/h2"));
        System.out.println(helloUser.getText());

        WebElement closePage = driver.findElement(By.cssSelector(".logout-btn"));
        closePage.click();

        Thread.sleep(3000);
        driver.quit();
    }
}
