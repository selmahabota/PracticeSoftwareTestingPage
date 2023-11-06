import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    /*By signInLocator = By.xpath("//a[contains(text(), 'Sign in')]");
    By emailLocator = By.id("email");
    By passwordLocator = By.id("password");
    By loginButton = By.xpath("//input[@value='Login']");
    By userMenuLocator = By.id("user-menu");
    By textOnFormLocator = By.xpath("//div [@class='container']//h1");
    By headingTextLocator = By.xpath("//div [@class='container']//p");

    @Test
    public void logInTest() throws InterruptedException {
        Thread.sleep(2000);
        clickOnElement(signInLocator);
        Thread.sleep(2000);
        typeIn(emailLocator, "selma.habota1@email.com");
        typeIn(passwordLocator, "111111");
        clickOnElement(loginButton);
        Thread.sleep(5000);

        String actualName = getElement(userMenuLocator).getText();
        String exptectedName = "Sign in";
        Assert.assertNotEquals(actualName, exptectedName, "Names are matched!");

        String expectedText = "My account";
        String actualText = getTextOfElement(textOnFormLocator);
        Assert.assertEquals(actualText, expectedText, "Text not matched!");

        String actualHeadingText = getTextOfElement(headingTextLocator);
        String expectedHeadingText = "Here you can manage your profile, favorites and orders.";
        Assert.assertEquals(actualHeadingText, expectedHeadingText, "Text not matched!");

    }*/
}
