package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.json.JsonOutput;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.Driver;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class CartPage extends BasePage {
    private WebDriverWait wait;

    public CartPage(WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    private By firstTool = By.xpath("//div[@class='col-md-9']/div/a[1]");
    private By secondTool = By.xpath("//div[@class='col-md-9']/div/a[2]");
    private By firstAddToCart = By.id("btn-add-to-cart");
    private By secondAddToCart = By.id("btn-add-to-cart");
    private By cart = By.xpath("//a[@routerlink='/checkout']");
    private By homePage = By.xpath("//a[text()='Home']");
    private By firstQuantity = By.xpath("//table[@class='table table-hover']//tbody//tr[1]/td[3]/input");
    private By firstPrice = By.xpath("//table[@class='table table-hover']//tr[1]/td[4]/span");
    private By secondQuantity = By.xpath("//table[@class='table table-hover']//tbody//tr[2]/td[3]/input");
    private By secondPrice = By.xpath("//table[@class='table table-hover']//tr[2]/td[4]/span");
    private By firstTotalPrice = By.xpath("//table[@class='table table-hover']//tr[1]/td[5]/span");
    private By secondTotalPrice = By.xpath("//table[@class='table table-hover']//tr[2]/td[5]/span");
    private By totalPrice = By.xpath("//table[@class='table table-hover']//tfoot/tr/td[5]");
    private By totalPrices = By.xpath("//table[@class='table table-hover']//tbody//td[5]/span");

    public CartPage cartPage() throws InterruptedException {
        clickOnElement(firstTool);
        clickOnElement(firstAddToCart);
        clickOnElement(homePage);
        clickOnElement(secondTool);
        clickOnElement(secondAddToCart);
        Thread.sleep(5000);
        clickOnElement(cart);
        driver.navigate().refresh();


        return this;
    }

    public double removeText(By locator) {
        String cijena = getTextOfElement(locator);
        String cijena1 = cijena.replace("$", "");
        double cijenaDouble = Double.parseDouble(cijena1);
        return cijenaDouble;
    }

    public double removeTextFromString(String cijena) {
        String cijena1 = cijena.replace("$", "");
        double cijenaDouble = Double.parseDouble(cijena1);
        return cijenaDouble;
    }

    public double getFirstPrice() {

        int kolicina = Integer.parseInt(getAttributeValue(firstQuantity));
        double cijenaDouble = removeText(firstPrice);
        System.out.println(kolicina * cijenaDouble);
        return kolicina * cijenaDouble;
    }

    public double getSecondPrice() {
        int kolicina = Integer.parseInt(getAttributeValue(secondQuantity));
        double cijenaDouble = removeText(secondPrice);
        System.out.println(kolicina * cijenaDouble);
        return kolicina * cijenaDouble;
    }

    public double getFirstTotalPrice() {

        return removeText(firstTotalPrice);
    }

    public double getSecondTotalPrice() {

        return removeText(secondTotalPrice);
    }

    public double getTotalPrice() {

        return removeText(totalPrice);
    }

    public int getTotalQuantity() {
        return (Integer.parseInt(getAttributeValue(firstQuantity)) + Integer.parseInt(getAttributeValue(secondQuantity)));
    }

    public int getQuantityNumberFromCart() {

        return Integer.parseInt(getElement(cart).getText());
    }

    public double getSumOfPrices() {
        wait.until(ExpectedConditions.presenceOfElementLocated(totalPrices));
        double sum = 0;
        List<WebElement> list = driver.findElements(totalPrices);
        for (WebElement prices : list) {
            sum += removeTextFromString(prices.getText());
        }
        return sum;
    }
}
