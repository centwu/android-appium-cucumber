package pages;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

public class HeaderPage extends BasePage {

    private final By burgerMenuButton =
            AppiumBy.accessibilityId("View menu");

    private final By cartButton =
            AppiumBy.accessibilityId("View cart");

    private final By cartCountText =
            AppiumBy.id(APP_PACKAGE + ":id/cartTV");

    public void clickBurgerMenuButton() {
        click(burgerMenuButton);
    }

    public void clickCartButton() {
        click(cartButton);
    }

    public void assertCartCount(int count) {
        waitForVisible(cartCountText);

        int actualItemCount = Integer.parseInt(getText(cartCountText));

        if (actualItemCount != count) {
            throw new AssertionError("Count mismatch! Expected: " + count + ", but found: " + actualItemCount);
        }
    }
}
