package com.mygdx.hangman;

import java.util.ArrayList;
import java.util.List;


public class ClickBoxList {
    private List<ClickBox> clickBoxes;

    public ClickBoxList(){
        clickBoxes = new ArrayList<ClickBox>();
    }

    public void addClickBox(float fromX, float fromY, float toX, float toY){
        clickBoxes.add(new ClickBox(fromX, fromY, toX, toY));
    }

    public void addClickBox(float fromX, float fromY, float toX, float toY, String nextView){
        clickBoxes.add(new ClickBox(fromX, fromY, toX, toY, nextView));
    }

    public void addClickBox(float fromX, float fromY, float toX, float toY, int operationCode){
        clickBoxes.add(new ClickBox(fromX, fromY, toX, toY, operationCode));
    }

    public void addClickBox(float fromX, float fromY, float toX, float toY, String nextView, int operationCode){
        clickBoxes.add(new ClickBox(fromX, fromY, toX, toY, nextView, operationCode));
    }

    public ClickResponse getResponse(float x, float y, float h){
        for (ClickBox clickBox: clickBoxes) {
            if (clickBox.isClicked(x, h - 1 - y))
                return clickBox.respond();
        }
        return new ClickResponse();
    }
}
