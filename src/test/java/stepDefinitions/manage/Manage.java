package stepDefinitions.manage;

import io.cucumber.java.en.*;
import pages.manage.Kisi_Ekleme_Guncelleme_Modulu;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class Manage {

    Kisi_Ekleme_Guncelleme_Modulu management = new Kisi_Ekleme_Guncelleme_Modulu();


    @Given("Kullanici {string} adresine gider")
    public void kullanici_adresine_gider(String string) {
        Driver.getDriver().get(ConfigReader.getProperty("manageUrl"));
    }

    @Then("Kullanici Login ikonunu tiklar")
    public void kullanici_login_ikonunu_tiklar() {
    management.login.click();
    }


    @And("Kullanici username kutusununa {string} girer")
    public void kullaniciUsernameKutusununaGirer(String arg0) {
        management.username.sendKeys("teacherhakan");
    }

    @And("Kullanici password kutusuna {string} girer")
    public void kullaniciPasswordKutusunaGirer(String arg0) {
        management.pasword.sendKeys("12345678");

    }

    @And("Kullanici Login butonunu tiklar")
    public void kullaniciLoginButonunuTiklar() {
        management.UyeGirisKismiLoginButton.click();
    }
    @Then("Kullanici Menu butonunu tiklar")
    public void kullanici_menu_butonunu_tiklar() {
        management.menu.click();
    }

    @Then("Kullanici name kutusuna {string} girer")
    public void kullaniciNameKutusunaGirer(String arg0) {
        management.editName.sendKeys("batu");
    }

    @And("Kullanici surname kutusuna {string} girer")
    public void kullaniciSurnameKutusunaGirer(String arg0) {
        management.editSurname.sendKeys("kara");
    }

    @And("Kullanici birth place kutusuna {string} girer")
    public void kullaniciBirthPlaceKutusunaGirer(String arg0) {
        management.editBirthPlace.sendKeys("yalnizcam");

    }

    @And("Kullanici gender checkboxtan gender secer")
    public void kullaniciGenderCheckboxtanGenderSecer() {
        management.editFemale.click();
    }

    @And("Kullanici date of birth kutusuna {string} girer")
    public void kullaniciDateOfBirthKutusunaGirer(String arg0) {
        management.editDateOfBirth.sendKeys("01/01/2000");

    }
    @And("Kullanici phone kutusuna {string} girer")
    public void kullaniciPhoneKutusunaGirer(String arg0) {
        management.editPhone.sendKeys("124-666-3258");
    }


    @And("Kullanici ssn kutusuna {string} girer")
    public void kullaniciSsnKutusunaGirer(String arg0) {

        management.editSsn.sendKeys("125-88-9654");

    }

    @And("Kullanici user name kutusuna {string} girer")
    public void kullaniciUserNameKutusunaGirer(String arg0) {
        management.username.sendKeys("Team2");

    }

    @And("Kullanici pass kutusuna {string} girer")
    public void kullaniciPassKutusunaGirer(String arg0) {
        management.editPassword.sendKeys("12345678");

    }

    @And("Kullanici submit butonuna basar")
    public void kullaniciSubmitButonunaBasar() {
        management.submit.click();
    }

    @And("Kullanici admin management menusunu secer")
    public void kullaniciAdminManagementMenusunuSecer() {
        management.teacherManagement.click();
    }

    @Then("Kullanici edit butonuna basar")
    public void kullaniciEditButonunaBasar() {
        ReusableMethods.pageDown();
        management.firstEditButton.click();
    }

    @And("Kullanici email kutusuna {string} girer")
    public void kullaniciEmailKutusunaGirer(String arg0) {
        management.editMale.sendKeys("hakanbatirhan@gmail.com");
    }

    @And("Kullanici is advisor teacher checkbox'ini secer")
    public void kullaniciIsAdvisorTeacherCheckboxIniSecer() {
        management.isAdvisorTeacher.click();
    }
}