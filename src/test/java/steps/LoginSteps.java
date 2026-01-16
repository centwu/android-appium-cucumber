package steps;

import data.Users;
import io.cucumber.java.en.*;
import pages.LoginPage;
import pages.ProductsPage;
import pages.SideMenuPage;

public class LoginSteps {

    LoginPage loginPage = new LoginPage();
    ProductsPage productsPage = new ProductsPage();
    SideMenuPage sideMenuPage = new SideMenuPage();

    @Given("user navigates to login page")
    public void userNavigatesToLoginPage() {
        sideMenuPage.navigateToLoginPage();
        loginPage.verifyLoginScreenDisplayed();
    }

    @When("user enters valid username and password")
    public void userEntersValidCredentials() {
        loginPage.login(Users.VALID_USER);
    }

    @When("user enters locked out username and password")
    public void userEntersLockedOutCredentials() {
        loginPage.login(Users.LOCKED_OUT_USER);
    }

    @Then("user should see locked out message")
    public void userShouldSeeLockedOutMessage() {
        loginPage.assertLockedOutErrorMessage();
    }
}
