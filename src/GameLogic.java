/**
 * Application purpose: This class contains the logic behind the Game
 * Author: Amanpreet Singh
 * Date: 10/4/22
 * Time: 11:00AM
 */

public class GameLogic {
    // instance variables storing the user and computer responses
    private char userChoice, comChoice;

    // Parameterized constructor taking in GameInput class object to populate the instance variables through the object
    // I have implemented data transfer through objects, which is something of a challenge that I was ready to take..
    public GameLogic(GameInput gameInput) {
        userChoice = gameInput.getUserChoice();
        comChoice = gameInput.getComChoice();
    }

    // This returns the result according to the user and computer responses generated
    public String getResult() {

        String result;
        switch (userChoice) {
            case 'R':
                if (comChoice == 'R') {
                    result = "Its a Tie!";
                } else if (comChoice == 'P') {
                    result = "You Lose!";
                } else {
                    result = "You Win!";
                }
                break;
            case 'P':
                if (comChoice == 'R') {
                    result = "You Win!";
                } else if (comChoice == 'P') {
                    result = "Its a Tie!";
                } else {
                    result = "You Lose!";
                }
                break;
            case 'S':
                if (comChoice == 'R') {
                    result = "You Lose!";
                } else if (comChoice == 'P') {
                    result = "You Win!";
                } else {
                    result = "Its a Tie!";
                }
                break;
            default:
                throw new IllegalArgumentException("Unexpected value: " + userChoice + "\nPlease enter a choice between: [R,P,S] only!");
        }
        System.out.println("Your Choice: " + userChoice);
        System.out.println("Computer's Choice: " + comChoice);
        return result;
    }
}
