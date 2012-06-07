package design04; /**
 * File Name:
 * Creator: Varun Nayyar
 * Date: 25/03/12
 * Desc: design04.DeepTeal - a simple Chess program.
 */

import java.util.*;

public class DeepTeal implements ChessThinker{

    private Board chessGame;

    public DeepTeal(String boardString){
        fromString(boardString);
    }

    public DeepTeal(){

    }
    //For acceptance Testing - Had both types of constructors?

    public void fromString (String boardString){
        chessGame = new Board(boardString);
        //design04.Board does all the string parsing
    }


    public boolean blackIsInCheck(){
        //Gets all white pieces and see if they can get to the design04.King
        Coordinate blackKing = chessGame.findBlackKing();
        List<Coordinate> whitePieces = getPieces(true);
        for (Coordinate currentLocation : whitePieces){
            if(chessGame.getPiece(currentLocation).canMoveto(blackKing)){
                return true;
            }
        }
        return false;
    }

    private List<Coordinate> getPieces(boolean getWhite){//which colour to get
        List<Coordinate> boardPiece = new ArrayList<Coordinate>();
        for (int i=0; i<chessGame.BOARD_SIZE;i++){
            for (int j=0;j<chessGame.BOARD_SIZE;j++){
                //We find every piece, and put it into a list
                Coordinate currentLocation = new Coordinate(i,j);
                if(!chessGame.isSquareEmpty(currentLocation)){ //if not empty
                    if(chessGame.isPieceWhite(currentLocation)^(!getWhite)){//some clever logic to simplify things
                        //i.e. only puts in which colour requested
                        boardPiece.add(currentLocation);
                    }
                }
            }
        }
        //letting the gc do most of our dirty work :P
        return boardPiece;
    }


    public boolean blackIsInCheckMate(){

        List <Coordinate> possibleMoves;
        List <Coordinate> blackPieces = getPieces(false); //get list of black pieces

        Piece taken;
        boolean blackCheckBool;

        for(Coordinate currentPiecePos : blackPieces){ //For all black pieces
            possibleMoves = chessGame.getPiece(currentPiecePos).getValidMoves();//get moves
            //System.err.println(possibleMoves);
            for(Coordinate newPos: possibleMoves){ //for all possible moves
                taken = chessGame.movePiece(currentPiecePos,newPos);//move it to new position, and keep track of old piece
                blackCheckBool = blackIsInCheck();
                chessGame.movePiece(newPos,currentPiecePos);
                chessGame.insertPiece(taken, newPos);
                // move it back in case we need to do more tests

                //if the white king has been taken, the game is over, not checkmate

                if(!blackCheckBool||(taken!=null&&taken.toString().equalsIgnoreCase("kl"))){
                    //chessGame.movePiece(currentPiecePos,newPos);//make the move
                    //System.err.println(chessGame.toString());
                    return false; //there is a move that can be made
                }
            }

        }
        return true;

    }

    public boolean whiteCanMateInOneMove(){
        return whiteMateWrapper(false);
    }


    public void makeWhiteMateMove(){
        whiteMateWrapper(true);
    }

    //essentially the same function with some differences - we make the move or we dont, that's what the boolean
    //is for

    private boolean whiteMateWrapper(boolean performMove){
        boolean blackCheckMateBool;
        List <Coordinate> possibleMoves;
        Piece taken;
        List <Coordinate> whitePieces = getPieces(true); //get list of white pieces

        for(Coordinate currentPiecePos : whitePieces){  //for all white pieces
            possibleMoves = chessGame.getPiece(currentPiecePos).getValidMoves();//get moves
            for(Coordinate newPos: possibleMoves){ //for all possible moves

                taken = chessGame.movePiece(currentPiecePos,newPos);//move it to new position, and keep track of old piece
                blackCheckMateBool = blackIsInCheckMate();
                chessGame.movePiece(newPos,currentPiecePos);
                chessGame.insertPiece(taken, newPos);
                // move it back in case we need to do more tests
                if (taken!=null&&taken.toString().equalsIgnoreCase("kd")){
                //i.e taking the king is not checkmate
                    blackCheckMateBool = false;
                }

                if(blackCheckMateBool){ //If in checkmate
                    if (performMove){ //perform move too.
                        chessGame.movePiece(currentPiecePos,newPos);
                    }
                    return true;
                }
            }

        }

        return false;
    }


    public String toString(){
        return chessGame.toString();  //yay

    }

}