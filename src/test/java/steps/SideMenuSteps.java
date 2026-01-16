package steps;

import io.cucumber.java.en.*;
import pages.HeaderPage;
import pages.SideMenuPage;

public class SideMenuSteps {

    HeaderPage headerPage = new HeaderPage();
    SideMenuPage sideMenuPage = new SideMenuPage();

    @Given("user opens side menu")
    public void userOpensSideMenu() {
        headerPage.clickBurgerMenuButton();
        sideMenuPage.verifySideMenuIsDisplayed();
    }
}
