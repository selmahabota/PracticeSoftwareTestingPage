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

    private By errorMessage = By.cssSelector(".alert");

    public LoginPage goToLoginPage() {
        clickOnElement(signInLocator);
        return this;
    }

    public LoginPage loginPage(String username, String password) {
        typeIn(emailLocator, username);
        typeIn(passwordLocator, password);
        clickOnElement(loginButton);
        return this;
    }

    public boolean isErrorMessagePresent() {
        return getElement(errorMessage).isDisplayed();
    }
}
