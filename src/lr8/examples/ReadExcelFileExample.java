package lr8.examples;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;

public class ReadExcelFileExample {
    
    private static final String FILE_PATH = "src/lr8/examples/example.xlsx";
    private static final String SHEET_NAME = "Товары";
    
    public static void main(String[] args) {
        FileInputStream inputStream = null;
        XSSFWorkbook workbook = null;
        
        try {
            File file = new File(FILE_PATH);
            if (!file.exists()) {
                System.err.println("\nОШИБКА: Файл не найден!");
                System.err.println("\tПуть: " + FILE_PATH);
                return;
            }
            
            if (!FILE_PATH.endsWith(".xlsx")) {
                System.err.println("\nОШИБКА: Неверный формат файла!");
                System.err.println("\tОжидается файл с расширением .xlsx");
                System.err.println("\tТекущий файл: " + FILE_PATH);
                return;
            }
            
            if (!file.canRead()) {
                System.err.println("\nОШИБКА: Нет прав на чтение файла!");
                System.err.println("\tПуть: " + FILE_PATH);
                return;
            }
            
            inputStream = new FileInputStream(FILE_PATH);
            workbook = new XSSFWorkbook(inputStream);
            
            XSSFSheet sheet = workbook.getSheet(SHEET_NAME);
            if (sheet == null) {
                System.err.println("\nОШИБКА: Лист \"" + SHEET_NAME + "\" не найден!");
                return;
            }
            
            if (sheet.getPhysicalNumberOfRows() == 0) {
                System.err.println("\nПРЕДУПРЕЖДЕНИЕ: Лист \"" + SHEET_NAME + "\" пуст!");
                System.out.println("\tНет данных для отображения");
                return;
            }
            
            System.out.println("\nСодержимое файла");
            
            boolean hasData = false;
            for (Row row : sheet) {
                if (row == null) continue;
                
                for (Cell cell : row) {
                    if (cell == null) {
                        System.out.print("[пусто]\t");
                    } else {
                        switch (cell.getCellType()) {
                            case STRING:
                                System.out.print(cell.getStringCellValue() + "\t");
                                break;
                            case NUMERIC:
                                if (DateUtil.isCellDateFormatted(cell)) {
                                    System.out.print(cell.getDateCellValue() + "\t");
                                } else {
                                    System.out.print(cell.getNumericCellValue() + "\t");
                                }
                                break;
                            case BOOLEAN:
                                System.out.print(cell.getBooleanCellValue() + "\t");
                                break;
                            case BLANK:
                                System.out.print("[пусто]\t");
                                break;
                            default:
                                System.out.print("[?]\t");
                        }
                    }
                }
                System.out.println();
                hasData = true;
            }
            
            if (!hasData) {
                System.out.println("(нет данных для отображения)");
            }
            
        } catch (Exception e) {
            String message = e.getMessage();
            if (message != null && (message.contains("zip") || message.contains("ZIP") || message.contains("Package"))) {
                System.err.println("\nОШИБКА: Файл повреждён или имеет неверный формат!");
                System.err.println("\tПричина: " + message);
                System.err.println("\n\tВозможные решения:");
                System.err.println("\t1. Удалите файл " + FILE_PATH + " и создайте его заново");
                System.err.println("\t2. Убедитесь, что это действительно Excel-файл (.xlsx)");
                System.err.println("\t3. Попробуйте открыть файл в Microsoft Excel для проверки");
            } else if (message != null && message.contains("No such file")) {
                System.err.println("\nОШИБКА: Файл не найден!");
                System.err.println("\tПуть: " + FILE_PATH);
            } else {
                System.err.println("\nОШИБКА при чтении файла:");
                System.err.println("\tПричина: " + e.getMessage());
                System.err.println("\n\tРекомендация: проверьте целостность файла");
            }
            
        } finally {
            try {
                if (workbook != null) {
                    workbook.close();
                }
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException e) {
                System.err.println("Предупреждение: не удалось закрыть ресурсы");
            }
        }
    }
}