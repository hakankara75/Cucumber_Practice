package pages.others1;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class MynetPage {
    public MynetPage() {
        PageFactory.initElements(Driver.getDriver(), this);

    }

    @FindBy(xpath = "//a[@title='Eğitim']/span")
    public WebElement egitim;

    @FindBy(xpath = "//div[@class='card home-universite-bolumleri']")
    public WebElement universiteBolumleri;
    @FindBy(xpath = "//a[@title='Sayısal Bölümlerin Taban Puanları']")
    public WebElement sayisalBolumler;
    @FindBy(xpath = "//h1[@class='mb-2 p-0']")
    public WebElement baslik;
    @FindBy(xpath = "//a[@href='https://www.mynet.com/egitim/tip-taban-puanlari-ve-basari-siralamasi']")
    public WebElement tip;



}
