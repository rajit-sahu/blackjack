import java.util.*;
public class Leaderboard 
{
    private ArrayList<Player> players;
    public Leaderboard() 
    {
        players = new ArrayList<Player>();
    }
    public void addPlayer(Player player) 
    {
        players.add(player);
    }
    public void print() 
    {
        // Sort the players by their scores
        for (int i = 0; i < players.size() - 1; i++) 
        {
            for (int j = 0; j < players.size() - i - 1; j++) 
            {
                if (players.get(j).getScore() < players.get(j+1).getScore()) 
                {
                    // Swap the players if they are in the wrong order
                    Player temp = players.get(j);
                    players.set(j, players.get(j+1));
                    players.set(j+1, temp);
                }
            }
        }
        // Print the leaderboard
        System.out.println("LEADERBOARD");
        System.out.println("-----------");
        for (int i = 0; i < players.size(); i++) 
        {
            System.out.println((i+1) + ". " + players.get(i).getName() + " - " + players.get(i).getScore());
        }
    }
    public void removePlayer(Player player)
    {
        players.remove(player);
    }
    public ArrayList<Player> getPlayers() 
    {
        return players;
    }
    public int getRank(Player player) 
    {
        return binarySearch(player, 0, players.size() - 1);
    }
    public void addScore(String playerName, int score) 
    {
        for (Player player : players) {
            if (player.getName().equals(playerName)) {
                player.updateScore(score);
                return;
            }
        }
        // If player is not found, add a new player with the given name and score
        Player newPlayer = new Player(playerName);
        newPlayer.updateScore(score);
        addPlayer(newPlayer);
    }
    private int binarySearch(Player player, int left, int right) 
    {
        if (left > right) 
        {
            return -1;
        }
        int mid = (left + right) / 2;
        if (players.get(mid).getScore() == player.getScore()) 
        {
            return mid;
        } 
        else if (players.get(mid).getScore() < player.getScore())
            return binarySearch(player, left, mid - 1);
        else
            return binarySearch(player, mid + 1, right);
    }
    public String toString() 
    {
        StringBuilder sb = new StringBuilder();
        sb.append("Leaderboard:\n");
        for (int i = 0; i < players.size(); i++) 
        {
            sb.append(i + 1).append(". ").append(players.get(i)).append("\n");
        }
        return sb.toString();
    }
}
