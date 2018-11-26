import java.util.Scanner;


public class HangMan {

    private static String secretWord;

    public static void main(String[] args) {
        Scanner input;
        String letterGuessed;
        String answer;
        String currentGuessPhrase;


        input = new Scanner(System.in);
        int guesses = 15;





        do {
            System.out.println("Hangman is a game where one person enters a word and another will guess the word.\n" +
                    "Player one will choose a word first, then player two will guess letters. For this game\n" +
                    "the winner will get a point. If you enter the word, you win if they don't guess it.\n" +
                    "If you don't enter the word, you win by guessing it. The first to win 3 games, wins Hangman.");
            int score1 = 0;
            int score2 = 0;
            int whoGoes = 0;
            //String singleMulti;
            //start multi player coding
            while ((score1 < 3) || (score2 < 3)) {
                if(whoGoes % 2 == 0){
                    System.out.println("Player 1 enter a word or phrase, player 2 be ready to guess.");
                } else {
                    System.out.println("Player 2 enter a word or phrase, player 1 be ready to guess.");
                }
                secretWord = input.nextLine().toLowerCase();
                System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n" +
                        "\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");//the most advanced anti cheat software
                currentGuessPhrase = setSecretWord(secretWord);
                if (secretWord.length() <= 5) {
                    System.out.println("This is a easy word/phrase");
                } else if (secretWord.length() <= 10) {
                    System.out.println("This is a average word/phrase");
                } else if (secretWord.length() <= 15) {
                    System.out.println("This is a hard word/phrase");
                } else {
                    System.out.println("Good Luck guessing this one.");

                }


                do {
                    System.out.println("Guess a letter.");
                    letterGuessed = input.nextLine().toLowerCase();
                    while(letterGuessed.length() > 1){
                        System.out.println("A letter, not letters...");
                        letterGuessed=input.nextLine().toLowerCase();
                    }
                    char letterGuessedChar = letterGuessed.charAt(0);
                    if (isLetterRight(letterGuessedChar, currentGuessPhrase)) {
                        System.out.println("Right!");

                    } else {
                        System.out.println("Wrong");
                        guesses--;

                    }

                    currentGuessPhrase = showLettersGuessed(letterGuessedChar, secretWord, currentGuessPhrase);
                    System.out.println(currentGuessPhrase);
                    System.out.println(drawManHanging(guesses));
                    System.out.println("You have " + guesses + " guesses left.");
                    if (currentGuessPhrase.equals(secretWord)) {
                        break;
                    }

                }
                while (guesses != 0);
                if(whoGoes % 2 == 0){
                    if (!currentGuessPhrase.equals(secretWord)) {
                        System.out.println("Player 1 wins!");
                        score1 += 1;
                    } else {
                        System.out.println("Player 2 wins!");
                        score2 += 1;
                    }
                }
                else {
                    if (!currentGuessPhrase.equals(secretWord)) {
                        System.out.println("Player 2 wins!");
                        score2 += 1;
                    } else {
                        System.out.println("Player 1 wins!");
                        score1 += 1;
                    }
                }
                while (guesses != 15){
                    guesses ++;
                }
                whoGoes ++;
                System.out.println("The score is " + score1 + " to " + score2 + " .(Player 1 : Player 2)");
                if(score1 == 3) {
                    System.out.println("Player 1 Won The Game!");
                    break;
                }
                if(score2 == 3){
                    System.out.println("Player 2 Won The Game!");
                    break;
                }

            }
            System.out.println("Would you like to play again? (Please only type y or n)");
            answer = input.nextLine().toLowerCase();


        }while(answer.equals("y"));
        if(!answer.equals("y")){
            System.out.println("Ok then...");
            input.close();
            System.exit(0);
        }
    }
    private static boolean isLetterRight(char letterGuessed, String currentGuessPhrase){
        if(currentGuessPhrase.contains(String.valueOf(letterGuessed))){
            return false;
        }
        if((String.valueOf(letterGuessed).length() >= 2)){
            return false;
        }
        for(int i=0;i<secretWord.length();i++) {
            if (secretWord.charAt(i) == letterGuessed) {
                return true;
            }
        }
        return(false);


    }
    private static String setSecretWord(String secretWord) {
        String hiddenWord = "";
        for(int i=0;i<secretWord.length();i++) {
            hiddenWord = secretWord.replaceAll("\\S", "-");
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
