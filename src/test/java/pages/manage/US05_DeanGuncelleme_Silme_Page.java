package pages.manage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.AmazonPage;

public class US05_DeanGuncelleme_Silme_Page extends AmazonPage {
    @FindBy(xpath = "(//h5[@class='fw-bold p-3 card-header'])[1]")
    public WebElement addDean;
    @FindBy(xpath = "(//h5[@class='fw-bold p-3 card-header'])[2]")
    public WebElement deanList;
}
