package warcardgame;

/**
 * This class contains the methods and attributes of a Deck of Cards.
 *
 * @author Team Galadhel
 */


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
    protected List<Card> deck = new ArrayList<>();
    
    public Deck(){
    }
    
    public void shuffle(){
        Collections.shuffle(deck);
    }
    
    public List<Card> getCards(){ 
        return deck;
    }
    
//    // For testing invalid War Round
//    public void setCard(){
//        Card c = new WarCard(WarCard.Suit.values()[0],WarCard.Value.values()[0],1);
//        this.deck.set(24, c);
//    }
    
    public int getSize(){ 
        return deck.size();
    }
    
    public Card drawCard(){
        try {
            Card drawnCard = this.deck.get(0); // Always pulls index 0 because it is removed afterwards, so next draw auto-increments itself.
            this.deck.remove(drawnCard);
            return drawnCard;
        }
        catch (Exception e){
            System.out.println("No cards left in the deck, unable to draw.");
            return null;
        }
    }

}
