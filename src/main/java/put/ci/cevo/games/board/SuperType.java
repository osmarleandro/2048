package put.ci.cevo.games.board;

public abstract class SuperType extends SuperClassExtracted {
    private int gameCounter;

    public abstract int getWidth();

    public abstract int getHeight();

    /**
     * @param row
     *            0-based index
     * @param col
     *            0-based index
     */
    public abstract int getValue(int row, int col);

    public abstract void setValue(int row, int col, int color);

    /**
     * @param pos
     *            pos is not 0-based. It is currently implementation dependent
     */
    public abstract int getValue(int pos);

    public abstract SuperClassExtracted clone();

    public BoardPos newBoard(int row, int column) {
        return new BoardPos(row, column);
    }
}
