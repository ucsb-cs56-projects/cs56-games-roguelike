package edu.ucsb.cs56.projects.games.roguelike;

/**
 *This class represents the various pieces in game
 *it could be a monster, player, or nothing
 *@author Hans Marasigan & Richard Nguyen
 *@version cs56 s13
 */

public interface GamePiece {

    /**
     *This is the getter to figure out what piece it is.
     */
    public String getTypeOfPiece();
    
    /**
     *This is the setter for the TypeOfPiece it will be
     *@param newTypeOfPiece is the type of piece that will be in the game
     */
    public void setTypeOfPiece(String newTypeOfPiece);    
    
    
    /**
     *This is the getter to figure out what piece icon it is.
     */
    public char getIcon();
    
    /**
     *This is the setter for the Icon it will be
     *@param NewIcon is the icon of piece that will be in the game
     */
    public void setIcon(char NewIcon);    
    
    
}
