package HomePage;

import base.Base;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.*;
import pageobjects.HomePagePO;
import pageobjects.LoginPagePO;

import java.util.concurrent.TimeUnit;


public class HomePageTest extends Base {
    private static final Logger log = LogManager.getLogger();
    @BeforeClass
    public void setUp(){
        startBrowser();
        log.info("starting browser successfully");
    }

    @Test
    public void homePageTest() {
        HomePagePO homepage=new HomePagePO(driver);
        homepage.loginBtn().click();
        LoginPagePO loginPage=new LoginPagePO(driver);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        try{
        Assert.assertEquals(loginPage.username().toString().contains("loginUserName"),true);
        log.info("home page passed test");
        }catch (AssertionError e){
            log.error("home page failed test"+e);
            Assert.fail("home page failed test"+e);

        }

    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
