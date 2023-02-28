import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Random;

public class RockPaperScissorsFrame extends JFrame
{
    JPanel mainPanel;
    JPanel buttonPanel;
    JPanel statsPanel;
    JPanel outcomePanel;

    JButton rockButton;
    JButton paperButton;
    JButton scissorsButton;
    JButton quitButton;

    JLabel playerWinsL;
    JLabel computerWinsL;
    JLabel tieWinsL;

    JTextField playerTotal;
    JTextField computerTotal;
    JTextField tieTotal;

    JTextArea outcomeTextArea;
    JScrollPane scrollPaneVariable;

    ImageIcon rockPic;
    ImageIcon paperPic;
    ImageIcon scissorsPic;
    ImageIcon quitPic;

    String playersChoice = "";
    String computersChoice = "";

    int playerWinsI = 0;
    int computerWinsI = 0;
    int tieWinsI = 0;
    int computerRandom;

    Random randomChoice = new Random();

    Border blackline = BorderFactory.createLineBorder(Color.black, 5);

    public RockPaperScissorsFrame()
    {
        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        createButtonPanel();
        mainPanel.add(buttonPanel, BorderLayout.NORTH);
        createStatsPanel();
        mainPanel.add(statsPanel, BorderLayout.CENTER);
        createOutcomePanel();
        mainPanel.add(outcomePanel, BorderLayout.SOUTH);
        add(mainPanel);
        setSize(600, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void createButtonPanel()
    {
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1,4));
        buttonPanel.setBorder(blackline);

        rockPic = new ImageIcon("src/RockImage.jpg");
        rockButton = new JButton("Rock", rockPic);
        rockButton.setVerticalTextPosition(SwingConstants.BOTTOM);
        rockButton.setHorizontalTextPosition(SwingConstants.CENTER);
        rockButton.setBackground(Color.white);

        paperPic = new ImageIcon("src/PaperImage.jpg");
        paperButton = new JButton("Paper", paperPic);
        paperButton.setVerticalTextPosition(SwingConstants.BOTTOM);
        paperButton.setHorizontalTextPosition(SwingConstants.CENTER);
        paperButton.setBackground(Color.white);

        scissorsPic = new ImageIcon("src/ScissorsImage.jpg");
        scissorsButton = new JButton("Scissors", scissorsPic);
        scissorsButton.setVerticalTextPosition(SwingConstants.BOTTOM);
        scissorsButton.setHorizontalTextPosition(SwingConstants.CENTER);
        scissorsButton.setBackground(Color.white);

        quitPic = new ImageIcon("src/QuitImage.jpg");
        quitButton = new JButton("Quit", quitPic);
        quitButton.setVerticalTextPosition(SwingConstants.BOTTOM);
        quitButton.setHorizontalTextPosition(SwingConstants.CENTER);
        quitButton.setBackground(Color.white);

        rockButton.addActionListener((ActionEvent ae) ->
        {
            playersChoice = "Rock";
            gameOutcome();
        });
        paperButton.addActionListener((ActionEvent ae) ->
        {
            playersChoice = "Paper";
            gameOutcome();
        });
        scissorsButton.addActionListener((ActionEvent ae) ->
        {
            playersChoice = "Scissors";
            gameOutcome();
        });
        quitButton.addActionListener((ActionEvent ae) -> System.exit(0));

        buttonPanel.add(rockButton);
        buttonPanel.add(paperButton);
        buttonPanel.add(scissorsButton);
        buttonPanel.add(quitButton);
    }

    private void createStatsPanel()
    {
        statsPanel = new JPanel();
        statsPanel.setSize(100,100);
        statsPanel.setLayout(new GridLayout(3,2));

        playerWinsL = new JLabel("Player Wins:           ");
        computerWinsL = new JLabel("Computer Wins:           ");
        tieWinsL = new JLabel("Ties:           ");

        playerTotal = new JTextField("0");
        computerTotal = new JTextField("0");
        tieTotal = new JTextField("0");

        playerWinsL.setHorizontalAlignment(JTextField.RIGHT);
        computerWinsL.setHorizontalAlignment(JTextField.RIGHT);
        tieWinsL.setHorizontalAlignment(JTextField.RIGHT);

        statsPanel.add(playerWinsL);
        statsPanel.add(playerTotal);
        statsPanel.add(computerWinsL);
        statsPanel.add(computerTotal);
        statsPanel.add(tieWinsL);
        statsPanel.add(tieTotal);
    }

    private void createOutcomePanel()
    {
        outcomePanel = new JPanel();

        outcomeTextArea = new JTextArea(10, 25);
        outcomeTextArea.setEditable(false);
        scrollPaneVariable = new JScrollPane(outcomeTextArea);
        outcomePanel.add(scrollPaneVariable);
    }

    private void gameOutcome()
    {
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
        if(playersChoice == computersChoice)
        {
            outcomeTextArea.append("Tie (" + playersChoice + ")\n");
            tieWinsI++;
            tieTotal.setText(String.valueOf(tieWinsI));
        }
        if(playersChoice == "Rock" && computersChoice == "Scissors")
        {
            outcomeTextArea.append("Rock breaks scissors (Player wins)\n");
            playerWinsI++;
            playerTotal.setText(String.valueOf(playerWinsI));
        }
        if(playersChoice == "Rock" && computersChoice == "Paper")
        {
            outcomeTextArea.append("Paper covers rock (Computer wins)\n");
            computerWinsI++;
            computerTotal.setText(String.valueOf(computerWinsI));
        }
        if(playersChoice == "Paper" && computersChoice == "Rock")
        {
            outcomeTextArea.append("Paper covers rock (Player wins)\n");
            playerWinsI++;
            playerTotal.setText(String.valueOf(playerWinsI));
        }
        if(playersChoice == "Paper" && computersChoice == "Scissors")
        {
            outcomeTextArea.append("Scissors cut paper (Computer wins)\n");
            computerWinsI++;
            computerTotal.setText(String.valueOf(computerWinsI));
        }
        if(playersChoice == "Scissors" && computersChoice == "Rock")
        {
            outcomeTextArea.append("Rock breaks scissors (Computer wins)\n");
            computerWinsI++;
            computerTotal.setText(String.valueOf(computerWinsI));
        }
        if(playersChoice == "Scissors" && computersChoice == "Paper")
        {
            outcomeTextArea.append("Scissors cut paper (Player wins)\n");
            playerWinsI++;
            playerTotal.setText(String.valueOf(playerWinsI));
        }
    }
}
