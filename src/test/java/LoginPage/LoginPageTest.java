package LoginPage;

import base.Base;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pagelibraries.LoginPageLib;
import pageobjects.HomePagePO;
import pageobjects.LoginPagePO;

public class LoginPageTest extends Base {
    private static final Logger log = LogManager.getLogger();
    @BeforeClass
    public void setUp(){
        startBrowser();
        log.info("starting browser successfully");
    }

    @Test
    public void loginPageTest(){
        HomePagePO homePage=new HomePagePO(driver);
        homePage.loginBtn().click();
        LoginPageLib loginLib=new LoginPageLib(driver);
        loginLib.login();
        LoginPagePO LoginPage=new LoginPagePO(driver);
        try{
        Assert.assertEquals(LoginPage.loginerror().toString().contains("login-error"),false);
        log.info("login was verified successfully");
        }catch (AssertionError e){
            log.error("login failed test"+e);
            Assert.fail("login failed test"+e);
        }

    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }
}
