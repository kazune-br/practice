package gradle.cucumber;

public class VendingMachine {


    private int money;

    public void insert(int money) {
        if (money >= 10 && money <= 1000) {
            this.money += money;
        }
    }

    public int currentMoney() {
        return money;
    }
}
