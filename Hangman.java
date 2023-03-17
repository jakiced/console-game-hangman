import java.util.Scanner;

public class Hangman {

    public static Scanner scan = new Scanner(System.in);

    public static String[] words = { "ant", "baboon", "badger", "bat", "bear", "beaver", "camel",
            "cat", "clam", "cobra", "cougar", "coyote", "crow", "deer",
            "dog", "donkey", "duck", "eagle", "ferret", "fox", "frog", "goat",
            "goose", "hawk", "lion", "lizard", "llama", "mole", "monkey", "moose",
            "mouse", "mule", "newt", "otter", "owl", "panda", "parrot", "pigeon",
            "python", "rabbit", "ram", "rat", "raven", "rhino", "salmon", "seal",
            "shark", "sheep", "skunk", "sloth", "snake", "spider", "stork", "swan",
            "tiger", "toad", "trout", "turkey", "turtle", "weasel", "whale", "wolf",
            "wombat", "zebra" };

    public static String[] gallows = { "+---+\n" +
            "|   |\n" +
            "    |\n" +
            "    |\n" +
            "    |\n" +
            "    |\n" +
            "=========\n",

            "+---+\n" +
                    "|   |\n" +
                    "O   |\n" +
                    "    |\n" +
                    "    |\n" +
                    "    |\n" +
                    "=========\n",

            "+---+\n" +
                    "|   |\n" +
                    "O   |\n" +
                    "|   |\n" +
                    "    |\n" +
                    "    |\n" +
                    "=========\n",

            " +---+\n" +
                    " |   |\n" +
                    " O   |\n" +
                    "/|   |\n" +
                    "     |\n" +
                    "     |\n" +
                    " =========\n",

            " +---+\n" +
                    " |   |\n" +
                    " O   |\n" +
                    "/|\\  |\n" +
                    "     |\n" +
                    "     |\n" +
                    " =========\n",

            " +---+\n" +
                    " |   |\n" +
                    " O   |\n" +
                    "/|\\  |\n" +
                    "/    |\n" +
                    "     |\n" +
                    " =========\n",

            " +---+\n" +
                    " |   |\n" +
                    " O   |\n" +
                    "/|\\  |\n" +
                    "/ \\  |\n" +
                    "     |\n" +
                    " =========\n" };

    public static String randomWord() {
        String word = "";
        int randomNumber = (int) (Math.random() * words.length);
        for (int i = 0; i < words.length; i++) {
            word = words[randomNumber];
        }
        return word;
    }

    public static void printPlaceholders(char[] placeholders) {
        for (int i = 0; i < placeholders.length; i++) {
            System.out.print(placeholders[i] + " ");
        }
        System.out.print("\n");
    }

    public static boolean checkGuess(char[] word, String playerGuess) {
        for (int i = 0; i < word.length; i++) {
            if (playerGuess.equals(String.valueOf(word[i]))) {
                return true;
            }
        }
        return false;
    }

    public static void printMissedGuesses(char[] word, String playerGuess) {
        String missed = "";
        for (int i = 0; i < word.length; i++) {
            missed = "";
            if (!checkGuess(word, playerGuess)) {
                missed += playerGuess;
            }
        }
        System.out.print("Misses: " + missed);
        System.out.println();
    }

    public static void updatePlaceholders(char[] randomWord, char[] placeholders, char guess) {
        for (int i = 0; i < randomWord.length; i++) {
            if (randomWord[i] == guess) {
                placeholders[i] = guess;
            }
        }
    }

    public static void main(String[] args) {

        char[] randomWord = randomWord().toCharArray();
        char[] placeholders = new char[randomWord.length];
        System.out.print("\n");
        String incorrectGuess = "";
        int gallowsCount = 0;

        for (int i = 0; i < placeholders.length; i++) {
            placeholders[i] = '_';

        }

        while (gallowsCount < 6) {
            System.out.println("\n");
            System.out.println(gallows[gallowsCount]);
            System.out.print("Word: ");
            printPlaceholders(placeholders);
            System.out.print("\n");
            System.out.print("Guess: ");
            char guess = scan.nextLine().charAt(0);

            if (!checkGuess(randomWord, String.valueOf(guess))) {
                incorrectGuess += guess;
                gallowsCount++;
            } else {
                updatePlaceholders(randomWord, placeholders, guess);
            }
            System.out.print("\n");

            if (!String.valueOf(placeholders).contains("_")) {
                System.out.println(gallows[gallowsCount]);
                System.out.print("\nWord was: " + String.valueOf(randomWord));
                System.out.println("\nGOOD JOB!");
                break;
            }
            printMissedGuesses(randomWord, incorrectGuess);
        }

        System.out.println();
        if (gallowsCount == 6) {
            System.out.println(gallows[gallowsCount]);
            System.out.println("RIP");
            System.out.println("The word was: " + "'" + String.valueOf(randomWord) + "'");
        }

    }

}
