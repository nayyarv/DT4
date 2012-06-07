package design04;

import java.util.ArrayList;
import java.util.List;


public class Pawn extends Piece {
		//a pawn can only move one space
  
    public Pawn(Board b, Boolean whiteInput, Coordinate start){
        chess = b;
        white = whiteInput;
        position = start;
    }

    public List<Coordinate> hypotheticalMoves() {
        List<Coordinate> moves = new ArrayList<Coordinate>();
        int PAWN_MOVE;
        if (white){
            PAWN_MOVE = 1;
        } else {
            PAWN_MOVE =-1;
        }

        Coordinate topLeft = new Coordinate(position);
        topLeft.shiftCoordinate(position.TOP_LEFT, PAWN_MOVE);
        //System.err.println("Was at: "+position+ " TopLeft/BottomRight: "+topLeft);


        Coordinate up = new Coordinate(position);
        up.shiftCoordinate(position.UP, PAWN_MOVE);
        //System.err.println("Was at: "+position+ "Up/Down : "+up);

        Coordinate topRight = new Coordinate(position);
        topRight.shiftCoordinate(position.TOP_RIGHT, PAWN_MOVE);
        //System.err.println("Was at: "+position+ " TopRight/BottomLeft: "+topRight+"\n");

        if (topLeft.isOnBoard()&&!chess.isSquareEmpty(topLeft)) {
            moves.add(topLeft);
        }
        if (topRight.isOnBoard()&&!chess.isSquareEmpty(topRight)) {
            moves.add(topRight);
        }

        if (up.isOnBoard()&&chess.isSquareEmpty(up)) {
            moves.add(up);
        }

        return moves;

    }
    //checks if square above is empty
    //if true adds to possible move list
    //also check to top 2 diagonal square are occupied
    //if true also adds to list

    		  
    public String toString(){
        return "p"+super.colourString();
    }
}