package pages;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

public class ProductsPage extends BasePage {

    private final By productsTitle =
            AppiumBy.id(APP_PACKAGE + ":id/productTV");

    public void verifyProductsPageDisplayed() {
        waitForVisible(productsTitle);

        if (!isVisible(productsTitle)) {
            throw new AssertionError("Product title is not displayed");
        }
    }
}
