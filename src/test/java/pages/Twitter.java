package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class Twitter {

    public Twitter() {
        PageFactory.initElements(Driver.getDriver(), this);

    }

    @FindBy(xpath = "//div[@class='css-901oao r-1awozwy r-jwli3a r-6koalj r-18u37iz r-16y2uox r-37j5jr r-a023e6 r-b88u0q r-1777fci r-rjixqe r-bcqeeo r-q4m81j r-qvutc0']")
    public WebElement girisYap;
    @FindBy(xpath = "/login")
    public WebElement giris;
    @FindBy(xpath = "//input[@autocapitalize='sentences']")
    public WebElement epostaGir;
    @FindBy(xpath = "//div[@class='css-18t94o4 css-1dbjc4n r-sdzlij r-1phboty r-rs99b7 r-ywje51 r-usiww2 r-2yi16 r-1qi8awa r-1ny4l3l r-ymttw5 r-o7ynqc r-6416eg r-lrvibr r-13qz1uu']")
    public WebElement ileri;
    @FindBy(xpath = "//input[@name='password']")
    public WebElement sifreGir;
    @FindBy(xpath = "//div[@data-testid='LoginForm_Login_Button']")
    public WebElement sifreSonrasiGirisYap;
    @FindBy(xpath = "//div[@class='css-901oao css-1hf3ou5 r-18jsvk2 r-37j5jr r-adyw6z r-16dba41 r-135wba7 r-1joea0r r-88pszg r-bcqeeo r-qvutc0']")
    public WebElement ara;
    @FindBy(xpath = "//a[@href='/explorer']")
    public WebElement kesfet;
    @FindBy(xpath = "(//div[@class='css-1dbjc4n'])[2]")
    public WebElement home;
    @FindBy(xpath = "(//div[@class='css-901oao r-18jsvk2 r-37j5jr r-a023e6 r-b88u0q r-rjixqe r-1bymd8e r-bcqeeo r-qvutc0'])[1]")
    public WebElement hastagBir;
    @FindBy(xpath = "(//div[@class='css-901oao r-18jsvk2 r-37j5jr r-a023e6 r-b88u0q r-rjixqe r-1bymd8e r-bcqeeo r-qvutc0'])[2]")
    public WebElement hastagIki;
    @FindBy(xpath = "(//div[@class='css-901oao r-18jsvk2 r-37j5jr r-a023e6 r-b88u0q r-rjixqe r-1bymd8e r-bcqeeo r-qvutc0'])[3]")
    public WebElement hastagUc;
    @FindBy(xpath = "(//div[@class='css-901oao r-18jsvk2 r-37j5jr r-a023e6 r-b88u0q r-rjixqe r-1bymd8e r-bcqeeo r-qvutc0'])[4]")
    public WebElement hastagDort;
    @FindBy(xpath = "(//div[@class='css-901oao r-18jsvk2 r-37j5jr r-a023e6 r-b88u0q r-rjixqe r-1bymd8e r-bcqeeo r-qvutc0'])[5]")
    public WebElement hastagBes;
    @FindBy(xpath = "//a[@data-testid='SideNav_NewTweet_Button']")
    public WebElement tweetAt;
    @FindBy(xpath = "(//div[@data-testid='tweetTextarea_0'])[1]")
    public WebElement tweetYaz;
    @FindBy(xpath = "//div[@class='css-901oao r-1awozwy r-jwli3a r-6koalj r-18u37iz r-16y2uox r-37j5jr r-a023e6 r-b88u0q r-1777fci r-rjixqe r-bcqeeo r-q4m81j r-qvutc0']")
    public WebElement tweetleTusu;
    @FindBy(xpath = "//div[@class='css-18t94o4 css-1dbjc4n r-l5o3uw r-42olwf r-sdzlij r-1phboty r-rs99b7 r-19u6a5r r-2yi16 r-1qi8awa r-1ny4l3l r-ymttw5 r-o7ynqc r-6416eg r-lrvibr']")
    public WebElement tweetleTus2;
    @FindBy(id = "reload-button")
    public WebElement yenile;
    @FindBy(xpath = "(//div[@aria-label='Fotoğraf veya video ekle'])[1]")
    public WebElement fotografEkle;
}
