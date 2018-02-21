import java.util.*;

public class Driver
{
    public static void main(String args[])
    {

        Scanner input = new Scanner(System.in);
        TicTacToe tttObj = new TicTacToe();
        Game gameObj = new Game(tttObj);
        
        System.out.println("How big do you want the board to be?" );
        int n = input.nextInt();
        tttObj.setN(n);
        /*
        System.out.println(" (1) player vs Player" );
        System.out.println(" (2) player vs Computer" );
        int option1 = input.nextInt() ; 
        input.nextLine();  */
        String str1 ; 
        while( true ) 
        {

            System.out.println(" (1) player vs Player" );
            System.out.println(" (2) player vs Computer" );
            int option1 = input.nextInt() ; 
            input.nextLine();  
            tttObj.setBoard();

            if( option1 == 1 ) 
                gameObj.newGame();
            else
                gameObj.newGamePlayerVsComputer() ;
            tttObj.printBoard();
            System.out.println( "Play Again (Y/N):" ) ;
            str1 = input.nextLine() ;
            if ( str1.equals("n") || str1.equals("N") )
            {
                break ;
            }

        }
    }
}