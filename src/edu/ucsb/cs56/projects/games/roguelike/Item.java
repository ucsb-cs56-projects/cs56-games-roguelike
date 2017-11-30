package edu.ucsb.cs56.projects.games.roguelike;

import java.util.Random;

/**
 * An Item class to represent Items in the Dungeon.
 *@author Hans Marasigan & Richard Nguyen
 *@version cs56 s13
 */


public class Item implements GamePiece {
    private int effect;
    private int[] position = new int[2];
    private int pointValue = 10;
    private boolean used;
    private String typeOfPiece = "";
    private char icon;
    private boolean itemHasDisplayed=false;

    /**
     *  Creates a default item with effect value of 10 that has not been used.
     *  This item is a Game piece that has an icon 'I'.
     */
    public Item() {
        this.effect = 10;
        this.used = false;
        this.setTypeOfPiece("item");
        this.setIcon('I');
    }
    
    /**
     *  Creates an item with an effect value of the user's choice that has not been used and is an item game piece with icon 'I'
     *  @param NewEffect This will be how much the item will effect the user.
     */
    public Item(int NewEffect) {
        this.effect = NewEffect;
        this.used = false;
        this.setTypeOfPiece("item");
        this.setIcon('I');
    }
    
    /**
     *Creates an item with the default effect value of 10 where the computer/player decides on whether it has been used. This item is a GamePiece with icon 'I'.
     *@param CanUse Tells whether the item has been used
     */
    public Item(boolean CanUse) {
        this.used = CanUse;
        this.effect = 10;
        this.setTypeOfPiece("item");
        this.setIcon('I');
    }

    /**
     * Getter: Gets the item's effect value.
     * @return The effect of this item
     */
    public int getEffect() {
        return this.effect;
    }
    /**
     * Setter: Sets the item's effect value.
     * @param NewEffect This is the value the computer/programmer can set.
     */
    public void setEffect(int NewEffect) {
        this.effect = NewEffect;
    }
    
    /**
     *Setter: This sets whether the item has been used or not.
     *@param use This is a true or false statement that tells whether the item has been used.
     */
    public void setUse(boolean use) {
        this.used = use;
    }
    
    /**
     * Getter: This returns whether or not the item has been used.
     * @return true If this item has been used, false if not
     */
    public boolean getUse() {
        return this.used;
    }
    
    /**
     * Getter: This returns what kind of piece it is.
     * @return Type of GamePiece
     */
    public String getTypeOfPiece() {
        return this.typeOfPiece;
    }
    
    /**
     *  Setter: This allows the computer/programmer to set what type of piece this will be.
     *  @param newTypeOfPiece This will be the name of this piece
     */
    public void setTypeOfPiece(String newTypeOfPiece) {
        this.typeOfPiece = newTypeOfPiece;
    }
    
    /**
     *Getter: Returns Game Piece icon character
     * @return character representing GamePiece
     */
    public char getIcon() {
        return this.icon;
    }
    
    /**
     *This is the setter for the Icon it will be
     *@param NewIcon is the icon of piece that will be in the game
     */ public void setIcon(char NewIcon) {
        this.icon = NewIcon;
    }
    
    /**
     *  This method uses the effect value to affect the player in some way.
     *  @param p the player to be affected by the item
    */
    public void UseEffect(Player p) {
        p.setScore(this.getEffect() + p.getScore());
    }

    /**
     *  Setter: This allows the computer/programmer to set boolean if item has displayed on HUD
     *  @param b This will be the boolean to determine if item has displayed on HUD. true= displayed on HUD, false = has not displayed on HUD.
     */
    public void setItemHasDisplayed(boolean b) {
        itemHasDisplayed = b;
    }

    /**
     * Getter: Returns boolean itemHasDisplayed 
     * @return boolean that tells user if item has displayed on HUD once 
    */
    boolean hasItemHUD_Displayed(){
	return itemHasDisplayed; 
    }
}


