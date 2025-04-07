package com.example.project;

//only needs a constructor
public class Treasure extends Sprite{ //child of Sprite
    private String treasureEmoji;

    public Treasure(int x, int y) {
        super(x,y);
        treasureEmoji = "🌈";//needed for display
    }
    @Override
    public String getEmoji() {
        return treasureEmoji;
    }




}