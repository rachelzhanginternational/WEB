package org.example;

import base.Base;
import org.testng.annotations.Test;
import pagelibraries.LoginPageLib;
import pageobjects.HomePagePO;
import pageobjects.LoginPagePO;

import java.io.IOException;

public class NewTest extends Base {
    @Test
    public void testStartBrowser() throws IOException {
        startBrowser();
        HomePagePO homepage=new HomePagePO(driver);
        homepage.loginBtn().click();
        LoginPageLib loginlib=new LoginPageLib(driver);
        loginlib.login();

    }
}
