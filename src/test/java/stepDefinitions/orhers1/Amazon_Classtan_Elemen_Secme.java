package stepDefinitions.orhers1;

import io.cucumber.java.en.Then;
import pages.others1.AmazonPage;

import static org.testng.AssertJUnit.assertTrue;

public class Amazon_Classtan_Elemen_Secme {

    AmazonPage amazonPage = new AmazonPage();
    @Then("kullanici imagelerin gorunur oldugunu sirayla kontrol eder")
    public void kullanici_imagelerin_gorunur_oldugunu_sirayla_kontrol_eder() {

        assertTrue(amazonPage.image.isDisplayed());
        assertTrue(amazonPage.image2.isDisplayed());
        assertTrue(amazonPage.image3.isDisplayed());
        assertTrue(amazonPage.image4.isDisplayed());
        assertTrue(amazonPage.image5.isDisplayed());
    }

}
