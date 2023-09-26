package stepDefinitions.others2;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.others2.HepsiburadaPage;
import utilities.Driver;

public class Hepsiburada {

    HepsiburadaPage hepsiburada=new HepsiburadaPage();
    @Given("siteye git")
    public void siteye_git() {
        Driver.getDriver().get("https://www.hepsiburada.com");
    }
    @Then("arama cubuguna {string} yaz")
    public void arama_cubuguna_yaz(String string) {
       hepsiburada.aramaKutusu.click();

       hepsiburada.aramaKutusu1.sendKeys(string);
    }

}
