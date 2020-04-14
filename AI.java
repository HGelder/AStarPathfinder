import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AI {

    public Node startNode;
    public Node endNode;
    public Board gameBoard;
    public Node[][] boardTiles;
    public List<Node> open = new ArrayList<>();
    public List<Node> closed = new ArrayList<>();

    public AI (Node startNode, Node endNode, Board gameBoard, Node[][] boardTiles) {
        this.startNode = startNode;
        this.endNode = endNode; 
        this.gameBoard = gameBoard;
        this.boardTiles = boardTiles;
    }
    
    public void addToList (String list, Node node) {
        if (list.equals("Open")) {
            open.add(node);
        } else if (list.equals("Closed")) {
            closed.add(node);
        }
    }
    public void removeFromList (String list, Node node) {
        if (list.equals("Open")) {
            open.remove(node);
        } else if (list.equals("Closed")) {
            closed.remove(node);
        }
    }

    public List<Node> getNeighbours (Node currentNode, Node[][] boardTiles) {
        int row = currentNode.getRow();
        int col = currentNode.getCol();

        int[] points = { row-1, col, row+1, col, row, col-1, row, col+1 };

        List<Node> result = new ArrayList<>();

        for (int i = 0; i < points.length; i++) {
            int x = points[i];
            int y = points[++i];

            if (x >= 0 && x < boardTiles.length 
            && boardTiles[x][y].getState() == Node.NodeState.WALKABLE) {
                result.add(boardTiles[x][y]);
            }
        }
        return result;
    }

    public List<Node> getPath(Node startNode, Node endNode, Node[][] boardTiles) {

        List<Node> path = new ArrayList<>();
        List<Node> neighbours = new ArrayList<>();
        boolean endReached = false; 
        Node currentNode = startNode;

        for (int x = 0; x < boardTiles.length; x++) { 
            for (int y = 0; y < boardTiles.length; y++) {
                boardTiles[x][y].setH(Math.abs(endNode.getRow() - x) + Math.abs(endNode.getCol() - y));
            }
        }

        while (!endReached) {

            neighbours = getNeighbours(currentNode, boardTiles);
            List<Integer> fCosts = new ArrayList<>();
            
            for (int i = 0; i < neighbours.size(); i++) {
                if (neighbours.get(i).getState() != Node.NodeState.UNWALKABLE) {

                    addToList("Open", neighbours.get(i));
                    neighbours.get(i).setParent(currentNode);
                    neighbours.get(i).setG(neighbours.get(i).getG() + 10);

                    int fCost = neighbours.get(i).getG() + neighbours.get(i).getH();
                    neighbours.get(i).setF(fCost);

                    fCosts.add(fCost);
                }
            }

            Collections.sort(fCosts);
            int smallestFCost = fCosts.get(0);

            for (int j = 0; j < open.size(); j++) {
                if (open.get(j).getF() == smallestFCost) {
                    addToList("Closed", currentNode);
                    currentNode = open.get(j);
                }
            }

            if (currentNode == endNode) {
                endReached = true;
            }
        }
        System.out.println("End reached");
        return path;
    }
}