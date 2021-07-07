public class hangmanController
{
    private hangmanModel theModel;
    private hangmanView theView;

    public hangmanController(hangmanView _theView, hangmanModel _theModel)
    {
        theModel = _theModel;
        theView = _theView;
    }
    public void logic()
    {
        theModel.setWord();
        theView.initializeHashMap(theModel.getWord());
        boolean playing = true;
        String guess = "";
        theView.updateKnownLettersView(theModel.getKnownWord());
        boolean waitingForSubmit = false, gettingGuess = true;
        
        while (playing)
        {
            theView.setLivesV(theModel.getLives());
            while (gettingGuess == true)
            {
                //System.out.println("2");
                guess = theView.getGuess();
                theView.invalidate();
                theView.validate();
                theView.repaint();
                waitingForSubmit = theView.submit();
                if ((waitingForSubmit == true) && (theView.guessedAlready(guess) == false))
                {
                    break;
                }
                
            }
            theView.resetGuess();
            if (theModel.checkGuess(guess))
            {
                theModel.updateKnownLetters(guess);
                theView.updateKnownLettersView(theModel.getKnownWord());
            }
            gettingGuess = true;
            waitingForSubmit = false;
            if ((theModel.getLives() == 0) || theModel.isWin())
            {
                break;
            }
        }
        theView.setLivesV(theModel.getLives());
        if ((theModel.getLives() == 0))
        {
            theView.setLoss(true);
            try 
            {
            Thread.sleep(3000);
            }
            catch (InterruptedException ex)
            {
            }
            theView.end();
        }
        if (theModel.isWin())
        {
            theView.setWin(true);
            try 
            {
            Thread.sleep(3000);
            }
            catch (InterruptedException ex)
            {
            }
            theView.end();
        }
    }
}
