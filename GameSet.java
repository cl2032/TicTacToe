import java.util.*;
/**
 * Write a description of class Interface here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameSet
{
    private ArrayList <Integer> myArray;
    private String listType;
    private TicTacToe obj1 = new TicTacToe();
    private int n = 0 ;

    public static int n()
    {
        return this.n;
    }
    // instance variables - replace the example below with your own

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

            if( noMoves == 9 ) 
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
            while ( row < 1 || row > 3 )
            {
                System.out.println( "Out of bounds, please try again!");
                System.out.print("Player X, which row?");
                row = input.nextInt();
            }
            System.out.print("Player X, which col?");
            col = input.nextInt();
            while ( col < 1 || col > 3 )
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
                while ( row < 1 || row > 3 )
                {
                    System.out.println( "Out of bounds, please try again!");
                    System.out.print("Player X, which row?");
                    row = input.nextInt();
                }
                System.out.print("Player X, which col?");
                col = input.nextInt();
                while ( col < 1 || col > 3 )
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

            if( noMoves == 9 ) 
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

}


