package pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Locale;
import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BasePage {
    protected WebDriver driver;
    private WebDriverWait wait;
    private static final Logger log = LogManager.getLogger(BasePage.class.getName());

    Faker faker;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        faker = new Faker(new Locale("en-us"));
    }

    protected WebElement getElement(By locator) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    protected void typeIn(By locator, String text) {
        WebElement element = getElement(locator);
        element.clear();
        element.sendKeys(text);
    }

    protected String getAttributeValue(By locator) {
        return getElement(locator).getAttribute("value");
    }

    protected String getTextOfElement(By locator) {

        return getElement(locator).getText();
    }


    protected void clickOnRandomElement(By locator) {
        List<WebElement> list = driver.findElements(locator);
        Random random = new Random();
        int randomElement = random.nextInt(list.size());
        list.get(randomElement).click();
    }

    protected void hover(By locator, long wait) {
        WebElement element = getElement(locator);
        new Actions(driver)
                .moveToElement(element)
                .pause(wait)
                .build()
                .perform();
    }

    protected void hoverAndClick(By locator, long wait) {
        WebElement element = getElement(locator);
        new Actions(driver)
                .moveToElement(element)
                .pause(wait)
                .click()
                .build()
                .perform();
    }

    protected void clickOnElement(By locator) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        try {
            wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
        } catch (ElementClickInterceptedException e) {
            //wait.until(ExpectedConditions.presenceOfElementLocated(locator)).click();
            js.executeScript("arguments[0].click()", getElement(locator));
        } catch (StaleElementReferenceException s) {
            s.printStackTrace();
            hoverAndClick(locator, 5000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected boolean matchesExpectedText(By locator, String expectedText) {
        if (getTextOfElement(locator).equals(expectedText)) {
            log.info("PASSED - Text found in element: " + getTextOfElement(locator) + " matches with expected text: " + expectedText);
            return true;
        } else {
            log.error("FAILED - Text found in element: " + getTextOfElement(locator) + " is not matched with expected text: " + expectedText);
        }
        return false;
    }

    protected boolean matchesExpectedTextDouble(double firstValue, double expectedValue) {
        if (firstValue == expectedValue) {
            log.info("PASSED - Value " + firstValue + " matches with expected value: " + expectedValue);
            return true;
        } else {
            log.error("FAILED - Value " + firstValue + " is not matched with expected value: " + expectedValue);
        }
        return false;
    }

    protected boolean matchesExpectedTextInteger(int firstValue, int expectedValue) {
        if (firstValue == expectedValue) {
            log.info("PASSED - Value " + firstValue + " matches with expected value: " + expectedValue);
            return true;
        } else {
            log.error("FAILED - Value " + firstValue + " is not matched with expected value: " + expectedValue);
        }
        return false;
    }

}
