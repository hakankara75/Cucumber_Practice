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

                    System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chromedriver-win64\\chromedriver.exe");
                    ChromeOptions options= new ChromeOptions();
                    options.addArguments("--headless"); // Headless test yapmak icin
                    options.addArguments("--disaple-gpu"); //GPU kullanimini devre disi birakir
                    //driver= new ChromeDriver(options); //bu kodu headless testte acarsinizi

                    //asagidaki kodlar file download yaparken default deger olan download klasoru yerine bir yol vermemize yarar
//                    ChromeOptions options = new ChromeOptions();
//                    String filePath ="C:\\Hakan Arsiv";
//                    Map<String, Object> prefs = new HashMap<>();
//                    prefs.put("download.default_directory", filePath);
//                    options.setExperimentalOption("prefs", prefs);
                    //  driver = new ChromeDriver(options);  //bu satirdaki yorum slashlarini bir alt satira indirip calistirmaliyiz.

                    driver = new ChromeDriver(options);
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