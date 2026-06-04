package lr8.examples;

import java.io.IOException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;

public class WriteExcelFileExample {
    
    private static final String FILE_PATH = "src/lr8/examples/example.xlsx";
    
    public static void main(String[] args) {
        XSSFWorkbook workbook = null;
        FileOutputStream outputStream = null;
        
        try {
            workbook = new XSSFWorkbook();
            XSSFSheet sheet = workbook.createSheet("Товары");
            
            Row headerRow = sheet.createRow(0);
            headerRow.createCell(0).setCellValue("Товар");
            headerRow.createCell(1).setCellValue("Характеристики");
            headerRow.createCell(2).setCellValue("Стоимость");
            
            Row dataRow1 = sheet.createRow(1);
            dataRow1.createCell(0).setCellValue("Книга");
            dataRow1.createCell(1).setCellValue("Жанр: Фантастика, Автор: Иванов И.И.");
            dataRow1.createCell(2).setCellValue(500.0);
            
            Row dataRow2 = sheet.createRow(2);
            dataRow2.createCell(0).setCellValue("Компьютер");
            dataRow2.createCell(1).setCellValue("Процессор: Intel Core i5, Оперативная память: 16 Гб");
            dataRow2.createCell(2).setCellValue(25000.0);
            
            outputStream = new FileOutputStream(FILE_PATH);
            workbook.write(outputStream);
            
            System.out.println("Файл успешно создан: " + FILE_PATH);
            
        } catch (IOException e) {
            System.err.println("\nОШИБКА при создании файла:");
            System.err.println("\tПричина: " + e.getMessage());
            System.err.println("\nВозможные решения:");
            System.err.println("\t1. Проверьте, существует ли папка src/lr8/examples/");
            System.err.println("\t2. Убедитесь, что у вас есть права на запись в эту папку");
            System.err.println("\t3. Закройте файл " + FILE_PATH + " если он открыт в другой программе");
        } catch (Exception e) {
            System.err.println("\nНЕИЗВЕСТНАЯ ОШИБКА:");
            System.err.println("\tПричина: " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                if (workbook != null) {
                    workbook.close();
                }
                if (outputStream != null) {
                    outputStream.close();
                }
            } catch (IOException e) {
                System.err.println("Предупреждение: не удалось закрыть ресурсы");
            }
        }
    }
}
