package design04;

/**
 * File Name:
 * Creator: Varun Nayyar
 * Date: 23/03/12
 * Desc:
 */
public class Coordinate {
    private int x;
    private int y;
    public final int UP = 0;
    public final int TOP_RIGHT = 1;
    public final int RIGHT = 2;
    public final int BOTTOM_RIGHT = 3;
    public final int DOWN = 4;
    public final int BOTTOM_LEFT =5;
    public final int LEFT = 6;
    public final int TOP_LEFT = 7;
    public final int NUM_DIRECTIONS =8;
    public final int TURN_90_DEGREES = 2;
    public final int TURN_45_DEGREES = 1;
    // This allows us to move in multiple directions inside loops
    //It is actually quite nice


    
    private final static int BOARD_SIZE = 8;


    public Coordinate(int xCoord, int yCoord){
        x = xCoord;
        y = yCoord;
     }

    //I added an extra constructor - this is convenient at times
    public Coordinate(Coordinate c){
        x= c.getX();
        y=c.getY();
    }

    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    
    public void shiftCoordinate(int direction, int magnitude) {
    	if (direction == UP) {
    		x-=magnitude;
    	} else if (direction == TOP_RIGHT) {
    		x-=magnitude;
    		y+=magnitude;
    	} else if (direction == RIGHT) {
    		y+=magnitude;
    	} else if (direction == BOTTOM_RIGHT) {
    		x+=magnitude;
    		y+=magnitude;
    	} else if (direction == DOWN) {
    		x+=magnitude;
    	} else if (direction == BOTTOM_LEFT) {
    		x+=magnitude;
    		y-=magnitude;
    	} else if (direction == LEFT) {
    		y-=magnitude;
    	} else if (direction == TOP_LEFT) {
    		x-=magnitude;
    		y-=magnitude;
    	}
    } //solves the problem of having multiple while loops

    //Check that the coords are the same.
    public boolean compareCoordTo(Coordinate c){
        return (x==c.getX()&&y==c.getY());
    }



    public void setCoordto(int xord, int yord){
        x = xord;
        y = yord;
    }
    public void setCoordto(Coordinate c){
        x = c.getX();
        y = c.getY();
    }
    //Deprecated functions ^^ they were used at one point


    public boolean isOnBoard() {
        if (this.x>=0&&this.x<BOARD_SIZE&&this.y>=0&&this.y<BOARD_SIZE) {
          return true;
        }
        return false;
    }
    public String toString(){
        return "[x: " +x+ ", y: " +y+"]";
    }

}
