package steps;

import io.cucumber.java.en.*;
import pages.HeaderPage;

public class HeaderSteps {

    HeaderPage headerPage = new HeaderPage();

    @Then("the cart count should be {int}")
    public void theCartCountShouldBe(int count) {
        headerPage.assertCartCount(count);
    }
}
