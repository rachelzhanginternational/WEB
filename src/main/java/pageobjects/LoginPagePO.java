package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPagePO {
    public WebDriver driver;

    public LoginPagePO(WebDriver driver) {
        this.driver = driver;
    }

    By Loginform=By.id("loginForm");
    By username= By.id("loginUserName");
    By password=By.id("loginPassword");
    By loginbtn=By.xpath("/html/body/div[3]/div[3]/button[1]");
    By loginerror=By.id("login-error");

    public WebElement Loginform() {
        return driver.findElement(Loginform);
    }
    public WebElement username() {
        return driver.findElement(username);
    }

    public WebElement password() {
        return driver.findElement(password);
    }
    public WebElement loginbtn() {
        return driver.findElement(loginbtn);
    }

    public WebElement loginerror(){
        return driver.findElement(loginerror);
    }

}
