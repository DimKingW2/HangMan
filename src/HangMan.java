import java.util.Random;
import java.util.Scanner;


public class HangMan {

    private static String secretWord;

    public static void main(String[] args) {
        Scanner input;
        String letterGuessed;
        String answer;
        String currentGuessPhrase;
        int guesses = 15;
        int score1 = 0;
        int score2 = 0;
        input = new Scanner(System.in);


        do{
            System.out.println("Would you like to play single player or multi player?(Type S for single player and M for multi player)");
            String s_or_m = input.next().toLowerCase();
            while (!s_or_m.equals("s") && !s_or_m.equals("m")) {
                System.out.println("Only type s or m.");
                s_or_m = input.next().toLowerCase();
            }
            if(s_or_m.equals("s")) {
                System.out.println("In single player you will be facing a computer. The computer will make the word, and you will have to guess it.");
                String[] arr = {"ago","extra","stone","beauty","group","rod","coast","eye","blank","ancient","thin","process","pale","daily","particles","use","sign","experience","size","cast",
                        "volume","sound","rock","through","outline","suddenly","riding","behind","into","vowel","reader","pattern","point","leather","deal","travel","yesterday","corner","start","written",
                        "hold","refused","like","slightly","into","poet","gradually","blow","smallest","scene","year","season","stared","dust","related","mixture","tears","gate","wise","smile",
                        "speak","farmer","dry","outline","must","especially","early","close","task","however","suit","chair","consider","success","hearing","meat","teach","brush","individual","earlier",
                        "border","statement","saddle","dirty","blanket","business","west","speak","product","wheel","dropped","series","refused","place","eaten","could","occur","say","huge","flame",
                        "path","loud","bottom","drink","dinner","camp","wherever","behind","breath","happened","oxygen","original","chosen","twenty","apart","without","new","drove","straw","depth",
                        "breathe","pen","orbit","except","walk","mostly","soil","news","which","eager","tropical","be","sudden","use","activity","door","worry","orange","across","travel",
                        "build","nobody","frog","cave","ants","stand","promised","off","all","putting","proud","jar","negative","bow","easily","teach","cap","highway","donkey","produce",
                        "breakfast","stiff","stopped","minute","village","planning","roar","reason","hang","first","already","easily","birth","easier","butter","let","orbit","driven","enter","upward",
                        "but","musical","own","remember","cream","pocket","habit","avoid","collect","sleep","carried","bank","useful","support","thus","eventually","flag","positive","find","fog",
                        "there","yes","bee","rocky","recently","show","molecular","guide","dropped","mood","obtain","research","dress","speed","particular","lunch","select","colony","flew","machine",
                        "The quick brown fox jumps over the lazy dog", "The lake is a long way from here", "The book is in front of the table", "A glittering gem is not enough",
                        "Don't step on the broken glass", "We need to rent a room for our party", "This is a Japanese doll", "The mysterious diary records the voice", "She always speaks to him in a loud voice",
                        "Christmas is coming", "Where do random thoughts come from", "How was the math test", "Mary plays the piano", "The book is in front of the table",
                        "I want more detailed information", "She advised him to come back at once", "I am never at home on Sundays", "Two seats were vacant",
                        "Let me help you with your baggage", "The river stole the gods", "stay away from it", "I really want dessert", "I would have gotten the promotion",
                        "the roads were impassable", "I checked to make sure", "it was not the right thing to do", "Malls are great places to shop", "The sky is clear",
                        "the stars are twinkling", "It was getting dark", "Is it free", "he went anyway", "we visited Africa", "he was not there yesterday"};
                Random r = new Random();
                int randomNumber = r.nextInt(arr.length);
                secretWord = (arr[randomNumber]).toLowerCase();
                if (secretWord.length() <= 5) {
                    System.out.println("This is a easy word/phrase");
                } else if (secretWord.length() <= 10) {
                    System.out.println("This is a average word/phrase");
                } else if (secretWord.length() <= 15) {
                    System.out.println("This is a hard word/phrase");
                } else {
                    System.out.println("Good Luck guessing this one.");
                }
                currentGuessPhrase = setSecretWord(secretWord);
                do{
                    System.out.println("Guess a letter.");
                    letterGuessed = input.next().toLowerCase();
                    while (letterGuessed.length() > 1) {
                        System.out.println("A letter, not letters...");
                        letterGuessed = input.next().toLowerCase();
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
                    if (currentGuessPhrase.equals(secretWord)){
                        System.out.println("Good Job you guessed the word/phrase.");
                        break;
                    }
                }while (guesses != 0);
                while(guesses != 15){
                    guesses++;
                }
                if(!currentGuessPhrase.equals(secretWord)){
                    System.out.println("Nope, the word was " + secretWord + ".");
                    System.out.println("-------------------------\n" +
                                        "       |                |\n" +
                                        "       0                |\n" +
                                        "      /|\\               |\n" +
                                        "     / | \\              |\n" +
                                        "    ; /\\ ;              |\n" +
                                        "     /  \\               |\n" +
                                        "   _      _             |\n" +
                                        "________________________|");
                }

            }
            int whoGoes = 0;
            if (s_or_m.equals("m")) {
                System.out.println("Hangman is a game where one person enters a word and another will guess the word.\n" +
                        "Player one will choose a word first, then player two will guess letters. For this game\n" +
                        "the winner will get a point. If you enter the word, you win if they don't guess it.\n" +
                        "If you don't enter the word, you win by guessing it. The first to win 3 games, wins Hangman.");
                while((score1 < 3) && (score2 < 3)) {
                    if (whoGoes % 2 == 0) {
                        System.out.println("Player 1 enter a word or phrase, player 2 be ready to guess.");
                    } else {
                        System.out.println("Player 2 enter a word or phrase, player 1 be ready to guess.");
                    }
                    secretWord = input.nextLine().toLowerCase();
                    secretWord = input.nextLine().toLowerCase();
                    currentGuessPhrase = setSecretWord(secretWord);
                    System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n" +
                            "\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");//the most advanced anti cheat software
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
                        letterGuessed = input.next().toLowerCase();
                        while (letterGuessed.length() > 1) {
                            System.out.println("A letter, not letters...");
                            letterGuessed = input.next().toLowerCase();
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
                    }while (guesses != 0);
                    if(!currentGuessPhrase.equals(secretWord)){
                        System.out.println("Nope, the word was " + secretWord + ".");
                    }

                    while (guesses != 15) {
                        guesses++;
                    }


                    if (whoGoes % 2 == 0) {
                        if (!currentGuessPhrase.equals(secretWord)) {
                            System.out.println("Player 1 wins!");
                            score1 += 1;

                        } else if (currentGuessPhrase.equals(secretWord)) {
                            System.out.println("Player 2 wins!");
                            score2 += 1;
                        }
                    } else {
                        if (!currentGuessPhrase.equals(secretWord)) {
                            System.out.println("Player 2 wins!");
                            score2 += 1;
                        } else if (currentGuessPhrase.equals(secretWord)) {
                            System.out.println("Player 1 wins!");
                            score1 += 1;
                        }
                    }
                    System.out.println("The score is " + score1 + " to " + score2 + ".(player 1: player 2)");
                    whoGoes ++;
                }
                if(score1 == 3){
                    System.out.println("Player 1 wins the game!");
                }
                else if(score2 == 3){
                    System.out.println("Player 2 wins the game!");
                }
            }


            System.out.println("Would you like to play again? (Please only type y or n)");
            answer = input.next().toLowerCase();


            }while (answer.equals("y")) ;
            if (!answer.equals("y")) {
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
