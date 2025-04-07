package com.example.project;


//Dot only needs a constructor
public class Dot extends Sprite{
    private String dotEmoji;
    public Dot (int x, int y) {
        super(x,y);
        dotEmoji = "⬜"; //needed for display
    }
    @Override
    public String getEmoji() {
        return dotEmoji;
    }


}
