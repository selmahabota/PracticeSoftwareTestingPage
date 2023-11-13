package tests;

import core.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    protected WebDriver driver;

    @BeforeMethod
    public void setUpDriver() {
        driver = DriverManager.setDriver();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException();
        }
        driver.get("https://practicesoftwaretesting.com/#/");
    }

    public WebDriver getDriver() {
        return driver;
    }
   /* @AfterMethod
    public void tearDown(){
        driver.quit();
    }*/
}
