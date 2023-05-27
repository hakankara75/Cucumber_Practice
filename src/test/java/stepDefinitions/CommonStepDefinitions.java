package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import pages.Twitter;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class CommonStepDefinitions {

    Twitter twitter=new Twitter();
    @And("{int} saniye bekle")
    public void saniyeBekle(int arg0) {
        ReusableMethods.bekle(arg0);
    }

    @Given("kullanici {string} sitesine gider")
    public void kullaniciSitesineGider(String arg0) {
        ReusableMethods.extentReport();
        try {
            Driver.getDriver().get(ConfigReader.getProperty("twitter"));

        }catch (Exception e) {
            twitter.yenile.click();
        }


        ReusableMethods.extentTestInfo("kullanici \"https://www.twitter.com/\" sitesine gider");
    }
}
