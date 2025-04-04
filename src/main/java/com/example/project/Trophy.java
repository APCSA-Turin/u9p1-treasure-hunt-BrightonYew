package com.example.project;

//only needs a constructor
public class Trophy extends Treasure{ //child of trophy
    private String trophyEmoji;
    public Trophy(int x, int y){
        super(x, y);
        trophyEmoji = "🏆";
    }

    @Override
    public String getEmoji() {return trophyEmoji;}
}
