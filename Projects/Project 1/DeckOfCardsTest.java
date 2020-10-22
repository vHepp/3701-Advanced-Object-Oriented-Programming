/*Card Shuffling and Dealing

Using the code in the book (or slides if you do not have the book), 
modify Fig.7.11 to deal a five-card poker hand. 
Then modify class DeckOfCards of Fig.7.10  
to include methods that determine whether a hand contains:

a pair
two pairs
three of a kind (e.g., three jacks)
four of a kind (e.g., four aces)
a flush (i.e., all five cards of the same suit)
a straight (i.e., five cards of consecutive face values)
a full house (i.e., two cards of one face value and three cards of another face value)
Hint: Add methods getFace and getSuit to class Card of Fig.7.9

Then write an application that deals two five-card poker hands, 
evaluates each hand and determines which is better.

Extra Credit!!

Make your application simulate the dealer. 
The dealer’s five-card hand is dealt "face down", so the player cannot see it. 
The application should then evaluate the dealer’s hand, and, 
based on the quality of the hand, the dealer should draw one, 
two or three more cards to replace the corresponding number of unneeded cards in the original hand. 
The application should then reevaluate the dealer’s hand.*/

public class DeckOfCardsTest
{
	public static void main(String[] args)
	{
		DeckOfCards myDeckOfCards = new DeckOfCards();
		myDeckOfCards.shuffle();
		
		for (int i = 1; i <= 52; i++)
		{
			System.out.printf("%-19s", myDeckOfCards.dealCard());
			
			if (i % 4 == 0)
			{
				System.out.println();
			}
		}
		
	}
}