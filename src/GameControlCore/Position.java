/*
* This class keeps track of a location on the game map.
* It holds two main pieces of information: the X-coordinate and the Y-coordinate.
*
* Parameters: x (int): The starting horizontal (left-to-right) coordinate.
*             y (int): The starting vertical (up-to-down) coordinate.
*
* Returns: getX(): Returns the current X position.
*          getY(): Returns the current Y position.
*          setX(int x): Updates the X position to a new value.
*          setY(int y): Updates the Y position to a new value.
*/

package GameControlCore;

public class Position {
    private int x;
    private int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() { return x; }
    public int getY() { return y; }

    public void setX(int x) { this.x = x; }
    public void setY(int y) { this.y = y; }
}
