/**
 * Application purpose: This class is responsible for taking in game inputs and storing them
 * Author: Amanpreet Singh
 * Date: 10/4/22
 * Time: 11:00AM
 */

import java.util.Random;
import java.util.Scanner;

public class GameInput {
    // Instance variables used to store the user input and the computer generated responses
    private char userChoice;
    private char comChoice;
    // Stores the user's name for applicable user interface
    private String userName;
    // Object of the Random class
    Random rdm;

    // This 2-D array stores the total wins, loses and ties
    public static String[][] score = new String[][]{
            {"Win", "0"},
            {"Lose", "0"},
            {"Tie", "0"},
    };

    // Default constructor
    public GameInput() {
        userChoice = ' ';
        comChoice = ' ';
        rdm = new Random();
    }

    // getter and setter for userChoice
    public char getUserChoice() {
        return userChoice;
    }

    public void setUserChoice(char userChoice) {
        userChoice = Character.toUpperCase(userChoice);
        this.userChoice = userChoice;
    }

    // This function generates a random response using an array preloaded with responses
    public void generateComChoice() {
        char[] rockPaperScissor = {'R', 'P', 'S'};
        int randomIndex = rdm.nextInt(3);
        // This is needed to make the random index value more unpredictable as the bound value is only 3!
        int i = 100;
        while ( i > 0) {
            randomIndex = rdm.nextInt(3);
            i--;
        }
        comChoice = rockPaperScissor[randomIndex];
    }

    // Getter for comChoice
    public char getComChoice() {
        return comChoice;
    }

    // Getter and setter for user's name
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    // This is the game interface with specific instructions which loads before starting every game
    public void gameStartInterface() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter your Name to start the game");
        userName = sc.next();
        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
        System.out.println("Hello! " + userName);
        System.out.println("---------------------------");
        System.out.println("Welcome to the Rock, Paper and Scissors game.");
        System.out.println("This is a very cliche game that you might have already played in real life with your friends...");
        System.out.println("Now its time to try your luck out against a computer.");
        System.out.println("Let's see who wins first!!!");
        System.out.println("Here is a short Legend for the abbreviations used in the game.");
        System.out.println("R->Rock \nP->Paper \nS->Scissors");
        System.out.println("Enough with the info! let's get started then.....");
        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
    }

    // This prints the calculated score of the user for the total Wins, Losses and Ties
    public static void printScore() {
        System.out.println("\n\n************************");
        System.out.println("Scoreboard:");
        System.out.println("Wins: " + score[0][1]);
        System.out.println("Losses: " + score[1][1]);
        System.out.println("Ties: " + score[2][1]);
        System.out.println("************************");
    }

}
