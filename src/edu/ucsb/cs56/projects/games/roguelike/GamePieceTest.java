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

/**Tests my GamePiece Super Class
 *
 */
public class GamePieceTest{
    @Test
    /** tests for the default GamePiece which is nothing
     */
    public void test_defaultConstructor_and_Getters(){
	GamePiece gp=new GamePiece();
	assertEquals("nothing",gp.getTypeOfPiece());
    }	    
    @Test
        /** tests for the 1 arg constructor of GamePiece which is red
     */
    public void test_1ArgConstructor_and_GettersRed(){
	GamePiece gp=new GamePiece("red");
	assertEquals("red",gp.getTypeOfPiece());
    }
    @Test
    /** tests for the 1 arg constructor of GamePiece which is blue
     */
    public void test_1ArgConstructor_and_GettersBlue(){
	GamePiece gp=new GamePiece("blue");
	assertEquals("blue",gp.getTypeOfPiece());
    }
    @Test
    /** tests for the 1 arg constructor of GamePiece which is player
     */
    public void test_1ArgConstructor_and_GettersPlayer(){
	GamePiece gp=new GamePiece("player");
	assertEquals("player",gp.getTypeOfPiece());
    }
    @Test
        /** tests for the 1 arg constructor of GamePiece which is monster
     */
    public void test_1ArgConstructor_and_GettersMonster(){
	GamePiece gp=new GamePiece("monster");
	assertEquals("monster",gp.getTypeOfPiece());
    }
    @Test
    /** tests for the default GamePiece which is nothing and seeing if the setter works.
     *setting it to monster
     */
    public void test_defaultConstructor_and_setter(){
	GamePiece gp=new GamePiece();
	gp.setTypeOfPiece("monster");
	assertEquals("monster",gp.getTypeOfPiece());
    }
    @Test
    /** tests for the default GamePiece which is nothing and seeing if the setter works.
     *setting it to player
     */
    public void test_defaultConstructor_and_setterPlayer(){
	GamePiece gp=new GamePiece();
	gp.setTypeOfPiece("player");
	assertEquals("player",gp.getTypeOfPiece());
    }
    @Test
    /** tests for the 1 arg constructor of GamePiece which is monster
     *then setting it to player
     */
    public void test_1ArgConstructor_and_SetterPlayer(){
	GamePiece gp=new GamePiece("monster");
	gp.setTypeOfPiece("player");
	assertEquals("player",gp.getTypeOfPiece());
    }
    @Test
    /** tests for the 1 arg constructor of GamePiece which is player
     *then setting it to monster
     */
    public void test_1ArgConstructor_and_SetterMonster(){
	GamePiece gp=new GamePiece("player");
	gp.setTypeOfPiece("monster");
	assertEquals("monster",gp.getTypeOfPiece());
    }
}
