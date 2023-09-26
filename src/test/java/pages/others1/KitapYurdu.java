package pages.others1;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class KitapYurdu {
    public KitapYurdu() {
        PageFactory.initElements(Driver.getDriver(), this);

    }

    @FindBy(xpath = "(//li[@class='has-open-menu'])[1]")
    public WebElement cokSatanKitaplar;
    @FindBy(xpath = "//a[@href='index.php?route=product/best_sellers&list_id=16&filter_in_stock=1']")
    public WebElement cokSatanEdebiyatKitaplari;
    @FindBy(xpath = "(//select[@onchange='location = this.value;'])[3]")
    public WebElement yirmiUrun;

    @FindBy(xpath = "(//div[@class='price-new '])[1]")
    public WebElement ilkUrun;
    @FindBy(xpath = "(//div[@class='price-new '])[100]")
    public WebElement sonUrun;
    @FindBy(xpath = "(//select[@onchange='location = this.value;'])[2]")
    public WebElement varsayilan;
}
