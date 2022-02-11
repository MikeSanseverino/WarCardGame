package warcardgame;

public class Card {

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

    public Card(Suit suit, Value value, int worth) {
        this.suit = suit;
        this.value = value;
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


}