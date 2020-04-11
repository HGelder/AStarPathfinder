public class Node {

    enum NodeState {
        WALKABLE,
        UNWALKABLE
    }

    private int row;
    private int col; 
    private int f;
    private int g;
    private int h;
    private String contents;
    private Node parent;
    private NodeState state;

    public Node (int row, int col, NodeState state, String value) {
        this.row = row;
        this.col = col;
        this.state = state;
        this.contents = value;
    }

    public String getContents () {
        return contents;
    }
    public void setContents (String value) {
        this.contents = value;
    }

    public int getRow () {
        return row;
    }
    public int getCol () {
        return col;
    }

    public int getF () {
        return f;
    }
    public void setF (int f) {
        this.f = f;
    }

    public int getG () {
        return g;
    }
    public void setG (int g) {
        this.g = g;
    }
    
    public int getH () {
        return h;
    }
    public void setH (int h) {
        this.h = h;
    }

    public Node getParent () {
        return parent;
    }
    public void setParent (Node parent) {
        this.parent = parent;
    }

    public NodeState getState () {
        return state;
    }
    public void setState (String state) {
        if (state.equals("W")) {
            this.state = NodeState.WALKABLE;
        } else if (state.equals("U")) {
            this.state = NodeState.UNWALKABLE;
        }
    }
}