import java.util.*;
public class Deck 
{
    private ArrayList<Card> deck;
    public Deck() 
    {
        deck = new ArrayList<Card>();
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        String[] ranks = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
        for (String suit : suits) 
        {
            for (String rank : ranks) 
            {
                Card card = new Card(suit, rank);
                deck.add(card);
            }
        }
        shuffle();
        shuffle();
    }
    public void shuffle() 
    {
        shuffleRecursive(deck.size() - 1);
    }
    private void shuffleRecursive(int n) 
    {
        if (n == 0) 
        {
            return;
        }
        shuffleRecursive(n - 1);
        int k = (int) (Math.random() * (n + 1));
        Card temp = deck.get(n);
        deck.set(n, deck.get(k));
        deck.set(k, temp);
    }
    public Card dealCard() 
    {
        Card card = deck.remove(0);
        return card;
    }
    public int getSize()
    {
        return deck.size();
    }
}
