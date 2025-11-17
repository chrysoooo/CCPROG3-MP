/*
* The player must collect all of the microchips to complete a level.
* When Chip collects a Microchip, the 'collectedChips' counter in the Chip class is incremented.
*
* Parameters: None
*
* Returns: use(Chip chip): This is required by the base Item class, but the Microchip has no active use.
*/

package InventoryCore;

import GameCore.Chip;

public class Microchip extends Item {
    public Microchip() {
        super("Microchip");
    }

    public void use(Chip chip) { }
}

