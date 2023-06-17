package pages.manage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.AmazonPage;

public class US05_DeanGuncelleme_Silme_Page extends AmazonPage {
    @FindBy(xpath = "(//h5[@class='fw-bold p-3 card-header'])[1]")
    public WebElement addDeanBasligi;
    @FindBy(xpath = "(//h5[@class='fw-bold p-3 card-header'])[2]")
    public WebElement deanListBasligi;
    @FindBy(xpath = "//*[@id=\"root\"]/div/main/div/div[1]/div[3]/div/div/div[1]/table/thead/tr/th[1]")
    public WebElement nameSutunu;
}
