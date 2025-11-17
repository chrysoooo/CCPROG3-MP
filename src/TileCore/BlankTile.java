/*
* It represents an empty space on the map that has no special properties or obstacles.
*
* Parameters: None
*
* Returns: isWalkable(Chip chip): Returns 'true'. The player can always walk onto a blank tile.
*/

package TileCore;

import GameCore.*;

public class BlankTile extends Tile {
    public BlankTile() {
        super('_');
    }

    public boolean isWalkable(Chip chip){
        return true;
    }
}

