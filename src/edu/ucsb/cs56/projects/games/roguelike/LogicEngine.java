package edu.ucsb.cs56.projects.games.roguelike;

import java.util.Random;

/**
 * LogicEngine takes care of game states
 * @author Minh Le
 * @author Hans Marasigan & Richard Nguyen
 */
public class LogicEngine {
    //list of all the monsters
    private Monster[][] listOfMonsters;
    //the player the user uses
    private Player thePlayer;
    //all the cells that all object in the game can move in
    private Object[][] floor;
    private int floorWidth;
    private int floorHeight;
    private int[] playerPosition;
    private boolean gameOver ;
	

	
	
	/**
	 * creates the logic engine which takes care of game state, intialize with a floor that is 80 by 24
	 * 
	 */
	public LogicEngine(){
		this(80,24);
	}
	
	/**
	 * creates the logic engine which takes care of game state
	 * @param width the width of the floor
	 * @param height the height of the floor
	 */
	public LogicEngine(int width, int height){
		floorWidth = width;
		floorHeight = height;
		floor = new Object[floorWidth][floorHeight];
		listOfMonsters = new Monster[floorWidth][floorHeight];
		createAllObjects();
		storeMonsters();
		int[] position = {40,12};
		thePlayer.setPlayerPosition(position);
		gameOver= false; 
	}
    
    /**
     * setter for boolean gameOver
     *
     */
    public void setGameOver(boolean a){
	this.gameOver = a;
    }
    
    /**
     * getter for boolean gameOver
     *
     */
    public boolean getGameOver(){
	return gameOver;
    }
	/**
	 * @return the list of monsters
	 * 
	 */
	public Monster[][] getMonsters(){

	      return listOfMonsters;
	}
	
	/**
	 * @param x the x position of the object
	 * @param y the y position of the object
	 * @return the object at the position x and y
	 */
	public Object getObject(int x, int y){

	      return floor[x][y];
	}
	
	public Object[][] getFloor(){
		return floor;
	}
	
	/**
	 * @return the player
	 * 
	 */
	public Player getPlayer(){
		return thePlayer;
	}
	
	public int[] getPlayerPosition(){
		return thePlayer.getPlayerPosition();
	}
	

	
	/**
	 * x and y are the position thats being tested
	 * xOrig and yOrig are the position of the object now
	 * @param x is the x position of the position being tested
	 * @param y is the y position of the position being tested
	 * @param xOrig is the x position of the object right now
	 * @param yOrig is the y position of the object right now
	 * @return true if its movable, false if not
	 */
	public boolean movable(int x,int y,int xOrig, int yOrig){
	    if(thePlayer.getHitPoints() <= 0){
		return false;
	    }
		/* not movable, out of boundary*/
	    if (x < 1 || x >= floorWidth-1){
		return false;
        }
		
	    if (y < 1 || y >= floorHeight-1){
        	return false;
        }
        
		
		
		//player isn't movable, start attack for player
	    if(floor[x][y] instanceof Monster){
			if(floor[xOrig][yOrig]instanceof Player){
			    thePlayer.attacking(listOfMonsters[x][y]);
				return false;
			}else{
				return false;
			}
		}
				
		//monster isn't movable, start attack for monster
		if(floor[x][y] instanceof Player && floor[xOrig][yOrig] instanceof Monster){
		    listOfMonsters[xOrig][yOrig].attacking(thePlayer);
			return false;
		}
		

		// monster or player is movable	

		floor[x][y] = floor[xOrig][yOrig];
		floor[xOrig][yOrig] = null;

		int[] position = {x,y};
        if(floor[x][y] instanceof Player){
        	thePlayer.setPlayerPosition(position);
        }
		return true;
	}
	
	/**
	 * check if the monster at position x,y has 0 or less hp
	 * @param x is the x position of the position being tested
	 * @param y is the y position of the position being tested
	 * @return if monster is dead at x and y return true else false
	 */
	public boolean monsterIsDead(int x,int y){
		
		if(listOfMonsters[x][y]!=null && listOfMonsters[x][y].getHitPoints()<=0){			
				floor[x][y] = null;
				listOfMonsters[x][y] = null;
				return true;
		}
		return false;
	}
	
	/**
	 * check if the player has 0 or less hp
	 * @return if monster is dead at x and y return true else false
	 */
	public boolean playerIsDead(){
		if(thePlayer.getHitPoints()<=0){
			return true;
		}
		
		return false;
	}
	

	/**
	 * update the monster list based on the objects in floor
	 */
	public void storeMonsters(){
		
	      for (int x = 0; x < floorWidth; x++) {  
	          for (int y = 0; y < floorHeight; y++) {  
	        	  if(floor[x][y] instanceof Monster){	
			      listOfMonsters[x][y] = (Monster) floor[x][y];
			      //listOfMonsters[x][y] =Monster floor[x][y];
	        		  listOfMonsters[x][y].setMonsterPosition(x,y);
	        	  }else{
	        		  listOfMonsters[x][y] = null; 
	        	  }
	          }
	      }
	}
	
	/**
	 * creates all the monsters and player in the game
	 */
	public void createAllObjects(){
		
		 for (int x = 0; x < floorWidth; x++) {
	          for (int y = 0; y < floorHeight; y++) {
	        	  floor[x][y] = null;
	          }
		 }
		 
		 thePlayer = new Player();
		 floor[40][12] = thePlayer;
		 
		 Random numGenerator = new Random();
		 
		 int x = 0;
		 while(x < 8){
			 int xPos = numGenerator.nextInt(79);
			 int yPos = numGenerator.nextInt(23);
			 if(floor[xPos][yPos]==null){
			     if (x<2){
				 floor[xPos][yPos] = new Monster(numGenerator.nextInt(2)+1);
				 x++;
			     }
			     if (x<4){
				 floor[xPos][yPos] = new Troll(numGenerator.nextInt(2)+1);
				 x++;
			     }
			     if (x<6){
				 floor[xPos][yPos] = new Golem(numGenerator.nextInt(2)+1);
				 x++;
			     }
			     if (x<8)
				 floor[xPos][yPos] = new Bat(numGenerator.nextInt(2)+1);
				 x++;
			 }
		 }

		 
	}
	
	public void createMonster(){
		 Random numGenerator = new Random();
		 
		 int x = 0;
		 while(true){
			 int xPos = numGenerator.nextInt(70);
			 int yPos = numGenerator.nextInt(20);
			 if(floor[xPos][yPos]==null){
			     floor[xPos][yPos] = new Monster(numGenerator.nextInt(2)+1);
			     listOfMonsters[xPos][yPos] = (Monster) floor[xPos][yPos];		      
			     listOfMonsters[xPos][yPos].setMonsterPosition(xPos,yPos);
			     break;
			 }
		 }
	}
	
}
