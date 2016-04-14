import java.util.*;
import java.awt.*;
import javax.swing.*;
public class BlackJack
{
    private int numplayers;
    private int users;
    private String[] players;
    private ArrayList<Integer> cards = new ArrayList<Integer>(52);
    public BlackJack(int numPlayers, int users, String[] names)
    {
        this.numplayers = numPlayers;
        this.users = users;
        this.players = new String[numPlayers];
        int comNamer = 1;
        for (int i = 0; i < names.length; i++)
        {
            players[i] = names[i];
        }
        for (int i = names.length; i < numPlayers; i++)
        {
            players[i] = "COM " + comNamer;
            comNamer++;
        }
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
}