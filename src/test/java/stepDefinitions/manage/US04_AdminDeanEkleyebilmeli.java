package stepDefinitions.manage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.manage.Kisi_Ekleme_Guncelleme_Modulu;
import pages.manage.US04_Admin_Dean_Ekleyebilmeli_Modulu;
import utilities.Methods;

import static org.junit.Assert.assertTrue;

public class US04_AdminDeanEkleyebilmeli extends Kisi_Ekleme_Guncelleme_Modulu {

    US04_Admin_Dean_Ekleyebilmeli_Modulu admin= new US04_Admin_Dean_Ekleyebilmeli_Modulu();
    Methods methods =new Methods();

    @Given("Admin {string} adresine gider")
    public void admin_adresine_gider(String string) {
        methods.loginMethod("deanName", "deanPassword");
        methods.addDean();
    }

    @Then("Kullanici Login ikonunu tiklar")
    public void kullaniciLoginIkonunuTiklar() {

    }

    @And("Kullanici username kutusununa {string} girer")
    public void kullaniciUsernameKutusununaGirer(String arg0) {

    }

    @And("Kullanici password kutusuna {string} girer")
    public void kullaniciPasswordKutusunaGirer(String arg0) {

    }

    @And("Kullanici Login butonunu tiklar")
    public void kullaniciLoginButonunuTiklar() {

    }

    @And("Kullanici Menu butonunu tiklar")
    public void kullaniciMenuButonunuTiklar() {

    }

    @And("Admin Dean Management sayfasına gider")
    public void adminDeanManagementSayfasınaGider() {

    }

    @Given("Admin Add Dean Management bolumunu gorur")
    public void adminAddDeanManagementBolumunuGorur() {
        assertTrue(admin.deanManagementBolumu.isDisplayed());

    }

    @And("Admin Name kutusuna {string} girer")
    public void adminNameKutusunaGirer(String arg0) {
        admin.name.sendKeys(arg0);

    }

    @Then("Admin Surname kutusuna {string} girer")
    public void adminSurnameKutusunaGirer(String arg0) {

        admin.surname.sendKeys(arg0);
    }

    @Then("Admin Birth Place kutusuna {string}  girer")
    public void adminBirthPlaceKutusunaGirer(String arg0) {

        admin.birthPlace.sendKeys(arg0);

    }

    @Then("Admin Gender radio'sundan gender secer")
    public void adminGenderRadioSundanGenderSecer() {
        admin.male.click();
    }

    @Then("Admin Date Of Birth kutusuna {string}  girer")
    public void adminDateOfBirthKutusunaGirer(String arg0) {
        admin.dateOfBirth.sendKeys(arg0);
    }

    @Then("Admin Phone kutusuna {string} girer")
    public void adminPhoneKutusunaGirer(String arg0) {
        admin.phoneNumber.sendKeys(arg0);
    }

    @Then("Admin SSN kutusuna ucuncu ve besinci rakamdan sonra \\(-) içeren dokuz rakamdan olusan {string} girer")
    public void adminSSNKutusunaUcuncuVeBesinciRakamdanSonraIcerenDokuzRakamdanOlusanGirer(String arg0) {
        admin.ssn.sendKeys(arg0);
    }

    @Then("Admin User Name kutusuna {string} girer")
    public void adminUserNameKutusunaGirer(String arg0) {
        admin.username.sendKeys(arg0);
    }

    @Then("Admin Password kutusuna en az {int} karakterden olusan {string} girer")
    public void adminPasswordKutusunaEnAzKarakterdenOlusanGirer(String arg0) {
        admin.password.sendKeys(arg0);
        
    }

    @And("Admin Submit butonuna basar")
    public void adminSubmitButonunaBasar() {
        
    }

    @And("Admin girdiği verileri kaydeder")
    public void adminGirdigiVerileriKaydeder() {
    }
}
