package warcardgame;

import java.util.Scanner;

/**
 * This class contains the rules and methods to play the War Game.
 *
 * @author Team Galadhel
 */

public class WarGame extends Game {
    
    WarGame(){
        super("War Card Game");
    }

    @Override
    public void play() {
        
        Scanner input = new Scanner(System.in);
        
        // Get Player names.
        System.out.println("Enter name of player 1!");
        String player1Name = input.next();
        System.out.println("Enter name of player 2!");
        String player2Name = input.next();
        
        // Greet Players.
        System.out.println("Greetings " + player1Name + " and " + player2Name +"!");
        System.out.println("LETS PLAY WAR!!!");
        
        // Create War Deck, and assign decks to players
        WarDeck gameDeck = new WarDeck();
        
        WarPlayerDeck player1Deck = new WarPlayerDeck(gameDeck);
        WarPlayerDeck player2Deck = new WarPlayerDeck(gameDeck);
       
        WarPlayer player1 = new WarPlayer (player1Name, player1Deck);
        WarPlayer player2 = new WarPlayer (player2Name, player2Deck);
        
//        //Test to see what happens during war with 2 cards left
//        player1.getPlayerDeck().setCard();
//        player2.getPlayerDeck().setCard();
//        System.out.println(player1.getPlayerDeck().getCards().get(24));
//        System.out.println(player2.getPlayerDeck().getCards().get(24));
        
        pressEnter();
        
        // While players have cards remaining, do a normalRound()
        do{
            normalRound(player1, player2);
        } while (player1.getPlayerDeckSize() >= 1 && player2.getPlayerDeckSize() >= 1);
        
        System.out.println("No more cards left! Lets find out who won.");
        pressEnter();
        
        // Prints game result
        TallyScore.getGameResult(player1, player2);
        
    }
    
    private void pressEnter(){ //prompts user to press enter to continue the program
    System.out.print("[Press Enter to Continue]\n");
    Scanner pressEnter = new Scanner(System.in);
    pressEnter.nextLine();
}
    
    private void normalRound(WarPlayer player1, WarPlayer player2){
        //If player 1 and 2 have enough cards to compare.
        if (player1.getPlayerDeckSize() >= 1 && player2.getPlayerDeckSize() >= 1){
            
            //Get instance of CompareCards
            CompareCards compare = CompareCards.getInstance();
            
            //Player 1 draw.
            Card p1Draw = player1.draw();
            System.out.println(player1.getName() + " drew: " + p1Draw);
            System.out.println(player1.getName() + " has " + player1.getPlayerDeckSize()+ " card(s) left!");
            pressEnter();
            
            //Player 2 draw.
            Card p2Draw = player2.draw();
            System.out.println(player2.getName() + " drew: " + p2Draw);
            System.out.println(player2.getName() + " has " + player2.getPlayerDeckSize()+ " card(s) left!");
            pressEnter();
            
            //Extra text for the final round.
            if (player1.getPlayerDeckSize() == 0 && player2.getPlayerDeckSize() == 0){
                System.out.println("This is the final round, let's see who wins!");
                pressEnter();
            }
            
            // Compares the two drawn cards.
            int compareResult =compare.compareCards(p1Draw, p2Draw);
            
            // If result is 1, player 1 won.            
            if (compareResult == 1){
                System.out.println(player1.getName() + " wins!");
                System.out.println("They earn " + compare.assignPoints() + " points.");
                // Assign points to player 1.
                player1.addScore(CompareCards.assignPoints());
                pressEnter();
            }
            // If result is 2, player 2 won.
            else if (compareResult == 2){
                System.out.println(player2.getName() + " wins!");
                System.out.println("They earn " + compare.assignPoints() + " points.");
                // Assign points to player 2.
                player2.addScore(compare.assignPoints());
                pressEnter();
            }
            // If result is 3, it is a tie.
            else if (compareResult == 3){
                System.out.println("It's a tie! Time for WAR!!!");
                pressEnter();
                // Do a round a WAR.
                warRound(player1, player2);
            }
        }
        // If they don't have enough for war skip to end.
    }
    
    private void warRound(WarPlayer player1, WarPlayer player2){
        //If both players still have enough cards to do a round a war (3 cards for each player)
        if (player1.getPlayerDeckSize() >= 3 && player2.getPlayerDeckSize() >= 3){
            //Get instance of CompareCards
            CompareCards compare = CompareCards.getInstance();
            
            //Player 1 war draw.
            player1.draw();  //Draw face down
            player1.draw();  //Draw face down
            Card faceUp1 = player1.draw();  //Draw face up

            System.out.println(player1.getName() + " drew three cards, two face down and one face up!");
            System.out.println(player1.getName() + "'s face up card is: " + faceUp1);
            System.out.println(player1.getName() + " has " + player1.getPlayerDeckSize()+ " card(s) left!");
            pressEnter();
            
            //Player 2 war draw.
            player2.draw();  //Draw face down
            player2.draw();  //Draw face down
            Card faceUp2 = player2.draw();  //Draw face up

            System.out.println(player2.getName() + " drew three cards, two face down and one face up!");
            System.out.println(player2.getName() + "'s face up card is: " + faceUp2);
            System.out.println(player2.getName() + " has " + player2.getPlayerDeckSize()+ " card(s) left!");
            pressEnter();

            //Add +6 to totalPoints for the 6 extra cards.
            compare.addWarPoints();
            
            //Compare the two face up cards.
            int compareResult = compare.compareCards(faceUp1, faceUp2);
            
            // If result is 1, player 1 won.      
            if (compareResult == 1){
                System.out.println(player1.getName() + " wins!");
                System.out.println("They earn " + compare.assignPoints() + " points.");
                player1.addScore(compare.assignPoints());
                //After assigning points, reset totalPoints back to 2
                compare.resetPoints(); 
                pressEnter();
            }
            // If result is 2, player 2 won.      
            else if (compareResult == 2){
                System.out.println(player2.getName() + " wins!");
                System.out.println("They earn " + compare.assignPoints() + " points.");
                player2.addScore(compare.assignPoints());
                //After assigning points, reset totalPoints back to 2
                compare.resetPoints(); 
                pressEnter();
            }
            // If result is 3, it is a tie.      
            else if (compareResult == 3){
                System.out.println("It's a tie again! Time for another WAR!!!");
                pressEnter();
                // Runs another warRound()
                warRound(player1, player2); 
            }        
        }
        // If they don't have enough for war skip to end.
        else {
            System.out.println("Not enough cards to continue the war! The rest of the cards are forfeited and no points are assigned this round.");
            
            //Draw rest of cards to end game loop
            while(player1.getPlayerDeckSize() != 0){
                player1.draw();
            }
            while(player2.getPlayerDeckSize() != 0){
                player2.draw();
            }
            pressEnter();
        }
    }
    



}
