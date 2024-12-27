package PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshetty.AbstractComponents.AbstractComponents;

public class ProductCatalogue extends AbstractComponents {
    WebDriver driver;

    public ProductCatalogue(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "item-box")
    private List<WebElement> products;

    @FindBy(xpath = "//a[text()='shopping cart']")
    private WebElement toastMessage;

    private By addToCartButton = By.xpath(".//div[@class='buttons']/input[@value='Add to cart']");
    private By productTitle = By.xpath(".//h2[@class='product-title']/a");

    public List<WebElement> getProducts() {
        return products;
    }

    public WebElement getProductByName(String productName) {
        return getProducts().stream()
                .filter(product -> product.findElement(productTitle).getText().equals(productName))
                .findFirst()
                .orElse(null);
    }

    public WebElement addProductToCart(String productName) {
        WebElement product = getProductByName(productName);
        if (product != null) {
            product.findElement(addToCartButton).click();
            waitForElementToAppear(toastMessage);
            return toastMessage;
        } else {
            throw new RuntimeException("Product with name '" + productName + "' not found.");
        }
    }
}
