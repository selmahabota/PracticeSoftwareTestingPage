package tests;

import listeners.TestListener;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.CartPage;

@Listeners(TestListener.class)
public class CartTest extends BaseTest {

    CartPage cartPage;

    @BeforeMethod
    public void setUpCart() {

        cartPage = new CartPage(driver);
    }

    @Test
    public void cartTest() {
        cartPage.cartPage();
        Assert.assertTrue(cartPage.isCartWorking(), "Cart is not working!");
    }
}
