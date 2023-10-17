package com.libertex.aqa.mixqa.practictask.ui.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;

public class LibertexTerminalInstrumentTradePage {

    private SelenideElement instrumentOpenTradeButton = $(".a-submit[data-growth='Buy'][data-reduction='Sell'][data-signal-growth='Buy by signal'][data-signal-reduction='Sell by signal']");

    private SelenideElement notificationField = $("[class='box-row box-row-text'] p");

    public SelenideElement getNotificationField() {
        return notificationField;
    }

    @Step("Open trade for default instrument")
    public void openDefaultInstrumentTrade()  {
        instrumentOpenTradeButton.click();
    }

    @Step("Waiting for successful open default instrument trade notification")
    public void waitingForNotification(){
        notificationField.shouldHave(Condition.visible, Duration.ofSeconds(15));
    }
}
