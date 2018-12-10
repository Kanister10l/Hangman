package com.mygdx.hangman;


public class ClickResponse {
    private String nextView;
    private int operationCode;

    public ClickResponse(){
        nextView = null;
        operationCode = 0;
    }

    public void setNextView(String nextView){
        this.nextView = nextView;
    }

    public String getNextView(){
        return nextView;
    }

    public void setOperationCode(int operationCode){
        this.operationCode = operationCode;
    }

    public int getOperationCode(){
        return operationCode;
    }
}
