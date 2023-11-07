package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterPage extends BasePage {
    public RegisterPage(WebDriver driver) {

        super(driver);
    }

    private By signInLocator = By.xpath("//a[contains(text(), 'Sign in')]");
    private By registerLocator = By.xpath("//a[contains(text(), 'Register your account')]");
    private By firstNameLocator = By.id("first_name");
    private By lastNameLocator = By.id("last_name");
    private By ageLocator = By.cssSelector("input[formcontrolname='dob']");
    private By addressLocator = By.id("address");
    private By postCodeLocator = By.id("postcode");
    private By cityLocator = By.id("city");
    private By stateLocator = By.id("state");
    private By countryLocator = By.id("country");
    private By phoneLocator = By.id("phone");
    private By emailLocator = By.id("email");
    private By passwordLocator = By.id("password");
    private By registerButton = By.xpath("//button[text()='Register']");
    private By emailSignInLocator = By.id("email");
    private By passwordSignInLocator = By.id("password");
    private By loginButton = By.xpath("//input[@value='Login']");
    private By userMenuLocator = By.id("user-menu");
    private By textOnFormLocator = By.xpath("//div [@class='container']//h1");

    private String email;
    private String password;
    private String ime;
    private String prezime;

    public RegisterPage goToRegisterPage() {
        clickOnElement(signInLocator);
        clickOnElement(registerLocator);
        return this;
    }

    public RegisterPage registerPage() {
        email = faker.internet().emailAddress();
        password = faker.internet().password();
        ime = faker.name().firstName();
        prezime = faker.name().lastName();
        typeIn(firstNameLocator, ime);
        typeIn(lastNameLocator, prezime);
        typeIn(ageLocator, age());
        typeIn(addressLocator, faker.address().fullAddress());
        typeIn(postCodeLocator, faker.address().zipCode());
        typeIn(cityLocator, faker.address().city());
        typeIn(stateLocator, faker.address().state());
        selectCountry();
        typeIn(phoneLocator, faker.number().digits(8));
        typeIn(emailLocator, email);
        String emailAddress = email;
        typeIn(passwordLocator, password);
        String passwordSignIn = getAttributeValue(passwordLocator);
        clickOnElement(registerButton);
        hover(emailSignInLocator, 2000);
        typeIn(emailSignInLocator, emailAddress);
        typeIn(passwordSignInLocator, passwordSignIn);
        clickOnElement(loginButton);
        return this;
    }

    private void selectCountry() {
        Select dropDownMenuCountry = new Select(getElement(countryLocator));
        dropDownMenuCountry.selectByVisibleText("Bosnia and Herzegovina");
    }

    public String getActualName() {
        return getTextOfElement(userMenuLocator);
    }

    public String getExpectedName() {
        return ime + " " + prezime;
    }

    public String getTextOnForm() {
        return getTextOfElement(textOnFormLocator);
    }
}
