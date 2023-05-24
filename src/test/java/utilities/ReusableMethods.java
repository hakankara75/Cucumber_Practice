package utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ReusableMethods {
    //TestBase class'ından Obje oluşturmanın önüne geçilmesi için abstract yapılabilir
    //Orn: TestBase base = new TestBase()
    //Bu class'a extends ettiğimiz test classlarından ulaşabiliriz

    //HARD WAIT METHOD
    public static void bekle(int saniye){
        try {
            Thread.sleep(saniye*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    //Alert ACCEPT
    public static void alertAccept(){
        Driver.getDriver().switchTo().alert().accept();
    }
    //Alert DISMISS
    public static void alertDismiss(){
        Driver.getDriver().switchTo().alert().dismiss();
    }
    //Alert getText()
    public static void alertText(){
        Driver.getDriver().switchTo().alert().getText();
    }
    //Alert promptBox
    public static void alertprompt(String text){
        Driver.getDriver().switchTo().alert().sendKeys(text);
    }
    //DropDown VisibleText
    /*
        Select select2 = new Select(gun);
        select2.selectByVisibleText("7");
        //ddmVisibleText(gun,"7"); --> Yukarıdaki kullanım yerine sadece method ile handle edebilirim
     */
    public static void ddmVisibleText(WebElement ddm,String secenek){
        Select select = new Select(ddm);
        select.selectByVisibleText(secenek);
    }
    //DropDown Index
    public static void ddmIndex(WebElement ddm,int index){
        Select select = new Select(ddm);
        select.selectByIndex(index);
    }
    //DropDown Value
    public static void ddmValue(WebElement ddm,String secenek){
        Select select = new Select(ddm);
        select.selectByValue(secenek);
    }
    //SwitchToWindow1
    public static void switchToWindow(int sayi){
        List<String> tumWindowHandles = new ArrayList<String>(Driver.getDriver().getWindowHandles());
        Driver.getDriver().switchTo().window(tumWindowHandles.get(sayi));
    }
    //SwitchToWindow2
    public static void window(int sayi){
        Driver.getDriver().switchTo().window(Driver.getDriver().getWindowHandles().toArray()[sayi].toString());
    }
    //EXPLICIT WAIT METHODS
    //Visible Wait
    public static void visibleWait(WebElement element,int sayi){
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(sayi));
        wait.until(ExpectedConditions.visibilityOf(element));
    }
    //VisibleElementLocator Wait
    public static WebElement visibleWait(By locator, int sayi){
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(sayi));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    //Alert Wait
    public static void alertWait(int sayi){
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(sayi));
        wait.until(ExpectedConditions.alertIsPresent());
    }
    //Tüm Sayfa ScreenShot
    public static void tumSayfaScreenShoot(){
        String tarih = new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());
        String dosyaYolu = "TestOutput/screenshot"+tarih+".png";
        TakesScreenshot ts = (TakesScreenshot) Driver.getDriver();
        try {
            FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE),new File(dosyaYolu));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    //WebElement ScreenShot
    public static void webElementScreenShoot(WebElement element){
        String tarih = new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());
        String dosyaYolu = "TestOutput/webElementScreenshot"+tarih+".png";
        try {
            FileUtils.copyFile(element.getScreenshotAs(OutputType.FILE),new File(dosyaYolu));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //bu metot ile herhangi bir webelemente JavascriptExecutor kullanarak tiklayabilirim
    public static void clickByJavaScript(WebElement webElement){
        JavascriptExecutor jse= (JavascriptExecutor) Driver.getDriver();

        jse.executeScript("arguments[0].click();", webElement);

    }

    public static void scrollIntoViewByJavaScript(WebElement webElement){
        JavascriptExecutor jse=(JavascriptExecutor) Driver.getDriver();//Casting
        jse.executeScript("arguments[0].scrollIntoView(true);",webElement);

    }

    //bu metot ile sayfayi en alta kaydirabilirim
    public static void scrollEndByJavaScript(){
               JavascriptExecutor js= (JavascriptExecutor) Driver.getDriver();
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
    }
    /** Bu metot ile select objesinin indexi ile secim yapilir
     *
     * @param webElement elementin locatidir
     * @param str   secilecek index numarasidir
     */
    public static void selectByIndexWithJavascript(WebElement webElement, String str) {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].selectedIndex = "+str+"; arguments[0].dispatchEvent(new Event('change'))", webElement);
    }

    /** Bu metot ile select objesinin value'su ile secim yapilir
     *
     * @param webElement elementin locatidir
     * @param str   gonderilecek value degeridir
     */
    public static void selectByValueWithJavascript(WebElement webElement, String str) {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].value = "+str+"; arguments[0].dispatchEvent(new Event('change'))", webElement);
    }

    //elemente JavascriptExecutor ile string gonderir(java sendkey() ile ayni)
    public static void sendKeyWithJavaScript(String string, WebElement webElement) {
        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();//Casting
        jse.executeScript("arguments[0].value = '"+string+"';", webElement);

    }
    //bu metot ile sayfayi en yukari kaydirabilirim
    public static void scrollTopByJavaScript(){
        JavascriptExecutor js= (JavascriptExecutor) Driver.getDriver();
        js.executeScript("window.scrollTo(0, -document.body.scrollHeight);");
    }

    public static void typeWithJavaScript(WebElement webElement, String str){
        JavascriptExecutor js= (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].setAttribute('value', '"+str+"')", webElement);
    }

//bu metot ile attribute degerleri ile texti alabilirim
    public static void getValueByJavaScript(String id, String attributeName){
        JavascriptExecutor js= (JavascriptExecutor) Driver.getDriver();
        String string= js.executeScript("return document.getElementById('"+id+"')."+attributeName+"").toString();
        System.out.println(string);
        //        NOT: document.querySelector("p").value;  -> TAG KULLANILABILIR
//             document.querySelector(".example").value; -> CSS DEGERI KULLANILABILIR
//             document.querySelector("#example").value; -> CSS DEGERI KULLANILABILIR
    }


    public static String getScreenshot(String name) throws IOException {
        // naming the screenshot with the current date to avoid duplication
        String date = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        // TakesScreenshot is an interface of selenium that takes the screenshot
        TakesScreenshot ts = (TakesScreenshot) Driver.getDriver();
        File source = ts.getScreenshotAs(OutputType.FILE);
        // full path to the screenshot location
        String target = System.getProperty("user.dir") + "/target/Screenshots/" + name + date + ".png";
        File finalDestination = new File(target);
        // save the screenshot to the path given
        FileUtils.copyFile(source, finalDestination);
        return target;
    }
    //========Switching Window=====//
    public static void switchToWindow(String targetTitle) {
        String origin = Driver.getDriver().getWindowHandle();
        for (String handle : Driver.getDriver().getWindowHandles()) {
            Driver.getDriver().switchTo().window(handle);
            if (Driver.getDriver().getTitle().equals(targetTitle)) {
                return;
            }
        }
        Driver.getDriver().switchTo().window(origin);
    }

    //*[contains(@name,'q')]
    //*[contains(@title,'Ara')]
    //*[contains(@maxlength,'2048')]
    //*[contains(@maxlength,'20')]
    // * [cointains ( @Attribute = ’Value’) ]


    /**
     * Bu metot ile bir elementin tag'ı ve texti verilerek locate alınır
     * @param tag elementin tag'ı
     * @param text elementin textidir
     * @return element locate döndürür
     */
    public static WebElement xpathContainsLocateAlma(String tag, String text){
        WebElement element = Driver.getDriver().findElement(By.xpath("//"+tag+"[contains(text(),'"+text+"')]"));
        return element;

    }


    /**
     * Bu metot xpath contains ile bir textin locatini alıp geriye text dönderir.
     * @return
     */
    public static String xpathContainsTextAlma(String tag, String text){

        WebElement element = Driver.getDriver().findElement(By.xpath("//"+tag+"[contains(text(),'"+text+"')]"));
        text = element.getText();
        return text;
    }

    /**
     * Bu metot Action class kullanarak bir webelementin ustune gidip bekler
     * @param element yerine webelement'in locate koyulmalidir
     */
    public static void moveToElementWithAction(WebElement element){
        Actions action = new Actions(Driver.getDriver());
        action.moveToElement(element).perform();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}