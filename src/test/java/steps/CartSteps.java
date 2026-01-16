package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import models.CartItem;
import pages.*;
import utils.CheckoutContext;

import java.util.List;

public class CartSteps {

    CartPage cartPage = new CartPage();
    HeaderPage headerPage = new HeaderPage();
    ProductsPage productsPage = new ProductsPage();
    ProductDetailPage productDetailPage = new ProductDetailPage();
    SideMenuPage sideMenuPage = new SideMenuPage();

    @Given("user has the following items in the cart:")
    public void userHasItemsInCart(DataTable table) {
        List<CartItem> items = table.asList(CartItem.class);

        CheckoutContext.setCartItems(items);

        for (CartItem item : items) {
            productsPage.selectProductByName(item.product());
            productDetailPage.verifyProductDetailPageDisplayed(item.product());
            productDetailPage.setQuantity(item.quantity());
            productDetailPage.clickAddToCartButton();

            headerPage.clickBurgerMenuButton();
            sideMenuPage.navigateToCatalog();
        }
    }

    @Given("user proceeds to checkout")
    public void userProceedsToCheckout() {
        cartPage.clickProceedCheckoutButton();
    }

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
