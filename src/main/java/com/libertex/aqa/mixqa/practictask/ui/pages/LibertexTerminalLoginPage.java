package com.libertex.aqa.mixqa.practictask.ui.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;

public class LibertexTerminalLoginPage {
    private SelenideElement emailField = $(By.id("login-field"));
    private SelenideElement passwordField = $(By.id("password-field"));
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
}
