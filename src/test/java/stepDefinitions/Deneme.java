package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.ConfigReader;
import utilities.Driver;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Deneme {

       @Given("Kullanici kitap {string} e gider")
    public void kullaniciKitapEGider(String arg0) {
           Driver.getDriver().get(ConfigReader.getProperty("url"));
    }
    @Then("excel")
    public void excel() throws IOException {
        String excelFilePath = "src/test/java/resources/Book1.xlsx";
        FileInputStream inputStream = new FileInputStream(new File(excelFilePath));
        Workbook workbook = new XSSFWorkbook(inputStream);
        Sheet sheet = workbook.getSheetAt(0);

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        int numPages = 10;

        for (int i = 1; i <= numPages; i++) {
            // Yeni sekme aç
            driver.switchTo().newWindow(org.openqa.selenium.WindowType.TAB);

            // Sekme başlığını değiştir
            String pageTitle = "Page " + i;
            driver.get("https://www.google.com/search?q=" + pageTitle);
            Row row = sheet.createRow(sheet.getLastRowNum() + 1);
            row.createCell(0).setCellValue(pageTitle);

            // Bekleme süresi
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        FileOutputStream outputStream = new FileOutputStream(excelFilePath);
        workbook.write(outputStream);
        workbook.close();
        outputStream.close();

        driver.quit();
    }

}



