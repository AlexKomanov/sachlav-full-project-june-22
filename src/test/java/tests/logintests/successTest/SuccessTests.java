package tests.logintests.successTest;

import helpers.Credentials;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductsPage;
import tests.BaseTest;

public class SuccessTests extends BaseTest {

    @Test
    public void successTest_01() {
        LoginPage loginPage = new LoginPage(driver);
        ProductsPage productsPage = new ProductsPage(driver);

        loginPage.loginToApp(Credentials.STANDARD_USER, Credentials.SECRET_SAUCE_PASSWORD);

        String productsPageTitle = productsPage.getTitle();
        Assert.assertEquals(productsPageTitle, "PRODUCTS");
    }

    @Test
    public void successTest_02() {
        LoginPage loginPage = new LoginPage(driver);
        ProductsPage productsPage = new ProductsPage(driver);

        loginPage.loginToApp(Credentials.PERFORMANCE_GLITCH_USER, Credentials.SECRET_SAUCE_PASSWORD);

        String productsPageTitle = productsPage.getTitle();
        Assert.assertEquals(productsPageTitle, "PRODUCTS");
    }
}
