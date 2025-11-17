/*
* This is the main class that manages the entire game flow.
* It handles everything from loading the map, starting the main game loop, accepting player input, moving the player (Chip), and managing interactions with tiles.
* It also manages the overall game state, such as keeping track of the current level and whether the game is running.
*
* Parameters: None
*
* Returns: start(): This is the main game loop. It runs continuously until the player quits ('Q') or finishes all levels. It handles input, movement, and tile interactions.
*          moveChipAutomatically(Direction dir): Handles the special movement logic for Force Floor tiles, where Chip slides continuously until hitting a wall, a different tile, or an obstacle.
*          loadNextLevel(): Moves the game to the next level, resets the player's inventory, and reloads the map.
*/


package GameControlCore;


import DoorCore.*;
import GameCore.*;
import TileCore.*;
import java.util.Scanner;


public class GameEngine {


    private MapGrid map;
    private Chip chip;
    private boolean running;
    private int level;


    public GameEngine() {
        this.level = 1;
        this.chip = new Chip(0, 0); // Position set by LevelData
        this.map = LevelData.createLevel1(chip);
        chip.setCurrentMap(map);
        this.running = true;
    }


    public void start() {
        Scanner sc = new Scanner(System.in);


        while (running) {
            System.out.println("\n=== CHIP'S CHALLENGE (Level " + level + ") ===");
            map.display(chip);
            chip.printInventory();
            System.out.print("Move (W/A/S/D), Q to quit: ");
            String input = sc.nextLine().toUpperCase();


            if (input.length() == 0) continue;
            char move = input.charAt(0);


            if (move == 'Q') {
                System.out.println("Game exited.");
                break;
            }


            int newX = chip.getX();
            int newY = chip.getY();


            // Movement
            if (move == 'W') newY--;
            else if (move == 'S') newY++;
            else if (move == 'A') newX--;
            else if (move == 'D') newX++;
            else continue;


            // Bounds check
            if (newX < 0 || newX >= map.getWidth() || newY < 0 || newY >= map.getHeight()) {
                System.out.println("You hit a wall!");
                continue;
            }


            Tile target = map.getTile(newY, newX);


            // Handle Door
            if (target instanceof DoorTile door) {
                boolean opened = door.isWalkable(chip);
                if (opened) {
                    map.setTile(newY, newX, new BlankTile());
                    chip.setX(newX);
                    chip.setY(newY);
                }
                continue; // Prevent running isWalkable() again this turn
            }


            if (target.isWalkable(chip)) {
                chip.setX(newX);
                chip.setY(newY);


                // Handle item pickup
                if (target instanceof ItemTile) {
                    map.setTile(newY, newX, new BlankTile());
                }


                // Handle ForceFloor movement
                if (target instanceof ForceFloorTile) {
                    ForceFloorTile floor = (ForceFloorTile) target;
                    Direction dir = floor.getDirection();
                    moveChipAutomatically(dir);
                }


                // Handle Exit
                if (target instanceof ExitTile) {
                    if (chip.hasAllChips()) {
                        System.out.println("Level " + level + " complete!");
                        loadNextLevel();
                    }
                }
            } else if (target instanceof ExitTile && !chip.hasAllChips()) {
                System.out.println("The exit is locked! Collect all microchips first.");
            } else {
                System.out.println("You can't move there!");
            }
        }


        sc.close();
    }


    /**
     * Handles the special continuous movement for Force Floor tiles.
     * Chip will keep moving in the given direction until hitting a wall, a locked door, an obstacle, or the exit.
     *
     * Parameter: dir: The direction the force floor is pushing Chip.
     */
   private void moveChipAutomatically(Direction dir) {
        boolean sliding = true;


        while (sliding) {
            int dx = 0, dy = 0;


            switch (dir) {
                case UP -> dy = -1;
                case DOWN -> dy = 1;
                case LEFT -> dx = -1;
                case RIGHT -> dx = 1;
            }


            int nextX = chip.getX() + dx;
            int nextY = chip.getY() + dy;


           
            if (nextX < 0 || nextX >= map.getWidth() || nextY < 0 || nextY >= map.getHeight()) {
                System.out.println("You slide into a wall and stop.");
                break;
            }


            Tile next = map.getTile(nextY, nextX);


            // Stop if it's a wall or obstacle
            if (next instanceof WallTile) {
                System.out.println("You slide into a wall and stop.");
                break;
            }
           
            if (next.isWalkable(chip)) {
                if(next instanceof DoorTile){
                    map.setTile(nextX, nextY, new BlankTile());
                } else if(next instanceof DoorTile door && !door.isWalkable(chip)){
                    System.out.println("You slide into a locked " + door.getColor() + " door!");
                    break;
                }


                chip.setX(nextX);
                chip.setY(nextY);
            }


            // Pickup items while sliding
            if (next instanceof ItemTile) {
                map.setTile(nextY, nextX, new BlankTile());
            }


            // Exit check while sliding
            if (next instanceof ExitTile) {
                if (chip.hasAllChips()) {
                    System.out.println("You slide right into the exit!");
                    loadNextLevel();
                } else {
                    System.out.println("The exit is locked! Collect all microchips first.");
                }
                break;
            }


            // Continue sliding if next is another Force Floor
            if (next instanceof ForceFloorTile nextFloor) {
                dir = nextFloor.getDirection();
                System.out.println("Sliding " + dir.name().toLowerCase() + "...");
            } else {
                sliding = false;
            }
        }
    }


    /*
     * Clears the current level and prepares the next one.
     * It increments the level number, loads the new map layout, and clears Chip's inventory.
     */
    private void loadNextLevel() {
        level++;
        if (level == 2) {
            System.out.println("Loading Level 2...");
            map = LevelData.createLevel2(chip);
            chip.setCurrentMap(map);
            chip.clearInventory();
            chip.resetChips();
        } else {
            System.out.println("Congratulations! You finished all available levels!");
            running = false;
        }
    }


    /*
     * The starting point for the entire program.
     * It creates a new GameEngine object and calls its 'start()' method to begin the game.
     */
    public static void main(String[] args) {
        GameEngine engine = new GameEngine();
        engine.start();
    }
}





