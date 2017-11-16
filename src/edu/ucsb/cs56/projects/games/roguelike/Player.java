package edu.ucsb.cs56.projects.games.roguelike;


/**
 * A Player class that represents the character the player uses.
 * @author Minh Le
 * @author Hans Marasigan and Richard Nguyen
 * @version cs56 S13
 */

public class Player implements GamePiece {
//character hit points and attack
    private int hitPoints;
    private int attack;
    private int speed;
    private int[] playerPosition;
    private int score;
    private String typeOfPiece;
    private char icon;

    /**
     * creates a player with 100 hitPoints, 20 attack, and 1 speed
     */
    public Player() {
        this.hitPoints = 100;
        this.attack = 20;
        this.speed = 1;
        this.score = 0;
        this.setTypeOfPiece("player");
        this.setIcon('@');
    }

    /**
     * @return the player's hitPoints
     *
     */
    public int getHitPoints() {
        return this.hitPoints;
    }

    /**
       sets the player's speed
       @param speed this is the new value of the player's speed, can only be from 1 to 5
     */
    public void setSpeed(int speed) {
        if(speed >= 5) {
            this.speed = 5;
        } else if(speed <= 1) {
            this.speed = 1;
        } else
            this.speed = speed;
    }

    /**
     * @return the player's speed
     *
     */
    public int getSpeed() {
        return this.speed;
    }

    /**
     * @return the player's score
     *
     */
    public int getScore() {
        return this.score;
    }

    /**
       sets that player's attack
       @param atk this is the amount of points you want to set the player with
     */
    public void setAttack(int atk) {
        if(atk >= 100) {
            this.attack = 100;
        } else
            this.attack = atk;
    }

    /**
     * @return the player's attack
     *
     */
    public int getAttack() {
        return this.attack;
    }

    public int[] getPlayerPosition() {
        return playerPosition;
    }

    public void setPlayerPosition(int[] playerPosition) {
        this.playerPosition = playerPosition;
    }

    /**
     * sets the player's hitPoints
     * @param newHp the hitPoints that is to be set
     */
    public void setHitPoints(int newHp) {
        if(newHp >= 100) {
            this.hitPoints = 100;
        } else
            this.hitPoints = newHp;
    }

    /**
     * sets the player's Score
     * @param newScore is the score  that is to be set
     */
    public void setScore(int newScore) {
        this.score = newScore;
    }

    /**
     * a method for attacking monsters and incrementing player's score
     * @param mon the monster being attacked
     */
    public void attacking(Monster mon) {
        if(hitPoints > 0) {
            this.score += mon.getPointValue();
            mon.setHitPoints(mon.getHitPoints() - this.attack);
        }
    }

    /** this gets the type of piece of the object
     */
    public String getTypeOfPiece() {
        return this.typeOfPiece;
    }
    /**
       this sets the type of piece of the object
       @param newTypeOfPiece it is the new type of piece it will be.
     */

    public void setTypeOfPiece(String newTypeOfPiece) {
        this.typeOfPiece = newTypeOfPiece;
    }

    /**
       *This is the getter to figure out what piece icon it is.
     */
    public char getIcon() {
        return this.icon;
    }
    /**
       *This is the setter for the Icon it will be
       *@param NewIcon is the icon of piece that will be in the game
     */
    public void setIcon(char NewIcon) {
        this.icon = NewIcon;
    }

}
