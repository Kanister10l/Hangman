package com.mygdx.hangman;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.math.Vector2;
import hview.HView;
import hview.ViewGenerator;

public class Hangman extends ApplicationAdapter implements GestureDetector.GestureListener {
    private ViewGenerator viewGenerator;
    private HView hView;
    private ClickResponse clickResponse;
    private GestureDetector gestureDetector;
    private float h;
    private float w;

    @Override
    public void create() {
        h = (float) Gdx.graphics.getHeight();
        w = (float) Gdx.graphics.getWidth();
        viewGenerator = new ViewGenerator();
        hView = viewGenerator.getView("Menu", h, w);
        System.out.println(hView.getName());
        gestureDetector = new GestureDetector(this);
        Gdx.input.setInputProcessor(gestureDetector);
    }

    @Override
    public void render() {
        hView.render();
    }

    @Override
    public void dispose() {

    }

    @Override
    public boolean touchDown(float x, float y, int pointer, int button) {
        return false;
    }

    @Override
    public boolean tap(float x, float y, int count, int button) {
        System.out.println("tap X: " + x + " Y: " + y);
        clickResponse = hView.handleClick(x, y);
        if (clickResponse.getNextView() != null) {
            hView = viewGenerator.getView(clickResponse.getNextView(), h, w);
        }
        return false;
    }

    @Override
    public boolean longPress(float x, float y) {
        return false;
    }

    @Override
    public boolean fling(float velocityX, float velocityY, int button) {
        return false;
    }

    @Override
    public boolean pan(float x, float y, float deltaX, float deltaY) {
        return false;
    }

    @Override
    public boolean panStop(float x, float y, int pointer, int button) {
        return false;
    }

    @Override
    public boolean zoom(float initialDistance, float distance) {
        return false;
    }

    @Override
    public boolean pinch(Vector2 initialPointer1, Vector2 initialPointer2, Vector2 pointer1, Vector2 pointer2) {
        return false;
    }

    @Override
    public void pinchStop() {

    }
}
