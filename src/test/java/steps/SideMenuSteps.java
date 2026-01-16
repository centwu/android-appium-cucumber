package steps;

import io.cucumber.java.en.*;
import pages.SideMenuPage;

public class SideMenuSteps {

    SideMenuPage sideMenuPage = new SideMenuPage();

    @Given("user opens side menu")
    public void userOpensSideMenu() {
        sideMenuPage.openSideMenu();
    }
}
