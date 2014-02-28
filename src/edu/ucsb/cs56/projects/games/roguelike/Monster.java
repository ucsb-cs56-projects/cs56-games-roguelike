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
	private String typeOfPiece;
    private char icon;
	/**
	 * creates a monster with 20 hitPoints and 10 attack and  no random movement
	 * 
	 */
	public Monster(){
	    this.hitPoints=20;
	    this.attack=10;
	    this.typeOfMovement=0;
	    this.setTypeOfPiece("monster");
	    this.setIcon('M');
	}
	/**
	 * creates a player with 20 hitPoints and 10 attack
	 * @param randomMovement whether or not the monster will move randomly or not
	 */
	public Monster(int typeOfMovement){
	    this.hitPoints = 20;
	    this.attack=10;
	    this.typeOfMovement=typeOfMovement;
	    this.setTypeOfPiece("monster");
	    this.setIcon('M');
	}
	/**
	 * creates a player with 20 hitPoints and 10 attack
	 * @param hitPoints the monster's hitPoints
	 * @param attack the monster's attack
	 * @param randomMovement whether or not the monster will move randomly or not
	 */
	public Monster(int hitPoints, int attack, int typeOfMovement){
		this.hitPoints = hitPoints;
		this.attack = attack;
		this.typeOfMovement = typeOfMovement;
		this.setTypeOfPiece("monster");
		this.setIcon('M');
	}
    /**
     *creates a monster with the makers preference of status
     *@param hp, hit points of the monster
     *@param att, the attack power of the monster
     *@param typeOfMovement determines whether it is random or not
     *@param points, determines how many points it is.
     */
    public Monster (int hp, int att, int typeOfMovement,int points){
		this.hitPoints = hp;
		this.attack = att;
		this.typeOfMovement = typeOfMovement;
		this.pointValue=points;
		this.setTypeOfPiece("monster");
		this.setIcon('M');
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
       this gets the type of piece of the monster
    */
	public String getTypeOfPiece(){
		return this.typeOfPiece;
	}
    /**
       this sets the type of piece of the monster
    */
	public void setTypeOfPiece(String newTypeOfPiece){
		this.typeOfPiece=newTypeOfPiece;
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
    public void levelBonus(int level){
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
