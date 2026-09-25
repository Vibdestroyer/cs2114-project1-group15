import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Random;

/**
 * Main is used to maintain the user's interactions with the
 * game, handle bad input, and keep track of time and
 * distance left to class.
 *
 * @author Sarah Gage
 * @version 2026.09.19
 */

public class User {
    private int timeRemaining;
    private int distanceToClass;
    private int happiness;
    private Choice baseChoice;
    private List<Choice> choices;
    private List<Character> menuLetters;

    // ----------------------------------------------------------
    /**
     * Maintains the user's interactions with the game, handle
     * bad input, and keep track of time and distance left to
     * class.
     */
    public User() {
        // Create scanner to read in user inputs
        Scanner scanner = new Scanner(System.in);

        // Initialize game state
        timeRemaining = 40;
        distanceToClass = 20;
        happiness = 0;

        // Create choice that is always available
        baseChoice = new Choice("Just keep walking",
            "You kept walking for 4 minutes. Nothing interesting happened, but you are 0.2 miles closer to class.",
            4, 2, -2);

        // Initialize choices list and add the most basic choice
        choices = new ArrayList<>();
        choices.add(baseChoice);

        // Initialize list of selected choices to print at the end
        List<Choice> choicesSelected = new ArrayList<>();

        // Initialize letters to be displayed as a part of the menu
        menuLetters = new ArrayList<>(26);
        for (char letter = 'A'; letter <= 'Z'; letter++) {
            menuLetters.add(letter);
        }

        // Create random object to be used to determine which encounter object
        // are seen
        Random random = new Random();

        // First interaction with user
        System.out.println("\nWelcome to Hokie Hustle!\n");
        System.out.println("You are a Virginia Tech student rushing to class.");
        System.out.println(
            "You will want to make it to class on time, but you will encounter many obstacles and opportunities along the way.");
        System.out.println(
            "It is up to you what path you take, just try not to be late.");
        System.out.println("You have 40 minutes and have to travel 2 miles.");
        System.out.println("Good luck!\n");

        // Main game play
        while (!isDone()) {
            // Reset choices list
            choices.clear();
            choices.add(baseChoice);

            // Create potential encounters and add their choices to the choices
            // array list
            if (random.nextBoolean()) {
                Person p = new Person();
                List<Choice> pChoices = p.getChoices();
                for (int i = 0; i < pChoices.size(); i++) {
                    choices.add(pChoices.get(i));
                }
            }
            if (random.nextBoolean()) {
                Friend f = new Friend();
                List<Choice> fChoices = f.getChoices();
                for (int i = 0; i < fChoices.size(); i++) {
                    choices.add(fChoices.get(i));
                }
            }
            if (random.nextBoolean()) {
                Freshman f = new Freshman();
                List<Choice> fChoices = f.getChoices();
                for (int i = 0; i < fChoices.size(); i++) {
                    choices.add(fChoices.get(i));
                }
            }
            if (random.nextBoolean()) {
                Club c = new Club();
                List<Choice> cChoices = c.getChoices();
                for (int i = 0; i < cChoices.size(); i++) {
                    choices.add(cChoices.get(i));
                }
            }
            if (random.nextBoolean()) {
                Bus b = new Bus();
                List<Choice> bChoices = b.getChoices();
                for (int i = 0; i < bChoices.size(); i++) {
                    choices.add(bChoices.get(i));
                }
            }
            if (random.nextBoolean()) {
                Restaurant r = new Restaurant();
                List<Choice> rChoices = r.getChoices();
                for (int i = 0; i < rChoices.size(); i++) {
                    choices.add(rChoices.get(i));
                }
            }

            // Allow the user to make a choice and update game state based on
            // that choice
            displayChoices();
            Choice choice = readChoice(scanner);
            choicesSelected.add(choice);
            takeAction(choice);

            if (!isDone()) {
                DecimalFormat df = new DecimalFormat("0.0");
                System.out.println("You have " + timeRemaining
                    + " minutes remaining and " + df.format(
                        (float)distanceToClass / 10.0) + " miles remaining.\n");
            }
        }
        scanner.close();

        if (timeRemaining < 0) {
            System.out.println(
                "You ran out of time. You are going to be late to class.");
        }
        else if (timeRemaining == 0) {
            if (distanceToClass < 0) {
                System.out.println(
                    "You made it to class with time to spare. Amazing job!");
            }
            else if (distanceToClass == 0) {
                System.out.println(
                    "You made it to class exactly on time. Impressive!");
            }
            else {
                System.out.println(
                    "You ran out of time. You are going to be late to class.");
            }
        }
        else {
            System.out.println(
                "You made it to class with time to spare. Amazing job!");
        }

        // Print final story
        System.out.println("\nYour story summary:");
        for (int i = 0; i < choicesSelected.size(); i++) {
            System.out.print(choicesSelected.get(i).getResultText() + " ");
        }
        if (happiness > 5) {
            System.out.println(
                "\n\nThese choices made you very happy despite the outcome. Maybe it isn't always about being on time.");
        }
        else if (happiness > 0) {
            System.out.println(
                "\n\nThese choices made you pretty happy. The trip was enjoyable no matter the outcome.");
        }
        else if (happiness == 0) {
            System.out.println(
                "\n\nThese choices did not affect your happiness very much. The trip was pretty boring.");
        }
        else {
            System.out.println(
                "\n\nThese choices did not make you happy. Maybe it is more important to be on time.");
        }
    }


    // ----------------------------------------------------------
    /**
     * Whether or not the game is over.
     * 
     * @return Returns if the user is out or time or at class.
     */
    public boolean isDone() {
        if (timeRemaining <= 0 || distanceToClass <= 0) {
            return true;
        }
        return false;
    }


    // ----------------------------------------------------------
    /**
     * Outputs the options available to the user.
     */
    public void displayChoices() {
        System.out.println("What would you like to do?");
        for (int i = 0; i < choices.size(); i++) {
            System.out.println(menuLetters.get(i) + ") " + choices.get(i)
                .getMenuText());
        }
    }


    // ----------------------------------------------------------
    /**
     * Reads in the user's input and handles the user's bad
     * inputs.
     * 
     * @return Returns the choice the user selects.
     */
    public Choice readChoice(Scanner scanner) {
        Boolean madeChoice = false;
        int choiceIndex = -1;

        while (!madeChoice) {
            System.out.print("Please select an option from the menu: ");
            String input = scanner.nextLine();

            if (input == "") {
                System.out.println(
                    "It does not look like you made a choice. Make sure to enter a letter choice from the menu.");
            }
            else {
                char[] inputArray = input.toCharArray();
                if (inputArray.length > 1) {
                    System.out.println(
                        "It looks like you entered more than one character. Please enter a single letter choice from the menu.");
                }
                else {
                    char inputChar = Character.toUpperCase(inputArray[0]);
                    if ((int)inputChar - 65 < 0 || (int)inputChar
                        - 65 >= choices.size()) {
                        System.out.println(
                            "It looks like you entered a choice that was not available in the menu. Please enter a single letter choice that is available in the menu.");
                    }
                    else {
                        choiceIndex = (int)inputChar - 65;
                        madeChoice = true;
                    }
                }
            }
        }
        return choices.get(choiceIndex);
    }


    // ----------------------------------------------------------
    /**
     * Updates values depending on the user's choice and prints
     * story updates.
     * 
     * @param choice
     *            The choice object the user selected.
     */
    public void takeAction(Choice choice) {
        System.out.println("\n" + choice.getResultText());
        timeRemaining -= choice.getTimeCost();
        distanceToClass -= choice.getDistanceReduction();
        happiness += choice.getHappinessEffect();

    }


    // ----------------------------------------------------------
    /**
     * Starts game play.
     */
    public static void main(String arg[]) {
        new User();
    }
}
