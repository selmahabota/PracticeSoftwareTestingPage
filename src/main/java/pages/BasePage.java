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

public class BasePage {
    private WebDriver driver;
    private WebDriverWait wait;
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
    protected String getAttributeValue(By locator)
    {
        return getElement(locator).getAttribute("value");
    }
    protected String getTextOfElement(By locator)
    {
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
    protected String age(){
        if (driver instanceof ChromeDriver){
            return "12121999";
        } else if (driver instanceof FirefoxDriver) {
            return "12/" + "12/" + "1229";
        } else if (driver instanceof EdgeDriver) {
            return "1212" + Keys.ARROW_RIGHT + "1929";
        }
        return null;
    }

}
