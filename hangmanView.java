/**
hangmanView
has the graphics code for the Hangman
Tully Eva
07/07/2021
*/
import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import javax.swing.JFrame;
import java.awt.event.*; 
import java.util.HashMap;
public class hangmanView extends JPanel implements KeyListener, MouseListener
{
    private JFrame myFrame;
    private String userGuess = "";
    private String guessedLetters = "";
    private String[] letters = new String[]{"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v","w", "x", "y", "z"};
    private HashMap<Integer, String> keys = new HashMap<>();
    private int mouseX = 0;
    private int mouseY = 0;
    private String knownLettersView = "";
    private String theWord;
    private boolean loss = false;
    private boolean win = false;
    private int livesV;
    
    /**
     * initialize the JFrame
     */
    public hangmanView()
    {
        myFrame = new JFrame("Hangman");
        myFrame.add(this);
        myFrame.setSize(new Dimension(517,540));
        myFrame.setPreferredSize(new Dimension(517,540));
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.setVisible(true);
        //Key Input
        myFrame.setFocusable(true);
        myFrame.requestFocusInWindow();
        myFrame.addKeyListener(this);
        myFrame.addMouseListener(this);
    }
   /**
    * 
    */
   public void keyPressed(KeyEvent e)
   {
      // *****************************************************
      // To get the key that triggered the event...
      // Most keys are included in KeyEvent.VK_<SOMEKEY>
      // These are integers in the KeyEvent class representing
      // keys on typical keyboards
      // *****************************************************
      //https://www.geeksforgeeks.org/java-util-hashmap-in-java-with-examples/
      int key = e.getKeyCode();
      if (keys.containsKey(key))
      {
          userGuess = keys.get(key);
      }
      // *****************************************************
   }
   /**
    * 
    */
   public void keyReleased(KeyEvent e)
   {
   
   }
   /**
    * 
    */
   public void keyTyped(KeyEvent e)
   {
   
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
        //System.out.println("Mouse Clicked");
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
     * create the dictionary AND get the View to know the word
     */
   public void initializeHashMap(String word)
   {
       for(int i = 65; i <= 90; i += 1)
       {
           keys.put(i, letters[i-65]);
       }
       this.theWord = word;
   }
   /**
    * detects an update in the mouseX/mouseY and if
    *those values are within a certain range
    *returns true
    * @return if the mouse was clicked or not
    */
   public boolean submit()
   {
       //System.out.println(this.mouseX);
       //System.out.println(userGuess);
       if ((this.mouseY > 368) && (this.mouseY < 402) && (!userGuess.equals("")) && (this.mouseX > 219) && (this.mouseX < 439))
       {
            //System.out.println("submitted");
            mouseX = 0;
            mouseY = 0;
            return true;
       }
       
       mouseX = 0;
       mouseY = 0;
       return false;
   }
   /**
    * Print the known letters to the screen
    also used to print the word at the end
    * @param g2
    * @param known
    */
   public void showKnown(Graphics2D g2, String known)
   {
        //g2.setFont(new Font("COCOGOOSE", Font.PLAIN, 40));
        g2.setFont(new Font("Monospaced", Font.PLAIN, 40));
        g2.setColor(new Color(0, 0, 0));
        String printThis = "";
        for(int i = 0; i < known.length(); i += 1)
        {
            printThis = printThis + known.substring(i, i+1) + " ";
        }
        g2.drawString(printThis, 34, 468);
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
    * returns the most recently typed character 
    *by the user
    * @return
    */
   public String getGuess()
   {
       return userGuess;
   }
   /**
    * set's the guess to an empty string
    */
   public void resetGuess()
   {
       if (theWord.indexOf(userGuess) == -1)
       {
            guessedLetters = guessedLetters + userGuess + " ";
       }
        
       userGuess = "";
   }
   /**
    * paint the objects to the JFrame
    */
   public void paintComponent(Graphics g)
   { 
       //hangmanSubmitGuess.png
       //System.out.println("printing");
       Graphics2D g2 = (Graphics2D) g;
       createBackgroundColor(g2);
        drawMan(g2);

       Toolkit t = Toolkit.getDefaultToolkit();
       Image x = t.getImage("./Images/hangmanSubmitGuess.png");
       g2.drawImage(x, 0, 0, this);
       //how can I pass in the Model board without having to create a view board aswell?
       


       if (loss)
       {
            Toolkit z = Toolkit.getDefaultToolkit();
            Image loseScreen = z.getImage("./Images/hangmanLoss.png");
            g2.drawImage(loseScreen, 0, 0, this);
            showKnown(g2, theWord);
       }
       else if (win)
       {
            Toolkit z = Toolkit.getDefaultToolkit();
            Image winScreen = z.getImage("./Images/hangmanWin.png");
            g2.drawImage(winScreen, 0, 0, this);
            showKnown(g2, knownLettersView);
            
       }
       else
       {
        g2.setFont(new Font("Monospaced", Font.PLAIN, 40));
        g2.setColor(new Color(0, 0, 0));
        g2.drawString(userGuess, 310, 308);

        g2.setFont(new Font("Monospaced", Font.PLAIN, 40));
        g2.setColor(new Color(0, 0, 0));
        g2.drawString(guessedLetters, 174, 210);

        showKnown(g2, knownLettersView);
       }
   }
   /**
    * get the known letters from the model and then set the known letters view to that string
    * @param knownLettersModel
    */
   public void updateKnownLettersView(String knownLettersModel)
   {
       this.knownLettersView = knownLettersModel;
   }
   /**
    * if the user is out of lives
    *sets the loss to true
    * @param n
    */
   public void setLoss(boolean n)
   {
       this.loss = n;
   }
   /**
    * if the user guesses the word
    * sets win to true
    * @param n
    */
   public void setWin(boolean n)
   {
       this.win = n;
   }
   /**
    * close the window
    */
   public void end()
   {
      myFrame.setVisible(false);
      myFrame.dispose();
   }
   /**
    * if a letter has been guessed already or if the letter is a known letter
    * @param guess
    * @return
    */
   public boolean guessedAlready(String guess)
   {
       
       if (guessedLetters.indexOf(guess) == -1 && knownLettersView.indexOf(guess) == -1)
       {
           return false;
       }
       return true;
   }
   /**
    * draws the actual guy
    * @param g2
    */
   public void drawMan(Graphics2D g2)
   {
       if (livesV == 0)
       {
        Toolkit t = Toolkit.getDefaultToolkit();
        Image o = t.getImage("./Images/6Limb.png");
        g2.drawImage(o, 0, 0, this);
       }
       else if (livesV == 1)
       {
        Toolkit t = Toolkit.getDefaultToolkit();
        Image o = t.getImage("./Images/5Limb.png");
        g2.drawImage(o, 0, 0, this);
       }
       else if (livesV == 2)
       {
        Toolkit t = Toolkit.getDefaultToolkit();
        Image o = t.getImage("./Images/4Limb.png");
        g2.drawImage(o, 0, 0, this);
       }
       else if (livesV == 3)
       {
        Toolkit t = Toolkit.getDefaultToolkit();
        Image o = t.getImage("./Images/3Limb.png");
        g2.drawImage(o, 0, 0, this);
       }
       else if (livesV == 4)
       {
        Toolkit t = Toolkit.getDefaultToolkit();
        Image o = t.getImage("./Images/2Limb.png");
        g2.drawImage(o, 0, 0, this);
       }
       else if (livesV == 5)
       {
        Toolkit t = Toolkit.getDefaultToolkit();
        Image o = t.getImage("./Images/1Limb.png");
        g2.drawImage(o, 0, 0, this);
       }
       else if (livesV == 6)
       {

       }
   }
   /**
    * get the number of lives from the model
    * @param n
    */
   public void setLivesV(int n)
   {
       livesV = n;
   }
}