package pages;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

public class ProductsPage extends BasePage {

    private final By productsTitle =
            AppiumBy.id(APP_PACKAGE + ":id/productTV");

    private final By productContainer =
            AppiumBy.xpath("//android.widget.TextView[@text='Sauce Lab Back Packs']/preceding-sibling::android.view.ViewGroup[1]");

    private By getProductContainerByName(String productName) {
        return AppiumBy.xpath(
                "//android.widget.TextView[@text='" + productName + "']/.."
        );
    }

    public void verifyProductsPageDisplayed() {
        waitForVisible(productsTitle);

        if (!isVisible(productsTitle)) {
            throw new AssertionError("Product title is not displayed");
        }
    }

    public void selectProductByName(String productName) {
        By productContainer = getProductContainerByName(productName);
        click(productContainer);
    }
}
