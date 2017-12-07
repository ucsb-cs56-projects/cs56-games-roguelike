package edu.ucsb.cs56.projects.games.roguelike;
/**
 * Class for the creation of walls within the game.
 * 
*/
public class Wall implements GamePiece {
    private String typeOfPiece = "Wall";
    private char icon = '0';

    /**
       Getter: Returns type of GamePiece object.
       @return GamePiece Object, "wall".
     */
    public String getTypeOfPiece() {
        return this.typeOfPiece;
    }

    /**
       Setter: Sets type of GamePiece object.
       @param newTypeOfPiece The new String value for the type of piece. 
     */
    public void setTypeOfPiece(String newTypeOfPiece) {
        this.typeOfPiece = newTypeOfPiece;
    }

    /**
     *@inheritDoc
     */
    public char getIcon() {
        return this.icon;
    }

    /**
     *@inheritDoc
     */
    public void setIcon(char NewIcon) {
        this.icon = NewIcon;
    }
}
