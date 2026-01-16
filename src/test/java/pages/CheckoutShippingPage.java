package pages;

import io.appium.java_client.AppiumBy;
import models.Shipping;
import org.openqa.selenium.By;

public class CheckoutShippingPage extends BasePage {

    private final By fullNameField =
            AppiumBy.id(APP_PACKAGE + ":id/fullNameET");

    private final By addressLine1Field =
            AppiumBy.id(APP_PACKAGE + ":id/address1ET");

    private final By cityField =
            AppiumBy.id(APP_PACKAGE + ":id/cityET");

    private final By zipCodeField =
            AppiumBy.id(APP_PACKAGE + ":id/zipET");

    private final By stateField =
            AppiumBy.id(APP_PACKAGE + ":id/stateET");

    private final By countryField =
            AppiumBy.id(APP_PACKAGE + ":id/countryET");

    private final By toPaymentButton =
            AppiumBy.accessibilityId("Saves user info for checkout");

    public void fillShippingDetails(Shipping shipping) {
        inputText(fullNameField, shipping.fullName());
        inputText(addressLine1Field, shipping.addressLine1());
        inputText(cityField, shipping.city());
        inputText(zipCodeField, shipping.zipCode());
        inputText(stateField, shipping.state());
        inputText(countryField, shipping.country());
    }

    public void continueToPayment() {
        click(toPaymentButton);
    }
}
