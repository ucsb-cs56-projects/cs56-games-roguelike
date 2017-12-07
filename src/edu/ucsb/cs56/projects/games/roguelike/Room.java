package edu.ucsb.cs56.projects.games.roguelike;
/**
 * Class for holding information of a given room to be generated
*/
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

    /**
     * Constructor for creating new rooms.
     * @param x x coordinate for upper left corner of room
     * @param y y coordinate for upper left corner of room
     * @param w width of room to be drawn
     * @param h height of room to be drawn
     */
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
    
    /**
     * Getter: Returns initial x coordinate of room.
     * @return Initial x coordinate
     */
    public int getX1() {
        return this.x1;
    }

    /**
     * Getter: Returns final x coordinate of room.
     * @return Final x coordinate
     */
    public int getX2() {
        return this.x2;
    }

    /**
     * Getter: Returns initial y coordinate of room.
     * @return Initial y coordinate
     */
    public int getY1() {
        return this.y1;
    }

    /**
     * Getter: Returns final y coordinate of room.
     * @return final y coordinate
     */
    public int getY2() {
        return this.y2;
    }

    /**
     * Getter: Returns width of room to be drawn.
     * @return Width of room
     */
    public int getWidth() {
        return this.w;
    }

    /**
     * Getter: Returns height of room to be drawn.
     * @return Height of room
     */
    public int getHeight() {
        return this.h;
    }

    /**
     * Getter: Returns center x coordinate of room.
     * @return Center x coordinate
     */
    public int getCenterX() {
        return this.centerX;
    }

    /**
     * Getter: Returns cetner y coordinate of room.
     * @return Center y coordinate
     */
    public int getCenterY() {
        return this.centerY;
    }
    
    /**
     * Method to check whether two rooms intersect with each other.
     * @return true if this room intersects with provided Room
     */
    public boolean intersects(Room otherRoom) {
        return(this.x1 <= otherRoom.x2 && this.x2 >= otherRoom.x2 && this.y1 <= otherRoom.y2 && this.y2 >= otherRoom.y1);
    }

}
