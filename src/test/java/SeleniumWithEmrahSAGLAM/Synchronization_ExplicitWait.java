package SeleniumWithEmrahSAGLAM;

public class Synchronization_ExplicitWait {

    /*
    * Beklenen bir durum(expected condition) olduğunda veya "ElementNotVisibleException" exception'i atmadan
     once belirlenen max sureyi beklemesini soylemek icin explicit wait kullanılır.

     * Syntax:

       =>  new WebDriverWait(driver, Duration.ofSeconds(30)).
                                until(ExpectedConditions.elementToBeClickable(By.xpath("//a/h3")));

       =>  WebDriverWait wait = new WebDriverWait(driver,Duration.ofSecond(30));

           wait.until(ExpectedConditions.typeofExpectedCondition(By.locator(“valueoflocator”));

       Syntaxı bir örnek ile açıklayacak olursak;

       wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(“abc”));

     * Expected Condition Cesitleri
        alertIsPresent()
        elementSelectionStateToBe()
        elementToBeClickable()
        elementToBeSelected()
        frameToBeAvaliableAndSwitchToIt()
        invisibilityOfTheElementLocated()
        invisibilityOfElementWithText()
        presenceOfAllElementsLocatedBy()
        presenceOfElementLocated()
        textToBePresentInElement()
        textToBePresentInElementLocated()
        textToBePresentInElementValue()
        titleIs()
        titleContains()
        visibilityOf()
        visibilityOfAllElements()
        visibilityOfAllElementsLocatedBy()
        visibilityOfElementLocated()
     */
}
