import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Image;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ClockPuzzle {

    public static boolean clockPassed = false;

    private final static String bookIconPath = "./images/book.jpg";
    private static final ImageIcon bookIcon = new ImageIcon(bookIconPath);

    public static void StartClockPuzzle() {

        double clockTime = 14.00;

        JFrame timeFrame = new JFrame();
        String playerInput = JOptionPane.showInputDialog(timeFrame, "Enter time (in 24hr format, ie: 15.30:");

        if (clockTime == Double.parseDouble(playerInput)) {
            clockPassed = true;
            JOptionPane.showMessageDialog(timeFrame, "Congradulations, Puzzle Passed");

        }
    }

    public static void BookPopup() {

        JFrame bookFrame = new JFrame("You found an old book");
        JPanel book = new JPanel();
        JLabel bookImage = new JLabel(
                new ImageIcon(bookIcon.getImage().getScaledInstance(490, 290, Image.SCALE_DEFAULT)));
        book.setLayout(new BorderLayout());

        // JPanel gamePanel = menus.generateMainWindow(menus);
        book.add(bookImage, BorderLayout.CENTER);

        book.add(Box.createRigidArea(new Dimension(20, 0)), BorderLayout.WEST);
        book.add(Box.createRigidArea(new Dimension(20, 0)), BorderLayout.EAST);

        bookFrame.add(book);

        bookFrame.setMinimumSize(new Dimension(500, 300));
        bookFrame.pack();
        bookFrame.setLocationRelativeTo(null);
        bookFrame.setVisible(true);

    }

}
