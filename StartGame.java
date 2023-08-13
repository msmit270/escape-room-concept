import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.List;

public class StartGame {
    private static Menus menus;
    private static JFrame mainWindow = null;
    private static JPanel gameView = null;

    /**
     * main method - initialises and creates main JFrame
     * 
     * @param args NA
     */
    public static void main(String[] args) {
        mainWindow = new JFrame();
        mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainWindow.setMinimumSize(new Dimension(800, 500));
        gameView = generateGameView();
        mainWindow.setContentPane(gameView);
        mainWindow.pack();
        mainWindow.setLocationRelativeTo(null);
        mainWindow.setVisible(true);
    }

    public static Menus refreshSearchView() {
        return new Menus();
    }

    /**
     * method to generate the main search view of the app, by using the menus object
     * 
     * @return a JPanel representing the main search view
     */
    public static JPanel generateGameView() {

        JPanel gameWindow = new JPanel();
        gameWindow.setLayout(new BorderLayout());
        menus = refreshSearchView();
        JPanel gamePanel = menus.generateMainWindow(menus);
        gameWindow.add(gamePanel, BorderLayout.CENTER);

        gameWindow.add(Box.createRigidArea(new Dimension(20, 0)), BorderLayout.WEST);
        gameWindow.add(Box.createRigidArea(new Dimension(20, 0)), BorderLayout.EAST);
        return gameWindow;
    }

    /**
     * method to generate the car seat cover search view of the app, by using the
     * menus object
     * 
     * @return a JPanel representing the car seat cover search view containing a
     *         submit button
     */
    public static JPanel generateSinglePlayerView() {
        JPanel gameWindow = new JPanel();
        gameWindow.setLayout(new BorderLayout());
        JPanel gamePanel = menus.generateSinglePlayerWindow();
        gameWindow.add(gamePanel, BorderLayout.CENTER);

        JButton goBackToMain = new JButton("EXIT");
        goBackToMain.addActionListener(e -> {
            gameView = generateGameView();
            mainWindow.setContentPane(gameView);
            mainWindow.pack();
            mainWindow.setVisible(true);
        });

        JPanel buttonPanel = new JPanel();
        JPanel selectionPanel = new JPanel();
        selectionPanel.setLayout(new BoxLayout(selectionPanel, BoxLayout.LINE_AXIS));
        selectionPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        selectionPanel.add(Box.createRigidArea(new Dimension(10, 0)));
        // selectionPanel.add(search);
        selectionPanel.add(Box.createRigidArea(new Dimension(10, 0)));
        selectionPanel.add(goBackToMain);
        selectionPanel.add(Box.createRigidArea(new Dimension(10, 0)));
        selectionPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        buttonPanel.add(selectionPanel, BorderLayout.CENTER);
        gameWindow.add(buttonPanel, BorderLayout.SOUTH);
        gameWindow.add(Box.createRigidArea(new Dimension(20, 0)), BorderLayout.WEST);
        gameWindow.add(Box.createRigidArea(new Dimension(20, 0)), BorderLayout.EAST);

        return gameWindow;
    }

    /**
     * method to generate the car seat cover search view of the app, by using the
     * menus object
     * 
     * @return a JPanel representing the car seat cover search view containing a
     *         submit button
     */
    public static JPanel generateMultiPlayerView() {
        JPanel gameWindow = new JPanel();
        gameWindow.setLayout(new BorderLayout());
        JPanel gamePanel = menus.generateSinglePlayerWindow();
        gameWindow.add(gamePanel, BorderLayout.CENTER);

        JButton goBackToMain = new JButton("EXIT");
        goBackToMain.addActionListener(e -> {
            gameView = generateGameView();
            mainWindow.setContentPane(gameView);
            mainWindow.pack();
            mainWindow.setVisible(true);
        });

        JPanel buttonPanel = new JPanel();
        JPanel selectionPanel = new JPanel();
        selectionPanel.setLayout(new BoxLayout(selectionPanel, BoxLayout.LINE_AXIS));
        selectionPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        selectionPanel.add(Box.createRigidArea(new Dimension(10, 0)));
        // selectionPanel.add(search);
        selectionPanel.add(Box.createRigidArea(new Dimension(10, 0)));
        selectionPanel.add(goBackToMain);
        selectionPanel.add(Box.createRigidArea(new Dimension(10, 0)));
        selectionPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        buttonPanel.add(selectionPanel, BorderLayout.CENTER);
        gameWindow.add(buttonPanel, BorderLayout.SOUTH);
        gameWindow.add(Box.createRigidArea(new Dimension(20, 0)), BorderLayout.WEST);
        gameWindow.add(Box.createRigidArea(new Dimension(20, 0)), BorderLayout.EAST);

        return gameWindow;
    }

    /**
     * a method to load the required view
     * 
     * @param menus an instance of the Menus class (used to generate JPanels for
     *              game)
     */
    public static void loadView(Menus menus) {
        GameType gameType = menus.getGameType();
        if (gameType.equals(GameType.SINGLE_PLAYER)) {// single player clicked
            gameView = generateSinglePlayerView();
        } else if (menus.getGameType() == GameType.MULTI_PLAYER) {// multi player clicked
            gameView = generateMultiPlayerView();
        } else {
            JOptionPane.showMessageDialog(mainWindow, "You MUST select a game type.\n", "Invalid search",
                    JOptionPane.INFORMATION_MESSAGE);
            gameView = generateGameView();
        }
        mainWindow.setContentPane(gameView);
        mainWindow.pack();
        mainWindow.setVisible(true);
    }
}
