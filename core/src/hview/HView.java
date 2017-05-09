package hview;

import com.mygdx.hangman.ClickResponse;

/**
 * Created on 09.05.2017 by Kamil Samul for usage in Hangman.
 */
public abstract class HView {

    public abstract String getName();

    public abstract ClickResponse handleClick();

    public abstract void dispose();

    public abstract void render();

    protected abstract void create();
}
