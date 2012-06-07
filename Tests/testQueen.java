import java.util.ArrayList;
import java.util.List;


public class testQueen implements Test {

	public void run() {
		Board board = new Board();
		Coordinate one = new Coordinate (0,0);
		Coordinate two = new Coordinate (7,7);
		Piece whiteQueen = new Queen(board,true,one);
		Piece blackKing = new King(board,false,two);
		board.insertPiece(whiteQueen, one);
		board.insertPiece(blackKing, two);
		
		List<Coordinate> moves = whiteQueen.getValidMoves();
		List<Coordinate> test = new ArrayList<Coordinate>();
		test.add(new Coordinate(1,1));
		test.add(new Coordinate(2,2));
		test.add(new Coordinate(3,3));
		test.add(new Coordinate(4,4));
		test.add(new Coordinate(5,5));
		test.add(new Coordinate(6,6));
		test.add(new Coordinate(7,7));
		System.out.println(moves.toString());
		//assert(moves.containsAll(test));
		moves.removeAll(test);
		//assert(moves.isEmpty());
	}

}
