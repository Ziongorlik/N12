package pages;

import org.openqa.selenium.*;
import utils.DriverSingleton;

import java.util.List;

public class BasePage {
    static WebDriver driver;

    public BasePage(){
        driver = DriverSingleton.getDriveInstance();
    }

    private static WebElement getWebElement(By locator) throws NoSuchElementException {
        return driver.findElement(locator);
    }

    public void clickElement(By locator){
        getWebElement(locator).click();
    }

    public String getElementAttribute(By locator, String attribute){
        return getWebElement(locator).getAttribute(attribute);
    }

    public static void scrollToElement(By locator) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", getWebElement(locator));
    }

    public boolean isElementVisible(By locator){
        return getWebElement(locator).isDisplayed();
    }

    public String getCurrentURL(){
        return driver.getCurrentUrl();
    }

    public List<WebElement> getElementChildren(By locator, String cssSelector){
        WebElement listElement = getWebElement(locator);
        listElement.click();
        return listElement.findElements(By.cssSelector(cssSelector));
    }
}
