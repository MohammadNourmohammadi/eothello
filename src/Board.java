
public class Board {
    public Cell [][] board ;
    private char black = '\u25cf';
    private char white = '\u25cb';

    /**
     * Instantiates a new Board.
     */
    public Board(){
        board = new Cell[8][8];
        for(int i =0 ; i < 8 ; i ++)
            for( int j = 0 ;j < 8 ; j++)
                board[i][j] = new Cell();
        board[3][3].setCell(white);
        board[4][4].setCell(white);
        board[3][4].setCell(black);
        board[4][3].setCell(black);
    }

    /**
     * Print.
     */
    public void print (){
        for( int i = 0 ; i < 8 ; i ++ ){
            for(int j = 0 ; j < 8 ; j++)
                board[i][j].print();
            System.out.println();
        }
        System.out.println("******************************");

    }
}
