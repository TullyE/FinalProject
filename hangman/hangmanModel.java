package hangman;

/**
hangmanModel
has the Model code for the hangmanModel
Tully Eva
07/06/2021
*/
import java.util.Random;
public class hangmanModel
{
    private String[] possibleWords = new String[]{"hhhhhhhhhh", "hhhhhhhhhh"};
    private String knownLetters = "";
    private String theWord;
    private int lives = 6;
    

    /**
     * Randomize and set the word
     * set the lenght of known letters to the lenght of the word
     */
    public void setWord()
    {
        Random rand = new Random();
        int randInt = rand.nextInt(possibleWords.length);
        this.theWord = this.possibleWords[randInt];

        for(int i = 0; i < this.theWord.length(); i += 1)
        {
                knownLetters = knownLetters + "_";
        }
        
    }
    /**
     * check if a letter is inside the word
     * @param guess
     * @return true/false
     */
    public boolean checkGuess(String guess)
    {
        for (int i = 0; i < this.theWord.length(); i += 1)
        {
            if (this.theWord.substring(i, i+1).equals(guess))
            {
                return true;
            }
        }
        lives -= 1;
        return false;
    }
    /**
     * update teh known letters
     * @param guess
     */
    public void updateKnownLetters(String guess)
    {
        for (int i = 0; i < this.theWord.length(); i += 1)
        {
            if (this.theWord.substring(i, i+1).equals(guess))
            {
                this.knownLetters = this.knownLetters.substring(0, i) + guess + this.knownLetters.substring(i+1, this.knownLetters.length()); 
            }
        }
    }
    /**
     * @return String knownLetters
     */
    public String getKnownWord()
    {
        return knownLetters;
    }
    /**
     * @return the mystery word
     */
    public String getWord()
    {
        return this.theWord;
    }
    /**
     * @return the number of lives left
     */
    public int getLives()
    {
        return this.lives;
    }
    /**
     * returns true if the known letters is equal to the word
     * @return true/false
     */
    public boolean isWin()
    {
        return knownLetters.equals(theWord);
    }
}
