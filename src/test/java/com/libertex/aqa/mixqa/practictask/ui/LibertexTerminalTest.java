package com.libertex.aqa.mixqa.practictask.ui;


import com.codeborne.selenide.Condition;
import com.libertex.aqa.mixqa.practictask.ui.pages.LibertexTerminalInstrumentTradePage;
import com.libertex.aqa.mixqa.practictask.ui.pages.LibertexTerminalProfilePage;
import org.testng.annotations.Test;

public class LibertexTerminalTest extends BaseTest{

    protected LibertexTerminalProfilePage libertexTerminalProfilePage = new LibertexTerminalProfilePage();

    protected LibertexTerminalInstrumentTradePage libertexTerminalInstrumentTradePage = new LibertexTerminalInstrumentTradePage();

    @Test(description = "Test open trade in the Libertex Terminal")
    public void testLibertexTerminal()  {


        libertexTerminalMainPage.clickLoginButton();

        libertexTerminalLoginPage.inputCredentials(email, password);
        libertexTerminalLoginPage.clickLoginButton();

        libertexTerminalProfilePage.clickOnBuyTabForDefaultInstrument();

        libertexTerminalInstrumentTradePage.openDefaultInstrumentTrade();
        libertexTerminalInstrumentTradePage.waitingForNotification();
        libertexTerminalInstrumentTradePage.getNotificationField().shouldHave(Condition.text("Successful trade! Your balance will be updated shortly."));
    }
}
