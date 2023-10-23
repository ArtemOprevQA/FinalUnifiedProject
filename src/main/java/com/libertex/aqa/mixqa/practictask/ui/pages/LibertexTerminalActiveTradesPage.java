package com.libertex.aqa.mixqa.practictask.ui.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;

public class LibertexTerminalActiveTradesPage {
    private SelenideElement closeAllTradesMenuButton = $("div.close-all-btn");
    private SelenideElement closeAllTradesButton = $("li.all");
    private SelenideElement closeOutButton = $("span.close-invest");
    private SelenideElement successfulCloseOutNotificationField = $("div.close-multiple-ty");
    private SelenideElement goBackToTradingButton = $("div.close-multiple-ty > span.a-btn.a-btn-blue.go-trade");
    private SelenideElement usedAmountField = $("div.investments-footer div.col.col-sumInv");
    private SelenideElement resultAmountField = $("div.investments-footer div.col.col-equityInv");
    private SelenideElement profitAmountField = $("div.investments-footer div.col.col-profit");

    @Step("Click on the 'Close all trades' button on active trades page")
    public void clickCloseAllTradesMenuButton() {
        closeAllTradesMenuButton.click();
    }

    @Step("Click on the 'Close all' button on active trades page")
    public void clickCloseAllTradesButton() {
        closeAllTradesButton.click();
    }

    @Step("Click on the 'Close out' button on modal window of active trades page")
    public void clickCloseOutButton() {
        closeOutButton.click();
    }

    @Step("Waiting for successful close out default instrument trade notification")
    public void waitingForSuccessfulCloseOutNotification(){
        successfulCloseOutNotificationField.shouldHave(Condition.visible, Duration.ofSeconds(10));
    }

    @Step("Get text from successful opened trade notification field")
    public String getTextFromSuccessfulCloseOutNotificationField(){
        return successfulCloseOutNotificationField.getText();
    }

    @Step("Click on the 'Close out' button on modal window of active trades page")
    public void clickGoBackToTradingButton() {
        goBackToTradingButton.shouldBe(Condition.visible).click();
    }

    @Step("Get text from 'Used' field")
    public String getTextFromUsedAmountField(){
        return usedAmountField.getText();
    }

    @Step("Get text from 'Amount' field")
    public String getTextFromResultAmountField(){
        return resultAmountField.getText();
    }

    @Step("Get text from 'Profit' field")
    public String getTextFromProfitAmountField(){
        return profitAmountField.getText();
    }
}
