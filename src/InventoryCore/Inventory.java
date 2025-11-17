/*
* This class holds a collection of Item objects.
* Its main purpose is to manage the list of items the player (Chip) has picked up.ip class, making this class currently unused or redundant.
*
* Parameters: None.
*
* Returns: addItem(Item item): Adds a new Item object to the inventory.
*          getItems(): Returns the entire list of Item objects currently stored in the inventory.
*/

package InventoryCore;

import java.util.ArrayList;

public class Inventory {
    private ArrayList<Item> items;

    public Inventory() {
        items = new ArrayList<Item>();
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public ArrayList<Item> getItems() {
        return items;
    }
}
