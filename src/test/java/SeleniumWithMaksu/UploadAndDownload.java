package SeleniumWithMaksu;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;

public class UploadAndDownload {
    static WebDriver driver;
    static String url = "https://demoqa.com/upload-download";
    JavascriptExecutor js;

    public static void main(String[] args) throws InterruptedException, IOException {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);

        //Upload
        String file = "/Users/farid/Downloads/subscribe_-_86089 (Original).mp4";
        WebElement upload = driver.findElement(By.id("uploadFile"));
        upload.sendKeys(file);


        // Download
        WebElement downloadButton = driver.findElement(By.id("downloadButton"));
        downloadButton.click();
        Thread.sleep(2000);

        String downloadPath = "/Users/farid/Downloads";
        String filePath = "sampleFile.jpeg";
        boolean isFileDownloaded = isFileDownload(downloadPath, filePath);
        System.out.println(isFileDownloaded);
    }
    public static boolean isFileDownload (String downloadPath, String fileName ){
        File file = new File(downloadPath);
        File[] files = file.listFiles();

        for (int i = 0; i < files.length; i++) {
            if (files[i].getName().equals(fileName) ){
                files[i].delete();
                return true;
            }
        }
        return false;
    }
}
