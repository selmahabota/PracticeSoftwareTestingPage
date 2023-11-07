import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.RegisterPage;

import java.time.Duration;

public class LoginTest extends BaseTest {

    LoginPage loginPage;

    @BeforeMethod
    public void setUpRegister() {

        loginPage = new LoginPage(driver);
    }

    @Test
    public void logInTest() {

        loginPage.goToLoginPage()
                .loginPage();

        String actualName = loginPage.getName();
        String exptectedName = "Sign in";
        Assert.assertNotEquals(actualName, exptectedName, "Names are matched!");

        String expectedText = "My account";
        String actualText = loginPage.getTextOnForm();
        Assert.assertEquals(actualText, expectedText, "Text not matched!");

        String actualHeadingText = loginPage.getHeadingText();
        String expectedHeadingText = "Here you can manage your profile, favorites and orders.";
        Assert.assertEquals(actualHeadingText, expectedHeadingText, "Text not matched!");
    }
}
