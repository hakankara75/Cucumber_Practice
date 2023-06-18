package pages.manage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class US05_DeanGuncelleme_Silme_Page  {
    Kisi_Ekleme_Guncelleme_Modulu management = new Kisi_Ekleme_Guncelleme_Modulu();
    US04_AdminDeanEkleyebilmeli dean= new US04_AdminDeanEkleyebilmeli();

    @FindBy(xpath = "(//h5[@class='fw-bold p-3 card-header'])[1]")
    public WebElement addDeanBasligi;
    @FindBy(xpath = "(//h5[@class='fw-bold p-3 card-header'])[2]")
    public WebElement deanListBasligi;
    @FindBy(xpath = "//*[@id=\"root\"]/div/main/div/div[1]/div[3]/div/div/div[1]/table/thead/tr/th[1]")
    public WebElement nameSutunu;
    @FindBy(xpath = "//*[@id=\"root\"]/div/main/div/div[1]/div[3]/div/div/div[1]/table/thead/tr/th[2]")
    public WebElement genderSutunu;
    @FindBy(xpath = "//*[@id=\"root\"]/div/main/div/div[1]/div[3]/div/div/div[1]/table/thead/tr/th[3]")
    public WebElement phoneNumberSutunu;
    @FindBy(xpath = "//*[@id=\"root\"]/div/main/div/div[1]/div[3]/div/div/div[1]/table/thead/tr/th[4]")
    public WebElement ssnSutunu;
    @FindBy(xpath = "//*[@id=\"root\"]/div/main/div/div[1]/div[3]/div/div/div[1]/table/thead/tr/th[5]")
    public WebElement usernameSutunu;
    @FindBy(xpath = "//div[@class='mb-5 ms-3 me-3 text-center border border-3 shadow-sm bg-body rounded card border-warning']")
    public WebElement deanListBolumu;
    @FindBy(xpath = "(//input[@id='name'])[2]")
    public WebElement editBirthPlace;
    @FindBy(xpath = "(//input[@value='MALE'])[2]")
    public WebElement editGenderMale;
    @FindBy(xpath = "(//input[@value='FEMALE'])[2]")
    public WebElement editGenderFemale;
    @FindBy(xpath = "(//input[@id='birthDay'])[2]")
    public WebElement editDateOfBirth;
}
