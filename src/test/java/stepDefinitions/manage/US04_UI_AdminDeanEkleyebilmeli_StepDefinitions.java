package stepDefinitions.manage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.manage.Kisi_Ekleme_Guncelleme_Modulu;
import pages.manage.US04_US05_Dean_Ekleme_Guncelleme_Silme_Modulu;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.US04_US05_Methods;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class US04_UI_AdminDeanEkleyebilmeli_StepDefinitions extends Kisi_Ekleme_Guncelleme_Modulu {

    US04_US05_Dean_Ekleme_Guncelleme_Silme_Modulu admin = new US04_US05_Dean_Ekleme_Guncelleme_Silme_Modulu();
    US04_US05_Methods method =new US04_US05_Methods();



    @Given("Admin Add Dean Management bolumunu gorur")
    public void adminAddDeanManagementBolumunuGorur() {
        try {
            assertTrue(admin.deanManagementBolumu.isDisplayed());
        }catch (Exception e) {

        }


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
        ReusableMethods.bekle(2);
    }


    @And("Admin Submit butonuna basar")
    public void adminSubmitButonunaBasar() {
        admin.submit.click();
        ReusableMethods.bekle(3);
    }

    @And("Admin girdiği verileri kaydeder")
    public void adminGirdigiVerileriKaydeder() {
        method.alertWait1(admin.addDeanClass);
        assertFalse(admin.addDeanClass.getText().contains("saved"));
        Driver.closeDriver();
    }
    @And("Admin girdiği verileri kaydettigini dogrular")
    public void adminGirdigiVerileriKaydettiginiDogrular() {
        method.alertWait1(admin.addDeanClass);
        assertFalse(admin.addDeanClass.getText().contains("saved"));
        Driver.closeDriver();
    }
    @And("Admin Gender radio'sunu bos biraktiginda {string} uyarisini gorur")
    public void adminGenderRadioSunuBosBiraktigindaUyarisiniGorur(String arg0) {

        assertTrue(admin.alertMessage.isDisplayed());
        Driver.closeDriver();

    }
    @Then("Admin Password kutusuna en az sekiz karakterden olusan {string} girer")
    public void adminPasswordKutusunaEnAzSekizKarakterdenOlusanGirer(String arg0) {
        admin.loginPasword.sendKeys(arg0);
    }

    @Then("Admin kayit yapamadigini dogrular")
    public void adminKayitYapamadiginiDogrular() {

        method.alertWait1(admin.nameShouldTwo);
        assertFalse(admin.nameShouldTwo.isDisplayed());

        ReusableMethods.bekle(2);

        Driver.closeDriver();
    }

    @When("Admin Name kutusunu bos biraktiginda uyari yazisini gorur")
    public void adminNameKutusunuBosBiraktigindaUyariYazisiniGorur() {
        admin.name.click();
        admin.surname.click();
        assertTrue(admin.requiredMessageName.isDisplayed());
    }

    @Then("Admin  Surname  kutusunu bos biraktiginda uyari yazisini gorur")
    public void adminSurnameKutusunuBosBiraktigindaUyariYazisiniGorur() {

        admin.surname.click();
        admin.birthPlace.click();
        assertTrue(admin.requiredMessageSurname.isDisplayed());
    }

    @And("Admin Birth Place  kutusunu bos biraktiginda uyari yazisini gorur")
    public void adminBirthPlaceKutusunuBosBiraktigindaUyariYazisiniGorur() {
        admin.birthPlace.click();
        admin.dateOfBirth.click();
        assertTrue(admin.requiredMessageDateOfBirth.isDisplayed());
    }

    @And("Admin Date Of Birth  kutusunu bos biraktiginda uyari yazisini gorur")
    public void adminDateOfBirthKutusunuBosBiraktigindaUyariYazisiniGorur() {
        admin.dateOfBirth.click();
        admin.phoneNumber.click();
        assertTrue(admin.requiredMessageDateOfBirth.isDisplayed());
    }

    @And("Admin Phone  kutusunu bos biraktiginda uyari yazisini gorur")
    public void adminPhoneKutusunuBosBiraktigindaUyariYazisiniGorur() {
        admin.phoneNumber.click();
        admin.ssn.click();
        assertTrue(admin.requiredMessagePhone.isDisplayed());
    }

    @And("Admin Password kutusunu bos biraktiginda uyari yazisini gorur")
    public void adminPasswordKutusunuBosBiraktigindaUyariYazisiniGorur() {
        admin.loginPasword.click();
        admin.name.click();
        assertTrue(admin.requiredMessagePassword.isDisplayed());
    }

    @And("Admin Ssn  kutusunu bos biraktiginda uyari yazisini gorur")
    public void adminSsnKutusunuBosBiraktigindaUyariYazisiniGorur() {
        admin.ssn.click();
        admin.username.click();
        assertTrue(admin.requiredMessageSsn.isDisplayed());
    }

    @And("Admin Username kutusunu bos biraktiginda uyari yazisini gorur")
    public void adminUsernameKutusunuBosBiraktigindaUyariYazisiniGorur() {
        admin.username.click();
        admin.loginPasword.click();
        assertTrue(admin.requiredMessageUserName.isDisplayed());

    }

    @And("Admin eksik giris ile kayit yapamadigini dogrular")
    public void adminEksikGirisIleKayitYapamadiginiDogrular() {

        boolean bosMu= admin.requiredMessageName.isDisplayed()||
                admin.requiredMessageSurname.isDisplayed()||
                admin.requiredMessageBirthPlace.isDisplayed()||
                admin.requiredMessageDateOfBirth.isDisplayed()||
                admin.requiredMessagePhone.isDisplayed()||
                admin.requiredMessageSsn.isDisplayed()||
                admin.requiredMessageUserName.isDisplayed()||
                admin.requiredMessagePassword.isDisplayed();
        assertTrue(bosMu==true);
        Driver.closeDriver();
    }
}