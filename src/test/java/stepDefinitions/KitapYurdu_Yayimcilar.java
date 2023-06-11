package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.CokSatanKitaplar_Edebiyat_Kitapyurdu;
import utilities.Driver;
import utilities.ExcelUtils;
import utilities.ReusableMethods;

import java.util.List;

public class KitapYurdu_Yayimcilar {
    CokSatanKitaplar_Edebiyat_Kitapyurdu edebiyatKitapyurdu= new CokSatanKitaplar_Edebiyat_Kitapyurdu();
    String dosyaYolu= "src/test/java/resources/mysmoketestdata.xlsx";
    String sayfaAdi= "sayfa";


    @Then("kullanici yayinci kategorisinden yayimevlerini sirayla secer")
    public void kullaniciYayinciKategorisindenYayimevleriniSiraylaSecer() {
        for (int i = 1; i < 81; i++) {
            Driver.getDriver().findElement(By.xpath("(//div[@id='faceted-search-group-2']//div[@class='row'])["+i+"]")).click();
            List<WebElement> kitapElements= Driver.getDriver().findElements(By.xpath("//div[@class='name ellipsis']"));


            //Excel ile baglanti kurdum
            ExcelUtils excelUtils = new ExcelUtils(dosyaYolu,sayfaAdi );
            for (int k = 1; k <= kitapElements.size(); k++) {
                //Excel'de sayfa olusturdum
                String sayfa=sayfaAdi+""+i;
                try {
                    ReusableMethods.addSheetToExcel(dosyaYolu,sayfa);
                } catch (Exception e) {

                }
                try {
                    excelUtils.setCellData(kitapElements.get(k).getText(), k, 0);
                } catch (Exception e) {

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
}
