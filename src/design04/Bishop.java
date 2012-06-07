package design04;

import java.util.ArrayList;
import java.util.List;



public class Bishop extends Piece{

    public Bishop(Board b, Boolean whiteInput, Coordinate start){
                chess = b;
        white = whiteInput;
        position = start;
        //System.out.println("Creating a rook :)");
    }


    public List<Coordinate> hypotheticalMoves(){
        List<Coordinate> moves = new ArrayList<Coordinate>();
        int direction = position.TOP_RIGHT;
        while (direction < position.NUM_DIRECTIONS) {
            Coordinate temp = new Coordinate (position);
            while(temp.isOnBoard()){
                int increment=1;
                temp.shiftCoordinate(direction,increment);
                moves.add(new Coordinate(temp));

                if(temp.isOnBoard()&&!chess.isSquareEmpty(temp)){
                    break;
                }

            }
            direction += position.TURN_90_DEGREES;
        }
        return moves;
    }
    
    
    public String toString(){
        return "b" + super.colourString();
    }
}

