import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Image;
import java.util.Random;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class TelescopePuzzle {

    public static boolean telescopePassed = false;

    private static JTextField playerInput;

    public static String answer = "";

    private final static String imageIcon1Path = "./images/aries.jpg";
    private static final ImageIcon imageIcon1 = new ImageIcon(imageIcon1Path);
    private final static String imageIcon2Path = "./images/gemini.jpg";
    private static final ImageIcon imageIcon2 = new ImageIcon(imageIcon2Path);
    private final static String imageIcon3Path = "./images/taurus.jpg";
    private static final ImageIcon imageIcon3 = new ImageIcon(imageIcon3Path);

    private static final ImageIcon[] imageArray = new ImageIcon[] {
            imageIcon1,
            imageIcon2,
            imageIcon3
    };

    public static void StartTelescopePuzzle() {

        // double n = Math.floor(Math.random() * (3 - 1 + 1)) + 1;

        ImageIcon imageIcon = imageArray[new Random().nextInt(imageArray.length)];
        if (imageIcon == imageIcon1) {
            answer = "aries";
        } else if (imageIcon == imageIcon2) {
            answer = "gemini";
        } else if (imageIcon == imageIcon3) {
            answer = "taurus";
        }

        JFrame constellationFrame = new JFrame("Constellation Puzzle");
        JFrame passedFrame = new JFrame();

        JPanel aries = new JPanel();
        JPanel input = new JPanel();

        JLabel ariesImage = new JLabel(
                new ImageIcon(imageIcon.getImage().getScaledInstance(390, 390, Image.SCALE_DEFAULT)));

        JLabel inputField = new JLabel("Enter constellation:");
        playerInput = new JTextField(15);
        JButton confirm = new JButton("CHECK");

        aries.setLayout(new BorderLayout());

        // String playerInput = JOptionPane.showInputDialog(input, "Enter
        // constellation");

        // JPanel gamePanel = menus.generateMainWindow(menus);
        aries.add(ariesImage, BorderLayout.CENTER);
        input.add(inputField);
        input.add(playerInput);
        input.add(confirm);

        aries.add(input, BorderLayout.SOUTH);

        constellationFrame.add(aries);

        constellationFrame.setMinimumSize(new Dimension(500, 500));
        constellationFrame.pack();
        constellationFrame.setLocationRelativeTo(null);
        constellationFrame.setVisible(true);

        playerInput.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
            }
        });

        confirm.addActionListener(e -> {
            String playerAnswer = playerInput.getText();
            if (playerAnswer.equals(answer)) {
                telescopePassed = true;
                JOptionPane.showMessageDialog(passedFrame, "Congradulations, Puzzle Passed");
                constellationFrame.setVisible(false);
            } else
                JOptionPane.showMessageDialog(passedFrame, "Try again");
        });

    }

    public String getInput() {
        return playerInput.getText();
    }
}
