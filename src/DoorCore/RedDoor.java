/*
* This class is represents a specific type of door tile in the game, the Red Door.
* It inherits all the standard features from its parent class, DoorTile, but immediately sets its own color and map symbol.
*
* Parameters: None
*
* Returns: 'R' or "Red"
*/

package DoorCore;

public class RedDoor extends DoorTile {
    public RedDoor() {
        super('R', "Red");
    }
}
