package com.mygdx.hangman;

import org.junit.Test; 
import org.junit.Before; 
import org.junit.After;

import static org.junit.Assert.assertNotNull;

/** 
* GameConfig Tester. 
* 
* @author <Authors name> 
* @since <pre>gru 10, 2018</pre> 
* @version 1.0 
*/ 
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
