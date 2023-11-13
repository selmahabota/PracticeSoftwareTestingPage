package dataProviders;

import org.testng.annotations.DataProvider;

public class DataProviders {

    @DataProvider(name = "loginDataProvider")
    public Object[][] loginDataProvider() {
        return new Object[][]{
                {"username1", ""},
                {"", "password"},
                {"username", "password"},
                {"", ""},
                {"customer@practicesoftwaretesting.com", ""},
                {"customer@practicesoftwaretesting.com", "123"}
        };
    }
}
