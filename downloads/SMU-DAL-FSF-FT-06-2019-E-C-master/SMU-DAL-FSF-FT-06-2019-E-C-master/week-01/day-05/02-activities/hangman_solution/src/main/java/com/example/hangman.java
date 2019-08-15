package com.example;
import java.util.Random;
import java.util.Scanner;

public class hangman {
    public static int numLives = 10;
    public static String[] words = {"feather", "turducken", "horizon", "sample"};
    public static boolean isEnd = false;
    public static boolean isWinner = false;
    public static int correctCount = 0;

    public static void main (String[] args){

        //Using a loop alter your program to continuously ask the user for input until the game ends.
        String magicWord = selectWord(words);
        long uniqueCount = countUniqueCharacters(magicWord);


        while (!isEnd && !isWinner){
            //Using the methods add the logic that allows a  player can start a game, guess a letter
            System.out.println("Select a letter");
            Scanner scanner = new Scanner(System.in);
            String input = scanner.next();

            // See if it is correct, and decrement lives as needed

            boolean correct = isContained(magicWord, input);
            printIsCorrect(correct);

            if(!correct){
                decrementLives();
            }else{
                incrementCorrectCount();
            }

            printLives();
            System.out.println();

            isWinner = correctCount >= uniqueCount;
            isEnd = isOver(numLives);
        }

        if(isEnd) {
            System.out.println("Game Over");
        } else {
            System.out.println("You win");
        }





//                - Add a feature that allows the user to input “spent” and see a list of letters already guessed.
//        - Add a feature that allows a user to play games continuously tracking number of wins and loses.

    }

    // Build a method that prints the current number of lives to the console.
    public static void printLives(){
        System.out.println("You have " + numLives + " lives remaining.");
    }

    // Build a method that prints  “correct” or “incorrect” to the console depending on which boolean (true or false) is passed into the method
    public static void printIsCorrect(boolean isCorrect){
        if(isCorrect){
            System.out.println("Correct!");
        } else {
            System.out.println("Incorrect.");
        }
    }

    // Build a method that determines if a letter is in a word and returns a boolean.
    public static boolean isContained(String word, String input){
        return word.contains(input);
    }

    // Build a method that randomly selects 1 word from the array (hint:look up random number generation)
    public static String selectWord(String[] words){
        return words[new Random().nextInt(words.length)];
    }

    // Build a method that decrements the lives when called.
    public static void decrementLives(){
        numLives--;
    }

    // Build a method that checks if lives are depleted and returns a boolean.

    public static boolean isOver(int numLives){
        return numLives <= 0;
    }

    //Build a method the counts the unique characters in a word
    public static long countUniqueCharacters(String input) {
        return input.chars()
                .distinct()
                .count();
    }

    // Build a method that increments the correctCount when called.
    public static void incrementCorrectCount(){
        correctCount++;
    }
}
