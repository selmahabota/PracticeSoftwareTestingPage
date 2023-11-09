package tests;

import listeners.TestListener;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.RegisterPage;

@Listeners(TestListener.class)
public class RegisterTest extends BaseTest {

    RegisterPage registerPage;
    LoginPage loginPage;

    @BeforeMethod
    public void setUpRegister() {

        registerPage = new RegisterPage(driver);
        loginPage = new LoginPage(driver);
    }

    @Test(description = "Register user happy path; Expected result: User is successfully registered")
    public void registerTest() {
        registerPage.goToRegisterPage()
                .registerPage();
        loginPage.loginPage(registerPage.getEmail(), registerPage.getPassword());
        Assert.assertTrue(registerPage.isUserRegistered(), "User is not registered!");
    }

}

