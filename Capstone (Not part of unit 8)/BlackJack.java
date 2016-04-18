import java.util.*;
import java.awt.*;
import javax.swing.*;
public class BlackJack
{
    private int numplayers;
    private int users;
    private String[] players; // list of all the players, including the computers
    private int[][] handValue; // the second array is for alta. value if Ace is drawn
    private int[] numAces; // number of aces in each player's hand
    private String[] cardsInHand; // the list of cards each player has
    private ArrayList<Integer> cards = new ArrayList<Integer>(52); // Deck of cards
    public BlackJack(int numPlayers, int users, String[] names)
    {
        this.numplayers = numPlayers;
        this.users = users;
        this.players = names;
        this.numAces = new int[numPlayers];
        for (int i = 0; i < numPlayers; i++)
        {
            numAces[i] = 0;
        }
        this.handValue = new int[numPlayers][3];
        this.cardsInHand = new String[numPlayers];
    }
    public String getName(int pos)
    {
        return players[pos];
    }
    public int getDeckSize()
    {
        return cards.size();
    }
    public String getHand(int currentPlayer)
    {
        return cardsInHand[currentPlayer];
    }
    public String getHandValue(int currentPlayer)
    {
        String hand = "";
        if (handValue[currentPlayer][1] != handValue[currentPlayer][2])
        {
            hand += (handValue[currentPlayer][1] + "/" + handValue[currentPlayer][2]);
        } else
        {
            hand += handValue[currentPlayer][2];
        }
        return hand;
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
    public void computerMoves(int currentPlayer)
    {
        int til21 = 21 - handValue[currentPlayer][2];
        int stillAliveCards = 0;
        for (int i = 1; i <= til21; i++)
        {
            stillAliveCards += Collections.frequency(cards, i);
        }
        double decksize = (stillAliveCards / cards.size()) * 100;
        if (decksize >= 60)
        {
            this.hit(currentPlayer);
        }
    }
    public int hit(int currentPlayer)
    {
        Random rand = new Random();
        int pos = rand.nextInt(cards.size());
        int card = cards.get(pos);
        if (card == 1) // the 1 equals an ace, which can be either a 1 or 11
        {
            if (numAces[currentPlayer] >= 2)
            {
                int temp = handValue[currentPlayer][1];
                handValue[currentPlayer][2] = temp + 11;
                handValue[currentPlayer][1] += 1;
            } else
            {
                handValue[currentPlayer][1] += 1;
                handValue[currentPlayer][2] += 11;
                numAces[currentPlayer]++;
            }
            cardsInHand[currentPlayer] += "\tA";
        } else if (card >= 11 && card <= 13)
        {
            handValue[currentPlayer][1] += 10;
            handValue[currentPlayer][2] += 10;
            if (card == 11) // jack
            {
                cardsInHand[currentPlayer] += "\tJ";
            } else if (card == 12) // queen
            {
                cardsInHand[currentPlayer] += "\tQ";
            } else if (card == 13) // king
            {
                cardsInHand[currentPlayer] += "\tQ";
            }
        } else
        {
            handValue[currentPlayer][1] += card;
            handValue[currentPlayer][2] += card;
            cardsInHand[currentPlayer] += ("\t" + card);
        }
        cards.remove(pos);
        return card;
    }
    public boolean isBusted(int currentPlayer)
    {
        if (handValue[currentPlayer][2] > 21)
        {
            if (handValue[currentPlayer][1] > 21)
            {
                return true;
            } else
            {
                handValue[currentPlayer][2] = handValue[currentPlayer][1];
                return false;
            }
        } else
        {
            return false;
        }
    }
}