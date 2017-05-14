package hview;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.mygdx.hangman.ClickBoxList;
import com.mygdx.hangman.ClickResponse;
import com.mygdx.hangman.FontGenerator;

/**
 * Created by jamsl on 2017-05-13.
 */
public class Menu extends HView {

    private String name = "Menu";
    private ClickResponse clickResponse;
    private ClickBoxList clickBoxList;
    private int operationCode;
    private float w;
    private float h;
    private SpriteBatch batch;
    private BitmapFont font1;
    private ShapeRenderer shapeRenderer;

    public Menu(float h, float w) {
        name = "Menu";
        this.h = h;
        this.w = w;
        this.create();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public ClickResponse handleClick(float x, float y) {
        clickResponse = clickBoxList.getResponse(x, y, h);
        operationCode = clickResponse.getOperationCode();
        if (operationCode == 1) {
            System.exit(0);
        }
        return clickResponse;
    }


    @Override
    protected void create() {
        batch = new SpriteBatch();

        shapeRenderer = new ShapeRenderer();

        font1 = new FontGenerator().getFont("Roboto-Medium.ttf",22,true);
        clickBoxList = new ClickBoxList();
        clickBoxList.addClickBox(w / 4, h - 100, w / 4 + w / 2, h - 100 + 70, "Game");
        clickBoxList.addClickBox(w / 4, h - 200, w / 4 + w / 2, h - 200 + 70, "Options");
        clickBoxList.addClickBox(w / 4, h - 300, w / 4 + w / 2, h - 300 + 70, 1);
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(132/255f, 95/255f, 97/255f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(0, 1, 0, 1);
        shapeRenderer.rect(w / 4, h - 100, w / 2, 70);
        shapeRenderer.setColor(1, 1, 0, 1);
        shapeRenderer.rect(w / 4, h - 200, w / 2, 70);
        shapeRenderer.setColor(1, 0, 1, 1);
        shapeRenderer.rect(w / 4, h - 300, w / 2, 70);
        shapeRenderer.end();
        batch.begin();
        font1.draw(batch, "Start", w / 4 + w / 4 - 30, h - 50);
        font1.draw(batch, "Opcje", w / 4 + w / 4 - 30, h - 150);
        font1.draw(batch, "Wyjście", w / 4 + w / 4 - 35, h - 250);
        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
        font1.dispose();
        shapeRenderer.dispose();

    }
}
