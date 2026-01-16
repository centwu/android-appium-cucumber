package steps;

import io.cucumber.java.en.*;
import pages.ProductsPage;

public class CommonSteps {

    ProductsPage productsPage =  new ProductsPage();

    @Given("user is on products page")
    public void userIsOnProductsPage() {
        productsPage.verifyProductsPageDisplayed();
    }
}
