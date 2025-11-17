/*
* It allows the player (Chip) to walk over Water Tiles without taking damage.
* It inherits the base properties of an Item, like having a name.
*
* Parameters: None
*
* Returns: use(Chip chip): This method is required by the base Item class, but the Flippers have no active use.
*/

package InventoryCore;

import GameCore.Chip;

public class Flippers extends Item {
    public Flippers() {
        super("Flippers");
    }

    public void use(Chip chip) { }
}
