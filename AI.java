
/**
 * Write a description of class AI here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class AI
{
    // instance variables - replace the example below with your own
    private int x;
    static int n;
    private TicTacToe obj1 = new TicTacToe();
    /**
     * Constructor for objects of class AI
     */
    public AI()
    {
        // initialise instance variables
        int x1 = 0 ; 
        int x2;

        for(int row = 0 ; row < n ; row++)
        {
            for(int col = 0 ; col < n ; col++)
            {
                if ( obj1.board[row][col] == tokenWinner )
                {
                    x1++;
                }

                if ( obj1.board[row][col] == "   " )
                {
                    x2++;
                }

                if ( x1 == n-1 && x2 == 1 )
                {
                    for(int col1 = 0 ; col1 < n ; col1++)
                    {
                        if ( obj1.board[row][col] == "   " )
                        {
                            obj1.board[row][col] = token;
                        }
                    }
                }
            }
        }

        for(int col = 0 ; col < n ; col++)
        {
            for(int row = 0 ; row < n ; row++)
            {
                if ( board[row][col] == token )
                {
                    x1++;
                }

                if ( x1 == n-1 )
                {

                }
            }
        }
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public int sampleMethod(int y)
    {
        // put your code here
        return x + y;
    }
}
