/*
* It represents the bounds of the map.
*
* Parameters: None
*
* Returns: isWalkable(Chip chip): Returns 'false'. The player cannot pass through the Wall Tile.
*/


package TileCore;

import GameCore.*;

public class WallTile extends Tile{
    public WallTile(){
        super('*');
    }

    public boolean isWalkable(Chip chip){
        return false;
    }
}
