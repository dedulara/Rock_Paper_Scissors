//Computer picks the choice that will beat the player's current choice; happens 10% of the time

public class Cheat implements Strategy
{
    private String currentChoice;

    @Override
    public String getChoice(int rockTotalPlays, int paperTotalPlays, int scissorsTotalPlays, String lastChoice, String currentChoice)
    {
        String computersChoice = "";
        this.currentChoice = currentChoice;

        if(currentChoice == "Rock") {computersChoice = "Paper";}
        if(currentChoice == "Paper") {computersChoice = "Scissors";}
        if(currentChoice == "Scissors") {computersChoice = "Rock";}

        return computersChoice;
    }
}
