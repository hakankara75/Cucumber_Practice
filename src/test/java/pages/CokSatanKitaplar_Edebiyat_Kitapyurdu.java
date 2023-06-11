package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class CokSatanKitaplar_Edebiyat_Kitapyurdu {

    public CokSatanKitaplar_Edebiyat_Kitapyurdu(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "(//li[@class='has-open-menu']/child::span)[1]")
    public WebElement cokSatanKitaplar;
    @FindBy(xpath = "//a[@href='index.php?route=product/best_sellers&list_id=16&filter_in_stock=1']")
    public WebElement cokSatanEdebiyat;
    @FindBy(xpath = "//a[@href='https://www.kitapyurdu.com/index.php?route=product/best_sellers&list_id=16&filter_in_stock=1']")
    public WebElement edebiyatButonu;
    @FindBy(xpath = "//input[@name='selected_in_stock' and @checked='checked']")
    public WebElement satistaOlanlar;
    @FindBy(xpath = "(//select[@onchange='location = this.value;'])[3]")
    public WebElement yirmiUrun;
    @FindBy(xpath = "//option[text()='100 Ürün']")
    public WebElement yuzUrun;

    @FindBy(xpath = "//div[@class='image']")
    public WebElement sergilenenkitaplar;

    @FindBy(xpath = "//select[@class='best-sellers-list-times-select']")
    public WebElement zamanAraligi;
    @FindBy(xpath = "((//div[@class='product-cr'])[8]/div/a)[1]")
    public WebElement kitaplar;
    @FindBy(xpath = "//div[@class='product-grid']")
    public WebElement kitaplarList;

}


