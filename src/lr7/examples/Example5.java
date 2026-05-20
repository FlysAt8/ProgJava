package lr7.examples;

import java.io.*;

public class Example5 {
    public static void main(String[] args) {
        String inputFileName = "src/lr7/examples/input.txt";
        String outputFileName = "src/lr7/examples/output.txt";

        try (InputStream inputStream = new FileInputStream(inputFileName); 
            InputStreamReader inputStreamReader =
                    new InputStreamReader(inputStream, "UTF-8");
            BufferedReader bufferedReader =
                    new BufferedReader(inputStreamReader);

            OutputStream outputStream =
                    new FileOutputStream(outputFileName);
            OutputStreamWriter outputStreamWriter =
                    new OutputStreamWriter(outputStream, "UTF-8");
            BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter)) {
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    bufferedWriter.write(line.toUpperCase());
                    bufferedWriter.newLine();
                }
                System.out.println("Данные записаны в файл: " + outputFileName);
        } catch (IOException e) {
            System.out.println("Ошибка при чтении файла: " + e.getMessage());
        }
    }
}
