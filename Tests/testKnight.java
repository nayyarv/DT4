import java.util.ArrayList;
import java.util.List;


public class testKnight implements Test {

	public void run() {
		Board board = new Board();
		Coordinate one = new Coordinate (0,2);
		Coordinate two = new Coordinate (1,7);
		Piece whiteKnight = new Knight(board,true,one);
		Piece blackKing = new King(board,false,two);
		board.insertPiece(whiteKnight, one);
		board.insertPiece(blackKing, two);
		
		List<Coordinate> moves = whiteKnight.getValidMoves();
		List<Coordinate> test = new ArrayList<Coordinate>();
		test.add(new Coordinate(1,0));
		test.add(new Coordinate(1,2));
		test.add(new Coordinate(2,3));
		test.add(new Coordinate(1,4));
		System.out.println(moves.toString());
		//assert(moves.containsAll(test));
		moves.removeAll(test);
		//assert(moves.isEmpty());
	}
	
}
