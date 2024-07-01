package com.codingpearls;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Test class for the VendingMachine.
 */
public class VendingMachineTest {

    private VendingMachine vendingMachine;

    @BeforeEach
    void setUp() {
        vendingMachine = new VendingMachine();
    }

    @Test
    void testSelectItemAndGetPrice() {
        Item soda = new Item("Soda", 100);
        vendingMachine.selectItemAndGetPrice(soda);
        assertEquals(soda, getCurrentItem(vendingMachine));
    }

    @Test
    void testInsertCoin() {
        vendingMachine.insertCoin(new Coin(25));
        vendingMachine.insertCoin(new Coin(25));
        vendingMachine.insertCoin(new Coin(50));
        assertEquals(100, getCurrentBalance(vendingMachine));
    }

    @Test
    void testCollectItemAndChange() {
        Item soda = new Item("Soda", 100);
        vendingMachine.selectItemAndGetPrice(soda);
        vendingMachine.insertCoin(new Coin(50));
        vendingMachine.insertCoin(new Coin(50));
        try {
            List<Coin> change = vendingMachine.collectItemAndChange();
            assertNotNull(change); // Check change is not null
            assertEquals(0, getCurrentBalance(vendingMachine)); // Check current balance
        } catch (NotFullPaidException | NotSufficientChangeException e) {
            fail("Exception not expected: " + e.getMessage());
        }
    }

    // Helper methods for accessing private fields
    private int getCurrentBalance(VendingMachine vm) {
        try {
            var field = VendingMachine.class.getDeclaredField("currentBalance");
            field.setAccessible(true);
            return field.getInt(vm);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private Item getCurrentItem(VendingMachine vm) {
        try {
            var field = VendingMachine.class.getDeclaredField("currentItem");
            field.setAccessible(true);
            return (Item) field.get(vm);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
