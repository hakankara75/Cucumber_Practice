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
        for (int i = 1; i < 81; i++) {
            Driver.getDriver().findElement(By.xpath("(//div[@id='faceted-search-group-2']//div[@class='row'])["+i+"]")).click();
            Driver.getDriver().navigate().back();
           // System.out.println("Driver.getDriver().findElement(By.xpath(\"//div[@class='publisher']//a[contains(@class,'alt')]//text()[normalize-space()][\"+i+\"]\")).getText() = " + Driver.getDriver().findElement(By.xpath("//div[@class='publisher']//a[contains(@class,'alt')]//text()[normalize-space()][" + i + "]")).getText());
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
