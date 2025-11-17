/*
* It inherits the base Item properties and adds a crucial piece of information: its color. The color of the key must match the color of the door to open it.
* Keys are special because they are **consumed** (removed from inventory) when they are used to open a door.
*
* Parameters: color (String): The name of the color for this key (e.g., "Red", "Blue"). The item's full name is set as "[Color] Key".
*
* Returns: getColor(): Returns the color name of the key.
*          use(Chip chip): This method is required by the base Item class as the key's use is handled by the DoorTile's logic.
*/

package InventoryCore;

import GameCore.Chip;

public class Key extends Item {
    private String color;

    public Key(String color) {
        super(color + " Key");
        this.color = color;
    }

    public String getColor() { return color; }

    public void use(Chip chip) { }
}
