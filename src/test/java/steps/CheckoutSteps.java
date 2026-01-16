package steps;

import data.Checkouts;
import data.Users;
import io.cucumber.java.en.*;
import pages.*;
import utils.CheckoutContext;

public class CheckoutSteps {

    CheckoutCompletePage checkoutCompletePage = new CheckoutCompletePage();
    CheckoutShippingPage checkoutShippingPage = new CheckoutShippingPage();
    CheckoutReviewOrderPage checkoutReviewOrderPage = new CheckoutReviewOrderPage();
    LoginPage loginPage = new LoginPage();
    PaymentPage paymentPage = new PaymentPage();

    @When("user completes checkout with valid details")
    public void userCompletesCheckout() {
        loginPage.login(Users.VALID_USER);
        checkoutShippingPage.fillShippingDetails(Checkouts.VALID_SHIPPING);
        checkoutShippingPage.continueToPayment();

        paymentPage.verifyIsOnPaymentPage();
        paymentPage.fillPaymentDetails(Checkouts.VALID_PAYMENT);
        paymentPage.reviewOrder();
    }

    @When("user reviews order details")
    public void userReviewsOrderDetails() {
        checkoutReviewOrderPage.isOnCheckoutReviewOrderPage();
    }

    @When("user places the order")
    public void userPlacesTheOrder() {
        checkoutReviewOrderPage.placeOrder();
    }

    @Then("order summary should display correct items and total price")
    public void orderSummaryShouldBeCorrect() {
        var expectedItems = CheckoutContext.getCartItems();
        checkoutReviewOrderPage.assertOrderSummary(expectedItems);
        checkoutReviewOrderPage.assertTotalPriceIsCorrect(expectedItems);
    }

    @Then("checkout success message should be displayed")
    public void checkoutSuccessMessage() {
        checkoutCompletePage.assertCheckoutSuccessDisplayed();
    }
}
