package hview;

import com.mygdx.hangman.ClickBoxList;
import com.mygdx.hangman.ClickResponse;

/**
 * Created on 09.05.2017 by Kamil Samul for usage in Hangman.
 */
public class HMainView extends HView {
    private String name;
    private ClickResponse clickResponse;
    private ClickBoxList clickBoxList;
    private int operationCode;
    private float w;
    private float h;

    public HMainView(float h, float w){
        name = "HMainView";
        this.h = h;
        this.w = w;
        this.create();
    }

    public String getName(){
        return name;
    }

    @Override
    public ClickResponse handleClick(float x, float y) {
        clickResponse = clickBoxList.getResponse(x, y);
        operationCode = clickResponse.getOperationCode();
        if (operationCode != 0){
            /*Do something here according to operationCode*/
            if (operationCode == 1)
                System.out.println("X: " + x + " Y: " + y);
        }
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
        clickBoxList = new ClickBoxList();
        clickBoxList.addClickBox(0, 0, 100, 100, 1);
    }
}
