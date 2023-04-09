import java.util.*;
public class Blackjack 
{
    private Deck deck;
    private Player player;
    private Dealer dealer;
    private Scanner scanner;
    private Leaderboard leaderboard;
    public Blackjack() 
    {
        System.out.println("Welcome to Blackjack!");
        System.out.println("Blackjack, also known as 21, is a popular casino card game that is played between a dealer and one or more players.\n The objective of the game is to have a hand value of 21 or as close to 21 as possible without going over.");
        System.out.println("Rules");
        System.out.println("Blackjack is a card game where the goal is to have a hand value of 21 or as close to 21 as possible without going over.\n The game is played with a deck of 52 cards, and each card has a point value. \nThe player is dealt two cards and can choose to hit (take another card) or stand (keep their current hand). \nThe dealer also receives two cards, but one card is face down. The dealer must hit until they have a hand value of 17 or higher. \nIf the player's hand value is higher than the dealer's without going over 21, the player wins. \nIf the dealer's hand value is higher than the player's or the player goes over 21, the player loses. \nAces can be worth either 1 or 11 points, and face cards are worth 10 points each.");
        deck = new Deck();
        dealer = new Dealer("Dealer", deck);
        scanner = new Scanner(System.in);
        leaderboard = new Leaderboard();
        System.out.println("What is your name? ");
        String name = scanner.nextLine();
        player = new Player(name);
    }
    public void play() 
    {
        while(true) 
        {
            if(deck.getSize()<18)
                deck = new Deck();
            deck.shuffle();
            dealer.dealInitialCards(player);
            System.out.println("Dealer's hand: \n" + dealer.getHand().get(0) + ", [hidden]");
            System.out.println("Your hand: \n" + player.getHand());
            System.out.println("Your hand value: \n" + player.getHandValue());
            if (player.getHandValue() == 21) 
            {
                System.out.println("Blackjack! You win!");
                leaderboard.addScore(player.getName(), 1);
            } 
            else 
            {
                while (true) 
                {
                    System.out.print("Do you want to hit or stand? ");
                    String input = scanner.nextLine().toLowerCase();
                    if (input.equals("hit")) 
                    {
                        Card card = deck.dealCard();
                        player.play(card);
                        System.out.println("Your new card: \n" + card.printCard());
                        System.out.println("Your hand: \n" + player.getHand());
                        System.out.println("Your hand value: " + player.getHandValue());
                        if (player.getHandValue() > 21) 
                        {
                            System.out.println("Bust! You lose.");
                            leaderboard.addScore(player.getName(), -1);
                            break;
                        }
                    } 
                    else if (input.equals("stand")) 
                    {
                        dealer.play();
                        System.out.println("Dealer's hand: \n" + dealer.getHand());
                        System.out.println("Dealer's hand value: " + dealer.getHandValue());
                        if (dealer.getHandValue() > 21) 
                        {
                            System.out.println("Dealer bust! You win!");
                            leaderboard.addScore(player.getName(), 1);
                            break;
                        } 
                        else if (dealer.getHandValue() == player.getHandValue()) 
                        {
                            System.out.println("Tie!");
                            leaderboard.addScore(player.getName(), 0);
                            break;
                        } 
                        else if (dealer.getHandValue() < player.getHandValue()) 
                        {
                            System.out.println("You win!");
                            leaderboard.addScore(player.getName(), 1);
                            break;
                        } 
                        else 
                        {
                            System.out.println("You lose.");
                            leaderboard.addScore(player.getName(), -1);
                            break;
                        }
                    } 
                    else
                        System.out.println("Invalid input. Please enter 'hit' or 'stand'.");
                }
            }
            System.out.println("Leaderboard:");
            leaderboard.print();
            System.out.print("Do you want to play again? ");
            String input = scanner.nextLine().toLowerCase();
            if (input.indexOf('y')!=-1) 
            {
                continue;
            }
            else 
            {
                System.out.print("Is there a new player? ");
                String in = scanner.nextLine().toLowerCase();
                if (in.indexOf('y')!=-1) 
                {
                    System.out.println("Ok! Resetting now.");
                    System.out.println("What is the new player's name? ");
                    String name = scanner.nextLine().toLowerCase();
                    player = new Player(name);
                    continue;
                }
                break;
            }
        }
        scanner.close();
    }
}
