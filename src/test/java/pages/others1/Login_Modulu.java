package pages.others1;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Login_Modulu extends Kisi_Ekleme_Guncelleme_Modulu{

    @FindBy(xpath = "//input[@id='username']")
    public WebElement username;
    @FindBy(xpath = "//input[@id='password']")
    public WebElement password;
    @FindBy(xpath = "//a[@href='/login']")
    public WebElement login;
    @FindBy(xpath = "(//button[@type='button'])[3]")
    public WebElement uyeGirisKismiLoginButton;

}



