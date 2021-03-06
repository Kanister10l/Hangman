package com.mygdx.hangman;

public class Word {
    private String word;
    private double points;
    public Word(String word,double points){
        this.word = word;
        this.points = points;
    }
    public String getWord(){
        return word;
    }
    public double getPoints(){
        return points;
    }
    public String toString(){
        StringBuilder toReturn = new StringBuilder();
        toReturn.append("Word: "+word);
        toReturn.append(" Points: "+points);
        return toReturn.toString();
    }
}
