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


    @Then("kullanici egitim linkini tiklar")
    public void kullaniciEgitimLinkiniTiklar() {
        firstPageHandle= Driver.getDriver().getWindowHandle();
        mynetPage.egitim.click();
        ReusableMethods.extentTestInfo("kullanici egitim linkini tiklar");
    }

    @And("universite taban puanlarina kadar sayfayi asagi goruturur")
    public void universiteTabanPuanlarinaKadarSayfayiAsagiGoruturur() {
                ReusableMethods.scrollToElementWithWebElement(mynetPage.universiteBolumleri);
        ReusableMethods.extentTestInfo("universite taban puanlarina kadar sayfayi asagi goruturur");
    }


    @Then("sayisal bolumlerin taban puanlari linkine tiklar")
    public void sayisalBolumlerinTabanPuanlariLinkineTiklar() {
        try{
            mynetPage.sayisalBolumler.click();
        }catch (Exception e){

        }
        ReusableMethods.extentTestInfo("sayisal bolumlerin taban puanlari linkine tiklar");
    }


    @And("acilan sayfanin {string} icerdigini dogrular")
    public void acilanSayfaninIcerdiginiDogrular(String arg0) {
        assertTrue(mynetPage.baslik.getText().contains(arg0));
        ReusableMethods.extentTestInfo("acilan sayfanin \"Sayısal Bölümler\" icerdigini dogrular");
        ReusableMethods.pageDown();
    }

    @Then("tip linkini tiklar")
    public void tipLinkiniTiklar() {
        mynetPage.tip.click();
        ReusableMethods.extentTestInfo("tip linkini tiklar");
    }

    @And("yeni acilan sayfaya gecis yapar")
    public void yeniAcilanSayfayaGecisYapar() {
        ReusableMethods.switchToWindow(1);
        ReusableMethods.extentTestInfo("yeni acilan sayfaya gecis yapar");

    }

    @Then("yeni sayfaya gectigini dogrular")
    public void yeniSayfayaGectiginiDogrular() {
        secondPageHandle= Driver.getDriver().getWindowHandle();
        assertFalse(secondPageHandle.equals(firstPageHandle));
        ReusableMethods.extentTestInfo("yeni sayfaya gectigini dogrular");
    }

    @And("sayfa basliginda {string} oldugunu dogrular")
    public void sayfaBasligindaOldugunuDogrular(String arg0) {
        String sayfaBasligi=Driver.getDriver().getTitle();
        System.out.println(sayfaBasligi);
        assertTrue(sayfaBasligi.contains(arg0));
        ReusableMethods.extentTestInfo("sayfa basliginda \"Tıp\" oldugunu dogrular");
    }

    @And("testi bitirir")
    public void testiBitirir() {
        ReusableMethods.extentTestInfo("testi bitirir");
        ReusableMethods.extentRaporBitir();
    }
}
