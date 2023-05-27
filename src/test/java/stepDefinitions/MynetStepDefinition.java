package stepDefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import pages.MynetPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import static org.testng.AssertJUnit.assertFalse;
import static org.testng.AssertJUnit.assertTrue;

public class MynetStepDefinition {

    MynetPage mynetPage=new MynetPage();
    String secondPageHandle="";
    String firstPageHandle="";
    @Given("kullanici {string} sitesine gider")
    public void kullaniciSitesineGider(String arg0) {
        Driver.getDriver().get(ConfigReader.getProperty("mynet"));
        String firstPageHandle= Driver.getDriver().getWindowHandle();
    }

    @Then("kullanici egitim linkini tiklar")
    public void kullaniciEgitimLinkiniTiklar() {
        mynetPage.egitim.click();
    }

    @And("universite taban puanlarina kadar sayfayi asagi goruturur")
    public void universiteTabanPuanlarinaKadarSayfayiAsagiGoruturur() {
                ReusableMethods.scrollToElementWithWebElement(mynetPage.universiteBolumleri);
    }


    @Then("sayisal bolumlerin taban puanlari linkine tiklar")
    public void sayisalBolumlerinTabanPuanlariLinkineTiklar() {
        mynetPage.sayisalBolumler.click();
    }


    @And("acilan sayfanin {string} icerdigini dogrular")
    public void acilanSayfaninIcerdiginiDogrular(String arg0) {
        assertTrue(mynetPage.baslik.getText().contains(arg0));
        ReusableMethods.pageDown();
    }

    @Then("tip linkini tiklar")
    public void tipLinkiniTiklar() {
        mynetPage.tip.click();
    }

    @And("yeni acilan sayfaya gecis yapar")
    public void yeniAcilanSayfayaGecisYapar() {
        ReusableMethods.switchToWindow(1);

    }

    @Then("yeni sayfaya gectigini dogrular")
    public void yeniSayfayaGectiginiDogrular() {
        String secondPageHandle= Driver.getDriver().getWindowHandle();
        assertFalse(secondPageHandle.equals(firstPageHandle));
    }

    @And("sayfa basliginda {string} oldugunu dogrular")
    public void sayfaBasligindaOldugunuDogrular(String arg0) {
        String sayfaBasligi=Driver.getDriver().getTitle();
        System.out.println(sayfaBasligi);
        assertTrue(sayfaBasligi.contains(arg0));
    }

    @And("testi bitirir")
    public void testiBitirir() {

    }
}
