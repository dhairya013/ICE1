/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package card;

import java.util.Random;
import java.util.Scanner;

/**
 * A class that fills a magic hand of 7 cards with random Card Objects
 * and then asks the user to pick a card and searches the array of cards
 * for the match to the user's card. To be used as starting code in ICE 1
 * @author dhairya013
 * @modifier Dhairya Arora, 991722221
 * @date May 22, 2024
 */
public class CardTrick {
    
    public static void main(String[] args) {
        Card[] magicHand = new Card[7];
        Random rand = new Random();
        
        // Fill the magic hand with random cards
        for (int i = 0; i < magicHand.length; i++) {
            Card c = new Card();
            c.setValue(rand.nextInt(13) + 1); // Random value between 1 and 13
            c.setSuit(Card.SUITS[rand.nextInt(4)]); // Random suit from SUITS array
            magicHand[i] = c;
        }

        // Display the magic hand
        System.out.println("The magic hand of cards:");
        for (Card card : magicHand) {
            System.out.println(card.getValue() + " of " + card.getSuit());
        }
        
        // Ask the user for card value and suit
        Scanner scanner = new Scanner(System.in);
        System.out.println("Pick a card value (1-13): ");
        int userValue = scanner.nextInt();
        System.out.println("Pick a suit (Hearts, Diamonds, Spades, Clubs): ");
        String userSuit = scanner.next();

        Card userCard = new Card();
        userCard.setValue(userValue);
        userCard.setSuit(userSuit);
        boolean found = false;

        // Search for the user's card in the magic hand
        for (Card card : magicHand) {
            if (card.getValue() == userCard.getValue() && card.getSuit().equalsIgnoreCase(userCard.getSuit())) {
                found = true;
                break;
            }
        }

        // Report if the user's card is in the magic hand
        if (found) {
            System.out.println("Your card is in the magic hand!");
        } else {
            System.out.println("Your card is not in the magic hand.");
        }

        // Add a hard-coded lucky card
        Card luckyCard = new Card();
        luckyCard.setValue(2);
        luckyCard.setSuit("Clubs");
        boolean luckyFound = false;

        // Search for the lucky card in the magic hand
        for (Card card : magicHand) {
            if (card.getValue() == luckyCard.getValue() && card.getSuit().equalsIgnoreCase(luckyCard.getSuit())) {
                luckyFound = true;
                break;
            }
        }

        // Report if the lucky card is in the magic hand
        if (luckyFound) {
            System.out.println("The lucky card " + luckyCard.getValue() + " of " + luckyCard.getSuit() + " is in the magic hand!");
        } else {
            System.out.println("The lucky card " + luckyCard.getValue() + " of " + luckyCard.getSuit() + " is not in the magic hand.");
        }
    }
}
