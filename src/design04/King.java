package design04;

import java.util.ArrayList;
import java.util.List;

	/**
 * File Name:
 * Creator: Varun Nayyar
 * Date: 24/03/12
 * Desc:
 */
public class King extends Piece {
	private final int KING_MOVE = 1; 
	//a king can only move one space
  
    public King(Board b, Boolean whiteInput, Coordinate start){
        chess = b;
        white = whiteInput;
        position = start;
    }

    public List<Coordinate> hypotheticalMoves() {
      List<Coordinate> moves = new ArrayList<Coordinate>();
      int direction = position.UP;
      while (direction < position.NUM_DIRECTIONS) {
    	  Coordinate temp = new Coordinate(position);
    	  temp.shiftCoordinate(direction, KING_MOVE);
    	  temp.toString();
    	  moves.add(temp);
    	  direction+=position.TURN_45_DEGREES;
      }
	  return moves;

    }

    		  
    public String toString(){
        return "k" + super.colourString();
    }
}