package SeleniumWithRahulShetty;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class AddItemsToCart {
    static WebDriver driver;
    static String url = "https://rahulshettyacademy.com/seleniumPractise/#/";
    public static void main(String[] args) throws InterruptedException, IOException {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


        String[] products = {"Cauliflower", "Beetroot", "Brinjal", "Potato", "Corn"};
        addItemsCart(driver, products);
    }
    public static void addItemsCart (WebDriver driver, String[] products) throws InterruptedException, IOException {
        driver.get(url);
        List<String> addItemsProduct = Arrays.asList(products);
        int j = 0;

        List<WebElement> productsName = driver.findElements(By.cssSelector("div h4[class='product-name']"));
        for (int i = 0; i < productsName.size(); i++) {
            String name = productsName.get(i).getText().split("-")[0].trim();
            if (addItemsProduct.contains(name)){
                driver.findElements(By.cssSelector(".product-action button")).get(i).click();
                j++;
            }
            if (j == productsName.size()) {
                break;
            }
        }

        WebElement clickToCart = driver.findElement(By.xpath("//img[@alt='Cart']"));
        clickToCart.click();

        WebElement proceedButton = driver.findElement(By.xpath("//button[.='PROCEED TO CHECKOUT']"));
        proceedButton.click();

        WebElement promoCode = driver.findElement(By.className("promoCode"));
        promoCode.sendKeys("rahulshettyacademy");

        WebElement promoBtn = driver.findElement(By.className("promoBtn"));
        promoBtn.click();

        WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".promoInfo")));

        WebElement promoInfo = driver.findElement(By.cssSelector(".promoInfo"));
        System.out.println(promoInfo.getText());

        WebElement placeOrder = driver.findElement(By.xpath("//button[.='Place Order']"));
        placeOrder.click();

        WebElement selectCountry = driver.findElement(By.cssSelector("select[style='width: 200px;']"));
        Select select = new Select(selectCountry);
        select.selectByValue("Azerbaijan");

        WebElement chkAgree = driver.findElement(By.className("chkAgree"));
        chkAgree.click();

        WebElement proceed = driver.findElement(By.xpath("//button[.='Proceed']"));
        proceed.click();

        TakesScreenshot screenshot = (TakesScreenshot) driver;
        String output = System.getProperty("user.dir") + "/ScreenShot/success.png";
        File pagetScreenShot = new File(output);
        File muveqqetiSekil = screenshot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(muveqqetiSekil, pagetScreenShot);

        Thread.sleep(5000);
        driver.quit();
    }
}
