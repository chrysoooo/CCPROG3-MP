/*
* This class creates the specific game levels) for the Game Engine.
* It does not store any game data itself. Every new MapGrid is made from scratch using a hardcoded character layout.
* It handles placing all the tiles, items, doors, and setting the player's (Chip's) starting position.
*
* Parameters: None
*
* Returns: createLevel1(Chip chip): Returns the populated and finished MapGrid for Level 1.
*          createLevel2(Chip chip): Returns the populated and finished MapGrid for Level 2.
*/

package GameControlCore;

import DoorCore.*;
import GameCore.*;
import InventoryCore.*;
import TileCore.*;

public class LevelData {

    public static MapGrid createLevel1(Chip chip) {
        int height = 15;
        int width = 17;
        MapGrid map = new MapGrid(width, height);

        // Fill everything as BlankTile first
        for (int r = 0; r < height; r++) {
            for (int c = 0; c < width; c++) {
                map.setTile(r, c, new BlankTile());
            }
        }

        // Custom layout for Level 1
        char[][] layout = {
            {'*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*'},
            {'*','_','_','_','*','_','_','_','*','_','_','_','*','_','_','_','*'},
            {'*','_','E','_','R','_','r','_','*','_','_','_','*','_','_','_','*'},
            {'*','_','_','_','*','_','_','_','*','*','*','*','*','*','*','*','*'},
            {'*','*','*','*','*','R','*','*','*','*','*','*','_','_','_','*','*'},
            {'*','*','*','*','M','_','_','_','*','*','*','*','r','M','_','*','*'},
            {'*','*','*','*','F','F','F','F','*','*','*','*','_','_','_','*','*'},
            {'*','*','*','*','F','F','F','F','*','*','*','*','*','B','*','*','*'},
            {'*','*','*','*','_','_','_','_','<','<','<','<','_','_','_','f','*'},
            {'*','*','*','*','_','_','_','_','F','M','b','F','_','_','C','_','*'},
            {'*','*','*','*','_','_','_','_','>','>','>','>','_','_','_','_','*'},
            {'*','*','*','*','W','W','W','W','*','*','*','*','*','*','*','*','*'},
            {'*','*','*','*','W','s','M','W','*','*','*','*','*','*','*','*','*'},
            {'*','*','*','*','W','W','W','W','*','*','*','*','*','*','*','*','*'},
            {'*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*'}
        };

        int totalChips = 0;

        for (int r = 0; r < height; r++) {
            for (int c = 0; c < width; c++) {
                char symbol = layout[r][c];

                switch (symbol) {
                    case '*': map.setTile(r, c, new WallTile()); break;
                    case '_': map.setTile(r, c, new BlankTile()); break;
                    case 'E': map.setTile(r, c, new ExitTile()); break;
                    case 'R': 
                        if (chip.hasKey("Red"))
                            map.setTile(r, c, new BlankTile());
                        else
                            map.setTile(r, c, new RedDoor());
                        break;
                    case 'r': map.setTile(r, c, new ItemTile(new Key("Red"))); break;
                    case 'B':  
                        if (chip.hasKey("Blue"))
                            map.setTile(r, c, new BlankTile());
                        else
                            map.setTile(r, c, new BlueDoor());
                        break;
                    case 'b': map.setTile(r, c, new ItemTile(new Key("Blue"))); break;
                    case 'F': map.setTile(r, c, new FireTile()); break;
                    case 'W': map.setTile(r, c, new WaterTile()); break;
                    case 'f': map.setTile(r, c, new ItemTile(new Flippers())); break;
                    case 's': map.setTile(r, c, new ItemTile(new FireBoots())); break;
                    case '<': map.setTile(r, c, new ForceFloorTile("LEFT")); break;
                    case '>': map.setTile(r, c, new ForceFloorTile("RIGHT")); break;
                    case 'M':
                        map.setTile(r, c, new ItemTile(new Microchip()));
                        totalChips++;
                        break;
                    case 'C':
                        chip.setX(c);
                        chip.setY(r);
                        break;
                }
            }
        }

        chip.setTotalChips(totalChips);
        return map;
    }

    public static MapGrid createLevel2(Chip chip) {
        int height = 17;
        int width = 19;
        MapGrid map = new MapGrid(width, height);

        // Fill everything with blank tiles first
        for (int r = 0; r < height; r++) {
            for (int c = 0; c < width; c++) {
                map.setTile(r, c, new BlankTile());
            }
        }

        // Custom layout for Level 2
        char[][] layout = {
            {'*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*'},
            {'*','*','*','*','*','*','*','*','*','*','_','_','_','_','*','*','*','*','*'},
            {'*','*','*','*','*','*','*','*','*','*','_','f','M','_','*','*','*','*','*'},
            {'*','*','*','*','*','*','*','*','*','*','_','_','_','_','*','*','*','*','*'},
            {'*','*','*','*','*','*','*','*','*','*','*','R','*','*','*','*','*','*','*'},
            {'*','W','W','W','W','*','_','_','_','_','_','_','_','*','*','*','*','*','*'},
            {'*','W','W','E','W','_','_','_','_','_','_','_','_','*','*','*','*','*','*'},
            {'*','W','W','M','W','*','_','_','_','C','_','_','_','*','r','*','M','*','*'},
            {'*','W','W','W','W','*','_','_','_','_','_','_','_','B','_','*','_','*','*'},
            {'*','*','*','*','*','*','_','_','_','_','_','_','_','*','_','*','_','*','*'},
            {'*','*','*','*','*','*','_','_','_','*','*','*','*','*','_','_','_','*','*'},
            {'*','*','*','*','*','*','_','_','_','*','M','s','_','*','*','*','*','*','*'},
            {'*','*','*','*','*','*','_','_','_','_','_','_','_','*','*','*','*','*','*'},
            {'*','*','*','*','*','*','_','*','*','*','*','*','*','*','*','*','*','*','*'},
            {'*','*','*','*','F','F','F','F','*','*','*','*','*','*','*','*','*','*','*'},
            {'*','*','*','*','F','M','b','F','*','*','*','*','*','*','*','*','*','*','*'},
            {'*','*','*','*','F','F','F','F','*','*','*','*','*','*','*','*','*','*','*'},
            {'*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*'}
        };

        int totalChips = 0;

        for (int r = 0; r < height; r++) {
            for (int c = 0; c < width; c++) {
                char symbol = layout[r][c];

                switch (symbol) {
                    case '*': map.setTile(r, c, new WallTile()); break;
                    case '_': map.setTile(r, c, new BlankTile()); break;
                    case 'E': map.setTile(r, c, new ExitTile()); break;
                    case 'R': 
                        if (chip.hasKey("Red"))
                            map.setTile(r, c, new BlankTile());
                        else
                            map.setTile(r, c, new RedDoor());
                        break;
                    case 'r': map.setTile(r, c, new ItemTile(new Key("Red"))); break;
                    case 'B': 
                        if (chip.hasKey("Blue"))
                            map.setTile(r, c, new BlankTile());
                        else
                            map.setTile(r, c, new BlueDoor());
                        break;
                    case 'b': map.setTile(r, c, new ItemTile(new Key("Blue"))); break;
                    case 'F': map.setTile(r, c, new FireTile()); break;
                    case 'W': map.setTile(r, c, new WaterTile()); break;
                    case 'f': map.setTile(r, c, new ItemTile(new Flippers())); break;
                    case 's': map.setTile(r, c, new ItemTile(new FireBoots())); break;
                    case 'M':
                        map.setTile(r, c, new ItemTile(new Microchip()));
                        totalChips++;
                        break;
                    case 'C':
                        chip.setX(c);
                        chip.setY(r);
                        break;
                }
            }
        }

        chip.setTotalChips(totalChips);
        return map;
    }

}

