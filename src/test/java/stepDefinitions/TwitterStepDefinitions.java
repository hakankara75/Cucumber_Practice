package stepDefinitions;

import io.cucumber.java.en.*;
import pages.Twitter;
import utilities.ConfigReader;
import utilities.Driver;
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
         twitter.girisYap.click();
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
         twitter.ara.click();
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
            twitter.tweetYaz.sendKeys(tweet);
            twitter.tweetleTusu.click();
        }

    }



}
