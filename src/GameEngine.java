/**
 * Application purpose: As the name suggests, this is basically the Engine of the Game, responsible for starting the game by taking inputs and displaying outputs from two different classes
 * Author: Amanpreet Singh
 * Date: 10/4/22
 * Time: 11:00AM
 */

import java.util.Scanner;

public class GameEngine {
    // Static variable to store response regarding the continuation of the game.
    private static char continueGame;


    public static void startGameEngine() {
        // GameInput class's object is instantiated
        GameInput gameInput = new GameInput();
        // variables storing the user and computer responses
        char userChoice, comChoice;
        // Scanner class object creation
        Scanner sc = new Scanner(System.in);
        // Printing the game interface for giving user the necessary instructions
        gameInput.gameStartInterface();
        do {
            // Asking for user input
            System.out.println("\nPlease enter your choice (R,P,S)");
            userChoice = sc.next().charAt(0);

            // Storing the userInput in the instance variable of the GameInput class
            gameInput.setUserChoice(userChoice);
            // Generating random computer response
            gameInput.generateComChoice();
            // Retrieving the computer response
            comChoice = gameInput.getComChoice();

            // Instantiating the GameLogic class's object along with passing in the GameInput class object to transfer data between objects
            GameLogic gameLogic = new GameLogic(gameInput);
            // Try-catch block to handle any IllegalArgumentExceptions thrown for wrong user input
            try {
                // Storing and printing the result received from the getResult() method of the GameLogic class
                String result = gameLogic.getResult();
                System.out.println("\n" + result);
                // Populating the score 2-D array according to the result recieved
                int newScore;
                int flag = 0;
                for (int i = 0; i < 3; i++) {
                    if (result.contains(GameInput.score[i][0])) {
                        flag = i;
                        break;
                    }
                }
                newScore = Integer.parseInt(GameInput.score[flag][1]) + 1;
                GameInput.score[flag][1] = Integer.toString(newScore);

            } catch (Exception ex) {
                // Catching any exceptions for user input beyond [R, P, S]
                System.out.println(ex.getMessage() + "\n");
                // Skipping to the part for asking for another user response within [R, P, S]
                continueGame = 'Y';
                continue;
            }
            // Asking whether the user wants to continue or not?
            System.out.println("\nDo you want to continue(Y/N)?");
            continueGame = sc.next().charAt(0);
            continueGame = Character.toUpperCase(continueGame);
            System.out.println("--------------------------------------");
        } while (continueGame == 'Y');
        // If user quits show the results along with a warm ending message.
        GameInput.printScore();
        System.out.println("\nxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
        System.out.println("Game Over!");
        System.out.println("Thanks, for playing our Rock, Paper and Scissors game - " + gameInput.getUserName());
        System.out.println("If you liked the game, you can come back later anytime!");
        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
    }

}
