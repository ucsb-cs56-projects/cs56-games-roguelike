package edu.ucsb.cs56.S12.choice.issue842;


/**
 * A Player character class which the user uses
 * @author Minh Le 
 *
 */
public class Player {
	//character hit points and attack
    private int hitPoints;
    private int attack;
    private int[] playerPosition;
    private int score;
    /**
     * creates a player with 100 hitPoints and 20 attack
     */
    public Player(){
	this.hitPoints = 50;
	this.attack = 20;
	this.score= 0;
    }
    
    /**
     * @return the player's hitPoints
     * 
     */
    public int getHitPoints(){
	return this.hitPoints;
    }
     /**
      * @return the player's score
     * 
     */
    public int getScore(){
	return this.score;
    }
    
    /**
     * @return the player's attack
     * 
     */
    public int getAttack(){
	return this.attack;
    }
    
    public int[] getPlayerPosition(){
	return playerPosition;
    }
    
    public void setPlayerPosition(int[] playerPosition){
	this.playerPosition = playerPosition;
    }
    
    /**
     * sets the player's hitPoints
     * @param newHp the hitPoints that is to be set
     */
    public void setHitPoints(int newHp){
	this.hitPoints = newHp;
    }
     
    /**
     * sets the player's Score
     * @param newScore is the score  that is to be set
     */
    public void setScore(int  newScore){
	this.score = newScore;
    }
    
    /**
     * a method for attacking monsters
     * @param mon the monster being attacked
     */
    public void attacking(Monster mon){
	mon.setHitPoints(mon.getHitPoints()-this.attack);
	this.score+=20;
    }
	
    
    
}
