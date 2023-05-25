package SeleniumWithEmrahSAGLAM;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstTestClass {

    static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {

        driver = new ChromeDriver();
        driver.get("https://www.amazon.com/");

        Thread.sleep(5000);
        driver.quit();
    }
}
