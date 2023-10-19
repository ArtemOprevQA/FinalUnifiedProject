package com.libertex.aqa.mixqa.practictask.ui.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class LibertexTerminalProfilePage {

    private SelenideElement firstInstrument = $("a.a-btn.growth");
    private SelenideElement headerBurgerMenu = $("[class='nav-block-toggle']");
    private SelenideElement activeTradesButton = $("a.investments-nav");

    @Step("Click on the 'Buy' tab for default instrument")
    public void clickOnBuyTabForDefaultInstrument() {
        firstInstrument.shouldBe(Condition.visible).click();
    }

    @Step("Click on the 'Active trades' button from burger menu")
    public void clickOnActiveTradesButton() {
        headerBurgerMenu.hover();
        activeTradesButton.click();
    }
}
