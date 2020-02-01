import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    String wordToGuess = "earth";
    String wordGuessed = "_____";

    System.out.println("Welcome! \nThis is a game of hangman.");

    System.out.println("Would you like to play? \nY/N?");

    String inputWord = input.next();
    //System.out.println("You said: " + inputWord );
    if (!inputWord.equals("Y") && !inputWord.equals("y")){
      System.out.println("Exiting program");
      System.exit(0);
    } 
    System.out.println("Starting game...");
    while (true){
      System.out.println("Please guess a letter.");
      inputWord = input.next();
      System.out.println("You guessed: " + inputWord);
    }

    
  }
  
}