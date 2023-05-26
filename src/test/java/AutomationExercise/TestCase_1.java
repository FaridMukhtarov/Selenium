package AutomationExercise;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;
public class TestCase_1 {

    static WebDriver driver;
    static String url = "http://automationexercise.com";
    public static void main(String[] args) throws InterruptedException {

        // Register User

        // 1. Launch browser
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // 2. Navigate to url 'http://automationexercise.com'
        driver.get(url);

        // 3. Verify that home page is visible successfully
        String image = "//img[@src='/static/images/home/logo.png']";
        WebElement homePage = driver.findElement(By.xpath(image));

        if (homePage.isDisplayed()){
            System.out.println("Test Passed");
        }else
            System.out.println("Test failed");

        // 4. Click on 'Signup / Login' button
        WebElement signupButton = driver.findElement(By.xpath("//a[text()=' Signup / Login']"));
        signupButton.click();

        // 5. Verify 'New User Signup!' is visible
        WebElement newUserVisible = driver.findElement(By.xpath("//h2[text()='New User Signup!']"));
        String ifVisible = newUserVisible.isDisplayed() ? newUserVisible.getText() : "Is not Visible";
        System.out.println(ifVisible);

        // 6. Enter name and email address
        WebElement newUserName = driver.findElement(By.xpath("//input[@placeholder='Name']"));
        newUserName.sendKeys("fuad");
        WebElement newUserEmail = driver.findElement(By.xpath("//input[@data-qa='signup-email']"));
        newUserEmail.click();
        newUserEmail.sendKeys("sssgrbd@gmail.com");

        // 7. Click 'Signup' button
        WebElement clickButton = driver.findElement(By.xpath("//button[@data-qa='signup-button']"));
        clickButton.click();

        // 8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
        WebElement enterAccountVisible = driver.findElement(By.xpath("//b[.='Enter Account Information']"));
        if (enterAccountVisible.isDisplayed()){
            System.out.println(enterAccountVisible.getText());
        }else
            System.out.println("Test Failed");

        // 9. Fill details: Title, Name, Email, Password, Date of birth
        WebElement genderSelect = driver.findElement(By.id("id_gender1"));

        Actions action = new Actions(driver);
        action.click(genderSelect)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys("Ferid12345")
                .sendKeys(Keys.TAB).perform();

        List<WebElement> days = driver.findElements(By.xpath("//select[@id='days'] / option"));
        for (WebElement day : days) {
            if (day.getText().equals("6")){
                day.click();
            }
        }
        List<WebElement> months = driver.findElements(By.xpath("//select[@id='months'] / option"));
        for (WebElement month : months) {
            if (month.getText().equals("June")){
                month.click();
            }
        }
        List<WebElement> years = driver.findElements(By.xpath("//select[@id='years'] / option"));
        for (WebElement year : years) {
            if (year.getText().equals("1995")){
                year.click();
            }
        }

        // 10. Select checkbox 'Sign up for our newsletter!'
        WebElement newsletterCheckBox = driver.findElement(By.id("newsletter"));
        newsletterCheckBox.click();

        // 11. Select checkbox 'Receive special offers from our partners!'
        WebElement optinCheckBox = driver.findElement(By.id("optin"));
        action.click(optinCheckBox)

        // 12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
                .sendKeys(Keys.TAB)
                .sendKeys("Farid")
                .sendKeys(Keys.TAB)
                .sendKeys("Muxtarov")
                .sendKeys(Keys.TAB)
                .sendKeys("motiv")
                .sendKeys(Keys.TAB)
                .sendKeys("BulBul 41")
                .sendKeys(Keys.TAB)
                .sendKeys("Baki")
                .sendKeys(Keys.TAB).perform();

        WebElement country = driver.findElement(By.id("country"));
        Select select = new Select(country);
        select.selectByVisibleText("United States");

        Actions actions = new Actions(driver);
        WebElement state = driver.findElement(By.id("state"));
        actions.sendKeys(Keys.TAB)
                .sendKeys("Florida")
                .sendKeys(Keys.TAB)
                .sendKeys("Orlando")
                .sendKeys(Keys.TAB)
                .sendKeys("3482")
                .sendKeys(Keys.TAB)
                .sendKeys("67826329")
                .sendKeys(Keys.TAB).perform();

        // 13. Click 'Create Account button'
        WebElement btnClick = driver.findElement(By.xpath("//button[@data-qa='create-account']"));
        btnClick.click();

        // 14. Verify that 'ACCOUNT CREATED!' is visible
        Thread.sleep(2000);
        WebElement accountCreateVisible = driver.findElement(By.xpath("//b[.='Account Created!']"));
        String visible = accountCreateVisible.isDisplayed() ? "ACCOUNT CREATED! is Visible" : "ACCOUNT CREATED! Is Not Visible";

        // 15. Click 'Continue' button
        driver.findElement(By.xpath("//a[.='Continue']")).click();


        // 16. Verify that 'Logged in as username' is visible
        WebElement logged = driver.findElement(By.xpath("//ul/li[10]/a"));
        if (logged.isDisplayed()){
            System.out.println("Logged: " + logged.getText());
        }else
            System.out.println("Test Failed");

        // 17. Click 'Delete Account' button
        driver.findElement(By.xpath("//a[.=' Delete Account']")).click();

        // 18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
        WebElement accountDeletedVisible = driver.findElement(By.xpath("//b[.='Account Deleted!']"));
        if (accountDeletedVisible.isDisplayed()){
            System.out.println(accountDeletedVisible.getText());
        }else
            System.out.println("Test Failed");

        driver.findElement(By.xpath("//a[.='Continue']")).click();

        Thread.sleep(3000);
        //driver.quit();
    }
}
