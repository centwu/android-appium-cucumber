package steps;

import io.cucumber.java.en.*;
import pages.CartPage;
import pages.HeaderPage;

public class CartSteps {

    CartPage cartPage = new CartPage();
    HeaderPage headerPage = new HeaderPage();

    @When("user navigates to cart page")
    public void userNavigatesToCartPage() {
        headerPage.clickCartButton();
        cartPage.verifyCartIsDisplayed();
    }

    @When("user clicks remove item for {string}")
    public void userClicksRemoveItem(String name) {
        cartPage.clickRemoveItemButton(name);
    }

    @Then("the cart should be empty")
    public void theCartShouldBeEmpty() {
        cartPage.verifyEmptyCart();
    }

    @Then("the cart should contain {string} with quantity {int}")
    public void theCartShouldContainItemWith(String name, int quantity) {
        headerPage.clickCartButton();
        cartPage.verifyCartIsDisplayed();
        cartPage.verifyCartItemQuantity(name, quantity);
    }

    @Then("the cart page total items should be {int}")
    public void theCartPageTotalItemsShouldBe(int totalItems) {
        headerPage.clickCartButton();
        cartPage.assertTotalItemQty(totalItems);
    }

    @Then("the cart page total price should be {double}")
    public void theCartPageTotalPriceShouldBe(double price) {
        cartPage.assertTotalPrice(price);
    }

    @Then("the cart should not contain {string}")
    public void theCartShouldNotContainItem(String name) {
        cartPage.verifyCartItemRemoved(name);
    }
}
