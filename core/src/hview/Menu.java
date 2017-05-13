package hview;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.mygdx.hangman.ClickBoxList;
import com.mygdx.hangman.ClickResponse;

/**
 * Created by jamsl on 2017-05-13.
 */
public class Menu extends HView {

    private String name="Menu";
    private ClickResponse clickResponse;
    private ClickBoxList clickBoxList;
    private int operationCode;
    private float w;
    private float h;

    @Override
    public String getName() {
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
        Gdx.gl.glClearColor( 255, 255, 255, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        ShapeRenderer shapeRenderer = new ShapeRenderer();
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(0, 1, 0, 1);
        shapeRenderer.rect(w/4, h-100, w/2, 70);
        shapeRenderer.setColor(1, 1, 0, 1);
        shapeRenderer.rect(w/4, h-200, w/2, 70);
        shapeRenderer.setColor(1, 0, 1, 1);
        shapeRenderer.rect(w/4, h-300, w/2, 70);
        shapeRenderer.end();

    }

    @Override
    protected void create() {
        clickBoxList = new ClickBoxList();
        clickBoxList.addClickBox(0, 0, 100, 100, 1);
        clickBoxList.addClickBox(200, 200, 300, 300, 2);
    }

    @Override
    public void setResolution(float h, float w) {
        this.h = h;
        this.w = w;
    }
}
