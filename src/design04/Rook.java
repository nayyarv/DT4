package design04;

import java.util.ArrayList;
import java.util.List;



public class Rook extends Piece{

    public Rook(Board b, Boolean whiteInput, Coordinate start){
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
	        direction += position.TURN_90_DEGREES;
        }
        return moves;
    }
    //moves the rook up, down, left right until its coordinates are off the board
    //or unless its path is impeded by a piece the coordinate of the piece is also added
    // as a possible move
    
    
    public String toString(){
        return "r"+super.colourString();
    }
}
