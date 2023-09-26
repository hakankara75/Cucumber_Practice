package stepDefinitions.orhers1;

import io.cucumber.java.en.Then;
import pages.others1.KitapYurdu;
import utilities.ReusableMethods;

import static org.junit.Assert.assertTrue;


public class KitapYurduStepDefinition {
    KitapYurdu kitapYurdu=new KitapYurdu();


    @Then("Kullanıcı cok satan kitaplar menusu ustune gider")
    public void kullanıcı_cok_satan_kitaplar_menusu_ustune_gider() {
        ReusableMethods.moveToElementWithAction(kitapYurdu.cokSatanKitaplar);
    }
    @Then("Kullanıcı cok satan edebiyat kitaplari menusunu tiklar")
    public void kullanıcı_cok_satan_edebiyat_kitaplari_menusunu_tiklar() {
        kitapYurdu.cokSatanEdebiyatKitaplari.click();
    }
    @Then("Kullanıcı {int} dropdown'indan {int} urun ayni anda goruntulenmesini secer tıklar")
    public void kullanıcı_dropdown_indan_urun_ayni_anda_goruntulenmesini_secer_tıklar(Integer int1, Integer int2) {
        kitapYurdu.varsayilan.click();
        ReusableMethods.ddmIndex(kitapYurdu.varsayilan, 5);


    }
    @Then("Kullanıcı varsayilan dropdown'indan ucuzdan pahaliya secenegini secer")
    public void kullanıcı_varsayilan_dropdown_indan_ucuzdan_pahaliya_secenegini_secer() {
        kitapYurdu.yirmiUrun.click();
        ReusableMethods.ddmIndex(kitapYurdu.yirmiUrun, 4);


    }
    @Then("Kullanıcı sayfadaki ilk urunun fiyatinin son urunun fiyatindan dusuk oldugunu dogrular")
    public void kullanıcı_sayfadaki_ilk_urunun_fiyatinin_son_urunun_fiyatindan_dusuk_oldugunu_dogrular() {
        Integer ilkFiyat= Integer.valueOf(kitapYurdu.ilkUrun.getText().trim().replaceAll(",",""));
        System.out.println(ilkFiyat);
        Integer sonFiyat= Integer.valueOf(kitapYurdu.sonUrun.getText().trim().replaceAll(",",""));
        System.out.println(sonFiyat);
        assertTrue(ilkFiyat<sonFiyat);

    }

}
