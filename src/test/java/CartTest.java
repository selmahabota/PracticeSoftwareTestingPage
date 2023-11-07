import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CartPage;

public class CartTest extends BaseTest {

    CartPage cartPage;

    @BeforeMethod
    public void setUpCart() {

        cartPage = new CartPage(driver);
    }

    @Test
    public void cartTest() throws InterruptedException {
        cartPage.cartPage();
        double actualTotalFirstPrice = cartPage.getFirstPrice();
        double expectedTotalFirstPrice = cartPage.getFirstTotalPrice();
        Assert.assertEquals(actualTotalFirstPrice, expectedTotalFirstPrice, "Price not matched!");

        double actualTotalSecondPrice = cartPage.getSecondPrice();
        double expectedTotalSecondPrice = cartPage.getSecondTotalPrice();
        Assert.assertEquals(actualTotalSecondPrice, expectedTotalSecondPrice, "Price not matched!");

        double actualTotal = cartPage.getSumOfPrices();
        double expectedTotal = cartPage.getTotalPrice();
        Assert.assertEquals(actualTotal, expectedTotal, "Price not matched!");

        int actualTotalQuantity = cartPage.getTotalQuantity();
        int expectedTotalQuantity = cartPage.getQuantityNumberFromCart();
        Assert.assertEquals(actualTotalQuantity, expectedTotalQuantity);
    }


}
