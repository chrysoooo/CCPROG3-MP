/*
* It allows the player (Chip) to walk over Fire Tiles without taking damage.
* It inherits the base properties of an Item, like having a name.
*
* Parameters: None
*
* Returns: use(Chip chip): This method is required by the base Item class, but the Fire Boots have no active use.
*/

package InventoryCore;

import GameCore.Chip;

public class FireBoots extends Item {
    public FireBoots() {
        super("Fire Boots");
    }

    public void use(Chip chip) { }
}