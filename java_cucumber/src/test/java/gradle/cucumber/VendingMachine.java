package gradle.cucumber;

import java.util.HashMap;
import java.util.Map;

public class VendingMachine {


    private int money;
    private Map<String, Integer> drinks = new HashMap<>();


    public void insert(int money) {
        if (money >= 10 && money <= 1000) {
            this.money += money;
        }
    }

    public int currentMoney() {
        return money;
    }

    public void add(String drinkName, int drinkCount) {
        drinks.put(drinkName, drinks.computeIfAbsent(drinkName, s -> 0) + drinkCount);
    }

    public int currentMonsterDrinkCount(String drinkName) {
        return drinks.get(drinkName);
    }
}
