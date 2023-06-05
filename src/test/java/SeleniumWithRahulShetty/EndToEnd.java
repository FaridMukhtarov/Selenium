package SeleniumWithRahulShetty;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import java.time.Duration;
import java.util.List;

public class EndToEnd {
    static WebDriver driver;
    static String url = "https://rahulshettyacademy.com/dropdownsPractise/";
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(url);

        WebElement autosuggest = driver.findElement(By.id("autosuggest"));
        autosuggest.sendKeys("us");

        List<WebElement> options = driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));
        for (WebElement option : options) {
            if (option.getText().equals("Cyprus")){
                System.out.println(option.getText());
                option.click();
                break;
            }
        }

        WebElement from = driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXTaction"));
        from.click();

        WebElement departureCity = driver.findElement(By.xpath("//a[@text='Jaipur (JAI)']"));
        departureCity.click();

        WebElement arrivalCity = driver.findElement(By.xpath("(//a[@text='Hyderabad (HYD)'])[2]"));
        arrivalCity.click();

        WebElement calendar = driver.findElement(By.id("ctl00_mainContent_view_date1"));
        calendar.click();

        List<WebElement> days = driver.findElements(By.cssSelector(".ui-state-default"));
        for ( WebElement day : days) {
            if (day.getText().equals("20")){
                System.out.println("You have chosen the " + day.getText() + "th of the month");
                day.click();
                break;
            }
        }

        WebElement divpaxinfo = driver.findElement(By.id("divpaxinfo"));
        System.out.println("Before Info: " + divpaxinfo.getText());
        divpaxinfo.click();

        WebElement hrefIncAdt = driver.findElement(By.id("hrefIncAdt"));
        for (int i = 0; i <= 4; i++) {
            hrefIncAdt.click();
        }
        WebElement hrefIncChd = driver.findElement(By.id("hrefIncChd"));
        for (int i = 0; i < 2; i++) {
            hrefIncChd.click();
        }
        WebElement hrefIncInf = driver.findElement(By.id("hrefIncInf"));
        for (int i = 0; i < 1; i++) {
            hrefIncInf.click();
        }

        WebElement done = driver.findElement(By.id("btnclosepaxoption"));
        done.click();

        System.out.println("After Info: " + divpaxinfo.getText());

        WebElement dropDown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
        dropDown.click();

        Select select = new Select(dropDown);
        select.selectByVisibleText("USD");
        System.out.println(select.getFirstSelectedOption().getText());


        WebElement student = driver.findElement(By.id("ctl00_mainContent_chk_StudentDiscount"));
        student.click();

        WebElement findFlightsButton = driver.findElement(By.cssSelector("input[name='ctl00$mainContent$btn_FindFlights']"));
        findFlightsButton.click();

        Thread.sleep(5000);
        driver.quit();
    }
}
