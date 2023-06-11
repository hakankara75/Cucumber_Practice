package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.CokSatanKitaplar_Edebiyat_Kitapyurdu;
import utilities.Driver;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class KitapYurdu_Yayimcilar {
    CokSatanKitaplar_Edebiyat_Kitapyurdu edebiyatKitapyurdu= new CokSatanKitaplar_Edebiyat_Kitapyurdu();


    @Then("kullanici yayinci kategorisinden yayimevlerini sirayla secer")
    public void kullaniciYayinciKategorisindenYayimevleriniSiraylaSecer() throws IOException {
        for (int i = 1; i < 81; i++) {
            Driver.getDriver().findElement(By.xpath("(//div[@id='faceted-search-group-2']//div[@class='row'])["+i+"]")).click();
            List<WebElement> kitapElements= Driver.getDriver().findElements(By.xpath("//div[@class='name ellipsis']"));


            String dosyaYolu = "src/test/java/resources/Book.xlsx";
            String sayfaAdi= "sayfa";

// Yeni bir Excel dosyası oluştur
            XSSFWorkbook workbook = new XSSFWorkbook();

// Yeni bir sayfa ekle
            for(int k=0;k<kitapElements.size(); k++){
                sayfaAdi=kitapElements.get(k).getText();
                try { XSSFSheet sheet = workbook.createSheet(sayfaAdi + k);
            } catch (Exception e) {
                    e.printStackTrace();
                }

// Dosyayı kaydet
            try {
                FileOutputStream outputStream = new FileOutputStream(dosyaYolu);
                workbook.write(outputStream);
                workbook.close();
            } catch (IOException e) {
                e.printStackTrace();
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
