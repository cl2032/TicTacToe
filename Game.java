import java.util.*;
/**
 * Write a description of class Interface here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Game
{
      public void Game()
    {
        
        Scanner input = new Scanner(System.in);
        GameSet gameObj = new GameSet();
        int n = GameSet.n();
        /*
        System.out.println(" (1) player vs Player" );
        System.out.println(" (2) player vs Computer" );
        int option1 = input.nextInt() ; 
        input.nextLine();  */
        String str1 ; 
        while( true ) 
        {

            System.out.println("Board size?" );
            n = input.nextInt() ; 
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
    }

    public static void main(String args[])
    {
        
        Scanner input = new Scanner(System.in);
        Game gameObj = new Game();
       
    }
}

