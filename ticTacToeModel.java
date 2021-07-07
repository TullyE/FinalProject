/**
ticTacToeModel
Model for Tic Tac Toe
I'm not really sure if I put the correct things in the Model
Tully Eva
07/06/2021
*/
//https://www.youtube.com/watch?v=dTVVa2gfht8
//watched to learn how to do MVC programming... I was concerned that the code was 500 lines
//I was talking to one of my friends and he said I should look into MVC so I did
public class ticTacToeModel 
{
   //Private Variable
   private String[] gameBoard = new String[]{"none", "none", "none","none", "none", "none","none", "none", "none"};
    /**
     * Check if there is a win on the current game board
     * @param _board
     * @return
     */
   public boolean checkWin(String[] _board)
   {
      for(int i = 0; i <= 6; i += 3)
      {
         if ((_board[i] == _board[i+1]) && (_board[i] == _board[i+2]) && (!_board[i].equals("none")))
         {
            return true;
         }
      }
      for (int i = 0; i <= 2; i += 1)
      {
         if ((_board[i] == _board[i+3]) && (_board[i] == _board[i+6]) && (!_board[i].equals("none")))
         {
            return true;
         }
      }
      if (((_board[4] == _board[0]) && (_board[4] == _board[8])) || ((_board[4] == _board[2]) && (_board[4] == _board[6])))
      {
         if (!_board[4].equals("none"))
         {
            return true;
         }
      }
      return false;
   }
    /**
     * Check if the current gameboard has any open spots
     * @param _board
     * @return
     */
   public boolean checkTie(String[] _board)
   {
      for(String mark : _board)
      {
         if (mark.equals("none"))
         {
            return false;
         }
      }
      return true;
   }
    /**
     * Add "x" or "o" to the gameBoard
     * @param pos
     * @param playerTurn
     */
   public void addMarkModel(int pos, int playerTurn)
   {
      String marker = "o";
      if (playerTurn % 2 == 0)
      {
         marker = "x";
      }
      this.gameBoard[pos] = marker;
   }
    /**
     * return the current state of the gameBoard
     * @return
     */
   public String[] getBoard()
   {
      return gameBoard;
   }

}
