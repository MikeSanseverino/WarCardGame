package warcardgame;

/**
 * This class generates a Player Deck for the game of War.
 *
 * @author Team Galadhel
 */

public class WarPlayerDeck extends Deck {
    
        
        public WarPlayerDeck(Deck warDeck){
            generatePlayerDeck(warDeck);
        }
        
        public void generatePlayerDeck(Deck warDeck){ 
            //Only generates player deck once per player deck.
            if (this.deck.size() == 0) {
                for (int i = 0; i < 26; i++) {  //pulls 26 cards from the shuffled 52 card deck
                    Card playerCard = warDeck.drawCard();
                    this.deck.add(playerCard);
                }
            }
        }
            
}
