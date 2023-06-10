package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.CokSatanKitaplar_Edebiyat_Kitapyurdu;
import utilities.Driver;

import java.util.List;

public class KitapYurdu_Yayimcilar {
    CokSatanKitaplar_Edebiyat_Kitapyurdu edebiyatKitapyurdu= new CokSatanKitaplar_Edebiyat_Kitapyurdu();

    @Then("kullanici yayinci kategorisinden yayimevlerini sirayla secer")
    public void kullaniciYayinciKategorisindenYayimevleriniSiraylaSecer() {
        for (int i = 201; i < 362; i++) {
            Driver.getDriver().findElement(By.xpath("(//div[@class='row']//span[text()=.])["+i+"]")).click();
            System.out.println("edebiyatKitapyurdu.yayimevi = " + edebiyatKitapyurdu.yayimevi.getText());
        }


    }

    @And("kullanici sectigi yayimciya gore goruntulenen kitaplarin degistigini dogrular")
    public void kullaniciSectigiYayimciyaGoreGoruntulenenKitaplarinDegistiginiDogrular() {

        List<WebElement> kitaplarList= (List<WebElement>) edebiyatKitapyurdu.kitaplarList;
        for (WebElement kitaplar : kitaplarList){
            kitaplar.getText();

        }

    }

    @And("kullanici goruntulenen kitaplarin sectigi yayimcinin kitaplari oldugunu dogrular")
    public void kullaniciGoruntulenenKitaplarinSectigiYayimcininKitaplariOldugunuDogrular() {

        Driver.closeDriver();
    }
}
