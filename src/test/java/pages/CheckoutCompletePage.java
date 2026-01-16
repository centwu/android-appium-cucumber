package pages;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

public class CheckoutCompletePage extends BasePage {
    private final By orderSuccessTitle =
            AppiumBy.id(APP_PACKAGE + ":id/completeTV");

    private final By thankYouText =
            AppiumBy.id(APP_PACKAGE + ":id/thankYouTV");

    private final By swagText =
            AppiumBy.id(APP_PACKAGE + ":id/swagTV");

    private final By orderText =
            AppiumBy.id(APP_PACKAGE + ":id/orderTV");

    private final By sauceLabsPonyExpressImage =
            AppiumBy.accessibilityId("Sauce Labs Pony Express");

    private final By shoppingButton =
            AppiumBy.accessibilityId("Tap to open catalog");

    public void assertCheckoutSuccessDisplayed() {
        waitForVisible(orderSuccessTitle);
        waitForVisible(thankYouText);
        waitForVisible(swagText);
        waitForVisible(orderText);
        waitForVisible(sauceLabsPonyExpressImage);
        waitForVisible(shoppingButton);
    }
}
