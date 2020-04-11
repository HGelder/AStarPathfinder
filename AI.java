import java.util.ArrayList;
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
}