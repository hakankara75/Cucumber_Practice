package stepDefinitions.manage;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;
import pages.manage.Kisi_Ekleme_Guncelleme_Modulu;
import pages.manage.Login_Modulu;
import pages.manage.US04_US05_Dean_Ekleme_Guncelleme_Silme_Modulu;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.US19_US20_US21_TeacherMeetingVeStudentNotesModulu;

import static org.junit.Assert.assertTrue;

public class US04_EditSteps {
    static Kisi_Ekleme_Guncelleme_Modulu kisi = new Kisi_Ekleme_Guncelleme_Modulu();
    Login_Modulu login = new Login_Modulu();
    US19_US20_US21_TeacherMeetingVeStudentNotesModulu page = new US19_US20_US21_TeacherMeetingVeStudentNotesModulu();
    US04_US05_Dean_Ekleme_Guncelleme_Silme_Modulu dean = new US04_US05_Dean_Ekleme_Guncelleme_Silme_Modulu();
    Faker faker =new Faker();

    @And("Kullanici Dean List ini gorur")
    public void kullaniciDeanListIniGorur() {
        try{
            ReusableMethods.pageDown();
            ReusableMethods.arrowUp();
            ReusableMethods.arrowUp();
            ReusableMethods.arrowUp();
            ReusableMethods.arrowUp();
            ReusableMethods.bekle(3);}
        catch (Exception e){

        }
        assertTrue(dean.deanListBasligi.isDisplayed());
    }

    @When("Kullanici Sayfada Edit Butonuna Tiklar")
    public void kullanici_sayfada_edit_butonuna_tiklar() {

        ReusableMethods.clickByJavaScript(dean.firstEditButton);
    }

    @And("Kullanici Name Alanina Editlenecek ismi Yazar")
    public void kullaniciNameAlaninaEditlenecekIsmiYazar() {
        String deger= dean.editName.getAttribute("value");
        for (int i = 0; i < deger.length(); i++) {
            dean.editName.sendKeys(Keys.BACK_SPACE);
        }

        dean.editName.sendKeys(faker.name().firstName());

    }
    @When("Kullanici SurName Alanina Editlenecek Soyismi Yazar")
    public void kullanici_sur_name_alanina_editlenecek_soyismi_yazar() {
        String deger= dean.editSurname.getAttribute("value");
        for (int i = 0; i < deger.length(); i++) {
            dean.editSurname.sendKeys(Keys.BACK_SPACE);
        }

        dean.editSurname.sendKeys(faker.name().lastName());

    }

    @When("Kullanici BirthPlace Alanina Editlenecek BirthPlacei Yazar")
    public void kullanici_birth_place_alanina_editlenecek_birth_placei_yazar() {

        String deger= dean.editBirthPlace.getAttribute("value");
        for (int i = 0; i < deger.length(); i++) {
            dean.editBirthPlace.sendKeys(Keys.BACK_SPACE);
        }

        dean.editBirthPlace.sendKeys(faker.address().city());

    }

    @When("Kullanici Gender Alanina Editlenecek Gender Secenegini Secer")
    public void kullanici_gender_alanina_editlenecek_gender_secenegini_secer() {
       dean.editGenderMale.click();
    }

    @When("Kullanici Date Of Birth Alanina Editlenecek Date Of Birthi Yazar")
    public void kullanici_date_of_birth_alanina_editlenecek_date_of_birthi_yazar() {

        dean.editDateOfBirth.sendKeys("01.01.2001");
    }

    @When("Kullanici Phone Alanina Editlenecek Phone u Yazar")
    public void kullanici_phone_alanina_editlenecek_phone_u_yazar() {

        for (int i = 0; i < 20; i++) {
            dean.editPhone.sendKeys(Keys.BACK_SPACE);
        }
        dean.editPhone.sendKeys(faker.numerify("###-###-####"));
    }

    @When("Kullanici SSN Alanina Editlenecek SSN Numarasini Yazar")
    public void kullanici_ssn_alanina_editlenecek_ssn_numarasini_yazar() {
        for (int i = 0; i < 20; i++) {
            dean.editSsn.sendKeys(Keys.BACK_SPACE);
        }
        dean.editSsn.sendKeys(faker.numerify("###-###-####"));
    }



    @And("Kullanici User Name Alanina Editlenecek ismi Yazar")
    public void kullaniciUserNameAlaninaEditlenecekIsmiYazar() {
        String deger= dean.editUserName.getAttribute("value");
        for (int i = 0; i < deger.length(); i++) {
            dean.editUserName.sendKeys(Keys.BACK_SPACE);
        }
        ReusableMethods.bekle(2);
        dean.editUserName.sendKeys(faker.name().username());
    }
    @When("Kullanici Password Alanina Editlenecek Parola Yazar")
    public void kullanici_password_alanina_editlenecek_parola_yazar() {
        String deger= dean.editUserName.getAttribute("value");
        for (int i = 0; i < deger.length(); i++) {
            dean.editUserName.sendKeys(Keys.BACK_SPACE);
        }
        ReusableMethods.bekle(2);
        dean.editUserName.sendKeys(faker.internet().password());
    }

    @When("Kullanici Submit Butonuna Tiklayarak KayitLari Onaylar")
    public void kullanici_submit_butonuna_tiklayarak_kayit_lari_onaylar() {
       dean.editSubmit.click();
    }

    @Then("Kullanici driver'i kapatir")
    public void kullanici_driver_i_kapatir() {
        Driver.closeDriver();
    }


}