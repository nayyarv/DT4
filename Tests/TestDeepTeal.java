package design04;

/**
 * File Name:
 * Creator: Varun Nayyar
 * Date: 25/03/12
 * Desc:
 */
public class TestDeepTeal {

    public static void main(String[] args){

        String boardString =
                        "|rd|nd|bd|qd|kd|bd|nd|rd|=\n" +
                        "|pd|pd|pd|pd|pd|  |  |pd|=\n" +
                        "|  |  |  |  |  |  |  |  |=\n" +
                        "|  |  |  |  |  |  |  |  |=\n" +
                        "|  |  |  |pl|  |  |  |  |=\n" +
                        "|  |  |  |  |  |  |  |  |=\n" +
                        "|pl|pl|  |  |  |  |pl|pl|=\n" +
                        "|rl|nl|bl|ql|kl|bl|nl|rl|=\n";

        ChessThinker deepTeal = new DeepTeal();

        deepTeal.fromString (boardString);
        /*
        System.out.println("ToString ok? : " + boardString.equals(deepTeal.toString()));
        System.out.println(deepTeal.toString());


        System.out.println("Black is in Check: " +deepTeal.blackIsInCheck());
        if (!deepTeal.blackIsInCheckMate()){
            System.out.println("Not in Checkmate atm");
        } else {
            System.out.println("Checkmate");
        }
        boolean mate;

        System.out.println("Can white mate in 1?: " + (mate = deepTeal.whiteCanMateInOneMove()));
        if (mate){
           deepTeal.makeWhiteMateMove();
        }

        System.out.println(deepTeal.toString());

        System.out.println("In Checkmate?: " + deepTeal.blackIsInCheckMate());


        //System.out.println("Chekcmate for black?: " +deepTeal.blackIsInCheckMate());
        //System.out.println(deepTeal.toString());
        */
         boardString =
                        "|  |  |  |  |  |  |  |kd|=\n" +
                        "|  |  |  |  |  |  |pl|  |=\n" +
                        "|  |  |  |  |  |  |  |  |=\n" +
                        "|  |  |  |  |  |  |  |  |=\n" +
                        "|  |  |  |  |  |  |  |  |=\n" +
                        "|  |  |  |  |  |  |  |  |=\n" +
                        "|  |  |  |  |  |  |  |  |=\n" +
                        "|  |  |  |  |  |  |  |kl|=\n";

        deepTeal.fromString(boardString);
        System.err.println("With no king, Check is :" + deepTeal.blackIsInCheck());
        System.err.println("With no king, CheckMate is :" + deepTeal.blackIsInCheckMate());
        System.err.println("With no king, One move Checkmate is :" + deepTeal.whiteCanMateInOneMove());


    }
}
