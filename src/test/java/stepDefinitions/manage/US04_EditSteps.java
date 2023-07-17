package stepDefinitions.manage;

import io.cucumber.java.en.*;
import pages.manage.Kisi_Ekleme_Guncelleme_Modulu;
import pages.manage.Login_Modulu;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.US19_US20_US21_TeacherMeetingVeStudentNotesModulu;

import static utilities.ReusableMethods.clickByJavaScript;

public class US04_EditSteps {
    static Kisi_Ekleme_Guncelleme_Modulu kisi = new Kisi_Ekleme_Guncelleme_Modulu();
    Login_Modulu login = new Login_Modulu();
    US19_US20_US21_TeacherMeetingVeStudentNotesModulu page = new US19_US20_US21_TeacherMeetingVeStudentNotesModulu();





//    @When("Kullanici Gelen Menuden Dean Management Menusune Tiklar")
//    public void kullanici_gelen_menuden_dean_management_menusune_tiklar() {
//        deanPage.menuList.click();
//        ReusableMethods.bekle(2);
//    }
//    @When("Kullanici Add Dean Bolumunde Name Alanini Doldurur")
//    public void kullanici_add_dean_bolumunde_name_alanini_doldurur() {
//        deanPage.deanNameBox.sendKeys(ConfigReader.getProperty("EmreDeanName"));
//    }
//    @When("Kullanici Add Dean Bolumunde Surname Alanini Doldurur")
//    public void kullanici_add_dean_bolumunde_surname_alanini_doldurur() {
//        deanPage.deanSurnameBox.sendKeys(ConfigReader.getProperty("EmreDeanSurname"));
//    }
//
//    @When("Kullanici Add Dean Bolumunde Birth Place Alanini Doldurur")
//    public void kullanici_add_dean_bolumunde_birth_place_alanini_doldurur() {
//        deanPage.deanBirthPlaceBox.sendKeys(ConfigReader.getProperty("EmreBirthPlace"));
//    }
//    @When("Kullanici Add Dean Bolumunde Gender Secenegini Secer")
//    public void kullanici_add_dean_bolumunde_gender_secenegini_secer() {
//        deanPage.deanGenderBox.click();
//    }
//    @When("Kullanici Add Dean Bolumunde Date Of Birth Alanini Doldurur")
//    public void kullanici_add_dean_bolumunde_date_of_birth_alanini_doldurur() {
//        deanPage.deanBirthDayBox.sendKeys(ConfigReader.getProperty("EmreBirthDay"));
//    }
//    @When("Kullanici Add Dean Bolumunde Phone Alanini Doldurur")
//    public void kullanici_add_dean_bolumunde_phone_alanini_doldurur() {
//        deanPage.deanPhoneNumberBox.sendKeys(ConfigReader.getProperty("EmrePhoneNumber"));
//    }
//    @When("Kullanici Add Dean Bolumunde SSN Alanini Doldurur")
//    public void kullanici_add_dean_bolumunde_ssn_alanini_doldurur() {
//        deanPage.deanSSNBox.sendKeys(ConfigReader.getProperty("EmreSsn"));
//    }
//    @When("Kullanici Add Dean Bolumunde User Name Alanini Doldurur")
//    public void kullanici_add_dean_bolumunde_user_name_alanini_doldurur() {
//        deanPage.deanUsernameBox.sendKeys(ConfigReader.getProperty("EmreUsername"));
//    }
//    @When("Kullanici Add Dean Bolumunde Password Alanini Doldurur")
//    public void kullanici_add_dean_bolumunde_password_alanini_doldurur() {
//        deanPage.deanPasswordBox.sendKeys(ConfigReader.getProperty("EmrePassword"));
//    }
//    @When("Kullanici Add Dean Bolumunde Submit Butonuna Tiklar")
//    public void kullanici_add_dean_bolumunde_submit_butonuna_tiklar() {
//        deanPage.deanSubmitButton.click();
//    }
//    @When("Kullanici Logout Secenegine Tiklayarak Cikis Yapar")
//    public void kullanici_logout_secenegine_tiklayarak_cikis_yapar() {
//        deanPage.deanLogOut.click();
//        deanPage.deanLogoutConfirmButton.click();
//    }
//    @Then("Kullanici driver'i kapatir")
//    public void kullanici_driveri_kapatir() {
//
//        Driver.closeDriver();
//    }
//
//
//    @And("Kullanici Dean List 'ini gorur")
//    public void KullaniciDeanListinigorur() {
//        List<WebElement> isimArama = deanPage.isimArama;
//        for (int i = 0; i < isimArama.size(); i++) {
//            Assert.assertTrue(isimArama.get(i).isDisplayed());
//
//        }
//    }
//
//
//
//
//    @And("Kullanici ilk Deani siler")
//    public void kullaniciIlkDeaniSiler() {
//        deanPage.getDeleteButton.click();
//
//    }
//
//    @And("Kullanici Edit Butonuna Tiklar")
//    public void kullaniciEditButonunaTiklar() {
//        ReusableMethods.scroll(deanPage.deanEditButon);
//        deanPage.deanEditButon.click();
//    }
//
//
//
//    @And("Kulanici Menu Butonuna Tiklar")
//    public void kulaniciMenuButonunaTiklar() {
//    }
//
//    @And("Kullanici Name Alanina Editlenecek Ismi Yazar")
//    public void kullaniciNameAlaninaEditlenecekIsmiSiler() {
//
//        for (int i = 0; i < 15; i++) {
//            deanPage.newName.sendKeys(Keys.BACK_SPACE);
//        }
//
//        deanPage.newName.sendKeys(ConfigReader.getProperty("NewName"));
//
//    }
//
//
//
//
//
//
//    @And("Kullanici SurName Alanina Editlenecek Soyismi Yazar")
//    public void kullaniciSurNameAlaninaEditlenecekSoyismiYazar() {
//        for (int i = 0; i < 15; i++) {
//            deanPage.newSurname.sendKeys(Keys.BACK_SPACE);
//        }
//        deanPage.newSurname.sendKeys(ConfigReader.getProperty("NewSurname"));
//    }
//
//    @And("Kullanici BirthPlace Alanina Editlenecek BirthPlacei Yazar")
//    public void kullaniciBirthPlaceAlaninaEditlenecekBirthPlaceiYazar() {
//        for (int i = 0; i < 15; i++) {
//            deanPage.newBirthPlace.sendKeys(Keys.BACK_SPACE);
//        }
//        deanPage.newBirthPlace.sendKeys(ConfigReader.getProperty("NewBirthPlace"));
//    }
//
//    @And("Kullanici Gender Alanina Editlenecek Gender Secenegini Secer")
//    public void kullaniciGenderAlaninaEditlenecekGenderSeceneginiSecer() {
//
//        deanPage.newGender.click();
//    }
//
//    @And("Kullanici Date Of Birth Alanina Editlenecek Date Of Birthi Yazar")
//    public void kullaniciDateOfBirthAlaninaEditlenecekDateOfBirthiYazar() {
//        for (int i = 0; i < 15; i++) {
//            deanPage.newBirthDay.sendKeys(Keys.BACK_SPACE);
//        }
//        deanPage.newBirthDay.sendKeys(ConfigReader.getProperty("NewDateOfBirth"));
//    }
//
//    @And("Kullanici Phone Alanina Editlenecek Phone u Yazar")
//    public void kullaniciPhoneAlaninaEditlenecekPhoneUYazar() {
//        for (int i = 0; i < 15; i++) {
//            deanPage.newPhoneNumber.sendKeys(Keys.BACK_SPACE);
//        }
//        deanPage.newPhoneNumber.sendKeys(ConfigReader.getProperty("NewPhoneNumber"));
//    }
//
//    @And("Kullanici SSN Alanina Editlenecek SSN Numarasini Yazar")
//    public void kullaniciSSNAlaninaEditlenecekSSNNumarasiniYazar() {
//        for (int i = 0; i < 15; i++) {
//            deanPage.newSSN.sendKeys(Keys.BACK_SPACE);
//        }
//        deanPage.newSSN.sendKeys(ConfigReader.getProperty("NewSsn"));
//    }
//
//    @And("Kullanici User Name Alanina Editlenecek Ismi Yazar")
//    public void kullaniciUserNameAlaninaEditlenecekIsmiYazar() {
//        for (int i = 0; i < 15; i++) {
//            deanPage.newUsername.sendKeys(Keys.BACK_SPACE);
//        }
//        deanPage.newUsername.sendKeys(ConfigReader.getProperty("NewUserName"));
//    }
//
//    @And("Kullanici Password Alanina Editlenecek Parola Yazar")
//    public void kullaniciPasswordAlaninaEditlenecekParolaYazar() {
//        for (int i = 0; i < 15; i++) {
//            deanPage.newPassword.sendKeys(Keys.BACK_SPACE);
//        }
//        deanPage.newPassword.sendKeys(ConfigReader.getProperty("NewPassword"));
//    }
//
//    @And("Kullanici Submit Butonuna Tiklayarak KayitLari Onaylar")
//    public void kullaniciSubmitButonunaTiklayarakKayitLariOnaylar() {
//        deanPage.editSubmitButton.click();
//    }
//
//    @And("Kullanici Cikis Tusuna Tiklar")
//    public void kullaniciCikisTusunaTiklar() {
//        deanPage.cikisTusu.click();
//
//    }
//
//    @And("Kullanici Sayfada Edit Butonuna Tiklar")
//    public void kullaniciSayfadaEditButonunaTiklar() {
//
//        ReusableMethods.click(deanPage.deanEditButon);
//    }

    @Given("kullanıcı managementschool proje sayfasına gider")
    public void kullanıcı_managementschool_proje_sayfasına_gider() {
        Driver.getDriver().get(ConfigReader.getProperty("manageUrl"));
//        ReusableMethods.bekle(2);
    }
    @Given("kullanıcı sayfada login butonuna tiklar")
    public void kullanıcı_sayfada_login_butonuna_tiklar() {
        page.login.click();
        login.username.sendKeys(ConfigReader.getProperty("adminUsername"));
        login.password.sendKeys(ConfigReader.getProperty("managePassword"));


    }
    @Given("Kullanici Kayitli Username Bilgileri Ile Login Olur")
    public void kullanici_kayitli_username_bilgileri_ıle_login_olur() {
        //login.uyeGirisKismiLoginButton.click();
        clickByJavaScript(login.uyeGirisKismiLoginButton);
    }
    @When("Kullanici Kayitli Password Bilgileri Ile Login Olur")
    public void kullanici_kayitli_password_bilgileri_ıle_login_olur() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("kullanici login butonuna tiklayarak sisteme giris yapar")
    public void kullanici_login_butonuna_tiklayarak_sisteme_giris_yapar() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("Kullanici Menu Butonuna Tiklar")
    public void kullanici_menu_butonuna_tiklar() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("Kullanici Gelen Menuden Dean Management Menusune Tiklar")
    public void kullanici_gelen_menuden_dean_management_menusune_tiklar() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("Kullanici Dean List 'ini gorur")
    public void kullanici_dean_list_ini_gorur() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("Kullanici Sayfada Edit Butonuna Tiklar")
    public void kullanici_sayfada_edit_butonuna_tiklar() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("Kullanici Name Alanina Editlenecek Ismi Yazar")
    public void kullanici_name_alanina_editlenecek_ısmi_yazar() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("Kullanici SurName Alanina Editlenecek Soyismi Yazar")
    public void kullanici_sur_name_alanina_editlenecek_soyismi_yazar() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("Kullanici BirthPlace Alanina Editlenecek BirthPlacei Yazar")
    public void kullanici_birth_place_alanina_editlenecek_birth_placei_yazar() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("Kullanici Gender Alanina Editlenecek Gender Secenegini Secer")
    public void kullanici_gender_alanina_editlenecek_gender_secenegini_secer() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("Kullanici Date Of Birth Alanina Editlenecek Date Of Birthi Yazar")
    public void kullanici_date_of_birth_alanina_editlenecek_date_of_birthi_yazar() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("Kullanici Phone Alanina Editlenecek Phone u Yazar")
    public void kullanici_phone_alanina_editlenecek_phone_u_yazar() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("Kullanici SSN Alanina Editlenecek SSN Numarasini Yazar")
    public void kullanici_ssn_alanina_editlenecek_ssn_numarasini_yazar() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("Kullanici User Name Alanina Editlenecek Ismi Yazar")
    public void kullanici_user_name_alanina_editlenecek_ısmi_yazar() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("Kullanici Password Alanina Editlenecek Parola Yazar")
    public void kullanici_password_alanina_editlenecek_parola_yazar() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("Kullanici Submit Butonuna Tiklayarak KayitLari Onaylar")
    public void kullanici_submit_butonuna_tiklayarak_kayit_lari_onaylar() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("Kullanici driver'i kapatir")
    public void kullanici_driver_i_kapatir() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
}
