package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

public class ProductsPage extends BasePage {

    @FindBy(className = "title")
    WebElement title;
    @FindAll(@FindBy(css = "[class=\"inventory_item_description\"]"))
    List<WebElement> productDescriptions;
    @FindBy(css = "[button]")
    WebElement addToCartButton;


    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public void validateTitle(String expectedText) {
        String titleText = getElementText(title);
        Assert.assertEquals(titleText, expectedText);
    }

    public String getTitle() {
        return getElementText(title);
    }

    public void chooseProductFromList(String title) {
        for (WebElement productDescription : productDescriptions) {
            WebElement itemTitleElement = productDescription.findElement(By.cssSelector("[class=\"inventory_item_name\"]"));
            String itemTitle = itemTitleElement.getText();
            if (itemTitle.toLowerCase().equals(title.toLowerCase())) {
                productDescription.findElement(By.cssSelector("button")).click();
            }
        }
    }
}
