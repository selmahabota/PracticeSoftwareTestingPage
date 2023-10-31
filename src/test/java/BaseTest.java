import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    protected WebDriver driver;

    @BeforeMethod
    public void setUpDriver()
    {
        driver=new ChromeDriver();
        try {
            Thread.sleep(3000);
        }
        catch (InterruptedException e)
        {
            throw new RuntimeException();
        }
        driver.manage().window().maximize();
        driver.get("https://practicesoftwaretesting.com/#/");
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    protected WebElement getElement(By locator)
    {
        return driver.findElement(locator);
    }

    protected void typeIn(By locator, String text) {
        getElement(locator).sendKeys(text);
    }

    protected void clickOnElement(By locator)
    {
        driver.findElement(locator).click();
    }

    protected void datePicker(By locator, String date)
    {
        getElement(locator).clear();
        typeIn(locator,date);
    }
    protected String getAttributeValue(By locator)
    {
        return getElement(locator).getAttribute("value");
    }
    protected String getTextOfElement(By locator)
    {
        return getElement(locator).getText();
    }
}
