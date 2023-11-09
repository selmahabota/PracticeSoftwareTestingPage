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

    private By emailMessage = By.xpath("//div[@data-test='email-error']/div");
    private By passwordMessage = By.xpath("//div[@data-test='password-error']/div");
    private By emailPasswordMessage = By.xpath("//div[@data-test='login-error']/div");

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

    public boolean isUserLoged() {
        return !matchesExpectedText(userMenuLocator, "Sign in")
                && matchesExpectedText(textOnFormLocator, "My account")
                && matchesExpectedText(headingTextLocator, "Here you can manage your profile, favorites and orders.");
    }

    public boolean isUserRegistrationFailedPassword() {
        return matchesExpectedText(passwordMessage, "Password is required.");
    }

    public boolean isUserRegistrationFailedEmail() {
        return matchesExpectedText(emailMessage, "E-mail is required.");
    }

    public boolean isUserRegistrationFailedEmailPasswordMissing() {
        return matchesExpectedText(emailMessage, "E-mail is required.")
                && matchesExpectedText(passwordMessage, "Password is required.");
    }

    public boolean isUserRegistrationFailedEmailInvalid() {
        return matchesExpectedText(emailMessage, "E-mail format is invalid.");
    }

    public boolean isUserRegistrationFailedEmailInvalidPasswordMissing() {
        return matchesExpectedText(emailMessage, "E-mail format is invalid.")
                && matchesExpectedText(passwordMessage, "Password is required.");
    }

    public boolean isUserRegistrationFailedPasswordInvalid() {
        return matchesExpectedText(emailPasswordMessage, "Invalid email or password");
    }
}
