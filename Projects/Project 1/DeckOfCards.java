import java.security.SecureRandom;

public class DeckOfCards
{
	private static final SecureRandom randomNumbers = new SecureRandom();
	private static final int NUMBER_OF_CARDS = 52;
	private static final int NUMBER_IN_HAND = 5;
	
	private Card[] deck = new Card[NUMBER_OF_CARDS];
	private Card[] playerHand = new Card[NUMBER_IN_HAND];
	private int currentCard = 0;
	
	public DeckOfCards()
	{
		String[] faces = {"Ace", "Deuce", "Three", "Four", "Five", "Six", 
			"Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King"};
			
		String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
		
		for (int i = 0; i < deck.length; i++)
		{
			deck[i] = new Card(faces[i%13], suits[i/13]);
		}
	}
	
	public void shuffle()
	{
		currentCard = 0;
		
		for (int i = 0; i < deck.length; i++)
		{
			int second = randomNumbers.nextInt(NUMBER_OF_CARDS);
			
			Card temp = deck[i];
			deck[i] = deck[second];
			deck[second] = temp;
		}
	}
	
	public Card dealCard()
	{
		if (currentCard < deck.length)
		{
			return deck[currentCard++];
		}
		else
		{
			return null;
		}
	}
	
	public int pairs(Card [] hand)
	{
		String[] faces = {"Ace", "Deuce", "Three", "Four", "Five", "Six", 
						"Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King"};
		
		int count = 0, pairs = 0;
		
		for (int i = 0; i < faces.length; i++)
		{
			for (int k = 0; k < NUMBER_IN_HAND; k++)
			{
				
				if (faces[i] == hand[k].getFace())
				{
					count++;
					//System.out.printf("count = %d%n", count);
				}
			}
			
			if (count == 2)
				pairs++;
			
			//System.out.printf("count = %d, pairs = %d%n", count, pairs);
			count = 0;
		}
		
		if (pairs == 2)
			return 2;
		if (pairs == 1)
			return 1;
		return 0;
	}
	
	public int ofAKind(Card [] hand)
	{
		int count = 1, maxCount = 1;
		
		for (int i = 0; i < NUMBER_IN_HAND - 1; i++)
		{
			for (int k = i+1; k < NUMBER_IN_HAND; k++)
			{
				
				if (hand[i].getFace() == hand[k].getFace())
				{
					count++;
				}
			}
			
			if (maxCount <= count)
				maxCount = count;
			
			count = 1;
		}
		
		if (maxCount == 4)
			return 4;
		if (maxCount == 3)
			return 3;
		return 0;
	}
	
	public boolean flush(Card [] hand)
	{
		String flushSuit = hand[0].getSuit();
		
		for (int i = 1; i < NUMBER_IN_HAND; i++)
		{
			if (hand[i].getSuit() != flushSuit)
				return false;
		}
		
		return true;
	}
	
	public String straight(Card [] hand)
	{
		sortHand(hand);
		
		/*
		System.out.println("\nSorted Hand (Highest -> Lowest (K -> A)):\n");
		
		for (int i = 0; i < NUMBER_IN_HAND; i++)
		{
			//myHand[i] = myDeckOfCards.dealCard();
			System.out.printf("%-19s\n", hand[i]);
		}
		*/
		
		if(royalFlush(hand))
			return "You have a Royal Flush!";
		
		for (int i = 0; i < NUMBER_IN_HAND - 1; i++)
		{
			if (getCardRank(hand[i]) - getCardRank(hand[i+1]) != 1)
				return "You do not have a Straight.";
		}
		
		if(flush(hand))
			return "You have a Straight Flush!";
		
		return "You have a Straight!";
	}
	
	public boolean royalFlush(Card [] hand)
	{	
		sortHand(hand);
		
		if (flush(hand) && hand[4].getFace() == "Ace" && hand[3].getFace() == "Ten" && hand[2].getFace() == "Jack" 
			&& hand[1].getFace() == "Queen" && hand[0].getFace() == "King")
			return true;
			
		return false;
	}
	
	public boolean fullHouse(Card [] hand)
	{
		return (pairs(hand) == 1 && ofAKind(hand) == 3);
	}
	
	public void sortHand(Card [] hand)
	{
		//Bubble sort using Linear Search
		
		
		for (int i = 0; i < NUMBER_IN_HAND - 1; i++)
		{	
			for (int k = 0; k < NUMBER_IN_HAND - i - 1; k++)
			{
				if (getCardRank(hand[k]) < getCardRank(hand[k+1]))
				{
					Card temp = hand[k];
					hand[k] = hand[k+1];
					hand[k+1] = temp;
				}
			}
		}
	}
	
	public int getCardRank(Card card)
	{
		String[] faces = {"Ace", "Deuce", "Three", "Four", "Five", "Six", 
			"Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King"};
		
		String face = card.getFace();
		
		int i = 0;
		
		while (i < faces.length)
		{
			if (faces[i] == face)
				return i;
			i++;
		}
		
		return -1;
	}
	
	public int highCard(Card [] hand)
	{
		sortHand(hand);
		
		return getCardRank(hand[0]);
	}
	
	public int getHandRank(Card [] hand)
	{
		if (royalFlush(hand))
			return 1;
		if (straight(hand) == "You have a Straight Flush!")
			return 2;
		if (ofAKind(hand) == 4)
			return 3;
		if (fullHouse(hand))
			return 4;
		if (flush(hand))
			return 5;
		if (straight(hand) == "You have a Straight!")
			return 6;
		if (ofAKind(hand) == 3)
			return 7;
		if (pairs(hand) == 2)
			return 8;
		if (pairs(hand) == 1)
			return 9;
		else
			return 10;
	}
	
	
	
	//stuff for ranking ties, this section is a mess but it works (I think).
	
	public Card pairsTie(Card [] hand)
	{
		String[] faces = {"Ace", "Deuce", "Three", "Four", "Five", "Six", 
						"Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King"};
		
		Card high1 = new Card("Ace", "Spades");
		Card high2 = new Card("Ace", "Spades");
			
			
		boolean flag = false;
		
		int count = 0, pairs = 0;
		
		for (int i = 0; i < faces.length; i++)
		{
			for (int k = 0; k < NUMBER_IN_HAND; k++)
			{
				
				if (faces[i] == hand[k].getFace())
				{
					count++;
				}
				
				if (count == 2)
				{
					if (!flag)
					{
						high1 = hand[k];
						flag = true;
					}
					else
						high2 = hand[k];
				}
				
			}
			
			count = 0;
		}
		
		if (getCardRank(high1) < getCardRank(high2))
			return high2;
		return high1;
	}
	
	public Card ofAKindTie(Card [] hand)
	{
		Card high3 = new Card("Ace", "Spades");
		Card high4 = new Card("Ace", "Spades");
		
		int count = 1, maxCount = 1;
		
		for (int i = 0; i < NUMBER_IN_HAND - 1; i++)
		{
			for (int k = i+1; k < NUMBER_IN_HAND; k++)
			{
				//System.out.printf("i = %d, k = %d\t%s of %s and %s of %s%n", i, k,hand[i].getFace(),hand[i].getSuit(),hand[k].getFace(),hand[k].getSuit());
				
				if (hand[i].getFace() == hand[k].getFace())
				{
					//System.out.println("count++");
					count++;
					
					if (count == 3)
						high3 = hand[k];
					else if (count == 4)
						high4 = hand[k];
				}
			}
			
			if (maxCount <= count)
				maxCount = count;
			
			//System.out.printf("count = %d, maxcount = %d%n", count, maxCount);
			count = 1;
		}
		
		if (maxCount == 4)
			return high4;
		return high3;
	}
		
	public int getHandRankTie(Card [] hand, int rankTied)
	{
		sortHand(hand);
		
		if (rankTied == 1)
			return 1;
		if (rankTied == 2 || rankTied == 4 || rankTied == 5 || rankTied == 6)
			return getCardRank(hand[0]);
		if (rankTied == 3 || rankTied == 7)
			return getCardRank(ofAKindTie(hand));
		if (rankTied == 8 || rankTied == 9)
			return getCardRank(pairsTie(hand));
		else
			return 0;
	}
}