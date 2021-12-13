package tictactoe;
import java.io.IOException;
import java.net.URL;
import javax.sound.sampled.*;

/**
ticTacToeController
Controller for Tic Tac Toe
this has all the game logic
Tully Eva
07/06/2021
*/
public class ticTacToeController 
{
  // Private variables
   private ticTacToeModel _theModel;
   private ticTacToeView _theView;

  /**
   * constructor
   * @param theView
   * @param theModel
   */
   public ticTacToeController(ticTacToeView theView, ticTacToeModel theModel)
   {
      _theModel = theModel;
      _theView = theView;
   }
  /**
   * Actual Tic Tac Toe Logic 
 * @throws IOException
 * @throws UnsupportedAudioFileException
 * @throws LineUnavailableException
   */
  public void winnerSound() throws UnsupportedAudioFileException, IOException, LineUnavailableException
  {
   URL file = new URL("file:///" + System.getProperty("user.dir") + "/audio" + "/ticTacToeWinner!.wav");
   System.out.println("file:///" + System.getProperty("user.dir") + "/audio" + "/ticTacToeWinner!.wav");
   AudioInputStream ais = AudioSystem.getAudioInputStream(file);
   Clip clip = AudioSystem.getClip();
   clip.open(ais);
   clip.setFramePosition(0);
   clip.start();
  }
   public void logic() throws UnsupportedAudioFileException, IOException, LineUnavailableException
   {
      boolean playing = true;
   
      while (playing)
      {
      //for(int i = 0; i < 9; i += 1)
      //{
      //  System.out.println(_theModel.getBoard()[i]);
      //}
         int position = _theView.getPos(_theModel.getBoard());
         while (position == 10)
         {
            position = _theView.getPos(_theModel.getBoard());
         }
         _theModel.addMarkModel(position, _theView.getTurn());
         _theView.addMarkView(position, _theView.getTurn());
         URL file = new URL("file:///" + System.getProperty("user.dir") + "/audio" + "/Ding%20-%20Sound%20Effect%20(HD).wav");
         System.out.println("file:///" + System.getProperty("user.dir") + "/audio" + "/Ding%20-%20Sound%20Effect%20(HD).wav");
         AudioInputStream ais = AudioSystem.getAudioInputStream(file);
         Clip clip = AudioSystem.getClip();
         clip.open(ais);
         clip.setFramePosition(0);
         clip.start();
         _theView.invalidate();
         _theView.validate();
         _theView.repaint();
      //https://stackoverflow.com/questions/7628121/how-can-i-refresh-or-reload-the-jframe
         if (_theModel.checkWin(_theModel.getBoard()))
         {
            if (_theView.getTurn()%2 == 0)
            {
               _theView.setXWin(true);
               winnerSound();
               break;
            }
            else
            {
               _theView.setOWin(true);
               winnerSound();
               break;
            }
         }
         if (_theModel.checkTie(_theModel.getBoard()))
         {
            _theView.setTie(true);
            break;
         }
         _theView.nextTurn();
         position = 10;
      }
      try 
      {
         Thread.sleep(1250);
      }
      catch (InterruptedException ex)
      {
      }
      _theView.end();
   }
}