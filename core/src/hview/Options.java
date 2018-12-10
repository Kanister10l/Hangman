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
import com.mygdx.hangman.GameConfig;


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
    private Texture nextTexture;
    private Boolean dzwiek = true;
    private GameConfig gameConfig;
    private int nextDiff;
    private class Diff {
        private int downLvl;
        private int highLvl;
        private String name;

        public Diff(int downLvl, int highLvl, String name) {
            this.downLvl = downLvl;
            this.highLvl = highLvl;
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public Boolean validDiff(int points) {
            return (downLvl <= points && points < highLvl);
        }
        public int getAvgPoints(){
            return (downLvl+highLvl)/2;
        }
    }
    private Diff[] diff;
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
        if (operationCode != 0) {
            /*Do something here according to operationCode*/
            if (operationCode == 1)
                System.out.println("X: " + x + " Y: " + y);
            if (operationCode == 2)
                gameConfig.switchSound();
            if (operationCode == 3)
                gameConfig.setDifficulty(diff[nextDiff].getAvgPoints());
        }
        return clickResponse;
    }

    @Override
    protected void create() {
        gameConfig = gameConfig.getInstance();
        diff = new Diff[5];
        diff[0] = new Diff(0, 20, "Bardzo łatwy");
        diff[1] = new Diff(20, 30, "Łatwy");
        diff[2] = new Diff(30, 40, "Średni");
        diff[3] = new Diff(40, 50, "Trudny");
        diff[4] = new Diff(50, 76, "Piekielny");
        batch = new SpriteBatch();
        shapeRenderer = new ShapeRenderer();
        clickBoxList = new ClickBoxList();
        clickBoxList.addClickBox(w - 100, h - 100, w - 50, h - 50, "Menu");
        clickBoxList.addClickBox(w / 4, h - 200, w / 4 + w / 2, h - 100 + 70, 2);
        clickBoxList.addClickBox(w / 4, h - 300, w / 4 + w / 2, h - 200 + 70, 3);
        font1 = new FontGenerator().getFont("Roboto-Medium.ttf", 28, true, Color.WHITE);
        quitTexture = new Texture(Gdx.files.internal("core/assets/sprites/exit.png"));
        nextTexture = new Texture(Gdx.files.internal("core/assets/sprites/next.png"));
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(251 / 255f, 250 / 255f, 250 / 255f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(46 / 255f, 38 / 255f, 33 / 255f, 1);
        shapeRenderer.rect(w / 4, h - 200, w / 2, 70);
        shapeRenderer.rect(w / 4, h - 300, w / 2, 70);
        shapeRenderer.end();


        batch.begin();

        if (gameConfig.getNotMuteSound()) {
            font1.draw(batch, "Wyłącz dźwięki", w / 4 + w / 6, h - 150);
        } else {
            font1.draw(batch, "Włącz dźwięki", w / 4 + w / 6, h - 150);
        }
        for(int i=0;i<5;i++){
            if(diff[i].validDiff(gameConfig.getDifficulty())){
                font1.draw(batch, diff[i].getName(), w / 4 + w / 6, h - 250);
                if(i+1==5){
                    nextDiff =0;
                }else{
                    nextDiff = i+1;
                }
            }
        }
        batch.draw(quitTexture, w - 100, h - 100, 50, 50);
        batch.draw(nextTexture, w/4+w/2-70, h - 300, 70, 70);
        batch.end();

    }

    @Override
    public void dispose() {
        shapeRenderer.dispose();
        font1.dispose();
        batch.dispose();
    }
}
