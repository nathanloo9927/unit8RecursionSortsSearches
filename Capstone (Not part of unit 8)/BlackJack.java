import java.util.*;
import java.awt.*;
import javax.swing.*;
public class BlackJack
{
    private int numplayers;
    private int users;
    private String[] players;
    private int[][] handValue; // the second array is for alta. value if Ace is drawn
    //private ArrayList<String> cardNames = new ArrayList<Integer>(11);
    private ArrayList<Integer> cards = new ArrayList<Integer>(52);
    public BlackJack(int numPlayers, int users, String[] names)
    {
        this.numplayers = numPlayers;
        this.users = users;
        this.players = names;
        this.handValue = new int[numPlayers][2];
    }
    public String getName(int pos)
    {
        return players[pos];
    }
    public int deck()
    {
        return cards.size();
    }
    public void makeDeck()
    {
        for (int i = 1; i <= 4; i++)
        {
            for (int j = 1; j <= 13; j++)
            {
                cards.add(j);
            }
        }
    }
    public void removeAllCards()
    {
        cards.clear();
    }
    public int hit(int currentPlayer)
    {
        Random rand = new Random();
        int pos = rand.nextInt(cards.size());
        int card = cards.get(pos);
        if (card == 1)
        {
            handValue[currentPlayer][1] += 1;
            handValue[currentPlayer][2] += 11;
        } else if (card >= 11 && card <= 13)
        {
            
        }
        cards.remove(pos);
        return card;
    }
}