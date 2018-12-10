package com.mygdx.hangman;

import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.assertNotNull;


public class WordLoaderTest {
    @Test
    public void getWord() throws Exception {
        WordLoader data = new WordLoader();
        Random generator = new Random();
        data.setPoints(34);
        data.loadWord();
        assertNotNull(data.getWord());
        data.setPoints(65);
        data.loadWord();
        assertNotNull(data.getWord());
        data.setPoints(21);
        data.loadWord();
        assertNotNull(data.getWord());
    }
    }
