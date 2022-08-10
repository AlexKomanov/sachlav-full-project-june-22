package tests.sanityTests;


import helpers.Credentials;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductsPage;
import tests.BaseTest;

public class BuyProductsTest extends BaseTest {

    @Test(testName = "Buy products sanity test")
    public void sanity_test_01() {

        LoginPage loginPage = new LoginPage(driver);
        ProductsPage productsPage = new ProductsPage(driver);

        loginPage.loginToApp(Credentials.STANDARD_USER, Credentials.SECRET_SAUCE_PASSWORD);

        String productsPageTitle = productsPage.getTitle();
        Assert.assertEquals(productsPageTitle, "PRODUCTS");


        productsPage.chooseProductFromList("Sauce Labs Backpack");
        productsPage.chooseProductFromList("Sauce Labs Fleece Jacket");

        productsPage.sleep(2000);
    }
}
