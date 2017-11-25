package edu.ucsb.cs56.projects.games.roguelike;

public class Room {
    // Holds values for grid coordinates for each cornor of the Room
    private int x1;
    private int x2;
    private int y1;
    private int y2;

    // Width and height of the Room
    private int w;
    private int h;

    // Center point of the room
    public int centerX;
    public int centerY;

    // Constructor for creating new rooms
    public Room(int x, int y, int w, int h) {
        this.x1 = x;
        this.x2 = x + w;
        this.y1 = y;
        this.y2 = y + h;
        this.w = w;
        this.h = h;
        this.centerX = (int)((x1+x2)/2);
        this.centerY = (int)((y1+y2)/2);
    }

    public int getX1() {
        return this.x1;
    }
    public int getX2() {
        return this.x2;
    }
    public int getY1() {
        return this.y1;
    }
    public int getY2() {
        return this.y2;
    }
    public int getWidth() {
        return this.w;
    }
    public int getHeight() {
        return this.h;
    }
    public int getCenterX() {
        return this.centerX;
    }
    public int getCenterY() {
        return this.centerY;
    }
    
    // return true if this room intersects with provided Room
    public boolean intersects(Room otherRoom) {
        return(this.x1 <= otherRoom.x2 && this.x2 >= otherRoom.x2 && this.y1 <= otherRoom.y2 && this.y2 >= otherRoom.y1);
    }

}
