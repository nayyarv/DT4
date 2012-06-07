package design04;

import java.util.ArrayList;
import java.util.List;



public class Queen extends Piece{

    public Queen(Board b, Boolean whiteInput, Coordinate start){
        chess = b;
        white = whiteInput;
        position = start;
        //System.out.println("Creating a rook :)");
    }
    

    public List<Coordinate> hypotheticalMoves(){
    	List<Coordinate> moves = new ArrayList<Coordinate>();
        int direction = position.UP;
        while (direction < position.NUM_DIRECTIONS) {
        	Coordinate temp = new Coordinate (position);
	        while(temp.isOnBoard()){
	        	int increment=1;
	        	temp.shiftCoordinate(direction,increment);
	            moves.add(new Coordinate(temp));
	            if(temp.isOnBoard() && !chess.isSquareEmpty(temp)){
	                    break;
	            }
  
	        }
	        direction += position.TURN_45_DEGREES;
        }
        return moves;
    }
    //checks all 8 possible directions of movement for the queen and adds a coordinate to the list 
    //it stops checking a certain direction when 
    
    
    public String toString(){
        return "q"+super.colourString();
    }
}
