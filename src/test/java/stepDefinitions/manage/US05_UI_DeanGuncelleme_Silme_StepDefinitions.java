package stepDefinitions.manage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import pages.manage.US04_US05_Dean_Ekleme_Guncelleme_Silme_Modulu;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.US04_US05_Methods;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class US05_UI_DeanGuncelleme_Silme_StepDefinitions extends US04_US05_Methods {

    US04_US05_Dean_Ekleme_Guncelleme_Silme_Modulu dean = new US04_US05_Dean_Ekleme_Guncelleme_Silme_Modulu();

    String name = "hakan";
    String surname = "kara";
    String birthPlace = "ardahan";
    String dateOfBirth = "2001-01-01";
    String phone = "111-544-5555";
    String ssn = "111-55-5445";
    String username = "deanhakan1";
    String password = "12345678";


    @Given("Admin {string} adresine gider")
    public void adminAdresineGider(String arg0) {

    }

    @And("Admin username kutusununa {string} girer")
    public void adminUsernameKutusununaGirer(String arg0) {

    }

    @And("Kullanici Menu butonuna basar")
    public void kullaniciMenuButonunaBasar() {
        dean.menu.click();
    }

    @Given("Admin Name bilgilerini gorur")
    public void admin_name_bilgilerini_gorur() {
        assertTrue(dean.nameSutunu.isDisplayed());

        int sutunSayisi = ReusableMethods.satirSayisiBul("Name");

        int i = 1;
        do {
            assertTrue(Driver.getDriver().findElement(By.xpath("//tr[" + i + "]//td[1]")).isDisplayed());
            assertTrue(Driver.getDriver().findElement(By.xpath("//tr[" + i + "]//td[1]")).getText().length() > 0);

            i++;

        } while (i <= sutunSayisi);

    }

    @Given("Admin Gender bilgilerini gorur")
    public void admin_gender_bilgilerini_gorur() {

        assertTrue(dean.genderSutunu.isDisplayed());

        int sutunSayisi = ReusableMethods.satirSayisiBul("Gender");

        int i = 1;
        do {
            assertTrue(Driver.getDriver().findElement(By.xpath("//tr[" + i + "]//td[2]")).isDisplayed());
            i++;

        } while (i <= sutunSayisi);

    }

    @Given("Admin Phone bilgilerini gorur")
    public void admin_phone_bilgilerini_gorur() {
        assertTrue(dean.phoneNumberSutunu.isDisplayed());

        int sutunSayisi = ReusableMethods.satirSayisiBul("Phone Number");

        int i = 1;
        do {
            assertTrue(Driver.getDriver().findElement(By.xpath("//tr[" + i + "]//td[3]")).isDisplayed());
            assertTrue(Driver.getDriver().findElement(By.xpath("//tr[" + i + "]//td[3]")).getText().length() > 0);

            i++;

        } while (i <= sutunSayisi);

    }

    @Given("Admin SSN bilgilerini gorur")
    public void admin_ssn_bilgilerini_gorur() {
        assertTrue(dean.ssnSutunu.isDisplayed());

        int sutunSayisi = ReusableMethods.satirSayisiBul("Ssn");

        int i = 1;
        do {
            assertTrue(Driver.getDriver().findElement(By.xpath("//tr[" + i + "]//td[4]")).isDisplayed());
            assertTrue(Driver.getDriver().findElement(By.xpath("//tr[" + i + "]//td[4]")).getText().length() > 0);

            i++;

        } while (i <= sutunSayisi);

    }

    @Given("Admin User Name bilgilerini gorur")
    public void admin_user_name_bilgilerini_gorur() {
        assertTrue(dean.usernameSutunu.isDisplayed());

        int sutunSayisi = ReusableMethods.satirSayisiBul("User Name");

        int i = 1;
        do {
            assertTrue(Driver.getDriver().findElement(By.xpath("//tr[" + i + "]//td[5]")).isDisplayed());
            assertTrue(Driver.getDriver().findElement(By.xpath("//tr[" + i + "]//td[5]")).getText().length() > 0);

            i++;

        } while (i <= sutunSayisi);

    }

    @Given("Admin Delete butonunu gorur")
    public void admin_delete_butonunu_gorur() {




    }

    @Given("Admin Delete butonuna basar")
    public void admin_delete_butonuna_basar() {
      try {
         assertTrue(dean.deanListBolumu.getText().toLowerCase().contains("delete"));
      }catch (Exception e) {

      }finally {
          Driver.closeDriver();
      }

    }

    @Given("Admin Dean List'i gorur")
    public void admin_dean_list_i_gorur() {
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

    @Given("Admin Edit butonunu gorur")
    public void admin_edit_butonunu_gorur() {
        assertTrue(dean.firstEditButton.isDisplayed());


    }

    @Given("Admin Edit butonuna basar")
    public void admin_edit_butonuna_basar() {
        ReusableMethods.pageDown();
        ReusableMethods.clickByJavaScript(dean.firstEditButton);

    }

    @Given("Admin Edit Dean penceresini gorur")
    public void admin_edit_dean_penceresini_gorur() {
        ReusableMethods.bekle(1);
        assertTrue(dean.editDeanBolumBasligi.isDisplayed());

    }

    @Given("Admin degistirmek istedigi ismi Name kutusunda gorur")
    public void admin_degistirmek_istedigi_ismi_name_kutusunda_gorur() {
        assertTrue(dean.editName.isDisplayed());
        assertTrue(dean.editName.getAttribute("value").contains(name));
        ReusableMethods.bekle(2);


    }

    @Given("Admin degistirmek istedigi soyadi Surname kutusunda gorur")
    public void admin_degistirmek_istedigi_soyadi_surname_kutusunda_gorur() {
        assertTrue(dean.editSurname.isDisplayed());
        assertTrue(dean.editSurname.getAttribute("value").contains(surname));
    }

    @Given("Admin degistirmek istedigi dogum yerini Birth Place kutusunda gorur")
    public void admin_degistirmek_istedigi_dogum_yerini_birth_place_kutusunda_gorur() {
        assertTrue(dean.editBirthPlace.isDisplayed());
        assertTrue(dean.editBirthPlace.getAttribute("value").contains(birthPlace));

    }

    @Given("Admin degistirmek istedigi cinsiyeti Gender checkbox'inda gorur")
    public void admin_degistirmek_istedigi_cinsiyeti_gender_checkbox_inda_gorur() {
        ReusableMethods.bekle(3);
        try {
            assertTrue(dean.editGenderMale.isSelected());
        } catch (Exception e) {
            assertTrue(dean.editGenderFemale.isSelected());
        }



    }

    @Given("Admin degistirmek istedigi dogum tarihini Date Of Birth kutusunda gorur")
    public void admin_degistirmek_istedigi_dogum_tarihini_date_of_birth_kutusunda_gorur() {
        assertTrue(dean.editDateOfBirth.isDisplayed());
        assertTrue(dean.editDateOfBirth.getAttribute("value").contains(dateOfBirth));
        ReusableMethods.sendKeyWithJavaScript("01/01/1000", dean.dateOfBirth);
        ReusableMethods.bekle(2);


    }

    @Given("Admin degistirmek istedigi telefon numarasini Phone kutusunda gorur")
    public void admin_degistirmek_istedigi_telefon_numarasini_phone_kutusunda_gorur() {
        assertTrue(dean.editPhone.isDisplayed());
        assertTrue(dean.editPhone.getAttribute("value").contains(phone));
        ReusableMethods.bekle(2);
    }

    @Given("Admin degistirmek istedigi ssn bilgisini SSN kutusunda gorur")
    public void admin_degistirmek_istedigi_ssn_bilgisini_ssn_kutusunda_gorur() {
        assertTrue(dean.editSsn.isDisplayed());
        assertTrue(dean.editSsn.getAttribute("value").contains(ssn));

    }

    @Given("Admin degistirmek istedigi username'i User Name kutusunda gorur")
    public void admin_degistirmek_istedigi_username_i_user_name_kutusunda_gorur() {
        assertTrue(dean.editUserName.isDisplayed());
        assertTrue(dean.editUserName.getAttribute("value").contains(username));
        ReusableMethods.sendKeyWithJavaScript("12345678", dean.editPassword);
        ReusableMethods.bekle(3);

    }

    @Given("Admin degistirmek istedigi password'u Password kutusunda gorur")
    public void admin_degistirmek_istedigi_password_u_password_kutusunda_gorur() {
        ReusableMethods.bekle(3);
        assertTrue(dean.editPassword.isDisplayed());
        assertTrue(dean.editPassword.getAttribute("value").contains(password));
    }

    @Given("Admin Submit butonunu gorur")
    public void admin_submit_butonunu_gorur() {

        assertTrue(dean.editSubmit.isDisplayed());
    }

    @Given("Admin Submit butonuna tiklar")
    public void admin_submit_butonuna_tiklar() {
        try {
            ReusableMethods.webelementJavaScript("document.querySelector(\"body > div.fade.modal.show > div > div > div:nth-child(2) > div.modal-footer > button\")").click();
        } catch (Exception e) {

        }

    }

    @Given("Admin olarak {string} adresine gider")
    public void adminOlarakAdresineGider(String arg0) {



    }

    @Then("Admin olarak Login ikonunu tiklar")
    public void adminOlarakLoginIkonunuTiklar() {
    }

    @And("Admin olarak username kutusununa {string} girer")
    public void adminOlarakUsernameKutusununaGirer(String arg0) {

    }

    @And("Admin olarak password kutusuna {string} girer")
    public void adminOlarakPasswordKutusunaGirer(String arg0) {

    }

    @And("Admin olarak Login butonunu tiklar")
    public void adminOlarakLoginButonunuTiklar() {
        try{
            loginMethod("adminUsername", "deanPassword");
        }catch (Exception e){

        }
    }

    @And("Admin olarak Menu butonuna basar")
    public void adminOlarakMenuButonunaBasar() {
        deanBolumuGiris();

    }


    @And("Admin olarak Dean Management sayfasina gider")
    public void adminOlarakDeanManagementSayfasinaGider() {

    }

    @And("Admin olarak Dean Management linkini tiklar")
    public void adminOlarakDeanManagementLinkiniTiklar() {

    }

    @And("Admin kayit yapar")
    public void adminKayitYapar() {
        ReusableMethods.bekle(3);
        assertFalse(dean.requiredMessagePassword.isDisplayed());
        ReusableMethods.bekle(3);
        Driver.closeDriver();
    }
}
