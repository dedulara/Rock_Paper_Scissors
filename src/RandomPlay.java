//Randomly picks

import java.util.Random;

public class RandomPlay implements Strategy
{
    Random randomChoice = new Random();

    @Override
    public String getChoice(int rockTotalPlays, int paperTotalPlays, int scissorsTotalPlays, String lastChoice, String currentChoice)
    {
        String computersChoice = "";
        int computerRandom;

        computerRandom = randomChoice.nextInt(3);
        switch(computerRandom)
        {
            case 0:
                computersChoice = "Rock";
                break;
            case 1:
                computersChoice = "Paper";
                break;
            case 2:
                computersChoice = "Scissors";
                break;
        }
        return computersChoice;
    }
}
