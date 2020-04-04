import java.util.Scanner;
import java.lang.*;
import java.util.Random;

class Main {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
  
    
  String wordToGuess = "pizza";
  String wordGuessed = "_____";
  char [] charsToGuess = wordToGuess.toCharArray();
  char [] charsGuessed = wordGuessed.toCharArray();

    System.out.println("Welcome! \nThis is a game of hangman.");

    System.out.println("Would you like to play? \nY/N");

    String inputWord = input.next();
    System.out.println("You said: " + inputWord);
    inputWord = inputWord.toLowerCase();

    if (inputWord.equals("y") == false){
      System.out.println("Exiting program");
      System.exit(0);
    }
    System.out.println("Starting game...");



    while(true){
      System.out.println("Would you like me to select a word? \nY/N");
      inputWord = input.next();
      System.out.println("You said: " + inputWord);
      inputWord = inputWord.toLowerCase();
      if (inputWord.equals("y")){
        System.out.println("Computer will select a word for you.");
        String [] wordBank = 
          {
            "apple",
            "orange",
            "chemicals",
            "coronavirus"
          };
        Random ran = new Random();
        int randomNumber = ran.nextInt(wordBank.length);
        wordToGuess = wordBank[randomNumber];
        wordGuessed = "";
        for (int i = 0; i < wordToGuess.length(); i++){
          wordGuessed = wordGuessed + "_";
        }
        charsToGuess = wordToGuess.toCharArray();
        charsGuessed = wordGuessed.toCharArray();
        break;
      }
      else if (inputWord.equals("n")){
        System.out.println("Please enter a word.");
        inputWord = input.next();
        inputWord = inputWord.toLowerCase();
        System.out.println("You chose: " + inputWord);
        wordToGuess = inputWord;
        wordGuessed = "";
        for (int i = 0; i < inputWord.length(); i++){
          wordGuessed = wordGuessed + "_";
        }
        charsToGuess = wordToGuess.toCharArray();
        charsGuessed = wordGuessed.toCharArray();
        System.out.print("\033[H\033[2J");  
        break;
      }
      else{
        System.out.println("Invalid Input.");
      }
    }

    int lives = 6;
    int prevCounter = 0;

    //guessing loop
    while (true){
        System.out.println("Please guess a letter.");
        inputWord = input.next();
        inputWord = inputWord.toLowerCase();
        char letterGuessed = inputWord.charAt(0);
        if (inputWord.length() != 1){
          System.out.println("Invalid length.");
          continue;
        }
        if (!Character.isLetter(letterGuessed)){
          System.out.println("Invalid character.");
          continue;
        }
        System.out.println("You guessed: " + inputWord);

        System.out.println(letterGuessed);
        int counter = 0;
        for (int i = 0; i < wordToGuess.length(); i++){
          //System.out.println("Loop number: " + i);
          //System.out.println("Current letter: " + charsToGuess[i]);
          if (charsToGuess[i] == letterGuessed){
            //System.out.println("Letter right: " + letterGuessed);
            charsGuessed[i] = letterGuessed;
            System.out.println(new String(charsGuessed));
          }
          if (charsGuessed[i] == charsToGuess[i]){
             counter += 1;
          }
        }
        if (counter == prevCounter){
          System.out.println("Wrong guess");
          lives -= 1;
          if (lives < 6){
            System.out.println("---|");
            System.out.println("   O");
          }
          if (lives == 4){
            System.out.println("   |");
            System.out.println("   |");
          }
          else if (lives == 3){
            System.out.println("  /|");
            System.out.println(" / |");
          }
          else if (lives <= 2){
            System.out.println("  /|\\");
            System.out.println(" / | \\");
          }
          if (lives == 1){
            System.out.println("  /");
            System.out.println(" / ");
          }
          if (lives == 0){
            System.out.println("  / \\");
            System.out.println(" /   \\");
            System.out.println("You lose :(");
          }
        }
        prevCounter = counter;
        if (counter == wordToGuess.length()){
          System.out.println("You win (method1)");
          System.exit(0);
          break;
        }
        // wordToGuess = new String(charsToGuess);
        // wordGuessed = new String(charsGuessed);
        // if (wordToGuess.equals(wordGuessed)){
          if (wordToGuess.equals(new String(charsGuessed))){
           System.out.println("You win (method2)");
           System.exit(0);
           break;
        }     
    }
  }
}