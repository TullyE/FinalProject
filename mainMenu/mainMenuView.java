package mainMenu;

/**
mainMenuView
View for the Main menu
I may have done this wrong because I don't have a Model for the main menu
Tully Eva
07/06/2021
*/
import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import javax.swing.JFrame;
import java.awt.event.*;
public class mainMenuView extends JPanel implements MouseListener
{
    //Private Variables
   private JFrame myFrame;
   private int mouseX = 0;
   private int mouseY = 0;
   private int[][] boxesLimits = new int[][] {{100, 400, 113, 188}, {100, 400, 312, 387}};
    /**
     * create the JFrame
     */
   public mainMenuView()
   {
      myFrame = new JFrame("Main Menu");
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
     * draw the background color and show the buttons
     */
   public void paintComponent(Graphics g)
   {
   
      Graphics2D g2 = (Graphics2D) g;
      createBackgroundColor(g2);
   
      Toolkit t = Toolkit.getDefaultToolkit();
      Image o = t.getImage("./Images/Menu Screen.png");
      g2.drawImage(o, 0, 0, this);
   
      myFrame.invalidate();
      myFrame.validate();
      myFrame.repaint();
   }
   public void createBackgroundColor(Graphics2D g2)
   {
        //g2.setColor(new Color(0, 0, 0));
      g2.setColor(new Color(244, 241, 222));
      Rectangle2D.Double background = new Rectangle2D.Double(0, 0, 500, 500);
      g2.draw(background);
      g2.fill(background);
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
     * take a given x/y mouse value and return a game
     * @return
     */
   public String whatGame()
   {
      if ((mouseX > boxesLimits[0][0]) && (mouseX < boxesLimits[0][1]))
      {
         if ((mouseY > boxesLimits[0][2]) && (mouseY < boxesLimits[0][3]))
         {
            mouseX = 0;
            mouseY = 0;
            return "ticTacToe";
         }
      }
      if ((mouseX > boxesLimits[1][0]) && (mouseX < boxesLimits[1][1]))
      {
         if ((mouseY > boxesLimits[1][2]) && (mouseY < boxesLimits[1][3]))
         {
            mouseX = 0;
            mouseY = 0;
            return "otherGame";
         }
      }
      mouseX = 0;
      mouseY = 0;
      return "noneSelected";
   }
}