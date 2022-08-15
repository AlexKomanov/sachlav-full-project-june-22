package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class YourCartPage extends BasePage {

    @FindBy(className = "title")
    WebElement title;
    @FindBy(css = "[id=\"checkout\"]")
    WebElement checkoutButton;

    public YourCartPage(WebDriver driver) {
        super(driver);
    }

    public String getTitle() {
        return getElementText(title);
    }

    public void goToCheckout() {
        clickElement(checkoutButton);
    }
}
