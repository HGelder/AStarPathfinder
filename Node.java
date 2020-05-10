public class Node {

    enum NodeState {
        WALKABLE,
        UNWALKABLE
    }

    private int x; 
    private int y; 
    private int f;
    private int g;
    private int h; 
    private String contents;
    private Node parent; 
    private NodeState state;

    public Node(int x, int y, NodeState state, String contents) {
        this.x = x;
        this.y = y;
        this.state = state;
        this.contents = contents;
    }

    public String getContents() {
        return contents;
    }
    public void setContents(String contents) {
        this.contents = contents;
    }

    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }

    public int getF() {
        return f;
    }
    public void setF(int f) {
        this.f = f;
    }

    public int getG() {
        return g;
    }
    public void setG(int g) {
        this.g = g;
    }

    public int getH() {
        return h;
    }
    public void setH(int h) {
        this.h = h;
    }

    public Node getParent() {
        return parent;
    }
    public void setParent(Node parent) {
        this.parent = parent;
    }

    public NodeState getState() {
        return state;
    }
    public void setState(String state) {
        if (state.equals("W")) {
            this.state = NodeState.WALKABLE;
        } else if (state.equals("U")) {
            this.state = NodeState.UNWALKABLE;
        }
    }

}