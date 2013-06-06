package edu.ucsb.cs56.projects.games.roguelike;


import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

/** test class for my Item class
@author Hans Marasigan & Richard Nguyen
@version cs56 S13
@see Item
*/

public class ItemTest{
    /**
       this tests the default constructor. 
       the effect should be 10 and used is false and it is an item
    */
    @Test public void test_defaultItemConstructor_andGetters(){
	Item i=new Item();
	assertEquals(10,i.getEffect());
	assertEquals(false,i.getUse());
	assertEquals("item",i.getTypeOfPiece());
    }
    /**
       this tests the 1 Arg constructor for an int effect
       the effect should be 15 and used is false and it is an item
    */
    @Test public void test_1ArgEffectItemConstructor_andGetters(){
	Item i=new Item(15);
	assertEquals(15,i.getEffect());
	assertEquals(false,i.getUse());
	assertEquals("item",i.getTypeOfPiece());
    }

    /**
       this tests the 1 Arg constructor for an int 
       the effect should be 10 and used is true and it is an item
    */
    @Test public void test_1ArgUseItemConstructor_andGetters(){
	Item i=new Item(true);
	assertEquals(10,i.getEffect());
	assertEquals(true,i.getUse());
	assertEquals("item",i.getTypeOfPiece());
    }
    
    /**
       this tests the default constructor. 
       the effect should be 10 and used is false and it is an item
    */
    @Test public void test_defaultItemConstructorSettersandGetters(){
	Item i=new Item();
	i.setUse(true);
	i.setTypeOfPiece("gameitem");
	i.setEffect(20);
	assertEquals(20,i.getEffect());
	assertEquals(true,i.getUse());
	assertEquals("gameitem",i.getTypeOfPiece());
    }
}
