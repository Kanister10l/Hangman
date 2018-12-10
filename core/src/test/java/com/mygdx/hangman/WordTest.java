package com.mygdx.hangman;

import org.junit.Test; 
import org.junit.Before; 
import org.junit.After;

import static org.junit.Assert.*;


public class WordTest { 

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

@Test
public void testToString() throws Exception { 
    Word word = new Word("xD", 77.0);
    assertEquals("Word: xD Points: 77.0", word.toString());
} 


} 
