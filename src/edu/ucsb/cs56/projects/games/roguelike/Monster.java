package edu.ucsb.cs56.projects.games.roguelike;

import java.util.Random;

/**
 * A Monster class to represents monster in the game
 * @author Minh Le
 *@author Hans Marasigan and Richard Nguyen
 *@version cs56 s13
 */
public class Monster implements GamePiece {
    private int hitPoints;
    private int attack;
    private int direction = 0;
    private int typeOfMovement;
    private int[] position = new int[2];
    private int pointValue = 5;
    private char icon;

    // Default attributes for monsters. To add a new monster, add a new array with the values for hitPoints, attack, pointValue, and icon
    public static final int[] BAT = {5, 1, 10, 66};
    public static final int[] GOLEM = {25, 5, 30, 71};
    public static final int[] MONSTER = {20, 10, 5, 77};
    public static final int[] PIRATE = {15, 4, 20, 80};
    public static final int[] SNAKE = {5, 3, 15, 83};
    public static final int[] TROLL = {10, 3, 15, 84};
    public static final int[] ZOMBIE = {15, 2, 15, 90};

    /**
     * Creates a monster with 20 hitPoints and 10 attack and no random movement.
     */
    public Monster() {
        this.setHitPoints(MONSTER[0]);
        this.setAttack(MONSTER[1]);
        this.setPointValue(MONSTER[2]);
        char[] iconArray = Character.toChars(MONSTER[3]);
        char iconChar = iconArray[0];
        this.setIcon(iconChar);
        this.typeOfMovement = 0;
    }
    /**
     * Creates a monster with 20 hitPoints and 10 attack.
     * @param typeOfMovement whether or not the monster will move randomly or not.
     * @param typeOfMonster integer array containing monster's stats.
     */
    public Monster(int typeOfMovement, int[] typeOfMonster) {
        this(typeOfMovement, typeOfMonster[0], typeOfMonster[1],
             typeOfMonster[2], Character.toChars(typeOfMonster[3])[0]);
    }
    /**
     * Creates a monster with the stats passed in.
     * @param typeOfMovement determines the monster's movement behavior
     * @param hitPoints the monster's hitPoints
     * @param attack the monster's attack
     * @param pointValue how many points the monster is worth
     * @param icon the icon which will represent the monster on screen
     */

    public Monster(int typeOfMovement, int hitPoints, int attack, int pointValue, char icon) {
        this.setHitPoints(hitPoints);
        this.setAttack(attack);
        this.setPointValue(pointValue);
        this.setIcon(icon);
        this.typeOfMovement = typeOfMovement;
    }

    /**
     * Static factory method for generating a monster based on an input string.
     * @param typeOfMovement determines the monster's movement behavior
     * @param monsterName a string containing the name of the monster you want to create
     */

    public static Monster createMonster(int typeOfMovement, String monsterName) {
        monsterName = monsterName.toUpperCase();
        Monster retMonster;
        switch (monsterName) {
        case "BAT" :
            retMonster = new Monster(typeOfMovement, BAT);
            break;
        case "GOLEM" :
            retMonster = new Monster(typeOfMovement, GOLEM);
            break;
        case "MONSTER" :
            retMonster = new Monster(typeOfMovement, MONSTER);
            break;
        case "PIRATE" :
            retMonster = new Monster(typeOfMovement, PIRATE);
            break;
        case "SNAKE" :
            retMonster = new Monster(typeOfMovement, SNAKE);
            break;
        case "TROLL" :
            retMonster = new Monster(typeOfMovement, TROLL);
            break;
        case "ZOMBIE" :
            retMonster = new Monster(typeOfMovement, ZOMBIE);
            break;
        default :
            retMonster = new Monster(typeOfMovement, MONSTER);
        }

        return retMonster;
    }

    /**
     * @return the monster's hitPoints
     */
    public int getHitPoints() {
        return this.hitPoints;
    }
    /**
     * Sets the hitPoints of the monster.
     * @param newHp is the new hp for the monster
     */
    public void setHitPoints(int newHp) {
        this.hitPoints = newHp;
    }
    /**
     *Sets the attack of the monster.
     *@param attack the attack points of the monster
     */
    public void setAttack(int attack) {
        this.attack = attack;
    }
    /**
     * @return the monster's attack
     *
     */
    public int getAttack() {
        return this.attack;
    }

    /**
     * Get the point value of the Monster.
     * @return the point value of this monster
     */
    public int getPointValue() {
        return this.pointValue;

    }

    /**
     * sets the pointValue of the Monster
     * @param pointValue number of points for killing the bat.
     */
    public void setPointValue(int pointValue) {
        this.pointValue = pointValue;

    }

    /**
     * This is the getter to figure out what piece icon it is.
     */
    public char getIcon() {
        return this.icon;
    }

    /**
     *This is the setter for the Icon it will be.
     *@param NewIcon is the icon of piece that will be in the game
     */
    public void setIcon(char NewIcon) {
        this.icon = NewIcon;

    }

    /**
     *  A method that boosts stats on Monster for each level
     *  i.e. the higher the level, the tougher the enemy
     *  @param level the current level the player is on
    */
    public void setLevelBonus(int level) {
        this.hitPoints = this.hitPoints + ( (level * 5) - 5 ); //HP of monster is increased by 5 for each level
        if(level % 3 == 0)
            this.attack = this.attack + ( (level) - 1 );    //Attack power of monster increases by 1 every 3 levels

        //More bonuses goes here

    }

    /**
     * A method for attacking the player
     * @param mainChar the player being attacked
     */
    public void attacking(Player mainChar) {
        mainChar.setHitPoints(mainChar.getHitPoints() - this.attack);
    }

    /**
     * Setter: A method for setting the position of the monster
     * @param x Desired monster x coordinate position
     * @param y Desired monster y coordinate position
     */
    public void setMonsterPosition(int x, int y) {
        this.position[0] = x;
        this.position[1] = y;
    }
    
    /**
     * Chooses what direction the monster moves in.
     * @return a vector that represents the direction
     */    
    public int[] getDirection(int[] playerPosition) {

        int[] vector = new int[2];
        Random directionGenerator = new Random();


        switch(typeOfMovement) {
        case 0	:
            direction++;
            if(direction == 4) {
                direction = 0;
            }
            break;

        case 1	:
            direction = directionGenerator.nextInt(4);
            break;

        case 2 	:
            int randomer = directionGenerator.nextInt(3);
            if((position[0] - playerPosition[0] == 0)) {
                if(position[1] - playerPosition[1] > 0) {
                    if(randomer == 0) {
                        direction = 1;
                    } else if(randomer == 1) {
                        direction = 0;
                    } else if(randomer == 2) {
                        direction = 2;
                    }
                } else {
                    if(randomer == 0) {
                        direction = 3;
                    } else if(randomer == 1) {
                        direction = 0;
                    } else if(randomer == 2) {
                        direction = 2;
                    }
                }
            } else if((position[1] - playerPosition[1] == 0)) {
                if(position[0] - playerPosition[0] > 0) {
                    if(randomer == 0) {
                        direction = 2;
                    } else if(randomer == 1) {
                        direction = 1;
                    } else if(randomer == 2) {
                        direction = 3;
                    }
                } else {
                    if(randomer == 0) {
                        direction = 0;
                    } else if(randomer == 1) {
                        direction = 1;
                    } else if(randomer == 2) {
                        direction = 3;
                    }
                }
            } else if((position[0] - playerPosition[0] > 0) && (position[1] - playerPosition[1] > 0)) {
                if(directionGenerator.nextInt(2) == 1) {
                    direction = 1;
                } else {
                    direction = 2;
                }
            } else if((position[0] - playerPosition[0] > 0) && (position[1] - playerPosition[1] < 0)) {
                if(directionGenerator.nextInt(2) == 1) {
                    direction = 3;
                } else {
                    direction = 2;
                }

            } else if((position[0] - playerPosition[0] < 0) && (position[1] - playerPosition[1] > 0)) {
                if(directionGenerator.nextInt(2) == 1) {
                    direction = 1;
                } else {
                    direction = 0;
                }

            } else if((position[0] - playerPosition[0] < 0) && (position[1] - playerPosition[1] < 0)) {
                if(directionGenerator.nextInt(2) == 1) {
                    direction = 3;
                } else {
                    direction = 0;
                }

            }
        }

        switch (direction) {
        case 0	    :
            vector[0] = 1;
            break;
        case 1	    :
            vector[1] = -1;
            break;
        case 2	    :
            vector[0] = -1;
            break;
        case 3		:
            vector[1] = 1;
            break;
        default		:
            break;
        }

        return vector;
    }
}
