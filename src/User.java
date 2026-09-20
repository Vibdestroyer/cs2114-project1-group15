/**
 * Main is used to mainain the user's interactions with the
 * game, handle bad input, and keep track of time and 
 * distance left to class.
 *
 * @author Sarah Gage
 * @version 2026.09.19
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Random;

public class User
{
    private int timeRemaining;
    private int distanceToClass;
    private Choice baseChoice;
    private List<Choice> choices;
    private List<Character> menuLetters;

    // ----------------------------------------------------------
    /**
     * Mainains the user's interactions with the game, handle 
     * bad input, and keep track of time and distance left to 
     * class.
     */
    public User() {
        // Initalize game state
        timeRemaining = 40;
        distanceToClass = 20;

        // Create choice that is always available
        baseChoice = new Choice("Just keep walking", "You kept walking. Nothing interesting happened, but you are closer to class", 4, 2);
        
        // Initalize choices list and add the most basic choice
        choices = new ArrayList<>();
        choices.add(baseChoice);

        // Initialize letters to be displayed as a part of the menu
        menuLetters = new ArrayList<>(26);
        for (char letter = 'A'; letter <= 'Z'; letter++) {
            menuLetters.add(letter);
        }

        // Create random object to be used to determine which encounter object are seen
        Random random = new Random();

        // Main game play
        while (!isDone()) {
            // Create potential encounters and add their choices to the choices array list
            if (random.nextBoolean()) {
                Person p = new Person();
                List<Choice> pChoices = p.getChoices();
                for (int i = 0; i < pChoices.size(); i++) {
                    choices.add(pChoices.get(i));
                }
            } else if (random.nextBoolean()) {
                Friend f = new Friend();
                List<Choice> fChoices = f.getChoices();
                for (int i = 0; i < fChoices.size(); i++) {
                    choices.add(fChoices.get(i));
                }
            } else if (random.nextBoolean()) {
                Freshman f = new Freshman();
                List<Choice> fChoices = f.getChoices();
                for (int i = 0; i < fChoices.size(); i++) {
                    choices.add(fChoices.get(i));
                }
            } else if (random.nextBoolean()) {
                Club c = new Club();
                List<Choice> cChoices = c.getChoices();
                for (int i = 0; i < cChoices.size(); i++) {
                    choices.add(cChoices.get(i));
                }
            } else if (random.nextBoolean()) {
                Bus b = new Bus();
                List<Choice> bChoices = b.getChoices();
                for (int i = 0; i < bChoices.size(); i++) {
                    choices.add(bChoices.get(i));
                }
            } else if (random.nextBoolean()) {
                Restaurant r = new Restaurant();
                List<Choice> rChoices = r.getChoices();
                for (int i = 0; i < rChoices.size(); i++) {
                    choices.add(rChoices.get(i));
                }
            }

            // Allow the user to make a choice and update game state based on that choice
            displayChoices();
            Choice choice = readChoice();
            takeAction(choice);
        }
    }
    
    // ----------------------------------------------------------
    /**
     * Whether or not the game is over.
     * 
     * @return Returns if the user is out or time or at class.
     */
    public boolean isDone() 
    {
        if (timeRemaining <= 0 || distanceToClass <= 0) {
            return true;
        }

        return false;
    }

    // ----------------------------------------------------------
    /**
     * Outputs the options available to the user.
     */
    public void displayChoices() 
    {
        System.out.println("What would you like to do?");
        for (int i = 0; i <= choices.size(); i++) {
            System.out.println(menuLetters.get(i) + ") " + choices.get(i).getMenuText());
        }
    }

    // ----------------------------------------------------------
    /**
     * Reads in the user's input and handles the the user's bad 
     * inputs.
     * 
     * @return Returns the choice the user selects.
     */
    public Choice readChoice() 
    {
        Boolean madeChoice = false;
        Scanner scanner = new Scanner(System.in);
        int choiceIndex = -1;
        
        while (!madeChoice) {
            System.out.print("Please select an option from the menu: ");
            String input = scanner.nextLine();

            if (input == null) {
                System.out.println("It does not look like you made a choice. Make sure to enter a letter choice from the menu.");
            } else {
                char[] inputArray = input.toCharArray();
                if (inputArray.length > 1) {
                    System.out.println("It looks like you entered more than one character. Please enter a single letter choice from the menu.");
                } else {
                    char inputChar = Character.toUpperCase(inputArray[0]);
                    if ((int) inputChar - 65 < 0 && (int) inputChar - 65 >= choices.size()) {
                        System.out.println("It looks like you entered a choice that was not available in the menu. Please enter a single letter choice that is avaible in the menu.");
                    } else {
                        choiceIndex = (int) inputChar - 65;
                        madeChoice = true;
                    }
                }
            }
        }

        scanner.close();
        return choices.get(choiceIndex);
    }

    // ----------------------------------------------------------
    /**
     * Updates values depending on the user's choice and prints 
     * story updates.
     * 
     * @param choice
     *          The choice object the user selected.
     */
    public void takeAction(Choice choice) 
    {
        System.out.println(choice.getResultText());
        timeRemaining -= choice.getTimeCost();
        distanceToClass -= choice.getDistanceReduction();

    }

    // ----------------------------------------------------------
    /**
     * Starts game play.
     */
    public static void main(String arg[]) 
    {
        new User();
    }
}
