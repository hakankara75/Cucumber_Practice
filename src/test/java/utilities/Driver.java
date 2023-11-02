package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.util.concurrent.TimeUnit;

public class Driver {

    public static WebDriver driver;


    public static WebDriver getDriver(){

        if(driver==null) {

            switch (ConfigReader.getProperty("browser")){

                case "chrome":
                    //System.setProperty("webdriver.chrome.driver","Drivers/chromedriver");
//                    ChromeOptions options = new ChromeOptions();
//                    options.addArguments("--headless"); // Başsız modu etkinleştir
//                    options.addArguments("--disable-gpu"); // GPU kullanımını devre dışı bırak
//
//                    System.setProperty("webdriver.chrome.driver", "path/to/chromedriver.exe"); // Chrome sürücü yolunu belirtin

                    driver = new ChromeDriver();
                    break;

                case "safari":

                    driver = new SafariDriver();
                    break;

                case "firefox":

                    driver = new FirefoxDriver();
                    break;
                case "edge":

                    driver = new EdgeDriver();
                    break;
                case "chrome-headless":

                    driver = new ChromeDriver(new ChromeOptions().setHeadless(true));
                    //bu secenekte chrome acilmadan test kosulur
                    break;
                default:

                    driver = new EdgeDriver();

            }

            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        }
        return driver;
    }

    public static void closeDriver(){

        if(driver!=null) {
            driver.close();
            driver=null;
        }
    }

}