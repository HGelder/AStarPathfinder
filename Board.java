public class Board {

    public final String space = "[ ]";
    public final int maxRows;
    public final int maxCols;
    private String[][] boardTiles;

    public Board (int maxRows, int maxCols) {
        this.maxRows = maxRows;
        this.maxCols = maxCols;
        this.boardTiles = new String[maxRows][maxCols];
    }

    public String getTile (int rowNumber, int colNumber) {
        return this.boardTiles[rowNumber][colNumber];
    }

    public void setTile (int rowNumber, int colNumber, String value) {
        this.boardTiles[rowNumber][colNumber] = value;
    }

    public void clear () {
        for (int rowNumber = 0; rowNumber < maxRows; rowNumber++) {
            for (int colNumber = 0; colNumber < maxCols; colNumber++) {
                setTile(rowNumber, colNumber, space);
            }
        }
    }

    public void print () {
        for (int rowNumber = 0; rowNumber < maxRows; rowNumber++) {
            for (int colNumber = 0; colNumber < maxCols; colNumber++) {
                System.out.print(getTile(rowNumber, colNumber));
            }
            System.out.println();
        }
    }
}