/**
ticTacToeView
has the graphics code for the TicTacToe
Tully Eva
07/06/2021
*/
import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import javax.swing.JFrame;
import java.awt.event.*; 
public class ticTacToeView extends JPanel implements MouseListener
{
    //Private Variables
   private int turn = 0; 
   private int mouseX = 0;
   private int mouseY = 0;
   private String[] gameBoard = new String[]{"none", "none", "none","none", "none", "none","none", "none", "none"};
   private String[] xNames = new String[]{"X1", "X2", "X3", "X4", "X5"};
   private String[] oNames = new String[]{"O1", "O2", "O3", "O4", "O5"};
   private int[] xPos = new int[]{99, 199, 299, 99, 199, 299, 99, 199, 299};
   private int[] yPos = new int[]{100, 100, 100, 200, 200, 200, 300, 300, 300};
   private boolean showXWinScreen = false;
   private boolean showOWinScreen = false;
   private boolean showTieScreen = false;
   private JFrame myFrame;
    /**
     * Create the JFrame
     */
   public ticTacToeView()
   {
      myFrame = new JFrame("Tic Tac Toe");
        //myFrame.add(new ticTacToeView());
        //SEE Help1.png for myFrame.add(this);
      myFrame.add(this);
      myFrame.setSize(new Dimension(517,540));
        
      myFrame.setPreferredSize(new Dimension(517,540));
        
      myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   
        //myFrame.add((Component) paintComponent());
   
        //myFrame.add(new ticTacToeView());
        
      myFrame.setVisible(true);
        
        
      myFrame.setFocusable(true);
      myFrame.requestFocusInWindow();
      myFrame.addMouseListener(this);
   }
    /**
     * Draw the board, Background, display player turn, and game end situation
     */
   public void paintComponent(Graphics g)
   {
   
      Graphics2D g2 = (Graphics2D) g;
      createBackgroundColor(g2);
     
      drawBoard(g2, gameBoard);
     // If you pass the Graphics2D variable g2 into your method as a parameter
     // You can use all the drawing methods inside your other method
      if (showXWinScreen)
      {
         Toolkit t = Toolkit.getDefaultToolkit();
         Image xWins = t.getImage("./Images/xWins.png");
         g.drawImage(xWins, 0, 0, this);
      }
      else if (showOWinScreen)
      {
         Toolkit t = Toolkit.getDefaultToolkit();
         Image oWins = t.getImage("./Images/oWins.png");
         g.drawImage(oWins, 0, 0, this);
      }
      else if (showTieScreen)
      {
         Toolkit t = Toolkit.getDefaultToolkit();
         Image tie = t.getImage("./Images/tie.png");
         g.drawImage(tie, 0, 0, this);
      }
      else
      {
         if (this.turn % 2 == 0)
         {
            Toolkit t = Toolkit.getDefaultToolkit();
            Image xTurn = t.getImage("./Images/xTurn.png");
            g.drawImage(xTurn, 0, 0, this);
         }  
         else
         {
            Toolkit t = Toolkit.getDefaultToolkit();
            Image oTurn = t.getImage("./Images/oTurn.png");
            g.drawImage(oTurn, 0, 0, this);
         }
      }
       
   }
    /**
    * @param e
    */
   public void mouseExited(MouseEvent e)
   {
   
   }
   /**
    * @param e
    */
   public void mouseEntered(MouseEvent e)
   {
   
   }
   /**
    * set the X/Y values for the mouse click
    * @param e
    */
   public void mousePressed(MouseEvent e)
   {
      // Example of getting the x location of the mouse
      this.mouseX = e.getX();
      this.mouseY = e.getY();
   }
   /**
    * @param e
    */
   public void mouseReleased(MouseEvent e)
   {
   
   }
   /**
    * @param e
    */
   public void mouseClicked(MouseEvent e)
   {
   
   }
   /**
    * draw the View Board
    * should be the same as the model board
    * @param g2
    * @param _board
    */
   public void drawBoard(Graphics2D g2, String[] _board)
   {
      for(int i = 0; i < _board.length; i += 1)
      {
            //https://www.javatpoint.com/Displaying-image-in-swing
            //Used to figure out how to display images
         if (i == 0)
         {
            if (_board[i].equals("x"))
            {
               Toolkit t = Toolkit.getDefaultToolkit();
               Image x = t.getImage("./Images/" + xNames[0] + ".png");
               g2.drawImage(x, xPos[i], yPos[i], this);
            }
            else if (_board[i].equals("o"))
            {
               Toolkit t = Toolkit.getDefaultToolkit();
               Image o = t.getImage("./Images/" + oNames[0] + ".png");
               g2.drawImage(o, xPos[i], yPos[i], this);
            } 
         }
         if ((i == 1) || (i == 3))
         {
            if (_board[i].equals("x"))
            {
               Toolkit t = Toolkit.getDefaultToolkit();
               Image x = t.getImage("./Images/" + xNames[1] + ".png");
               g2.drawImage(x, xPos[i], yPos[i], this);
            }
            else if (_board[i].equals("o"))
            {
               Toolkit t = Toolkit.getDefaultToolkit();
               Image o = t.getImage("./Images/" + oNames[1] + ".png");
               g2.drawImage(o, xPos[i], yPos[i], this);
            }
         }
         if ((i == 2) || (i == 4) || (i == 6))
         {
            if (_board[i].equals("x"))
            {
               Toolkit t = Toolkit.getDefaultToolkit();
               Image x = t.getImage("./Images/" + xNames[2] + ".png");
               g2.drawImage(x, xPos[i], yPos[i], this);
            }
            else if (_board[i].equals("o"))
            {
               Toolkit t = Toolkit.getDefaultToolkit();
               Image o = t.getImage("./Images/" + oNames[2] + ".png");
               g2.drawImage(o, xPos[i], yPos[i], this);
            }
         }
         if ((i == 5) || (i == 7))
         {
            if (_board[i].equals("x"))
            {
               Toolkit t = Toolkit.getDefaultToolkit();
               Image x = t.getImage("./Images/" + xNames[3] + ".png");
               g2.drawImage(x, xPos[i], yPos[i], this);
            }
            else if (_board[i].equals("o"))
            {
               Toolkit t = Toolkit.getDefaultToolkit();
               Image o = t.getImage("./Images/" + oNames[3] + ".png");
               g2.drawImage(o, xPos[i], yPos[i], this);
            }
         }
         if (i == 8)
         {
            if (_board[i].equals("x"))
            {
               Toolkit t = Toolkit.getDefaultToolkit();
               Image x = t.getImage("./Images/" + xNames[4] + ".png");
               g2.drawImage(x, xPos[i], yPos[i], this);
            }
            else if (_board[i].equals("o"))
            {
               Toolkit t = Toolkit.getDefaultToolkit();
               Image o = t.getImage("./Images/" + oNames[4] + ".png");
               g2.drawImage(o, xPos[i], yPos[i], this);
            }
         }
      }//2nd to last
        //Draw the actual # pattern
      Toolkit b = Toolkit.getDefaultToolkit();
      Image tttBoard = b.getImage("./Images/TicTacToeBoard.png");
      g2.drawImage(tttBoard, 0, 0, this);
   }//last
    /**
     * close the game window
     */
   public void end()
   {
      myFrame.setVisible(false);
      myFrame.dispose();
   }
    /**
     * set the background color
     * @param g2
     */
   public void createBackgroundColor(Graphics2D g2)
   {
        //g2.setColor(new Color(0, 0, 0));
      g2.setColor(new Color(244, 241, 222));
      Rectangle2D.Double background = new Rectangle2D.Double(0, 0, 500, 500);
      g2.draw(background);
      g2.fill(background);
   }
    /**
     * get the board position of the mouse click
     * @param _gameBoard
     * @return
     */
   public int getPos(String[] _gameBoard)
   {
      if (this.mouseX >= 100 && this.mouseX <= 200)
      {
         if (this.mouseY >= 100 && this.mouseY <= 200)
         {
            if(_gameBoard[0].equals("none"))
            {
               mouseX = 0;
               mouseY = 0;
               return 0;
            }
         }
         if (this.mouseY >= 200 && this.mouseY <= 300)
         {
            if(_gameBoard[3].equals("none"))
            {
               mouseX = 0;
               mouseY = 0;
               return 3;
            }
         }
         if (this.mouseY >= 300 && this.mouseY <= 400)
         {
            if(_gameBoard[6].equals("none"))
            {
               mouseX = 0;
               mouseY = 0;
               return 6;
            }
         }
      }
      if (this.mouseX >= 200 && this.mouseX <= 300)
      {
         if (this.mouseY >= 100 && this.mouseY <= 200)
         {
            if(_gameBoard[1].equals("none"))
            {
               mouseX = 0;
               mouseY = 0;
               return 1;
            }
         }
         if (this.mouseY >= 200 && this.mouseY <= 300)
         {
            if(_gameBoard[4].equals("none"))
            {
               mouseX = 0;
               mouseY = 0;
               return 4;
            }
         }
         if (this.mouseY >= 300 && this.mouseY <= 400)
         {
            if(_gameBoard[7].equals("none"))
            {
               mouseX = 0;
               mouseY = 0;
               return 7;
            }
         }
      }
      if (this.mouseX >= 300 && this.mouseX <= 400)
      {
         if (this.mouseY >= 100 && this.mouseY <= 200)
         {
            if(_gameBoard[2].equals("none"))
            {
               mouseX = 0;
               mouseY = 0;
               return 2;
            }
         }
         if (this.mouseY >= 200 && this.mouseY <= 300)
         {
            if(_gameBoard[5].equals("none"))
            {
               mouseX = 0;
               mouseY = 0;
               return 5;
            }
         }
         if (this.mouseY >= 300 && this.mouseY <= 400)
         {
            if(_gameBoard[8].equals("none"))
            {
               mouseX = 0;
               mouseY = 0;
               return 8;
            }
         }
      }
      return 10;
   }
    /**
     * increase playerTurn by one
     */
   public void nextTurn()
   {
      this.turn += 1;
   }
    /**
     * return playerTurn
     * @return
     */
   public int getTurn()
   {
      return this.turn;
   }
    /**
     * add a mark to the View Board 
     * different form adding to the model board however they both should represent the same thing
     * there's probably a way to just use one board
     * however I didn't really look into or try drawing the model board I just draw the View board
     * @param pos
     * @param playerTurn
     */
   public void addMarkView(int pos, int playerTurn)
   {
      String marker = "o";
      if (playerTurn % 2 == 0)
      {
         marker = "x";
      }
      this.gameBoard[pos] = marker;
   }
    /**
     * set the boolean for xWin
     * @param n
     */
   public void setXWin(boolean n)
   {
      this.showXWinScreen = n;
   }
    /**
     * set the boolean for OWin
     * @param n
     */
   public void setOWin(boolean n)
   {
      this.showOWinScreen = n;
   }
    /**
     *set the boolean for tie
     * @param n
     */
   public void setTie(boolean n)
   {
      this.showTieScreen = n;
   }
}