package edu.ucsb.cs56.projects.games.roguelike;

/**
 *This class represents the various pieces in game
 *it could be a monster, player, or nothing
 *@author Hans Marasigan & Richard Nguyen
 *@version cs56 s13
 */

public class GamePiece {
    
    private String typeOfPiece="";
    
    
    /**
     * Creates a game piece that is nothing. This would mean it is a free space
     *that another peice could go on.
     */
    public GamePiece(){
	typeOfPiece="nothing";
    }
    /**
     *Creates a game piece that the user/game creates
     *@param newTypeOfPiece This is the type of the piece(monster or player or other new features will be added later)
     *
     */
    public GamePiece(String newTypeOfPiece){
	typeOfPiece = newTypeOfPiece;
    }
    /**
     *This is the getter to figure out what piece it is.
     */
    public String getTypeOfPiece(){
	return this.typeOfPiece;
    }
    
    /**
     *This is the setter for the TypeOfPiece it will be
     *@param newTypeOfPiece is the type of piece that will be in the game
     */
    public void setTypeOfPiece(String newTypeOfPiece){
	this.typeOfPiece=newTypeOfPiece;
    }
    
    
    
}
