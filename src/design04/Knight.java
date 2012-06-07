package design04;

import java.util.ArrayList;
import java.util.List;

public class Knight extends Piece {
	private final int KNIGHT_MOVE_A = 2; 
	private final int KNIGHT_MOVE_B = 1;
	//a knight moves 2 spaces in one axis and 1 space perpendicular to that axis
  
    public Knight(Board b, Boolean whiteInput, Coordinate start){
        chess = b;
        white = whiteInput;
        position = start;
    }

    public List<Coordinate> hypotheticalMoves() {
      List<Coordinate> moves = new ArrayList<Coordinate>();
      moves.add(new Coordinate(position.getX() + KNIGHT_MOVE_A, position.getY() + KNIGHT_MOVE_B));
      moves.add(new Coordinate(position.getX() + KNIGHT_MOVE_A, position.getY() - KNIGHT_MOVE_B));
      moves.add(new Coordinate(position.getX() - KNIGHT_MOVE_A, position.getY() + KNIGHT_MOVE_B));
      moves.add(new Coordinate(position.getX() - KNIGHT_MOVE_A, position.getY() - KNIGHT_MOVE_B));
      
      moves.add(new Coordinate(position.getX() + KNIGHT_MOVE_B, position.getY() + KNIGHT_MOVE_A));
      moves.add(new Coordinate(position.getX() + KNIGHT_MOVE_B, position.getY() - KNIGHT_MOVE_A));
      moves.add(new Coordinate(position.getX() - KNIGHT_MOVE_B, position.getY() + KNIGHT_MOVE_A));
      moves.add(new Coordinate(position.getX() - KNIGHT_MOVE_B, position.getY() - KNIGHT_MOVE_A));
	  return moves;

    }
    //knight have 8 possible moves it is up to cleanMoves to check if the moves are on the board/blocked

    		  
    public String toString(){
        return "n" + super.colourString();
    }
}