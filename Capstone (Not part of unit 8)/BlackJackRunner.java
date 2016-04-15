import java.util.*;
import java.awt.*;
import javax.swing.*;
public class BlackJackRunner
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Welcome to BlackJack");
        System.out.println("Choose the number of players that are playing, then choose how many");
        System.out.println("of those players are controlled by an actual user");
        int players;
        int users;
        do {
            System.out.print("How many players are playing? (2-10 players): ");
            while (!in.hasNextInt()) {
                System.out.println("That's not an integer!");
                System.out.print("How many players are playing? (2-10 players): ");
                in.next();
            }
            players = in.nextInt();
        } while (players < 2 || players > 10);
        String[] names = new String[players];
        do {
            System.out.println("How many of those players will be controlled by a player (At least 1");
            System.out.print("player must be controlled by the user): ");
            while (!in.hasNextInt()) {
                System.out.println("That's not an integer!");
                System.out.println("How many of those players will be controlled by a player (At least 1");
                System.out.print("player must be controlled by the user): ");
                in.next();
            }
            users = in.nextInt();
        } while (users < 1 || users > players);
        for (int i = 0; i < users; i++)
        {
            System.out.print("Enter the name for player " + (i + 1) + ": ");
            names[i] = in.next();
        }
        int comNamer = 1;
        for (int i = users; i < players; i++)
        {
            names[i] = "COM " + comNamer;
            comNamer++;
        }
        String response = "yes";
        boolean firstTime = true;
        while (response.equals("yes"))
        {
            BlackJack game = new BlackJack(players, users, names);
            if (firstTime == true)
            {
                System.out.println("\nThese are the people who will be playing:");
                for (int i = 0; i < players; i++)
                {
                    System.out.println(game.getName(i));
                }
                firstTime = false;
            }
            game.makeDeck();
            System.out.println(game.getDeckSize());
            System.out.print("Play again? (yes/any other response = no): ");
            response = in.next();
        }
    }
}