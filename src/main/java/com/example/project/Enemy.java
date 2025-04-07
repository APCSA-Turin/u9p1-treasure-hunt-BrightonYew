package com.example.project;

public class Enemy extends Sprite {  //child  of Sprite
    private String enemyEmoji;
    public Enemy(int x, int y) {
        super(x, y);
        enemyEmoji = "🦂";//needed for display
    }
    @Override
    public String getEmoji() {
        return enemyEmoji;
    }
    //the methods below should override the super class

    @Override
    public String getCoords(){ //returns "Enemy:"+coordinates
        return "Enemy:" + super.getCoords();
    }

    @Override
    public String getRowCol(int size){  //return "Enemy:"+row col
        return "Enemy:" + super.getRowCol(size);
    }
}
