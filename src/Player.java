
import java.util.ArrayList;
public class Player {
    private int countOfCell ;
    private ArrayList<Integer>[][] aim ;
    private char color ;
    private char oppColor ;
    private Board board ;

    /**
     * Instantiates a new Player.
     *
     * @param color the color
     * @param board the board
     */
    public Player(char color , Board board){
        aim = new ArrayList[8][8];
        for(int i = 0 ; i< 8 ; i++)
            for(int j=0 ; j < 8 ; j++)
                aim[i][j] = new ArrayList<>();
        this.color = color ;
        if(color == '\u25cf')
            oppColor = '\u25cb';
        else
            oppColor = '\u25cf';
        this.board = board;
        countOfCell = 2;
        updateNextMove();
    }

    /**
     * Build aim.
     *
     * @param x the x
     * @param y the y
     */
    void buildAim(int x , int y){
        int i = x+1 , j = y ;
        while (i < 8 && board.board[i][j].getCell() == oppColor)
            i++;
        if(i < 8 && i != x+1 && board.board[i][j].getCell() == color)
            aim[x][y].add(1);
        i = x-1;
        while (i >=0 && board.board[i][j].getCell() == oppColor)
            i--;
        if(i >=0 && i != x-1 && board.board[i][j].getCell() == color)
            aim[x][y].add(2);
        i = x ; j = y+1;
        while (j < 8 && board.board[i][j].getCell() == oppColor)
            j++;
        if (j < 8 && j != y+1 && board.board[i][j].getCell() == color)
            aim[x][y].add(3);
        i = x; j = y-1;
        while ( j>=0 && board.board[i][j].getCell() == oppColor)
            j--;
        if(j>=0 && j != y-1 && board.board[i][j].getCell() == color)
            aim[x][y].add(4);
        i = x-1; j =y+1 ;
        while (i >= 0 && j< 8 && board.board[i][j].getCell() == oppColor ){
            i--; j++;
        }
        if(i >= 0 && j< 8 &&i != x-1 && board.board[i][j].getCell() == color)
            aim[x][y].add(5);
        i = x+1; j = y+1;
        while (i < 8 && j < 8 && board.board[i][j].getCell() == oppColor){
            i++; j++;
        }
        if(i < 8 && j < 8 && i != x+1 && board.board[i][j].getCell() == color)
            aim[x][y].add(6);
        i = x+1 ;j=y-1;
        while (i < 8 && j>=0 && board.board[i][j].getCell() == oppColor){
            i++; j--;
        }
        if(i < 8 && j>=0 && i != x+1 && board.board[i][j].getCell() == color)
            aim[x][y].add(7);
        i = x-1 ; j = y-1;
        while (i >= 0 && j>= 0 && board.board[i][j].getCell() == oppColor){
            i--;j--;
        }
        if (i >= 0 && j>= 0 && i != x-1 && board.board[i][j].getCell() == color)
            aim[x][y].add(8);
    }

    /**
     * Update next move.
     */
    public void updateNextMove (){
        for(int i = 0 ; i < 8 ; i++)
            for( int j = 0 ; j < 8 ; j++){
                aim[i][j].clear();;
                if(board.board[i][j].getCell() == '\u25a1' )
                    buildAim(i , j);
            }

    }

    /**
     * Has move boolean.
     *
     * @return the boolean
     */
    public boolean hasMove(){
        updateNextMove();
        for(int i=0 ; i < 8 ; i++)
            for(int j = 0 ;j < 8 ; j++)
                if(aim[i][j].size() > 0)
                    return true;
        return false;
    }

    /**
     * Cnt int.
     *
     * @return the int
     */
    public int cnt (){
        countOfCell = 0 ;
        for(int i = 0 ; i < 8 ; i++ )
            for(int j = 0 ; j < 8 ; j++ )
                if(board.board[i][j].getCell() == color)
                    countOfCell ++;
        return countOfCell;
    }

    /**
     * Move boolean.
     *
     * @param x the x
     * @param y the y
     * @return the boolean
     */
    public boolean move(int x , int y){
        updateNextMove();
        if(aim[x][y].size() ==0)
            return false;
        board.board[x][y].setCell(color);
        int i=x , j =y;
        if(aim[x][y].contains(1)){
            i = x+1 ;
            while (board.board[i][j].getCell() == oppColor){
                board.board[i][j].setCell(color);
                i++;
            }
        }
        if(aim[x][y].contains(2)){
            i = x-1;
            while (board.board[i][j].getCell() == oppColor){
                board.board[i][j].setCell(color);
                i--;
            }
        }
        if(aim[x][y].contains(3)){
            i = x ; j = y+1;
            while (board.board[i][j].getCell() == oppColor){
                board.board[i][j].setCell(color);
                j++;
            }
        }
        if(aim[x][y].contains(4)){
            i = x ; j = y-1;
            while (board.board[i][j].getCell() == oppColor){
                board.board[i][j].setCell(color);
                j--;
            }
        }
        if (aim[x][y].contains(5)){
            i = x-1 ; j=y+1;
            while (board.board[i][j].getCell() == oppColor){
                board.board[i][j].setCell(color);
                i--; j++;
            }
        }
        if(aim[x][y].contains(6)){
            i = x+1 ; j =y+1 ;
            while (board.board[i][j].getCell() == oppColor){
                board.board[i][j].setCell(color);
                i++; j++;
            }
        }
        if(aim[x][y].contains(7)){
            i=x+1 ; j=y-1;
            while (board.board[i][j].getCell() == oppColor){
                board.board[i][j].setCell(color);
                i++; j--;
            }
        }
        if(aim[x][y].contains(8)){
            i=x-1; j=y-1;
            while (board.board[i][j].getCell() == oppColor){
                board.board[i][j].setCell(color);
                i--; j--;
            }
        }
        return true;

    }

}
