package com.mygdx.hangman;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import hview.HView;
import hview.ViewGenerator;

public class Hangman extends ApplicationAdapter {
	private ViewGenerator viewGenerator;
	private HView hView;
	
	@Override
	public void create () {
		viewGenerator = new ViewGenerator();
		hView = viewGenerator.getView("HMainView");
		System.out.println(hView.getName());
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
	}
	
	@Override
	public void dispose () {

	}
}
