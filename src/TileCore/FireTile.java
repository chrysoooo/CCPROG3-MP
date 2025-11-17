/*
* It represents the Fire Tile on the map that cannot be walked on without Fire Boots.
*
* Parameters: None
*
* Returns: isWalkable(Chip chip): Returns 'true' if the player has Fire Boots in the inventory.
*/

package TileCore;

import GameCore.*;

public class FireTile extends Tile {
    public FireTile(){
        super('F');
    }

    public boolean isWalkable(Chip chip){
        return chip.hasFireBoots();
    }
}
