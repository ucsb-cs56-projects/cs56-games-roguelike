package edu.ucsb.cs56.projects.games.roguelike;

import java.util.Random;

/**
* An Item class to represent Items in the Dungeon.
*@author Hans Marasigan & Richard Nguyen
*@version cs56 s13
*/


public class Item implements GamePiece{
    private int effect;
    private int[] position = new int[2];
    private int pointValue=10;
    private boolean used;
    private String typeOfPiece="";
    private char icon;

    /**
       creates a default item with effect value of 10
       and has not been used.
       and it is an item game piece 
       it has icon I
    */
    public Item(){
	this.effect=10;
	this.used=false;
	this.setTypeOfPiece("item");
	this.setIcon('I');
    }
    /**
       creates an item with an effect value of the user's choice
       and has not been used and is an item game piece with icon I
       @param NewEffect this will be how much the item will effect the user.
    */

    public Item(int NewEffect){
	this.effect=NewEffect;
	this.used=false;
	this.setTypeOfPiece("item");
	this.setIcon('I');
    }
    /** 
	creates an item with the default effect value of 10
	and the computer/player decides on whether it has been used
	and is an item game piece with icon I
	@param tells whether the item has been used
    */
    public Item(boolean CanUse){
	this.used=CanUse;
	this.effect=10;
	this.setTypeOfPiece("item");
	this.setIcon('I');
    }
    
    /** 
	gets the item's effect value
    */
    public int getEffect(){
	    return this.effect;
	}
    /**
       sets the item's effect value
       @param NewEffect this is the value the computer/programmer can set
    */
    public void setEffect(int NewEffect){
	this.effect=NewEffect;
    }
    /** 
	this sets whether the item has been used or not
	@param use this is a true or false statement that tells whether 
	the item has been used.
    */
    public void setUse(boolean use){
	this.used=use;
    }
    /**
       this gets whether or not the item has been used 
    */
    public boolean getUse(){
	return this.used;
    }
    /** 
	this tells what kind of piece it is
    */
    public String getTypeOfPiece(){
	return this.typeOfPiece;
    }
    /**
       this allows the computer/programmer to set what type of piece this will be
       @param newTypeOfPiece this will be the name of this piece
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
    

}
