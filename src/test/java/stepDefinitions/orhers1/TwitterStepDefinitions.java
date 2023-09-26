package stepDefinitions.orhers1;

import io.cucumber.java.en.*;
import pages.others1.Twitter;
import utilities.ConfigReader;
import utilities.ReusableMethods;

public class TwitterStepDefinitions {
    Twitter twitter=new Twitter();
    String hastagBir= "";
    String hastagIki= "";
    String hastagUc= "";
    String hastagDort= "";
    String hastagBes= "";
    String tweet= "";
    @Then("kullanici login tusuna basar")
    public void kullanici_login_tusuna_basar() {

    }


    @Then("kullanici giris yap tusuna basar")
    public void kullaniciGirisYapTusunaBasar() {
        try{ twitter.girisYap.click();
    }catch (Exception e){
            twitter.giris.click();
        }
        }

    @And("kullanici eposta kutusuna mail adresini girer")
    public void kullaniciEpostaKutusunaMailAdresiniGirer() {
        ReusableMethods.visibleWait(twitter.epostaGir, 15);
         twitter.epostaGir.sendKeys(ConfigReader.getProperty("email"));
    }

    @And("kullanici ileri tusuna basar")
    public void kullaniciIleriTusunaBasar() {
         twitter.ileri.click();
    }

    @And("kullanici password kutusuna sifresini girer")
    public void kullaniciPasswordKutusunaSifresiniGirer() {
         twitter.sifreGir.sendKeys(ConfigReader.getProperty("password"));
    }

    @And("kullanici sifre girisi sonrasi giris yap tusuna basar")
    public void kullaniciSifreGirisiSonrasiGirisYapTusunaBasar() {
         twitter.sifreSonrasiGirisYap.click();
    }

    @And("kullanici ara tusuna basar")
    public void kullaniciAraTusunaBasar() {


        try{
            twitter.home.click();
        }catch (Exception e) {
            twitter.ara.click();
        }finally {
            twitter.ara.click();
        }



    }


    @And("kullanici hastagleri alir")
    public void kullaniciHastagleriAlir() {
          hastagBir= twitter.hastagBir.getText();
          hastagIki= twitter.hastagIki.getText();
          hastagUc= twitter.hastagUc.getText();
          hastagDort= twitter.hastagDort.getText();
          hastagBes= twitter.hastagBes.getText();
    }

    @And("kullanici tweet at tusuna basar")
    public void kullaniciTweetAtTusunaBasar() {
        for (int i = 1; i < 6; i++) {
            twitter.tweetAt.click();
            switch (i){
                case 1:
                    tweet=hastagBir;

                    break;
                case 2:
                    tweet=hastagIki;

                    break;
                case 3:
                    tweet=hastagUc;
                    break;
                case 4:
                    tweet=hastagDort;
                    break;
                case 5:
                    tweet=hastagBes;
                    break;
                default:
                    break;
            }
//            String farkliYol= System.getProperty("user.home"); //C:\Users\Hakan Batirhan.DESKTOP-KA8SOKR
//            String ortalYol= System.getProperty("/Desktop/Tiens/kordiseps.jpg");
//            String dosyaYolu= farkliYol+ortalYol;

            twitter.tweetYaz.sendKeys("TIENS Kordisep Mantarı  İçeren Kapsül Takviye Edici Gıda Kordiseps Mantarı, " +
                    "olağanüstü doğal bir antibiyotiktir ve ünlü TIANSHI Kordiseps' inin hammaddesidir. " +
                    "Bu mantar; astım, prostat, damar sertliği, bronşit, zatürre, tüberküloz, sarılık, " +
                    "böbrek." +
                    " ");
            twitter.tweetYaz.sendKeys(tweet);
            ReusableMethods.bekle(3);
            twitter.tweetYaz.sendKeys(" " +
                    "");
            twitter.fotografEkle.click();
            ReusableMethods.robotClassDosyaYukleme("C:\\Users\\Hakan Batirhan.DESKTOP-KA8SOKR\\Desktop\\Tiens\\kordiseps.jpg");

            ReusableMethods.bekle(7);
            ReusableMethods.scrollEndByJavaScript();
            ReusableMethods.bekle(2);
            try {
                twitter.tweetleTus2.click();
            }catch (Exception e) {
                twitter.tweetleTusu.click();
            }

        }

    }


    @And("kullanici tweetini yazar ve atar")
    public void kullaniciTweetiniYazarVeAtar() {
    }
}
