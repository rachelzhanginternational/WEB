package pagelibraries;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageobjects.LoginPagePO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class LoginPageLib extends LoginPagePO {
    public LoginPageLib(WebDriver driver) {
        super(driver);
    }

    public void login() {
        //read properties file
        FileInputStream file= null;
        try {
            file = new FileInputStream("C:\\Reporsitory\\Web UI1.0\\Configs\\GlobalData.properties");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Properties prop=new Properties();
        //load file
        try {
            prop.load(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String username=prop.getProperty("username");
        String password=prop.getProperty("password");
        username().sendKeys(username);
        password().sendKeys(password);
        loginbtn().click();
    }
}
