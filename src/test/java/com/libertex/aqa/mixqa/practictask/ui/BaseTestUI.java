package com.libertex.aqa.mixqa.practictask.ui;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.libertex.aqa.mixqa.practictask.ui.pages.LibertexTerminalLoginPage;
import com.libertex.aqa.mixqa.practictask.ui.pages.LibertexTerminalMainPage;
import com.libertex.aqa.mixqa.practictask.util.PropertyReader;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import static com.libertex.aqa.mixqa.practictask.constants.Properties.*;

@Slf4j
public class BaseTestUI {
    protected LibertexTerminalMainPage mainPage = new LibertexTerminalMainPage();
    protected LibertexTerminalLoginPage loginPage = new LibertexTerminalLoginPage();
    protected String email = PropertyReader.getProperty(UI_CREDENTIALS_EMAIL);
    protected String password = PropertyReader.getProperty(UI_CREDENTIALS_PASSWORD);

    @BeforeSuite
    public void setupBrowser() {
        Configuration.browser = PropertyReader.getProperty(UI_BROWSER);
    }

    @BeforeClass
    public void openLibertexTerminal() {
        Selenide.open(PropertyReader.getProperty(UI_BASE_URL));
        mainPage.waitForLibertexTerminalMainPageLoaded();
    }
}
