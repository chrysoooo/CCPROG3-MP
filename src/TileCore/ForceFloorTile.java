/*
* When the player steps on this tile, they are automatically moved in a set direction until they hit an obstacle or a different type of tile.
*
* Parameters: dir (String): The direction the floor should push. This also determines the tile's display symbol.
*
* Returns: getDirection(): Returns the direction this force floor pushes.
*          isWalkable(Chip chip): Returns 'true'. The player can always step onto a force floor.
*/

package TileCore;

import GameControlCore.Direction;
import GameCore.*;

public class ForceFloorTile extends Tile {
    private Direction direction;

    public ForceFloorTile(String dir) {
        super(directionSymbol(Direction.fromString(dir)));
        this.direction = Direction.fromString(dir);
    }

    private static char directionSymbol(Direction d) {
        return switch (d) {
            case LEFT -> '<';
            case RIGHT -> '>';
            case UP -> '^';
            case DOWN -> 'v';
        };
    }

    public Direction getDirection() {
        return direction;
    }

    public boolean isWalkable(Chip chip) {
        // Chip can always walk on a force floor
        return true;
    }
}

