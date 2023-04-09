public class Dealer extends Player {
    private Deck deck;
    public Dealer(String name, Deck deck) 
    {
        super(name);
        this.deck = deck;
    }
    public Dealer()
    {
        super("Dealer");
        this.deck = new Deck();
    }
    public void dealInitialCards(Player player) 
    {
        player.clearHand();
        super.clearHand();

        Card card1 = deck.dealCard();
        Card card2 = deck.dealCard();

        player.play(card1);
        player.play(card2);

        Card card3 = deck.dealCard();
        Card card4 = deck.dealCard();

        super.play(card3);
        super.play(card4);
    }
    public void play() 
    {
        while (getHandValue() < 17) 
        {
            Card card = deck.dealCard();
            super.play(card);
        }
    }
}
