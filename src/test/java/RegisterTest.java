import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegisterTest extends BaseTest {

    By signInLocator = By.xpath("//a[contains(text(), 'Sign in')]");
    By registerLocator = By.xpath("//a[contains(text(), 'Register your account')]");
    By firstNameLocator = By.id("first_name");
    By lastNameLocator = By.id("last_name");
    By ageLocator = By.id("dob");
    By addressLocator = By.id("address");
    By postCodeLocator = By.id("postcode");
    By cityLocator = By.id("city");
    By stateLocator = By.id("state");
    By countryLocator = By.id("country");
    By phoneLocator = By.id("phone");
    By emailLocator = By.id("email");
    By passwordLocator = By.id("password");
    By registerButton = By.xpath("//button[text()='Register']");
    By emailSignInLocator = By.id("email");
    By passwordSignInLocator = By.id("password");
    By loginButton = By.xpath("//input[@value='Login']");
    By userMenuLocator = By.id("user-menu");
    By textOnFormLocator = By.xpath("//div [@class='container']//h1");

    String email = System.currentTimeMillis() + "@email.com";

    @Test
    public void registerTest() throws InterruptedException {
        Thread.sleep(2000);
        clickOnElement(signInLocator);
        Thread.sleep(2000);
        clickOnElement(registerLocator);
        typeIn(firstNameLocator, "Selma");
        typeIn(lastNameLocator, "Habota");
        String exptectedName = getAttributeValue(firstNameLocator) + " " + getAttributeValue(lastNameLocator);
        datePicker(ageLocator, "12/12/2000");
        Thread.sleep(2000);
        typeIn(addressLocator, "Aleja lipa 56");
        typeIn(postCodeLocator, "71000");
        typeIn(cityLocator, "Sarajevo");
        typeIn(stateLocator, "Kanton Sarajevo");

        Select dropDownMenuCountry = new Select(getElement(countryLocator));
        dropDownMenuCountry.selectByVisibleText("Bosnia and Herzegovina");

        typeIn(phoneLocator, "062555444");
        typeIn(emailLocator, email);
        String emailAddress = email;
        typeIn(passwordLocator, "000000");
        String passwordSignIn = getAttributeValue(passwordLocator);
        clickOnElement(registerButton);
        Thread.sleep(3000);
        typeIn(emailSignInLocator, emailAddress);
        typeIn(passwordSignInLocator, passwordSignIn);
        clickOnElement(loginButton);
        Thread.sleep(5000);

        String actualName = getTextOfElement(userMenuLocator);
        Assert.assertEquals(actualName, exptectedName, "Names not matched!");

        String expectedText = "My account";
        String actualText = getTextOfElement(textOnFormLocator);
        Assert.assertEquals(actualText, expectedText, "Text not matched!");
    }
}
