import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.util.*;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.util.*;

/**
 * a class used to create panels
 */
public class GameShow {

    private GameType chosenGameType;

    private final static String clockIconPath = "./images/clock.png";
    private static final ImageIcon clockIcon = new ImageIcon(clockIconPath);
    private final static String wallpaperIconPath = "./images/vin-wall-paper.jpg";
    private static final ImageIcon wallpaperIcon = new ImageIcon(wallpaperIconPath);
    private final static String telescopeIconPath = "./images/telescope.png";
    private static final ImageIcon telescopeIcon = new ImageIcon(telescopeIconPath);
    private final static String bookCaseIconPath = "./images/book-shelf.png";
    private static final ImageIcon bookCaseIcon = new ImageIcon(bookCaseIconPath);

    public JPanel gameContainer;

    public JPanel background;

    public JPanel titleArea;
    public JLabel title;

    public JPanel gameArea;
    public JPanel gameSelect;
    public JLabel gameSelectInstructions;
    public JPanel guessContainer;

    public JButton wordScramble;
    public JButton memoryGame;
    public JButton guessingGame;

    /**
     * generates the main selection window
     * 
     * @return the described JPanel
     */
    public static void main(String args) {

        JPanel background;

        JPanel titleArea;
        JLabel title;

        JPanel gameContainer;
        JPanel gameArea;
        JPanel gameSelect;
        JLabel gameSelectInstructions;

        JButton wordScramble;
        JButton memoryGame;
        JButton guessingGame;

        background = new JPanel(new BorderLayout());
        background.setPreferredSize(new Dimension(800, 600));
        background.setBackground(Color.WHITE);

        titleArea = new JPanel(new BorderLayout());
        titleArea.setPreferredSize(new Dimension(800, 100));
        titleArea.setBackground(new Color(255, 255, 0));

        title = new JLabel("GAME SHOW", SwingConstants.CENTER);
        title.setFont(new Font("Arial Black", Font.PLAIN, 60));

        titleArea.add(title, BorderLayout.CENTER);

        background.add(titleArea, BorderLayout.NORTH);

        gameContainer = new JPanel(new BorderLayout());
        gameContainer.setPreferredSize(new Dimension(700, 400));
        gameContainer.setBorder(new EmptyBorder(20, 20, 20, 20));
        gameContainer.setBackground(Color.WHITE);

        gameSelect = new JPanel(new BorderLayout());
        gameSelect.setPreferredSize(new Dimension(760, 40));
        gameSelect.setBackground(new Color(255, 106, 210));

        gameSelectInstructions = new JLabel("Select a game to play", SwingConstants.CENTER);
        gameSelectInstructions.setFont(new Font("Arial", Font.PLAIN, 24));

        gameSelect.add(gameSelectInstructions, BorderLayout.CENTER);

        gameArea = new JPanel(new BorderLayout(10, 10));
        gameArea.setBackground(new Color(255, 106, 210));

        gameArea.add(gameSelect, BorderLayout.NORTH);

        wordScramble = new JButton("Word Scramble");
        wordScramble.setPreferredSize(new Dimension(100, 50));
        // wordScramble.addActionListener((evt) ->
        // sendCommand(new JsonObject().put("command", "wordScramble")));

        gameArea.add(wordScramble, BorderLayout.NORTH);

        memoryGame = new JButton("Memory Game");
        memoryGame.setPreferredSize(new Dimension(100, 50));

        gameArea.add(memoryGame, BorderLayout.CENTER);

        guessingGame = new JButton("Guess the Animal");
        guessingGame.setPreferredSize(new Dimension(100, 50));

        gameArea.add(guessingGame, BorderLayout.SOUTH);

        gameContainer.add(gameArea);

        background.add(gameContainer);
    }

    public void startWordScramble(String scrambledWord, int gameId) {

        JPanel guessContainer;

        gameContainer.removeAll();
        gameContainer.validate();
        gameContainer.repaint();

        JPanel scrambledWordPanel = new JPanel(new BorderLayout());
        JLabel scrambled = new JLabel(scrambledWord, SwingConstants.CENTER);

        scrambledWordPanel.add(scrambled, BorderLayout.CENTER);

        gameContainer.add(scrambledWordPanel, BorderLayout.NORTH);

        guessContainer = new JPanel(new BorderLayout(50, 50));
        guessContainer.setBorder(new EmptyBorder(100, 100, 100, 100));

        JTextField guess = new JTextField(5);
        JButton sendGuess = new JButton("Submit guess");
        // sendGuess.addActionListener((evt) ->
        // sendCommand(new JsonObject()
        // .put("command", "guess")
        // .put("guess", guess.getText())
        // .put("gameId", gameId)));

        guessContainer.add(guess, BorderLayout.CENTER);
        guessContainer.add(sendGuess, BorderLayout.SOUTH);

        gameContainer.add(guessContainer, BorderLayout.CENTER);
        gameContainer.validate();
        gameContainer.repaint();
    }

    public void wordScrambleGuess(boolean correct) {

        if (!correct) {
            JLabel tryAgain = new JLabel("That's not quite right :( Try again!",
                    SwingConstants.CENTER);
            guessContainer.add(tryAgain, BorderLayout.NORTH);
        } else {
            guessContainer.removeAll();
            guessContainer.validate();
            guessContainer.repaint();
            JLabel congrats = new JLabel("Congratulations! You Win :)",
                    SwingConstants.CENTER);
            guessContainer.add(congrats, BorderLayout.CENTER);
        }

        guessContainer.validate();
        guessContainer.repaint();
    }
}
