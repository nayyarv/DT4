import java.util.ArrayList;
import java.util.List;


public class testRook implements Test {

	public void run() {
		Board board = new Board();
		Coordinate one = new Coordinate (0,0);
		Coordinate two = new Coordinate (0,2);
		Piece whiteRook= new Rook(board,true,one);
		Piece blackKing = new King(board,false,two);
		board.insertPiece(whiteRook, one);
		board.insertPiece(blackKing, two);
		
		List<Coordinate> moves = whiteRook.getValidMoves();
		List<Coordinate> test = new ArrayList<Coordinate>();
		test.add(new Coordinate(0,1));
		test.add(new Coordinate(0,2));
		test.add(new Coordinate(1,0));
		test.add(new Coordinate(2,0));
		test.add(new Coordinate(3,0));
		test.add(new Coordinate(4,0));
		test.add(new Coordinate(5,0));
		test.add(new Coordinate(6,0));
		test.add(new Coordinate(7,0));
		
		System.out.println(moves.toString());
		//assert(moves.containsAll(test));
		moves.removeAll(test);
		//assert(moves.isEmpty());
	}
}
