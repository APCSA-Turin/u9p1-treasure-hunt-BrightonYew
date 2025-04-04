package com.example.project;

public class Grid {
    private Sprite[][] grid;
    private int size;

    public Grid(int size) {  //initialize and create a grid with all DOT objects
        this.size = size;
        grid = new Sprite[size][size];
        for (int i = 0; i < grid.length; i++) { //uses a nested for loop to fill the grid with dots
            for (int j = 0; j < grid.length; j++) {
                grid[i][j] = new Dot(j, size - i - 1);
            }
        }
    }

    public Sprite[][] getGrid(){ 
        return grid;
    }

    public int getSize() {
        return size;
    }

    public void placeSprite(Sprite s) { //place sprite in new spot
        grid[size - s.getY() - 1][s.getX()] = s; //first bracket is inverse(goes from top to bottom), while second is the same (both move from left to right)
    }
    public void placeSprite(Sprite s, String direction) { //place sprite in a new spot based on direction
        int oldx;
        int oldy;
       grid[s.getRow(size)][s.getCol(size)] = s; //updates the grid to new coords

        if (direction.equals("w")) { //based on direction, get the old coords of s (to be turned into a dot)
            oldx = s.getX();
            oldy = s.getY() - 1;
        } else if (direction.equals("a")) {
            oldx = s.getX() + 1;
            oldy = s.getY();
        } else if (direction.equals("s")) {
            oldx = s.getX();
            oldy = s.getY() + 1;
        } else {
            oldx = s.getX() - 1;
            oldy = s.getY();
        } 
        grid[size - oldy - 1][oldx] = new Dot(oldx, oldy); //sets those old coords to a dot
    }

    

    public void display() { //print out the current grid to the screen
        for (int i = 0; i < grid.length; i++) { //uses a nested for loop to get the emoji of all the elements, and displays it
            for (int j = 0; j < grid[0].length; j++) {
                System.out.print(grid[i][j].getEmoji());
            }
            System.out.println(); //starts a new line
        }
    }
    
    public void gameover(){  //use this method to display a loss
        System.out.println("Game Over! You lost all lives.");
    }

    public void win(){  //use this method to display a win
        System.out.println("You won the game!");
    }
}
