/*
* This is basis for every collectible object in the game.
* Because it's an 'abstract' class, it cannot create a generic 'Item'. It must create a specific, named item that inherits from it.
* It ensures that every collectible object has a name and a method that defines what happens when the item is used.
*
* Parameters: name (String): The  name of the item (e.g., "Red Key", "Flippers").
*
* Returns: getName(): Returns the stored name of the item. 
*/

package InventoryCore;

import GameCore.Chip;

public abstract class Item {
    private String name;

    public Item(String name) {
        this.name = name;
    }

    public String getName() { return name; }

    public abstract void use(Chip chip);
}
