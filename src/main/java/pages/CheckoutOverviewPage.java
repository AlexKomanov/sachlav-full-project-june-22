package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutOverviewPage extends BasePage {

    @FindBy(css = "[class=\"title\"]")
    private WebElement title;
    @FindBy(css = "[id=\"finish\"]")
    private WebElement finishButton;
    public CheckoutOverviewPage(WebDriver driver) {
        super(driver);
    }

    public String getTitle() {
        return getElementText(title);
    }

    public void finishCheckout() {
        clickElement(finishButton);
    }

}
