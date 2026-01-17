# Android UI Automation – Appium + Cucumber + TestNG

This project contains Android UI automation tests for **Sauce Labs MyDemoApp** using **Appium**, **Cucumber (BDD)**, **Java**, **Maven**, and **TestNG**.

The framework follows **Page Object Model (POM)** principles and is designed to be readable, scalable, and interview-ready.

---

## 🛠 Tech Stack

- Java 17+
- Maven
- Appium
- Selenium WebDriver
- Cucumber (BDD)
- TestNG
- Android SDK
- Appium Inspector

---

## 📂 Project Structure

```
├── pom.xml
└── src
    └── test
        ├── java
        │   ├── data
        │   ├── hooks
        │   ├── models
        │   ├── pages
        │   ├── runners
        │   ├── steps
        │   ├── transformers
        │   └── utils
        └── resources
            ├── apps
            ├── config
            └── features

```

---

## Running the Tests

### Prerequisites

Before running the automation tests, make sure the following tools and applications are installed and properly configured.

---

#### Java Development Kit (JDK)

- **Required version:** Java 17 or higher
- Download from Oracle JDK

Verify installation:
```bash
java -version
```

#### Maven

- **Required:** Apache Maven 3.8+
- Downloadable from https://maven.apache.org/install.html

#### Android SDK
Install Android Studio (includes Android SDK):
https://developer.android.com/studio

During installation, ensure the following components are installed:
- Android SDK Platform
- Android SDK Platform Tools
- Android Emulator
- Android SDK Build Tools

After installation, verify adb:
```bash
adb version
```

#### Appium
Install Appium using Node.js:
Install [Node.js](https://nodejs.org) (LTS version recommended)
```
# verify Node.js installation
node -v
npm -v

# install appium
npm install -g appium

# verify appium installation
appium -v

# install UiAutomator2 driver
appium driver install uiautomator2

# running appium server
appium
```

#### Environment configuration
Test configuration is stored in `src/test/resources/config/config.properties`
This file contains:
- App path
- Device name
- Platform version
- Automation name
- Appium server settings
Ensure values match your local device/emulator setup.

### Run all tests
```bash
mvn clean test
```

---

## 📊 Reports

- Cucumber Report: `target/cucumber-report.html`
- TestNG Report: `target/surefire-reports/index.html`

---

## 🚧 Known Limitations

- Cart UI does not expose product color
- Color verification is documented but skipped

---
