package com.libertex.aqa.mixqa.practictask.ui;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.libertex.aqa.mixqa.practictask.ui.pages.LibertexTerminalLoginPage;
import com.libertex.aqa.mixqa.practictask.ui.pages.LibertexTerminalMainPage;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import static com.codeborne.selenide.Selenide.$;

;

public class BaseTest {

    protected LibertexTerminalMainPage libertexTerminalMainPage = new LibertexTerminalMainPage();

    protected LibertexTerminalLoginPage libertexTerminalLoginPage = new LibertexTerminalLoginPage();

    String email = PropertyReader.getProperty("UIcredentials.email");

    String password = PropertyReader.getProperty("UIcredentials.password");


    @BeforeSuite
    public void setupBrowser() {

        //Configuration.browser = System.getProperty("browser");
        Configuration.browser = System.getProperty("browser");
    }

    @BeforeTest
    public void openLibertexTerminal() {

        Selenide.open(System.getProperty("BASE_URL"));

        $((By.xpath("//span[contains(@class, 'login-btn')]"))).shouldBe(Condition.visible);
    }
}
