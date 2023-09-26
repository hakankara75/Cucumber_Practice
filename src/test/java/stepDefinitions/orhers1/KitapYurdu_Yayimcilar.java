package stepDefinitions.orhers1;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.others1.CokSatanKitaplar_Edebiyat_Kitapyurdu;
import utilities.Driver;
import utilities.ExcelUtils;
import utilities.ReusableMethods;

import java.util.List;

public class KitapYurdu_Yayimcilar {
    CokSatanKitaplar_Edebiyat_Kitapyurdu edebiyatKitapyurdu= new CokSatanKitaplar_Edebiyat_Kitapyurdu();
    ExcelUtils excelUtils;
    String dosyaYolu = "src/test/java/resources/Book.xlsx";
    String sayfaAdi = "sayfa";
    XSSFWorkbook workbook = new XSSFWorkbook();
    XSSFSheet sheet = workbook.createSheet(sayfaAdi );


    @Then("kullanici yayinci kategorisinden yayimevlerini sirayla secer")
    public void kullaniciYayinciKategorisindenYayimevleriniSiraylaSecer() throws Exception {
        for (int i = 1; i < 81; i++) {
            //yayınevlerini sırayla tiklamak icin komut
            Driver.getDriver().findElement(By.xpath("(//div[@id='faceted-search-group-2']//div[@class='row'])[" + i + "]")).click();

            //Acilan sayfada yayinevini almak icin komut
            WebElement publisherFilter = Driver.getDriver().findElement(By.id("publisher-filters-div")).findElement(By.className("facet-name"));


            //acilan yayinevine ait kitaplari listeye alma komutu
            List<WebElement> kitapElements = edebiyatKitapyurdu.ellips;

            // yukarida alinan yayinevi sayfa adi olarak atanacak
            String sayfaAdi = publisherFilter.getText();
            System.out.println("sayfaAdi = " + sayfaAdi);

            ReusableMethods.excellSayfaAdiVerme(dosyaYolu,sayfaAdi);

            // Kitap elementlerinin sayısını al
            int kitapElementSayisi = kitapElements.size();

            // For döngüsü ile kitapları Excel'e yaz

            int sayac= 0;
            for (int j = 0; j < kitapElementSayisi; j++) {
                try {
                    excelUtils = new ExcelUtils(dosyaYolu, sayfaAdi);
                    excelUtils.setCellData(kitapElements.get(j).getText(), j, 0);
                }catch (Exception e) {

                }

            }

            Driver.getDriver().navigate().back();
        }
    }



    @And("kullanici sectigi yayimciya gore goruntulenen kitaplarin degistigini dogrular")
    public void kullaniciSectigiYayimciyaGoreGoruntulenenKitaplarinDegistiginiDogrular() {

        List<WebElement> kitaplarList= (List<WebElement>) edebiyatKitapyurdu.kitaplarList;
        for (WebElement kitaplar : kitaplarList){
            System.out.println("kitaplar.getText() = " + kitaplar.getText());

        }

    }

    @And("kullanici goruntulenen kitaplarin sectigi yayimcinin kitaplari oldugunu dogrular")
    public void kullaniciGoruntulenenKitaplarinSectigiYayimcininKitaplariOldugunuDogrular() {

        Driver.closeDriver();
    }

    @And("cok satan edebiyat kitaplari linkine sol klik yapar")
    public void cokSatanEdebiyatKitaplariLinkineSolKlikYapar() {
        ReusableMethods.webelementJavaScript("document.querySelector(\"#mainNav > div.nav-content > ul > li.book.has-menu.active > div.lvl2.js-bookCr > ul > li:nth-child(1) > div > div.open-menu-ct.bookBestSeller > div.subCategories > ul:nth-child(2) > li:nth-child(1) > a > strong\")").click();

        ReusableMethods.excellSayfaAdiVerme(sayfaAdi, dosyaYolu);


    }



}


