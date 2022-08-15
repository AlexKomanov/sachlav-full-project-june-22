package tests.logintests.failedTests;

import helpers.Credentials;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import tests.BaseTest;

public class FailedTests extends BaseTest {

    @Test
    public void failedTest_01() {
        LoginPage loginPage = new LoginPage(driver);


        loginPage.loginToApp(Credentials.LOCKED_OUT_USER, Credentials.SECRET_SAUCE_PASSWORD);

        Assert.assertEquals(loginPage.getErrorMessage(), "Epic sadface: Sorry, this user has been locked out.");
    }


}
