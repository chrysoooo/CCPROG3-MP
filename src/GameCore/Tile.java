/*
* It ensures that every tile has a single-character symbol for display and a method to determine if a player can step onto it.
* Because it's an 'abstract' class, it can't create a generic 'Tile'. It must create a specific kind of tile that inherits from it.
*
* Parameters: symbol (char): The characters that represents this tile on the map display.
*
* Returns: getSymbol(): Returns the character used to draw the tile on the map.
*          isWalkable(Chip chip): It determines whether Chip can move onto this tile. The actual check is handled by each specific tile.
*/

package GameCore;

public abstract class Tile {
    private char symbol;

    public Tile(char symbol){
        this.symbol = symbol;
    }

    public char getSymbol(){
        return symbol;
    }

    public abstract boolean isWalkable(Chip chip);
}
