package tests;

import dataProviders.DataProviders;
import listeners.TestListener;
import model.LoginUser;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.RegisterPage;
import utils.Utils;

import java.util.List;

@Listeners(TestListener.class)
public class LoginTest extends BaseTest {

    LoginPage loginPage;
    RegisterPage registerPage;

    @BeforeMethod
    public void setUpRegister() {

        loginPage = new LoginPage(driver);
    }

    @Test(description = "Login user happy path; Expected result: User is successfully logged")
    public void logInTest() {

        loginPage.goToLoginPage()
                .loginPage("customer@practicesoftwaretesting.com", "welcome01");

        Assert.assertTrue(registerPage.isUserRegisteredAndLoggedIn(), "User is not logged!");
    }

    @Test(description = "Negative test cases using dataProvider", dataProvider = "loginDataProvider", dataProviderClass = DataProviders.class)
    public void invalidLoginTest(String username, String password) {
        loginPage.goToLoginPage()
                .loginPage(username, password);
        Assert.assertTrue(loginPage.isErrorMessagePresent());
    }

    @Test(description = "Negative test cases using json")
    public void invalidLoginTestFromJson() {
        List<LoginUser> list = Utils.getDataFromJson();
        for (int i = 0; i < list.size(); i++) {
            loginPage.goToLoginPage()
                    .loginPage(list.get(i).getUsername(), list.get(i).getPassword());
        }
        Assert.assertTrue(loginPage.isErrorMessagePresent());
    }

    @Test
    public void lombokTest() {
        LoginUser loginUserModel = LoginUser.builder()
                .password("")
                .username("")
                .build();
        System.out.println(loginUserModel);
    }


}
