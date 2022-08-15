package tests.sanityTests;


import helpers.Credentials;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CheckoutYourInformationPage;
import pages.LoginPage;
import pages.ProductsPage;
import pages.YourCartPage;
import tests.BaseTest;

public class BuyProductsTest extends BaseTest {

    String firstName = "Alex";

    @Test(testName = "Buy products sanity test")
    public void sanity_test_01() {

        LoginPage loginPage = new LoginPage(driver);
        ProductsPage productsPage = new ProductsPage(driver);
        YourCartPage yourCartPage = new YourCartPage(driver);
        CheckoutYourInformationPage checkoutYourInformationPage = new CheckoutYourInformationPage(driver);

        loginPage.loginToApp(Credentials.STANDARD_USER, Credentials.SECRET_SAUCE_PASSWORD);

        String productsPageTitle = productsPage.getTitle();
        Assert.assertEquals(productsPageTitle, "PRODUCTS");


        productsPage.chooseProductFromList("Sauce Labs Backpack");
        Assert.assertEquals(productsPage.getItemsCounter(), 1);
        productsPage.chooseProductFromList("Sauce Labs Fleece Jacket");
        Assert.assertEquals(productsPage.getItemsCounter(), 2);
        productsPage.continueToCheckout();

        Assert.assertEquals(yourCartPage.getTitle(), "YOUR CART");
        yourCartPage.goToCheckout();

        Assert.assertEquals(checkoutYourInformationPage.getTitle(), "CHECKOUT: YOUR INFORMATION");
        checkoutYourInformationPage.fillCheckoutForm(firstName, "Komanov", "20100");
        checkoutYourInformationPage.continueWithCheckout();

        productsPage.sleep(2000);

    }
}
