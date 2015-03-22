package org.ck.projectEuler.unsolved.problem054;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/*TODO: finish this*/
public class PokerHands
{

	private static enum Suit
	{
		SPADES, HEARTS, DIAMONDS, CLUBS;
	}

	private static enum Value
	{
		TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGTH, NINE, TEN, JACK, QUEEN, KING, ACE;
	}

	private static enum HandValue
	{
		HIGH_CARD, ONE_PAIR, TWO_PAIR, THREE_OF_KIND, STRAIGTH, FLUSH, FULL_HOUSE, FOUR_OF_KIND, STRAIGHT_FLUSH,
		ROYAL_FLUSH;
	}

	private static class Card
	{
		private Suit suit = null;
		private Value value = null;

		public Card(String card)
		{
			char[] values = card.toCharArray();

			setValue(values[0]);
			setSuit(values[1]);
		}

		private void setValue(char valueForValue)
		{
			switch (valueForValue)
			{
				case '2':
					setValue(Value.TWO);
					break;
				case '3':
					setValue(Value.THREE);
					break;
				case '4':
					setValue(Value.FOUR);
					break;
				case '5':
					setValue(Value.FIVE);
					break;
				case '6':
					setValue(Value.SIX);
					break;
				case '7':
					setValue(Value.SEVEN);
					break;
				case '8':
					setValue(Value.EIGTH);
					break;
				case '9':
					setValue(Value.NINE);
					break;
				case 'T':
					setValue(Value.TEN);
					break;
				case 'J':
					setValue(Value.JACK);
					break;
				case 'Q':
					setValue(Value.QUEEN);
					break;
				case 'K':
					setValue(Value.KING);
					break;
				case 'A':
					setValue(Value.ACE);
					break;
				default:
					break;
			}
		}

		private void setSuit(char valueForSuit)
		{
			switch (valueForSuit)
			{
				case 'S':
					setSuit(Suit.SPADES);
					break;
				case 'H':
					setSuit(Suit.HEARTS);
					break;
				case 'D':
					setSuit(Suit.DIAMONDS);
					break;
				case 'C':
					setSuit(Suit.CLUBS);
					break;
				default:
					break;
			}
		}

		public Suit getSuit()
		{
			return this.suit;
		}

		public void setSuit(Suit suit)
		{
			this.suit = suit;
		}

		public Value getValue()
		{
			return this.value;
		}

		public void setValue(Value value)
		{
			this.value = value;
		}

		public boolean equalsInSuit(Card card)
		{
			if (this.suit.equals(card.getSuit()))
			{
				return true;
			}

			return false;
		}

	}

	private static class Hand
	{
		private HandValue handValue = null;
		private Value highCard = null;

		public Hand(Card c1, Card c2, Card c3, Card c4, Card c5)
		{
			checkHand(c1, c2, c3, c4, c5);
		}

		private void checkHand(Card c1, Card c2, Card c3, Card c4, Card c5)
		{
			// ...

			checkForRoyalFlush(c1, c2, c3, c4, c5);
		}

		private void checkForRoyalFlush(Card c1, Card c2, Card c3, Card c4, Card c5)
		{
			if (c1.equalsInSuit(c2) && c2.equalsInSuit(c3) && c3.equalsInSuit(c4) && c4.equalsInSuit(c5))
			{
				if (isStraight(c1, c2, c3, c4, c5))
				{
					if (isAnyOfValue(Value.ACE, c1, c2, c3, c4, c5))
					{
						setHandValue(HandValue.ROYAL_FLUSH);
						setHighCard(Value.ACE);
					}
				}
			}
		}

		private static boolean isAnyOfValue(Value value, Card c1, Card c2, Card c3, Card c4, Card c5)
		{
			if (c1.getValue().equals(value) || c2.getValue().equals(value) || c3.getValue().equals(value)
					|| c4.getValue().equals(value) || c5.getValue().equals(value))
			{
				return true;
			}

			return false;
		}

		/**
		 * @param c1
		 * @param c2
		 * @param c3
		 * @param c4
		 * @param c5
		 */
		private static boolean isStraight(Card c1, Card c2, Card c3, Card c4, Card c5)
		{
			
			return false;
		}

		public HandValue getHandValue()
		{
			return this.handValue;
		}

		public void setHandValue(HandValue handValue)
		{
			this.handValue = handValue;
		}

		public Value getHighCard()
		{
			return this.highCard;
		}

		public void setHighCard(Value highCard)
		{
			this.highCard = highCard;
		}
	}

	public static void main(String[] args) throws IOException
	{

		List<String[]> values = readInput();

		for (String[] line : values)
		{
			Hand handP1 =
					new Hand(new Card(line[0]), new Card(line[1]), new Card(line[2]), new Card(line[3]), new Card(
							line[4]));

			Hand handP2 =
					new Hand(new Card(line[5]), new Card(line[6]), new Card(line[7]), new Card(line[8]), new Card(
							line[9]));

			System.err.println(handP1.getHandValue() + " " + handP2.getHighCard());
		}

	}

	private static List<String[]> readInput() throws IOException
	{
		List<String[]> ret = new ArrayList<>();

		try (FileInputStream fstream = new FileInputStream("E:\\Projects\\workspace\\Euler\\resources\\poker.txt");
				DataInputStream in = new DataInputStream(fstream);
				BufferedReader br = new BufferedReader(new InputStreamReader(in)))
		{
			String strLine;

			while ((strLine = br.readLine()) != null)
			{
				ret.add(strLine.split(" "));
			}
		}

		return ret;
	}

}