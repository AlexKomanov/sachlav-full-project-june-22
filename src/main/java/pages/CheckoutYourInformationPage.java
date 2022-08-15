package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutYourInformationPage extends BasePage {

    @FindBy(css = "[class=\"title\"]")
    private WebElement title;
    @FindBy(css = "[id=\"first-name\"]")
    private WebElement firstNameField;
    @FindBy(css = "[id=\"last-name\"]")
    private WebElement lastNameField;
    @FindBy(css = "[id=\"postal-code\"]")
    private WebElement postalCodeField;
    @FindBy(css = "[id=\"continue\"]")
    private WebElement continueButton;
    @FindBy(css = "[id=\"cancel\"]")
    private WebElement cancelButton;

    public CheckoutYourInformationPage(WebDriver driver) {
        super(driver);
    }

    public void fillFirstName(String firstname) {
        fillText(firstNameField, firstname);
    }

    public void fillLastName(String lastname) {
        fillText(lastNameField, lastname);
    }

    public void fillPostalCode(String postalCode) {
        fillText(postalCodeField, postalCode);
    }

    public void fillCheckoutForm(String firstname, String lastname, String postalCode) {
        this.fillFirstName(firstname);
        this.fillLastName(lastname);
        this.fillPostalCode(postalCode);
    }

    public void continueWithCheckout() {
        clickElement(continueButton);
    }

    public String getTitle() {
        return getElementText(title);
    }
}
