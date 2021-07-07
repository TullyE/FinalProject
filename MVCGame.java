/**
MVCGame
Where I actually create an instance of each M, V, and C
Tully Eva
07/06/2021
*/
import javax.sound.sampled.*;

import hangman.hangmanController;
import hangman.hangmanModel;
import hangman.hangmanView;
import mainMenu.mainMenuController;
import mainMenu.mainMenuView;
import tictactoe.ticTacToeController;
import tictactoe.ticTacToeModel;
import tictactoe.ticTacToeView;

import java.net.URL;
public class MVCGame 
{
   public static void main(String[] args) throws Exception
   {
      //https://stackoverflow.com/questions/4871051/how-to-get-the-current-working-directory-in-java
      //https://stackoverflow.com/questions/64509691/how-can-i-add-some-sound-to-my-java-jframe
      //Plays audio
      URL file = new URL("file:///" + System.getProperty("user.dir") + "/audio" + "/Marcos%20H.%20Bolanos%20-%20A%20Simple%20Life.wav");
      System.out.println("file:///" + System.getProperty("user.dir") + "/audio" + "/Marcos%20H.%20Bolanos%20-%20A%20Simple%20Life.wav");
      AudioInputStream ais = AudioSystem.getAudioInputStream(file);
      Clip clip = AudioSystem.getClip();
      clip.open(ais);
      clip.setFramePosition(0);
      clip.start();
      mainMenuView mainMenuV = new mainMenuView();
      mainMenuController mainMenuC = new mainMenuController(mainMenuV);
      while (true)
      {
         if (mainMenuC.whatGame().equals("ticTacToe"))
         {
            //Start a tic tac toe game
            //can be repeated
            ticTacToeModel ticTacToeM = new ticTacToeModel();
            ticTacToeView ticTacToeV = new ticTacToeView();
            ticTacToeController ticTacToeC = new ticTacToeController(ticTacToeV, ticTacToeM);
            ticTacToeC.logic();
         }
         if (mainMenuC.whatGame().equals("otherGame"))
         {
            //Start a Hangman game
            hangmanView hangmanV = new hangmanView();
            hangmanModel hangmanM = new hangmanModel();
            hangmanController hangmanC = new hangmanController(hangmanV, hangmanM);
            hangmanC.logic();
         }
      }
   }
}