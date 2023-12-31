package com.libertex.aqa.mixqa.practictask.ui.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;

public class LibertexTerminalLoginPage {
    private SelenideElement emailField = $("#login-field");
    private SelenideElement passwordField = $("#password-field");
    private SelenideElement loginButton = $("input[type='submit']");

    @Step("Set email: '{email}' and password: '{password}' to its fields")
    public void inputCredentials(String email, String password) {
        emailField.setValue(email);
        passwordField.setValue(password);
    }

    @Step("Click on the 'Login' button on login page")
    public void clickLoginButton() {
        loginButton.click();
    }

    @Step("Wait for Libertex Terminal login page loaded")
    public void waitForLibertexTerminalLoginPageLoaded() {
        loginButton.shouldBe(Condition.visible, Duration.ofSeconds(5));
    }
}
