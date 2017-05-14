package com.mygdx.hangman;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;

/**
 * Created by jamsl on 2017-05-14.
 */
public class FontGenerator {

    public static BitmapFont getFont(String fontFileName, int size, boolean border, Color color) {
        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("core/assets/fonts/"+fontFileName));
        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();

        parameter.characters = "aąbcćdeęfghijklłmnńoópqrsśtuvwxyzźżAĄBCĆDEĘFGHIJKLŁMNŃOÓPQRSŚTUVWXYZŹŻ0123456789][_!$%#@|\\/?-+=()*&.;:,{}\"´`'<>";
        parameter.size = size;
        parameter.color = color;
        if(border){
            parameter.borderColor = Color.BLACK;
            parameter.borderWidth = 2;
        }
        BitmapFont font = generator.generateFont(parameter);
        generator.dispose();

        return font;
    }
}