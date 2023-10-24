package com.libertex.aqa.mixqa.practictask.ui.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;

public class LibertexTerminalMainPage {
    private SelenideElement loginButton = $("a[href='/login']");

    @Step("Wait for Libertex Terminal main page loaded")
    public void waitForLibertexTerminalMainPageLoaded() {
        loginButton.shouldBe(Condition.visible, Duration.ofSeconds(5));
    }
    @Step("Click on the 'Existing account' button on main page")
    public void clickLoginButton() {
        loginButton.click();
    }
}
