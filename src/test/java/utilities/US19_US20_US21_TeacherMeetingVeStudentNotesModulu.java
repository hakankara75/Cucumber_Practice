package utilities;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class US19_US20_US21_TeacherMeetingVeStudentNotesModulu {
    public US19_US20_US21_TeacherMeetingVeStudentNotesModulu() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "(//button[@type='button'])[1]")
    public WebElement menu;
    @FindBy(xpath = "//input[@id='username']")
    public WebElement username;
    @FindBy(xpath = "//input[@id='password']")
    public WebElement password;
   @FindBy(xpath = "(//button[@type='button'])[3]")
  public WebElement login2;
    @FindBy(xpath = "//a[@href='/login']")
    public WebElement login;
    @FindBy(xpath = "//button[text()='Login']")
    public WebElement login3;
    @FindBy(xpath = "//h3")
    public WebElement StudentManagementInfo;
    @FindBy(xpath = "//span[text()='TeacherKemal']")
    public WebElement teacherName;
    @FindBy(xpath = "//a[text()='Meet Management']")
    public WebElement meetManagement;
    @FindBy(xpath = "(//div[text()='Main Menu'])[2]")
    public WebElement mainMenu;
    @FindBy(xpath = "//h3")
    public WebElement meetManagementText;
    @FindBy(xpath = "//div[@class=' css-19bb58m']")
    public WebElement chooseStudentBox;

    @FindBy(xpath = "//input[@id='date']")
    public WebElement date;
    @FindBy(xpath = "//input[@id='startTime']")
    public WebElement startTime;
    @FindBy(xpath = "//input[@id='stopTime']")
    public WebElement stopTime;
    @FindBy(xpath = "//*[@id='description']")
    public WebElement description;
    @FindBy(xpath = "(//button[@type='button'])[5]")
    public WebElement submit;

    @FindBy(xpath = "//div[@class=' css-1nmdiq5-menu']")
    public List<WebElement> list;
    @FindBy(xpath = "//div[text()='Kemal ARZU']")
    public WebElement selectedName;
    @FindBy(xpath = "//div[@class='Toastify']")
    public WebElement message;
    @FindBy(xpath = "(//h5)[2]")
    public WebElement meetList;
    @FindBy(xpath = "//*[@id=\"root\"]//thead/tr/th[1]")
    public WebElement tableDate;
    @FindBy(xpath = "//*[@id=\"root\"]//thead/tr/th[2]")
    public WebElement startTimeTable;
    @FindBy(xpath = "//*[@id=\"root\"]//thead/tr/th[3]")
    public WebElement stopTimeTable;
    @FindBy(xpath = "(//*[@id=\"description\"])[2]")
    public WebElement descriptionTable;
    @FindBy(xpath = "//*[@id=\"root\"]/div/main/div/div[1]/div[3]/div/div/div[1]/table/tbody/tr[3]/td[5]/span/button")
    public WebElement edit;
    @FindBy(xpath = "(//input[@id='date'])[2]")
    public WebElement editDate;
    @FindBy(xpath = "(//input[@id='startTime'])[2]")
    public WebElement editStartTime;
    @FindBy(xpath = "(//input[@id='stopTime'])[2]")
    public WebElement editStopTime;
    @FindBy(xpath = "(//input[@placeholder='Description'])[2]")
    public WebElement editDescription;
    @FindBy(xpath = "(//button[@type='button'])[47]")
    public WebElement editSubmit;
    @FindBy(xpath = "(//div[@class=' css-hlgwow'])[2]")
    public WebElement chooseStudentBox2;

    @FindBy(xpath = "//*[@class='Toastify__toast Toastify__toast-theme--colored Toastify__toast--error Toastify__toast--close-on-click']")
    public WebElement hata;
    @FindBy(xpath = "//*[@class='Toastify__toast Toastify__toast-theme--colored Toastify__toast--success Toastify__toast--close-on-click']")
    public WebElement onay;
  @FindBy(xpath = "//*[@id=\"root\"]/div/main/div/div[1]/div[3]/div/div/div[1]/table/tbody/tr[3]/td[4]/span")
  public WebElement silineceMeetinginDescriptionu;
  @FindBy(xpath = "//*[@id=\"root\"]/div/main/div/div[1]/div[3]/div/div/div[1]/table/tbody/tr[3]/td[3]/span")
  public WebElement silinecekMeetinginStopTime;
  @FindBy(xpath = "//*[@id=\"root\"]/div/main/div/div[1]/div[3]/div/div/div[1]/table/tbody/tr[3]/td[2]/span")
  public WebElement silinecekMeetinginStartTime;
  @FindBy(xpath = "//*[@id=\"root\"]/div/main/div/div[1]/div[3]/div/div/div[1]/table/tbody/tr[3]/td[1]/span")
  public WebElement silinecekMeetinginDate;
  @FindBy(xpath = "//*[@id=\"root\"]/div/main/div/div[1]/div[3]/div/div/div[1]/table/tbody/tr[3]/td[6]/span/button")
  public WebElement delete;


    @FindBy(xpath = "//table[@class='table table-striped table-bordered table-hover']")
    public List<WebElement> table;
    @FindBy(xpath = "//tr[td/span[text()='2023-12-12']][td/span[text()='11:00:00']][td/span[text()='13:00:00']][td/span[text()='dersDurumu ']]")
    public WebElement row;
    @FindBy(xpath = "//span[text()='AtabeyArzu']")
    public WebElement studentName;
    @FindBy(xpath = "//h3")
    public WebElement chooseLessonManagement;
    @FindBy(xpath = "//input[@value='4']")
    public WebElement dorduncuDers;
    @FindBy(xpath = "//input[@value='5']")
    public WebElement ders1;
    @FindBy(xpath = "//input[@value='7']")
    public WebElement ders2;
    @FindBy(xpath = "//*[@id=\"root\"]/div/main/div/div[1]/div[2]/div/div/div/div[1]/table/thead/tr/th[3]")
    public WebElement teacher;
    @FindBy(xpath = "//*[@id=\"root\"]/div/main/div/div[1]/div[2]/div/div/div/div[1]/table/thead/tr/th[3]//following-sibling::td")
    public List<WebElement> teacherCells;
    @FindBy(xpath = "//*[@id=\"root\"]/div/main/div/div[1]/div[2]/div/div/div/div[1]/table/thead/tr/th[2]")
    public WebElement lessons;
    @FindBy(xpath = "//*[@id=\"root\"]/div/main/div/div[1]/div[2]/div/div/div/div[1]/table/thead/tr/th[4]")
    public WebElement day;

    @FindBy(xpath = "//*[@id=\"root\"]/div/main/div/div[1]/div[2]/div/div/div/div[1]/table/thead/tr/th[5]")
    public WebElement StudentstartTime;
    @FindBy(xpath = "//*[@id=\"root\"]/div/main/div/div[1]/div[2]/div/div/div/div[1]/table/thead/tr/th[6]")
    public WebElement StudentstopTime;
    @FindBy(xpath = "//*[@id=\"root\"]/div/main/div/div[1]/div[2]/div/div/div/div[1]/table/thead/tr/th[2]//following-sibling::td")
    public List<WebElement> lessonsCells;
    @FindBy(xpath = "//*[@id=\"root\"]/div/main/div/div[1]/div[2]/div/div/div/div[1]/table/thead/tr/th[4]//following-sibling::td")
    public List<WebElement> dayCells;
    @FindBy(xpath = "//*[@id=\"root\"]/div/main/div/div[1]/div[2]/div/div/div/div[1]/table/thead/tr/th[5]//following-sibling::td")
    public List<WebElement> startTimeCells;
    @FindBy(xpath = "//*[@id=\"root\"]/div/main/div/div[1]/div[2]/div/div/div/div[1]/table/thead/tr/th[6]//following-sibling::td")
    public List<WebElement> stopTimeCells;
    @FindBy(xpath = "//h5")
    public WebElement lessonProgramList;
    @FindBy(xpath = "//*[@id=\"root\"]/div/main/div/div[1]/div[3]/div/div/div/div/table/tbody/tr[1]/td[1]/span[text()='Java']")
    public WebElement sectigiBirinciDers;
    @FindBy(xpath = "//*[@id='root']/div/main/div/div[1]/div[3]/div/div/div/div/table/tbody/tr/td[contains(text(),'Average')]//following-sibling::td")
    public List<WebElement> lessonsList;
    @FindBy(xpath = "(//a[@role='button'])[7]")
    public WebElement gradesAndAnnouncements;
    @FindBy(xpath = "//*[@id=\"root\"]/div/main/div/div/div[1]/div/div/div[1]/table//tr")
    public List<WebElement> studentNoteTable;
    @FindBy(xpath = "(//h5)[2]")
    public WebElement meetListTable;

    @FindBy(xpath = "//*[@id=\"root\"]/div/main/div/div/div[2]/div/div/div/table//tr")
    public List<WebElement> descriptionWebTable;



}
