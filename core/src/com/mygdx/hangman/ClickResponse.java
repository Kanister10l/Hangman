package com.mygdx.hangman;

/**
 * Created on 09.05.2017 by Kamil Samul for usage in Hangman.
 */
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
