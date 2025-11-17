/*
* It represents the Water Tile on the map that cannot be walked on without Flippers.
*
* Parameters: None
*
* Returns: isWalkable(Chip chip): Returns 'true' if the player has Flippers in the inventory.
*/

package TileCore;

import GameCore.*;

public class WaterTile extends Tile {
    public WaterTile(){
        super('W');
    }

    public boolean isWalkable(Chip chip){
        return chip.hasFlippers();
    }
}    

