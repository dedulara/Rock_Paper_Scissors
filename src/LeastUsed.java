//Assume player will pick the choice they least pick; computer picks the move that will beat the least popular choice of player

public class LeastUsed implements Strategy
{
    private int rockTotalPlays;
    private int paperTotalPlays;
    private int scissorsTotalPlays;

    @Override
    public String getChoice(int rockTotalPlays, int paperTotalPlays, int scissorsTotalPlays, String lastChoice, String currentChoice)
    {
        String computersChoice = "";
        this.rockTotalPlays = rockTotalPlays;
        this.paperTotalPlays = paperTotalPlays;
        this.scissorsTotalPlays = scissorsTotalPlays;

        if(rockTotalPlays < paperTotalPlays && rockTotalPlays < scissorsTotalPlays) {computersChoice = "Paper";}
        else if(paperTotalPlays < rockTotalPlays && paperTotalPlays < scissorsTotalPlays) {computersChoice = "Scissors";}
        else if(scissorsTotalPlays < paperTotalPlays && scissorsTotalPlays < rockTotalPlays) {computersChoice = "Rock";}
        else {computersChoice = "Error";}

        return computersChoice;
    }
}
