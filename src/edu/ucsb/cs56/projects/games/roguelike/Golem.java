package edu.ucsb.cs56.S12.choice.issue842;

import java.util.Random;

/**
 *@author Hans Marasigan & Richard Nguyen
 *@version cs56 Spring 13
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

        public Golem(int hp,int att,int typeOfMove, int points){
	super(hp,att,typeOfMove,points);

    }
}
