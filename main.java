/*
ticTacToe.java

This is a Tic Tac Toe program with a full GUI (using Swing) and 1-2 player options.
A project for Computer Science 112 

Last edited 04/26/2023 by Adam Marx
 */

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // initialize a 2-dimensional array to represent the board
        char[][] board = {{' ', ' ', ' '},
                          {' ', ' ', ' '},
                          {' ', ' ', ' '}};

        printBoard(board);

        // Main game loop:
        while (true) {
            playerTurn(board, scanner);
            if (isGameFinished(board)){
                break;
            } // end if
            printBoard(board);

            computerTurn(board);
            if (isGameFinished(board)){
                break;
            } // end if
            printBoard(board);
        } // end while
        scanner.close();
    } // end main method

    /***********************************************************************************/

    private static boolean isGameFinished(char[][] board) {

        if (hasContestantWon(board, 'X')) {
            printBoard(board);
            System.out.println("Player wins!");
            return true;
        } // end if (hasContestantWon(board, 'X'))

        if (hasContestantWon(board, 'O')) {
            printBoard(board);
            System.out.println("Computer wins!");
            return true;
        } // end if (hasContestantWon(board, 'O'))

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == ' ') {
                    return false;
                } // end if 
            } // end for (int j = 0; j < board[i].length; j++)
        } // end for (int i = 0; i < board.length; i++) 
        printBoard(board);
        System.out.println("The game ended in a tie!");
        return true;
    } // end private static boolean isGameFinished(char[][] board) 

    /***********************************************************************************/

    private static boolean hasContestantWon(char[][] board, char symbol) {
        if ((board[0][0] == symbol && board [0][1] == symbol && board [0][2] == symbol) ||
                (board[1][0] == symbol && board [1][1] == symbol && board [1][2] == symbol) ||
                (board[2][0] == symbol && board [2][1] == symbol && board [2][2] == symbol) ||

                (board[0][0] == symbol && board [1][0] == symbol && board [2][0] == symbol) ||
                (board[0][1] == symbol && board [1][1] == symbol && board [2][1] == symbol) ||
                (board[0][2] == symbol && board [1][2] == symbol && board [2][2] == symbol) ||

                (board[0][0] == symbol && board [1][1] == symbol && board [2][2] == symbol) ||
                (board[0][2] == symbol && board [1][1] == symbol && board [2][0] == symbol) ) {
            return true;
        } // end if 
        return false;
    } // end private static boolean hasContestantWon(char[][] board, char symbol)

    /***********************************************************************************/

    private static void computerTurn(char[][] board) {
        Random rand = new Random();
        int computerMove;
        while (true) {
            computerMove = rand.nextInt(9) + 1;
            if (isValidMove(board, Integer.toString(computerMove))) {
                break;
            } // end if 
        } // end while 
        System.out.println("Computer chose " + computerMove);
        placeMove(board, Integer.toString(computerMove), 'O');
    } // end private static void computerTurn(char[][] board) 

    /***********************************************************************************/

    private static boolean isValidMove (char[][] board, String position) {
        switch(position) {
            case "1":
                return (board[0][0] == ' ');
            case "2":
                return (board[0][1] == ' ');
            case "3":
                return (board[0][2] == ' ');
            case "4":
                return (board[1][0] == ' ');
            case "5":
                return (board[1][1] == ' ');
            case "6":
                return (board[1][2] == ' ');
            case "7":
                return (board[2][0] == ' ');
            case "8":
                return (board[2][1] == ' ');
            case "9":
                return (board[2][2] == ' ');
            default:
                return false;
        } // end switch case
    } //end private static boolean isValidMove (char[][] board, String position) {

    /***********************************************************************************/

    private static void playerTurn(char[][] board, Scanner scanner) {
        String userInput;
        while (true) {
            System.out.println("Where would you like to play? (1-9)");
            userInput = scanner.nextLine();
            if (isValidMove(board, userInput)){
                break;
            } // end if 
            else {
                System.out.println(userInput + " is not a valid move.");
            } // end else 
        } // end while 
        placeMove(board, userInput, 'X');
    } // end private static void playerTurn(char[][] board, Scanner scanner) 

    /***********************************************************************************/

    private static void placeMove(char[][] board, String position, char symbol) {
        switch(position) {
            case "1":
                board[0][0] = symbol;
                break;
            case "2":
                board[0][1] = symbol;
                break;
            case "3":
                board[0][2] = symbol;
                break;
            case "4":
                board[1][0] = symbol;
                break;
            case "5":
                board[1][1] = symbol;
                break;
            case "6":
                board[1][2] = symbol;
                break;
            case "7":
                board[2][0] = symbol;
                break;
            case "8":
                board[2][1] = symbol;
                break;
            case "9":
                board[2][2] = symbol;
                break;
            default:
                System.out.println(":(");
        } // end switch case 
    } // end private static void placeMove(char[][] board, String position, char symbol) 

    /***********************************************************************************/

    private static void printBoard(char[][] board) {
        System.out.println(board[0][0] + "|" +  board[0][1] + "|" +  board[0][2] );
        System.out.println("-+-+-");
        System.out.println(board[1][0] + "|" +  board[1][1] + "|" +  board[1][2] );
        System.out.println("-+-+-");
        System.out.println(board[2][0] + "|" +  board[2][1] + "|" +  board[2][2] );
    } // end private static void printBoard(char[][] board)
} // end Main class
