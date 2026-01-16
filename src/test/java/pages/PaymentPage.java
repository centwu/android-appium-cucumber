package pages;

import io.appium.java_client.AppiumBy;
import models.Payment;
import org.openqa.selenium.By;

public class PaymentPage extends BasePage {

    private final By checkoutPaymentTitle =
            AppiumBy.id(APP_PACKAGE + ":id/enterPaymentMethodTV");

    private final By cardNameField =
            AppiumBy.id(APP_PACKAGE + ":id/nameET");

    private final By cardNumberField =
            AppiumBy.id(APP_PACKAGE + ":id/cardNumberET");

    private final By expiryField =
            AppiumBy.id(APP_PACKAGE + ":id/expirationDateET");

    private final By cvvField =
            AppiumBy.id(APP_PACKAGE + ":id/securityCodeET");

    private final By toReviewOrderButton =
            AppiumBy.accessibilityId("Saves payment info and launches screen to review checkout data");

    public void verifyIsOnPaymentPage(){
        waitForVisible(checkoutPaymentTitle);
    }

    public void fillPaymentDetails(Payment data) {
        inputText(cardNameField, data.cardHolderName());
        inputText(cardNumberField, data.cardNumber());
        inputText(expiryField, data.expiryDate());
        inputText(cvvField, data.securityCode());
    }

    public void reviewOrder() {
        click(toReviewOrderButton);
    }
}
