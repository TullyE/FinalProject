package mainMenu;
import java.io.IOException;
import java.net.URL;
import javax.sound.sampled.*;
/**
mainMenuController
Controller for the Main Menu
Tully Eva
07/06/2021
*/
public class mainMenuController
{
  //private variable
   private mainMenuView theView;
  /**
   * constructor
   * only view as I don't have a Model for the menu scree
   * I don't actually think that a Controller is needed for the menu screen.
   * @param _theView
   */
   public mainMenuController(mainMenuView _theView)
   {
      theView = _theView;
   }
  /**
   * return a string of the game name
   * @return
 * @throws LineUnavailableException
 * @throws IOException
 * @throws UnsupportedAudioFileException
   */
   public String whatGame() throws LineUnavailableException, IOException, UnsupportedAudioFileException
   {
      boolean waiting = true;
      String game = theView.whatGame();
      while (waiting)
      {
         while (game.equals("noneSelected"))
         {
            game = theView.whatGame();
            //https://stackoverflow.com/questions/22221742/code-not-working-unless-a-simple-print-statement-is-inserted-in-while-loop
            //the thread.sleep(10) just creates some delay
            try 
            {
               Thread.sleep(10);
            }
            catch (InterruptedException ex)
            {
            }
         }
         waiting = false;
      }
      if (game.equals("ticTacToe"))
      {
         URL file = new URL("file:///" + System.getProperty("user.dir") + "/audio" + "/Mouse%20click%20sound%20effect%20free%20copyright.wav");
         System.out.println("file:///" + System.getProperty("user.dir") + "/audio" + "/Mouse%20click%20sound%20effect%20free%20copyright.wav");
         AudioInputStream ais = AudioSystem.getAudioInputStream(file);
         Clip clip = AudioSystem.getClip();
         clip.open(ais);
         clip.setFramePosition(0);
         clip.start();
         return "ticTacToe";
      }
      if (game.equals("otherGame"))
      {
         URL file = new URL("file:///" + System.getProperty("user.dir") + "/audio" + "/Mouse%20click%20sound%20effect%20free%20copyright.wav");
         System.out.println("file:///" + System.getProperty("user.dir") + "/audio" + "/Mouse%20click%20sound%20effect%20free%20copyright.wav");
         AudioInputStream ais = AudioSystem.getAudioInputStream(file);
         Clip clip = AudioSystem.getClip();
         clip.open(ais);
         clip.setFramePosition(0);
         clip.start();
         return "otherGame";
      }
      System.out.println("won't return this hopefully");
      return "Won't return this ever (hopefully)";
   }

}