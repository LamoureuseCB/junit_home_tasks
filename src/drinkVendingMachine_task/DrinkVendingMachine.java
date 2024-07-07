package drinkVendingMachine_task;

import java.util.HashMap;
import java.util.Map;

public class DrinkVendingMachine {
    private Map<String, Integer> inventory = new HashMap<>();
    private int balance = 0;

    public DrinkVendingMachine() {

        inventory.put("Кола", 10);
        inventory.put("Спрайт", 8);
        inventory.put("Фанта", 5);
    }

    public void insertCoin(int value) {
        balance += value;
    }

    public String selectDrink(String drinkName) {
        if (inventory.containsKey(drinkName)) {
            int quantity = inventory.get(drinkName);
            int price = getDrinkPrice(drinkName);
            if (quantity > 0 && balance >= price) {
                inventory.put(drinkName, quantity - 1);
                balance -= price;
                return "Вы получили " + drinkName + "!";
            } else if (quantity == 0) {
                return "Извините, " + drinkName + " закончился.";
            } else {
                return "Недостаточно средств.";
            }
        } else {
            return "Такого напитка нет в автомате.";
        }
    }

    public int getBalance() {
        return balance;
    }

    public Map<String, Integer> getAvailableDrinks() {
        return inventory;
    }

    public int getDrinkPrice(String drinkName) {
        if (inventory.containsKey(drinkName)) {
            return 200;
        } else {
            return 0;
        }
    }
}
