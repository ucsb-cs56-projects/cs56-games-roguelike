package edu.ucsb.cs56.projects.games.roguelike;
import java.awt.event.*;
import java.util.Random;
import java.io.*;
import javax.swing.*;


/**
 * RogueController - Handles user input and gamestate.
 * 	Will eventually be split up into separate components,
 * 	but for the sake of having something that runs,
 * 	RogueController both creates a RoguePanel and allows the user to manipulate it.
 * @author Clayven Anderson and Jonathan Tan
 * @author Hans Marasigan
 * @author Minh Le
 * @author Rick Lee
 */
public class RogueController extends JFrame implements KeyListener {

    //Unique serialVersion identification. Generated by Eclipse.
    //private static final long serialVersionUID = 8465305666089157172L;
    //x and y is the player intial position
    private int x = 3;
    private int y = 2;

    private GamePiece[][]floor;

    //startx and starty are the locations the player should spawn after a new level begins
    public final int startx = x;
    public final int starty = y;

    private Random randomNumber = new Random();

    // origX and origY is the position the character is at before the it moves
    private int origX;
    private int origY;

    private int currentLevel = 1;

    //Canvas - The RoguePanel instance everything is drawn to.
    public RoguePanel canvas;


    // handles all game state from attack and damage to remove of monsters and player
    public LogicEngine logicHandler;

    //Matrix indicating which grid space has been discovered yet
    //1 = discovered, any other value = not discovered
    private int[][] discoveredArea;

    /**
     * No parameters.
     * Constructor initializes the RoguePanel canvas, logicEngine logicHandler and declares that it is listening for keys.
     */
    public RogueController() {
        super();
        canvas = new RoguePanel();
        add(canvas);
        pack();
        logicHandler = new LogicEngine();
        addKeyListener(this);
        discoveredArea = new int[ canvas.getGridWidth() ][ canvas.getGridHeight() - 1 ];
    }


    /**
     * Handles movement of player by checking if it can move there first through the logic engine
     * if it can move, invoke the canvas to animate it
     * if it can't, it checks if its because of out of bounds or a monster
     * if its a monster the player will attack it and if it's dead the canvas will animate the removal of the monster
     */
    public void moveHero() {
        //	if(!logicHandler.movable(x,y,origX, origY)){

        //    if(logicHandler.monsterIsDead(x,y)){
        //	canvas.clear(x,y);
        //   }

        //  x = origX;
        //   y = origY;
        //	}
        //	canvas.moveHeroAnimated(x, y,logicHandler.getPlayer().getHitPoints(),logicHandler.getPlayer().getScore());

        while (!logicHandler.isGround(x, y)) {
            if (x != origX)
                x = (x > origX) ? x - 1 : x + 1;
            else if (y != origY)
                y = (y > origY) ? y - 1 : y + 1;
        }

        //Draws all items even when the player tries to move outside the boundaries
        drawAllItems();
		
		boolean attacked = attackMonsters(origX, origY, x, y);
        if (attacked) {	//if the player attacked a monster, then dont change its position
            x = origX;
            y = origY;
        } else{
			
			if(logicHandler.movable(x,y)){
				logicHandler.move(x, y, origX, origY);
			}
			if (logicHandler.getItemConsumed()) {
			    Sound.itemConsumedSound.play(); //Plays Item consumed noise
			    canvas.write("     Item Used  ", 61, 23, RoguePanel.green, RoguePanel.black);
			}
		}

        canvas.moveHeroAnimated(x, y, logicHandler.getPlayer().getHitPoints(), logicHandler.getPlayer().getAttack(), logicHandler.getPlayer().getSpeed(), logicHandler.getLevel(), logicHandler.getPlayer().getScore());
    }
	
	
	
	/**
		Attacks all monster between the player and the target
		Returns true if a monster has been attacked
	*/
	private boolean attackMonsters(int playerX, int playerY, int targetX, int targetY){
		int tempX=playerX, tempY=playerY;
		boolean attacked=false;

		while(tempX!=targetX || tempY!=targetY){
			
			//increment the temp positions to move closer to the target
			tempX+= Integer.signum(targetX - tempX);
			tempY+= Integer.signum(targetY - tempY);
			
			//checks every square between the player and the target
			if(logicHandler.attackable(tempX, tempY)){
				logicHandler.attack( tempX, tempY, playerX, playerY);
				
				//if the monster is killed, see if an item has been dropped
				 if (logicHandler.monsterIsDead(tempX, tempY)) {
					if (logicHandler.getObject(tempX, tempY) instanceof Item) {
						canvas.drawItem(tempX, tempY, logicHandler.getItem(tempX, tempY));
					} else {
						canvas.clear(tempX, tempY);
					}

				 }
				attacked = true;
			}
		}
		
		return attacked;
	}

    /**
     * Handles movement of all monsters by checking if it can move there first through the logic engine
     * if it can move, invoke the canvas to animate it
     * if it can't, it checks if its because of out of bounds or a monster or a player
     * if its a player, the monster will attack it and if its a monster it will eat it
     */
    public void moveMonster() {
        //xPos,yPos is the position the monster is going to move to
        int gridWidth, gridHeight, xPos, yPos;
        int[] direction = new int[2];
        Monster mon[][] = logicHandler.getMonsters();
        gridHeight = canvas.getGridHeight();
        gridWidth = canvas.getGridWidth();

        /* loops through all the monsters
           xOrig,yOrig is the position the monster is at right now */
        for (int xOrig = 0; xOrig < gridWidth; xOrig++) {
            for (int yOrig = 0; yOrig < gridHeight; yOrig++) {

                if(mon[xOrig][yOrig] != null) {
                    // gets the direction of movement of the monster at xOrig, yOrig
                    direction = mon[xOrig][yOrig].getDirection(logicHandler.getPlayerPosition());
                    xPos = xOrig + direction[0];
                    yPos = yOrig + direction[1];

                    if (logicHandler.attackable(xPos, yPos, xOrig, yOrig)) {
                        logicHandler.attack(xPos, yPos, xOrig, yOrig);
                        if(xPos > 0 && xPos <= 78 && yPos > 0 && yPos <= 20) {
                            //display the you were attacked flag if the collision was with a player
                            if(logicHandler.getObject(xPos, yPos) instanceof Player) {
                                canvas.monsterAttack();
                                canvas.moveHeroAnimated(x, y, logicHandler.getPlayer().getHitPoints(),
                                                        logicHandler.getPlayer().getAttack(),
                                                        logicHandler.getPlayer().getSpeed(), logicHandler.getLevel()
                                                        , logicHandler.getPlayer().getScore());
                            }
                            canvas.moveMonster(xOrig, yOrig, logicHandler.getObject(xOrig, yOrig));
                        }
                    } else if (logicHandler.movable(xPos, yPos)) {
                        logicHandler.move(xPos, yPos, xOrig, yOrig);
                        canvas.moveMonster(xPos, yPos, logicHandler.getObject(xPos, yPos));

                        //This was a fix for monsters disappearing. Monster will remain in the same place if not movable
                    } else {
                        logicHandler.move(xOrig, yOrig, xOrig, yOrig);
                        canvas.moveMonster(xOrig, yOrig, logicHandler.getObject(xOrig, yOrig));

                    }
                }
            }
        }

        //update the monster list in logic handler
        logicHandler.storeMonsters();
        fillEmptySpace();
    }

    public void fillEmptySpace() {
        Object floor[][];
        floor = logicHandler.getFloor();
        for (int x = 0; x < canvas.getGridWidth() - 1; x++) {
            for (int y = 0; y < canvas.getGridHeight() - 1; y++) {
                if(floor[x][y] == null) {
                    canvas.emptySpace(x, y, logicHandler.getLevel());
                }
            }

        }
    }

    /**
     * Draws all walls using RoguePanel
     */
    public void drawAllWalls() {
        for (int x = 0; x < canvas.getGridWidth() - 1; x++) {
            for (int y = 0; y < canvas.getGridHeight() - 1; y++) {
                if(logicHandler.getObject(x, y) instanceof Wall)
                    canvas.drawWall(x, y, logicHandler.getLevel());
            }
        }
    }

    /**
     * Makes sure all items stay visible on the screen.
     */

    public void drawAllItems() {
        for (int x = 0; x < canvas.getGridWidth() - 1; x++) {
            for (int y = 0; y < canvas.getGridHeight() - 1; y++) {
                if(logicHandler.getObject(x, y) instanceof Item)
                    canvas.drawItem(x, y, logicHandler.getItem(x, y));
            }
        }
    }

    public void clearAllItems() {
        if (logicHandler.getLevel() != currentLevel) {
            for (int x = 0; x < canvas.getGridWidth() - 1; x++) {
                for (int y = 0; y < canvas.getGridHeight() - 1; y++) {
                    if(logicHandler.getObject(x, y) instanceof Item) {
                        logicHandler.deleteItem(x, y);
                    }
                }
            }
        }
        currentLevel++;
    }

    /**
           Records the areas where the player has revealed
        */
    public void trackDiscovery() {

        drawAllWalls(); //These Two Functions are called so that after the last monster is killed
        fillEmptySpace(); //The next level will appear with the right color

        //x and y coordinates of player
        int playerX = logicHandler.getPlayerPosition()[0];
        int playerY = logicHandler.getPlayerPosition()[1];

        //records the current x,y, position
        discoveredArea[playerX][playerY] = 1;

		int radius = logicHandler.getPlayer().getSight();

		//checks all spaces in the players radius of sight
        for(int i = -radius; i <= radius; i++) {
            for(int j = -radius; j <= radius; j++) {

				int targetX = playerX + i;
				int targetY = playerY + j;

				//check if there is a wall between the player's coordinates and the target coordinates
				if (isObstacle(playerX, playerY, targetX, targetY)){
					discoveredArea[targetX][targetY] = 1;
				}
            }
        }


    }

	/**
		returns the slope of the line between the specified coordinates
		will return NEGATIVE_INFINITY or POSITIVE_INFINITY for vertical lines
	*/
	private double findSlope(int xi, int yi, int xf, int yf){
		//the edge cases for vertical lines
		if(xf-xi == 0){

			if(yf-yi < 0){
				return Double.NEGATIVE_INFINITY;
			}
			else {
				return Double.POSITIVE_INFINITY;
			}
		}

		return (double)(yf-yi) / (xf - xi);
	}

	/**
		returns true if a coordinate is out of bounds
	*/
	private boolean outOfBounds(int x, int y){
		return x<0 || x>=discoveredArea.length || y<0 || y>=discoveredArea[0].length;
	}

	/**
		find the distance between two points
	*/
	private int distance(int x1, int y1, int x2, int y2){
		return (int)(Math.sqrt(Math.pow(x1-x2, 2) + Math.pow(y1-y2, 2)));
	}

	/**
		returns true if there is a wall between the two pairs of coordinates
	*/
	public boolean isObstacle(int currentX, int currentY, int targetX, int targetY){
		double slope = findSlope(currentX, currentY, targetX, targetY);
		return isObstacle(currentX, currentY, targetX, targetY, slope);
	}


	/**
		recursively moves from the current coordinates to the target coordinates,
		checking if there is a wall in the way as it goes
	*/
	private boolean isObstacle(int currentX, int currentY, int targetX, int targetY, double slope){
		if( outOfBounds(currentX, currentY)) {
			return false;
		}


		int playerX = logicHandler.getPlayerPosition()[0];
        int playerY = logicHandler.getPlayerPosition()[1];

		//has gone outside the player's radius of sight
		int distance = distance(currentX, currentY, playerX, playerY);
		if(distance > logicHandler.getPlayer().getSight()){
			return false;
		}

		//reached the target
		if(targetX == currentX && targetY == currentY){
			return true;
		}

		//if it hits a wall
		if(logicHandler.getObject(currentX, currentY) instanceof Wall){
			return false;
		}



		//if not reached the target or hit a wall, keep moving

		//calculate what to change the x coordinate by
		int xChange=0;
		if(targetX < currentX){
			xChange = -1;
		}
		else if (targetX > currentX) {
			xChange = 1;
		}

		//calculatewhat to change the y coordinate by
		int yChange=0;
//		slope = findSlope(currentX, currentY, targetX, targetY);
		if(Double.isInfinite(slope)){
			if(Double.compare(slope, 0) < 0)
				yChange = -1;
			else
				yChange = 1;
		}
		else
			yChange = (int)(slope * (currentX+xChange - playerX));

		//normalizing the change in y
		if(yChange > 1)
			yChange = 1;
		if(yChange < -1)
			yChange = -1;

		return isObstacle(currentX+xChange, currentY+yChange,targetX, targetY , slope);
	}

    /**
         * Checks to see if player is dead, and store score into txt file for HighScores
         *
         */
    public void checkPlayerStatus() {
        int[] array = new int[5];
        int a  = 0;
        if( logicHandler.getGameOver() == true) {
            canvas.clear();
            // display the HighScore after game is over by reading from Score.txt...
            try {
                File myFile = new File( "Score.txt");
                FileReader fileReader = new FileReader("Score.txt");
                BufferedReader reader = new BufferedReader(fileReader);
                String line = null;
                while((line = reader.readLine()) != null) {
                    array[a] = Integer.parseInt(line);
                    a++;
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            canvas.displayLosingScreen(logicHandler.getPlayer().getScore(), array);
        }
        // display the score and highScores after game is over and write the new highScore into Score.txt
        if(logicHandler.playerIsDead() && logicHandler.getGameOver() == false) {
            try {
                File myFile = new File( "Score.txt");
                FileReader fileReader = new FileReader("Score.txt");
                BufferedReader reader = new BufferedReader(fileReader);
                String line = null;
                while((line = reader.readLine()) != null) {
                    array[a] = Integer.parseInt(line);
                    a++;
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            // updating the Score.txt file after getting new highScore
            int temp = 0;
            int temp2 = 0;
            for(int count = 0; count < 5; count++) {
                if(array[count] < logicHandler.getPlayer().getScore()) {
                    temp = array[count];
                    array[count] = logicHandler.getPlayer().getScore();
                    if( count != 4) {
                        for( int c = count + 1; count < 5; count++) {
                            temp2 = array[c];
                            array[c] = temp;
                            temp = temp2;
                        }
                    }
                    break;
                }
            }

            try {
                FileWriter writer = new FileWriter("Score.txt");
                for( int b = 0 ; b < 5; b++) {
                    writer.write("" + array[b] + "\n");
                }
                writer.close();
            } catch(IOException ex) {
                ex.printStackTrace();
            }
            canvas.clear();
            canvas.displayLosingScreen(logicHandler.getPlayer().getScore(), array);
            logicHandler.setGameOver(true);
        }



    }

    /**
     * Check to see if all monsters are dead and creates more monsters!!! OMG!!
     */
    public void checkAllMonsterStatus() {
        int gridWidth, gridHeight;
        Monster mon[][] = logicHandler.getMonsters();
        gridHeight = canvas.getGridHeight();
        gridWidth = canvas.getGridWidth();

        for (int xOrig = 0; xOrig < gridWidth; xOrig++) {
            for (int yOrig = 0; yOrig < gridHeight; yOrig++) {
                if(mon[xOrig][yOrig] != null) {
                    return;
                }
            }
        }
        //If all monsters are defeated, created new monsters and increase the level
        logicHandler.setLevel(logicHandler.getLevel() + 1); //Increments level
	canvas.nextLevel(); // Displays to user that they are on next level
	logicHandler.changeMusic(); //Changes the music to new level
        logicHandler.setMaxNumOfMonsters(logicHandler.getMaxNumOfMonsters() + 1); //Increases monster count
        discoveredArea = new int[ canvas.getGridWidth() ][ canvas.getGridHeight() - 1 ]; //resets exploration
        logicHandler.createAllObjects();//clear board, make walls, player, and monsters
        clearAllItems();
        logicHandler.resetPlayerPosition();//moves the player back to the starting position
        canvas.moveHeroAnimated(startx, starty, logicHandler.getPlayer().getHitPoints(), logicHandler.getPlayer().getAttack(),
                                logicHandler.getPlayer().getSpeed(), logicHandler.getLevel(), logicHandler.getPlayer().getScore());
        this.x = startx;
        this.y = starty;
    }

    /**
     * Method mandated by KeyListener interface.
     * Calls moveHero().
     * @param key Keystroke event fired by keyboard.
     */
    public void keyPressed(KeyEvent key) {


        //WASD moves
        origX = x;
        origY = y;
        switch (key.getKeyChar()) {
        case 'w': //UP MOVEMENT
            this.y = this.y - logicHandler.getPlayer().getSpeed();
            break;
        case 'q': //UP LEFT DIAGONAL MOVEMENT
            this.y = this.y - logicHandler.getPlayer().getSpeed();
            this.x = this.x - logicHandler.getPlayer().getSpeed();
            break;
        case 'a': //LEFT MOVEMENT
            this.x = this.x - logicHandler.getPlayer().getSpeed();
            break;
        case 'e': //UP RIGHT MOVEMENT
            this.y = this.y - logicHandler.getPlayer().getSpeed();
            this.x = this.x + logicHandler.getPlayer().getSpeed();
            break;
        case 'd': //RIGHT MOVEMENT
            this.x = this.x + logicHandler.getPlayer().getSpeed();
            break;
        case 'z': //DOWN LEFT MOVEMENT
            this.y = this.y + logicHandler.getPlayer().getSpeed();
            this.x = this.x - logicHandler.getPlayer().getSpeed();
            break;
        case 's': //DOWN MOVEMENT
            this.y = this.y + logicHandler.getPlayer().getSpeed();
            break;
        case 'c': //DOWN RIGHT MOVEMENT
            this.y = this.y + logicHandler.getPlayer().getSpeed();
            this.x = this.x + logicHandler.getPlayer().getSpeed();
            break;
        case 'l': //LINGER BUTTON (Player waits in place)
            break;
        default	:
            return;
        }

        //Tell player they cannot run into a wall, else continue with game progress
        if(logicHandler.getObject(x, y) instanceof Wall) {
            canvas.write("     Ouch a Wall  ", 61, 23, RoguePanel.yellow, RoguePanel.red);

            //restores player (x,y) player position if a wall is hit
            while (!logicHandler.isGround(x, y)) {
                if (x != origX && y != origY) {
                    x = origX;
                    y = origY;
                } else if (y != origY)y = origY;
                else if (x != origX) x = origX;
            }
        } else {
            canvas.clear();
            drawAllWalls();
            //Writes last received input.
            canvas.write(key.getKeyChar(), 7, 23, RoguePanel.white, RoguePanel.black);
            moveHero();
            moveMonster();
	   
            checkPlayerStatus();
            checkAllMonsterStatus();
	    trackDiscovery();

            canvas.recordShadows(discoveredArea);
        }
        if(logicHandler.getGameOver() == false)
            canvas.setInGame(true);
        else
	canvas.setInGame(false);
        canvas.repaint();
    }

    /**
     * Method required by the KeyListener interface.
     * Doesn't do anything yet.
     */
    public void keyReleased(KeyEvent key) {

    }


    /**
     * Method required by the KeyListener interface.
     * Doesn't do anything yet.
     */
    public void keyTyped(KeyEvent key) {

    }

    public static void goToLosingScreen() {
        RogueController mainControl = new RogueController();
        mainControl.setVisible(true);
        mainControl.setLocationRelativeTo(null);
        mainControl.logicHandler.setGameOver(true);
        mainControl.checkPlayerStatus();
    }


    public static void main(String[] args) {
        RogueController mainControl = new RogueController();
        mainControl.setVisible(true);
        mainControl.setLocationRelativeTo(null); // center the window

        //Initially fills the map with monsters
        mainControl.logicHandler.createMonster();

        //Screen that shows after game is opened
        mainControl.canvas.write("MOVE WITH W A S D. MOVE DIAGONAL WITH Q E Z C. LINGER WITH L.", 9, 12, RoguePanel.white, RoguePanel.black);
	mainControl.canvas.write(" Survive the waves. Eat or be eaten...",9,13, RoguePanel.red,RoguePanel.black);



    }//Main Delimit

}//Class Delimit
