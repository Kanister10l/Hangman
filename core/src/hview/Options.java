package hview;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.mygdx.hangman.ClickBoxList;
import com.mygdx.hangman.ClickResponse;
import com.mygdx.hangman.FontGenerator;

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
    private Texture quitTexture;
    private Boolean dzwiek=true;
    public Options(float h, float w) {
        name = "Options";
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
            if (operationCode == 2)
                dzwiek = !dzwiek;
        }
        return clickResponse;
    }

    @Override
    protected void create() {
        batch = new SpriteBatch();
        shapeRenderer = new ShapeRenderer();
        clickBoxList = new ClickBoxList();
        clickBoxList.addClickBox(w-100, h-100, w-50, h-50, "Menu");
        clickBoxList.addClickBox(w / 4, h - 200, w / 4 + w / 2, h - 100 + 70, 2);
        font1 = new FontGenerator().getFont("Roboto-Medium.ttf",28,true, Color.WHITE);
        quitTexture = new Texture(Gdx.files.internal("core/assets/sprites/exit.png"));
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(251/255f, 250/255f, 250/255f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(46/255f, 38/255f, 33/255f, 1);
        shapeRenderer.rect(w / 4, h - 200, w / 2, 70);
        shapeRenderer.end();



        batch.begin();

        if(dzwiek){
            font1.draw(batch, "Wyłącz dźwięki", w / 4+w / 6, h - 150);
        }else{
            font1.draw(batch, "Włącz dźwięki", w / 4+w / 6, h - 150);
        }
        batch.draw(quitTexture,w-100,h-100,50,50);
        batch.end();

    }

    @Override
    public void dispose() {
        shapeRenderer.dispose();
        font1.dispose();
        batch.dispose();
    }
}
