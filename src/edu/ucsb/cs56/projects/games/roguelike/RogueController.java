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
public class RogueController extends JFrame implements KeyListener
{
	
    //Unique serialVersion identification. Generated by Eclipse.
    //private static final long serialVersionUID = 8465305666089157172L;
    //x and y is the player intial position
    private int x=3;
    private int y=2;
    
    private GamePiece[][]floor;

    //startx and starty are the locations the player should spawn after a new level begins
    public final int startx = x;
    public final int starty = y;

    private Random randomNumber = new Random();
	
    // origX and origY is the position the character is at before the it moves
    private int origX;
    private int origY;

    private int currentLevel= 1;

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
    public RogueController(){
	super();
	canvas = new RoguePanel();
	add(canvas);
	pack();
	logicHandler = new LogicEngine();
	addKeyListener(this);
	discoveredArea = new int[ canvas.getGridWidth() ][ canvas.getGridHeight()-1 ];
    }
    
    /**
     * Handles movement of player by checking if it can move there first through the logic engine
     * if it can move, invoke the canvas to animate it
     * if it can't, it checks if its because of out of bounds or a monster
     * if its a monster the player will attack it and its its dead the canvas will animate the removal of the monster
     */
    public void moveHero(){
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
		x = (x > origX) ? x-1 : x+1;
	    else if (y != origY)
		y = (y > origY) ? y-1 : y+1;
	}

	//Draws all items even when the player tries to move outside the boundaries
	drawAllItems();
	if (logicHandler.attackable(x, y, origX, origY)) {
	    logicHandler.attack(x, y, origX, origY);
	    if (logicHandler.monsterIsDead(x,y)){
		if (logicHandler.getObject(x,y) instanceof Item){
		    canvas.drawItem(x,y, logicHandler.getItem(x,y));
		} else {
		    canvas.clear(x,y);
		}
	    }
	    x = origX;
	    y = origY;
	} else if (logicHandler.movable(x, y)) {
	    logicHandler.move(x, y, origX, origY);
	}
	canvas.moveHeroAnimated(x, y,logicHandler.getPlayer().getHitPoints(), logicHandler.getPlayer().getAttack(),
				logicHandler.getPlayer().getSpeed(), logicHandler.getLevel(), logicHandler.getPlayer().getScore());	
    }
    /**
     * Handles movement of all monsters by checking if it can move there first through the logic engine
     * if it can move, invoke the canvas to animate it
     * if it can't, it checks if its because of out of bounds or a monster or a player
     * if its a player, the monster will attack it and if its a monster it will eat it
     */
    public void moveMonster(){
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
	        	  
		if(mon[xOrig][yOrig]!=null) {
		    // gets the direction of movement of the monster at xOrig, yOrig
		    direction = mon[xOrig][yOrig].getDirection(logicHandler.getPlayerPosition());
		    xPos = xOrig + direction[0];			      
		    yPos = yOrig + direction[1];

		    if (logicHandler.attackable(xPos, yPos, xOrig, yOrig)) {
			logicHandler.attack(xPos, yPos,xOrig,yOrig);
			if(xPos>0 && xPos<=78 && yPos>0 && yPos<=20){
			    //display the you were attacked flag if the collision was with a player
			    if(logicHandler.getObject(xPos, yPos) instanceof Player){
				canvas.monsterAttack();
				canvas.moveHeroAnimated(x, y, logicHandler.getPlayer().getHitPoints(),
							logicHandler.getPlayer().getAttack(),
							logicHandler.getPlayer().getSpeed(), logicHandler.getLevel()
							,logicHandler.getPlayer().getScore());
			    }
			    canvas.moveMonster(xOrig, yOrig,logicHandler.getObject(xOrig,yOrig));
			}
		    } else if (logicHandler.movable(xPos, yPos)) {
			logicHandler.move(xPos, yPos,xOrig,yOrig);
			canvas.moveMonster(xPos, yPos,logicHandler.getObject(xPos,yPos));
		    }
		}
	    }
	}
				      
	//update the monster list in logic handler
	logicHandler.storeMonsters();
	fillEmptySpace();
    }
    
    
    public void fillEmptySpace(){
	Object floor[][];
	floor = logicHandler.getFloor();
	for (int x= 0; x < canvas.getGridWidth()-1; x++) {	  
	    for (int y = 0; y < canvas.getGridHeight()-1; y++) {
		if(floor[x][y]== null){
		    canvas.emptySpace(x,y,logicHandler.getLevel());
		}
	    }
		
	}
    }

    /**
     * Draws all walls using RoguePanel
     */
    public void drawAllWalls() {
      	for (int x= 0; x < canvas.getGridWidth()-1; x++) {
	    for (int y = 0; y < canvas.getGridHeight()-1; y++) {
		if(logicHandler.getObject(x,y) instanceof Wall)
		    canvas.drawWall(x, y, logicHandler.getLevel());
	    }
	}
    }
    
    /**                                                                              
     * Makes sure all items stay visible on the screen.
     */
    
    public void drawAllItems(){
	for (int x= 0; x < canvas.getGridWidth()-1; x++) {
	    for (int y = 0; y < canvas.getGridHeight()-1; y++) {
		if(logicHandler.getObject(x,y) instanceof Item)
		    canvas.drawItem(x,y, logicHandler.getItem(x,y));
	    }
	}
    }
    
    public void clearAllItems(){
	if (logicHandler.getLevel() != currentLevel){
	    for (int x= 0; x < canvas.getGridWidth()-1; x++) {
		for (int y = 0; y < canvas.getGridHeight()-1; y++) {
		    if(logicHandler.getObject(x,y) instanceof Item){
			logicHandler.deleteItem(x,y);
		    }
		}
	    }
	}
	currentLevel++;
    }
    
    
    
    
    
    /**
       Records the areas where the player has revealed
    */
    public void trackDiscovery(){
	
	//x and y coordinates of player
	int playerX = logicHandler.getPlayerPosition()[0];
	int playerY = logicHandler.getPlayerPosition()[1];

	//records the current x,y, position
	discoveredArea[playerX][playerY] = 1;
	//records all areas 2 spaces around the current position
	for(int i = -2; i <= 2; i++){
	    for(int j = -2; j <= 2; j++){
		//Ensures it will not access out of bounds array exception
		if( ! (playerX+i < 0 ||
		       playerX+i >= canvas.getGridWidth()-1 ||
		       playerY+j < 0 ||
		       playerY+j >= canvas.getGridHeight()-1   ) ){
		    //If the specified area has not been discovered (i.e. != 1)
		    if(discoveredArea[playerX+i][playerY+j] != 1){
			discoveredArea[playerX+i][playerY+j] = 1;
		    }
		}//if
	    }//for(j)
	}//for(i)
    }



    
    /**
     * Checks to see if player is dead, and store score into txt file for HighScores
     * 
     */
    public void checkPlayerStatus(){
	int[] array= new int[5];
	int a  = 0;
	if( logicHandler.getGameOver() == true){
	    canvas.clear();
	    // display the HighScore after game is over by reading from Score.txt...
	    try{ 
		File myFile = new File( "Score.txt");
		FileReader fileReader = new FileReader("Score.txt");
		BufferedReader reader = new BufferedReader(fileReader);
		String line = null; 
		while((line = reader.readLine())!= null){
		    array[a]= Integer.parseInt(line);
		    a++;
		}
	    }catch (Exception ex){
		ex.printStackTrace();
	    }
	    canvas.displayLosingScreen(logicHandler.getPlayer().getScore(),array); 
	}
	// display the score and highScores after game is over and write the new highScore into Score.txt 
	if(logicHandler.playerIsDead()&& logicHandler.getGameOver() == false){
	    try{ 
		File myFile = new File( "Score.txt");
		FileReader fileReader = new FileReader("Score.txt");
		BufferedReader reader = new BufferedReader(fileReader);
		String line = null; 
		while((line = reader.readLine())!= null){
		    array[a]= Integer.parseInt(line);
		    a++;
		}
	    }catch (Exception ex){
		ex.printStackTrace();
	    }
	    // updating the Score.txt file after getting new highScore
	    int temp=0;
	    int temp2 = 0;
	    for(int count = 0;count <5;count++){
		if(array[count] < logicHandler.getPlayer().getScore()){
		    temp = array[count];
		    array[count] = logicHandler.getPlayer().getScore();
		    if( count != 4){
			for( int c = count+1; count < 5; count++){
			    temp2 = array[c];
			    array[c] = temp;
			    temp = temp2;
			}
		    }
		    break;
		}
	    }
	    
	    try{
		FileWriter writer = new FileWriter("Score.txt");
		for( int b = 0 ; b< 5;b++){
		    writer.write(""+array[b]+ "\n");
		}
		writer.close();
	    }catch(IOException ex){
		ex.printStackTrace();
	    }
	    canvas.clear();
	    canvas.displayLosingScreen(logicHandler.getPlayer().getScore(),array);
	    logicHandler.setGameOver(true);
	}
	
	
	
    }
    
    /**
     * Check to see if all monsters are dead and creates more monsters!!! OMG!!
     */
    public void checkAllMonsterStatus(){
	int gridWidth, gridHeight;
	Monster mon[][] = logicHandler.getMonsters();
	gridHeight = canvas.getGridHeight();
	gridWidth = canvas.getGridWidth();
	
	for (int xOrig = 0; xOrig < gridWidth; xOrig++) {	  
	    for (int yOrig = 0; yOrig < gridHeight; yOrig++) {
		if(mon[xOrig][yOrig]!=null){
		    return;
		}
	    }
	}
	//If all monsters are defeated, created new monsters and increase the level
 	logicHandler.setLevel(logicHandler.getLevel()+1);//Increments level
	logicHandler.setMaxNumOfMonsters(logicHandler.getMaxNumOfMonsters()+1);//Increases monster count
	discoveredArea = new int[ canvas.getGridWidth() ][ canvas.getGridHeight()-1 ];//resets exploration
	logicHandler.createMonster();//creates monsters
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
    public void keyPressed(KeyEvent key){	


	//WASD moves
	origX = x; 
	origY = y;

	Player player = logicHandler.getPlayer();
	switch (key.getKeyChar()){
		//moving in 4 directions
		case 'w': case '8':	 this.y = this.y - player.getSpeed(); break;
		case 'a': case '4':  this.x = this.x - player.getSpeed(); break;
		case 'd': case '6':	 this.x = this.x + player.getSpeed(); break;
		case 's': case '2':	 this.y = this.y + player.getSpeed(); break;
		
		
		//moving diagonally
		case '9'/*up*/	  :	 this.y = this.y - player.getSpeed(); 
				/*right*/ 	 this.x = this.x + player.getSpeed(); break;
		case '7'/*up*/	  :	 this.y = this.y - player.getSpeed(); 
				/*left*/     this.x = this.x - player.getSpeed(); break;
		case '1'/*down*/  :	 this.y = this.y + player.getSpeed();
				/*left*/     this.x = this.x - player.getSpeed(); break;
		case '3'/*down*/  :	 this.y = this.y + player.getSpeed();
				/*right*/ 	 this.x = this.x + player.getSpeed(); break;
				
		//does nothing on rest
		case '5'/*resting*/: break;
		
							 
		default			  :	 return;
	}

	canvas.clear();
	drawAllWalls();
	//Writes last received input.
	canvas.write(key.getKeyChar(),7,23,RoguePanel.white,RoguePanel.black);
	moveHero();
	moveMonster();


	checkPlayerStatus();
	checkAllMonsterStatus();
	trackDiscovery();

	canvas.recordShadows(discoveredArea);
	if(logicHandler.getGameOver()==false)
	    canvas.setInGame(true);
	else
	    canvas.setInGame(false);
	canvas.repaint();
    }
	
    /**
     * Method required by the KeyListener interface.
     * Doesn't do anything yet.
     */
    public void keyReleased(KeyEvent key){
		
    }
	

    /**
     * Method required by the KeyListener interface.
     * Doesn't do anything yet.
     */
    public void keyTyped(KeyEvent key){
		
    }

    public static void goToLosingScreen(){
	RogueController mainControl = new RogueController();
	mainControl.setVisible(true);
	mainControl.setLocationRelativeTo(null);
	mainControl.logicHandler.setGameOver(true);
	mainControl.checkPlayerStatus();
    }


    public static void main(String[] args){
	RogueController mainControl = new RogueController();
	mainControl.setVisible(true);
	mainControl.setLocationRelativeTo(null); // center the window
		
	//Initially fills the map with monsters
	mainControl.logicHandler.createMonster();

	//Screen that shows after game is opened
	mainControl.canvas.write("MOVE WITH W A S D or the numpad. Eat monsters to earn points.",9,12,RoguePanel.white,RoguePanel.black);

		
		
    }//Main Delimit
	
}//Class Delimit
