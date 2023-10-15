package base;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Base {
    public WebDriver driver;
    public void startBrowser() {
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
        String browser=prop.getProperty("browser");
        String url=prop.getProperty("url");
        String driverPath=new File("").getAbsolutePath() + File.separator + "drivers\\";

        if(browser.equals("firefox")){
            System.setProperty("webdriver.gecko.driver",driverPath+"\\geckodriver.exe");
            driver=new FirefoxDriver();
        }else if(browser.equals("chrome")){
            System.setProperty("webdriver.chrome.driver",driverPath+"\\chromedriver.exe");
            driver=new ChromeDriver();
        }else if(browser.equals("ie")){
            System.setProperty("webdriver.ie.driver",driverPath+"\\IEDriverServer.exe");
            driver=new InternetExplorerDriver();
        }
        driver.get(url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public void takeScreenShot(String screenshotname,WebDriver driver) throws IOException {
        TakesScreenshot ts= (TakesScreenshot)driver;
        File srcFile = ts.getScreenshotAs(OutputType.FILE);
        File desFile=new File(System.getProperty("user.dir")+"//Screenshots//"+screenshotname+".png");
        FileHandler.copy(srcFile,desFile);
    }

}
