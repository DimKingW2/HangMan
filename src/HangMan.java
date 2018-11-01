import java.util.Scanner;

public class HangMan {

    static String secretWord;
    public static void main(String[] args){
        Scanner input;
        int guesses;
        //String secretWord;
        String letterGuessed;
        drawManHanging();
        findGuessedLetters();
        showLettersGuessed();
        //isLetterRight();
        String answer;


        input = new Scanner(System.in);
        guesses = 0;


        System.out.println("Welcome to hangman. Player 1 enter a word, player 2 be ready to guess.");
        secretWord = input.next().toLowerCase();
        System.out.println("Player 2, guess a letter.");
        letterGuessed = input.next().toLowerCase();
        char letterGueesedChar = letterGuessed.charAt(0);
        System.out.println("Would you like to play again? (Please only type yes or no)");
        answer = input.nextLine().toLowerCase();



    }
    public static boolean isLetterRight(char letterGuessed){
        for(int i=0;i<secretWord.length();i++){
            if(secretWord.charAt(i)==letterGuessed){

            }
        }
        secretWord.charAt();
        //String[] wordBroken = secretWord.split(" ");
        return secretWord.contains(letterGuessed);

    }
    public static String findGuessedLetters(String word){
        String[] wordBroken=isLetterRight(word);

    }
    public static String showLettersGuessed(){

    }
    public static String drawManHanging(int guesses) {
        if (guesses = 15) {
            return
        }
        if (guesses = 14) {
            return
        }
        if (guesses = 13) {
            return
        }
        if (guesses = 12) {
            return

        }
        if (guesses = 11) {
            return

        }
        if (guesses = 10) {
            return

        }
        if (guesses = 9) {
            return ("----------------------\n         |           |\n         O           |\n                     |\n                     |" +
                    "\n                     |\n                     |\n                     |\n                     |\n                     |"
                    + "\n_____________________|");

        }
        if (guesses = 8) {
            return ("----------------------\n         |           |\n         O           |\n                     |\n                     |" +
                    "\n                     |\n                     |\n                     |\n                     |\n                     |"
                    + "\n_____________________|");

        }
        if (guesses = 7) {
            return ("----------------------\n         |           |\n         O           |\n                     |\n                     |" +
                    "\n                     |\n                     |\n                     |\n                     |\n                     |"
                    + "\n_____________________|");

            }
        if (guesses = 6) {
            return ("----------------------\n         |           |\n         O           |\n                     |\n                     |" +
                    "\n                     |\n                     |\n                     |\n                     |\n                     |"
                    + "\n_____________________|");

        }
        if (guesses = 5) {
            return ("----------------------\n         |           |\n         O           |\n                     |\n                     |" +
                    "\n                     |\n                     |\n                     |\n                     |\n                     |"
                    + "\n_____________________|");

        }
        if (guesses = 4) {
            return ("----------------------\n         |           |\n         O           |\n                     |\n                     |" +
                    "\n                     |\n                     |\n                     |\n                     |\n                     |"
                    + "\n_____________________|");

        }
        if (guesses = 3) {
            return ("----------------------\n         |           |\n         O           |\n                     |\n                     |" +
                    "\n                     |\n                     |\n                     |\n                     |\n                     |"
                    + "\n_____________________|");

        }
        if (guesses = 2) {
            return ("----------------------\n         |           |\n         O           |\n                     |\n                     |" +
                    "\n                     |\n                     |\n                     |\n                     |\n                     |"
                    + "\n_____________________|");

        }
        if (guesses = 1) {
            return ("----------------------\n         |           |\n         O           |\n                     |\n                     |" +
                    "\n                     |\n                     |\n                     |\n                     |\n                     |"
                    + "\n_____________________|");

        }
        if (guesses = 0) {
            return ("----------------------\n         |           |\n         O           |\n                     |\n                     |" +
                    "\n                     |\n                     |\n                     |\n                     |\n                     |"
                    + "\n_____________________|");

        }
    }


    }




