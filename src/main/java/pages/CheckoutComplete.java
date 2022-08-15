package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutComplete extends BasePage {

    @FindBy(css = "[class=\"title\"]")
    private WebElement title;
    @FindBy(css = "[class=\"complete-header\"]")
    private WebElement completeHeaderText;
    public CheckoutComplete(WebDriver driver) {
        super(driver);
    }

    public String getTitle() {
        return getElementText(title);
    }

    public String getHeaderCompleteText() {
        return getElementText(completeHeaderText);
    }
}
