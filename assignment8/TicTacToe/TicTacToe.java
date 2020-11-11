package TicTacToe;

import java.util.*;


/**
 * I put some codes I wrote in ticTacToe.java file which can give some tips I think. 
 * You can just delete codes or functions I wrote if you come up with some other methods to finish the requirements.
 */

public class TicTacToe {
    private static List<Integer> playerPositions = new ArrayList<>();
    private static List<Integer> cpuPositions = new ArrayList<>();

    public static void main(String[] args) {
        char[][] gameBoard = {
                {' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '},
        };

        printGameBoard(gameBoard);

        while (true) {
            Scanner scan = new Scanner(System.in);
            System.out.println("Enter your placement (1-9): ");
            int playerPos = scan.nextInt();
            // write your code here

            // check whether the player's position is a valid one.
            if (checkPositionValid(playerPos)) {
                System.out.println("Your choice is " + playerPos);
                // place the player's position on the board.
                placePiece(gameBoard, playerPos, "player");
                // check whether the game is over.
                if (checkGameOver()) {
                    break;
                }

                // now, it's cpu's turn.
                System.out.println("Now it is cpu's turn, cpu is thinking.");
                // cpuIsThinking() returns a valid position.
                int cpuPos = cpuIsThinking();
                System.out.println("CPU's choice is " + cpuPos);
                // place the cpu's position on the board.
                placePiece(gameBoard, cpuPos, "cpu");
                // check whether the game is over.
                if (checkGameOver()) {
                    break;
                }
            } else {
                System.out.println("The placement isn't valid, please select another position.");
            }
        }
    }

    // Create a function that draws the board and prints it
    // out like a 3*3 square
    public static void printGameBoard(char[][] gameBoard) {
        // write your code here

        for (int i = 0; i < gameBoard.length; ++i) {
            for (int j = 0; j < gameBoard[i].length; ++j) {
                System.out.print(gameBoard[i][j]);
            }
            System.out.println();
        }
    }

    public static void placePiece(char[][] gameBoard, int pos, String user) {

        char symbol = ' ';
        if (user.equals("player")) {
            symbol = 'X';
            playerPositions.add(pos);
        } else if (user.equals("cpu")) {
            symbol = 'O';
            cpuPositions.add(pos);
        }
        
        // write your code here

        // let pos become pos - 1, then, it would be easier
        // to get row and column.
        pos = pos - 1;
        int row = pos / 3;
        int column = pos % 3;
        gameBoard[2 * row][2 * column] = symbol;

        // every time draw a new board.
        printGameBoard(gameBoard);
    }

    public static String checkWinner() {
        // write your code here

        // ??? is there any better solution? ask TAS.

        // a player or CPU wins if they have 3 of their symbols
        // in one row, column, or diagonal.
        String winner = "";
        // the winner must have 3 or more positions.
        if (playerPositions.size() >= 3 || cpuPositions.size() >= 3) {
            // row
            for (int i = 1; i <= 9; i += 3) {
                if (playerPositions.contains(i) && playerPositions.contains(i + 1)
                        && playerPositions.contains(i + 2)) {
                    winner = "player";
                    break;
                }
                if (cpuPositions.contains(i) && cpuPositions.contains(i + 1)
                        && cpuPositions.contains(i + 2)) {
                    winner = "cpu";
                    break;
                }
            }

            // column
            if (winner.equals("")) {
                for (int i = 1; i <= 3; ++i) {
                    if (playerPositions.contains(i) && playerPositions.contains(i + 3)
                            && playerPositions.contains(i + 6)) {
                        winner = "player";
                        break;
                    }
                    if (cpuPositions.contains(i) && cpuPositions.contains(i + 3)
                            && cpuPositions.contains(i + 6)) {
                        winner = "cpu";
                        break;
                    }
                }
            }

            // diagonal
            if (winner.equals("")) {
                if (((playerPositions.contains(1) && playerPositions.contains(9))
                        || (playerPositions.contains(3) && playerPositions.contains(7)))
                        && playerPositions.contains(5)) {
                    winner = "player";
                }
                if (((cpuPositions.contains(1) && cpuPositions.contains(9))
                        || (cpuPositions.contains(3) && cpuPositions.contains(7)))
                        && cpuPositions.contains(5)) {
                    winner = "cpu";
                }
            }
        }

        return winner;
    }

    // the method is used to check whether the position is a valid one.
    public static boolean checkPositionValid(int pos) {
        // if palyer or cpu already occupied the position,
        // this position is not valid.
        return (!playerPositions.contains(pos)) && (!cpuPositions.contains(pos));
    }

    // the method is used to check whether the game board is full.
    public static boolean checkFull() {
        // if the sum of positions player and cpu occupied
        // is equal to 9, the board is full.
        return playerPositions.size() + cpuPositions.size() == 9;
    }

    // the method is used to check whether the game is over.
    public static boolean checkGameOver() {
        boolean gameIsOver = false;
        String winner = checkWinner();

        // if the game has a winner, then game is over.
        if (winner.equals("cpu")) {
            System.out.println("CPU wins! Sorry:(");
            gameIsOver = true;
        } else if (winner.equals("player")) {
            System.out.println("Congratulations you won!");
            gameIsOver = true;
        } else if (checkFull()) {
            // or, if the board is full, the game is over.
            System.out.println("CAT!");
            gameIsOver = true;
        }

        return gameIsOver;
    }

    // the method returns cpu's choice.
    public static int cpuIsThinking() {
        // let cpu take's 2 seconds to think the position,
        // making it more like a real game. Because when we
        // playing games, we need some time to determine the
        // next position.
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // cpu is trying to find a valid position.
        int cpuPos;
        do {
            cpuPos = (int) (Math.random() * 9 + 1);
        } while (!checkPositionValid(cpuPos));

        return cpuPos;
    }
}










