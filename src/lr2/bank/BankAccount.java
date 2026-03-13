package lr2.bank;

public class BankAccount implements BankInterface {
    private float balance;

    @Override
    public void openAccount() {
        this.balance = 0;
    }

    @Override
    public void deposit(float sum) {
        this.balance += sum;
    }

    @Override
    public void withdraw(float sum) {
        if (this.balance >= sum) {
            this.balance -= sum;
        } else {
            System.out.println("Нет средств");
        }
    }

    @Override
    public float getBalance() {
        return this.balance;
    }
}
