package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import pages.CokSatanKitaplar_Edebiyat_Kitapyurdu;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ExcelUtils;
import utilities.ReusableMethods;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class CokSatanKitaplar_Hakan_StepDefinition {

    CokSatanKitaplar_Edebiyat_Kitapyurdu locate = new     CokSatanKitaplar_Edebiyat_Kitapyurdu();



    Select select;
    String selectZaman;
    String ilkKitap = "";
    String ikinciKitap = "";
    String ucuncuKitap = "";
    ExcelUtils excelUtils=new ExcelUtils(ConfigReader.getProperty("excelDosyaYolu"), ConfigReader.getProperty("excelSayfaAdi"));

    @Given("kullanici cok satan kitaplar menusu ustune gelir")
    public void kullaniciCokSatanKitaplarMenusuUstuneGelir() {
        WebElement element = ReusableMethods.webelementJavaScript("document.querySelector(\"#mainNav > div.nav-content > ul > li.book.has-menu.active > div.lvl2.js-bookCr > ul > li:nth-child(1)\")");
        ReusableMethods.moveToElementWithAction(element);
    }

    @And("edebiyat butonunun secilmis oldugunu dogrular")
    public void edebiyatButonununSecilmisOldugunuDogrular() {

        assertTrue(locate.edebiyatButonu.getAttribute("class").equals("button"));

    }

    @Then("yirmi urun dropdownina tiklar")
    public void yirmiUrunDropdowninaTiklar() {
        locate.yirmiUrun.click();
    }

    @Then("edebiyat butonunun resmini ceker")
    public void edebiyatButonununResminiCeker() {
        ReusableMethods.webElementScreenShoot(locate.edebiyatButonu);
    }
    @And("satista olanlar checkboxinin secili oldugunu dogrular")
    public void satistaOlanlarCheckboxininSeciliOldugunuDogrular() {
        assertTrue(locate.satistaOlanlar.isSelected());
    }

    @And("yuz urunu secer")
    public void yuzUrunuSecer() {
        Select select=new Select(locate.yirmiUrun);
        select.selectByVisibleText("100 Ürün");
    }

    @And("yuz urun seceneginin secildigini dogrular")
    public void yuzUrunSecenegininSecildiginiDogrular() {
        assertTrue(locate.yuzUrun.isEnabled());
    }

    @And("sayfada yuz urun gorundugunu dogrular")
    public void sayfadaYuzUrunGorundugunuDogrular() {
        int expectedKitapSayisi=100;
        int actualKitapSayisi= Driver.getDriver().findElements(By.xpath("//div[@class='image']")).size();
        assertTrue(expectedKitapSayisi==actualKitapSayisi);

    }

    @Then("kullanici zaman araligi dropdown'inin secilebilir oldugunu dogrular")
    public void kullaniciZamanAraligiDropdownIninSecilebilirOldugunuDogrular() {
        assertTrue(locate.zamanAraligi.isEnabled());
    }


    @And("kullanici zaman araligi dropdown'inindan {string} secenegini secer")
    public void kullaniciZamanAraligiDropdownInindanSeceneginiSecer(String str) {
        select=new Select(locate.zamanAraligi);
        select.selectByVisibleText(str);
        selectZaman=str;

        if (selectZaman.equals("Haftalık")) {
            excelUtils.setCellData(locate.kitaplar.getText(),1,0);

        }
        if (selectZaman.equals("Aylık")) {
            excelUtils.setCellData(locate.kitaplar.getText(),2,0);

       }
        if (selectZaman.equals("Yıllık"))  {
            excelUtils.setCellData(locate.kitaplar.getText(),3,0);

        }


    }

    @Then("Sayfanin resmini ceker")
    public void sayfaninResminiCeker() {
        ReusableMethods.tumSayfaScreenShoot();
    }

    @And("{int} saniye bekleme yapar")
    public void saniyeBeklemeYapar(int arg0) {
        ReusableMethods.bekle(arg0);
    }

    @Then("acilan menude cok satan edebiyat kitaplari linki oldugunu dogrular")
    public void acilanMenudeCokSatanEdebiyatKitaplariLinkiOldugunuDogrular() {
        ReusableMethods.assertIsEnabled("document.querySelector(\"#mainNav > div.nav-content > ul > li.book.has-menu.active > div.lvl2.js-bookCr > ul > li.has-open-menu.selected > div > div.open-menu-ct.bookBestSeller > div.subCategories > ul:nth-child(2) > li:nth-child(1) > a\")");

    }

    @And("cok satan edebiyat kitaplari linkini tiklar")
    public void cokSatanEdebiyatKitaplariLinkiniTiklar() {
        ReusableMethods.webelementJavaScript("document.querySelector(\"#mainNav > div.nav-content > ul > li.book.has-menu.active > div.lvl2.js-bookCr > ul > li:nth-child(1) > div > div.open-menu-ct.bookBestSeller > div.subCategories > ul:nth-child(2) > li:nth-child(1) > a > strong\")").click();

    }

    @When("kullanici cok satan edebiyat kitaplari sayfasinda oldugunu dogrular")
    public void kullaniciCokSatanEdebiyatKitaplariSayfasindaOldugunuDogrular() {

            assertTrue(Driver.getDriver().getTitle().contains("Çok Satan Kitaplar"));


    }

    @Then("kullanici secim sonucu goruntulenen kitaplarin degistigini dogrular")
    public void kullaniciSecimSonucuGoruntulenenKitaplarinDegistiginiDogrular() {

       String ilkKitapExcell= excelUtils.getCellData(1, 0);
        String ikinciKitapExcell= excelUtils.getCellData(2, 0);
        String ucuncuKitapExcell= excelUtils.getCellData(3, 0);

        if(ilkKitapExcell.length()>3 && ikinciKitapExcell.length()>3 && ucuncuKitapExcell.length()>3 ){


            assertFalse(ilkKitapExcell.contains(ikinciKitapExcell));
            assertFalse(ilkKitapExcell.contains(ucuncuKitapExcell));
            assertFalse(ikinciKitapExcell.contains(ucuncuKitapExcell));
    }


    }
}

