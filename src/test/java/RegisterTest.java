import org.checkerframework.checker.units.qual.K;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.RegisterPage;

public class RegisterTest extends BaseTest {

    RegisterPage registerPage;
    @BeforeMethod
    public void setUpRegister(){
        registerPage=new RegisterPage(driver);
    }

    @Test
    public void registerTest (){
        registerPage.goToRegisterPage()
                .registerPage();
    }

      /*  String actualName = getTextOfElement(userMenuLocator);
        Assert.assertEquals(actualName, exptectedName, "Names not matched!");

        String expectedText = "My account";
        String actualText = getTextOfElement(textOnFormLocator);
        Assert.assertEquals(actualText, expectedText, "Text not matched!");
  */
}

