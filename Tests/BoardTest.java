package design04;

/**
 * File Name:
 * Creator: Varun Nayyar
 * Date: 23/03/12
 * Desc:
 */
public class BoardTest {

    public static void main(String[] args){
        String boardString =
                "|rd|nd|bd|qd|kd|bd|nd|rd|=\n" +
                        "|pd|pd|pd|  |  |pd|pd|pd|=\n" +
                        "|  |  |  |  |pd|  |  |  |=\n" +
                        "|  |  |  |pd|  |  |  |  |=\n" +
                        "|  |  |pl|pl|  |  |  |  |=\n" +
                        "|  |  |  |  |  |  |  |  |=\n" +
                        "|pl|pl|  |  |  |  |pl|pl|=\n" +
                        "|rl|nl|bl|ql|kl|bl|nl|rl|=\n";


        Board john = new Board(boardString);
        Coordinate ord1 = new Coordinate(1,2);
        Coordinate ord2 = new Coordinate(5,6);
        Coordinate ord3 = new Coordinate(2,6);
        //System.out.println(ord.toString());

        //System.out.println(john.isSquareEmpty(ord));
        john.insertPiece(new Rook(john, true,ord1),ord1);

        john.insertPiece(new King(john, false,ord1), ord2 );
        
        if (!john.isSquareEmpty(ord1)&&john.isSquareEmpty(new Coordinate(1,3))){
            System.out.println("Success: isSquareEmpty");
        }

        if(!john.isPieceWhite(ord1)){
            System.out.println("Failure");
        }  else {
            System.out.println("Success: isPieceWhite");
        }
        System.out.println(john.toString());
        john.movePiece(ord1, ord3);


        if(john.isSquareEmpty(ord1)&& !john.isSquareEmpty(ord3)) {
            System.out.println("Success: movePiece");
        } else {
            System.out.println("Failure movePiece");
        }




        System.out.println(john.toString());

        System.out.println(john.findBlackKing().toString());


        john.movePiece(ord3, ord2);
        System.out.println(john.toString());
;
    }





}
