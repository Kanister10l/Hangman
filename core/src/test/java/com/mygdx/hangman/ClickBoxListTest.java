package com.mygdx.hangman;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created on 31.05.2017 by Kamil Samul for usage in Hangman.
 */
public class ClickBoxListTest {
    @Test
    public void getResponse() throws Exception {
        ClickBoxList cbl = new ClickBoxList();
        cbl.addClickBox(10f, 10f, 50f, 50f);
        assertNotNull(cbl.getResponse(11f, 11f, 100f));
    }

}