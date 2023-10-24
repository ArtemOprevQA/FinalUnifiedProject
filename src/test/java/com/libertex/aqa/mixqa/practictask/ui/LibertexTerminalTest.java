package com.libertex.aqa.mixqa.practictask.ui;

import com.libertex.aqa.mixqa.practictask.ui.pages.LibertexTerminalActiveTradesPage;
import com.libertex.aqa.mixqa.practictask.ui.pages.LibertexTerminalInstrumentTradePage;
import com.libertex.aqa.mixqa.practictask.ui.pages.LibertexTerminalProfilePage;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

public class LibertexTerminalTest extends BaseTestUI {
    private LibertexTerminalProfilePage profilePage = new LibertexTerminalProfilePage();
    private LibertexTerminalInstrumentTradePage instrumentTradePage = new LibertexTerminalInstrumentTradePage();
    private LibertexTerminalActiveTradesPage activeTradesPage = new LibertexTerminalActiveTradesPage();

    private String EXPECTED_AMOUNT_VALUE = "0.00";

    @Test(description = "Test of successful login the Libertex Terminal", priority = 1)
    public void testLoginLibertexTerminal() {
        mainPage.clickLoginButton();
        loginPage.waitForLibertexTerminalLoginPageLoaded();
        loginPage.inputCredentials(email, password);
        loginPage.clickLoginButton();

        Assertions.assertThat(profilePage.getFirstInstrument().isDisplayed()).isTrue();
    }

    @Test(description = "Test of successful open a trade", priority = 2)
    public void testOpenATrade() {
        profilePage.clickOnBuyTabForDefaultInstrument();
        instrumentTradePage.openDefaultInstrumentTrade();
        instrumentTradePage.waitingForNotification();

        Assertions.assertThat(instrumentTradePage.getTextFromOpenedTradeField()).contains("Successful trade! Your balance will be updated shortly.");
        }

    @Test(description = "Test of successful close a trade", priority = 3)
    public void testCloseATrade() {
        profilePage.clickOnActiveTradesButton();
        activeTradesPage.clickCloseAllTradesMenuButton();
        activeTradesPage.clickCloseAllTradesButton();
        activeTradesPage.clickCloseOutButton();
        activeTradesPage.waitingForSuccessfulCloseOutNotification();

        Assertions.assertThat(activeTradesPage.getTextFromSuccessfulCloseOutNotificationField()).contains("All trades have been closed!");

        activeTradesPage.clickGoBackToTradingButton();
        activeTradesPage.waitingForSuccessfulUpdateOfClosedTrade();

        Assertions.assertThat(activeTradesPage.getTextFromUsedAmountField()).contains(EXPECTED_AMOUNT_VALUE);
        Assertions.assertThat(activeTradesPage.getTextFromProfitAmountField()).contains(EXPECTED_AMOUNT_VALUE);
        Assertions.assertThat(activeTradesPage.getTextFromResultAmountField()).contains(EXPECTED_AMOUNT_VALUE);
    }
}
