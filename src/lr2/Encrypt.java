package lr2;

import java.util.Scanner;

public class Encrypt {
    public static String getDecryptString (String decryptString, int shift) {
        char[] arrayChar = decryptString.toCharArray();
        long[] arrayInt = new long[arrayChar.length];
        char[] arrayCharNew = new char[arrayChar.length];

        for (int i = 0; i < arrayChar.length; i++){
            arrayInt[i] = arrayChar[i] - shift;
            arrayCharNew[i] = (char) arrayInt[i];
        }
        decryptString = new String(arrayCharNew);

        return decryptString;
    }

    public static String getEncryptString (String encryptString, int shift) {
        char[] arrayChar = encryptString.toCharArray();
        long[] arrayInt = new long[arrayChar.length];
        char[] arrayCharNew = new char[arrayChar.length];

        for (int i = 0; i < arrayChar.length; i++){
            arrayInt[i] = arrayChar[i] + shift;
            arrayCharNew[i] = (char) arrayInt[i];
        }
        encryptString = new String(arrayCharNew);

        return encryptString;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите текст для шифрования: ");
        String str_in = in.nextLine();

        System.out.print("Введите ключ: ");
        int key = in.nextInt();
        in.nextLine();

        String str_out = getEncryptString(str_in, key);

        System.out.println("Текст после преобразования: " + str_out + "\n");

        while (true){
            System.out.print("Выполнить обратное преобразование? (y/n): ");
            str_in = in.nextLine();

            if (str_in.equals("y")){
                str_out = getDecryptString(str_out, key);
                System.out.println("Текст обратного преобразованния: " + str_out);
                System.out.println("До свидания!");
                break;
            } else if (str_in.equals("n")){
                System.out.println("До свидания!");
                break;
            } else {
                System.out.println("Введите корректный ответ");
            }

        }

        in.close();
    }
}
