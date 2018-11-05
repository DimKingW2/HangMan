import java.util.Scanner;

public class HangMan {

    static String secretWord;
    static int guesses;
    public static void main(String[] args){
        Scanner input;
        //String secretWord;
        String letterGuessed;
        String answer;


        input = new Scanner(System.in);
        guesses = 15;


        System.out.println("Welcome to hangman. Player 1 enter a word, player 2 be ready to guess.");
        secretWord = input.next().toLowerCase();

        do {
            System.out.println("Player 2, guess a letter.");
            letterGuessed = input.next().toLowerCase();
            char letterGuessedChar = letterGuessed.charAt(0);
            if (isLetterRight(letterGuessedChar) == true) {
                System.out.println("Right!");
                System.out.println(drawManHanging(guesses));
            } else {
                System.out.println("Wrong");
                guesses --;
            }
        }while(guesses != 0);
        System.out.println("Would you like to play again? (Please only type yes or no)");
        answer = input.nextLine().toLowerCase();



    }
    public static boolean isLetterRight(char letterGuessed){
        int correct = 0;
        for(int i=0;i<secretWord.length();i++) {
            if (secretWord.charAt(i) == letterGuessed) {
                return true;
            }
        }
                return(false);
            }



    //public static String findGuessedLetters(String word){
       // String[] wordBroken=isLetterRight(word);

    //}
    //public static String showLettersGuessed(){

    //}
    public static String drawManHanging(int guesses) {
        if (guesses == 15) {
            return("-------------------------\n" +
                    "       |                |\n" +
                    "                        |\n" +
                    "                        |\n" +
                    "                        |\n" +
                    "                        |\n" +
                    "                        |\n" +
                    "                        |\n"+
                    "________________________|");
        }
        if (guesses == 14) {
            return("-------------------------\n" +
                    "       |                |\n" +
                    "       0                |\n" +
                    "                        |\n" +
                    "                        |\n" +
                    "                        |\n" +
                    "                        |\n" +
                    "                        |\n"+
                    "________________________|");
        }
        if (guesses == 13) {
            return("-------------------------\n" +
                    "       |                |\n" +
                    "       0                |\n" +
                    "       |                |\n" +
                    "                        |\n" +
                    "                        |\n" +
                    "                        |\n" +
                    "                        |\n"+
                    "________________________|");
        }
        if (guesses == 12) {
            return("-------------------------\n" +
                    "       |                |\n" +
                    "       0                |\n" +
                    "       |                |\n" +
                    "       |                |\n" +
                    "                        |\n" +
                    "                        |\n" +
                    "                        |\n"+
                    "________________________|");

        }
        if (guesses == 11) {
            return("-------------------------\n" +
                    "       |                |\n" +
                    "       0                |\n" +
                    "       |/               |\n" +
                    "       |                |\n" +
                    "                        |\n" +
                    "                        |\n" +
                    "                        |\n"+
                    "________________________|");

        }
        if (guesses == 10) {
            return("-------------------------\n" +
                    "       |                |\n" +
                    "       0                |\n" +
                    "      \\|/               |\n" +
                    "       |                |\n" +
                    "                        |\n" +
                    "                        |\n" +
                    "                        |\n"+
                    "________________________|");

        }
        if (guesses == 9) {
            return("-------------------------\n" +
                    "       |                |\n" +
                    "       0 /              |\n" +
                    "      \\|/               |\n" +
                    "       |                |\n" +
                    "                        |\n" +
                    "                        |\n" +
                    "                        |\n"+
                    "________________________|");

        }
        if (guesses == 8) {
            return("-------------------------\n" +
                    "       |                |\n" +
                    "     \\ 0 /              |\n" +
                    "      \\|/               |\n" +
                    "       |                |\n" +
                    "                        |\n" +
                    "                        |\n" +
                    "                        |\n"+
                    "________________________|");

        }
        if (guesses == 7) {
            return("-------------------------\n" +
                    "       |   _            |\n" +
                    "     \\ 0 /              |\n" +
                    "      \\|/               |\n" +
                    "       |                |\n" +
                    "                        |\n" +
                    "                        |\n" +
                    "                        |\n"+
                    "________________________|");

            }
        if (guesses == 6) {
            return("-------------------------\n" +
                    "    _  |   _            |\n" +
                    "     \\ 0 /              |\n" +
                    "      \\|/               |\n" +
                    "       |                |\n" +
                    "                        |\n" +
                    "                        |\n" +
                    "                        |\n"+
                    "________________________|");

        }
        if (guesses == 5) {
            return("-------------------------\n" +
                    "    _  |   _            |\n" +
                    "     \\ 0 /              |\n" +
                    "      \\|/               |\n" +
                    "       |                |\n" +
                    "      /                 |\n" +
                    "                        |\n" +
                    "                        |\n"+
                    "________________________|");

        }
        if (guesses == 4) {
            return("-------------------------\n" +
                    "    _  |   _            |\n" +
                    "     \\ 0 /              |\n" +
                    "      \\|/               |\n" +
                    "       |                |\n" +
                    "      /\\                |\n" +
                    "                        |\n" +
                    "                        |\n"+
                    "________________________|");

        }
        if (guesses == 3) {
            return("-------------------------\n" +
                    "    _  |   _            |\n" +
                    "     \\ 0 /              |\n" +
                    "      \\|/               |\n" +
                    "       |                |\n" +
                    "      /\\                |\n" +
                    "     /                  |\n" +
                    "                        |\n"+
                    "________________________|");

        }
        if (guesses == 2) {
            return("-------------------------\n" +
                    "    _  |   _            |\n" +
                    "     \\ 0 /              |\n" +
                    "      \\|/               |\n" +
                    "       |                |\n" +
                    "      /\\                |\n" +
                    "     /  \\               |\n" +
                    "                        |\n"+
                    "________________________|");

        }
        if (guesses == 1) {
            return("-------------------------\n" +
                    "    _  |   _            |\n" +
                    "     \\ 0 /              |\n" +
                    "      \\|/               |\n" +
                    "       |                |\n" +
                    "      /\\                |\n" +
                    "     /  \\               |\n" +
                    "   _                    |\n"+
                    "________________________|");

        }
        if (guesses == 0) {
            return("-------------------------\n" +
                    "    _  |   _            |\n" +
                    "     \\ 0 /              |\n" +
                    "      \\|/               |\n" +
                    "       |                |\n" +
                    "      /\\                |\n" +
                    "     /  \\               |\n" +
                    "   _      _             |\n"+
                    "________________________|");

        }
    }


    }




