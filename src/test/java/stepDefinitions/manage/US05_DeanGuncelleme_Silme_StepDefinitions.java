package stepDefinitions.manage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import pages.manage.Kisi_Ekleme_Guncelleme_Modulu;
import pages.manage.US05_DeanGuncelleme_Silme_Page;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import static org.junit.Assert.assertTrue;

public class US05_DeanGuncelleme_Silme_StepDefinitions {

    Kisi_Ekleme_Guncelleme_Modulu management = new Kisi_Ekleme_Guncelleme_Modulu();
    US05_DeanGuncelleme_Silme_Page dean = new US05_DeanGuncelleme_Silme_Page();
    @Given("Admin {string} adresine gider")
    public void adminAdresineGider(String arg0) {
        Driver.getDriver().get(ConfigReader.getProperty("manageUrl"));
    }

    @Then("Kullanici Login ikonunu tiklar")
    public void kullanici_login_ikonunu_tiklar() {
        management.login.click();
    }
    @And("Kullanici username kutusununa {string} girer")
    public void kullaniciUsernameKutusununaGirer(String arg0) {
        management.username.sendKeys(ConfigReader.getProperty("deanName"));
    }
    @And("Kullanici password kutusuna {string} girer")
    public void kullaniciPasswordKutusunaGirer(String arg0) {
        management.pasword.sendKeys(ConfigReader.getProperty("deanPassword"));

    }
    @And("Kullanici Login butonunu tiklar")
    public void kullaniciLoginButonunuTiklar() {
        management.UyeGirisKismiLoginButton.click();
    }
    @Then("Kullanici Menu butonunu tiklar")
    public void kullanici_menu_butonunu_tiklar() {
        management.menu.click();
    }

    @And("Admin Dean Management sayfasına gider")
    public void adminDeanManagementSayfasınaGider() {
        management.deanManagement.click();
    }


    @Given("Admin Name bilgilerini gorur")
    public void admin_name_bilgilerini_gorur() {
        assertTrue(dean.nameSutunu.isDisplayed());

       int sutunSayisi= ReusableMethods.satirSayisiBul("Name");

        int i=1;
        do {
                assertTrue(Driver.getDriver().findElement(By.xpath("//*[@id=\"root\"]/div/main/div/div[1]/div[3]/div/div/div[1]/table/tbody/tr["+i+"]/td[1]")).isDisplayed());
            i++;

        }while(i<=sutunSayisi);

    }

    @Given("Admin Gender bilgilerini gorur")
    public void admin_gender_bilgilerini_gorur() {

        assertTrue(dean.genderSutunu.isDisplayed());

        int sutunSayisi= ReusableMethods.satirSayisiBul("Gender");

        int i=1;
        do {
            assertTrue(Driver.getDriver().findElement(By.xpath("//*[@id=\"root\"]/div/main/div/div[1]/div[3]/div/div/div[1]/table/tbody/tr["+i+"]/td[1]")).isDisplayed());
            i++;

        }while(i<=sutunSayisi);

    }
    @Given("Admin Phone bilgilerini gorur")
    public void admin_phone_bilgilerini_gorur() {
        assertTrue(dean.phoneNumberSutunu.isDisplayed());

        int sutunSayisi= ReusableMethods.satirSayisiBul("Phone Number");

        int i=1;
        do {
            assertTrue(Driver.getDriver().findElement(By.xpath("//*[@id=\"root\"]/div/main/div/div[1]/div[3]/div/div/div[1]/table/tbody/tr["+i+"]/td[1]")).isDisplayed());
            i++;

        }while(i<=sutunSayisi);

    }
    @Given("Admin SSN bilgilerini gorur")
    public void admin_ssn_bilgilerini_gorur() {
        assertTrue(dean.ssnSutunu.isDisplayed());

        int sutunSayisi= ReusableMethods.satirSayisiBul("Ssn");

        int i=1;
        do {
            assertTrue(Driver.getDriver().findElement(By.xpath("//*[@id=\"root\"]/div/main/div/div[1]/div[3]/div/div/div[1]/table/tbody/tr["+i+"]/td[1]")).isDisplayed());
            i++;

        }while(i<=sutunSayisi);

    }
    @Given("Admin User Name bilgilerini gorur")
    public void admin_user_name_bilgilerini_gorur() {
        assertTrue(dean.usernameSutunu.isDisplayed());

        int sutunSayisi= ReusableMethods.satirSayisiBul("User Name");

        int i=1;
        do {
            assertTrue(Driver.getDriver().findElement(By.xpath("//*[@id=\"root\"]/div/main/div/div[1]/div[3]/div/div/div[1]/table/tbody/tr["+i+"]/td[1]")).isDisplayed());
            i++;

        }while(i<=sutunSayisi);

    }
    @Given("Admin Delete butonunu gorur")
    public void admin_delete_butonunu_gorur() {

        //assertTrue(dean.deanListBolumu.getText().toLowerCase().contains("delete"));


    }
    @Given("Admin Delete butonuna basar")
    public void admin_delete_butonuna_basar() {
       // assertTrue(dean.deanListBolumu.getText().toLowerCase().contains("delete"));

    }
    @Given("Admin Dean List'i gorur")
    public void admin_dean_list_i_gorur() {
        assertTrue(dean.deanListBasligi.isDisplayed());

    }
    @Given("Admin Edit butonunu gorur")
    public void admin_edit_butonunu_gorur() {
        assertTrue(management.firstEditButton.isDisplayed());


    }
    @Given("Admin Edit butonuna basar")
    public void admin_edit_butonuna_basar() {
        ReusableMethods.pageDown();
        management.firstEditButton.click();

    }
    @Given("Admin Edit Dean penceresini gorur")
    public void admin_edit_dean_penceresini_gorur() {
        assertTrue(management.editDeanBolumBasligi.isDisplayed());

    }
    @Given("Admin degistirmek istedigi ismi Name kutusunda gorur")
    public void admin_degistirmek_istedigi_ismi_name_kutusunda_gorur() {
        assertTrue(management.editName.isDisplayed());

    }
    @Given("Admin degistirmek istedigi soyadi Surname kutusunda gorur")
    public void admin_degistirmek_istedigi_soyadi_surname_kutusunda_gorur() {
        assertTrue(management.editSurname.isDisplayed());
    }
    @Given("Admin degistirmek istedigi dogum yerini Birth Place kutusunda gorur")
    public void admin_degistirmek_istedigi_dogum_yerini_birth_place_kutusunda_gorur() {
        assertTrue(dean.editBirthPlace.isDisplayed());

    }
    @Given("Admin degistirmek istedigi cinsiyeti Gender checkbox'inda gorur")
    public void admin_degistirmek_istedigi_cinsiyeti_gender_checkbox_inda_gorur() {
        assertTrue(dean.editGenderMale.isDisplayed());
        assertTrue(dean.editGenderFemale.isDisplayed());

    }
    @Given("Admin degistirmek istedigi dogum tarihini Date Of Birth kutusunda gorur")
    public void admin_degistirmek_istedigi_dogum_tarihini_date_of_birth_kutusunda_gorur() {
        assertTrue(dean.editDateOfBirth.isDisplayed());


    }
    @Given("Admin degistirmek istedigi telefon numarasini Phone kutusunda gorur")
    public void admin_degistirmek_istedigi_telefon_numarasini_phone_kutusunda_gorur() {
        assertTrue(management.editPhone.isDisplayed());
    }
    @Given("Admin degistirmek istedigi ssn bilgisini SSN kutusunda gorur")
    public void admin_degistirmek_istedigi_ssn_bilgisini_ssn_kutusunda_gorur() {
        assertTrue(management.editSsn.isDisplayed());

    }
    @Given("Admin degistirmek istedigi username'i User Name kutusunda gorur")
    public void admin_degistirmek_istedigi_username_i_user_name_kutusunda_gorur() {
        assertTrue(management.editUserName.isDisplayed());
    }
    @Given("Admin degistirmek istedigi password'u Password kutusunda gorur")
    public void admin_degistirmek_istedigi_password_u_password_kutusunda_gorur() {
        assertTrue(management.editPassword.isDisplayed());

    }
    @Given("Admin Submit butonunu gorur")
    public void admin_submit_butonunu_gorur() {
        assertTrue(management.submit.isDisplayed());
    }
    @Given("Admin Submit butonuna tiklar")
    public void admin_submit_butonuna_tiklar() {
        management.submit.click();
        Driver.closeDriver();
    }

}
