package hview;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.mygdx.hangman.ClickBoxList;
import com.mygdx.hangman.ClickResponse;

/**
 * Created by jamsl on 2017-05-14.
 */
public class Options extends HView {
    private String name = "Options";
    private ClickResponse clickResponse;
    private ClickBoxList clickBoxList;
    private int operationCode;
    private float w;
    private float h;
    private SpriteBatch batch;
    private BitmapFont font1;
    private ShapeRenderer shapeRenderer;

    public Options(float h, float w) {
        name = "Menu";
        this.h = h;
        this.w = w;
        this.create();
    }
    @Override
    public String getName() {
        return null;
    }

    @Override
    public ClickResponse handleClick(float x, float y) {
        clickResponse = clickBoxList.getResponse(x, y, h);
        operationCode = clickResponse.getOperationCode();
        if (operationCode != 0){
            /*Do something here according to operationCode*/
            if (operationCode == 1)
                System.out.println("X: " + x + " Y: " + y);
        }
        return clickResponse;
    }

    @Override
    protected void create() {
        clickBoxList = new ClickBoxList();
        clickBoxList.addClickBox(0, 0, w, h, "Menu");
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(22/255f, 11/255f, 11/255f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    }

    @Override
    public void dispose() {

    }
}
