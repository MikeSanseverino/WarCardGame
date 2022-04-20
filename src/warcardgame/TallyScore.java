package warcardgame;

/**
 * This class contains the method to print the game result.
 *
 * @author Team Galadhel
 */

public class TallyScore {
    public static void getGameResult(WarPlayer player1, WarPlayer player2){
        if (player1.getScore() > player2.getScore()){
            System.out.println(player1.getName() + " wins! Their score was: " + player1.getScore() + "!");
            System.out.println(player2.getName() + "'s score was " + player2.getScore());
        }
        else if (player1.getScore() < player2.getScore()){
            System.out.println(player2.getName() + " wins! Their score was: " + player2.getScore() + "!");
            System.out.println(player1.getName() + "'s score was " + player1.getScore());
        }
        else {
            System.out.println("It's a tie!");
            System.out.println(player1.getName() + "'s score was " + player1.getScore());
            System.out.println(player2.getName() + "'s score was " + player2.getScore());
        }
    }
}
