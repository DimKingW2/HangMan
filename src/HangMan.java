import java.util.Scanner;

public class HangMan {

    private static String secretWord;

    public static void main(String[] args){
        Scanner input;
        //String secretWord;
        String letterGuessed;
        //String answer;
        String currentGuessPhrase;


        input = new Scanner(System.in);
        int guesses = 15;



        System.out.println("Welcome to hangman. Player 1 enter a word, player 2 be ready to guess.");
        secretWord = input.next().toLowerCase();
        currentGuessPhrase = setSecretWord(secretWord);


        do {
            System.out.println("Player 2, guess a letter.");
            letterGuessed = input.next().toLowerCase();
            char letterGuessedChar = letterGuessed.charAt(0);
            if (isLetterRight(letterGuessedChar)) {
                System.out.println("Right!");

            } else {
                System.out.println("Wrong");
                guesses--;

            }

            currentGuessPhrase = showLettersGuessed(letterGuessedChar, secretWord,currentGuessPhrase);
            System.out.println(currentGuessPhrase);
            System.out.println(drawManHanging(guesses));
            System.out.println("You have " + guesses + " guesses left.");

        }while(guesses != 0);
        System.out.println("To Bad");
        input.close();
        System.exit(0);
        //System.out.println("Would you like to play again? (Please only type yes or no)");
        //answer = input.nextLine().toLowerCase();



    }
    private static boolean isLetterRight(char letterGuessed){
        for(int i=0;i<secretWord.length();i++) {
            if (secretWord.charAt(i) == letterGuessed) {
                return true;
            }
        }
                return(false);

    }
    private static String setSecretWord(String secretWord) {
        String hiddenWord = "";
        String guessedLetters = "";
        for(int i=0;i<secretWord.length();i++) {
            hiddenWord = secretWord.replaceAll("[^" + guessedLetters + "^]", "_");

        }
        return  hiddenWord;
    }


    private static String showLettersGuessed(char letterGuessed, String secretWord, String hiddenWord){
        //String hiddenWord = setSecretWord(secretWord);
        char[] cSecret = secretWord.toCharArray();
        char[] cHid = hiddenWord.toCharArray();
        for(int i=0; i < cHid.length; i++){
            if(cSecret[i] == letterGuessed){
                cHid[i] = cSecret[i];
            }
            hiddenWord = new String(cHid);
        }
        return hiddenWord;

    }
    private static String drawManHanging(int guesses) {
        if (guesses == 15) {
            return("-------------------------\n" +
                    "       |                |\n" +
                    "                        |\n" +
                    "                        |\n" +
                    "                        |\n" +
                    "                        |\n" +
                    "                        |\n" +
                    "                        |\n" +
                    "________________________|");
        }
        else if (guesses == 14) {
            return("-------------------------\n" +
                    "       |                |\n" +
                    "       0                |\n" +
                    "                        |\n" +
                    "                        |\n" +
                    "                        |\n" +
                    "                        |\n" +
                    "                        |\n" +
                    "________________________|");
        }
        else if (guesses == 13) {
            return("-------------------------\n" +
                    "       |                |\n" +
                    "       0                |\n" +
                    "       |                |\n" +
                    "                        |\n" +
                    "                        |\n" +
                    "                        |\n" +
                    "                        |\n" +
                    "________________________|");
        }
        else if (guesses == 12) {
            return("-------------------------\n" +
                    "       |                |\n" +
                    "       0                |\n" +
                    "       |                |\n" +
                    "       |                |\n" +
                    "                        |\n" +
                    "                        |\n" +
                    "                        |\n" +
                    "________________________|");

        }
        else if (guesses == 11) {
            return("-------------------------\n" +
                    "       |                |\n" +
                    "       0                |\n" +
                    "       |/               |\n" +
                    "       |                |\n" +
                    "                        |\n" +
                    "                        |\n" +
                    "                        |\n" +
                    "________________________|");

        }
        else if (guesses == 10) {
            return("-------------------------\n" +
                    "       |                |\n" +
                    "       0                |\n" +
                    "      \\|/               |\n" +
                    "       |                |\n" +
                    "                        |\n" +
                    "                        |\n" +
                    "                        |\n" +
                    "________________________|");

        }
        else if (guesses == 9) {
            return("-------------------------\n" +
                    "       |                |\n" +
                    "       0 /              |\n" +
                    "      \\|/               |\n" +
                    "       |                |\n" +
                    "                        |\n" +
                    "                        |\n" +
                    "                        |\n" +
                    "________________________|");

        }
        else if (guesses == 8) {
            return("-------------------------\n" +
                    "       |                |\n" +
                    "     \\ 0 /              |\n" +
                    "      \\|/               |\n" +
                    "       |                |\n" +
                    "                        |\n" +
                    "                        |\n" +
                    "                        |\n" +
                    "________________________|");

        }
        else if (guesses == 7) {
            return("-------------------------\n" +
                    "       |   _            |\n" +
                    "     \\ 0 /              |\n" +
                    "      \\|/               |\n" +
                    "       |                |\n" +
                    "                        |\n" +
                    "                        |\n" +
                    "                        |\n" +
                    "________________________|");

        }
        else if (guesses == 6) {
            return("-------------------------\n" +
                    "    _  |   _            |\n" +
                    "     \\ 0 /              |\n" +
                    "      \\|/               |\n" +
                    "       |                |\n" +
                    "                        |\n" +
                    "                        |\n" +
                    "                        |\n" +
                    "________________________|");

        }
        else if (guesses == 5) {
            return("-------------------------\n" +
                    "    _  |   _            |\n" +
                    "     \\ 0 /              |\n" +
                    "      \\|/               |\n" +
                    "       |                |\n" +
                    "      /                 |\n" +
                    "                        |\n" +
                    "                        |\n" +
                    "________________________|");

        }
        else if (guesses == 4) {
            return("-------------------------\n" +
                    "    _  |   _            |\n" +
                    "     \\ 0 /              |\n" +
                    "      \\|/               |\n" +
                    "       |                |\n" +
                    "      /\\                |\n" +
                    "                        |\n" +
                    "                        |\n" +
                    "________________________|");

        }
        else if (guesses == 3) {
            return("-------------------------\n" +
                    "    _  |   _            |\n" +
                    "     \\ 0 /              |\n" +
                    "      \\|/               |\n" +
                    "       |                |\n" +
                    "      /\\                |\n" +
                    "     /                  |\n" +
                    "                        |\n" +
                    "________________________|");

        }
        else if (guesses == 2) {
            return("-------------------------\n" +
                    "    _  |   _            |\n" +
                    "     \\ 0 /              |\n" +
                    "      \\|/               |\n" +
                    "       |                |\n" +
                    "      /\\                |\n" +
                    "     /  \\               |\n" +
                    "                        |\n" +
                    "________________________|");

        }
        else if (guesses == 1) {
            return("-------------------------\n" +
                    "    _  |   _            |\n" +
                    "     \\ 0 /              |\n" +
                    "      \\|/               |\n" +
                    "       |                |\n" +
                    "      /\\                |\n" +
                    "     /  \\               |\n" +
                    "   _                    |\n" +
                    "________________________|");

        }
        else{
            return("-------------------------\n" +
                    "    _  |   _            |\n" +
                    "     \\ 0 /              |\n" +
                    "      \\|/               |\n" +
                    "       |                |\n" +
                    "      /\\                |\n" +
                    "     /  \\               |\n" +
                    "   _      _             |\n" +
                    "________________________|");

        }


    }
}
