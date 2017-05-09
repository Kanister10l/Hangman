package com.mygdx.hangman;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.math.Vector2;
import hview.HView;
import hview.ViewGenerator;

public class Hangman extends ApplicationAdapter implements GestureDetector.GestureListener {
	private ViewGenerator viewGenerator;
	private HView hView;
	private ClickResponse clickResponse;
	private GestureDetector gestureDetector;
	
	@Override
	public void create () {
		viewGenerator = new ViewGenerator();
		hView = viewGenerator.getView("HMainView");
		System.out.println(hView.getName());
		gestureDetector = new GestureDetector(this);
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		hView.render();
	}
	
	@Override
	public void dispose () {

	}

    @Override
    public boolean touchDown(float x, float y, int pointer, int button) {
        return false;
    }

    @Override
    public boolean tap(float x, float y, int count, int button) {
	    clickResponse = hView.handleClick();
	    if (clickResponse.getNextView() != null)
	        hView = viewGenerator.getView(clickResponse.getNextView());
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
