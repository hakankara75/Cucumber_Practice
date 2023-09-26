package pages.others1;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class US04_US05_Dean_Ekleme_Guncelleme_Silme_Modulu extends Login_Modulu{

    @FindBy(xpath = "//*[@id=\"root\"]/div/main/div/div[1]/div[3]/div/div/div[1]/table/thead/tr/th[3]")
    public WebElement deanList;
    @FindBy(xpath = "(//h5[@class='fw-bold p-3 card-header'])[2]")
    public WebElement deanListBasligi;
    @FindBy(xpath = "//th[text()='Name']")
    public WebElement nameSutunu;
    @FindBy(xpath = "//th[text()='Gender']")
    public WebElement genderSutunu;
    @FindBy(xpath = "//th[text()='Phone Number']")
    public WebElement phoneNumberSutunu;
    @FindBy(xpath = "//th[text()='Ssn']")
    public WebElement ssnSutunu;
    @FindBy(xpath = "//th[text()='User Name']")
    public WebElement usernameSutunu;
    @FindBy(xpath = "//div[@class='mb-5 ms-3 me-3 text-center border border-3 shadow-sm bg-body rounded card border-warning']")
    public WebElement deanListBolumu;

    @FindBy(xpath = "//h3[@class='fw-bold p-3 card-header']")
    public WebElement deanManagementBolumu;
    @FindBy(xpath = "//div[@class='mt-5 ms-3 me-3 mb-5 text-center border border-3 shadow-sm bg-body rounded card border-warning']")
    public WebElement addDeanClass;





}
