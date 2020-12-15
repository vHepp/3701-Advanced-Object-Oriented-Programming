/*Card Shuffling and Dealing

Using the code in the book (or slides if you do not have the book), 
modify Fig.7.11 to deal a five-card poker hand. 
Then modify class DeckOfCards of Fig.7.10  
to include methods that determine whether a hand contains:

a pair		******Done
two pairs	******Done
three of a kind (e.g., three jacks)	******Done
four of a kind (e.g., four aces)	******Done
a flush (i.e., all five cards of the same suit) ******Done
a straight (i.e., five cards of consecutive face values) ******Done
a full house (i.e., a pair and a 3-of-a-kind) 	******Done
Hint: Add methods getFace and getSuit to class Card of Fig.7.9 ******Done

Then write an application that deals two five-card poker hands,
evaluates each hand and determines which is better. ******Done

*/


public class DeckOfCardsTest
{
	public static void main(String[] args)
	{
		
		DeckOfCards myDeckOfCards = new DeckOfCards();
		myDeckOfCards.shuffle();
		
		Card [] myHand = new Card[5];
		Card [] theirHand = new Card[5];
		
		System.out.println("\nmyHand:\n");

		for (int i = 0; i < 5; i++)
		{
			myHand[i] = myDeckOfCards.dealCard();
			System.out.printf("%-19s\n", myHand[i]);
		}
		
		System.out.println("\ntheirHand:\n");

		for (int i = 0; i < 5; i++)
		{
			theirHand[i] = myDeckOfCards.dealCard();
			System.out.printf("%-19s\n", theirHand[i]);
		}

		
		///////////Testing///////////
		
		//  myHand
		System.out.println("\n\nmyHand:\n");
		
		testPairs(myDeckOfCards, myHand);
		System.out.println();
		
		testOfAKind(myDeckOfCards, myHand);
		System.out.println();
		
		testFlush(myDeckOfCards, myHand);
		System.out.println();
		
		testFullHouse(myDeckOfCards, myHand);
		System.out.println();
		
		testStraight(myDeckOfCards, myHand);
		System.out.println();
		
		
		//  theirHand
		System.out.println("\ntheirHand:\n");
		
		testPairs(myDeckOfCards, theirHand);
		System.out.println();
		
		testOfAKind(myDeckOfCards, theirHand);
		System.out.println();
		
		testFlush(myDeckOfCards, theirHand);
		System.out.println();
		
		testFullHouse(myDeckOfCards, theirHand);
		System.out.println();
		
		testStraight(myDeckOfCards, theirHand);
		System.out.println();
		
		
		//both hands
		compareHands(myDeckOfCards, myHand, theirHand);
	}
	
	public static void test4ofaKind()
	{
		DeckOfCards myDeckOfCards = new DeckOfCards();
		myDeckOfCards.shuffle();
		
		System.out.print("\n\n/////////Testing 4 of a Kind/////////\n\n");
		Card [] myHand = new Card[5];
		
		System.out.println("myHand:\n");
		
		myHand[0] = new Card("Queen", "Hearts");
		myHand[1] = new Card("Ace", "Hearts");
		myHand[2] = new Card("Ace", "Diamonds");
		myHand[3] = new Card("Ace", "Clubs");
		myHand[4] = new Card("Ace", "Spades");
		
		for (int i = 0; i < 5; i++)
		{
			System.out.printf("%-19s\n", myHand[i]);
		}
		
		int x = myDeckOfCards.ofAKind(myHand);
		
		System.out.printf("%n%d of a kind", x);
	}
	
	public static void test3ofaKind()
	{
		System.out.print("\n\n/////////Testing 3 of a Kind/////////\n\n");
		
		DeckOfCards myDeckOfCards = new DeckOfCards();
		myDeckOfCards.shuffle();
		Card [] myHand = new Card[5];
		
		System.out.println("myHand:\n");
		
		myHand[0] = new Card("Queen", "Hearts");
		myHand[1] = new Card("King", "Hearts");
		myHand[2] = new Card("Ace", "Diamonds");
		myHand[3] = new Card("Ace", "Clubs");
		myHand[4] = new Card("Ace", "Spades");
		
		for (int i = 0; i < 5; i++)
		{
			System.out.printf("%-19s\n", myHand[i]);
		}
		
		int x = myDeckOfCards.ofAKind(myHand);
		
		System.out.printf("%n%d of a kind", x);
	}
	
	public static void testPairs(DeckOfCards myDeckOfCards, Card [] myHand)
	{
		//System.out.print("\n/////////Testing Pairs/////////\n");
		
		int x = myDeckOfCards.pairs(myHand);
		
		System.out.printf("%n%d Pair(s)", x);
	}
	
	public static void testOfAKind(DeckOfCards myDeckOfCards, Card [] myHand)
	{
		//System.out.print("\n/////////Testing of a Kind/////////\n");
		
		int x = myDeckOfCards.ofAKind(myHand);
		
		if (x > 1)
			System.out.printf("%n%d of a kind.", x);
		else
			System.out.print("\nNo groups of 3 or 4.");
	}
	
	public static void testFlush(DeckOfCards myDeckOfCards, Card [] myHand)
	{
		//System.out.print("\n/////////Testing Flush/////////\n");
		
		if (myDeckOfCards.flush(myHand))
		{
			System.out.print("\nYou have a flush!");
		}
		else
			System.out.print("\nYou do not have a flush.");
	}
	
	public static void testFullHouse(DeckOfCards myDeckOfCards, Card [] myHand)
	{
		//System.out.print("\n/////////Testing Full House/////////\n");
		
		if (myDeckOfCards.fullHouse(myHand))
		{
			System.out.print("\nYou have a Full House!");
		}
		else
			System.out.print("\nYou do not have a Full House.");
	}
	
	public static void testStraight(DeckOfCards myDeckOfCards, Card [] myHand)
	{
		//System.out.print("\n/////////Testing Straight/////////\n");
		
		System.out.printf("\n%s\n", myDeckOfCards.straight(myHand));
	}
	
	public static void compareHands(DeckOfCards myDeckOfCards, Card [] myHand, Card [] theirHand)
	{
		
		myDeckOfCards.sortHand(myHand);
		myDeckOfCards.sortHand(theirHand);
		
		int myHandRank = 0, theirHandRank = 0;
		
		myHandRank = myDeckOfCards.getHandRank(myHand);
		theirHandRank = myDeckOfCards.getHandRank(theirHand);
		
		if (myHandRank < theirHandRank)
			System.out.println("\nmyHand is better.");
		else if (theirHandRank < myHandRank)
			System.out.println("\ntheirHand is better.");
		else if (theirHandRank == myHandRank && myHandRank == 10)
		{
			myHandRank = myDeckOfCards.highCard(myHand);
			theirHandRank = myDeckOfCards.highCard(theirHand);
			
			if (myHandRank > theirHandRank)
				System.out.println("\nmyHand is better.");
			else if (theirHandRank > myHandRank)
				System.out.println("\ntheirHand is better.");
			else
				System.out.println("\nmyHand and theirHand are equally ranked.");
		}
		else if (theirHandRank == myHandRank && myHandRank != 10)
		{
			int rankTied = myHandRank;
			
			myHandRank = myDeckOfCards.getHandRankTie(myHand, rankTied);
			theirHandRank = myDeckOfCards.getHandRankTie(theirHand, rankTied);
			
			if (myHandRank > theirHandRank)
				System.out.println("\nmyHand is better.");
			else if (theirHandRank > myHandRank)
				System.out.println("\ntheirHand is better.");
			else
				System.out.println("\nmyHand and theirHand are equally ranked.");
		}
		
		
	}
}