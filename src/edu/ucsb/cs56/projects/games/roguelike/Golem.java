package edu.ucsb.cs56.projects.games.roguelike;

import java.util.Random;

/**
 *@author Hans Marasigan & Richard Nguyen
 *@version cs56 Spring 13
 */
/**
 *This is a monster called a golem that is very healthy with a ton of attack.
 */

public class Golem extends Monster{ 

    /**
     *creates a Golem with 50 hitPoints and 20 attack with no random movement
     *
     */
    public Golem(){
	super(50,20,0,20);    
    }
    /**
     * creates a Golem with 50 HP and 20 attack
     * @ param randomMovement whether or not the Golem will move randomly
     */
    public Golem(int typeOfMovement){
	super(50,20,typeOfMovement,20);
    }
    
    /**
     * creates a Golem with hit points, attack, and random movement
     * @param hitPoints the Golem's hitPoints
     * @param attack the Golem's attack
     * @param randomMovement whether or not the Golem will move randomly or not
     */
    public Golem(int hitPoints, int attack, int typeOfMovement){
	super(hitPoints,attack,typeOfMovement,20);
    }
    /**
     *creates a Golem to the parameters given to it
     * @param hp the Golem's hitPoints
     * @param att the Golem's attack
     * @param typeOfMove whether or not the Golem will move randomly or not
     * @param points the amount of points the Golem is worth
     */
        public Golem(int hp,int att,int typeOfMove, int points){
	super(hp,att,typeOfMove,points);

    }
}
