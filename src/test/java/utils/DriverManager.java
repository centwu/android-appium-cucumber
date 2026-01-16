package utils;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

import java.net.URL;

public class DriverManager {

    private static AndroidDriver driver;

    public static AndroidDriver getDriver() {
        return driver;
    }

    public static void initializeDriver() {
        try {
            UiAutomator2Options options = new UiAutomator2Options()
                    .setPlatformName(ConfigReader.get("platformName"))
                    .setDeviceName(ConfigReader.get("deviceName"))
                    .setAutomationName(ConfigReader.get("automationName"))
                    .setApp(ConfigReader.get("app"))
                    .setAppPackage(ConfigReader.get("appPackage"))
                    .setAppActivity(ConfigReader.get("appActivity"));

            URL serverURL = new URL(ConfigReader.get("serverURL"));

            driver = new AndroidDriver(serverURL, options);

        } catch (Exception e) {
            throw new RuntimeException("Failed to initialize Appium driver", e);
        }
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
