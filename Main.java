import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;
import java.util.List;

public class Main {

    public static Board gameBoard;
    public static Node currentNode;
    public static Node startNode; 
    public static Node endNode; 
    public static Node[][] boardTiles; 

    private static Scanner userInput;
    private static int boardSize = 5;
    private static int[] input = {0, 0};
    private static List<Node> tempNeighbours; 

    public static void main (String args[]) {
        newGame(boardSize, boardSize);
        placeObject(getObjectCell("Player"), "Player");
        placeObject(getObjectCell("Enemy"), "Enemy");
        placeObject(getObjectCell("Wall"), "Wall");
        placeObject(getObjectCell("Wall"), "Wall");
        placeObject(getObjectCell("Wall"), "Wall");

        boardTiles = gameBoard.getTiles();
        AI ai = new AI (startNode, endNode, gameBoard, boardTiles);

        currentNode = startNode;
        tempNeighbours = ai.getNeighbours(startNode, boardTiles);
        
        for (int i = 0; i < tempNeighbours.size(); i++) {
            ai.addToList("Open", tempNeighbours.get(i));
            tempNeighbours.get(i).setParent(currentNode);
        }

        ai.removeFromList("Open", currentNode);
        ai.addToList("Closed", currentNode);
    }

    public static void newGame (int maxRows, int maxCols) {
        gameBoard = new Board(maxRows, maxCols);
        gameBoard.clear();
        gameBoard.print();
    }

    public static int[] getObjectCell (String object) {

        userInput = new Scanner(System.in);
        
        if (object.equals("Player")) {

            System.out.print("Enter row number (1-5) in which to place player: ");
            input[0] = userInput.nextInt();
            
            while (input[0] < 1 || input[0] > 5) {
                System.out.println("Please enter a number between 1 and 5");
                input[0] = userInput.nextInt();
            }

            System.out.print("Enter col number (1-5) in which to place player: ");
            input[1] = userInput.nextInt();

            while (input[1] < 1 || input[1] > 5) {
                System.out.println("Please enter a number between 1 and 5");
                input[1] = userInput.nextInt();
            }

            System.out.println("Player (P) cell chosen: " + Arrays.toString(input));

        } else if (object.equals("Enemy")) {

            System.out.print("Enter row number (1-5) in which to place enemy: ");
            input[0] = userInput.nextInt();

            while (input[0] < 1 || input[0] > 5) {
                System.out.println("Please enter a number between 1 and 5");
                input[0] = userInput.nextInt();
            }

            System.out.print("Enter col number (1-5) in which to place enemy: "); 
            input[1] = userInput.nextInt();

            while (input[1] < 1 || input[1] > 5) {
                System.out.println("Please enter a number between 1 and 5");
                input[1] = userInput.nextInt();
            }

            System.out.println("Enemy (E) cell chosen: " + Arrays.toString(input));

        } else if (object.equals("Wall")) {

            System.out.print("Enter row number (1-5) in which to place wall: ");
            input[0] = userInput.nextInt();

            while (input[0] < 1 || input[0] > 5) {
                System.out.println("Please enter a number between 1 and 5");
                input[0] = userInput.nextInt();
            }

            System.out.print("Enter col number (1-5) in which to place wall: ");
            input[1] = userInput.nextInt();

            while (input[1] < 1 || input[1] > 5) {
                System.out.println("Please enter a number between 1 and 5");
                input[1] = userInput.nextInt();
            }

            System.out.println("Wall (X) cell chosen: " + Arrays.toString(input));
        }
        return input;
    }

    public static void placeObject (int[] cell, String object) {

        int rowNum = (int)Array.get(cell, 0) - 1;
        int colNum = (int)Array.get(cell, 1) - 1;

        String tileContents = gameBoard.getTile(rowNum, colNum).getContents();
        Node.NodeState state = gameBoard.getTile(rowNum, colNum).getState(); 

        if (object.equals("Player")) {

            if (tileContents.equals("[ ]")) {
                endNode = new Node(rowNum, colNum, Node.NodeState.WALKABLE, "[P]"); 
                gameBoard.setTile(rowNum, colNum, "[P]");
                gameBoard.print();
            } else {
                System.out.println("Cell already occupied. Please choose an empty cell.");
                placeObject(getObjectCell("Player"), "Player");
            }

        } else if (object.equals("Enemy")) {
            
            if (tileContents.equals("[ ]")) {
                startNode = new Node(rowNum, colNum, Node.NodeState.WALKABLE, "[E]"); 
                gameBoard.setTile(rowNum, colNum, "[E]");
                gameBoard.print();
            } else {
                System.out.println("Cell already occupied. Please choose an empty cell.");
                placeObject(getObjectCell("Enemy"), "Enemy");
            }

        } else if (object.equals("Wall")) {

            if (tileContents.equals("[ ]")) {
                state = Node.NodeState.UNWALKABLE; 
                gameBoard.setTile(rowNum, colNum, "[X]");
                gameBoard.print();
            } else {
                System.out.println("Cell already occupied. Please choose an empty cell.");
                placeObject(getObjectCell("Wall"), "Wall");

            }
        }
    }
}