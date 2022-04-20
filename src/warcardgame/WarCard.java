package warcardgame;

/**
 * This class contains the methods and attributes of a War Card.
 *
 * @author Team Galadhel
 */

public class WarCard extends Card {
    
      public enum Suit {
        Diamonds, Hearts, Spades, Clubs
    }

    public enum Value {
        ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN,
        JACK, QUEEN, KING
    }
    
    private final Suit suit;
    private final Value value;
    private int worth = 0;

    public WarCard(Suit suit, Value value, int worth) {
        this.suit = suit;
        this.value = value;
        this.worth = worth;
    }

    public Value getValue() {
        return this.value;
    }

    public Suit getSuit() {
        return this.suit;
    }

    public void setWorth(int worth) {
        this.worth = worth;
    }

    public int getWorth(){
        return worth;
    }
    
        @Override
    public String toString() {
        return value + " of " + suit;
    }

}
