package com.libertex.aqa.mixqa.practictask.ui.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import static com.codeborne.selenide.Selenide.$;

public class LibertexTerminalMainPage {
    private SelenideElement loginButton = $(".login-btn");

    @Step("Click on the 'Login' button on main page")
    public void clickLoginButton() {
        loginButton.click();
    }
}
