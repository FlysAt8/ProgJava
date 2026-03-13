package lr2.bank;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        BankAccount account = new BankAccount();
        account.openAccount();
        System.out.println("Новый счет открыт, текущий счет: "+account.getBalance());

        Scanner in = new Scanner(System.in);

        while (true){
            System.out.println(
                "Навигация:\n\t1 - Текущий баланс\n\t2 - Пополнить счет\n\t3 - Снять деньги со счета\n\t0 - Выход"
            );
            System.out.print("Выполнить: ");
            String str = in.nextLine();

            if (str.equals("0")) {
                break;
            }

            float sum;
            switch (str) {
                case "1":
                    System.out.println("Текущий счет: "+account.getBalance());
                    break;
                case "2":
                    System.out.print("Введите сумму пополнения: ");
                    sum = in.nextFloat();
                    in.nextLine();
                    account.deposit(sum);
                    break;
                case "3":
                    System.out.print("Введите сумму для снятия: ");
                    sum = in.nextFloat();
                    in.nextLine();
                    account.withdraw(sum);
                    break;
            
                default:
                    System.out.println("Введите корректную команду");
                    break;
            }
        }
        System.out.println("До свидания");
        in.close();
    }
}
