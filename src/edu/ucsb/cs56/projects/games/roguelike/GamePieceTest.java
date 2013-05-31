package edu.ucsb.cs56.projects.games.roguelike;


import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

/** test class for my super class 
    @author Hans Marasigan & Richard Nguyen
    @version cs56 S13
    @see GamePiece
*/


public class GamePieceTest{
    
    /** this tests that the monster constructor works and the type should be monster
     */
    @Test public void test_defaultMonsterType_Constructor(){
	Monster m=new Monster();
	assertEquals("monster",m.getTypeOfPiece());
    }
    
    /** this tests that the player constructor works and the type should be player
     */
    @Test public void test_defaultPlayerType_Constructor(){
	Player p=new Player();
	assertEquals("player",p.getTypeOfPiece());
    }
    
    /** this test that the Bat constructor works and is a Monster type
     */
    @Test public void test_defaulBatType_Constructor(){
	Bat b=new Bat();
	assertEquals("monster",b.getTypeOfPiece());
    }
    
    /** this test that the Golem constructor works and is a Monster type
     */
    @Test public void test_defaultGolemType_Constructor(){
	Golem g=new Golem();
	assertEquals("monster",g.getTypeOfPiece());
    }
    
    /** this test that the Troll constructor works and is a Monster type
     */
    @Test public void test_defaultTrollType_Constructor(){
	Troll t=new Troll();
	assertEquals("monster",t.getTypeOfPiece());
    }
    
    /**tests the monsters 3arg Constructor to see if it is still a Monster Type
     */
    @Test public void test_3ArgConstructorMonster(){
	Monster m=new Monster(1,2,0);
	assertEquals("monster",m.getTypeOfPiece());
    }
    
    /**tests the Bat 3arg Constructor to see if it is still a Monster Type
     */
    @Test public void test_3ArgConstructorBat(){
	Bat m=new Bat(1,2,0);
	assertEquals("monster",m.getTypeOfPiece());
    }
    
    /**tests the Golem 3arg Constructor to see if it is still a Monster Type
     */
    @Test public void test_3ArgConstructorGolem(){
	Golem m=new Golem(1,2,0);
	assertEquals("monster",m.getTypeOfPiece());
    }
    
    /**tests the Troll 3arg Constructor to see if it is still a Monster Type
     */
    @Test public void test_3ArgConstructorTroll(){
	Troll m=new Troll(1,2,0);
	assertEquals("monster",m.getTypeOfPiece());
    }
    
    /**tests the Monster 4arg Constructor to see if it is still a Monster Type
     */
    @Test public void test_4argConstructorMonsterType(){
	Monster b=new Monster(1,2,0,3);
	assertEquals("monster",b.getTypeOfPiece());
	
    }
    
    /**tests the Bat 4arg Constructor to see if it is still a Monster Type
     */
    @Test public void test_4argConstructorBatType(){
	Bat b=new Bat(1,2,0,3);
	assertEquals("monster",b.getTypeOfPiece());
    }
    
    /**tests the Golem 4arg Constructor to see if it is still a Monster Type
     */
    @Test public void test_4argConstructorGolemType(){
	Golem b=new Golem(1,2,0,3);
	assertEquals("monster",b.getTypeOfPiece());
    }
    
    /**tests the Monster 4arg Constructor to see if it is still a Monster Type
     */
    @Test public void test_4argConstructorTrollType(){
	Troll b=new Troll(1,2,0,3);
	assertEquals("monster",b.getTypeOfPiece());
    }


}
