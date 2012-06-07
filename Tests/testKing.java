import java.util.ArrayList;
import java.util.List;


public class testKing implements Test {
	public void run() {
		Board board = new Board();
		Coordinate one = new Coordinate (0,2);
		Coordinate two = new Coordinate (1,7);
		Piece whiteKing = new King(board,true,one);
		Piece blackKing = new King(board,false,two);
		board.insertPiece(whiteKing, one);
		board.insertPiece(blackKing, two);
		
		List<Coordinate> moves = whiteKing.getValidMoves();
		List<Coordinate> test = new ArrayList<Coordinate>(); 
		System.out.println(moves.toString());
		test.add(new Coordinate(1,0));
		test.add(new Coordinate(1,2));
		test.add(new Coordinate(2,3));
		test.add(new Coordinate(1,4));
/*
		assert(moves.contains(new Coordinate(0,1)));
		assert(moves.contains(new Coordinate(0,3)));
		assert(moves.contains(new Coordinate(1,2)));
		assert(moves.contains(new Coordinate(1,3)));
		assert(moves.contains(new Coordinate(1,1)));

		*/
	}
	
	
}
