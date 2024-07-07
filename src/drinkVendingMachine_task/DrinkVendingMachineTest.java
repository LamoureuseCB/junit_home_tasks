package drinkVendingMachine_task;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DrinkVendingMachineTest {
    private DrinkVendingMachine machine;

    @BeforeEach
    void createObject() {
        machine = new DrinkVendingMachine();
    }

    @Test
    void testInsertCoin() {
        machine.insertCoin(200);
        assertEquals(200, machine.getBalance());
        machine.insertCoin(100);
        assertEquals(300, machine.getBalance());
    }

    @Test
    void testSelectDrink() {
        machine.insertCoin(200);
        assertEquals("Вы получили Кола!", machine.selectDrink("Кола"));
        assertEquals(0, machine.getBalance());
        assertEquals(9, machine.getAvailableDrinks().get("Кола"));

        machine.insertCoin(200);
        assertEquals("Вы получили Спрайт!", machine.selectDrink("Спрайт"));
        assertEquals(0, machine.getBalance());
        assertEquals(7, machine.getAvailableDrinks().get("Спрайт"));

        machine.insertCoin(300);
        assertEquals("Такого напитка нет в автомате.", machine.selectDrink("Чай"));
        assertEquals(300, machine.getBalance());
        assertEquals(null, machine.getAvailableDrinks().get("Чай"));

    }

    @Test
    void testPurchaseUnavailableDrink() {
        machine.insertCoin(2000);
        machine.selectDrink("Кола");
        machine.selectDrink("Кола");
        machine.selectDrink("Кола");
        machine.selectDrink("Кола");
        machine.selectDrink("Кола");
        machine.selectDrink("Кола");
        machine.selectDrink("Кола");
        machine.selectDrink("Кола");
        machine.selectDrink("Кола");
        machine.selectDrink("Кола");
        machine.selectDrink("Кола");
        assertEquals("Извините, Кола закончился.", machine.selectDrink("Кола"));
        assertEquals(0, machine.getBalance());
        assertEquals(0, machine.getAvailableDrinks().get("Кола"));

    }
    @Test
    void testNotEnoughBalance(){
        machine.insertCoin(100);
        assertEquals("Недостаточно средств.", machine.selectDrink("Кола"));
        assertEquals(100, machine.getBalance());
        assertEquals(10, machine.getAvailableDrinks().get("Кола"));
    }

    @Test
    void testGetDrinkPrice() {
        assertEquals(200, machine.getDrinkPrice("Кола"));
        assertEquals(200, machine.getDrinkPrice("Спрайт"));
        assertEquals(200, machine.getDrinkPrice("Фанта"));
        assertEquals(0, machine.getDrinkPrice("Чай"));
    }
}
