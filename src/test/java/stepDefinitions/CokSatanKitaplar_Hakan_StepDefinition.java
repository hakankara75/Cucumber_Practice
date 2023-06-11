package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import pages.CokSatanKitaplar_Edebiyat_Kitapyurdu;
import pojo.EdebiyatKitaplariPojo;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ExcelUtils;
import utilities.ReusableMethods;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static utilities.ReusableMethods.*;


public class CokSatanKitaplar_Hakan_StepDefinition {

    CokSatanKitaplar_Edebiyat_Kitapyurdu locate = new CokSatanKitaplar_Edebiyat_Kitapyurdu();
    private static Connection connection;
    private static java.sql.Statement statement;
    private static ResultSet resultSet;

    Select select;
    String selectZaman;
    String ilkKitap = "";
    String ikinciKitap = "";
    String ucuncuKitap = "";

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
        Select select = new Select(locate.yirmiUrun);
        select.selectByVisibleText("100 Ürün");
    }

    @And("yuz urun seceneginin secildigini dogrular")
    public void yuzUrunSecenegininSecildiginiDogrular() {
        assertTrue(locate.yuzUrun.isEnabled());
    }

    @And("sayfada yuz urun gorundugunu dogrular")
    public void sayfadaYuzUrunGorundugunuDogrular() {
        int expectedKitapSayisi = 100;
        int actualKitapSayisi = Driver.getDriver().findElements(By.xpath("//div[@class='image']")).size();
        assertTrue(expectedKitapSayisi == actualKitapSayisi);

        Driver.closeDriver();
    }

    @Then("kullanici zaman araligi dropdown'inin secilebilir oldugunu dogrular")
    public void kullaniciZamanAraligiDropdownIninSecilebilirOldugunuDogrular() {
        assertTrue(locate.zamanAraligi.isEnabled());
    }


    @And("kullanici zaman araligi dropdown'inindan {string} secenegini secer")
    public void kullaniciZamanAraligiDropdownInindanSeceneginiSecer(String str) {
        select = new Select(locate.zamanAraligi);
        select.selectByVisibleText(str);
        selectZaman = str;

        //select sonucu olusan veriyi excel'e yukleyip kaydetme
        ExcelUtils excelUtils = new ExcelUtils("src/test/java/techproed/resources/mysmoketestdata.xlsx", "sayfa");
        if (selectZaman.equals("Haftalık")) {
            excelUtils.setCellData("", 1, 0);
            excelUtils.setCellData(locate.kitaplar.getText(), 1, 0);

        }
        if (selectZaman.equals("Aylık")) {
            excelUtils.setCellData("", 2, 0);
            excelUtils.setCellData(locate.kitaplar.getText(), 2, 0);

        }
        if (selectZaman.equals("Yıllık")) {
            excelUtils.setCellData("", 3, 0);
            excelUtils.setCellData(locate.kitaplar.getText(), 3, 0);

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
        ExcelUtils excelUtil = new ExcelUtils("src/test/resources/kitapyurdu.xlsx", "Sayfa1");
        String ilkKitapExcell = excelUtil.getCellData(1, 0);
        String ikinciKitapExcell = excelUtil.getCellData(2, 0);
        String ucuncuKitapExcell = excelUtil.getCellData(3, 0);

        if (ilkKitapExcell.length() > 3 && ikinciKitapExcell.length() > 3 && ucuncuKitapExcell.length() > 3) {


            assertFalse(ilkKitapExcell.contains(ikinciKitapExcell));
            assertFalse(ilkKitapExcell.contains(ucuncuKitapExcell));
            assertFalse(ikinciKitapExcell.contains(ucuncuKitapExcell));

            Driver.closeDriver();
        }


    }

    @And("kullanici zaman araligi dropdown'inindan {string} seceneklerini sirayla secer")
    public void kullaniciZamanAraligiDropdownInindanSecenekleriniSiraylaSecer(String str) throws ClassNotFoundException, SQLException, SQLException, SQLException {
        List<EdebiyatKitaplariPojo> kayitlar = new ArrayList<>();

        Class.forName("org.postgresql.Driver");


        //2.adim Database'e baglanma
        Connection con = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/jdbc",
                "postgres",
                ConfigReader.getProperty("postgresPassword"));
        //3. statement
        java.sql.Statement st = con.createStatement();

        //4. adim edebiyatKitaplari tablosu olusturacagim

        try {
            String sql01 = "create table edebiyatkitaplaripojo(id int primary key, isim varchar(30) unique)";
            st.execute(sql01);
        } catch (Exception e) {

        }

        PreparedStatement data = con.prepareStatement("insert into doctors values(?, ?, ?, ?)");

        data.executeBatch(); //tek seferde datalari yollar

        con.close();
        data.close();
        closeConnection();  //2 kapatma komutu yerine bu tek metot yeter.
    }




    @Then("kullanici secim sonucunda kitaplarin degistigini dogrular")
    public void kullaniciSecimSonucundaKitaplarinDegistiginiDogrular() {
        createConnection(); //utilities den metot cagirarak baglanti, dosyayi okuma, ekleme vb. yapiyoruz.
        String sql01 = "select * from edebiyatkitaplaripojo";
        System.out.println("Sutun isimleri " + getColumnNames(sql01));
        List<Object> actualDataId = getColumnData(sql01, "id");
        List<Object> actualDataIsimler = getColumnData(sql01, "isim");

        String ilkKitap = "";
        String ikinciKitap = "";
        String ucuncuKitap = "";
        int sayac = 0;
        for (Object obje : actualDataIsimler) {
            if (sayac == 0) {
                ilkKitap = obje.toString().toLowerCase();

            }
            if (sayac == 1) {
                ikinciKitap = obje.toString().toLowerCase();

            }
            if (sayac == 2) {
                ucuncuKitap = obje.toString().toLowerCase();

            }
            sayac++;
        }

        if (ilkKitap.length() > 2 && ikinciKitap.length() > 2 && ucuncuKitap.length() > 2) {
            try {
                assertFalse(ilkKitap.contains(ikinciKitap));
            } catch (Exception e) {

            }

            try {
                assertFalse(ilkKitap.contains(ucuncuKitap));
            } catch (Exception e) {

            }
            try {
                assertFalse(ikinciKitap.contains(ucuncuKitap));
            } catch (Exception e) {

            }

        }
        closeConnection();
        Driver.closeDriver();
    }


}

