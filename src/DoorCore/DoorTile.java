/*
* This is the blueprint for the two doors (Red and Blue) in the game.
* Because it's an 'abstract' class, it can't create a generic 'DoorTile' directly. It must create a specific type of door (like 'BlueDoor').
* It handles the logic for checking if a player (Chip) can walk through a door, which depends on whether the player has the correct key.
*
* Parameters: symbol (char): The single letter that will represent the door color on the game.
*             color (String): The name of the door's color, which must match the color of the key needed to open it.
*
* Returns: getColor(): Returns the color name of the door.
*          isWalkable(Chip chip): Returns 'true' if the player has the matching key and the door can be opened, or 'false' if they don't.
*/

package DoorCore;

import GameCore.*;
import InventoryCore.*;
import java.util.Iterator;

public abstract class DoorTile extends Tile {
    private String color;

    public DoorTile(char symbol, String color) {
        super(symbol);
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public boolean isWalkable(Chip chip) {
        // Loop through inventory items
        Iterator<Item> iter = chip.getInventory().iterator();
        while (iter.hasNext()) {
            Item item = iter.next();

            if (item instanceof Key key) {
                if (key.getColor().equalsIgnoreCase(color)) {
                    iter.remove(); // consume key
                    System.out.println("You used a " + color + " key. The door opens!");
                    return true; // door can now be passed
                }
            }
        }

        // Only print once when no matching key found
        System.out.println("You need a " + color + " key to open this door!");
        return false;
    }
}

