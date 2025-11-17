/*
* This is a list of the four main directions that can be used for player movement (Chip) or for tiles like force floors.
* An 'enum' is used because the possible values are always limited to these four options and errors are less likely to occur.
*
* Parameters: None
*
* Returns: fromString(String dir): Converts a direction name into the actual Direction value. Returns nothing if the text isn't a valid direction.
*          dx(): The player's X-coordinate changes when moving in this direction (either -1, 1, or 0).
*          dy(): The player's Y-coordinate changes when moving in this direction (either -1, 1, or 0).
*/

package GameControlCore;

public enum Direction {
    UP,
    DOWN,
    LEFT,
    RIGHT;

    /**
     * Converts a string (e.g. "UP", "LEFT") into a Direction.
     * Defaults to null if input is invalid.
     */
    public static Direction fromString(String dir) {
        if (dir == null) return null;
        switch (dir.toUpperCase()) {
            case "UP": return UP;
            case "DOWN": return DOWN;
            case "LEFT": return LEFT;
            case "RIGHT": return RIGHT;
            default: return null;
        }
    }

    /**
     * Returns the change in X for this direction.
     * LEFT = -1, RIGHT = +1, others = 0.
     */
    public int dx() {
        if (this == LEFT) return -1;
        if (this == RIGHT) return 1;
        return 0;
    }

    /**
     * Returns the change in Y for this direction.
     * UP = -1, DOWN = +1, others = 0.
     */
    public int dy() {
        if (this == UP) return -1;
        if (this == DOWN) return 1;
        return 0;
    }
}
