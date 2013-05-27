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
    
    /** tests for the default GamePiece which is nothing
     */
    public void test_defaultConstructor_and_Getters(){
	GamePiece gp=new GamePiece();
	assertEquals("nothing",gp.getTypeOfPiece());
    }	    
    
        /** tests for the 1 arg constructor of GamePiece which is red
     */
    public void test_1ArgConstructor_and_GettersRed(){
	GamePiece gp=new GamePiece("red");
	assertEquals("red",gp.getTypeOfPiece());
    }
    
    /** tests for the 1 arg constructor of GamePiece which is blue
     */
    public void test_1ArgConstructor_and_GettersBlue(){
	GamePiece gp=new GamePiece("blue");
	assertEquals("blue",gp.getTypeOfPiece());
    }
    
    /** tests for the 1 arg constructor of GamePiece which is player
     */
    public void test_1ArgConstructor_and_GettersPlayer(){
	GamePiece gp=new GamePiece("player");
	assertEquals("player",gp.getTypeOfPiece());
    }
    
        /** tests for the 1 arg constructor of GamePiece which is monster
     */
    public void test_1ArgConstructor_and_GettersMonster(){
	GamePiece gp=new GamePiece("monster");
	assertEquals("monster",gp.getTypeOfPiece());
    }
    
    /** tests for the default GamePiece which is nothing and seeing if the setter works.
     *setting it to monster
     */
    public void test_defaultConstructor_and_setter(){
	GamePiece gp=new GamePiece();
	gp.setTypeOfPiece("monster");
	assertEquals("monster",gp.getTypeOfPiece());
    }
    
    /** tests for the default GamePiece which is nothing and seeing if the setter works.
     *setting it to player
     */
    public void test_defaultConstructor_and_setterPlayer(){
	GamePiece gp=new GamePiece();
	gp.setTypeOfPiece("player");
	assertEquals("player",gp.getTypeOfPiece());
    }
    
    /** tests for the 1 arg constructor of GamePiece which is monster
     *then setting it to player
     */
    public void test_1ArgConstructor_and_SetterPlayer(){
	GamePiece gp=new GamePiece("monster");
	gp.setTypeOfPiece("player");
	assertEquals("player",gp.getTypeOfPiece());
    }
    
    /** tests for the 1 arg constructor of GamePiece which is player
     *then setting it to monster
     */
    public void test_1ArgConstructor_and_SetterMonster(){
	GamePiece gp=new GamePiece("player");
	gp.setTypeOfPiece("monster");
	assertEquals("monster",gp.getTypeOfPiece());
    }
    
    /** this tests that the monster constructor works and the type should be monster
     */
    public void test_defaultMonsterType_Constructor(){
	Monster m=new Monster();
	assertEquals("Monster",m.getTypeOfPiece());
    }
    
    /** this tests that the player constructor works and the type should be player
     */
    public void test_defaultPlayerType_Constructor(){
	Player p=new Player();
	assertEquals("Player",p.getTypeOfPiece());
    }
    
    /** this test that the Bat constructor works and is a Monster type
     */
        public void test_defaulBatType_Constructor(){
	Bat b=new Bat();
	assertEquals("Monster",b.getTypeOfPiece());
    }
    
    /** this test that the Golem constructor works and is a Monster type
     */
    public void test_defaultGolemType_Constructor(){
	Golem g=new Golem();
	assertEquals("Monster",g.getTypeOfPiece());
    }
    
    /** this test that the Troll constructor works and is a Monster type
     */
        public void test_defaultTrollType_Constructor(){
	Troll t=new Troll();
	assertEquals("Monster",t.getTypeOfPiece());
    }
    
    /**tests the monsters 3arg Constructor to see if it is still a Monster Type
     */
    public void test_3ArgConstructorMonster(){
	Monster m=new Monster(1,2,0);
	assertEquals("Monster",m.getTypeOfPiece());
    }
    
    /**tests the Bat 3arg Constructor to see if it is still a Monster Type
     */
    public void test_3ArgConstructorBat(){
	Bat m=new Bat(1,2,0);
	assertEquals("Monster",m.getTypeOfPiece());
    }
    
    /**tests the Golem 3arg Constructor to see if it is still a Monster Type
     */
    public void test_3ArgConstructorGolem(){
	Golem m=new Golem(1,2,0);
	assertEquals("Monster",m.getTypeOfPiece());
    }
    
    /**tests the Troll 3arg Constructor to see if it is still a Monster Type
     */
    public void test_3ArgConstructorTroll(){
	Troll m=new Troll(1,2,0);
	assertEquals("Monster",m.getTypeOfPiece());
    }
    
    /**tests the Monster 4arg Constructor to see if it is still a Monster Type
     */
    public void test_4argConstructorMonsterType(){
	Monster b=new Monster(1,2,0,3);
    }
    
    /**tests the Bat 4arg Constructor to see if it is still a Monster Type
     */
    public void test_4argConstructorBatType(){
	Bat b=new Bat(1,2,0,3);
    }
    
    /**tests the Golem 4arg Constructor to see if it is still a Monster Type
     */
    public void test_4argConstructorGolemType(){
	Golem b=new Golem(1,2,0,3);
    }
    
    /**tests the Monster 4arg Constructor to see if it is still a Monster Type
     */
    public void test_4argConstructorTrollType(){
	Troll b=new Troll(1,2,0,3);
    }


}
