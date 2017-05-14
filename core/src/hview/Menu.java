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
    private BitmapFont font2;
    private ShapeRenderer shapeRenderer;
    private Texture gibbet;
    private Texture bone1;
    private Texture bone2;

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

        gibbet = new Texture(Gdx.files.internal("core/assets/sprites/1element.png"));
        bone1 = new Texture(Gdx.files.internal("core/assets/sprites/kosc1.png"));
        font1 = new FontGenerator().getFont("Roboto-Medium.ttf",28,true, Color.WHITE);
        font2 = new FontGenerator().getFont("Drawing Guides.ttf",70,false, Color.BLACK);
        clickBoxList = new ClickBoxList();
        clickBoxList.addClickBox(w / 4, h - 200, w / 4 + w / 2, h - 100 + 70, "Game");
        clickBoxList.addClickBox(w / 4, h - 300, w / 4 + w / 2, h - 200 + 70, "Options");
        clickBoxList.addClickBox(w / 4, h - 400, w / 4 + w / 2, h - 300 + 70, 1);
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(251/255f, 250/255f, 250/255f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(46/255f, 38/255f, 33/255f, 1);
        shapeRenderer.rect(w / 4, h - 200, w / 2, 70);
        shapeRenderer.rect(w / 4, h - 300, w / 2, 70);
        shapeRenderer.rect(w / 4, h - 400, w / 2, 70);
        shapeRenderer.end();
        batch.begin();
        //batch.draw(gibbet, 0, 0,w/2,h);
        //batch.draw(bone1, w / 4, h-250,512,128);
        font1.draw(batch, "Start", w / 2 - 30, h - 150);
        font1.draw(batch, "Opcje", w / 2- 30, h - 250);
        font1.draw(batch, "Wyjście", w / 2 - 40, h - 350);
        font2.draw(batch, "Wisielec", w / 2 - 150, h - 10);
        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
        font1.dispose();
        shapeRenderer.dispose();

    }
}
