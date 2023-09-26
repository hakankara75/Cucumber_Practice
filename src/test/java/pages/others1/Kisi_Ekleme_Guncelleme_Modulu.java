package pages.others1;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class Kisi_Ekleme_Guncelleme_Modulu {
    public Kisi_Ekleme_Guncelleme_Modulu() {
        PageFactory.initElements(Driver.getDriver(), this);

    }

    @FindBy(xpath = "//input[@id='name']")
    public WebElement name;
    @FindBy(xpath = "//input[@id='surname']")
    public WebElement surname;
    @FindBy(xpath = "(//a[@role='button'])[10]")
    public WebElement adminManagement;
    @FindBy(xpath = "//a[text()='Dean Management']")
    public WebElement deanManagement;
    @FindBy(xpath = "(//a[@role='button'])[12]")
    public WebElement viceDeanManagement;
    @FindBy(xpath = "(//a[@role='button'])[13]")
    public WebElement lessonManagement;
    @FindBy(xpath = "(//a[@role='button'])[14]")
    public WebElement teacherManagement;
    @FindBy(xpath = "(//a[@role='button'])[15]")
    public WebElement studentManagement;
    @FindBy(xpath = "(//a[@role='button'])[16]")
    public WebElement studentInfoManagement;
    @FindBy(xpath = "(//a[@role='button'])[17]")
    public WebElement meetManagement;
    @FindBy(xpath = "(//a[@role='button'])[18]")
    public WebElement chooseLessonMenu;
    @FindBy(xpath = "(//a[@role='button'])[19]")
    public WebElement contactGetAll;
    @FindBy(xpath = "(//a[@role='button'])[20]")
    public WebElement getUser;
    @FindBy(xpath = "(//a[@role='button'])[21]")
    public WebElement logOut;
    @FindBy(xpath = "//input[@id='birthPlace']")
    public WebElement birthPlace;
    @FindBy(xpath = "//input[@value='FEMALE']")
    public WebElement female;
    @FindBy(xpath = "//input[@value='MALE']")
    public WebElement male;
    @FindBy(xpath = "//input[@id='birthDay']")
    public WebElement dateOfBirth;
    @FindBy(xpath = "//input[@id='phoneNumber']")
    public WebElement phoneNumber;
    @FindBy(xpath = "//input[@id='ssn']")
    public WebElement ssn;
    @FindBy(xpath = "//button[text()='Submit']")
    public WebElement submit;

    @FindBy(xpath = "//button[text()='Menu']")
    public WebElement menu;

    @FindBy(xpath = "//body/div[3]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/form[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]")
    public WebElement chooseLessonTextBox;
    @FindBy(xpath = "(//input[@id='name'])[2]")
    public WebElement editName;
    @FindBy(xpath = "(//input[@id='surname'])[2]")
    public WebElement editSurname;
    @FindBy(xpath = "(//input[@id='birthPlace'])[2]")
    public WebElement editBirthPlace;
    @FindBy(xpath = "//body/div[3]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/form[1]/div[2]/div[1]/div[1]/input[1]")
    public WebElement editEmail;
    @FindBy(xpath = "(//input[@id='phoneNumber'])[2]")
    public WebElement editPhone;
    @FindBy(xpath = "(//input[@id='ssn'])[2]")
    public WebElement editSsn;
    @FindBy(xpath = "//body/div[3]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/form[1]/div[2]/div[4]/div[1]/input[1]")
    public WebElement isAdvisorTeacher;

    @FindBy(xpath = "(//input[@value='FEMALE'])[2]")
    public WebElement editGenderFemale;
    @FindBy(xpath = "(//input[@value='MALE'])[2]")
    public WebElement editGenderMale;
    @FindBy(xpath = "(//input[@id='birthDay'])[2]")
    public WebElement editDateOfBirth;
    @FindBy(xpath = "(//input[@id='username'])[2]")
    public WebElement editUserName;
    @FindBy(xpath = "(//input[@id='password'])[2]")
    public WebElement editPassword;
    @FindBy(xpath = "(//button[text()='Submit'])[2]")
    public WebElement editSubmit;
    @FindBy(xpath = "(//button[@type='button'])[7]")
    public WebElement firstEditButton;

    @FindBy(xpath = "//div[@class='text-center modal-title h4']")
    public WebElement editDeanBolumBasligi;

    @FindBy(xpath = "//input[@id='name']")
    public WebElement addName;
    @FindBy(xpath = "//input[@id='surname']")
    public WebElement addSurname;

    @FindBy(xpath = "(//div[@class='invalid-feedback'])[1]")
    public WebElement requiredMessageName;
    @FindBy(xpath = "(//div[@class='invalid-feedback'])[2]")
    public WebElement requiredMessageSurname;
    @FindBy(xpath = "(//div[@class='invalid-feedback'])[3]")
    public WebElement requiredMessageBirthPlace;
    @FindBy(xpath = "(//div[@class='invalid-feedback'])[4]")
    public WebElement requiredMessageDateOfBirth;
    @FindBy(xpath = "(//div[@class='invalid-feedback'])[5]")
    public WebElement requiredMessagePhone;
    @FindBy(xpath = "(//div[@class='invalid-feedback'])[6]")
    public WebElement requiredMessageSsn;

    @FindBy(xpath = "(//div[@class='invalid-feedback'])[7]")
    public WebElement requiredMessageUserName;
    @FindBy(xpath = "(//div[@class='invalid-feedback'])[8]")
    public WebElement requiredMessagePassword;
    @FindBy(xpath = "(//div[@class='Toastify__toast-body'])[1]")
    public WebElement alertMessage;

    @FindBy(xpath = "//input[@id='username']")
    public WebElement username;

    @FindBy(xpath = "//input[@id='password']")
    public WebElement loginPasword;
    @FindBy(xpath = "(//div[@class='Toastify__toast-body'])[1]")
    public WebElement nameShouldTwo;
    @FindBy(xpath = "//div[@class='Toastify__toast-container Toastify__toast-container--top-center']")
    public WebElement saveMessage;
}


