
public class Cell {
    private char cell ;

    /**
     * Instantiates a new Cell.
     */
    public Cell (){
        cell = '\u25a1';
    }

    /**
     * Gets cell.
     *
     * @return the cell
     */
    public char getCell() {
        return cell;
    }

    /**
     * Sets cell.
     *
     * @param cell the cell
     */
    public void setCell(char cell) {
        this.cell = cell;
    }

    /**
     * Print.
     */
    public void print(){
        System.out.print(" "+cell);

    }
}
