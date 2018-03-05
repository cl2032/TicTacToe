// ============================================================================
//     Taken From: http://programmingnotes.org/
// ============================================================================
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GUI extends JFrame implements ActionListener
{
    int dimension = 3 ; 
    // setting up ALL the variables
    JFrame window = new JFrame("Kenneth's Tic Tac Toe Game");

    JMenuBar mnuMain = new JMenuBar();
    JMenuItem   mnuNewGame = new JMenuItem("  New Game"), 
    mnuGameTitle = new JMenuItem("|Tic Tac Toe|  "),
    mnuStartingPlayer = new JMenuItem(" Starting Player"),
    mnuAI = new JMenuItem( "              AI "),
    mnuExit = new JMenuItem("    Quit");

    //JButton btnEmpty[] = new JButton[10];

    JButton btn2Dim[][] = new JButton[dimension][dimension] ; 

    JPanel  pnlNewGame = new JPanel(),
    pnlNorth = new JPanel(),
    pnlSouth = new JPanel(),
    pnlTop = new JPanel(),
    pnlBottom = new JPanel(),
    pnlPlayingField = new JPanel();
    JPanel radioPanel = new JPanel();

    private JRadioButton SelectX = new JRadioButton("User Plays X", false);
    private  JRadioButton SelectO = new JRadioButton("User Plays O", false);
    private ButtonGroup radioGroup;
    private  String startingPlayer= "";
    final int X = 800, Y = 480, color = 190; // size of the game window
    private boolean inGame = false;
    private boolean win = false;
    private boolean btnEmptyClicked = false;
    private boolean setTableEnabled = false;
    private String message;
    private Font font = new Font("Rufscript", Font.BOLD, 100);
    private int remainingMoves = 1;

    //===============================  GUI  ========================================//
    public GUI() //This is the constructor
    {
        //Setting window properties:
        window.setSize(X, Y);
        window.setLocation(300, 180);
        window.setResizable(true);
        window.setLayout(new BorderLayout());
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  

        //------------  Sets up Panels and text fields  ------------------------//
        // setting Panel layouts and properties
        pnlNorth.setLayout(new FlowLayout(FlowLayout.CENTER));
        pnlSouth.setLayout(new FlowLayout(FlowLayout.CENTER));

        pnlNorth.setBackground(new Color(70, 70, 70));
        pnlSouth.setBackground(new Color(color, color, color));

        pnlTop.setBackground(new Color(color, color, color));
        pnlBottom.setBackground(new Color(color, color, color));

        pnlTop.setLayout(new FlowLayout(FlowLayout.CENTER));
        pnlBottom.setLayout(new FlowLayout(FlowLayout.CENTER));

        radioPanel.setBackground(new Color(color, color, color));
        pnlBottom.setBackground(new Color(color, color, color));
        radioPanel.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(), "Who Goes First?"));

        // adding menu items to menu bar
        mnuMain.add(mnuGameTitle);
        mnuGameTitle.setEnabled(false);
        mnuGameTitle.setFont(new Font("Purisa",Font.BOLD,18));
        mnuMain.add(mnuNewGame);
        mnuNewGame.setFont(new Font("Purisa",Font.BOLD,18));
        mnuMain.add(mnuStartingPlayer);
        mnuStartingPlayer.setFont(new Font("Purisa",Font.BOLD,18));
        mnuMain.add(mnuAI);
        mnuAI.setFont(new Font("Purisa",Font.BOLD,18));
        mnuMain.add(mnuExit);
        mnuExit.setFont(new Font("Purisa",Font.BOLD,18));//---->Menu Bar Complete

        // adding X & O options to menu
        SelectX.setFont(new Font("Purisa",Font.BOLD,18));
        SelectO.setFont(new Font("Purisa",Font.BOLD,18));
        radioGroup = new ButtonGroup(); // create ButtonGroup
        radioGroup.add(SelectX); // add plain to group
        radioGroup.add(SelectO);
        radioPanel.add(SelectX);
        radioPanel.add(SelectO);

        // adding Action Listener to all the Buttons and Menu Items
        mnuNewGame.addActionListener(this);
        mnuExit.addActionListener(this);
        mnuStartingPlayer.addActionListener(this);

        // setting up the playing field
        pnlPlayingField.setLayout(new GridLayout(dimension, dimension, 2, 2));
        pnlPlayingField.setBackground(Color.black);
        /*
        for(int x=1; x <= 9; ++x)   
        {
        btnEmpty[x] = new JButton();
        btnEmpty[x].setBackground(new Color(220, 220, 220));
        btnEmpty[x].addActionListener(this);
        pnlPlayingField.add(btnEmpty[x]);
        btnEmpty[x].setEnabled(setTableEnabled);
        } */

        for( int row=0 ; row< dimension ; row++ )
        {
            for( int col=0 ; col< dimension ; col++ )
            {
                btn2Dim[row][col] = new JButton();
                btn2Dim[row][col].setBackground(new Color(220, 220, 220));
                btn2Dim[row][col].addActionListener(this);
                pnlPlayingField.add(btn2Dim[row][col]);
                btn2Dim[row][col].setEnabled(setTableEnabled);
            }
        }

        // adding everything needed to pnlNorth and pnlSouth
        pnlNorth.add(mnuMain);
        BusinessLogic.ShowGame(pnlSouth,pnlPlayingField);

        // adding to window and Showing window
        window.add(pnlNorth, BorderLayout.NORTH);
        window.add(pnlSouth, BorderLayout.CENTER);
        window.setVisible(true);
    }// End GUI

    // ===========  Start Action Performed  ===============//
    public void actionPerformed(ActionEvent click)  
    {
        // get the mouse click from the user
        Object source = click.getSource();

        // check if a button was clicked on the gameboard
        /*
        for(int currentMove=1; currentMove <= 9; ++currentMove) 
        {
        if(source == btnEmpty[currentMove] && remainingMoves < 10)  
        {
        btnEmptyClicked = true;
        BusinessLogic.GetMove(currentMove, remainingMoves, font, 
        btnEmpty, startingPlayer);              
        btnEmpty[currentMove].setEnabled(false);
        pnlPlayingField.requestFocus();
        ++remainingMoves;
        }
        } */

        for( int row=0 ; row< dimension ; row++ )
        {
            for( int col=0 ; col< dimension ; col++ )
            {

                if(source == btn2Dim[row][col] && remainingMoves < (dimension*dimension + 1) )
                {
                    btnEmptyClicked = true;
                    BusinessLogic.SetMove(row, col, remainingMoves, font, 
                        btn2Dim, startingPlayer);              
                    btn2Dim[row][col].setEnabled(false);
                    pnlPlayingField.requestFocus();
                    ++remainingMoves;
                }

            }
        }

        // if a button was clicked on the gameboard, check for a winner
        if(btnEmptyClicked) 
        {
            inGame = true;
            if ( CheckWin() ) 
            {
                String token ;
                if ( (remainingMoves-1) % 2 != 0 )
                {   
                    token = "X" ; 
                }
                else
                    token = "O" ; 

                JOptionPane.showMessageDialog(null, token + " won ");
                btnEmptyClicked = false;
            }
        }

        // check if the user cliceks on a menu item
        if(source == mnuNewGame)    
        {
            BusinessLogic.ClearPanelSouth(pnlSouth,pnlTop,pnlNewGame,
                pnlPlayingField,pnlBottom,radioPanel);
            if(startingPlayer.equals(""))
            {
                JOptionPane.showMessageDialog(null, "Please Select a Starting Player", 
                    "Oops..", JOptionPane.ERROR_MESSAGE);
                BusinessLogic.ShowGame(pnlSouth,pnlPlayingField);
            }
            else
            {
                if(inGame)  
                {
                    int option = JOptionPane.showConfirmDialog(null, "If you start a new game," +
                            " your current game will be lost..." + "n" +"Are you sure you want to continue?"
                        , "New Game?" ,JOptionPane.YES_NO_OPTION);
                    if(option == JOptionPane.YES_OPTION)    
                    {
                        inGame = false;
                        startingPlayer = "";
                        setTableEnabled = false;
                    }
                    else
                    {
                        BusinessLogic.ShowGame(pnlSouth,pnlPlayingField);
                    }
                }
                // redraw the gameboard to its initial state
                if(!inGame) 
                {
                    RedrawGameBoard();
                }
            }       
        }       

        // exit button
        else if(source == mnuExit)  
        {
            int option = JOptionPane.showConfirmDialog(null, "Are you sure you want to quit?", 
                    "Quit" ,JOptionPane.YES_NO_OPTION);
            if(option == JOptionPane.YES_OPTION)
            {
                System.exit(0);
            }
        }

        //else if(source == mnuDimension)  

        // select X or O player 
        else if(source == mnuStartingPlayer)  
        {
            if(inGame)  
            {
                JOptionPane.showMessageDialog(null, "Cannot select a new Starting "+
                    "Player at this time.n Finish the current game, or select a New Game "+
                    "to continue", "Game In Session..", JOptionPane.INFORMATION_MESSAGE);
                BusinessLogic.ShowGame(pnlSouth,pnlPlayingField);
            }
            else
            {
                setTableEnabled = true;
                BusinessLogic.ClearPanelSouth(pnlSouth,pnlTop,pnlNewGame,
                    pnlPlayingField,pnlBottom,radioPanel);

                SelectX.addActionListener(new RadioListener());
                SelectO.addActionListener(new RadioListener());
                radioPanel.setLayout(new GridLayout(2,1));

                radioPanel.add(SelectX);
                radioPanel.add(SelectO);
                pnlSouth.setLayout(new GridLayout(2, 1, 2, 1));
                pnlSouth.add(radioPanel);
                pnlSouth.add(pnlBottom);

                pnlSouth.setVisible(false); 
                pnlSouth.setVisible(true);
                
            }
            
        }

        else if( source == mnuDim )
        {
            
            
            
            
            
        }
        
        
        else if( source == mnuAI )
        {
            if( inGame )
            {
                JOptionPane.showMessageDialog(null, "Cannot select a new AI game "+
                    "Player at this time.nFinish the current game, or select a New Game "+
                    "to continue", "Game In Session..", JOptionPane.INFORMATION_MESSAGE);
                BusinessLogic.ShowGame(pnlSouth,pnlPlayingField);

            }
            else
            {
                RedrawGameBoard();
            }
           
        }// End Action Performed
         pnlSouth.setVisible(false); 
            pnlSouth.setVisible(true);  
    }
    // ===========  Start RadioListener  ===============//  
    private class RadioListener implements ActionListener 
    {
        public void actionPerformed(ActionEvent event) 
        {
            JRadioButton theButton = (JRadioButton)event.getSource();
            if(theButton.getText().equals("User Plays X")) 
            {
                startingPlayer = "X";
            }
            if(theButton.getText().equals("User Plays O"))
            {
                startingPlayer = "O";
            }

            // redisplay the gameboard to the screen
            pnlSouth.setVisible(false); 
            pnlSouth.setVisible(true);          
            RedrawGameBoard();
        }
    }// End RadioListener
    /*
    ----------------------------------
    Start of all the other methods. |
    ----------------------------------
     */
    private void RedrawGameBoard()  
    {
        BusinessLogic.ClearPanelSouth(pnlSouth,pnlTop,pnlNewGame,
            pnlPlayingField,pnlBottom,radioPanel);
        BusinessLogic.ShowGame(pnlSouth,pnlPlayingField);       

        remainingMoves = 1;

        /* for(int x=1; x <= 9; ++x)   
        {
        btnEmpty[x].setText("");
        btnEmpty[x].setEnabled(setTableEnabled);
        }
         */

        for( int row=0 ; row< dimension ; row++ )
        {
            for( int col=0 ; col< dimension ; col++ )
            {
                btn2Dim[row][col].setText("");
                btn2Dim[row][col].setEnabled(setTableEnabled);

            }
        }

        win = false;        
    }

    String getToken( int row, int col ) 
    {
        return ( btn2Dim[row][col].getText() ) ;        
    }

    private boolean CheckWin() 
    {   
        String token ;

        if ( (remainingMoves-1) % 2 != 0 )
        {   
            token = "X" ; 
        }
        else
            token = "O" ; 

        for( int row = 0 ; row < dimension ; row++ )    
        {   

            if( getToken( 0,0 ).equals(token) ) 
            {   
                int win1 = 0 ;   
                for( int dig = 0 ; dig < dimension ; dig++ )    
                {   

                    if( getToken( dig,dig ).equals(token)     ) 
                    {   
                        win1 ++;     
                    }   

                    if ( win1 == dimension ) 
                        return true;    

                }   
            }   

            if( getToken( row,0 ).equals(token))    
            {   
                int win1 = 0 ;   
                for( int col = 0 ; col < dimension ; col++ )   
                {   
                    if( getToken( row,col ).equals(token) )  
                    {   
                        win1 ++;     
                    }   

                    if ( win1 == dimension ) 
                        return true;    

                }   
            }

            if( getToken( 0,row ).equals(token))    
            {   
                int win1 = 0 ;   
                for( int col = 0 ; col < dimension ; col++ )   
                {   
                    if( getToken( col,row ).equals(token) )  
                    {   
                        win1 ++;     
                    }   

                    if ( win1 == dimension ) 
                        return true;    

                }   
            }

            if( getToken( dimension-1,0 ).equals(token))
            {
                int win1 = 0 ;
                for( int dig = 0 ; dig < dimension ; dig++ )   
                {   
                    if( getToken( dimension-1-dig,dig ).equals(token) )  
                    {   
                        win1 ++;     
                    } 

                    if ( win1 == dimension ) 
                        return true;    

                }
            }   
            return false;   

        }
        return false; 
    }   
}

