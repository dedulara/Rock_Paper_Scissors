//Computer picks the move the player just picked

public class LastUsed implements Strategy
{
    private String lastChoice;

    @Override
    public String getChoice(int rockTotalPlays, int paperTotalPlays, int scissorsTotalPlays, String lastChoice, String currentChoice)
    {
        String computersChoice = "";
        this.lastChoice = lastChoice;

        computersChoice = lastChoice;

        return computersChoice;
    }
}
