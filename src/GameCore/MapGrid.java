/*
* This class holds the entire game map.
* It is responsible for organizing the tiles and providing methods to access or change tiles at specific coordinates.
* It also includes the logic for drawing the map to the console, showing the position of all tiles and Chip.
*
* Parameters: width (int): The number of columns in the map grid (horizontal size).
*             height (int): The number of rows in the map grid (vertical size).
*
* Returns: setTile(int row, int col, Tile tile): Places a specific Tile object at a specific location.
*          getTile(int row, int col): Gets the Tile object currently located at the given coordinates.
*          getWidth()/getHeight(): Returns the dimensions of the map.
*          display(Chip chip): Prints the current state of the entire map to the console, including Chip's current position.
*/

package GameCore;

public class MapGrid {
    private Tile[][] grid;
    private int width;
    private int height;

    public MapGrid(int width, int height) {
        this.width = width;
        this.height = height;
        grid = new Tile[height][width];
    }

    public void setTile(int row, int col, Tile tile) {
        grid[row][col] = tile;
    }

    public Tile getTile(int row, int col) {
        return grid[row][col];
    }

    public int getWidth() { return width; }
    public int getHeight() { return height; }

    public void display(Chip chip) {
        for (int r = 0; r < height; r++) {
            for (int c = 0; c < width; c++) {
                if (r == chip.getY() && c == chip.getX()) System.out.print('C');
                else System.out.print(grid[r][c].getSymbol());
            }
            System.out.println();
        }
    }
}


