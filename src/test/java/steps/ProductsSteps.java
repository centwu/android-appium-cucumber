package steps;

import io.cucumber.java.en.*;
import pages.HeaderPage;
import pages.ProductsPage;

public class ProductsSteps {

    ProductsPage productsPage = new ProductsPage();
    HeaderPage headerPage = new HeaderPage();

    @Then("user should see products page")
    public void userShouldSeeProductsPage() {
        productsPage.verifyProductsPageDisplayed();
    }

    @When("user goes to the cart page")
    public void userGoesToTheCartPage() {
        headerPage.clickCartButton();
    }
}
