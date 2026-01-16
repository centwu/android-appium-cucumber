package pages;

import io.appium.java_client.AppiumBy;
import models.User;
import org.openqa.selenium.By;

public class LoginPage extends BasePage {

    private final By loginTitle =
            AppiumBy.id(APP_PACKAGE + ":id/loginTV");

    private final By usernameInputField =
            AppiumBy.id(APP_PACKAGE + ":id/nameET");

    private final By passwordInputField =
            AppiumBy.id(APP_PACKAGE + ":id/passwordET");

    private final By loginButton =
            AppiumBy.accessibilityId("Tap to login with given credentials");

    private final By errorMessage =
            AppiumBy.id(APP_PACKAGE + ":id/passwordErrorTV");

    public void verifyLoginScreenDisplayed() {
        waitForVisible(loginTitle);

        if (!isVisible(loginTitle)) {
            throw new AssertionError("Login screen is not visible");
        }
    }

    public void login(User user) {
        type(usernameInputField, user.username());
        type(passwordInputField, user.password());
        click(loginButton);
    }

    public void assertLockedOutErrorMessage() {
        waitForVisible(errorMessage);

        String actual = getText(errorMessage);
        if (!actual.equals("Sorry this user has been locked out.")) {
            throw new AssertionError(
                    "Unexpected error message: " + actual
            );
        }
    }

}
