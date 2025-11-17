/*
* This is class represents Chip.
* It tracks Chip's position on the map, manages Chip's inventory, and keeps count of the microchips needed and collected.
*
* Parameters: startX (int): The starting X coordinate.
*             startY (int): The starting Y coordinate.
*
* Returns: getX()/getY() and setX()/setY(): Changes Chip's current position.
*          collectItem(Item item): Adds an item to the inventory. If the item is a Microchip, it also increases the 'collected chips' count.
*          hasKey(String color): Checks if Chip has a key of the specified color.
*          hasFlippers() / hasFireBoots(): Checks if Chip has the needed item.
*          hasAllChips(): Returns 'true' if the number of collected chips equals the total chips required for the level.
*          printInventory(): Displays the list of items Chip currently holds.
*          clearInventory(): Removes all items from the inventory.
*          setTotalChips(int totalChips): Sets the required number of microchips for the current level.
*          getInventory(): Returns Chip's inventory.
*/

package GameCore;

import java.util.ArrayList;
import InventoryCore.Item;
import InventoryCore.Key;
import InventoryCore.Flippers;
import InventoryCore.FireBoots;
import InventoryCore.Microchip;

public class Chip {
    private int x;
    private int y;
    private ArrayList<Item> inventory;
    private int collectedChips;
    private int totalChips;

    public Chip(int startX, int startY) {
        this.x = startX;
        this.y = startY;
        this.collectedChips = 0;
        this.totalChips = 0;  // will be set by LevelData
        this.inventory = new ArrayList<Item>();
    }

    public void setTotalChips(int totalChips){
        this.totalChips = totalChips;
    }

    public int getX() { return x; }
    public int getY() { return y; }
    public void setX(int x) { this.x = x; }
    public void setY(int y) { this.y = y; }

    public void collectItem(Item item) {
        inventory.add(item);
        if (item instanceof Microchip) collectedChips++;
    }

    public boolean hasKey(String color) {
        for (Item i : inventory)
            if (i instanceof Key && ((Key) i).getColor().equalsIgnoreCase(color))
                return true;
        return false;
    }

    public boolean hasFlippers() {
        for (Item i : inventory) if (i instanceof Flippers) return true;
        return false;
    }

    public boolean hasFireBoots() {
        for (Item i : inventory) if (i instanceof FireBoots) return true;
        return false;
    }

    public boolean hasAllChips() {
        return collectedChips == totalChips;
    }

    public void printInventory() {
        System.out.println("Inventory:");
        for (Item i : inventory)
            System.out.println("- " + i.getName());
        System.out.println("Microchips: " + collectedChips + "/" + totalChips);
    }

        // Clears all items in Chip's inventory
    public void clearInventory() {
        if (inventory != null) {
            inventory.clear();
        }
        System.out.println("[INFO] Inventory cleared.");
    }

    public void resetChips() {
        this.collectedChips = 0;
    }

    public java.util.List<Item> getInventory() {
        return inventory;
    }

    // Add a reference to current map 
    private GameCore.MapGrid currentMap;

    public void setCurrentMap(GameCore.MapGrid map) {
        this.currentMap = map;
    }

    public GameCore.MapGrid getCurrentMap() {
        return currentMap;
    }
}


