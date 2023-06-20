package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.AssertJUnit;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

public class ReusableMethods {
    protected static ExtentReports extentReports; //Raporlamayı başlatır
    protected static ExtentHtmlReporter extentHtmlReporter;//Raporu HTML formatında düzenler
    public static ExtentTest extentTest;//Tüm test aşamalarında extentTest objesi ile bilgi ekleriz

    private static Connection connection;
    private static Statement statement;
    private static ResultSet resultSet;

    /**
     bu metot ile extent rapor olusturulur
     */
    public static void extentReport() {

        extentReports = new ExtentReports();
        String tarih = new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());
        String dosyaYolu = "TestOutput/reports/extentReport_" + tarih + ".html";
        extentHtmlReporter = new ExtentHtmlReporter(dosyaYolu);
        extentReports.attachReporter(extentHtmlReporter);

        extentReports.setSystemInfo("Browser", "Chrome");
        extentReports.setSystemInfo("Tester", "Hakan");
        extentHtmlReporter.config().setDocumentTitle("Extent Report");
        extentHtmlReporter.config().setReportName("Smoke Test Raporu");
        extentTest = extentReports.createTest("ExtentTest", "Test Raporu");

    }
    /**
     bu metot ile extent rapora bilgi girisi saglanir
     @param message
     */
    public static void extentTestInfo(String message) {
        if (extentTest != null) {
            extentTest.info(message);
        }
    }
    /**
     bu metot ile extent rapor bitirilir
     */
    public static void extentRaporBitir() {
        if (extentReports != null) {
            extentReports.flush();
        }
    }



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

    /**  bu metot sayfayi girilen elemente goturur
     * @param element girilmesi gereken locatidir
     */
    public static void scrollToElementWithWebElement(WebElement element) {
        WebElement bottom = element;
        Actions actions = new Actions(Driver.getDriver());
        actions.scrollToElement(bottom).perform();
    }

    /**
     * bu metot elementin ustune JavascriptExecutor ile goturur
     @param webElement girilmesi gereken locate dir
     */
    public static void scrollIntoViewByJavaScript(WebElement webElement){
        JavascriptExecutor jse=(JavascriptExecutor) Driver.getDriver();//Casting
        jse.executeScript("arguments[0].scrollIntoView(true);",webElement);

    }

    //bu metot ile sayfayi en alta kaydirabilirim
    public static void scrollEndByJavaScript(){
               JavascriptExecutor js= (JavascriptExecutor) Driver.getDriver();
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
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

    /**
     *  JavaScript ile webelement olusturma
     * @param javascriptYolu internet sitesinden sag klik ile JS yolunu kopyala ile alınan metin olacak
     */
    public static WebElement webelementJavaScript(String javascriptYolu) {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        WebElement webElement = (WebElement) js.executeScript("return "+javascriptYolu+"");
        return webElement;
    }
    /**
     bu metot ekrani bir masue tekeri donmesi kadar asagi kaydirir
     */
    public static void pageDown() {
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN).perform();
    }

    /**
     bu metot ekrani bir masue tekeri donmesi kadar yukari kaydirir
     */
    public static void pageUp() {
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_UP).perform();
    }

    /**
     bu metot ekrani bir tik asagi kaydirir
     */
    public static void arrowDown() {
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.ARROW_DOWN).perform();
    }

    /**
     bu metot ekrani bir tik yukari kaydirir
     */
    public static void arrowUp() {
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.ARROW_UP).perform();
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
    public WebElement xpathContainsLocateAlma(String tag, String text){
        WebElement element = Driver.getDriver().findElement(By.xpath("//"+tag+"[contains(text(),'"+text+"')]"));
        return element;

    }


    /**
     * Bu metot xpath contains ile bir textin locatini alıp geriye text dönderir.
     * @return
     */
    public String xpathContainsTextAlma(String tag, String text){

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

    /**
     * Bu metot bir elemente sag click yapar
     * @param element ustunde sag click yapilacak webelement dir
     */
    public void sagClick(WebElement element){

        Actions action = new Actions(Driver.getDriver());
        action.contextClick(element).perform();

    }
    public static void robotClassDosyaYukleme(String filePath){
        try{
            ReusableMethods.bekle(3);
            StringSelection stringSelection = new StringSelection(filePath);
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection,null);
            Robot robot = new Robot();
            //pressing ctrl+v
            robot.keyPress(KeyEvent.VK_CONTROL);
            ReusableMethods.bekle(3);
            robot.keyPress(KeyEvent.VK_V);
            ReusableMethods.bekle(3);
            //releasing ctrl+v
            robot.keyRelease(KeyEvent.VK_CONTROL);
            ReusableMethods.bekle(3);
            robot.keyRelease(KeyEvent.VK_V);
            ReusableMethods.bekle(3);
            System.out.println("PASSED");
            //pressing enter
            ReusableMethods.bekle(3);
            robot.keyPress(KeyEvent.VK_ENTER);
            ReusableMethods.bekle(3);
            //releasing enter
            robot.keyRelease(KeyEvent.VK_ENTER);
            ReusableMethods.bekle(3);
            System.out.println("ENTER");
        }catch (Exception e){
        }
    }
    /**
     *  JavaScript ile webelement olusturup isEnabled oldugunu sorgulama
     * @param str internet sitesinden sag klik ile JS yolunu kopyala ile alınan metin olacak
     */
    public static void assertIsEnabled(String str){
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        WebElement webElement = (WebElement) js.executeScript("return "+str+"");
        AssertJUnit.assertTrue(webElement.isEnabled());
    }

    public static void closeConnection() {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void createConnection() {
        String url = "jdbc:postgresql://localhost:5432/jdbc";
        String user = "postgres";
        String password = ConfigReader.getProperty("postgresPassword");
        try {
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {

        }
    }


    public static void executeQuery(String query) {
        try {
            statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        } catch (SQLException e) {

        }
        try {
            resultSet = statement.executeQuery(query);
        } catch (SQLException e) {

        }
    }

    public static List<Object> getColumnData(String query, String column) {
        executeQuery(query);
        List<Object> rowList = new ArrayList<>();
        ResultSetMetaData rsmd;
        try {
            rsmd = resultSet.getMetaData();
            while (resultSet.next()) {
                rowList.add(resultSet.getObject(column));
            }
        } catch (SQLException e) {

        }
        return rowList;
    }


    public static List<String> getColumnNames(String query) {
        executeQuery(query);
        List<String> columns = new ArrayList<>();
        ResultSetMetaData rsmd;
        try {
            rsmd = resultSet.getMetaData();
            int columnCount = rsmd.getColumnCount();
            for (int i = 1; i <= columnCount; i++) {
                columns.add(rsmd.getColumnName(i));
            }
        } catch (SQLException e) {

        }
        return columns;
    }



    /**
     * Bu metot bir excell dosyası oluşturur ve excellde var olan sayfaya isim verir
     * @param sayfaAdi sayfaya verilecek isim
     * @param dosyaYolu hangi excell dosyasi uzerinde calisilacaksa o dosyanin yolu
     */
    public static void excellSayfaAdiVerme(String sayfaAdi, String dosyaYolu){
        try (Workbook workbook = new XSSFWorkbook()) {
            workbook.createSheet(sayfaAdi);
            FileOutputStream outputStream = new FileOutputStream(dosyaYolu);
            workbook.write(outputStream);
            workbook.close();
            outputStream.close();
        } catch (Exception e) {

        }
    }

    /**
     * Bu metot var olan bir excell dosyasini acip icine yeni sayfa ekler ve sayfaya isim verir.
     * @param dosyaYolu acilacak ve sayfa eklenecek excell dosyasinin yoludur
     * @param sayfaAdi excellde yeni acilan sayfaya verilecek isimdir
     */
    public static void excellSayfasiOlusturupIsimVerme(String dosyaYolu, String sayfaAdi){
        try {
            FileInputStream file = new FileInputStream(new File(dosyaYolu));
            Workbook workbook = new XSSFWorkbook(file);
            Sheet sheet = workbook.createSheet(sayfaAdi);
            FileOutputStream outputStream = new FileOutputStream(dosyaYolu);
            workbook.write(outputStream);
            workbook.close();
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /** bu metot manage sitesindeki listlerde bir sutundaki satır sayısını verir
     *
     * @param sutunIsmiGir eleman sayisi bulunmak istenen sutunun ismi girilmeli
     * @return int olarak bir sutundaki satir sayisini doner
     */
    public static int satirSayisiBul(String sutunIsmiGir){
        WebElement table = Driver.getDriver().findElement(By.xpath("//table"));
        List<WebElement> rows = table.findElements(By.tagName("tr"));
        int nameColumnIndex = -1; // Name sütununun index değeri
        int rowCount = 0; // Toplam satır sayısı

// Tablodaki her bir satırı döngü ile gezin
        for (WebElement row : rows) {
            if (nameColumnIndex == -1) { // İlk satırda Name sütununun index değerini bulun
                List<WebElement> headers = row.findElements(By.tagName("th"));
                for (int i = 0; i < headers.size(); i++) {
                    if (sutunIsmiGir.equalsIgnoreCase(headers.get(i).getText())) {
                        nameColumnIndex = i;
                        break;
                    }
                }
            } else { // Diğer satırlarda Name sütunundaki veriyi okuyarak satır sayısını arttırın
                List<WebElement> columns = row.findElements(By.tagName("td"));
                if (columns.size() > nameColumnIndex) {
                    String name = columns.get(nameColumnIndex).getText();
                    if (!name.trim().isEmpty()) {
                        rowCount++;
                    }
                }
            }
        }

        return rowCount;
    }

    public static void dogruMu( String expectedResult, String actualResutlt){

        assertTrue(expectedResult.equals(actualResutlt));
    }

    public static void dogruMu(Integer expectedResult, Integer actualResutlt){

        assertTrue(expectedResult.equals(actualResutlt));
    }


}