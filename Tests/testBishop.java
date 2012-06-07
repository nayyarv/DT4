import java.util.ArrayList;
import java.util.List;


public class testBishop implements Test {

	public void run() {
		Board board = new Board();
		Coordinate one = new Coordinate (1,3);
		Coordinate two = new Coordinate (3,5);
		Piece whiteBishop = new Bishop(board,true,one);
		Piece blackKing = new King(board,false,two);
		board.insertPiece(whiteBishop, one);
		board.insertPiece(blackKing, two);
		
		List<Coordinate> moves = whiteBishop.getValidMoves();
		List<Coordinate> test = new ArrayList<Coordinate>();
		test.add(new Coordinate(0,2));
		test.add(new Coordinate(2,2));
		test.add(new Coordinate(0,4));
		test.add(new Coordinate(2,4));
		test.add(new Coordinate(3,1));
		test.add(new Coordinate(4,0));
		System.out.println(moves.toString());
		//assert(moves.containsAll(test));
		moves.removeAll(test);
		//assert(moves.isEmpty());
	}


}
