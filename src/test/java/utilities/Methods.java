package utilities;

import pages.others1.Login_Modulu;

public class Methods {
    Login_Modulu login = new Login_Modulu();
    public void loginMethod(String username, String password) {
        Driver.getDriver().get(ConfigReader.getProperty("manageUrl"));
        login.login.click();

        switch (username){
            case "adminUsername":

                login.username.sendKeys(ConfigReader.getProperty("adminUsername"));
                break;
            case "deanName":
                login.username.sendKeys(ConfigReader.getProperty("deanName"));
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

        login.loginPasword.sendKeys(ConfigReader.getProperty(password));

        login.uyeGirisKismiLoginButton.click();

    }

    public void addDean(){
        ReusableMethods.bekle(2);
        login.menu.click();
        ReusableMethods.bekle(2);
        login.deanManagement.click();
        ReusableMethods.bekle(2);

    }

}
