package warcardgame;

/**
 * This class generates a set of Cards for the game of War.
 *
 * @author Team Galadhel
 */

public class WarDeck extends Deck {
    
    public WarDeck(){
        generateCards();
        shuffle();
    }
    
    private void generateCards(){ //creates 52 card deck
        int suitValue = 0;
        int cardWorth = 1; 
        int valuesLength = WarCard.Value.values().length;   // 13   
        int suitsLength = WarCard.Suit.values().length; // 4
            
        for (int i = 0; i < valuesLength + 1 ; i++) {     //while i is less than 14,  i = 0 --> 13, then goes to else and reset to 0.
            if(i < valuesLength && suitValue < suitsLength){    // If i < 13 AND suitValue < 4. Goes to else statement when i = 13.
    
            WarCard.Suit setSuit = WarCard.Suit.values()[suitValue];
            WarCard.Value setValue = WarCard.Value.values()[i];
     
            WarCard card = new WarCard(setSuit, setValue, cardWorth);        
            
            //System.out.println(setSuit + " " + setValue); //for debug purposes, shows entire computer deck 
            //created .setWorth in the card class to assign a proper int value to each card for purposes of winning card battles
            //there probably exists an easier solution but I couldn't think of one 
            
            this.deck.add(card);
            cardWorth++;
            
            //First iteration: WarCard(0, 0, 1)... RESET WarCard(1, 0, 1)
            //Second iteration: WarCard(0, 1, 2)... RESET WarCard(1, 1, 2)
            //until WarCard(0, 12, 13) ... but next if-statement won't work b/c i = 13.
            
            
            }else if(suitValue == suitsLength){    // if i = 13, OR x = 4
                break;
            }else{
                // resets card value and worth, but increments the suit
                i=-1;  // -1 because for loop increments it to 0.
                cardWorth=1;
                suitValue++;
            }
        }
    }
}
    
    
    