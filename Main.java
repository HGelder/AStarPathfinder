import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner; 

public class Main {

    public static Board gameBoard;
    private static Scanner userInput;
    private static int[] input = {0, 0};
    private static int boardSize = 5;

    public static void main (String args[]) {
        newGame(boardSize, boardSize);
        placeObject(getObjectCell("Player"), "Player");
        placeObject(getObjectCell("Enemy"), "Enemy");
        placeObject(getObjectCell("Wall"), "Wall");
        placeObject(getObjectCell("Wall"), "Wall");
        placeObject(getObjectCell("Wall"), "Wall");
    }

    public static void newGame (int maxRows, int maxCols) {
        gameBoard = new Board(maxRows, maxCols);
        gameBoard.clear();
        gameBoard.print();
    }

    public static int[] getObjectCell (String object) {

        userInput = new Scanner(System.in);
        
        if (object.equals("Player")) {

            System.out.print("Enter row number in which to place player: ");
            input[0] = userInput.nextInt();
            
            while (input[0] < 0 || input[0] > 4) {
                System.out.println("Please enter a number between 0 and 4");
                input[0] = userInput.nextInt();
            }

            System.out.print("Enter col number in which to place player: ");
            input[1] = userInput.nextInt();

            while (input[1] < 0 || input[1] > 4) {
                System.out.println("Please enter a number between 0 and 4");
                input[1] = userInput.nextInt();
            }

            System.out.println("Player (P) cell chosen: " + Arrays.toString(input));

        } else if (object.equals("Enemy")) {

            System.out.print("Enter row number in which to place enemy: ");
            input[0] = userInput.nextInt();

            while (input[0] < 0 || input[0] > 4) {
                System.out.println("Please enter a number between 0 and 4");
                input[0] = userInput.nextInt();
            }

            System.out.print("Enter col number in which to place enemy: "); 
            input[1] = userInput.nextInt();

            while (input[1] < 0 || input[1] > 4) {
                System.out.println("Please enter a number between 0 and 4");
                input[1] = userInput.nextInt();
            }

            System.out.println("Enemy (E) cell chosen: " + Arrays.toString(input));

        } else if (object.equals("Wall")) {

            System.out.print("Enter row number in which to place wall: ");
            input[0] = userInput.nextInt();

            while (input[0] < 0 || input[0] > 4) {
                System.out.println("Please enter a number between 0 and 4");
                input[0] = userInput.nextInt();
            }

            System.out.print("Enter col number in which to place wall: ");
            input[1] = userInput.nextInt();

            while (input[1] < 0 || input[1] > 4) {
                System.out.println("Please enter a number between 0 and 4");
                input[1] = userInput.nextInt();
            }

            System.out.println("Wall (X) cell chosen: " + Arrays.toString(input));
        }
        return input;
    }

    public static void placeObject (int[] cell, String object) {

        int rowNum = (int)Array.get(cell, 0);
        int colNum = (int)Array.get(cell, 1);

        String tileContents = gameBoard.getTile(rowNum, colNum).getContents();

        if (object.equals("Player")) {

            if (tileContents.equals("[ ]")) {
                gameBoard.setTile(rowNum, colNum, "[P]");
                gameBoard.print();
            } else {
                System.out.println("Cell already occupied. Please choose an empty cell.");
                placeObject(getObjectCell("Player"), "Player");
            }

        } else if (object.equals("Enemy")) {
            
            if (tileContents.equals("[ ]")) {
                gameBoard.setTile(rowNum, colNum, "[E]");
                gameBoard.print();
            } else {
                System.out.println("Cell already occupied. Please choose an empty cell.");
                placeObject(getObjectCell("Enemy"), "Enemy");
            }

        } else if (object.equals("Wall")) {

            if (tileContents.equals("[ ]")) {
                gameBoard.setTile(rowNum, colNum, "[X]");
                gameBoard.print();
            } else {
                System.out.println("Cell already occupied. Please choose an empty cell.");
                placeObject(getObjectCell("Wall"), "Wall");

            }
        }
    }
}