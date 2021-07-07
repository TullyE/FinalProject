import java.util.Random;

public class hangmanModel
{
    private String[] possibleWords = new String[]{"cupcake", "flower", "sleepy", "tiger", "candy", "corn", "code", "pine", "cone", "pirate", "cookies", "trees", "tulips"};
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

    public String getKnownWord()
    {
        return knownLetters;
    }
    public String getWord()
    {
        return this.theWord;
    }
    public int getLives()
    {
        return this.lives;
    }
    public boolean isWin()
    {
        return knownLetters.equals(theWord);
    }
}
