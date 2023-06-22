package pages.manage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class US05_DeanGuncelleme_Silme_Modulu extends Login_Modulu{

    @FindBy(xpath = "(//h5[@class='fw-bold p-3 card-header'])[1]")
    public WebElement addDeanBasligi;
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






}
