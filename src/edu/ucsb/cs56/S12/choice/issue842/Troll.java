package edu.ucsb.cs56.S12.choice.issue842;

import java.util.Random;

/**
 *@author Hans Marasigan & Richard Nguyen
 *@version cs56 Spring 13
 *
 */

public class Troll{ 
    private int hitPoints;
    private int attack;
    private int direction = 0;
    private int typeOfMovement;
    private int[] position = new int[2];
    private int pointValue=15;

    /**
     *creates a troll with 15 hitPoints and 10 attack with no random movement
     *
     */
    public Troll(){
	this (15,10,0);    
    }
    /**
     * creates a troll with 15 HP and 10 attack
     * @ param randomMovement whether or not the monster will move randomly
     */
    public Troll(int typeOfMovement){
	this(15,10,typeOfMovement);
    }
    
    /**
     * creates a troll with hit points, attack, and random movement
     * @param hitPoints the Troll's hitPoints
     * @param attack the Trolls's attack
     * @param randomMovement whether or not the Troll will move randomly or not
     */
    public Troll(int hitPoints, int attack, int typeOfMovement){
	this.hitPoints = hitPoints;
	this.attack = attack;
	this.typeOfMovement = typeOfMovement;
    }
    /**
     * @return the Trolls's hitPoints
     * 
     */
    public int getHitPoints(){
	//return this.hitPoints;
	return -42; //@@stub
    }

    /**
     * @return the Trolls's attack
     * 
     */
    public int getAttack(){
	//return this.attack;
	return -42; //@@stub
    }

    /** 
     * sets the hitPoints of the Trolls
     * @param newHp is the new hp for the Trolls
     */
    public void setHitPoints(int newHp){
	//this.hitPoints = newHp;
	this.hitPoints=-42; //@@stub
	
    }
        /**
	* gets the point value of the Troll
	*/
    
    public int getPointValue(){
    //return this.pointValue;
    return -42;
    }
    /**
	* sets the pointValue of the Troll.
	* @param pointValue number of points for killing the Troll.
	*/
     
    public void setPointValue(int pointValue){
     //this.pointValue=pointValue;
     this.pointValue=-42;
    }

    /**
     * a method for attacking the player
     * @param mainChar the player being attacked
     */
    public void attacking(Player mainChar){
	mainChar.setHitPoints(mainChar.getHitPoints()-this.attack);
    }

    public void setMonsterPosition(int x, int y){
	this.position[0] = x;
	this.position[1] = y;
    }
    /**
     *  chooses what direction the Troll moves in
     * @return a vector that represents the direction
     */

    public int[] getDirection(int[] playerPosition){

	int[] vector= new int[2];
	Random directionGenerator = new Random();


	switch(typeOfMovement){
	case 0:direction++;
	    if(direction==4){
		direction=0;
	    }
	    break;

	case 1:direction = directionGenerator.nextInt(4);
	    break;

	case 2 :int randomer = directionGenerator.nextInt(3);
	    if((position[0] - playerPosition[0] == 0)){
		if(position[1]-playerPosition[1] > 0){
		    if(randomer == 0){
			direction = 1;
		    }else if(randomer == 1){
			direction = 0;
		    }else if(randomer == 2){
			direction = 2;
		    }
		}else{
		    if(randomer == 0){
			direction = 3;
		    }else if(randomer == 1){
			direction = 0;
		    }else if(randomer == 2){
			direction = 2;
		    }
		}
	    }else if((position[1] - playerPosition[1] == 0)){
		if(position[0]-playerPosition[0] > 0){
		    if(randomer == 0){
			direction = 2;
		    }else if(randomer == 1){
			direction = 1;
		    }else if(randomer == 2){
			direction = 3;
		    }
		}else{
		    if(randomer == 0){
			direction = 0;
		    }else if(randomer == 1){
			direction = 1;
		    }else if(randomer == 2){
			direction = 3;
		    }
		}
	    }else if((position[0] - playerPosition[0] > 0) && (position[1]-playerPosition[1] > 0)){
		if(directionGenerator.nextInt(2) == 1){
		    direction = 1;
		}else{
		    direction = 2;
		}
	    }else if((position[0] - playerPosition[0] > 0) && (position[1]-playerPosition[1] < 0)){
		if(directionGenerator.nextInt(2) == 1){
		    direction = 3;
		}else{
		    direction = 2;
		}

	    }else if((position[0] - playerPosition[0] < 0) && (position[1]-playerPosition[1] > 0)){
		if(directionGenerator.nextInt(2) == 1){
		    direction = 1;
		}else{
		    direction = 0;
		}

	    }else if((position[0] - playerPosition[0] < 0) && (position[1]-playerPosition[1] < 0)){
		if(directionGenerator.nextInt(2) == 1){
		    direction = 3;
		}else{
		    direction = 0;
		}

	    }


	}






	switch (direction){
	case 0    :vector[0]=1; break;
	case 1    :  vector[1]=-1; break;
	case 2    :vector[0]=-1; break;
	case 3:vector[1]=1; break;
	default:break;
	}


	return vector;
    }


}


