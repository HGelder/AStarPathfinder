public class Board {

    public final int maxX;
    public final int maxY;
    public Node[][] boardTiles;

    public Board(int maxX, int maxY) {
        this.maxX = maxX;
        this.maxY = maxY;
        this.boardTiles = new Node[maxX][maxY];

        for (int x = 0; x < maxX; x++) {
            for (int y = 0; y < maxY; y++) {
                boardTiles[x][y] = new Node(x, y, Node.NodeState.WALKABLE, "[ ]");
            }
        }
    }

    public Node[][] getTiles() {
        return boardTiles;
    }

    public Node getTile(int x, int y) {
        return this.boardTiles[x][y];
    }
    public void setTile(int x, int y, String contents) {
        this.boardTiles[x][y].setContents(contents);
    }

    public void print() {
        for (int x = 0; x < maxX; x++) {
            for (int y = 0; y < maxY; y++) {
                System.out.print(getTile(x, y).getContents());
            }
            System.out.println();
        }
    }
    
}