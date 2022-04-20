package warcardgame;

/**
 * This class contains the methods and attributes of a War Game Player.
 *
 * @author Team Galadhel
 */

public class WarPlayer extends Player {

    private int score = 0;
    private Deck playerDeck;

    public WarPlayer(String name, Deck warDeck){
        super(name);
        this.playerDeck = warDeck;
    }

    public void setScore(int score){
        this.score = score;
    }
    
    public void addScore(int score){
        this.score += score;
    }

    public int getScore(){
        return this.score;
    }
    
    public Deck getPlayerDeck() {
        return playerDeck;
    }
    
    public int getPlayerDeckSize() {
        return playerDeck.getSize();
    }
    
    public Card draw(){
        return playerDeck.drawCard();
    }
    
}