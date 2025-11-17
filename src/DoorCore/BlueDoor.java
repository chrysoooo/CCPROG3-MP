/*
* This class is represents a specific type of door tile in the game, the Blue Door.
* It inherits all the standard features from its parent class, DoorTile, but immediately sets its own color and map symbol.
*
* Parameters: None
*
* Returns: 'B' or "Blue"
*/

package DoorCore;

public class BlueDoor extends DoorTile {
    public BlueDoor() {
        super('B', "Blue");
    }
}

