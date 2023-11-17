package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
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
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ReusableMethods {

    protected static ExtentReports extentReports; //Raporlamayı başlatır
    protected static ExtentHtmlReporter extentHtmlReporter;//Raporu HTML formatında düzenler
    public static ExtentTest extentTest;//Tüm test aşamalarında extentTest objesi ile bilgi ekleriz

    private static Connection connection;
    private static Statement statement;
    private static ResultSet resultSet;

    /**
     bu metot ile extent rapora bilgi girisi saglanir
     @param message
     */
    public static void extentTestInfo(String message) {
        if (extentTest != null) {
            extentTest.info(message);
        }
    }

    //bu metot ile sayfayi en alta kaydirabilirim
    public static void scrollEndByJavaScript(){
        JavascriptExecutor js= (JavascriptExecutor) Driver.getDriver();
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
    }


    /**
     bu metot ile extent rapor bitirilir
     */
    public static void extentRaporBitir() {
        if (extentReports != null) {
            extentReports.flush();
        }
    }

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
     * bu metot manage sitesindeki listlerde bir sutundaki satır sayısını verir
     *
     * @param sutunIsmiGir eleman sayisi bulunmak istenen sutunun ismi girilmeli
     * @return int olarak bir sutundaki satir sayisini doner
     */
    public static int satirSayisiBul(String sutunIsmiGir) {
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

    /**  bu metot sayfayi girilen elemente goturur
     * @param element girilmesi gereken locatidir
     */
    public static void scrollToElementWithWebElement(WebElement element) {
        WebElement bottom = element;
        Actions actions = new Actions(Driver.getDriver());
        actions.scrollToElement(bottom).perform();
    }


    /**
     * Bu metot Action class kullanarak bir webelementin ustune gidip bekler
     * @param element yerine webelement'in locate koyulmalidir
     */
    public static void moveToElemewebElementScreenShootntWithAction(WebElement element){
        Actions action = new Actions(Driver.getDriver());
        action.moveToElement(element).perform();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
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
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


    public static void executeQuery(String query) {
        try {
            statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            resultSet = statement.executeQuery(query);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
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
            // TODO Auto-generated catch block
            e.printStackTrace();
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
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return columns;
    }

    public static void addSheetToExcel(String fileName, String sheetName) throws Exception {
        // Dosya ve çalışma kitabı objelerini oluştur
        FileOutputStream outputStream = new FileOutputStream(fileName);
        XSSFWorkbook workbook = new XSSFWorkbook();

        // Sayfayı oluştur ve kitaba ekle
        XSSFSheet sheet = workbook.createSheet(sheetName);
        workbook.write(outputStream);

        // Kapat
        outputStream.close();
        workbook.close();
    }

    public void excelDosyasiVeSayfasiOlusturma(String dosyaAdi, String sayfaAdi,int sayfayaEkOlacakSayi) throws IOException {
        String dosyaYolu = "src/test/java/resources/"+dosyaAdi+".xlsx";

        FileOutputStream fileOutputStream = null;
        try {
            Workbook workbook = new XSSFWorkbook();
            for (int i = 1; i <= sayfayaEkOlacakSayi; i++) {
                String sheetName = sayfaAdi + i;
                Sheet sheet = workbook.createSheet(sheetName);
                // Sayfaya istediğiniz verileri ekleyebilirsiniz
            }

            fileOutputStream = new FileOutputStream(new File(dosyaYolu));
            workbook.write(fileOutputStream);
            fileOutputStream.close();
            System.out.println("Excel dosyası oluşturuldu.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

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
         bu metot ekrani bir masue tekeri donmesi kadar asagi kaydirir
         */
    public static void pageDown() {
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN).perform();
    }

    /**
     bu metot ekrani bir tik yukari kaydirir
     */
    public static void arrowUp() {
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.ARROW_UP).perform();
    }

    //HARD WAIT METHOD
    public static void bekle(int saniye) {
        try {
            Thread.sleep(saniye * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    //Alert ACCEPT
    public static void alertAccept() {
        Driver.getDriver().switchTo().alert().accept();
    }

    //Alert DISMISS
    public static void alertDismiss() {
        Driver.getDriver().switchTo().alert().dismiss();
    }

    //Alert getText()
    public static void alertText() {
        Driver.getDriver().switchTo().alert().getText();
    }

    //Alert promptBox
    public static void alertprompt(String text) {
        Driver.getDriver().switchTo().alert().sendKeys(text);
    }

    //DropDown VisibleText
    /*
        Select select2 = new Select(gun);
        select2.selectByVisibleText("7");

        //ddmVisibleText(gun,"7"); --> Yukarıdaki kullanım yerine sadece method ile handle edebilirim
     */
    public static void ddmVisibleText(WebElement ddm, String secenek) {
        Select select = new Select(ddm);
        select.selectByVisibleText(secenek);
    }

    //DropDown Index
    public static void ddmIndex(WebElement ddm, int index) {
        Select select = new Select(ddm);
        select.selectByIndex(index);
    }

    //DropDown Value
    public static void ddmValue(WebElement ddm, String secenek) {
        Select select = new Select(ddm);
        select.selectByValue(secenek);
    }


    //SwitchToWindow1
    public static void switchToWindow(int sayi) {
        List<String> tumWindowHandles = new ArrayList<String>(Driver.getDriver().getWindowHandles());
        Driver.getDriver().switchTo().window(tumWindowHandles.get(sayi));
    }

    //SwitchToWindow2
    public static void window(int sayi) {
        Driver.getDriver().switchTo().window(Driver.getDriver().getWindowHandles().toArray()[sayi].toString());
    }
    //EXPLICIT WAIT METHODS

    //Visible Wait
    public static void visibleWait(WebElement element, int sayi) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(sayi));
        wait.until(ExpectedConditions.visibilityOf(element));

    }

    //VisibleElementLocator Wait
    public static WebElement visibleWait(By locator, int sayi) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(sayi));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

    }

    //Alert Wait
    public static void alertWait(int sayi) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(sayi));
        wait.until(ExpectedConditions.alertIsPresent());

    }

    //Tüm Sayfa ScreenShot parametreli olan içine resmin nereye ait olduğu yazılır
    public static void tumSayfaResmi(String name) {
        String tarih = new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());
        String dosyaYolu = "TestOutput/screenshot/screenshot" + tarih + name + ".png";
        TakesScreenshot ts = (TakesScreenshot) Driver.getDriver();
        try {
            FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE), new File(dosyaYolu));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void tumSayfaResmi() {
        String tarih = new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());
        String dosyaYolu = "TestOutput/screenshot/screenshot" + tarih + ".png";
        TakesScreenshot ts = (TakesScreenshot) Driver.getDriver();
        try {
            FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE), new File(dosyaYolu));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //WebElement ScreenShot
    public static void webElementResmi(WebElement element) {
        String tarih = new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());
        String dosyaYolu = "TestOutput/screenshot/webElementScreenshot" + tarih + ".png";

        try {
            FileUtils.copyFile(element.getScreenshotAs(OutputType.FILE), new File(dosyaYolu));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    //WebTable
    public static void printData(int satir, int sutun) {
        WebElement satirSutun = Driver.getDriver().findElement(By.xpath("(//tbody)[1]//tr[" + satir + "]//td[" + sutun + "]"));
        System.out.println(satirSutun.getText());
    }

    //Click Method
    public static void click(WebElement element) {
        try {
            element.click();
        } catch (Exception e) {
            JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
            js.executeScript("arguments[0].click();", element);
        }
    }

    //JS Scroll
    public static void scroll(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    //JS Sayfa Sonu Scroll
    public static void scrollEnd() {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
    }

    //JS Sayfa Başı Scroll
    public static void scrollHome() {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("window.scrollTo(0,-document.body.scrollHeight)");
    }

    //JS SendKeys
    public static void sendKeysJS(WebElement element, String text) {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].value='" + text + "'", element);
    }

    //JS SendAttributeValue
    public static void sendAttributeJS(WebElement element, String text) {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].setAttribute('value','" + text + "')", element);
    }

    /** bu metot ile girilen attribute degerleri ile texti alabilirim
     @param id girilmesi gereken id degeri
     @param attributeName gonderilmesi gereken attribute ismi
     */
    public static void getValueByJavaScript(String id, String attributeName) {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        String string = js.executeScript("return document.getElementById('" + id + "')." + attributeName).toString();
        System.out.println(string);
    }

    /**
     * elemente JavascriptExecutor ile string gonderir(java sendkey() ile ayni)
     *
     * @param string     webElemente sendKey ile gonderilecek text
     * @param webElement sendKey ile gonderilecek webelement
     */
    public static void sendKeyWithJavaScript(String string, WebElement webElement) {
        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();//Casting
        jse.executeScript("arguments[0].value = '" + string + "';", webElement);

    }

    /**
     * javascript ile webelemente sendkey yapma methodu.
     *
     * @param webelementXpathYolu webelement yolu string olarak xpath seklinde girilir
     * @param gonderilecekText    sendkey yapilacak text
     */
    public static void sendKeyWithJavaScriptWithXpath(String webelementXpathYolu, String gonderilecekText) {
        WebElement element = Driver.getDriver().findElement(By.xpath(webelementXpathYolu));
        sendKeyWithJavaScript(gonderilecekText, element);
    }

    /**
     * javascript ile webelemente sendkey yapma methodu.
     *
     * @param webelementCssYolu webelement yolu string olarak Css seklinde girilir
     * @param gonderilecekText  sendkey yapilacak text
     */
    public static void sendKeyWithJavaScriptWithCss(String webelementCssYolu, String gonderilecekText) {
        WebElement element = Driver.getDriver().findElement(By.cssSelector(webelementCssYolu));
        sendKeyWithJavaScript(gonderilecekText, element);
    }


    /**
     * bu metot ile herhangi bir webelemente xpath vererek JavascriptExecutor kullanarak tiklayabilirim
     *
     * @param string elementin xpath cinsinden yolu
     */
    public static void clickByJavaScriptWithXpath(String string) {
        WebElement element = Driver.getDriver().findElement(By.xpath(string));
        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();

        jse.executeScript("arguments[0].click();", element);

    }


    /**
     * bu metot ile herhangi bir webelemente JavascriptExecutor kullanarak tiklayabilirim
     *
     * @param webElement click yapilacak webelement
     */
    public static void clickByJavaScript(WebElement webElement) {
        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();

        jse.executeScript("arguments[0].click();", webElement);

    }


    /**
     * bu metot ile herhangi bir webelemente cssSelector vererek JavascriptExecutor kullanarak tiklayabilirim
     *
     * @param string elementin xpath cinsinden yolu
     */
    public static void clickByJavaScriptWithCss(String string) {
        WebElement element = Driver.getDriver().findElement(By.cssSelector(string));
        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();

        jse.executeScript("arguments[0].click();", element);

    }

    /**
     * Bu metot ile elementin className değeri string olarak verilerek o classtaki text alinir.
     *
     * @param className text degeri alinmak istenen class ismi string olarak verilir
     * @return
     */
    public static String getTextWithJavaScript(String className) {
        WebElement element = Driver.getDriver().findElement(By.className(className));

        // JavaScriptExecutor kullanarak elementin içeriğini al
        JavascriptExecutor jsExecutor = (JavascriptExecutor) Driver.getDriver();
        String text = (String) jsExecutor.executeScript("return arguments[0].textContent;", element);
        return text;
    }

    /**
     * Bu metot string olarak verilen textteki rakamlar haric herseyi siler ve Integer'a donusturur.
     *
     * @param string icindeki harf, karakter ve bosluklar silinecek text
     * @return Integer dondurur
     */
    public static Integer stringConverToInteger(String string) {
        Integer integer = Integer.valueOf(string.replaceAll("[^0-9]", ""));
        return integer;
    }

    /**
     * sayfayi verilen pixel kadar asagi kaydirir
     *
     * @param scrollSize pixel degeridir. integer olarak yazilmali
     */
    public static void scroll(int scrollSize) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) Driver.getDriver();

        // Örneğin, sayfayı 500 piksel aşağı kaydırmak için:
        jsExecutor.executeScript("window.scrollBy(0, " + scrollSize + ");");
    }

    /**
     * * Bu metot sayfadaki expected ve actual urun sayilari birbirine esit olana kadar sayfayi scroll yapar.
     * * Esit degilse sayfa altindaki sayfa numaralarina basarak son sayfaya ve son urune kadar ilerler.
     * sonunda da toplam urun sayisini dondurur
     *
     * @param first  sayfada goruntulenen urun sayisini int olarak verilmeli
     * @param second buraya baslangic degeri olarak 0 verilmeli
     * @return bu metot toplam urun sayisini verir
     */
    public static long ifNotEqualGoScroll(int first, int second) {
        Long urunSayisiniEkle = 0L;
        do {
            JavascriptExecutor jsExecutor = (JavascriptExecutor) Driver.getDriver();
            long elementCountJavascript = (long) jsExecutor.executeScript(
                    "return document.querySelectorAll('.ProductItem__Wrapper').length;"
            );

            long elementCount = elementCountJavascript;

            if (first != elementCount) {
                urunSayisiniEkle = urunSayisiniEkle + elementCount;
                WebElement element = webelementJavaScript("document.querySelector(\"a[title='Sonraki Sayfa']\")");

                if (first != urunSayisiniEkle) {
                    webElementResmi(element);
                    clickByJavaScript(element);
                }
            }
        } while (first != urunSayisiniEkle);
        return urunSayisiniEkle;
    }

    /**
     * JavaScript ile webelement olusturma
     *
     * @param javascriptYolu internet sitesinden sag klik ile JS yolunu kopyala ile alınan metin olacak
     */
    public static WebElement webelementJavaScript(String javascriptYolu) {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        WebElement webElement = (WebElement) js.executeScript("return " + javascriptYolu + "");
        return webElement;
    }

    /**
     * bu metot ile JS yolu string olarak verilen elementi JavascriptExecutor kullanarak tiklayabilirim
     * @param webElement click yapilacak webelement yolu string olarak verilir
     */
    public static void clickJSElementWithJavaScript(String javascriptYolu) {
        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
        WebElement webElement = (WebElement) jse.executeScript("return " + javascriptYolu + "");
        jse.executeScript("arguments[0].click();", webElement);

    }
    public static void flash(WebElement element,WebDriver driver){
        JavascriptExecutor js= (JavascriptExecutor) driver;
        String elementColor=element.getCssValue("backgroundColor"); //locate alinan yerin  arka plan rengini alir
        for (int i = 0; i < 10; i++) {
            changeColor("rgb(0,0,0)", element, driver); //elemente siyah renk verir rgb kizmi rengi belirtir
            //changeColor("rgb(255,0,0)", element, driver); //kirmizi renk
            //changeColor("rgb(0,255,0)", element, driver); //yesil renk
            changeColor(elementColor, element, driver);
        }
    }

    /**
     * flash metoduna renk degistirme islemini yaptirir. Elementin arka plan renginin parametre olarak atanacagini bildirir.
     * @param color arka plan rengi
     * @param element   arka plan rengi degisecek element
     * @param driver
     */
    public static void changeColor(String color, WebElement element, WebDriver driver){
        JavascriptExecutor js= (JavascriptExecutor) driver; //javascript kodlarini calistirir
        js.executeScript("arguments[0].style.backgroundColor='"+color+"'", element); //elementin renginin degismesini sağlar

        try{
            Thread.sleep(20);
        }catch (Exception e){

        }
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

    /** Bu metot islem yapilacak elementin etrafina renkli cerceve cizerek belirgin hale getirir.
     *
     * @param locate islem yapilacak elementin cssSelector turunden locate string olarak girilmeli
     */
    public static void showElementWithFrame(String locate){
        WebElement element = Driver.getDriver().findElement(By.cssSelector(""+locate+""));
        String script = "arguments[0].style.border='3px solid red';";
//        String script = "arguments[0].style.border='3px solid white';";
//        String script = "arguments[0].style.border='3px solid yellow';";
//        String script = "arguments[0].style.border='3px solid green';";
        ((JavascriptExecutor) Driver.getDriver()).executeScript(script, element);

    }
}