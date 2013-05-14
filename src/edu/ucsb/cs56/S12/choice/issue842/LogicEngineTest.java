package edu.ucsb.cs56.projects.games.roguelike;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * The test class LogicEngineTest, to test the LogicEngine class
 *
 * @author  Minh Le
 * @see LogicEngine
 */

public class LogicEngineTest
{
	
    /**
       test to see if a player can move to a spot with a monster
       @see LogicEngine#movable()

     */
   @Test public void testMovable()
    {
	
        LogicEngine engine = new LogicEngine();

        assertEquals(false,engine.movable(5,3,40,12));
    }   
    /**
       test to see if a monster can move to a spot with a player
       @see LogicEngine#movable()

     */
   @Test public void testMovable2()
    {
	
        LogicEngine engine = new LogicEngine();

        assertEquals(false,engine.movable(40,12,5,3));
    }   
	
    /**
       test to see if a monster/player can move to a spot that is empty
       @see LogicEngine#movable()

     */
   @Test public void testMovable3()
    {
	
        LogicEngine engine = new LogicEngine();

        assertEquals(true,engine.movable(10,15,40,12));
    }   

    /**
       test to see if a monster/player can move to a spot that is out of bound
       @see LogicEngine#movable()

     */
   @Test public void testMovable4()
    {
	
        LogicEngine engine = new LogicEngine();

        assertEquals(false,engine.movable(0,3,40,12));
    }   
    /**
       test to see if a monster/player can move to a spot that is out of bound
       @see LogicEngine#movable()

     */
   @Test public void testMovable5()
    {
	
        LogicEngine engine = new LogicEngine();

        assertEquals(false,engine.movable(79,3,40,12));
    }   
    /**
       test to see if a monster/player can move to a spot that is out of bound
       @see LogicEngine#movable()

     */
   @Test public void testMovable6()
    {
	
        LogicEngine engine = new LogicEngine();

        assertEquals(false,engine.movable(6,0,40,12));
    } 
      /**
       test to see if a monster/player can move to a spot that is out of bound
       @see LogicEngine#movable()

     */
   @Test public void testMovable7()
    {
	
        LogicEngine engine = new LogicEngine();

        assertEquals(false,engine.movable(6,23,40,12));
    }   

    /**
       test for a dead player
       @see LogicEngine#playerIsDead()

     */
   @Test public void testPlayerStatus()
    {
	
        LogicEngine engine = new LogicEngine();
	engine.getPlayer().setHitPoints(0);
        assertEquals(true,engine.playerIsDead());
    }

    /**
       test for a player that isnt dead
       @see LogicEngine#playerIsDead()

     */
   @Test public void testPlayerStatus2()
    {
	
        LogicEngine engine = new LogicEngine();
	engine.getPlayer().setHitPoints(20);
        assertEquals(false,engine.playerIsDead());
    }

    /**
       test for a monster that is dead
       @see LogicEngine#monsterIsDead()

     */
   @Test public void testMonsterStatus()
    {
	
        LogicEngine engine = new LogicEngine();
	Monster[][] mList = engine.getMonsters();
	mList[5][3].setHitPoints(0);
        assertEquals(true,engine.monsterIsDead(5,3));
    }

    /**
       test for a monster that isnt dead
       @see LogicEngine#monsterIsDead()

     */
   @Test public void testMonsterStatus2()
    {
	
        LogicEngine engine = new LogicEngine();
	Monster[][] mList = engine.getMonsters();
	mList[5][3].setHitPoints(20);
        assertEquals(false,engine.monsterIsDead(5,3));
    }
  

} 
    

