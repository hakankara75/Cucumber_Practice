package stepDefinitions.manage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.manage.Kisi_Ekleme_Guncelleme_Modulu;
import pages.manage.US04_Admin_Dean_Ekleyebilmeli_Modulu;

import static org.junit.Assert.assertTrue;

public class US04_AdminDeanEkleyebilmeli extends Kisi_Ekleme_Guncelleme_Modulu {

    US04_Admin_Dean_Ekleyebilmeli_Modulu admin= new US04_Admin_Dean_Ekleyebilmeli_Modulu();

    @Given("Admin Add Dean Management bolumunu gorur")
    public void adminAddDeanManagementBolumunuGorur() {
        assertTrue(admin.deanManagementBolumu.isDisplayed());
    }

    @When("Admin Name kutusunu bos biraktiginda {string} uyarisini gorur")
    public void admin_name_kutusunu_bos_biraktiginda_uyarisini_gorur(String string) {
        assertTrue(admin.requiredMessageName.isDisplayed());


    }

    @When("Admin Surnamekutusunu bos biraktiginda {string} uyarisini gorur")
    public void admin_surnamekutusunu_bos_biraktiginda_uyarisini_gorur(String string) {
        assertTrue(admin.requiredMessageSurname.isDisplayed());
    }

    @When("Admin Birth Place kutusunu bos biraktiginda {string} uyarisini gorur")
    public void admin_birth_place_kutusunu_bos_biraktiginda_uyarisini_gorur(String string) {
        assertTrue(admin.requiredMessageBirthPlace.isDisplayed());
    }

    @Then("Admin Gender radio'sundan deger secer")
    public void adminGenderRadioSundanDegerSecer() {

    }

    @When("Admin Gender radio'sunu bos biraktiginda {string} uyarisini gorur")
    public void adminGenderRadioSunuBosBiraktigindaUyarisiniGorur(String arg0) {
        assertTrue(admin.alertMessage.getText().contains(arg0));
    }

    @And("Admin Date Of Birth kutusuna invalid deger girer")
    public void adminDateOfBirthKutusunaInvalidDegerGirer() {
    }

    @Then("Admin Date Of Birth kutusuna deger girer")
    public void admin_date_of_birth_kutusuna_deger_girer() {

    }
    @When("Admin Date Of Birth kutusunu bos biraktiginda {string} uyarisini gorur")
    public void admin_date_of_birth_kutusunu_bos_biraktiginda_uyarisini_gorur(String string) {
        assertTrue(admin.requiredMessageDateOfBirth.isDisplayed());

    }
    @Then("Admin Phone kutusuna deger girer")
    public void admin_phone_kutusuna_deger_girer() {

    }
    @When("Admin Phonekutusunu bos biraktiginda {string} uyarisini gorur")
    public void admin_phonekutusunu_bos_biraktiginda_uyarisini_gorur(String string) {
        assertTrue(admin.requiredMessagePhone.isDisplayed());

    }
    @Then("Admin SSN kutusuna {int}. ve {int}. rakamdan sonra {string} içeren {int} rakamdan olusan deger girer")
    public void admin_ssn_kutusuna_ve_rakamdan_sonra_içeren_rakamdan_olusan_deger_girer(Integer int1, Integer int2, String string, Integer int3) {

    }
    @When("Admin SSN kutusunu bos biraktiginda {string} uyarisini gorur")
    public void admin_ssn_kutusunu_bos_biraktiginda_uyarisini_gorur(String string) {

    }
    @When("Admin SSN kutusunu invalid deger girer")
    public void admin_ssn_kutusunu_invalid_deger_girer() {

    }
    @Then("Admin User Name kutusuna deger girer")
    public void admin_user_name_kutusuna_deger_girer() {

    }
    @When("Admin User Name kutusunu bos biraktiginda {string} uyarisini gorur")
    public void admin_user_name_kutusunu_bos_biraktiginda_uyarisini_gorur(String string) {

    }
    @Then("Admin Password kutusuna deger girer")
    public void admin_password_kutusuna_deger_girer() {

    }
    @When("Admin  Password kutusuna {int} karakter girince {string} uyarisini gorur")
    public void admin_password_kutusuna_karakter_girince_uyarisini_gorur(Integer int1, String string) {

    }
    @When("Admin  Password kutusuna en az {int} karakterden olusan bir deger girer")
    public void admin_password_kutusuna_en_az_karakterden_olusan_bir_deger_girer(Integer int1) {

    }
    @When("Admin Password kutusuna buyuk harf iceren deger girer")
    public void admin_password_kutusuna_buyuk_harf_iceren_deger_girer() {

    }
    @When("Admin Password kutusuna kucuk harf iceren deger girer")
    public void admin_password_kutusuna_kucuk_harf_iceren_deger_girer() {

    }
    @When("Admin  Password kutusuna bir rakam iceren deger girer")
    public void admin_password_kutusuna_bir_rakam_iceren_deger_girer() {

    }
    @When("Admin Password olarak büyük harf, küçük harf ve bir rakam içeren deger girer")
    public void admin_password_olarak_büyük_harf_küçük_harf_ve_bir_rakam_içeren_deger_girer() {

    }


    @And("Admin Phone kutusuna invalid deger girer")
    public void adminPhoneKutusunaInvalidDegerGirer() {
        
    }

    @And("Admin Submit butonuna basar")
    public void adminSubmitButonunaBasar() {
        
    }

    @And("Admin girdiği verileri kaydeder")
    public void adminGirdigiVerileriKaydeder() {
    }


    @Then("Admin Name kutusuna {string} girer")
    public void adminNameKutusunaGirer(String arg0, String arg1) {
        admin.name.sendKeys(arg0);
        admin.name.sendKeys(arg1);
    }

    @Then("Admin Surname kutusuna {string} girer")
    public void adminSurnameKutusunaGirer(String arg0, String arg1) {
        admin.surname.sendKeys(arg0);
        admin.surname.sendKeys(arg1);
    }

    @Then("Admin Birth Place kutusuna {string}  girer")
    public void adminBirthPlaceKutusunaGirer(String arg0, String arg1) {
        admin.birthPlace.sendKeys(arg0);
        admin.birthPlace.sendKeys(arg1);
    }


    @Then("Admin Gender radio'sundan {string} secer")
    public void adminGenderRadioSundanSecer(String arg0, String arg1) {
    }

    @Then("Admin Date Of Birth kutusuna {string}  girer")
    public void adminDateOfBirthKutusunaGirer(String arg0, String arg1) {
        admin.dateOfBirth.sendKeys(arg0);
        admin.dateOfBirth.sendKeys(arg1);

    }

    @Then("Admin Phone kutusuna {string} girer")
    public void adminPhoneKutusunaGirer(String arg0, String arg1) {
        admin.phoneNumber.sendKeys(arg0);
        admin.phoneNumber.sendKeys(arg1);
    }


    @Then("Admin User Name kutusuna {string} girer")
    public void adminUserNameKutusunaGirer(String arg0, String arg1) {
        
    }

    @Then("Admin Password kutusuna {string} girer")
    public void adminPasswordKutusunaGirer(String arg0, String arg1) {
    }

    @When("Admin Password kutusunu bos biraktiginda {string} uyarisini gorur")
    public void adminPasswordKutusunuBosBiraktigindaUyarisiniGorur(String arg0) {
    }

    @Then("Admin Gender radio'sundan gender secer")
    public void adminGenderRadioSundanGenderSecer() {
        admin.male.click();
    }

    @Then("Admin Password kutusuna en az {int} karakterden olusan {string} girer")
    public void adminPasswordKutusunaEnAzKarakterdenOlusanGirer(int arg0, String arg1, String arg2) {
        
    }

    @And("Admin Password olarak büyük harf, küçük harf ve bir rakam içeren {string} girer")
    public void adminPasswordOlarakBuyukHarfKucukHarfVeBirRakamIcerenGirer(String arg0, String arg1) {
    }


    @Then("Admin SSN kutusuna ucuncu ve besinci rakamdan sonra - içeren dokuz rakamdan olusan {string} girer")
    public void adminSSNKutusunaUcuncuVeBesinciRakamdanSonraIcerenDokuzRakamdanOlusanGirer(String arg0, String arg1) {
    }
}
