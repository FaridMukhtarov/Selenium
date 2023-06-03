package AutomationExercise;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class TestCase_02 {

    static WebDriver driver;
    static String url = "https://automationexercise.com/";
    JavascriptExecutor js;
    public static void main(String[] args) {
        // Login User with correct email and password

        // 1. Launch browser
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // 2. Navigate to url 'http://automationexercise.com'
        driver.get(url);

        // 3. Verify that home page is visible successfully
        String actual = driver.getCurrentUrl();

        if (actual.equals(url)){
            System.out.println("The home Page is Visible");
        }else
            System.out.println("The home Page is not Visible");

        // 4. Click on 'Signup / Login' button
        WebElement signupButton = driver.findElement(By.xpath("//li[.=' Signup / Login']"));
        signupButton.click();

        // 5. Verify 'Login to your account' is visible
        WebElement loginVisible = driver.findElement(By.xpath("//h2[.='Login to your account']"));
        String expectedLoginVisibleText = "Login to your account";

        if (loginVisible.getText().equals(expectedLoginVisibleText)){
            System.out.println("Visible: " + expectedLoginVisibleText);
        }else
            System.out.println("Test Failed");

        // 6. Enter correct email address and password
        WebElement email = driver.findElement(By.xpath("//input[@data-qa='login-email']"));
        email.sendKeys("niye@gmail.com");

        WebElement loginPassword = driver.findElement(By.xpath("//input[@data-qa='login-password']"));
        loginPassword.sendKeys("4444");

        // 7. Click 'login' button
        driver.findElement(By.xpath("//button[@data-qa='login-button']")).click();

        // 8. Verify that 'Logged in as username' is visible
        WebElement leggedAsIn = driver.findElement(By.xpath("//li[10]/a"));
        String expectedLogged = "Logged in as ferid";

        if (leggedAsIn.getText().equals(expectedLogged)){
            System.out.println("Test Passed");
        }else
            System.out.println("Test Failed");

        // 9. Click 'Delete Account' button
        driver.findElement(By.xpath("//li[5]/a[1][.=' Delete Account']")).click();

        // 10. Verify that 'ACCOUNT DELETED!' is visible
        WebElement accountDeleted = driver.findElement(By.xpath("//b[.='Account Deleted!']"));
        if (accountDeleted.equals("ACCOUNT DELETED!")){
            System.out.println("Test Passed");
        }else
            System.out.println("Test Failed");

        driver.quit();
    }
}
