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
   */
   public String whatGame()
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
         return "ticTacToe";
      }
      if (game.equals("otherGame"))
      {
         return "otherGame";
      }
      System.out.println("won't return this hopefully");
      return "Won't return this ever (hopefully)";
   }

}