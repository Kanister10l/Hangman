package com.mygdx.hangman;

/**
 * Created on 09.05.2017 by Kamil Samul for usage in Hangman.
 */
public class ClickResponse {
    private String nextView;
    public ClickResponse(){
        nextView = null;
    }

    public void setNextView(String nextView){
        this.nextView = nextView;
    }

    public String getNextView(){
        return nextView;
    }
}
