package com.example.project;

public class Player extends Sprite {
    private int treasureCount;
    private int numLives;
    private boolean win;
    private String playerEmoji;
    private boolean end;

    public Player(int x, int y) { //set treasureCount = 0 and numLives = 2
        super(x, y);
        treasureCount = 0;
        numLives = 2;
        playerEmoji = "🦄";
        win = false;
        end = false;
    }

    public int getTreasureCount(){
         return treasureCount;
        }

    public int getLives(){
         return numLives;
        }

    public boolean getWin(){
         return win;
        }

    public boolean getEnd() {
        return end;
    }

        public void setEnd(boolean bool) {
            end = bool;
        }
        
    @Override
    public String getEmoji() { 
        return playerEmoji;
    }

        //move method should override parent class, sprite
    @Override
    public void move(String direction) { //move the (x,y) coordinates of the player
            if (direction.equals("w")) {
                setY(getY() + 1);
            } else if (direction.equals("a")) {
                setX(getX() - 1);
            } else if (direction.equals("s")) {
                setY(getY() - 1);
            } else if (direction.equals("d")) {{
                setX(getX() + 1);
            }
        }
    }

    public void interact(int size, String direction, int numTreasures, Object obj) {  // interact with an object in the position you are moving to
            //numTreasures is the total treasures at the beginning of the game
        if (isValid(size, direction)) { //checks if direction is valid
            if (obj instanceof Enemy) { //if the obj is enemy, 
                numLives--;
                if (numLives < 1) {
                    win = false;
                    end = true;
                }
                move(direction); //move(direction) is repeated so player doesn't move when interacting with trophy when requirments not met
            }
            if (obj instanceof Treasure && !(obj instanceof Trophy)) { //if the obj is a treasure, add 1 to treasurecount
                treasureCount++;
                move(direction); //move(direction) is repeated so player doesn't move when interacting with trophy when requirments not met
            }
            if (obj instanceof Trophy && treasureCount == numTreasures) {
                win = true;
                end = true;
                move(direction);//move(direction) is repeated so player doesn't move when interacting with trophy when requirments not met
            }
            if (obj instanceof Dot) {
                move(direction);//move(direction) is repeated so player doesn't move when interacting with trophy when requirments not met
            }
        }
    }

    public boolean isValid(int size, String direction) { //check grid boundaries
        if (direction.equals("w") && getY() + 1 >= size) {
            return false;
        }

        if (direction.equals("a") && getX() - 1 < 0) {
            return false;
        }

        if (direction.equals("s") && getY() - 1 < 0) {
            return false;
        }
        if (direction.equals("d") && getX() + 1 >= size) {
            return false;
        }
        return true;
    }

    @Override
    public String getCoords() {  //returns the coordinates of the sprite ->"(x,y)"
        return "Player:" + super.getCoords(); 
    }

    @Override
    public String getRowCol(int size){   //returns the row and column of the sprite -> "[row][col]"
        return "Player:" + super.getRowCol(size); 
    }
}
