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
        System.out.println("of those players are controlled by a computer");
        int players;
        int users;
        do {
            System.out.print("How many players are playing? (2-10 players): ");
            while (!in.hasNextInt()) {
                System.out.println("That's not a number!");
                System.out.print("How many players are playing? (2-10 players): ");
                in.next();
            }
            players = in.nextInt();
        } while (players < 2 || players > 10);
        do {
            System.out.println("How many of those players will be controlled by a player (At least 1");
            System.out.print("player must be controlled by the user): ");
            while (!in.hasNextInt()) {
                System.out.println("That's not a number!");
                System.out.println("How many of those players will be controlled by a player (At least 1");
                System.out.print("player must be controlled by the user): ");
                in.next();
            }
            users = in.nextInt();
        } while (users < 1 || users > players);
        BlackJack game = new BlackJack(players, users);
    }
}