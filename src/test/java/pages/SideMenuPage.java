package pages;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

public class SideMenuPage extends BasePage{



    private final By drawerMenu =
            AppiumBy.id(APP_PACKAGE + ":id/drawerMenu");

    private final By catalogMenu =
            AppiumBy.androidUIAutomator("new UiSelector().text(\"Catalog\")");

    private final By loginMenu =
            AppiumBy.androidUIAutomator("new UiSelector().text(\"Log In\")");

    public void verifySideMenuIsDisplayed() {
        waitForVisible(drawerMenu);
        if (!isVisible(drawerMenu)) {
            throw new AssertionError("Drawer menu is not visible");
        }
    }

    public void navigateToCatalog() {
        click(catalogMenu);
    }

    public void navigateToLoginPage() {
        click(loginMenu);
    }
}
