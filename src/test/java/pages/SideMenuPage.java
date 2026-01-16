package pages;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

public class SideMenuPage extends BasePage{

    private final By burgerMenuButton =
            AppiumBy.accessibilityId("View menu");

    private final By drawerMenu =
            AppiumBy.id(APP_PACKAGE + ":id/drawerMenu");

    private final By loginMenu =
            AppiumBy.androidUIAutomator("new UiSelector().text(\"Log In\")");

    public void openSideMenu() {
        click(burgerMenuButton);
        waitForVisible(drawerMenu);
        if (!isVisible(drawerMenu)) {
            throw new AssertionError("Drawer menu is not visible");
        }
    }

    public void navigateToLoginPage() {
        click(loginMenu);
    }
}
