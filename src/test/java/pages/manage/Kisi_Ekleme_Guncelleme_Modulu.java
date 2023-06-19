package pages.manage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.AmazonPage;

public class Kisi_Ekleme_Guncelleme_Modulu extends AmazonPage {

    @FindBy(xpath = "//a[@href='/login']")
    public WebElement login;
    @FindBy(xpath = "//input[@id='name']")
    public WebElement name;
    @FindBy(xpath = "//input[@id='surname']")
    public WebElement surname;
    @FindBy(xpath = "(//a[@role='button'])[10]")
    public WebElement adminManagement;
    @FindBy(xpath = "(//a[@role='button'])[11]")
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
    @FindBy(xpath = "(//button[@type='button'])[5]")
    public WebElement submit;
    @FindBy(xpath = "//input[@id='password']")
    public WebElement loginPasword;
    @FindBy(xpath = "//input[@id='username']")
    public WebElement username;
    @FindBy(xpath = "//button[@aria-controls='offcanvasNavbar-expand-false']")
    public WebElement menu;
    @FindBy(xpath = "(//button[@type='button'])[3]")
    public WebElement UyeGirisKismiLoginButton;
    @FindBy(xpath = "//body/div[3]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/form[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]")
    public WebElement chooseLessonTextBox;
    @FindBy(xpath = "//body/div[3]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/form[1]/div[1]/div[2]/div[1]/input[1]")
    public WebElement editName;
    @FindBy(xpath = "//body/div[3]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/form[1]/div[1]/div[3]/div[1]/input[1]")
    public WebElement editSurname;
    @FindBy(xpath = "//body/div[3]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/form[1]/div[1]/div[4]/div[1]/input[1]")
    public WebElement editBirthPlace;
    @FindBy(xpath = "//body/div[3]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/form[1]/div[2]/div[1]/div[1]/input[1]")
    public WebElement editEmail;
    @FindBy(xpath = "//body/div[3]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/form[1]/div[2]/div[2]/div[1]/input[1]")
    public WebElement editPhone;
    @FindBy(xpath = "//body/div[3]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/form[1]/div[2]/div[3]/div[1]/input[1]")
    public WebElement editSsn;
    @FindBy(xpath = "//body/div[3]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/form[1]/div[2]/div[4]/div[1]/input[1]")
    public WebElement isAdvisorTeacher;

    @FindBy(xpath = "//body/div[3]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/form[1]/div[2]/div[5]/div[1]/div[1]/div[1]/input[1]")
    public WebElement editFemale;
    @FindBy(xpath = "//body/div[3]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/form[1]/div[2]/div[5]/div[1]/div[2]/div[1]/input[1]")
    public WebElement editMale;
    @FindBy(xpath = "//body/div[3]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/form[1]/div[3]/div[1]/div[1]/input[1]")
    public WebElement editDateOfBirth;
    @FindBy(xpath = "//body/div[3]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/form[1]/div[3]/div[2]/div[1]/input[1]")
    public WebElement editUserName;
    @FindBy(xpath = "//body/div[3]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/form[1]/div[3]/div[3]/div[1]/input[1]")
    public WebElement editPassword;
    @FindBy(xpath = "//body/div[3]/div[1]/div[1]/div[2]/div[2]/button[1]")
    public WebElement editSubmit;
    @FindBy(xpath = "(//button[@type='button'])[8]")
    public WebElement firstEditButton;
    @FindBy(xpath = "//div[@class='text-center modal-title h4']")
    public WebElement editDeanBolumBasligi;
    @FindBy(id = "controlled-tab-example-tab-lessonProgram")
    public WebElement lessonProgram;
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
}
