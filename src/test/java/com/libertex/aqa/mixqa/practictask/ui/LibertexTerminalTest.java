package com.libertex.aqa.mixqa.practictask.ui;

import com.libertex.aqa.mixqa.practictask.ui.pages.LibertexTerminalInstrumentTradePage;
import com.libertex.aqa.mixqa.practictask.ui.pages.LibertexTerminalProfilePage;
import com.libertex.aqa.mixqa.practictask.ui.pages.LibertexTerminalActiveTradesPage;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

public class LibertexTerminalTest extends BaseTestUI {
    protected LibertexTerminalProfilePage libertexTerminalProfilePage = new LibertexTerminalProfilePage();
    protected LibertexTerminalInstrumentTradePage libertexTerminalInstrumentTradePage = new LibertexTerminalInstrumentTradePage();
    protected LibertexTerminalActiveTradesPage libertexTerminalActiveTradesPage = new LibertexTerminalActiveTradesPage();

    @Test(description = "Test open and close trade in the Libertex Terminal")
    public void testOpenAndCloseTradeInLibertexTerminal()  {

        libertexTerminalMainPage.clickLoginButton();

        libertexTerminalLoginPage.inputCredentials(email, password);
        libertexTerminalLoginPage.clickLoginButton();

        libertexTerminalProfilePage.clickOnBuyTabForDefaultInstrument();

        libertexTerminalInstrumentTradePage.openDefaultInstrumentTrade();
        libertexTerminalInstrumentTradePage.waitingForNotification();

        Assertions.assertThat(libertexTerminalInstrumentTradePage.getTextFromOpenedTradeField()).contains("Successful trade! Your balance will be updated shortly.");

        libertexTerminalProfilePage.clickOnActiveTradesButton();

        libertexTerminalActiveTradesPage.clickCloseAllTradesMenuButton();
        libertexTerminalActiveTradesPage.clickCloseAllTradesButton();
        libertexTerminalActiveTradesPage.clickCloseOutButton();
        libertexTerminalActiveTradesPage.waitingForSuccessfulCloseOutNotification();

        Assertions.assertThat(libertexTerminalActiveTradesPage.getTextFromSuccessfulCloseOutNotificationField()).contains("All trades have been closed!");

        libertexTerminalActiveTradesPage.clickGoBackToTradingButton();

        Assertions.assertThat(libertexTerminalActiveTradesPage.getTextFromUsedAmountField()).contains("0.00");

        Assertions.assertThat(libertexTerminalActiveTradesPage.getTextFromProfitAmountField()).contains("0.00");

        Assertions.assertThat(libertexTerminalActiveTradesPage.getTextFromResultAmountField()).contains("0.00");

    }
}
