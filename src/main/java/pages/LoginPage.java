package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(id = "user-name")
    private WebElement usernameInput;
    @FindBy(css = "[id='password']")
    private WebElement passwordInput;
    @FindBy(css = "[id=\"login-button\"]")
    private WebElement loginButton;
    @FindBy(css = "[data-test=\"error\"]")
    private WebElement errorMessage;


    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void loginToApp(String username, String password){
        fillText(usernameInput, username);
        fillText(passwordInput, password);
        clickElement(loginButton);
    }

    public String getErrorMessage() {
        return getElementText(errorMessage);
    }

}