package pages.manage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.AmazonPage;

public class Dean_Listeleme_Silme extends AmazonPage {

    @FindBy(xpath = "(//li[@class='has-open-menu']/child::span)[1]")
    public WebElement cokSatanKitaplar;
    @FindBy(xpath = "//div[@class=' css-19bb58m']")
    public WebElement selectStudent;
    @FindBy(xpath = "(//a[@role='button'])[11]")
    public WebElement meetManagement;
    @FindBy(xpath = "//div[@class=' css-1p3m7a8-multiValue']")
    public WebElement student;



}
