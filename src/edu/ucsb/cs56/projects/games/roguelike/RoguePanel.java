package edu.ucsb.cs56.projects.games.roguelike;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.LookupOp;
import java.awt.image.ShortLookupTable;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.JButton;


/**
 * Basic Grid of Ascii character used to represent a "floor" of the "dungeon"
 * @author Clayven Anderson and Trystan Spangler(provided tutorial on roguelike grids and some code)
 * @author Jonathan Tan
 * @author Rick Lee
 *
 */

public class RoguePanel extends JPanel
{
 // private static final long serialVersionUID = L;
  
  
  // list of colors our grid will use
  public static Color white = new Color(0xFFFFFF);
  public static Color black = new Color(0x000000);
  public static Color red = new Color(0xFF0000);
  public static Color blue = new Color(0x0000FF);
  public static Color cyan = new Color(0x00FFFF);
  public static Color green = new Color(0x00FF00);
  public static Color yellow = new Color(0xFFFF00);
  public static Color magenta = new Color(0xFF00FF);
  public static Color gray = new Color(0x808080);
  public static Color brown = new Color(0x663300);
    //Array of colors that change the color of the ground with each level
    public static Color[] groundColor = new Color[] 
	{gray,white,yellow,green,cyan,blue,magenta,brown}; //first level starts at index 1
    
  
  //attributes for handling things such as the Background and Foreground colors
  //as well as character placement
  private Image offscreenBuffer;
  private Graphics offscreenGraphics;
  private char[][] chars;
  private int charHeight = 16;
  private int charWidth = 9;
  private int gridHeight;
  private int gridWidth;
  private int Xcoord;
  private int Ycoord;
  private BufferedImage glyphSprite;
  private BufferedImage[] glyphs;
  private Color defaultBackgroundColor = black;
  private Color defaultForegroundColor = white;
  private Color[][] backgroundColors;
  private Color[][] foregroundColors;
  private char[][] oldChars;
  private Color[][] oldBackgroundColors;
  private Color[][] oldForegroundColors;
 
    private int[][] discoveredArea;
    private boolean inGame;//whether the player is playing the game for shadows to be drawn

  
 // char [][] floor = new char [40][40];
  
  
  
  /**
   * @return the chars
   */
  public char[][] getChars()
  {
    return chars;
  }
  /**
   * @param chars the chars to set
   */
  public void setChars(char[][] chars)
  {
    this.chars = chars;
  }
  /**
   * @return the charHeight
   */
  public int getCharHeight()
  {
    return charHeight;
  }
  /**
   * sets the height of a character. Measured in pixels. 
   * @param charHeight the charHeight to set
   */
  public void setCharHeight(int charHeight)
  {
    this.charHeight = charHeight;
  }
  /**
   * @return the charWidth
   */
  public int getCharWidth()
  {
    return charWidth;
  }
  /**
   * sets the width of a character. Measured in pixels.
   * @param charWidth the charWidth to set
   */
  public void setCharWidth(int charWidth)
  {
    this.charWidth = charWidth;
  }
  /**
   * @return the gridHeight
   */
  public int getGridHeight()
  {
    return gridHeight;
  }
  /**
   * set the height of the grid. Measured in characters.
   * @param gridHeight the gridHeight to set
   */
  public void setGridHeight(int gridHeight)
  {
    this.gridHeight = gridHeight;
  }
  /**
   * @return the gridWidth
   */
  public int getGridWidth()
  {
    return gridWidth;
  }
  /**
   * set the width of the grid. Measured in characters.
   * @param gridWidth the gridWidth to set
   */
  public void setGridWidth(int gridWidth)
  {
    this.gridWidth = gridWidth;
  }
  /**
   * @return the xcoord
   */
  public int getXcoord()
  {
    return Xcoord;
  }
  /**Sets the X coordinate for where the character is draw, must be within the size or the frame
   * @param xcoord the xcoord to set
   */
  public void setXcoord(int xcoord)
  {
    if (xcoord < 0 || xcoord >= gridWidth)
      throw new IllegalArgumentException("Xcoord " + Xcoord + " must be within range [0," + gridWidth + ")." );
    Xcoord = xcoord;
  }
  /**
   * @return the ycoord
   */
  public int getYcoord()
  {
    return Ycoord;
  }
  /**
   * Set the Y coordinate for where the character is to be drawn, must be within the size of the frame
   * @param ycoord the ycoord to set
   */
  public void setYcoord(int ycoord)
  {
    if (ycoord < 0 || ycoord >= gridHeight)
      throw new IllegalArgumentException("Ycoord " + Ycoord + " must be within range [0," + gridHeight + ")." );
    Ycoord = ycoord;
  }
 
  /**
   * sets the coordinates of where we want to draw of character
   * @param x the x coordinate
   * @param y the y coordinate
   */
  public void setCoords(int x, int y){
    setXcoord(x);
    setYcoord(y); 
  }
  
  /**
   * @return the defaultBackgroundColor
   */
  public Color getDefaultBackgroundColor()
  {
    return defaultBackgroundColor;
  }
  /**
   * @param defaultBackgroundColor the defaultBackgroundColor to set
   */
  public void setDefaultBackgroundColor(Color defaultBackgroundColor)
  {
    if (defaultBackgroundColor == null)
      throw new NullPointerException("defaultBackgroundColor must not be null.");
    this.defaultBackgroundColor = defaultBackgroundColor;
  }
  /**
   * @return the defaultForegroundColor
   */
  public Color getDefaultForegroundColor()
  {
    return defaultForegroundColor;
  }
  /**
   * @param defaultForegroundColor the defaultForegroundColor to set
   */
  public void setDefaultForegroundColor(Color defaultForegroundColor)
  {
    if (defaultForegroundColor == null)
      throw new NullPointerException("defaultForegroundColor must not be null.");
    this.defaultForegroundColor = defaultForegroundColor;
  }
  /**
   * @return the backgroundColors
   */
  public Color[][] getBackgroundColors()
  {
    return backgroundColors;
  }
  /**
   * @param backgroundColors the backgroundColors to set
   */
  public void setBackgroundColors(Color[][] backgroundColors)
  {
    this.backgroundColors = backgroundColors;
  }
  /**
   * @return the foregroundColors
   */
  public Color[][] getForegroundColors()
  {
    return foregroundColors;
  }
  /**
   * @param foregroundColors the foregroundColors to set
   */
  public void setForegroundColors(Color[][] foregroundColors)
  {
    this.foregroundColors = foregroundColors;
  }
  /**
   * @return the oldChars
   */
  public char[][] getOldChars()
  {
    return oldChars;
  }
  /**
   * @param oldChars the oldChars to set
   */
  public void setOldChars(char[][] oldChars)
  {
    this.oldChars = oldChars;
  }
  /**
   * @return the oldBackgroundColors
   */
  public Color[][] getOldBackgroundColors()
  {
    return oldBackgroundColors;
  }
  /**
   * @param oldBackgroundColors the oldBackgroundColors to set
   */
  public void setOldBackgroundColors(Color[][] oldBackgroundColors)
  {
    this.oldBackgroundColors = oldBackgroundColors;
  }
  /**
   * @return the oldForegroundColors
   */
  public Color[][] getOldForegroundColors()
  {
    return oldForegroundColors;
  }
  /**
   * @param oldForegroundColors the oldForegroundColors to set
   */
  public void setOldForegroundColors(Color[][] oldForegroundColors)
  {
    this.oldForegroundColors = oldForegroundColors;
  }
    /**
       @return the inGame
    */
    public boolean getInGame(){
	return inGame;
    }
    /**
       @return b the boolean to set
    */
    public void setInGame(boolean b){
	inGame = b;
    }



  
  /**
   * Creates a grid of size 80 x 24 chars
   */
  public RoguePanel(){
    this(80,24);
  }
  
  /**
   * Creates a grid of a specified width and height
   * @param width
   * @param height
   */
  public RoguePanel(int width, int height)
  {
    super();

    if (width < 1)
        throw new IllegalArgumentException("width " + width + " must be greater than 0." );

    if (height < 1)
        throw new IllegalArgumentException("height " + height + " must be greater than 0." );

    gridWidth = width;
    gridHeight = height;
    setPreferredSize(new Dimension(charWidth * gridWidth, charHeight * gridHeight));

    defaultBackgroundColor = black;
    defaultForegroundColor = white;

    chars = new char[gridWidth][gridHeight];
    backgroundColors = new Color[gridWidth][gridHeight];
    foregroundColors = new Color[gridWidth][gridHeight];

    oldChars = new char[gridWidth][gridHeight];
    oldBackgroundColors = new Color[gridWidth][gridHeight];
    oldForegroundColors = new Color[gridWidth][gridHeight];

    glyphs = new BufferedImage[256];

    discoveredArea = new int[gridWidth][gridHeight-1];
    inGame = false;

    loadGlyphs();
    
    RoguePanel.this.clear();
  }
  
  @Override
  public void update(Graphics g) {
       paint(g); 
  } 

  @Override
  public void paint(Graphics g) {
      if (g == null)
          throw new NullPointerException();
      
      if (offscreenBuffer == null){
          offscreenBuffer = createImage(this.getWidth(), this.getHeight()); 
          offscreenGraphics = offscreenBuffer.getGraphics();
      }
      
      for (int x = 0; x < gridWidth; x++) {
          for (int y = 0; y < gridHeight; y++) {
            if (oldBackgroundColors[x][y] == backgroundColors[x][y]
             && oldForegroundColors[x][y] == foregroundColors[x][y]
             && oldChars[x][y] == chars[x][y])
              continue;
            
              Color bg = backgroundColors[x][y];
              Color fg = foregroundColors[x][y];

              LookupOp op = setColors(bg, fg);
              BufferedImage img = op.filter(glyphs[chars[x][y]], null);
              offscreenGraphics.drawImage(img, x * charWidth, y * charHeight, null);
              
              oldBackgroundColors[x][y] = backgroundColors[x][y];
	      oldForegroundColors[x][y] = foregroundColors[x][y];
	      oldChars[x][y] = chars[x][y];

          }
      }
     

      g.drawImage(offscreenBuffer,0,0,this);
      
      
      if(inGame){
	  //draw shadows that cover undiscovered areas
	  for(int x = 0; x < gridWidth; x++){
	      for(int y = 0; y < gridHeight-1; y++){
		  if(discoveredArea[x][y] != 1){
		      g.setColor(backgroundColors[x][y]);
		      g.fillRect(x*charWidth,y*charHeight,charWidth,charHeight);
		  }//if
	      }//for
	  }//for
      }//if
      
  }
  
 private void loadGlyphs() {
    try {
        glyphSprite = ImageIO.read(RoguePanel.class.getResource("cp437.png"));
    } catch (IOException e) {
        System.err.println("loadGlyphs(): " + e.getMessage());
    }

    for (int i = 0; i < 256; i++) {
        int sx = (i % 32) * charWidth + 8;
        int sy = (i / 32) * charHeight + 8;

        glyphs[i] = new BufferedImage(charWidth, charHeight, BufferedImage.TYPE_INT_ARGB);
        glyphs[i].getGraphics().drawImage(glyphSprite, 0, 0, charWidth, charHeight, sx, sy, sx + charWidth, sy + charHeight, null);
    }
}

/**
 * Create a <code>LookupOp</code> object (lookup table) mapping the original 
 * pixels to the background and foreground colors, respectively. 
 * @param bgColor the background color
 * @param fgColor the foreground color
 * @return the <code>LookupOp</code> object (lookup table)
 */
private LookupOp setColors(Color bgColor, Color fgColor) {
    short[] a = new short[256];
    short[] r = new short[256];
    short[] g = new short[256];
    short[] b = new short[256];

    byte bgr = (byte) (bgColor.getRed());
    byte bgg = (byte) (bgColor.getGreen());
    byte bgb = (byte) (bgColor.getBlue());

    byte fgr = (byte) (fgColor.getRed());
    byte fgg = (byte) (fgColor.getGreen());
    byte fgb = (byte) (fgColor.getBlue());

    for (int i = 0; i < 256; i++) {
        if (i == 0) {
            a[i] = (byte) 255;
            r[i] = bgr;
            g[i] = bgg;
            b[i] = bgb;
        } else {
            a[i] = (byte) 255;
            r[i] = fgr;
            g[i] = fgg;
            b[i] = fgb;
        }
    }

    short[][] table = {r, g, b, a};
    return new LookupOp(new ShortLookupTable(0, table), null);
}
  
    /**
     * Clear the entire screen to whatever the default background color is.
     * @return this for convenient chaining of method calls
     */
    public RoguePanel clear() {
        return clear(' ', 0, 0, gridWidth, gridHeight, defaultForegroundColor, defaultBackgroundColor);
    
    }
    /**
     * Clear the character at int x,y to whatever the default background color is.
     * @return this for convenient chaining of method calls
     */
    public RoguePanel clear(int x, int y){
    	  return clear(' ', x, y, 1, 1, defaultForegroundColor, defaultBackgroundColor);
    }

    /**
     * Clear the section of the screen with the specified character and whatever the specified foreground and background colors are.
     * @param character  the character to write
     * @param x          the distance from the left to begin writing from
     * @param y          the distance from the top to begin writing from
     * @param width      the height of the section to clear
     * @param height     the width of the section to clear
     * @param foreground the foreground color or null to use the default
     * @param background the background color or null to use the default
     * @return this for convenient chaining of method calls
     */
    public RoguePanel clear(char character, int x, int y, int width, int height, Color foreground, Color background) {
        if (character < 0 || character >= glyphs.length)
            throw new IllegalArgumentException("character " + character + " must be within range [0," + glyphs.length + "]." );

        if (x < 0 || x >= gridWidth)
            throw new IllegalArgumentException("x " + x + " must be within range [0," + gridWidth + ")" );

        if (y < 0 || y >= gridHeight)
            throw new IllegalArgumentException("y " + y + " must be within range [0," + gridHeight + ")" );

        if (width < 1)
            throw new IllegalArgumentException("width " + width + " must be greater than 0." );

        if (height < 1)
            throw new IllegalArgumentException("height " + height + " must be greater than 0." );

        if (x + width > gridWidth)
            throw new IllegalArgumentException("x + width " + (x + width) + " must be less than " + (gridWidth + 1) + "." );

        if (y + height > gridHeight)
            throw new IllegalArgumentException("y + height " + (y + height) + " must be less than " + (gridHeight + 1) + "." );

        for (int xo = x; xo < x + width; xo++) {
            for (int yo = y; yo < y + height; yo++) {
                write(character, xo, yo, foreground, background);
            }
        }
        return this;
    }

    /**
     * Write a character to the cursor's position.
     * This updates the cursor's position.
     * @param character  the character to write
     * @return this for convenient chaining of method calls
     */
    public RoguePanel write(char character) {
        if (character < 0 || character >= glyphs.length)
            throw new IllegalArgumentException("character " + character + " must be within range [0," + glyphs.length + "]." );

        return write(character, Xcoord, Ycoord, defaultForegroundColor, defaultBackgroundColor);
    }
    
    /**
     * Write a string to the specified position with the specified foreground and background colors.
     * This updates the cursor's position but not the default foreground or background colors.
     * @param string     the string to write
     * @param x          the distance from the left to begin writing from
     * @param y          the distance from the top to begin writing from
     * @param foreground the foreground color or null to use the default
     * @param background the background color or null to use the default
     * @return this for convenient chaining of method calls
     */
    public RoguePanel write(String string, int x, int y, Color foreground, Color background) {
        if (string == null)
            throw new NullPointerException("string must not be null." );
        
        if (x + string.length() >= gridWidth)
            throw new IllegalArgumentException("x + string.length() " + (x + string.length()) + " must be less than " + gridWidth + "." );

        if (x < 0 || x >= gridWidth)
            throw new IllegalArgumentException("x " + x + " must be within range [0," + gridWidth + ")." );

        if (y < 0 || y >= gridHeight)
            throw new IllegalArgumentException("y " + y + " must be within range [0," + gridHeight + ")." );

        if (foreground == null)
            foreground = defaultForegroundColor;

        if (background == null)
            background = defaultBackgroundColor;

        for (int i = 0; i < string.length(); i++) {
            write(string.charAt(i), x + i, y, foreground, background);
        }
        return this;
    }
    /**
     * Write a character to the specified position with the specified foreground and background colors.
     * This updates the cursor's position but not the default foreground or background colors.
     * @param character  the character to write
     * @param x          the distance from the left to begin writing from
     * @param y          the distance from the top to begin writing from
     * @param foreground the foreground color or null to use the default
     * @param background the background color or null to use the default
     * @return this for convenient chaining of method calls
     */
    public RoguePanel write(char character, int x, int y, Color foreground, Color background) {
        if (character < 0 || character >= glyphs.length)
            throw new IllegalArgumentException("character " + character + " must be within range [0," + glyphs.length + "]." );

        if (x < 0 || x >= gridWidth){
            throw new IllegalArgumentException("x " + x + " must be within range [0," + gridWidth + ")" );
        }
        if (y < 0 || y >= gridHeight){
            throw new IllegalArgumentException("y " + y + " must be within range [0," + gridHeight + ")" );
        }
        if (foreground == null) foreground = defaultForegroundColor;
        if (background == null) background = defaultBackgroundColor;

        chars[x][y] = character;
        foregroundColors[x][y] = foreground;
        backgroundColors[x][y] = background;
        if(character=='@'){
        Xcoord = x + 1;
        Ycoord = y;
        }
        return this;
    }
    
	/**
	 * Draw an "@" symbol at x,y using the RoguePanel's write(string,int,int,color,color) method.
	 */
	
	public void drawChar(int xPos, int yPos){
		write("@",xPos,yPos,RoguePanel.white,RoguePanel.black);
	}
    
	/**
	 * Draw HUD: text for information like the last read input, x and y coordinate of the character.
	 * Prints the x and y coordinates of the character.
	 */
	   

	public void drawHUD(){
		write("Input:",0,23,RoguePanel.white,RoguePanel.black);
		write("X:",10,23,RoguePanel.white,RoguePanel.black);
		write("Y:",14,23,RoguePanel.white,RoguePanel.black);
		write("Hp:",20,23,RoguePanel.white,RoguePanel.black);
    write("Ap:",27,23,RoguePanel.white,RoguePanel.black);
		write("Level:",33,23,RoguePanel.white,RoguePanel.black);
		write("Score:",43,23,RoguePanel.white,RoguePanel.black);
	}
    
	/**
	 * moves the player to position xPosition,yPosition and updates its hp using write
	 */
    public void moveHeroAnimated(int xPosition, int yPosition, int hp, int ap, int level, int score){
		
		drawHUD();
		
		try{
			write("@",xPosition,yPosition,RoguePanel.white,RoguePanel.black);
		}catch(Exception ex){
			write("HERE BE DRAGONS",0,22,RoguePanel.red,RoguePanel.black);
		}
		
		write(""+xPosition,12,23,RoguePanel.white,RoguePanel.black);
		write(""+yPosition,16,23,RoguePanel.white,RoguePanel.black);
		write(""+hp+ " ",22,23,RoguePanel.white,RoguePanel.black);
    write(""+ap+ " ",29,23,RoguePanel.white,RoguePanel.black);
		write(""+level+ " ",39,23,RoguePanel.white,RoguePanel.black);
		write(""+score+ " ",49,23,RoguePanel.white,RoguePanel.black);
	}
	
    public void drawItem(int xPosition, int yPosition, Item i){
		
	     write(i.getIcon(),xPosition,yPosition,RoguePanel.white,RoguePanel.black);
		
	 }

	/**
	 *moves the monster to position xPosition,yPosition
	 * Prints the x and y coordinates of the character.
	 */
    public void moveMonster(int xPosition, int yPosition, GamePiece piece){
		
	write(piece.getIcon(),xPosition,yPosition,RoguePanel.red,RoguePanel.black);
		
	}
	
	/**
	 * display the you were hit flag
	 */
	public void monsterAttack(){
		write("You were hit",60,23,RoguePanel.yellow,RoguePanel.black);
		
	}

    /**
     * display that the player has advanced to the next level
     */
    public void nextLevel(){
	write("NEXT LEVEL!",60,23,RoguePanel.yellow,RoguePanel.black);
    }
	
	/**
	 * displays the losing screen with player's score and HighScores
	 */
    public void displayLosingScreen(int score,int[] array){
	write("To play again: close this window and press play on the main menu.", 7,10,RoguePanel.green,RoguePanel.black);
		write("YOU LOSE",35,6,RoguePanel.red,RoguePanel.black);
		write("Score:"+score,35,14,RoguePanel.white,RoguePanel.black);
		write("High Scores", 35,16,RoguePanel.white,RoguePanel.black);
		int b = 17;
		int rank = 1;
		for( int a: array){
		    write("" + rank +":" + a, 40,b,RoguePanel.white,RoguePanel.black);
		    b++;
		    rank++;
		}
    
    }	
	/**
	 * displays the winning screen
	 */
	public void displayWinningScreen(){
		write("YOU WIN",40,12,RoguePanel.green,RoguePanel.black);
	}
	
    public void emptySpace(int xPosition, int yPosition, int colorNum){
		write("_",xPosition,yPosition,groundColor[colorNum%groundColor.length],RoguePanel.black);
	}

    /**
       Covers the areas where the player has not discovered yet
    */
    public void recordShadows(int[][] shadow){
	discoveredArea = shadow;
    }


    

}
