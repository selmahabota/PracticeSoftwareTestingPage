import core.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    protected WebDriver driver;

    @BeforeMethod
    public void setUpDriver() {
        driver = DriverManager.setDriver("chrome");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException();
        }
        driver.get("https://practicesoftwaretesting.com/#/");
    }

   /* @AfterMethod
    public void tearDown(){
        driver.quit();
    }*/
}
