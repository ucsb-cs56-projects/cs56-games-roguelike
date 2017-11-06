package edu.ucsb.cs56.projects.games.roguelike;

public class Wall implements GamePiece {
    private String typeOfPiece = "Wall";
    private char icon = '0';

    public String getTypeOfPiece() {
        return this.typeOfPiece;
    }

    public void setTypeOfPiece(String newTypeOfPiece) {
        this.typeOfPiece = newTypeOfPiece;
    }

    public char getIcon() {
        return this.icon;
    }

    public void setIcon(char NewIcon) {
        this.icon = NewIcon;
    }
    
}
