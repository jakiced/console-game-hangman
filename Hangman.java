public class Hangman {

    public static String[] words = {"ant", "baboon", "badger", "bat", "bear", "beaver", "camel",
    "cat", "clam", "cobra", "cougar", "coyote", "crow", "deer",
    "dog", "donkey", "duck", "eagle", "ferret", "fox", "frog", "goat",
    "goose", "hawk", "lion", "lizard", "llama", "mole", "monkey", "moose",
    "mouse", "mule", "newt", "otter", "owl", "panda", "parrot", "pigeon", 
    "python", "rabbit", "ram", "rat", "raven","rhino", "salmon", "seal",
    "shark", "sheep", "skunk", "sloth", "snake", "spider", "stork", "swan",
    "tiger", "toad", "trout", "turkey", "turtle", "weasel", "whale", "wolf",
    "wombat", "zebra"};

    public static String[] gallows = {"+---+\n" +
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
    " =========\n"};

    public static String randomWord() {
        String word = "";
        int randomNumber = (int)(Math.random() * words.length);
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






    }

}





