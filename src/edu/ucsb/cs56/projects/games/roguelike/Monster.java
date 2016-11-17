package edu.ucsb.cs56.projects.games.roguelike;

import java.util.Random;

/**
 * A Monster class to represents monster in the game
 * @author Minh Le 
 *@author Hans Marasigan & Richard Nguyen
 *@version cs56 s13
 */
public class Monster implements GamePiece{
	private int hitPoints;
	private int attack;
	private int direction = 0;
	private int typeOfMovement;
	private int[] position = new int[2];
        private int pointValue=5;
    private char icon;

    // Default attributes for monsters
    public static final int[] BAT = {5,1,10,66};
    public static final int[] GOLEM = {25,5,30,71};
    public static final int[] MONSTER = {20,10,5,77};
    public static final int[] PIRATE = {15,4,20,80};
    public static final int[] SNAKE = {5,3,15,83};
    public static final int[] TROLL = {10,3,15,84};
    public static final int[] ZOMBIE = {15,2,15,90};
    
	/**
	 * creates a monster with 20 hitPoints and 10 attack and  no random movement
	 * 
	 */
	public Monster(){
	    this.setHitPoints(MONSTER[0]);
	    this.setAttack(MONSTER[1]);
	    this.setPointValue(MONSTER[2]);
	    char[] iconArray = Character.toChars(MONSTER[3]);
	    char iconChar = iconArray[0];
	    this.setIcon(iconChar);
	    this.typeOfMovement=0;
	}
	/**
	 * creates a player with 20 hitPoints and 10 attack
	 * @param typeOfMovement whether or not the monster will move randomly or not
	 */
    public Monster(int typeOfMovement, int[] typeOfMonster){
	this.setHitPoints(typeOfMonster[0]);
	this.setAttack(typeOfMonster[1]);
	this.setPointValue(typeOfMonster[2]);
        char[] iconArray = Character.toChars(typeOfMonster[3]);
	char iconChar = iconArray[0];
	this.setIcon(iconChar);
	this.typeOfMovement=typeOfMovement;
	}

    /**
     * @return the monster's hitPoints
     * 
     */
    public int getHitPoints(){
	return this.hitPoints;
    }
    /**
     * sets the hitPoints of the monster
     * @param newHp is the new hp for the monster
     */
    public void setHitPoints(int newHp){
	this.hitPoints = newHp;
    }
    /**
     *sets the attack of the monster
     *@param attack the attack points of the monster
     */  
    public void setAttack(int attack){
	this.attack=attack;
    }
    /**
     * @return the monster's attack
     * 
     */
    public int getAttack(){
		return this.attack;
    }

    /**
     * get the point value of the Monster
     */
    public int getPointValue(){
	return this.pointValue;
	
    }
    /**
     * sets the pointValue of the Monster
     * @param pointValue number of points for killing the bat.
     */
    public void setPointValue(int pointValue){
	this.pointValue=pointValue;
	
    }

    /** 
     *This is the getter to figure out what piece icon it is. 
     */ 
    public char getIcon(){
	return this.icon;
    }
    /** 
     *This is the setter for the Icon it will be 
     *@param NewIcon is the icon of piece that will be in the game 
     */ public void setIcon(char NewIcon){
	 this.icon=NewIcon;

     }	
	
    /**
       a method that boosts stats on Monster for each level
       i.e. the higher the level, the tougher the enemy
       @param level the current level the player is on
    */
    public void setLevelBonus(int level){
	this.hitPoints = this.hitPoints + ( (level*5) - 5 );   //HP of monster is increased by 5 for each level
	if(level%3 == 0)
	    this.attack = this.attack + ( (level) - 1 );    //Attack power of monster increases by 1 every 3 levels

	//More bonuses goes here

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
	 *  chooses what direction the monster moves in
	 * @return a vector that represents the direction
	 */
	
	public int[] getDirection(int[] playerPosition){
	
		int[] vector= new int[2];
		Random directionGenerator = new Random();
		

		switch(typeOfMovement){
		case 0	:		direction++;
						if(direction==4){
							direction=0;
						}
						break;
						
		case 1	:		direction = directionGenerator.nextInt(4);
						break;
						
		case 2 	:		int randomer = directionGenerator.nextInt(3);
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
		case 0	    :	vector[0]=1; break;
		case 1	    :  	vector[1]=-1; break;
		case 2	    :	vector[0]=-1; break;
		case 3		:	vector[1]=1; break;
		default		:	break;
		}

		return vector;
	}
}
