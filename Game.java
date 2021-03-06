import java.util.*;
/**
 * Write a description of class Interface here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Game
{
    //public static int n = setN();
    private ArrayList <Integer> myArray;
    private String listType;
    private TicTacToe obj1;
    private int n;
    // instance variables - replace the example below with your own
    
    public Game(TicTacToe obj)
    {
        obj1 = obj;
        n = obj1.getN();
    }

    public void newGame()
    {
        int noMoves = 0 ; int row = 0 ; int col = 0 ; 
        Scanner input = new Scanner(System.in);
        while( true ) 
        {

            System.out.print("Player X, which row?");
            row = input.nextInt();
            System.out.print("Player X, which col?");
            col = input.nextInt();

            while( !obj1.changeToX(row,col)   )
            {
                obj1.printBoard();
                System.out.print("Player X, which row?");
                row = input.nextInt();
                System.out.print("Player X, which col?");
                col = input.nextInt();    

            }
            obj1.printBoard();
            if( obj1.findWin() == true )
            {
                System.out.println( "Player X is the winner");
                break;

            }
            noMoves++ ;

            if( noMoves == n*n ) 
            {
                //draw
                System.out.println("It is a cats game.");
                //break
                break; 

            }

            System.out.print("Player Y, which row?");
            row = input.nextInt();
            System.out.print("Player Y, which col?");
            col = input.nextInt();

            while( !obj1.changeToO(row,col)   )
            {
                obj1.printBoard();
                System.out.print("Player Y, which row?");
                row = input.nextInt();
                System.out.print("Player Y, which col?");
                col = input.nextInt();   

            }
            obj1.printBoard();
            if( obj1.findWin() == true )
            {
                System.out.println( "Player O is the winner");
                break;
            }
            noMoves++ ;

        }
    }

    public void newGamePlayerVsComputer()
    {
        int noMoves = 0 ; int row = 0 ; int col = 0 ; 
        Scanner input = new Scanner(System.in);
        while( true ) 
        {

            System.out.print("Player X, which row?");
            row = input.nextInt();
            while ( row < 1 || row > n )
            {
                System.out.println( "Out of bounds, please try again!");
                System.out.print("Player X, which row?");
                row = input.nextInt();
            }
            System.out.print("Player X, which col?");
            col = input.nextInt();
            while ( col < 1 || col > n )
            {
                System.out.println( "Out of bounds, please try again!");
                System.out.print("Player X, which col?");
                col = input.nextInt();
            }

            while( !obj1.changeToX(row,col)   )
            {
                obj1.printBoard();
                System.out.print("Player X, which row?");
                row = input.nextInt();
                while ( row < 1 || row >n )
                {
                    System.out.println( "Out of bounds, please try again!");
                    System.out.print("Player X, which row?");
                    row = input.nextInt();
                }
                System.out.print("Player X, which col?");
                col = input.nextInt();
                while ( col < 1 || col > n )
                {
                    System.out.println( "Out of bounds, please try again!");
                    System.out.print("Player X, which col?");
                    col = input.nextInt();
                }
            }
            obj1.printBoard();
            if( obj1.findWin() == true )
            {
                System.out.println( "Player X is the winner");
                break;

            }
            noMoves++ ;

            if( noMoves == n*n ) 
            {
                //draw
                System.out.println("It is a cats game.");
                //break
                break; 

            }

            row = (int)( Math.random() *3+1);
            col = (int)( Math.random() *3+1);
            System.out.println( "Bot played row : " + row + ", col : " + col ) ; 

            while( !obj1.changeToO(row,col)   )
            {
                obj1.printBoard();
                //System.out.print("Player Y, which row?");
                row = (int)( Math.random() *3+1);
                //System.out.print("Player Y, which col?");
                col = (int)( Math.random() *3+1);  
                System.out.println( "Bot played row : " + row + ", col : " + col ) ; 
                //try {
                //System.in.read( ) ; }
                //catch( Exception ex ) {}
            }
            obj1.printBoard();
            if( obj1.findWin() == true )
            {
                System.out.println( "Computer is the winner");
                break;
            }
            noMoves++ ;

        }
    }


    /*public static void main(String args[])
    {

        Scanner input = new Scanner(System.in);
        Game gameObj = new Game();
        TicTacToe tttObj = new TicTacToe();
        
        System.out.println("How big do you want the board to be?" );

        tttObj.setN();
        
        System.out.println(" (1) player vs Player" );
        System.out.println(" (2) player vs Computer" );
        int option1 = input.nextInt() ; 
        input.nextLine();  
        String str1 ; 
        while( true ) 
        {

            System.out.println(" (1) player vs Player" );
            System.out.println(" (2) player vs Computer" );
            int option1 = input.nextInt() ; 
            input.nextLine();  
            gameObj.obj1.setBoard();

            if( option1 == 1 ) 
                gameObj.newGame();
            else
                gameObj.newGamePlayerVsComputer() ;
            gameObj.obj1.printBoard();
            System.out.println( "Play Again (Y/N):" ) ;
            str1 = input.nextLine() ;
            if ( str1.equals("n") || str1.equals("N") )
            {
                break ;
            }

        }
    }*/
}

