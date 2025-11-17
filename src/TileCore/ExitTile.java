/*
* It represents the end of the current level.
*
* Parameters: None
*
* Returns: isWalkable(Chip chip): Returns 'true' if the player has completed the total number of microchips.
*/

package TileCore;

import GameCore.*;

public class ExitTile extends Tile{
    public ExitTile(){
        super('E');
    }

    public boolean isWalkable(Chip chip){
        return chip.hasAllChips();
    }
    
}
