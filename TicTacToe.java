import java.util.*;	
/**	+//     Taken From: http://programmingnotes.org/
 * Write a description of class TicTacToe here.	+// ============================================================================
 * 	+import javax.swing.*;
 * @author (your name) 	+
 * @version (a version number or a date)	
 */	
public class TicTacToe
{	 

    // instance variables - replace the example below with your own	+    public static void main(String[] args)
    private int n ;	
    private String tokenWinner = "";	
    static String[][] board;	

    public void setN(int n)	
    {	
        this.n = n;	
        board = new String[this.n][this.n];	
    }	

    public int getN()
    {
        return this.n;
    }

    /**	
     * Constructor for objects of class TicTacToe	
     */	
    public void setBoard()	
    {	
        // initialise instance variables	

        System.out.print( "       " );	
        for( int i1 = 0 ; i1 < n ; i1++)	
            System.out.print( "col " );	
        System.out.println();	
        System.out.print( "        " );	
        for( int i1 = 0 ; i1 < n ; i1++)	
            System.out.print( i1 + "   " );	
        System.out.println();	
        System.out.print( "      " );	
        for( int i1 = 0 ; i1 < n ; i1++)	
            System.out.print( "----" );	
        System.out.println();	

        for( int i1 = 0 ; i1 < n ; i1++)	
        {	
            System.out.print( "Row " + (i1 +1 ) + " " );	
            for ( int i2 = 0 ; i2 < n ; i2++)	
            {	
                board[i1][i2] = ("   ");	
                System.out.print("|");	
                System.out.print(board[i1][i2]);	
            }	
            System.out.print("|");	
            System.out.println();	
            for( int i3 = 0 ; i3 < n ; i3++)	
                System.out.print( "----" );	
            System.out.println();	
        }	
    }	

    public void printBoard()	
    {	
        // initialise instance variables	

        System.out.print( "       " );	
        for( int i1 = 0 ; i1 < n ; i1++)	
            System.out.print( "col " );	
        System.out.println();	
        System.out.print( "        " );	
        for( int i1 = 0 ; i1 < n ; i1++)	
            System.out.print( i1 + "   " );	
        System.out.println();	
        System.out.print( "      " );	
        for( int i1 = 0 ; i1 < n ; i1++)	
            System.out.print( "----" );	
        System.out.println();	

        for( int i1 = 0 ; i1 < n ; i1++)	
        {	
            System.out.print( "Row " + (i1 +1 ) + " " );	
            for ( int i2 = 0 ; i2 < n ; i2++)	
            {	
                System.out.print("|");	
                System.out.print(board[i1][i2]);	
            }	
            System.out.print("|");	
            System.out.println();	
            for( int i3 = 0 ; i3 < n ; i3++)	
                System.out.print( "----" );	
            System.out.println();	
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
        for( int i1 = 0 ; i1 < n ; i1++ )	
        {	

            if( board[0][0] == token)	
            {	
                int win = 0 ;	
                for( int i2 = 0 ; i2 < n ; i2++ )	
                {	

                    if( board[i2][i2] ==  token )	
                    {	
                        win ++; 	
                    }	

                    if ( win == n )	
                        return true;	

                }	
            }	

            if( board[i1][0] ==  token)	
            {	
                int win = 0 ;	
                for( int i2 = 0 ; i2 < n ; i2++ )	
                {	
                    if( board[i1][i2] ==  token )	
                    {	
                        win ++; 	
                    }	

                    if ( win == n )	
                        return true;	

                }	
            }

            if( board[0][i1] ==  token)	
            {	
                int win = 0 ;	
                for( int i2 = 0 ; i2 < n ; i2++ )	
                {	
                    if( board[i2][i1]  ==  token )	
                    {	
                        win ++; 	
                    }	

                    if ( win == n )	
                        return true;	

                }	
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

}