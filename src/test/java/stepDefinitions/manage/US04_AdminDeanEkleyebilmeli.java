package stepDefinitions.manage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.manage.Kisi_Ekleme_Guncelleme_Modulu;
import pages.manage.US04_Admin_Dean_Ekleyebilmeli_Modulu;
import utilities.Driver;
import utilities.Methods;

import static org.junit.Assert.assertTrue;

public class US04_AdminDeanEkleyebilmeli extends Kisi_Ekleme_Guncelleme_Modulu {

    US04_Admin_Dean_Ekleyebilmeli_Modulu admin= new US04_Admin_Dean_Ekleyebilmeli_Modulu();
    Methods methods =new Methods();

    @Given("Admin {string} adresine gider")
    public void admin_adresine_gider(String string) {

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
        methods.loginMethod("deanName", "deanPassword");
        methods.addDean();
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


    @And("Admin Submit butonuna basar")
    public void adminSubmitButonunaBasar() {
        admin.submit.click();
    }

    @And("Admin girdiği verileri kaydeder")
    public void adminGirdigiVerileriKaydeder() {

        Driver.closeDriver();
    }

    @When("Admin Name kutusunu bos biraktiginda uyarı yazısını gorur")
    public void adminNameKutusunuBosBiraktigindaUyarıYazısınıGorur() {
        admin.name.click();
        admin.surname.click();
        assertTrue(admin.requiredMessageName.isDisplayed());
    }

    @Then("Admin  Surname  kutusunu bos biraktiginda uyarı yazısını gorur")
    public void adminSurnameKutusunuBosBiraktigindaUyarıYazısınıGorur() {
        admin.surname.click();
        admin.birthPlace.click();
        assertTrue(admin.requiredMessageSurname.isDisplayed());
    }

    @And("Admin Birth Place  kutusunu bos biraktiginda uyarı yazısını gorur")
    public void adminBirthPlaceKutusunuBosBiraktigindaUyarıYazısınıGorur() {
        admin.birthPlace.click();
        admin.dateOfBirth.click();
        assertTrue(admin.requiredMessageDateOfBirth.isDisplayed());
    }

    @And("Admin Gender radio'sunu bos biraktiginda {string} uyarisini gorur")
    public void adminGenderRadioSunuBosBiraktigindaUyarisiniGorur(String arg0) {

        assertTrue(admin.alertMessage.isDisplayed());
// bu textin locatine bakacağım. burada kaldim
    }

    @And("Admin Date Of Birth  kutusunu bos biraktiginda uyarı yazısını gorur")
    public void adminDateOfBirthKutusunuBosBiraktigindaUyarıYazısınıGorur() {

        admin.dateOfBirth.click();
        admin.phoneNumber.click();
        assertTrue(admin.requiredMessageDateOfBirth.isDisplayed());
    }

    @And("Admin Phone  kutusunu bos biraktiginda uyarı yazısını gorur")
    public void adminPhoneKutusunuBosBiraktigindaUyarıYazısınıGorur() {

        admin.phoneNumber.click();
        admin.ssn.click();
        assertTrue(admin.requiredMessagePhone.isDisplayed());
    }

    @And("Admin Ssn  kutusunu bos biraktiginda uyarı yazısını gorur")
    public void adminSsnKutusunuBosBiraktigindaUyarıYazısınıGorur() {

        admin.ssn.click();
        admin.username.click();
        assertTrue(admin.requiredMessageSsn.isDisplayed());
    }

    @And("Admin Username kutusunu bos biraktiginda uyarı yazısını gorur")
    public void adminUsernameKutusunuBosBiraktigindaUyarıYazısınıGorur() {
        admin.username.click();
        admin.loginPasword.click();
        assertTrue(admin.requiredMessageUserName.isDisplayed());

    }

    @And("Admin Password kutusunu bos biraktiginda uyarı yazısını gorur")
    public void adminPasswordKutusunuBosBiraktigindaUyarıYazısınıGorur() {
        admin.loginPasword.click();
        admin.name.click();
        assertTrue(admin.requiredMessagePassword.isDisplayed());

    }

    @Then("Admin Password kutusuna en az sekiz karakterden olusan {string} girer")
    public void adminPasswordKutusunaEnAzSekizKarakterdenOlusanGirer(String arg0) {
        admin.loginPasword.sendKeys(arg0);
    }

}
