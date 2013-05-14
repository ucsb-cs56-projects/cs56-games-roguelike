package edu.ucsb.cs56.projects.games.roguelike;

import java.util.Random;

/**
 *@author Hans Marasigan & Richard Nguyen
 *@version cs56 Spring 13
 *
 */

public class Golem{ 
    private int hitPoints;
    private int attack;
    private int direction = 0;
    private int typeOfMovement;
    private int[] position = new int[2];
    private int pointValue=20;

    /**
     *creates a Golem with 50 hitPoints and 20 attack with no random movement
     *
     */
    public Golem(){
	this (50,20,0);    
    }
    /**
     * creates a Golem with 50 HP and 20 attack
     * @ param randomMovement whether or not the Golem will move randomly
     */
    public Golem(int typeOfMovement){
	this(50,20,typeOfMovement);
    }
    
    /**
     * creates a Golem with hit points, attack, and random movement
     * @param hitPoints the Golem's hitPoints
     * @param attack the Golem's attack
     * @param randomMovement whether or not the Golem will move randomly or not
     */
    public Golem(int hitPoints, int attack, int typeOfMovement){
	this.hitPoints = hitPoints;
	this.attack = attack;
	this.typeOfMovement = typeOfMovement;
    }
    /**
     * @return the Golem's hitPoints
     * 
     */
    public int getHitPoints(){
	//return this.hitPoints;
	return -42; //@@stub
    }

    /**
     * @return the Golem's attack
     * 
     */
    public int getAttack(){
	//return this.attack;
	return -42; //@@stub
    }

    /** 
     * sets the hitPoints of the Golem
     * @param newHp is the new hp for the Golem
     */
    public void setHitPoints(int newHp){
	//this.hitPoints = newHp;
	this.hitPoints=-42; //@@stub

    }
    /**
     * gets the point value of the Golem
     */
    	
    public int getPointValue(){
    //return this.pointValue;
    return -42;
    }
    /**
	* sets the pointValue of the Golem
	* @param pointValue number of points for killing the Golem.
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
     *  chooses what direction the Golem moves in
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

