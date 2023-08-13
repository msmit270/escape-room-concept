import javax.swing.*;
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
public class Menus {

    private GameType chosenGameType;

    private final static String clockIconPath = "./images/clock.png";
    private static final ImageIcon clockIcon = new ImageIcon(clockIconPath);
    private final static String wallpaperIconPath = "./images/vin-wall-paper.jpg";
    private static final ImageIcon wallpaperIcon = new ImageIcon(wallpaperIconPath);
    private final static String telescopeIconPath = "./images/telescope.png";
    private static final ImageIcon telescopeIcon = new ImageIcon(telescopeIconPath);
    private final static String bookCaseIconPath = "./images/book-shelf.png";
    private static final ImageIcon bookCaseIcon = new ImageIcon(bookCaseIconPath);

    /**
     * generates the main selection window
     * 
     * @return the described JPanel
     */
    public JPanel generateMainWindow(Menus menus) {
        JPanel searchSelect = new JPanel();
        searchSelect.setLayout(new BoxLayout(searchSelect, BoxLayout.Y_AXIS));
        searchSelect.add(getUserInputGameType(menus));
        return searchSelect;
    }

    /**
     * 
     * 
     * @return the described JPanel
     */
    public JPanel generateSinglePlayerWindow() {
        // JPanel gamesceen = new JPanel();
        // gamesceen.setLayout(new BoxLayout(gamesceen, BoxLayout.Y_AXIS));

        JLabel background = new JLabel(
                new ImageIcon(wallpaperIcon.getImage().getScaledInstance(800, 450, Image.SCALE_DEFAULT)));
        // gamesceen.add(background);

        JButton clockButton = new JButton(
                new ImageIcon(clockIcon.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT)));
        clockButton.setContentAreaFilled(false);
        clockButton.setFocusPainted(false);
        clockButton.setBorderPainted(false);

        JButton telescopeButton = new JButton(
                new ImageIcon(telescopeIcon.getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT)));
        telescopeButton.setContentAreaFilled(false);
        telescopeButton.setFocusPainted(false);
        telescopeButton.setBorderPainted(false);

        JButton bookCaseButton = new JButton(
                new ImageIcon(bookCaseIcon.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT)));
        bookCaseButton.setContentAreaFilled(false);
        bookCaseButton.setFocusPainted(false);
        bookCaseButton.setBorderPainted(false);

        JPanel gamesceen = new JPanel();
        gamesceen.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipadx = 20;
        gbc.ipady = 20;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gamesceen.add(clockButton, gbc);

        gbc.gridx = 1;
        gbc.gridy = 6;
        gamesceen.add(telescopeButton, gbc);

        gbc.gridx = 9;
        gbc.gridy = 6;
        gamesceen.add(bookCaseButton, gbc);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = 10;
        gbc.gridheight = 7;
        gamesceen.add(background, gbc);

        clockButton.addActionListener(e -> {
            if (ClockPuzzle.clockPassed == false) {
                ClockPuzzle.StartClockPuzzle();
            }

        });

        bookCaseButton.addActionListener(e -> {
            ClockPuzzle.BookPopup();

        });

        telescopeButton.addActionListener(e -> {
            if (TelescopePuzzle.telescopePassed == false) {
                TelescopePuzzle.StartTelescopePuzzle();
            }
        });// gamesceen.add(topLayer);

        return gamesceen;
    }

    /**
     * generates
     * 
     * @return the described JPanel
     */
    public JPanel generateMultiPlayerWindow() {
        JPanel seatCriteria = new JPanel();
        seatCriteria.setLayout(new BoxLayout(seatCriteria, BoxLayout.Y_AXIS));

        return seatCriteria;
    }

    /**
     * a method used
     * uses GidBagLayout
     * 
     * @return a JPanel of the home screen
     */
    public JPanel getUserInputGameType(Menus menus) {
        JButton singlePlayer = new JButton("SINGLE PLAYER GAME");
        JButton multiPlayer = new JButton("MULTI PLAYER GAME");

        JLabel headingLabel = new JLabel("WELCOME TO", JLabel.CENTER);
        headingLabel.setFont(new Font("Serif", Font.BOLD, 48));
        headingLabel.setForeground(Color.white);

        JLabel headingLabel2 = new JLabel("ESCAPE", JLabel.CENTER);
        headingLabel2.setFont(new Font("Serif", Font.BOLD, 38));
        headingLabel2.setForeground(Color.white);

        JLabel headingLabel3 = new JLabel("HOW WOULD YOU LIKE TO PLAY TODAY?", JLabel.CENTER);
        headingLabel3.setFont(new Font("Serif", Font.BOLD, 28));
        headingLabel3.setForeground(Color.white);

        JPanel gameTypePanel = new JPanel();
        gameTypePanel.setBackground(Color.darkGray);
        gameTypePanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipadx = 20;
        gbc.ipady = 20;
        gbc.gridx = 0;
        gbc.gridy = 3;
        gameTypePanel.add(singlePlayer, gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        gameTypePanel.add(multiPlayer, gbc);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = 2;
        gameTypePanel.add(headingLabel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = 2;
        gameTypePanel.add(headingLabel2, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = 2;
        gameTypePanel.add(headingLabel3, gbc);

        singlePlayer.addActionListener(e -> {
            chosenGameType = GameType.SINGLE_PLAYER;
            StartGame.loadView(menus);
        });

        multiPlayer.addActionListener(e -> {
            chosenGameType = GameType.MULTI_PLAYER;
            StartGame.loadView(menus);
        });

        return gameTypePanel;
    }

    public GameType getGameType() {
        return chosenGameType;
    }

}
