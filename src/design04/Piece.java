package design04;

import java.util.ArrayList;
import java.util.List;

/**
 * File Name:
 * Creator: Varun Nayyar
 * Date: 23/03/12
 * Desc:
 */
public abstract class Piece {
    protected boolean white;
    protected Board chess;
    protected Coordinate position;
    private static final String WHITE_COLOUR_STRING = "l";
    private static final String BLACK_COLOUR_STRING = "d";
    //Not loving the protected, but it is the most efficient implementation
    /*
    The pieces should know their own colour
    and a pointer to the board
    But shouldn't have it as a field
    as it is common to every piece.
    Im not sure about protected - is there a nicer implementation??
    Or is protected being used properly here?
    */


    public boolean isWhite(){
        return white;
    }

    
    public String colourString(){
        if (white){
            return WHITE_COLOUR_STRING ;
        }else{
            return BLACK_COLOUR_STRING;
        }
    } //used for toString functions of each piece
    
    //This works by checking if the blackKings position is in the list of moves for that piece
    public boolean canMoveto(Coordinate destination){
        //Cant use contains - as Co-ord is a pointer;
        for(Coordinate searchOrd : getValidMoves()){//For all items in list
            if(destination.compareCoordTo(searchOrd)){//Check if it matches to destination
                return true;
            }
        }
        return false;
    }
    
    
    public List<Coordinate> getValidMoves(){
        return cleanMoves(hypotheticalMoves());


     }
    //returns a list of valid moves a given piece can make
    
    
    private List<Coordinate> cleanMoves(List<Coordinate> hypotheticalMoves) {
		List<Coordinate> removeList = new ArrayList<Coordinate>();
		for(Coordinate toBeRemoved : hypotheticalMoves) {
			if (!isMoveValid(toBeRemoved)) {
				removeList.add(toBeRemoved);
			}
		}
		for(Coordinate toBeRemoved: removeList) {
			hypotheticalMoves.remove(toBeRemoved);
		}
        //System.err.println(hypotheticalMoves.toString());
    	return hypotheticalMoves;
    }
    // cleanMoves and isMoveValid enforces the common rules of our chess game
    // e.g. cant move to a square occupied by your own piece
    //this saves on code duplication
    
    public void updatePos(Coordinate c){
        position = c;
    } // this allows piece to take care of themselves


    private boolean isMoveValid (Coordinate destination) {
      
      if (!destination.isOnBoard()) {
    	  return false;
          
      } 
      if (chess.isSquareEmpty(destination)) {
    	  return true;
      } else if (white!=chess.isPieceWhite(destination)) {
    	  return true;
      }
      return false;
    }
    //a legal move is when an empty square is on the game board
    // or the other case is when an occupied square is an opponents piece

    
    
    abstract List<Coordinate> hypotheticalMoves();
    //calculates possible moves given the piece's logic e.g. bishop moves on diagonals
    // this takes care of path logic e.g. queens cannot move past a piece
}
