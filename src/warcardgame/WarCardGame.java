package warcardgame;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
//Author: Michal Sanseverino
public class WarCardGame {
    public static void main (String[] args){
        Random random = new Random();
        Scanner input = new Scanner(System.in);
        int points = 2; //used for determining point outcome of War, starts at 2 to include the two cards used to initiate war

        List<Card> deck = getCards(); //initiates method below to generate deck
        List<Card> playerDeck = new ArrayList<>(); 
        System.out.println("------------------");
        for (int i = 0; i < 26; i++) {  //pulls 26 cards at random from the 52 card deck
            Card playerCard = deck.get(random.nextInt(25));
            deck.remove(playerCard);
            playerDeck.add(playerCard);
           // System.out.println(playerCard.getValue() + " " + playerCard.getSuit()); //for debug purposes, show player deck
        }  

        //System.out.println("------------------");
        //for(Card d : deck){              //for debug purposes, show computer deck after player cards removed
        //System.out.println(d.getValue() + " " + d.getSuit()); 
        //} //debug end

        
        //Gets player information. 
        System.out.println("Enter name of player 1!");
        Player player1 = new Player(input.next(), 0);
        Player player2 = new Player("Computer", 0); //can be changed to add a second player - the game plays exactly the same

        System.out.println("Greetings " + player1.getName() + "!");
        System.out.println("LETS PLAY WAR!!!");
        pressEnter();

        do{
            Card playerDraw = playerDeck.get(random.nextInt(playerDeck.size()));
            playerDeck.remove(playerDraw);

            Card comDraw = deck.get(random.nextInt(deck.size()));
            deck.remove(comDraw);
            System.out.println(player1.getName() + " drew " + playerDraw.getValue() +" of "+ playerDraw.getSuit());
            System.out.println(player1.getName() + " has " + playerDeck.size()+ " card(s) left!");
            pressEnter();
            System.out.println(player2.getName() + " drew " + comDraw.getValue() +" of "+ comDraw.getSuit());
            if(playerDraw.getWorth() > comDraw.getWorth()){
                System.out.println(player1.getName()+ " wins the hand! " + player1.getName() + " gets two points!");
                player1.setScore(points);
            pressEnter();
            }else if(playerDraw.getWorth() < comDraw.getWorth()){
                System.out.println(player2.getName() + " wins the hand! " + player2.getName() + " gets two points!");
                player2.setScore(points);
            pressEnter();
            }else if(playerDraw.getWorth() == comDraw.getWorth() && playerDeck.size() > 3){
                System.out.println("It's WAR!!");
                boolean goAgain = true;
                pressEnter();
                    do{
                        Card warFaceDown = playerDeck.get(random.nextInt(playerDeck.size()));
                        playerDeck.remove(warFaceDown);
                        Card warFaceDown2 = playerDeck.get(random.nextInt(playerDeck.size()));
                        playerDeck.remove(warFaceDown2);

                        Card warFaceUp =  playerDeck.get(random.nextInt(playerDeck.size()));
                        playerDeck.remove(warFaceUp);

                        Card comFaceDown = deck.get(random.nextInt(deck.size()));
                        playerDeck.remove(comFaceDown);
                        Card comFaceDown2 = deck.get(random.nextInt(deck.size()));
                        playerDeck.remove(comFaceDown2);
                        Card comFaceUp =  deck.get(random.nextInt(deck.size()));
                        playerDeck.remove(comFaceUp);
                        
                        System.out.println(player1.getName() + " drew three cards, two face down and one face up!");
                        System.out.println(player1.getName() + " drew " + warFaceUp.getValue() +" of "+ warFaceUp.getSuit());
                        pressEnter();
                        System.out.println(player2.getName() + " drew three cards, two face down and one face up!");
                        System.out.println(player2.getName() + " drew " + comFaceUp.getValue() +" of "+ comFaceUp.getSuit());
                        pressEnter();
                        points += 6;
                        if(warFaceUp.getWorth() > comFaceUp.getWorth()){
                            System.out.println(player1.getName() + " gets all the cards! " + player1.getName() +" gets " + points + " points!");
                            player1.setScore(points);
                            goAgain = false;
                            points = 2;
                            break;
                        }else if(warFaceUp.getWorth() < comFaceUp.getWorth()){
                            System.out.println(player2.getName() + " gets all the cards! " + player2.getName() +" gets " + points + " points!");
                            player2.setScore(points);
                            goAgain = false;
                            points = 2;
                            break;
                        }else if(playerDeck.size() <= 1){
                            System.out.println("Not enough cards to continue the war! Lets find out who won.");
                            goAgain = false;
                            break;
                        }else{
                            System.out.println("It's a tie! Another round!");
                        }
                    }while(goAgain = true);
            }else if(playerDeck.size() <= 1){
                System.out.println("Not enough cards to continue the war! Lets find out who won.");
                break;
            }




        }while(playerDeck.size() >= 1);

        if(player1.getScore() > player2.getScore()){
            System.out.println(player1.getName() + " wins! Thier score was: " + player1.getScore() + "!");
            System.out.println(player2.getName() + "'s score was " + player2.getScore());
        }else if(player2.getScore() > player1.getScore()){
            System.out.println(player2.getName() + " wins! Thier score was: " + player2.getScore() + "!");
            System.out.println(player1.getName() + "'s score was " + player1.getScore());
        }else{
            System.out.println("It's a tie!");
            System.out.println(player1.getName() + "'s score was " + player1.getScore());
            System.out.println(player2.getName() + "'s score was " + player2.getScore());
        }
        

    }

public static List<Card> getCards(){ //creates 52 card deck
    List<Card> deck = new ArrayList<>();

    int x = 0;
    int y = 0; 
    int numValues = Card.Value.values().length;
    int numSuits = Card.Suit.values().length;
    
        
    for (int i = 0; i < numValues+1 ; i++) {
        if(i < numValues && x < numSuits){    

        Card.Suit setSuit = Card.Suit.values()[x];
        Card.Value setValue = Card.Value.values()[i];
 
        Card card = new Card(setSuit, setValue, y);        
        //System.out.println(setSuit + " " + setValue); //for debug purposes, shows entire computer deck 
        card.setWorth(y);
        //created .setWorth in the card class to assign a proper int value to each card for purposes of winning card battles
        //there probably exists an easier solution but I couldn't think of one 
        deck.add(card);
        y++;
        }else if(i == numValues+1 || x == numSuits+1){
            break;
        }else{
            //resets card value and worth, but increments the suit
            i=0-1;
            y=0;
            x++;
        }
    }
    
 
    return deck;
}
private static void pressEnter(){ //prompts user to press enter to continue the program
    System.out.print("[Press Enter to Continue]");
    Scanner pressEnter = new Scanner(System.in);
    pressEnter.nextLine();
}

}