package utilities;

import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ExcelUtils {
    private Workbook workbook;
    private Sheet sheet;
    private String path;

    /**bu metot dosya yolu verilen bir excell dosyasina ulasir
     * verilen sayfa ismini acar ve okur
     * @param path ulasilacak ve okunacak excell dosya yolu
     * @param sheetName excell dosyasinda okunacak sayfa ismi
     */
    public ExcelUtils(String path,String sheetName){
        this.path = path;
        try {
            FileInputStream fis = new FileInputStream(path);
            workbook = WorkbookFactory.create(fis);
            sheet = workbook.getSheet(sheetName);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**Excellde Satir ve sütun sayilari girildiğinde, o hücredeki veriyi return eder
     *
     * @param rowNum satir numarasi
     * @param colNum sutun numarasi
     * @return
     */
    public String getCellData(int rowNum,int colNum){
        Cell cell = sheet.getRow(rowNum).getCell(colNum);
        return cell.toString();
    }

    /**Exceldeki satir sayisini return eder
     * @return
     */
    public int rowCount(){
        return  sheet.getLastRowNum();
    }

    /**Exceldeki sütun sayisini return eder
      * @return
     */
    public int columnCount(){
        return sheet.getRow(0).getLastCellNum();
    }
    //Exceldeki dataları başlık olmadan alabilmek için 2 boyutlu bir array method oluşturalım
    public String[][] getDataArray() {
        String[][] data = new String[rowCount()][columnCount()];
        for (int i = 1; i <=rowCount() ; i++) {
            for (int j = 0; j < columnCount(); j++) {
                String value = getCellData(i,j);
                data[i-1][j]=value;
            }
        }
        return data;
    }

    /** Bu metot excelldeki bir sutunun basligini verir
     *
      * @return bir sutunun basligini verir
     */
    public List<String> getColumnsNames() {
        List<String> columns = new ArrayList<>();
        for (Cell cell : sheet.getRow(0)) {
            columns.add(cell.toString());
        }
        return columns;
    }

    /**
     * Bu metot excellde belirlenen hucreye verilen degeri girip kaydeder.
      * @param value excell hucresine kaydedilecek deger
     * @param rowNum satir numarasi
     * @param colNum sutun numarasi
     */

    public void setCellData(String value, int rowNum, int colNum) {
        try {
            Row row = sheet.getRow(rowNum);
            if (row == null) {
                row = sheet.createRow(rowNum);
            }
            Cell cell = row.createCell(colNum);
            cell.setCellValue(value);

            FileOutputStream fos = new FileOutputStream(path);
            workbook.write(fos);
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        }

    //    Bu metot ustdeki metotla birlikde calisir. Overload eder. Parametreleri farklidir
    public void setCellDataExcell(String value, String columnName, int row) {
        int column = getColumnsNames().indexOf(columnName);
        setCellData(value, row, column);
    }

}