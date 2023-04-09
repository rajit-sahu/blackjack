import java.util.*;
public class Player 
{
    private String name;
    private ArrayList<Card> hand;
    private int score;
    public Player(String name) 
    {
        this.name = name;
        hand = new ArrayList<Card>();
        score = 0;
    }
    public String getName() 
    {
        return name;
    }
    public void play(Card card) 
    {
        hand.add(card);
    }
    public int getHandSize() 
    {
        return hand.size();
    }
    public ArrayList<String> getHand() 
    {
        ArrayList<String> a = new ArrayList<String>();
        for(int c = 0; c<hand.size();c++)
        {
            Card temp=hand.get(c);
            a.add(temp.printCard());
        }
        return a;
    }
    public int getHandValue() 
    {
        int value = 0;
        int aceCount = 0;
        for (Card card : hand) 
        {
            String rank = card.getRank();
            if (rank.equals("A")) 
            {
                value += 11;
                aceCount++;
            } 
            else if (rank.equals("K") || rank.equals("Q") || rank.equals("J"))
                value += 10;
            else
                value += Integer.parseInt(rank);
        }
        while (value > 21 && aceCount > 0) 
        {
            value -= 10;
            aceCount--;
        }
        return value;
    }
    public boolean isBust()
    {
        if (getHandValue()>21)
            return true;
        else
            return false;
    }
    public int getScore() 
    {
        return score;
    }
    public void updateScore(int amount) 
    {
        score += amount;
    }
    public void clearHand()
    {
        hand = new ArrayList<Card>();
    }
    public String toString() 
    {
        return name + " has " + getHandSize() + " cards with a value of " + getHandValue() + " and a score of " + score;
    }
}
