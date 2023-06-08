package SeleniumWithRahulShetty;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class newWindow {

    static WebDriver driver;

    public static void main(String[] args) throws InterruptedException, IOException {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


        driver.get("https://www.google.com");
        driver.switchTo().newWindow(WindowType.WINDOW);

        driver.get("https://www.path2usa.com/travel-companion/");
        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        System.out.println(tabs.size());

        driver.switchTo().window(tabs.get(1));
        String titleSecond = driver.getTitle();

        driver.switchTo().window(tabs.get(0));
        WebElement goo = driver.findElement(By.id("APjFqb"));
        goo.sendKeys(titleSecond);
        goo.submit();

        WebElement takeScreen = driver.findElement(By.cssSelector("div[class='RNNXgb']"));
        File file = takeScreen.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file,new File("/Users/farid/IdeaProjects/SeleniumTraining/ScreenShot/SearchBox.png"));

        System.out.println("Dimension: "+takeScreen.getRect().getDimension());
        System.out.println("Height: "+takeScreen.getRect().getHeight());
        System.out.println("Width: "+takeScreen.getRect().getWidth());
        System.out.println("Point: "+takeScreen.getRect().getPoint());

        Thread.sleep(3000);
        driver.quit();
    }
}
