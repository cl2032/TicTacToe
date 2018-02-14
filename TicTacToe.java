import java.util.*;
/**
 * Write a description of class TicTacToe here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TicTacToe
{
    // instance variables - replace the example below with your own
    private int x;
    private String tokenWinner = "";
    static String[][] board = new String[3][3];
    /**
     * Constructor for objects of class TicTacToe
     */
    public static void setBoard()
    {
        // initialise instance variables
        System.out.println( "       col col col " );
        System.out.println( "        1   2   3  " );
        System.out.println( "      -------------" );

        for( int i1 = 0 ; i1 <3 ; i1++)
        {
            System.out.print( "Row " + (i1 +1 ) + " " );
            for ( int i2 = 0 ; i2 < 3 ; i2++)
            {
                board[i1][i2] = ("   ");
                System.out.print("|");
                System.out.print(board[i1][i2]);
            }
            System.out.print("|");
            System.out.println();
            System.out.println("      -------------");
        }
    }

    public static void printBoard()
    {
        // initialise instance variables
        int n = 4;
        System.out.println( "       " );
        for( int i1 = 0 ; i1 < n ; i1++ )
        {
            System.out.print( "col ");
            
        }
        System.out.println();
        System.out.println( "        1   2   3  " );
        System.out.println( "      -------------" );

        for( int i1 = 0 ; i1 <3 ; i1++)
        {
            System.out.print( "Row " + (i1 +1 ) + " " );
            for ( int i2 = 0 ; i2 < 3 ; i2++)
            {
                System.out.print("|");
                System.out.print(board[i1][i2]);
            }
            System.out.print("|");
            System.out.println();
            System.out.println("      -------------");
        }
    }

    public boolean changeToX(int row, int col)
    {
        if (board[row-1][col-1] == "   ")
        {
            board[row-1][col-1] = " X ";
            return true ;    
        }
        else
        {
            System.out.println("Already played, try again");
            return false ; 
        }

    }

    public boolean changeToO(int row, int col)
    {
        if (board[row-1][col-1] == "   ")
        {
            board[row-1][col-1] = " O ";
            return true;
        }
        else
        {
            System.out.println("Already played, try again");
            return false;
        }
    }

    public boolean checkToken( String token ) 
    {
        if( board[0][0] == token)
        {
            if( board[0][1] ==  token && board[0][2] == token )
            {
                return true ; 
            }

            if( board[1][1] ==  token && board[2][2] == token )
            {
                return true ; 
            }

            if( board[1][0] ==  token && board[2][0] == token )
            {
                return true ; 
            }

        }
        if( board[0][1] ==  token)
        {
            if( board[1][1] ==  token && board[2][1] == token )
            {
                return true ; 
            }

        }

        if( board[0][2] ==  token)
        {
            if( board[1][1] ==  token && board[2][0] == token )
            {
                return true ; 
            }

            if( board[1][2] ==  token && board[2][2] == token )
            {
                return true ; 
            }

        }

        if( board[1][0] ==  token)
        {
            if( board[1][1] ==  token && board[1][2] == token )
            {
                return true ; 
            }

        }

        if( board[2][0] ==  token)
        {
            if( board[2][1] ==  token && board[2][2] == token )
            {
                return true ; 
            }

        }

        return false;

    }

    public  boolean findWin()
    {
        if ( checkToken( " O " ) ) 
        {
            tokenWinner = "O" ;
            return true ; 
        }

        if ( checkToken( " X " ) ) 
        {
            tokenWinner = "X" ;
            return true ; 
        }

        return false ;
    }

    public static void main(String args[])
    {
        TicTacToe obj1 = new TicTacToe();
        obj1.setBoard();
        obj1.changeToO(2,2);
        obj1.printBoard();
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public int sampleMethod(int y)
    {
        // put your code here
        return x + y;
    }
}
