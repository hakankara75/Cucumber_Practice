package pages;


import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ExcelUtils;
import utilities.ReusableMethods;

public class Hooks {

  /*
Her bir Scenario'dan önce yada sonra çalışmasını istediğimiz metotları @Before ve @After kullanarak bu classın içerisine koyuyoruz.
Burada daha çok raporlama için kodlar kullacağız.
Screenshot alinip rapora koyulur
asagida hata alinirsa screenshot yapilacagina dair metot var
 */

    //features/day30_IlkFeature/US003_RunnerKullanimi.feature dosyasi asagida ornek olarak calisildi
    @Before ("All")
    public void setup(){
        System.out.println("Before Methodu");

    }
    @Before ("@gr1")
    public void setup1(){
        System.out.println("Amazonda SQL aratildi");

    }
    @Before ("@gr2")
    public void setup2(){
        System.out.println("Amazonda Java aratildi");

    }
    @Before ("@gr3")
    public void setup3(){
        System.out.println("Amazonda Selenium aratildi");

    }


    @After
    public void teardown(Scenario scenario){// bu class yardimci olacak
        //Eger scenario failed olursa alinan ekran goruntusu rapora eklenecek.
        final byte[] failedScreenShot=((TakesScreenshot)Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
        if (scenario.isFailed()){
            TakesScreenshot ts= (TakesScreenshot) Driver.getDriver();
            scenario.attach(failedScreenShot,"image/png", "failed_scenario"+scenario.getName());

        }
        Driver.closeDriver();

    }

}
