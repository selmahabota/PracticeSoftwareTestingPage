package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {

        super(driver);
    }

    private By signInLocator = By.xpath("//a[contains(text(), 'Sign in')]");
    private By emailLocator = By.id("email");
    private By passwordLocator = By.id("password");
    private By loginButton = By.xpath("//input[@value='Login']");
    private By userMenuLocator = By.id("user-menu");
    private By textOnFormLocator = By.xpath("//div [@class='container']//h1");
    private By headingTextLocator = By.xpath("//div [@class='container']//p");

    public LoginPage goToLoginPage() {
        clickOnElement(signInLocator);
        return this;
    }

    public LoginPage loginPage() {
        typeIn(emailLocator, "customer@practicesoftwaretesting.com");
        typeIn(passwordLocator, "welcome01");
        clickOnElement(loginButton);
        return this;
    }

    public String getName() {
        return getElement(userMenuLocator).getText();
    }

    public String getTextOnForm() {
        return getTextOfElement(textOnFormLocator);
    }

    public String getHeadingText() {
        return getTextOfElement(headingTextLocator);
    }
}
