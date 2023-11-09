package tests;

import listeners.TestListener;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.LoginPage;

@Listeners(TestListener.class)
public class LoginTest extends BaseTest {

    LoginPage loginPage;

    @BeforeMethod
    public void setUpRegister() {

        loginPage = new LoginPage(driver);
    }

    @Test(description = "Login user happy path; Expected result: User is successfully logged")
    public void logInTest() {

        loginPage.goToLoginPage()
                .loginPage("customer@practicesoftwaretesting.com", "welcome01");

        Assert.assertTrue(loginPage.isUserLoged(), "User is not logged!");
    }

    @Test(description = "Login user negative test case; password is missing Expected result: Password is required!")
    public void registerNegativeTest() {
        loginPage.goToLoginPage();
        loginPage.loginPage("customer@practicesoftwaretesting.com", "");
        Assert.assertTrue(loginPage.isUserRegistrationFailedPassword());
    }

    @Test(description = "Login user negative test case; email is missing Expected result: E-mail is required!")
    public void registerNegativeTest1() {
        loginPage.goToLoginPage();
        loginPage.loginPage("", "welcome01");
        Assert.assertTrue(loginPage.isUserRegistrationFailedEmail());
    }

    @Test(description = "Login user negative test case; email and password are missing Expected result: Email and password are required!")
    public void registerNegativeTest2() {
        loginPage.goToLoginPage();
        loginPage.loginPage("", "");
        Assert.assertTrue(loginPage.isUserRegistrationFailedEmailPasswordMissing());
    }

    @Test(description = "Login user negative test case; email and password are invalid Expected result: Email and password are invalid!")
    public void registerNegativeTest3() {
        loginPage.goToLoginPage();
        loginPage.loginPage("123", "welcome01");
        Assert.assertTrue(loginPage.isUserRegistrationFailedEmailInvalid());
    }

    @Test(description = "Login user negative test case; email is invalid and password is missing Expected result: Email is invalid! Password is required!")
    public void registerNegativeTest4() {
        loginPage.goToLoginPage();
        loginPage.loginPage("123", "");
        Assert.assertTrue(loginPage.isUserRegistrationFailedEmailInvalidPasswordMissing());
    }

    @Test(description = "Login user negative test case; password is invalid Expected result: Invalid email or password!")
    public void registerNegativeTest5() {
        loginPage.goToLoginPage();
        loginPage.loginPage("customer@practicesoftwaretesting.com", "123");
        Assert.assertTrue(loginPage.isUserRegistrationFailedPasswordInvalid());
    }

}
