package stepDefinitions;

import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.Dean_Listeleme_Silme;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.List;

public class General_Management  {
    Dean_Listeleme_Silme management= new Dean_Listeleme_Silme();
    @Then("Kullanici meet management linkini tiklar")
    public void kullanici_meet_management_linkini_tiklar() {
        management.meetManagement.click();
    }
    @Then("Kullanici student tiklar")
    public void kullanici_student_tiklar() {
        ReusableMethods.bekle(2);
        management.selectStudent.click();

      List<WebElement> liste= Driver.getDriver().findElements(By.xpath("//div[@class=' css-1nmdiq5-menu']"));
        System.out.println("liste.size() = " + liste.size());

        for (int i = 0; i < liste.size(); i++) {
            System.out.println("element.getText() = " + liste.get(i).getText());
            liste.get(i).click();
            ReusableMethods.bekle(2);

        }

    }
    @Then("Kullanici student secer")
    public void kullanici_student_secer() {
        Driver.closeDriver();
    }
}
