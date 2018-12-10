package com.mygdx.hangman;

import org.junit.Test; 
import org.junit.Before; 
import org.junit.After;

import static org.junit.Assert.assertNotNull;


public class GameConfigTest { 

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

@Test
public void testGetInstance() throws Exception { 
    assertNotNull(GameConfig.getInstance());
}

} 
