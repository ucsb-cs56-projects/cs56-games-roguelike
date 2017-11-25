package edu.ucsb.cs56.projects.games.roguelike;

import java.util.Random;
import java.util.ArrayList;
//import java.lang.reflect.*;

/**
 * LogicEngine takes care of game states
 * @author Minh Le
 * @author Hans Marasigan and Richard Nguyen
 * @author Rick Lee
 */
public class LogicEngine {
    //list of all the monsters
    private Monster[][] listOfMonsters;
    private Item[][] listOfItems;
    //the player the user uses
    private Player thePlayer;
    //all the cells that all object in the game can move in
    private GamePiece[][] floor;
    private int floorWidth;
    private int floorHeight;
    private int[] playerPosition;
    private boolean gameOver;
    private int level;//current level of the game
    private int elixirStepCounter;
    private boolean itemConsumed = false;

    //List of one of each monsters.
    //Add to this list when adding extra monsters (Put the class name as a String type)
    //Currently also needs to add cases to the createMonster() function
    private final String[] monsterPieces = new String[]
    {"Monster", "Troll", "Golem", "Bat", "Snake", "Zombie", "Pirate"};

    private int maxNumOfMonsters;//How many monsters on the board when creating them




    /**
     * creates the logic engine which takes care of game state, intialize with a floor that is 80 by 24
     *
     */
    public LogicEngine() {
        this(80, 24);
    }

    /**
     * creates the logic engine which takes care of game state
     * @param width the width of the floor
     * @param height the height of the floor
     */
    public LogicEngine(int width, int height) {
        floorWidth = width;
        floorHeight = height;
        floor = new GamePiece[floorWidth][floorHeight];
        listOfMonsters = new Monster[floorWidth][floorHeight];
        listOfItems = new Item[floorWidth][floorHeight];
        createAllObjects();
        storeMonsters();
        int[] position = {40, 12};
        thePlayer.setPlayerPosition(position);
        gameOver = false;

        //The -1 is to remove the initial monster creation incrementation
        maxNumOfMonsters = 7;
        level = 1;
        elixirStepCounter = 0;
    }

    public boolean getItemConsumed() {
        return itemConsumed;
    }


    public void setItemConsumed(boolean b) {
        itemConsumed = b;
    }

    /**
     * setter for boolean gameOver
     * @param a boolean to set gameOver to true or false
     */
    public void setGameOver(boolean a) {
        this.gameOver = a;
    }

    /**
     * getter for boolean gameOver
     * @return the current value of the boolean gameOver
     */
    public boolean getGameOver() {
        return gameOver;
    }
    /**
     * @return the list of monsters
     *
     */
    public Monster[][] getMonsters() {
        return listOfMonsters;
    }

    /**
     * @param x the x position of the object
     * @param y the y position of the object
     * @return the object at the position x and y
     */
    public GamePiece getObject(int x, int y) {
        return floor[x][y];
    }

    public Item getItem(int x, int y) {
        return listOfItems[x][y];
    }

    public GamePiece[][] getFloor() {
        return floor;
    }

    /**
     * @return the player
     *
     */
    public Player getPlayer() {
        return thePlayer;
    }

    public int[] getPlayerPosition() {
        return thePlayer.getPlayerPosition();
    }

    /**
       @return the level
    */
    public int getLevel() {
        return level;
    }
    /**
       @param level the level to set to
    */
    public void setLevel(int level) {
        this.level = level;
    }

    /**
       @return the max number of monsters
    */
    public int getMaxNumOfMonsters() {
        return maxNumOfMonsters;
    }
    /**
       @param max new max number of monsters
    */
    public void setMaxNumOfMonsters(int max) {
        this.maxNumOfMonsters = max;
    }

    /**
     * move GamePiece from (xOrig,yOrig) to (x,y)
     * 	 x and y are the position thats being tested
     * xOrig and yOrig are the position of the object now
     * @param x is the new x position
     * @param y is the new y position
     * @param xOrig is the x position of the object right now
     * @param yOrig is the y position of the object right now
     *
     */

    public void move(int x, int y, int xOrig, int yOrig) {
        setItemConsumed(false); //If player tried to move off potion, they are no longer consuming
        if (floor[x][y] instanceof Wall)
            return;

        if (floor[x][y] instanceof Item) {
            consumeItem(x, y);
            setItemConsumed(true); //If an item is consumed, it is noted, this will help with write function to let player know they consumed the item
        }

        if (x != xOrig || y != yOrig) {
            floor[x][y] = floor[xOrig][yOrig];
            floor[xOrig][yOrig] = null;
        }

        int[] position = {x, y};
        if(floor[x][y] instanceof Player) {
            thePlayer.setPlayerPosition(position);
        }

        if (thePlayer.getSpeed() > 1) {
            elixirStepCounter++;
            if (elixirStepCounter % 200 == 0) {
                thePlayer.setSpeed(thePlayer.getSpeed() - 1);
            }
        }

    }
    /**
     * x and y are the position thats being tested
     * xOrig and yOrig are the position of the object now
     * @param x is the x position of the position being tested
     * @param y is the y position of the position being tested
     * @param xOrig is the x position of the object right now
     * @param yOrig is the y position of the object right now
     * attacks if the 2 coordinates hold different GamePieces
     */
    public void attack(int x, int y, int xOrig, int yOrig) {
        // if ((x > 1 && x < floorWidth - 1) && (y > 1 && y < floorHeight - 1)) {
        if (floor[x][y] instanceof Wall)
            return;

        if(floor[x][y] instanceof Monster && floor[xOrig][yOrig] instanceof Player) {
            thePlayer.attacking(listOfMonsters[x][y]);
        }

        if(floor[x][y]instanceof Player && floor[xOrig][yOrig] instanceof Monster) {
            listOfMonsters[xOrig][yOrig].attacking(thePlayer);
        }
        //	    }
    }

    /**
     * Determines if there is a collision between a player and a monster
     * @param x horizontal position of thing to check
     * @param y vertical position of thing to check
     * @param xOrig horizontal position of thing doing the checking
     * @param yOrig vertical position of thing doing the checking
     * @return true if collision, false if not
     */

    public boolean attackable(int x, int y, int xOrig, int yOrig) {
        if (!isGround(x, y))
            return false;
        if (floor[x][y] instanceof Monster)
            return true;
        else if (floor[x][y] instanceof Player && floor[xOrig][yOrig] instanceof Monster)
            return true;
        else
            return false;
    }

    /**
     * x and y are the position thats being tested
     * xOrig and yOrig are the position of the object now
     * @param x is the x position of the position being tested
     * @param y is the y position of the position being tested
     * @return true if its movable, false if not
     */
    public boolean movable(int x, int y) {
        return (isGround(x, y) && thePlayer.getHitPoints() > 0);
    }

    /**
     * Checks if variables x and y are within the map
     * @param x horizontal coordinate being checked
     * @param y vertical cooridnate being checked
     * @return true if in bounds, false if not
     */

    public boolean inBounds(int x, int y) {
        return !((x < 1 || x >= floorWidth - 1) || (y < 1 || y >= floorHeight - 1));
    }

    /**
     * Checks if coordinates x and y are within bounds, and are not a wall
     * @param x horizontal coordinate being checked
     * @param y vertical coordinate being checked
     * @return true if in bounds and not wall, false otherwise
     */
    public boolean isGround(int x, int y) {
        if (!inBounds(x, y))
            return false;
        else if (floor[x][y] instanceof Wall)
            return false;
        else
            return true;
    }

    /**
     * check if the monster at position x,y has 0 or less hp
     * there is a chance of the monster dropping an item when it dies
     * @param x is the x position of the position being tested
     * @param y is the y position of the position being tested
     * @return if monster is dead at x and y return true else false
     */
    public boolean monsterIsDead(int x, int y) {

        if(listOfMonsters[x][y] != null && listOfMonsters[x][y].getHitPoints() <= 0) {

            double random = Math.random();

            if(0 <= random && random <= .2) { // 20% chance to drop Health Potion
                createItem(x, y, new HealthPotion());
            } else if(.2 < random && random <= .4) { // 20% chance to drop Beef
                createItem(x, y, new Beef());
            } else if(.4 < random && random <= .55) { // 15% chance to drop Pioson
                createItem(x, y, new Poison());
            } else if(.55 < random && random <= .60) {
                createItem(x, y, new Elixir()); // 5% chance of drop Elixir
            } else // no item drop :(
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
    public boolean playerIsDead() {
        if(thePlayer.getHitPoints() <= 0) {
            return true;
        }

        return false;
    }


    /**
     * update the monster list based on the objects in floor
     */
    public void storeMonsters() {

        for (int x = 0; x < floorWidth; x++) {
            for (int y = 0; y < floorHeight; y++) {
                if(floor[x][y] instanceof Monster) {
                    listOfMonsters[x][y] = (Monster) floor[x][y];
                    listOfMonsters[x][y].setMonsterPosition(x, y);
                } else {
                    listOfMonsters[x][y] = null;
                }
            }
        }
    }

    /**
     * creates all the monsters and player in the game
     */
    public void createAllObjects() {

        for (int x = 0; x < floorWidth; x++) {
            for (int y = 0; y < floorHeight; y++) {
                floor[x][y] = null;
            }
        }

        createWalls();

        thePlayer = new Player();
        floor[3][2] = thePlayer; //was 40, 12

        //directly calls the method below that creates monsters
        this.createMonster();
    }

    /**
      Fills Room borders with walls
    */
    public void createRoom(Room newRoom) {
        for(int col = newRoom.getX1(); col <= newRoom.getX2(); col++) {
            for(int row = newRoom.getY1(); row <= newRoom.getY2(); row++) {
                if(col == newRoom.getX1() || col == newRoom.getX2() || row == newRoom.getY1() || row == newRoom.getY2()) {
                    //System.out.println("x1: " + Integer.toString(newRoom.getX1()) + " x2: " + Integer.toString(newRoom.getX2()) + " y1: " + Integer.toString(newRoom.getY1()) + " y2: " + Integer.toString(newRoom.getY2()) + " row, col " + Integer.toString(row) + ", " + Integer.toString(col) + " maxWidth, maxHeight " + Integer.toString(floorWidth) + ", " + Integer.toString(floorHeight));
                    if((col > newRoom.getCenterX()-2 && col < newRoom.getCenterX()+2) || (row < newRoom.getCenterY()+2 && row > newRoom.getCenterY()-2)) {
                        floor[col][row] = null;
                    }
                    else {
                        floor[col][row] = new Wall();
                    }
                }
            }
        }
    }

    public void hCorridor(int x1, int x2, int y) {
        int corridorWidth = 3;

        for(int col = Math.min(x1,x2); col < Math.max(x1, x2) + 1;  col++) {
            // destory the walls to "carve" out corridor
            for(int i = 0; i <= corridorWidth ; i++) {
                floor[col][y+i] = null;
            }

            //add corridor walls
            if(col != x1 && col != x2) {
                floor[col][y] = new Wall();
                floor[col][y + corridorWidth + 1] = new Wall();
            }
        }
    }

    // create vertical corridor to connect rooms
    public void vCorridor(int y1, int y2, int x) {
        int corridorWidth = 3;

        for(int row = Math.min(y1,y2); row < Math.max(y1, y2) + 1;  row++) {
            // destory the walls to "carve" out corridor
            for(int i = 0; i <= corridorWidth ; i++) {
                floor[x+i][row] = null;
            }

            //add corridor walls
            if(row != y1 && row != y2) {
                floor[x][row] = new Wall();
                floor[x + corridorWidth + 1][row] = new Wall();
            }
        }
    }

    /**
       Fills empty spaces with wall objects
    */
    public void createWalls() {
        int w;
        int h;
        int x;
        int y;
        int x1, x2, y1, y2;
        int newCenterX, newCenterY;

        // create array for room storage for easy access
        ArrayList<Room> rooms = new ArrayList<Room>();

        // create room with randomized values
        for(int i = 0; i < 5; i++) {
            //int range = (max - min) + 1;
            //return (int)(Math.random() * range) + min;
            w = (int)(Math.random() * (floorWidth * (2/3)))+8;
            h = (int)(Math.random() * (floorHeight * (2/3)))+8;
            x = (int)(Math.random() * (floorWidth - w - 1) + 1);
            y = (int)(Math.random() * (floorHeight - h - 1) + 1);

            Room newRoom = new Room(x, y, w, h);

            boolean failed = false;
            for(Room otherRoom : rooms) {
                if(newRoom.intersects(otherRoom)) {
                   failed = true;
                   break;
                }
            }
            if (!failed) {
                // local function to carve out new room
                createRoom(newRoom);

                newCenterX = newRoom.getCenterX();
                newCenterY = newRoom.getCenterY();

                if(rooms.size() != 0) {

                    // store center of previous room
                    int prevCenterX = rooms.get(rooms.size() - 1).getCenterX();
                    int prevCenterY = rooms.get(rooms.size() - 1).getCenterY();

                    if(prevCenterX > newCenterX) {
                        x1 = newCenterX + (int)(newRoom.getWidth() / 2);
                        x2 = prevCenterX - (int)(rooms.get(rooms.size() - 1).getWidth() / 2);
                    } else {
                        x1 = prevCenterX + (int)(rooms.get(rooms.size() - 1).getWidth() / 2);
                        x2 = newCenterX - (int)(newRoom.getWidth() / 2);
                    }

                    if(prevCenterY > newCenterY) {
                      y1 = newCenterY + (int)(newRoom.getHeight() / 2);
                      y2 = prevCenterY - (int)(rooms.get(rooms.size() - 1).getHeight() / 2);
                    } else {
                      y1 = prevCenterY + (int)(rooms.get(rooms.size() - 1).getHeight() / 2);
                      y2 = newCenterY - (int)(newRoom.getHeight() / 2);
                    }



                    // carve out corridors between rooms based on centers
                    // randomly start with horizontal or vertical corridors
                    if ((int)(Math.random()*2) + 1 == 1) {
                        hCorridor(x1, x2, prevCenterY);
                        vCorridor(y1, y2, newCenterX);
                    } else {
                        vCorridor(y1, y2, prevCenterX);
                        hCorridor(x1, x2, newCenterY);
                    }
                }
            }
            if(!failed) {
              rooms.add(newRoom);
            }
        }

        // Borders
        for (int col = 0; col < floorWidth; col++) {
            floor[col][0] = new Wall();
            floor[col][floorHeight - 2] = new Wall();
        }

        for (int row = 0; row < floorHeight; row++) {
            floor[0][row] = new Wall();
            floor[floorWidth - 2][row] = new Wall();
        }
    }

    /**
     * creates specified item at specified location
     * @param x x coordinate for new item
     * @param y y coordinate for new item
     * @param i reference to new item
     */
    public void createItem(int x, int y, Item i) {
        floor[x][y] = i;
        listOfItems[x][y] = i;
    }

    public void consumeItem(int x, int y) {
        listOfItems[x][y].UseEffect(thePlayer);
        listOfItems[x][y] = null;
        floor[x][y] = null;
        // consumed item
    }

    public void deleteItem(int x, int y) {
        listOfItems[x][y] = null;
        floor[x][y] = null;
    }
    /**
     * after the level is completed, resets the player to the starting position
     */

    public void resetPlayerPosition() {
        int[] resetPosition = {3, 2};
        thePlayer.setPlayerPosition(resetPosition);
        floor[3][2] = thePlayer;
    }

    /**
     * creates monsters at random, some monsters appearing multiple times and some not appearing at all
     */
    public void createMonster() {
        Random numGenerator = new Random();

        int i = 0;
        while(i < maxNumOfMonsters) {
            int xPos = numGenerator.nextInt(79);
            int yPos = numGenerator.nextInt(23);

            int n = (int)(Math.random() * monsterPieces.length);

            if(floor[xPos][yPos] == null) {

                switch(n) {
                case 0 :
                    floor[xPos][yPos] = new Monster(numGenerator.nextInt(2) + 1, Monster.MONSTER);
                    listOfMonsters[xPos][yPos] = (Monster) floor[xPos][yPos];
                    listOfMonsters[xPos][yPos].setLevelBonus(level);
                    listOfMonsters[xPos][yPos].setMonsterPosition(xPos, yPos);
                    break;
                case 1 :
                    floor[xPos][yPos] = new Monster(numGenerator.nextInt(2) + 1, Monster.TROLL);
                    listOfMonsters[xPos][yPos] = (Monster) floor[xPos][yPos];
                    listOfMonsters[xPos][yPos].setLevelBonus(level);
                    listOfMonsters[xPos][yPos].setMonsterPosition(xPos, yPos);
                    break;
                case 2 :
                    floor[xPos][yPos] = new Monster(numGenerator.nextInt(2) + 1, Monster.GOLEM);
                    listOfMonsters[xPos][yPos] = (Monster) floor[xPos][yPos];
                    listOfMonsters[xPos][yPos].setLevelBonus(level);
                    listOfMonsters[xPos][yPos].setMonsterPosition(xPos, yPos);
                    break;
                case 3 :
                    floor[xPos][yPos] = new Monster(numGenerator.nextInt(2) + 1, Monster.BAT);
                    listOfMonsters[xPos][yPos] = (Monster) floor[xPos][yPos];
                    listOfMonsters[xPos][yPos].setLevelBonus(level);
                    listOfMonsters[xPos][yPos].setMonsterPosition(xPos, yPos);
                    break;
                case 4 :
                    floor[xPos][yPos] = new Monster(numGenerator.nextInt(2) + 1, Monster.SNAKE);
                    listOfMonsters[xPos][yPos] = (Monster) floor[xPos][yPos];
                    listOfMonsters[xPos][yPos].setLevelBonus(level);
                    listOfMonsters[xPos][yPos].setMonsterPosition(xPos, yPos);
                    break;
                case 5 :
                    floor[xPos][yPos] = new Monster(numGenerator.nextInt(2) + 1, Monster.ZOMBIE);
                    listOfMonsters[xPos][yPos] = (Monster) floor[xPos][yPos];
                    listOfMonsters[xPos][yPos].setLevelBonus(level);
                    listOfMonsters[xPos][yPos].setMonsterPosition(xPos, yPos);
                    break;
                case 6 :
                    floor[xPos][yPos] = new Monster(numGenerator.nextInt(2) + 1, Monster.PIRATE);
                    listOfMonsters[xPos][yPos] = (Monster) floor[xPos][yPos];
                    listOfMonsters[xPos][yPos].setLevelBonus(level);
                    listOfMonsters[xPos][yPos].setMonsterPosition(xPos, yPos);
                    break;

                //Add new monsters here. Copy the case and change the parameter passed in



                default :
                    floor[xPos][yPos] = null;
                    i--;
                    break;

                }//switch
                i++;
            }//if(floor[xPos][yPos]==null)
        }//while





        //DOES NOT WORK : plan to systemize creation of monsters instead of manually adding cases
        /*
          for(int i = 0; i < maxNumOfMonsters; i++){
          int xPos = numGenerator.nextInt(79);
          int yPos = numGenerator.nextInt(23);
          //randomly generates a number which determines what type monster will be created
          int n = (int)(Math.random()*monsterPieces.length);

          if(floor[xPos][yPos]==null){

          String className = monsterPieces[n];
          Class c1 = Class.forName(className);
          Constructor con = c1.getConstructor(int.class);
          floor[xPos][yPos] =
          (GamePiece)con.newInstance(numGenerator.nextInt(2)+1);
          }//if
          }//for
        */

    }

}
