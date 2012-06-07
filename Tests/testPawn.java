import java.util.ArrayList;
import java.util.List;


public class testPawn implements Test {

	public void run() {
		Board board = new Board();
		Coordinate one = new Coordinate (2,6);
		Coordinate two = new Coordinate (1,7);
		Piece whitePawn = new Pawn(board,true,one);
		Piece blackKing = new King(board,false,two);
		board.insertPiece(whitePawn, one);
		board.insertPiece(blackKing, two);
		
		List<Coordinate> moves = whitePawn.getValidMoves();
		List<Coordinate> test = new ArrayList<Coordinate>();
		test.add(new Coordinate(1,7));
		test.add(new Coordinate(2,7));
		System.out.println(moves.toString());
		//assert(moves.containsAll(test));
		moves.removeAll(test);
		//assert(moves.isEmpty());
	}
}
