package com.libertex.aqa.mixqa.practictask.ui;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.libertex.aqa.mixqa.practictask.ui.pages.LibertexTerminalLoginPage;
import com.libertex.aqa.mixqa.practictask.ui.pages.LibertexTerminalMainPage;
import com.libertex.aqa.mixqa.practictask.util.PropertyReader;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import java.time.Duration;
import static com.codeborne.selenide.Selenide.$;

@Slf4j
public class BaseTestUI {
    protected LibertexTerminalMainPage mainPage = new LibertexTerminalMainPage();
    protected LibertexTerminalLoginPage loginPage = new LibertexTerminalLoginPage();
    protected String email = PropertyReader.getProperty("ui.credentials.email");
    protected String password = PropertyReader.getProperty("ui.credentials.password");

    @BeforeSuite
    public void setupBrowser() {
        Configuration.browser = PropertyReader.getProperty("ui.browser");
    }

    @BeforeClass
    public void openLibertexTerminal() {
        Selenide.open(PropertyReader.getProperty("ui.base.url"));
        $(".login-btn").shouldBe(Condition.visible, Duration.ofSeconds(5));
    }
}
