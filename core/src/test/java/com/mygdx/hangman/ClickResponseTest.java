package com.mygdx.hangman;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created on 31.05.2017 by Kamil Samul for usage in Hangman.
 */
public class ClickResponseTest {
    @Test
    public void getNextView() throws Exception {
        ClickResponse cr = new ClickResponse();
        cr.setNextView("Menu");
        assertEquals("Menu", cr.getNextView());
    }

    @Test
    public void getOperationCode() throws Exception {
        ClickResponse cr = new ClickResponse();
        cr.setOperationCode(1000);
        assertEquals(1000, cr.getOperationCode());
    }

}