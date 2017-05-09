package hview;

import com.mygdx.hangman.ClickResponse;

/**
 * Created on 09.05.2017 by Kamil Samul for usage in Hangman.
 */
public class HMainView extends HView {
    private String name;
    private ClickResponse clickResponse;

    public HMainView(){
        name = "HMainView";
        this.create();
    }

    public String getName(){
        return name;
    }

    @Override
    public ClickResponse handleClick() {
        clickResponse = new ClickResponse();

        return clickResponse;
    }

    @Override
    public void dispose() {

    }

    @Override
    public void render() {

    }

    @Override
    protected void create() {

    }
}
