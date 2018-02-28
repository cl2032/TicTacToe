// ============================================================================
//     Taken From: http://programmingnotes.org/
// ============================================================================
import javax.swing.*;
import java.awt.*;

public class BusinessLogic
{
    /*
    public static void GetMove(int currentMove, int remainingMoves, Font font, JButton btnEmpty[], 
    String startingPlayer)
    {// gets the current move "X" or "O" for the user & displays to screen
    btnEmpty[currentMove].setFont(font);

    if(startingPlayer.equals("X"))
    {
    if(remainingMoves % 2 != 0)
    {				
    btnEmpty[currentMove].setText("X");
    }
    else
    {
    btnEmpty[currentMove].setText("O");
    }
    }
    else
    {
    if(remainingMoves % 2 != 0)
    {
    btnEmpty[currentMove].setText("O");
    }
    else
    {
    btnEmpty[currentMove].setText("X");
    }
    }
    }// End of GetMove
     */

    public static void SetMove(int row, int col, int remainingMoves, Font font, JButton btn2Dim[][], 
    String startingPlayer)
    {// gets the current move "X" or "O" for the user & displays to screen
        btn2Dim[row][col].setFont(font);

        if(startingPlayer.equals("X"))
        {
            if(remainingMoves % 2 != 0)
            {				
                btn2Dim[row][col].setText("X");
            }
            else
            {
                btn2Dim[row][col].setText("O");
            }
        }
        else
        {
            if(remainingMoves % 2 != 0)
            {
                btn2Dim[row][col].setText("O");
            }
            else
            {
                btn2Dim[row][col].setText("X");
            }
        }
    }// End of GetMove

    public static void ShowGame(JPanel pnlSouth, JPanel pnlPlayingField)
    {// shows the Playing Field
        pnlSouth.setLayout(new BorderLayout());
        pnlSouth.add(pnlPlayingField, BorderLayout.CENTER);
        pnlPlayingField.requestFocus();	
    }// End of ShowGame

    public static void ClearPanelSouth(JPanel pnlSouth, JPanel pnlTop, 
    JPanel pnlNewGame, JPanel pnlPlayingField, JPanel pnlBottom, JPanel radioPanel)	
    {// clears any posible panels on screen
        pnlSouth.remove(pnlTop); 
        pnlSouth.remove(pnlBottom);
        pnlSouth.remove(pnlPlayingField);
        pnlTop.remove(pnlNewGame);
        pnlSouth.remove(radioPanel);
    }//	End of ClearPanelSouth 
}