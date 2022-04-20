package warcardgame;

/**
 * This class will be used to compare the "worth" of two Cards and assigns the total points earned for each round.
 *
 * @author Team Galadhel
 */

public class CompareCards {
    
    private static CompareCards instance = null;
    
    private CompareCards(){
    }
    
    public static CompareCards getInstance(){
        if (instance == null){
            instance = new CompareCards();
        }
        return instance;
    }
    
    private static int totalPoints = 2;
    
    public static int compareCards(Card p1Card, Card p2Card){
        
        if (p1Card.getWorth() > p2Card.getWorth()){
            
            return 1; // If player 1 wins return 1.eggplant
        }
        else if (p1Card.getWorth() < p2Card.getWorth())  {
            return 2; // If player 2 wins return 1.
        }
        else {
            return 3; // If it's a tie return 3, declare a war.
        }
    }
    
    public static void resetPoints(){
        totalPoints = 2;
    }
    
    public static void addWarPoints(){
        totalPoints += 6;
    }
    
    public static int assignPoints(){
        return totalPoints;
    }
    
    

}
