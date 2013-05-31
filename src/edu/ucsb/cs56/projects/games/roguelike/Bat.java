package edu.ucsb.cs56.projects.games.roguelike;

import java.util.Random;

/**
 *@author Hans Marasigan & Richard Nguyen
 *@version cs56 Spring 13
 */

/**
 *This class represents a class of monster called a Bat which is a weak melee monster.
 */

public class Bat extends Monster{ 

    /**
     *creates a Bat with 10 hitPoints and 10 attack with no random movement
     *
     */
    public Bat(){
	super(10,10,0,10);    
    }
    /**
     * creates a Bat with 10 HP and 10 attack
     * @ param randomMovement whether or not the bat will move randomly
     */
    public Bat(int typeOfMovement){
	super(10,10,typeOfMovement,10);
    }
    
    /**
     * creates a Bat with hit points, attack, and random movement
     * @param hitPoints the Bat's hitPoints
     * @param attack the Bat's attack
     * @param typeOfMovement whether or not the Bat will move randomly or not
     */
    public Bat(int hitPoints, int attack, int typeOfMovement){
	super(hitPoints,attack,typeOfMovement,10);
    }
    /**
     *creates a Bat to the parameters given to it
     * @param hp the Bat's hitPoints
     * @param att the Bat's attack
     * @param typeOfMove whether or not the Bat will move randomly or not
     * @param points the amount of points the Bat is worth
     */
    public Bat(int hp,int att,int typeOfMove, int points){
	super(hp,att,typeOfMove,points);
    }
}
