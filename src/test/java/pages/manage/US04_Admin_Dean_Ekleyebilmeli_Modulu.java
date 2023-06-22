package pages.manage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class US04_Admin_Dean_Ekleyebilmeli_Modulu extends Kisi_Ekleme_Guncelleme_Modulu {
    @FindBy(xpath = "//h3[@class='fw-bold p-3 card-header']")
    public WebElement deanManagementBolumu;
    @FindBy(xpath = "//div[@class='mt-5 ms-3 me-3 mb-5 text-center border border-3 shadow-sm bg-body rounded card border-warning']")
    public WebElement addDeanClass;





}
