package pages;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

public class CartPage extends BasePage {

    private final By noItemTitle =
            AppiumBy.id(APP_PACKAGE + ":id/noItemTitleTV");

    private final By noItemCopy =
            AppiumBy.androidUIAutomator("new UiSelector().text(\"Oh no! Your cart is empty. Fill it up with swag to complete your purchase.\")");

    private final By shoppingButton =
            AppiumBy.id(APP_PACKAGE + ":id/shoppingBt");

    private final By cartConstraint =
            AppiumBy.id(APP_PACKAGE + ":id/cartCL");

    private final By totalItemQtyText =
            AppiumBy.id(APP_PACKAGE + ":id/itemsTV");

    private final By totalPriceText =
            AppiumBy.id(APP_PACKAGE + ":id/totalPriceTV");

    private final By proceedCheckoutButton =
            AppiumBy.accessibilityId("Confirms products for checkout");

    private By getCartItemContainerByName(String productName) {
        return AppiumBy.xpath(
                "//androidx.recyclerview.widget.RecyclerView[@resource-id='" + APP_PACKAGE + ":id/productRV']" +
                        "//android.view.ViewGroup[.//android.widget.TextView[@text='" + productName + "']]"
        );
    }

    public By getQuantityTextByProductName(String productName) {
        return AppiumBy.xpath(
                "//androidx.recyclerview.widget.RecyclerView[@resource-id='" + APP_PACKAGE + ":id/productRV']" +
                        "//android.view.ViewGroup[.//android.widget.TextView[@text='" + productName + "']]" +
                        "//android.widget.TextView[@resource-id='" + APP_PACKAGE + ":id/noTV']"
        );
    }

    public By getRemoveButtonByProductName(String productName) {
        return AppiumBy.xpath(
                "//android.view.ViewGroup[.//android.widget.TextView[@resource-id='"
                        + APP_PACKAGE + ":id/titleTV' and @text='" + productName + "']]" +
                        "//android.widget.TextView[@resource-id='" + APP_PACKAGE + ":id/removeBt']"
        );
    }

    public void verifyEmptyCart()  {
        waitForVisible(noItemTitle);
        waitForVisible(noItemCopy);
        waitForVisible(shoppingButton);
    }

    public void verifyCartIsDisplayed() {
        waitForVisible(cartConstraint);
    }

    public void verifyCartItemQuantity(String productName, int quantity) {

        By quantityLocator = getQuantityTextByProductName(productName);

        String actualQuantity = getText(quantityLocator);

        if (!actualQuantity.equals(String.valueOf(quantity))) {
            throw new AssertionError("Quantity mismatch! " +
                    "Expected: " + quantity + ", Found: " + actualQuantity);
        }
    }

    public void assertTotalItemQty(int totalItems) {
        waitForVisible(totalItemQtyText);

        String actualTotal = getText(totalItemQtyText);
        int actualTotalItem = Integer.parseInt(actualTotal.replaceAll("[^0-9]", ""));

        if (actualTotalItem != totalItems) {
            throw new AssertionError("Total qty mismatch! Expected: " + totalItems + ", but found: " + actualTotalItem);
        }
    }

    public void assertTotalPrice(double totalPrice) {
        waitForVisible(totalPriceText);

        String priceText = getText(totalPriceText);
        double actualTotalPrice = Double.parseDouble(priceText.replaceAll("[^0-9.]", ""));

        if (actualTotalPrice != totalPrice) {
            throw new AssertionError("Total price mismatch! Expected: " + totalPrice + ", found: " + actualTotalPrice);
        }
    }

    public void clickRemoveItemButton(String productName) {
        By removeBtn = getRemoveButtonByProductName(productName);
        waitForVisible(removeBtn);
        click(removeBtn);
    }

    public void verifyCartItemRemoved(String productName) {
        waitForInvisible(getCartItemContainerByName(productName));
    }

    public void clickProceedCheckoutButton() {
        click(proceedCheckoutButton);
    }
}
