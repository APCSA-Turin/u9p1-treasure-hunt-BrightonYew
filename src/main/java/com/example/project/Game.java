package com.example.project;
import java.util.Scanner;

public class Game{
    private Grid grid;
    private Player player;
    private Enemy[] enemies;
    private Treasure[] treasures;
    private Trophy trophy;
    private int size; 

    public Game(int size){ //the constructor should call initialize() and play()
        this.size = size;
        initialize();
        play();
    }

    public static void clearScreen() { //do not modify
        try {
            final String os = System.getProperty("os.name").toLowerCase();
            if (os.contains("win")) {
                // Windows
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                // Unix-based (Linux, macOS)
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    public void play(){ //write your game logic here
        while(!player.getEnd()) { //loops until an ending is reached, or manually manupulated when pressing "q"
            clearScreen(); //clears the screen for a clean interface

            grid.display(); //displays the current grid
            Scanner scanner = new Scanner(System.in); //asks the user for input to play the game
            System.out.println("What is your move? q to quit");
            String input = scanner.nextLine();
            if (input.equals("q")) { //ends the loop if q is pressed
                player.setEnd(true);
            }
            
            Object obj = new Object(); //used to determine interaction
            if (player.isValid(size, input)) { //gets the object in front of player based on the provided direction
                switch(input) {
                    case "w": obj = grid.getGrid()[(size - 1)-player.getY()-1][player.getX()]; break;
                    case "a": obj = grid.getGrid()[(size - 1)-player.getY()][player.getX()-1]; break;
                    case "s": obj = grid.getGrid()[(size - 1)-player.getY()+1][player.getX()]; break;
                    case "d": obj = grid.getGrid()[(size - 1)-player.getY()][player.getX()+1]; break;
                }
            }
            player.interact(grid.getGrid().length, input, treasures.length, obj); //based on the object, update variables
            player.move(input); //move player
            grid.placeSprite(player, input); //updates the grid to the updated information

            //used for debugging
            System.out.println("Lives num: " + player.getLives() + " treasure num: " + player.getTreasureCount() + " player cords: " + player.getCoords() + "win? " + player.getWin() + " interacted obj: " + obj.getClass());

        }
        if (player.getWin()) { //after the loop, either display a win or lose
            grid.win();
        } else {
            grid.gameover();
        }
    }



    public void initialize(){

        //to test, create a player, trophy, grid, treasure, and enemies. Then call placeSprite() to put them on the grid
        grid = new Grid(size);
        player = new Player(0,0);
        Enemy enemy1 = new Enemy(1,1);
        trophy = new Trophy(0, 9);
        Enemy enemy2 = new Enemy(8,1);
        Treasure treasure1 = new Treasure(4, 0);
        Treasure treasure2 = new Treasure(0, 4);
        treasures = new Treasure[2];
        treasures[0] = treasure1;
        treasures[1] = treasure2;
        enemies = new Enemy[2];
        enemies[0] = enemy1;
        enemies[1] = enemy2;
        grid.placeSprite(player);
        grid.placeSprite(enemy1);
        grid.placeSprite(trophy);
        grid.placeSprite(enemy2);
        grid.placeSprite(treasure1);
        grid.placeSprite(treasure2);
    }

    public static void main(String[] args) {
        Game game = new Game(10);
        
    }
}