package steps;

import io.cucumber.java.en.*;
import pages.ProductDetailPage;
import pages.ProductsPage;

public class ProductDetailSteps {

    ProductsPage productsPage = new ProductsPage();
    ProductDetailPage productDetailPage = new ProductDetailPage();

    @When("user navigates to {string} detail page")
    public void navigateToProductDetailPage(String item) {
        productsPage.selectProductByName(item);
        productDetailPage.verifyProductDetailPageDisplayed(item);
    }

    @When("user selects color {string}")
    public void selectColor(String color) {
        productDetailPage.selectColor(color);
    }

    @When("user sets quantity to {int}")
    public void setQuantity(int quantity) {
        productDetailPage.setQuantity(quantity);
    }

    @When("user adds the item to the cart")
    public void addItemToCart() {
        productDetailPage.clickAddToCartButton();
    }

}
