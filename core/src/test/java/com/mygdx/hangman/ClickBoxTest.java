package com.mygdx.hangman;

import org.junit.Test;

import static org.junit.Assert.*;


public class ClickBoxTest {
    @Test
    public void respond() throws Exception {
        ClickBox cb = new ClickBox(10f, 10f, 50f, 50f);
        assertNotNull(cb.respond());
    }

    @Test
    public void isClicked() throws Exception {
        ClickBox cb = new ClickBox(10f, 10f, 50f, 50f);
        assertTrue(cb.isClicked(20f, 20f));
        assertFalse(cb.isClicked(0f, 0f));
    }

}