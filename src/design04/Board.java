package design04;

public class Board   {
    public final int BOARD_SIZE = 8;
    private Piece[][] board;
    private static final char WHITE_COLOUR_CHAR = 'l';
    private static final char KNIGHT_CHAR = 'n';
    private static final char KING_CHAR = 'k';
    private static final char QUEEN_CHAR = 'q';
    private static final char PAWN_CHAR = 'p';
    private static final char ROOK_CHAR = 'r';
    private static final char BISHOP_CHAR = 'b';

    public Board(String boardString) {
        board = new Piece[BOARD_SIZE][BOARD_SIZE];
        String[] tokens = boardString.split("[|=\n]+");
        int len = tokens.length;
        for(int i = 1; i<len;i++){
           tokenWhisperer(tokens[i], i); //LOL@name - please smile :D
            //Converts tokens into pieces on the board
        }

    }


    private void tokenWhisperer(String token, int index){
        //Reads in token, and places piece on board
        boolean colourWhite;
        Piece inputPiece;
        Coordinate inputOrds;
        if(!token.equalsIgnoreCase("  ")){
            colourWhite = (token.charAt(1)==WHITE_COLOUR_CHAR);
            inputOrds = indexToCoordinate(index-1);
            if(token.charAt(0)==KNIGHT_CHAR){      //design04.Knight
                inputPiece = new Knight(this, colourWhite, inputOrds);
            } else if (token.charAt(0)==BISHOP_CHAR){  //design04.Bishop
                inputPiece = new Bishop(this, colourWhite, inputOrds);
            } else if (token.charAt(0)==PAWN_CHAR){ //design04.Pawn
                inputPiece = new Pawn(this, colourWhite, inputOrds);
            } else if (token.charAt(0)==QUEEN_CHAR){  //design04.Queen
                inputPiece = new Queen(this, colourWhite, inputOrds);
            } else if (token.charAt(0)==KING_CHAR){//design04.King
                inputPiece = new King(this, colourWhite, inputOrds);
            } else {//rook
                inputPiece = new Rook(this, colourWhite, inputOrds);
            }
            this.insertPiece(inputPiece, inputOrds);

        }

    }

    private Coordinate indexToCoordinate(int index){
        return new Coordinate(index/(this.BOARD_SIZE) , index%this.BOARD_SIZE);
    }// converts index to co-ordinate. Oh really

    public void insertPiece (Piece p, Coordinate c){
        if (board[c.getX()][c.getY()] == null&&p!=null) {
            board[c.getX()][c.getY()] = p;
            p.updatePos(c);
            
        }
    }
    // Place piece on board - update Position

    public boolean isSquareEmpty(Coordinate c){
        if(c.isOnBoard()){
            return (board[c.getX()][c.getY()]==null);
        } else {
            //System.exit(100);
            return false;
        }

    } // Check if empty so we dont get nullexception errors

    public Piece getPiece(Coordinate c) {
        assert (!isSquareEmpty(c));//Shouldnt be a problem
        return board[c.getX()][c.getY()];
    } //return piece at that co-ord

    public boolean isPieceWhite(Coordinate c){
        assert (board[c.getX()][c.getY()]!=null);
        return board[c.getX()][c.getY()].isWhite();
    } //Checks it's white in one fell swoop

    public Piece movePiece(Coordinate start, Coordinate destination) {
        Piece temp =  board[destination.getX()][destination.getY()];//get original piece
    	board[destination.getX()][destination.getY()] = board[start.getX()][start.getY()];
        board[destination.getX()][destination.getY()].updatePos(destination);
    	board[start.getX()][start.getY()] = null;
        return temp;
    }
    //movePiece moves the given piece, and returns a pointer to a piece if taken


    public Coordinate findBlackKing(){
        assert (board!=null);
        for(int i =0; i<BOARD_SIZE;i++){
            for (int j=0; j<BOARD_SIZE;j++){
                if (board[i][j]!=null&&board[i][j].toString().equalsIgnoreCase("kd")){
                    return new Coordinate(i,j);
                }
            }
        }
        //System.err.println("No Black design04.King");
        //System.exit(10);//Can't work without a black king
        return null;
    }
    //Finds the king, and returns the co-ordinates.

    public String toString(){
        String out="";
        for(int i =0; i<BOARD_SIZE;i++){
            for (int j=0; j<BOARD_SIZE;j++){
                out = out +"|";
                if(board[i][j]==null){
                    out = out + "  ";
                } else {
                    out = out + board[i][j].toString();
                }
            }
            out = out +"|=\n";
        }
        return out;
    }

    //this will simply print out the board as per specs.
}