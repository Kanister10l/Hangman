package com.mygdx.hangman;

/**
 * Created on 09.05.2017 by Kamil Samul for usage in Hangman.
 */
public class ClickBox {
    private float fromX;
    private float toX;
    private float fromY;
    private float toY;
    private ClickResponse clickResponse;

    public ClickBox(float fromX, float fromY, float toX, float toY){
        this.fromX = fromX;
        this.toX = toX;
        this.fromY = fromY;
        this.toY = toY;
        clickResponse = new ClickResponse();
    }

    public ClickBox(float fromX, float fromY, float toX, float toY, String nextView){
        this.fromX = fromX;
        this.toX = toX;
        this.fromY = fromY;
        this.toY = toY;
        clickResponse = new ClickResponse();
        clickResponse.setNextView(nextView);
    }

    public boolean isClicked(float x, float y){
        if (x >= fromX && x <= toX && y >= fromY && y <= toY)
            return true;
        return false;
    }

    public ClickResponse respond(){
        return clickResponse;
    }
}
