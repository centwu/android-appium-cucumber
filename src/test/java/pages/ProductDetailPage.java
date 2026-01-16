package pages;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

public class ProductDetailPage extends BasePage {

    private final By productTitle =
            AppiumBy.id(APP_PACKAGE + ":id/productTV");

    private final By productImage =
            AppiumBy.accessibilityId("Displays selected product");

    private final By productPrice =
            AppiumBy.id(APP_PACKAGE + ":id/priceTV");

    private final By productRating =
            AppiumBy.id(APP_PACKAGE + ":id/rattingV");

    private final By productColorChips =
            AppiumBy.accessibilityId("Displays available colors of selected product");

    private final By quantityText =
            AppiumBy.id(APP_PACKAGE + ":id/noTV");

    private final By increaseQtyButton =
            AppiumBy.accessibilityId("Increase item quantity");

    private final By addToCartButton =
            AppiumBy.accessibilityId("Tap to add product to cart");

    private By getColorElement(String color) {
        return AppiumBy.accessibilityId(color + " color");
    }

    private By getSelectedIndicatorForColor(String color) {
        return AppiumBy.xpath(
                "//android.widget.ImageView[@content-desc='" + color + " color']/preceding-sibling::android.widget.ImageView[@content-desc='Indicates when color is selected']"
        );
    }

    public void verifyProductDetailPageDisplayed(String productName) {
        waitForVisible(productTitle);
        waitForVisible(productImage);
        waitForVisible(productPrice);
        waitForVisible(productRating);
        waitForVisible(productColorChips);
        waitForVisible(addToCartButton);

        String actualProductName = getText(productTitle);
        if (!actualProductName.equals(productName)) {
            throw new AssertionError(
                    "Product name mismatch! Expected: " + productName + ", but found: " + actualProductName
            );
        }
    }

    public void selectColor(String color) {
        By colorContainer = getColorElement(color);
        click(colorContainer);

        waitForVisible(getSelectedIndicatorForColor(color));
    }

    public void setQuantity(int quantity) {
        waitForVisible(quantityText);

        int currentQuantity = Integer.parseInt(getText(quantityText));

        while (currentQuantity < quantity) {
            click(increaseQtyButton);
            currentQuantity++;
            System.out.println("Increased quantity to: " + currentQuantity);
        }

        if (currentQuantity > quantity) {
            throw new UnsupportedOperationException("Decrease quantity not implemented yet");
        }

        String finalQuantity = getText(quantityText);
        if (!finalQuantity.equals(String.valueOf(quantity))) {
            throw new AssertionError("Quantity mismatch! Expected: " + quantity + ", but found: " + finalQuantity);
        }
    }

    public void clickAddToCartButton() {
        click(addToCartButton);
    }
}
