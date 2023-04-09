public class Card
{   
    //private variables
    private String suit;
    private String rank;
    //constructor
    public Card(String suit, String rank)
    {
        this.suit = suit;
        this.rank = rank;
    }
    public String getSuit()
    {
        return suit;
    }
    public String getRank()
    {
        return rank;
    }
    public String printCard() {
        String suitSymbol = "";
        if (suit.equals("Spades")) {
            suitSymbol = "\u2660";
        } else if (suit.equals("Hearts")) {
            suitSymbol = "\u2665";
        } else if (suit.equals("Diamonds")) {
            suitSymbol = "\u2666";
        } else if (suit.equals("Clubs")) {
            suitSymbol = "\u2663";
        }
        String rankLine1 = "| "+rank+"           |\n";
        String rankLine2 = "|           "+rank+" |\n";
        if(rank.equals("10"))
        {
            rankLine1 = "| "+rank+"          |\n";
            rankLine2 = "|          "+rank+" |\n";
        }
        String cardString = "\n┌─────────────┐\n" +rankLine1+
        "|             |\n"  +"|             |\n" +"|      " + suitSymbol + "      |\n" +
        "|             |\n"  +"|             |\n" +rankLine2+"└─────────────┘";
        return cardString;
    }
}
