package pages;

import io.appium.java_client.AppiumBy;
import models.CartItem;
import org.openqa.selenium.By;

import java.math.BigDecimal;
import java.util.List;

public class CheckoutReviewOrderPage extends BasePage {

    private final By checkoutReviewTitle =
            AppiumBy.id(APP_PACKAGE + ":id/enterShippingAddressTV");

    private final By deliveryFeeText =
            AppiumBy.id(APP_PACKAGE + ":id/amountTV");

    private final By totalPriceText =
            AppiumBy.id(APP_PACKAGE + ":id/totalAmountTV");

    private final By placeOrderButton =
            AppiumBy.accessibilityId("Completes the process of checkout");

    private By itemName(String name) {
        return By.xpath(
                "//android.widget.TextView[@text=\"" + name + "\"]"
        );
    }

    private BigDecimal getDeliveryPrice() {
        scrollToText("DHL Standard Delivery");
        waitForVisible(deliveryFeeText);

        String priceText = getText(deliveryFeeText).replaceAll("[^0-9.]", "");

        return new BigDecimal(priceText);
    }

    public void isOnCheckoutReviewOrderPage() {
        waitForVisible(checkoutReviewTitle);
    }

    public void assertOrderSummary(List<CartItem> expectedItems) {

        for (CartItem item : expectedItems) {
            waitForVisible(itemName(item.product()));
            // MARK: Order summary does not show each item variant quantity yet
        }
    }

    public void assertTotalPriceIsCorrect(List<CartItem> items) {
        String actual = driver.findElement(totalPriceText).getText();

        BigDecimal actualTotal =
                new BigDecimal(actual.replaceAll("[^0-9.]", ""));

        BigDecimal subtotal = items.stream()
                .map(item ->
                        item.price().multiply(
                                BigDecimal.valueOf(item.quantity())
                        )
                )
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        BigDecimal expectedTotal = subtotal.add(getDeliveryPrice());

        if (actualTotal.compareTo(expectedTotal) != 0) {
            throw new AssertionError(
                    "Expected total: " + expectedTotal +
                            " but found: " + actualTotal
            );
        }
    }

    public void placeOrder() {
        click(placeOrderButton);
    }
}
