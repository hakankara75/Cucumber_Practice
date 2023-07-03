package utilities;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import pages.manage.Kisi_Ekleme_Guncelleme_Modulu;
import pages.manage.Login_Modulu;

import java.time.Duration;

import static utilities.ReusableMethods.clickByJavaScript;

public class US04_US05_Methods extends US04_05 implements US04_05_Methods {
    static Kisi_Ekleme_Guncelleme_Modulu kisi = new Kisi_Ekleme_Guncelleme_Modulu();
    Login_Modulu login = new Login_Modulu();

    US19_US20_US21_TeacherMeetingVeStudentNotesModulu page = new US19_US20_US21_TeacherMeetingVeStudentNotesModulu();


    /**
     *
     */
    @Override
    public void addDeanClick() {

            try {
                ReusableMethods.bekle(2);
                kisi.menu.click();
                ReusableMethods.bekle(2);
                kisi.deanManagement.click();
                ReusableMethods.bekle(2);
            } catch (Exception e) {

            }
    }

    /**
     *
     */
    @Override
    public void loginMethod() {

    }

    @Override
    public void milisaniyeBekle() {

    }

    @Override
    public void loginMethod(String username, String password) {
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        page.login.click();

        switch (username) {
            case "adminUsername":
                login.username.sendKeys(ConfigReader.getProperty("adminUsername"));
                break;
            case "deanUsername":
                login.username.sendKeys(ConfigReader.getProperty("deanUsername"));
                break;
            case "viceDeanUsername":
                login.username.sendKeys(ConfigReader.getProperty("viceDeanUsername"));
                break;
            case "teacherUsername":
                login.username.sendKeys(ConfigReader.getProperty("teacherUsername"));
                break;
            case "studentUsername":
                login.username.sendKeys(ConfigReader.getProperty("studentUsername"));
                break;

            default:
                break;

        }

        login.password.sendKeys(ConfigReader.getProperty(password));

        //login.uyeGirisKismiLoginButton.click();
        clickByJavaScript(login.uyeGirisKismiLoginButton);
    }


        public void alertWait1(WebElement alert){
            Wait<WebDriver> wait = new FluentWait<>(Driver.getDriver()).
                    withTimeout(Duration.ofSeconds(3)).//Fluent wait için max. süreyi belirtir
                            pollingEvery(Duration.ofSeconds(1)).//Her bir saniyede webelementi kontrol eder
                            withMessage("Ignore Exeption").//zorunlu değil
                            ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.visibilityOf(alert));
        }
        public void alertWait2() throws InterruptedException {
            int count = 0;
            while (count<10)
            {
                try
                {
                    Driver.getDriver().switchTo().alert();
                    break;
                }
                catch (Exception error)
                {
                    Thread.sleep(100);
                }
                count++;
            }
        }

    /**
     *
     */
    @Override
    public void deanBolumuGiris() {
        login.menu.click();
        login.deanManagement.click();
    }

    public void milisaniyeBekle(int milisaniye){
            try {
                Thread.sleep(milisaniye);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

