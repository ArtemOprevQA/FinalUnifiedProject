package com.libertex.aqa.mixqa.practictask.ui;

import com.libertex.aqa.mixqa.practictask.ui.pages.LibertexTerminalActiveTradesPage;
import com.libertex.aqa.mixqa.practictask.ui.pages.LibertexTerminalInstrumentTradePage;
import com.libertex.aqa.mixqa.practictask.ui.pages.LibertexTerminalProfilePage;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

public class LibertexTerminalTest extends BaseTestUI {
    private LibertexTerminalProfilePage ProfilePage = new LibertexTerminalProfilePage();
    private LibertexTerminalInstrumentTradePage InstrumentTradePage = new LibertexTerminalInstrumentTradePage();
    private LibertexTerminalActiveTradesPage ActiveTradesPage = new LibertexTerminalActiveTradesPage();

    @Test(description = "Test of successful login the Libertex Terminal", priority = 1)
    public void testLoginLibertexTerminal() {
        MainPage.clickLoginButton();
        LoginPage.inputCredentials(email, password);
        LoginPage.clickLoginButton();

        Assertions.assertThat(ProfilePage.getFirstInstrument().isDisplayed()).isTrue();
    }

    @Test(description = "Test of successful open a trade", priority = 2)
    public void testOpenATrade() {
        ProfilePage.clickOnBuyTabForDefaultInstrument();
        InstrumentTradePage.openDefaultInstrumentTrade();
        InstrumentTradePage.waitingForNotification();

        Assertions.assertThat(InstrumentTradePage.getTextFromOpenedTradeField()).contains("Successful trade! Your balance will be updated shortly.");
        }

    @Test(description = "Test of successful close a trade", priority = 3)
    public void testCloseATrade() {
        ProfilePage.clickOnActiveTradesButton();
        ActiveTradesPage.clickCloseAllTradesMenuButton();
        ActiveTradesPage.clickCloseAllTradesButton();
        ActiveTradesPage.clickCloseOutButton();
        ActiveTradesPage.waitingForSuccessfulCloseOutNotification();

        Assertions.assertThat(ActiveTradesPage.getTextFromSuccessfulCloseOutNotificationField()).contains("All trades have been closed!");

        ActiveTradesPage.clickGoBackToTradingButton();
        ActiveTradesPage.waitingForSuccessfulUpdateOfClosedTrade();

        Assertions.assertThat(ActiveTradesPage.getTextFromUsedAmountField()).contains("0.00");

        Assertions.assertThat(ActiveTradesPage.getTextFromProfitAmountField()).contains("0.00");

        Assertions.assertThat(ActiveTradesPage.getTextFromResultAmountField()).contains("0.00");
    }
}
