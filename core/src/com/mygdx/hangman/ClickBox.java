package com.mygdx.hangman;


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

    public ClickBox(float fromX, float fromY, float toX, float toY, int operationCode){
        this.fromX = fromX;
        this.toX = toX;
        this.fromY = fromY;
        this.toY = toY;
        clickResponse = new ClickResponse();
        clickResponse.setOperationCode(operationCode);
    }

    public ClickBox(float fromX, float fromY, float toX, float toY, String nextView, int operationCode){
        this.fromX = fromX;
        this.toX = toX;
        this.fromY = fromY;
        this.toY = toY;
        clickResponse = new ClickResponse();
        clickResponse.setNextView(nextView);
        clickResponse.setOperationCode(operationCode);
    }

    public boolean isClicked(float x, float y){
        return x >= fromX && x <= toX && y >= fromY && y <= toY;
    }

    public ClickResponse respond(){
        return clickResponse;
    }
}
