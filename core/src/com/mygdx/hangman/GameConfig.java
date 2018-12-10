package com.mygdx.hangman;


public class GameConfig {
    private Boolean notMuteSound = true;
    private int difficulty = 21;

    public void switchSound() {
         notMuteSound = !notMuteSound;
    }

    public Boolean getNotMuteSound() {
        return notMuteSound;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

    private static GameConfig instance = null;

    protected GameConfig() {
            // Exists only to defeat instantiation.
    }
    public static GameConfig getInstance() {
        if(instance == null) {
            instance = new GameConfig();
        }
        return instance;
    }
}
