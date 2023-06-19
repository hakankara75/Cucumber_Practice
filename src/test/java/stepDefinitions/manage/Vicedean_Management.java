package stepDefinitions.manage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import pages.manage.Kisi_Ekleme_Guncelleme_Modulu;
import utilities.Driver;
import utilities.Methods;
import utilities.ReusableMethods;

import static org.junit.Assert.assertTrue;

public class Vicedean_Management extends Methods {

    Kisi_Ekleme_Guncelleme_Modulu manage = new Kisi_Ekleme_Guncelleme_Modulu();

    @Then("Kullanici Login olur")
    public void kullaniciLoginOlur() {
        loginMethod("viceDeanUsername", "deanPassword");

    }

    @And("Admin Vicedean Management sayfasına gider")
    public void adminVicedeanManagementSayfasınaGider() {
        manage.lessonProgram.click();
        ReusableMethods.pageDown();
        for (int i = 1; i < 2; i++) {
            for (int k = 1; k < 2; k++) {
                String element = Driver.getDriver().findElement(By.xpath("(//*[@class='table-group-divider'])[3]/tr[" + i + "]/td[" + k + "]")).getText();
                System.out.println("element = " + element);

                String element1 = Driver.getDriver().findElement(By.xpath("(//*[@class='table-group-divider'])[3]/tr[" + i + "]/td[" + (k + 1) + "]")).getText();
                System.out.println("element1 = " + element1);

                String element2 = Driver.getDriver().findElement(By.xpath("(//*[@class='table-group-divider'])[3]/tr[" + i + "]/td[" + (k + 2) + "]")).getText();
                System.out.println("element2 = " + element2);

                String element3 = Driver.getDriver().findElement(By.xpath("(//*[@class='table-group-divider'])[3]/tr[" + i + "]/td[" + (k + 3) + "]")).getText();
                System.out.println("element3 = " + element3);

                assertTrue(element.contains("Cypress") && element1.contains("MONDAY") && element2.contains("10:30:00") && element3.contains("15:30:00"));

            }


        }
    }
}
