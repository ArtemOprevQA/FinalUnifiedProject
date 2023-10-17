package com.libertex.aqa.mixqa.practictask.ui.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class LibertexTerminalProfilePage {

    private SelenideElement firstInstrument = $("a.a-btn.new-invest.growth");

    @Step("Click on the 'Buy' tab for default instrument")
    public void clickOnBuyTabForDefaultInstrument() {
        firstInstrument.click();
    }
}
