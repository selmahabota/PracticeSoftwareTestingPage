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
        String actualName = registerPage.getActualName();
        String expectedName= registerPage.getExpectedName();
        Assert.assertEquals(actualName,expectedName,"Text not matched!");

        String expectedText = "My account";
        String actualText = registerPage.getTextOnForm();
        Assert.assertEquals(actualText, expectedText, "Text not matched!");
    }
}

