package steps;

import io.cucumber.java.en.*;
import pages.ProductsPage;

public class ProductsSteps {

    ProductsPage productsPage = new ProductsPage();

    @Then("user should see products page")
    public void userShouldSeeProductsPage() {
        productsPage.verifyProductsPageDisplayed();
    }
}
