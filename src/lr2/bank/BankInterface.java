package lr2.bank;

public interface BankInterface {
    void openAccount();
    void deposit(float sum);
    void withdraw(float sum);
    float getBalance();
}
