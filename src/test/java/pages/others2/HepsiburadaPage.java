package pages.others2;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class HepsiburadaPage {

    public HepsiburadaPage() {
        PageFactory.initElements(Driver.getDriver(), this);

    }
    @FindBy(xpath = "//div[@class='searchBoxOld-M1esqHPyWSuRUjMCALPK']")
    public WebElement aramaKutusu;
    @FindBy(xpath = "//div[@role='combobox']/input")
    public WebElement aramaKutusu1;
}
