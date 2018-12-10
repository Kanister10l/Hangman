package hview;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.mygdx.hangman.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created on 16.05.2017 by Kamil Samul for usage in Hangman.
 */
public class GameView extends HView{
    private class HField{
        public char letter;
        public boolean filled;

        public HField(char letter){
            this.letter = letter;
            this.filled = false;
        }
    }

    private String name;
    private float w;
    private float h;
    private SpriteBatch batch;
    private ShapeRenderer shapeRenderer;
    private String word;
    private WordLoader wordLoader;
    private BitmapFont font1;
    private BitmapFont font2;
    private ClickBoxList clickBoxList;
    private ClickResponse clickResponse;
    private int operationCode;
    private int selectedField;
    private List<HField> hFieldList;
    private int wordLength;
    private int faults;
    private List<Sprite> spriteList;
    private boolean lost;
    private boolean menuCreated;
    private boolean won;
    //private Sound correctSound;
    private Sound wrongSound;
    //private Sound[] loseSounds;
    private Sound[] winSounds;
    private Sound loseSound;
    private boolean wonPlayed;
    private boolean losePlayed;
    private Random random;
    private GameConfig gameConfig = GameConfig.getInstance();
    public GameView(float h, float w){
        name = "GameView";
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
        int r = 0;
        clickResponse = clickBoxList.getResponse(x, y, h);
        operationCode = clickResponse.getOperationCode();
        if (!lost && operationCode != 0 && !won) {
            r = checkLetter((char) operationCode);
            faults += r;
            if (r != 0) {

                if(gameConfig.getNotMuteSound()) {
                    wrongSound.play();
                }
            }

        }
        if (faults >= 11)
            lost = true;
        won = checkWin();
        if (won && !wonPlayed){
            if(gameConfig.getNotMuteSound()){
                winSounds[random.nextInt(3)].play();
            }

            wonPlayed = true;
        }
        else if (lost && !losePlayed){
            if(gameConfig.getNotMuteSound()){
                loseSound.play();
            }
            losePlayed = true;
        }
        return clickResponse;
    }

    @Override
    protected void create() {
        batch = new SpriteBatch();
        shapeRenderer = new ShapeRenderer();
        wordLoader = new WordLoader(gameConfig.getDifficulty());
        clickBoxList = new ClickBoxList();
        spriteList = new ArrayList<Sprite>(12);
        random = new Random();
        winSounds = new Sound[3];
        //loseSounds = new Sound[3];

        selectedField = 0;
        faults = 0;
        lost = false;
        menuCreated = false;
        won = false;

        font1 = FontGenerator.getFont("Roboto-Medium.ttf",28,true, Color.WHITE);
        font2 = FontGenerator.getFont("Drawing Guides.ttf",70,false, Color.BLACK);

        for (int i = 1; i < 13; i++) {
            spriteList.add(new Sprite(new Texture(Gdx.files.internal("core/assets/sprites/" + Integer.toString(i) + ".png"))));
            spriteList.get(i - 1).setScale(0.4f);
            spriteList.get(i - 1).setPosition(w - 1 - spriteList.get(i - 1).getWidth(), 0);
        }

        wordLoader.loadWord();
        word = wordLoader.getWord().getWord().toUpperCase();

        wordLength = word.length();
        hFieldList = new ArrayList<HField>(wordLength);
        for (int i = 0; i < wordLength; i++) {
            hFieldList.add(new HField(word.charAt(i)));
        }
        System.out.println(word);
        for (int i = 'A'; i <= 'Z'; i++) {
            clickBoxList.addClickBox(49 * (i - 'A'), font1.getLineHeight(), 49 * (i - 'A' + 1) - 1, font1.getLineHeight() * 2, i);
        }
        clickBoxList.addClickBox(49 * 0, 0, 49 * 1 - 1, font1.getLineHeight() -1, 260);
        clickBoxList.addClickBox(49 * 1, 0, 49 * 2 - 1, font1.getLineHeight() -1, 262);
        clickBoxList.addClickBox(49 * 2, 0, 49 * 3 - 1, font1.getLineHeight() -1, 280);
        clickBoxList.addClickBox(49 * 3, 0, 49 * 4 - 1, font1.getLineHeight() -1, 321);
        clickBoxList.addClickBox(49 * 4, 0, 49 * 5 - 1, font1.getLineHeight() -1, 323);
        clickBoxList.addClickBox(49 * 5, 0, 49 * 6 - 1, font1.getLineHeight() -1, 211);
        clickBoxList.addClickBox(49 * 6, 0, 49 * 7 - 1, font1.getLineHeight() -1, 346);
        clickBoxList.addClickBox(49 * 7, 0, 49 * 8 - 1, font1.getLineHeight() -1, 'Ź');
        clickBoxList.addClickBox(49 * 8, 0, 49 * 9 - 1, font1.getLineHeight() -1, 'Ż');

        //correctSound = Gdx.audio.newSound(Gdx.files.internal("core/assets/sounds/correctSound.wav"));
        wrongSound = Gdx.audio.newSound(Gdx.files.internal("core/assets/sounds/wrongSound.wav"));
        loseSound = Gdx.audio.newSound(Gdx.files.internal("core/assets/sounds/loseSound2.wav"));
        for (int i = 0; i < 3; i++) {
            winSounds[i] = Gdx.audio.newSound(Gdx.files.internal("core/assets/sounds/winSound" + (i + 1) + ".wav"));
        }

    }

    @Override
    public void render() {
        if ((won || lost) && !menuCreated) {
            clickBoxList.addClickBox(30, h - 450, 260, h - 400, "Menu");
            clickBoxList.addClickBox(30, h - 510, 260, h - 460, "GameView");
            menuCreated = true;
        }
        Gdx.gl.glClearColor(160/255f, 160/255f, 160/255f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        if ((won || lost) && menuCreated){
            shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
            shapeRenderer.setColor(46/255f, 38/255f, 33/255f, 1);
            shapeRenderer.rect(30, h - 450 -1, 230, 50);
            shapeRenderer.rect(30, h - 510 -1, 230, 50);
            shapeRenderer.end();
        }

        batch.begin();
        for (int i = 'A'; i <= 'Z'; i++) {
            font1.draw(batch, Character.toString((char)i), 49 * (i - 'A') + 15, (int)font1.getLineHeight() * 2);
        }
        font1.draw(batch, "Ą", 49 * 0 + 15, (int)font1.getLineHeight());
        font1.draw(batch, "Ć", 49 * 1 + 15, (int)font1.getLineHeight());
        font1.draw(batch, "Ę", 49 * 2 + 15, (int)font1.getLineHeight());
        font1.draw(batch, "Ł", 49 * 3 + 15, (int)font1.getLineHeight());
        font1.draw(batch, "Ń", 49 * 4 + 15, (int)font1.getLineHeight());
        font1.draw(batch, "Ó", 49 * 5 + 15, (int)font1.getLineHeight());
        font1.draw(batch, "Ś", 49 * 6 + 15, (int)font1.getLineHeight());
        font1.draw(batch, "Ź", 49 * 7 + 15, (int)font1.getLineHeight());
        font1.draw(batch, "Ż", 49 * 8 + 15, (int)font1.getLineHeight());

        for (int i = 0; i < wordLength; i++) {
            if (hFieldList.get(i).filled)
                font1.draw(batch, Character.toString(hFieldList.get(i).letter), 100 + 49 * i, h - 100);
            else
                font1.draw(batch, "_", 100 + 49 * i, h - 100);
        }

        for (int i = 0; i < faults + 1; i++) {
            spriteList.get(i).draw(batch);

        }
        font1.draw(batch, "Liczba błędów: " + faults + "/11", 100, h - 170);
        if ((won || lost) && menuCreated){
            font1.draw(batch, "Menu", 40, h - 415);
            font1.draw(batch, "Jeszcze raz", 40, h - 475);
            if (lost)
                font1.draw(batch, "Przegrałeś!!!", 100, h - 230);
            else if (won)
                font1.draw(batch, "Wygrałeś!!!", 100, h - 230);
        }
        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
        font1.dispose();
        font2.dispose();
        shapeRenderer.dispose();
    }

    private int checkLetter(char letter){
        int found = 0;
        for (int i = 0; i < wordLength; i++) {
            if (hFieldList.get(i).letter == letter && !hFieldList.get(i).filled) {
                found = 1;
                hFieldList.get(i).filled = true;
            }
        }
        if (found == 0)
            return 1;
        else
            return 0;
    }
    private boolean checkWin(){
        boolean w = true;
        for (int i = 0; i < wordLength; i++) {
            if (!hFieldList.get(i).filled)
                w = false;
        }
        return w;
    }
}
