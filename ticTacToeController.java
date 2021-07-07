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
   */
   public void logic()
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
         _theView.invalidate();
         _theView.validate();
         _theView.repaint();
      //https://stackoverflow.com/questions/7628121/how-can-i-refresh-or-reload-the-jframe
         if (_theModel.checkWin(_theModel.getBoard()))
         {
            if (_theView.getTurn()%2 == 0)
            {
               _theView.setXWin(true);
               break;
            }
            else
            {
               _theView.setOWin(true);
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
