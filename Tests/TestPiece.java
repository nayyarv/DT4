package design04;

/**
 * File Name:
 * Creator: Varun Nayyar
 * Date: 25/03/12
 * Desc:
 */
public class TestPiece {
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


}
