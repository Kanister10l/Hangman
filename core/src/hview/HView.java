package hview;

import com.mygdx.hangman.ClickResponse;


public abstract class HView {

    public abstract String getName();

    public abstract ClickResponse handleClick(float x, float y);

    protected abstract void create();

    public abstract void render();

    public abstract void dispose();
}
