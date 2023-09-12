import java.util.Scanner;
public class Turn {
    public static void main(String[] args) {
        Board board= new Board();
        board.print();
        Player white = new Player('\u25cb' , board);
        Player black = new Player('\u25cf' , board);
        boolean t = false;
        Scanner input = new Scanner(System.in);

        while (true){
            if(t == false && white.hasMove() == false){
                System.out.println(" Rest ");
                break;
            }
            if(t == true && black.hasMove() == false){
                System.out.println(" Rest ");
                break;
            }
            if(t == false){
                System.out.println("It's the first player's turn : ");
                int x = input.nextInt();
                x--;
                String c = input.next();
                int y = (int)c.charAt(0) - 65;
                if(x < 0 || x >=8 || y<0 || y>=8 || board.board[x][y].getCell()!= '\u25a1'){
                    System.out.println("this input is not valid ");
                    continue;
                }
                if(white.move(x,y) == false){
                    System.out.println("this input is not valid");
                    continue;
                }
                t = true;
                board.print();
                continue;

            }
            if(t == true){
                System.out.println("It's the second player's turn : ");
                int x = input.nextInt();
                x--;
                String c = input.next();
                int y = (int)c.charAt(0) - 65;
                if(x < 0 || x >=8 || y<0 || y>=8 || board.board[x][y].getCell()!= '\u25a1'){
                    System.out.println("this input is not valid");
                    continue;
                }
                if(black.move(x,y) == false){
                    System.out.println("this input is not valid");
                    continue;
                }
                t = false;
                board.print();

            }


        }
        while (white.hasMove()){
            System.out.println("It's the first player's turn : ");
            int x = input.nextInt();
            x--;
            String c = input.next();
            int y = (int)c.charAt(0) - 65;
            if(x < 0 || x >=8 || y<0 || y>=8 || board.board[x][y].getCell()!= '\u25a1'){
                System.out.println("this input is not valid ");
                continue;
            }
            if(white.move(x,y) == false){
                System.out.println("this input is not valid");
                continue;
            }
            board.print();
        }
        while (black.hasMove()){
            System.out.println("It's the second player's turn : ");
            int x = input.nextInt();
            x--;
            String c = input.next();
            int y = (int)c.charAt(0) - 65;
            if(x < 0 || x >=8 || y<0 || y>=8 || board.board[x][y].getCell()!= '\u25a1'){
                System.out.println("this input is not valid");
                continue;
            }
            if(black.move(x,y) == false){
                System.out.println("this input is not valid");
                continue;
            }
            board.print();
        }
        if(white.cnt() > black.cnt())
            System.out.println("the first player won");
        else if(white.cnt() == black.cnt())
            System.out.println("tie");
        else
            System.out.println("the second player won");

    }
}
