package experiment;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class MethodizedGameStore {
	private static Object[][] gamesAndPrice = {
			{"Sid Meier's Civilization VI", "2190", "Strategy"},
			{"BioShock Infinite", "190", "Action"}, 
			{"Stellaris", "1079", "Strategy"},
			{"The Sims 3", "599", "Simulation"},
			{"The Last of Us Part I", "2990", "Action"},
			{"Fallen Hero: Retribution", "600", "Gamebook"},
			{"Command & Conquer Red Alert 2", "0", "Strategy"},
			{"Victoria 3", "2000", "Strategy"}
	};
	private static String[] genres = {"Action", "Gamebook", "Simulation", "Strategy"};

    public static void main(String[] args) {    	
        JFrame frame = createMainFrame();
        createAccordions(frame);
        frame.setVisible(true);
    }

    private static JFrame createMainFrame() {
        JFrame frame = new JFrame("Beagle Games");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        // Create a scroll pane and add it to the frame
        JScrollPane scrollPane = new JScrollPane();
        frame.getContentPane().add(scrollPane, BorderLayout.CENTER);

        // Create a panel to hold the accordions
        JPanel contentPane = new JPanel();
        contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS)); // What happens if I put FlowLayout here?
        scrollPane.setViewportView(contentPane);

        return frame;
    }

    private static void createAccordions(JFrame frame) {
        JPanel accordionContainer = new JPanel();
        accordionContainer.setLayout(new BoxLayout(accordionContainer, BoxLayout.Y_AXIS));
        accordionContainer.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0)); // Add an empty border to create some space

        for (String genre : genres) {
            JComponent accordion = createAccordion(genre);
            accordionContainer.add(accordion);
        }

        JScrollPane scrollPane = new JScrollPane(accordionContainer);
        frame.add(scrollPane, BorderLayout.CENTER);
    }

    private static JComponent createAccordion(String genre) {
        // Create the accordion panel
        JPanel accordionPanel = new JPanel();
        accordionPanel.setLayout(new BoxLayout(accordionPanel, BoxLayout.Y_AXIS));
        accordionPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 5, 0)); // Add an empty border to create some space at the bottom

        // Create the header for the accordion panel
        JPanel accordionHeader = new JPanel(new BorderLayout());
        JLabel headerLabel = new JLabel(genre);
        headerLabel.setVerticalAlignment(SwingConstants.BOTTOM);
        accordionHeader.add(headerLabel, BorderLayout.WEST);
        headerLabel.setFont(new Font("Bebas Neue", Font.BOLD, 30));
        headerLabel.setForeground(new Color(255, 255, 255));
        accordionHeader.setBackground(new Color(0, 135, 189));

        // Create the toggle button for the accordion
        JToggleButton toggleButton = new RoundedToggleButton("-");
        toggleButton.setPreferredSize(new Dimension(30, 30));
        toggleButton.setSelected(true); // Set the initial state to "on"

        // Create the panel that holds the game panels
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
        contentPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, contentPanel.getPreferredSize().height));

        toggleButton.addActionListener(e -> {
            contentPanel.setVisible(toggleButton.isSelected());
            if (toggleButton.isSelected()) {
                toggleButton.setText("-");
            } else {
                toggleButton.setText("+");
            }
        });

        accordionHeader.add(toggleButton, BorderLayout.EAST);
        accordionPanel.add(accordionHeader); // Add the accordion header to the accordion panel

        // Create the game panels and add them to the content panel
        for (Object[] gameInfo : gamesAndPrice) {
            String gameTitle = (String) gameInfo[0];
            String gamePrice = (String) gameInfo[1];
            String gameGenre = (String) gameInfo[2];

            if (gameGenre.equals(genre)) {
                JPanel gamePanel = createGamePanel(gameTitle, gamePrice);
                contentPanel.add(gamePanel);
            }
        }

        // Set the initial state of the content panel
        contentPanel.setVisible(true);

        // Add the content panel to the accordion panel
        accordionPanel.add(contentPanel);

        return accordionPanel;
    }

    private static JPanel createGamePanel(String gameTitle, String gamePrice) {
        JPanel gamePanel = new JPanel(new GridLayout(3, 1));
        JLabel gameLabel = new JLabel(gameTitle);
        JLabel priceLabel = new JLabel("P" + gamePrice);
        JButton addButton = new RoundedButton("ADD TO CART");

        gamePanel.setBackground(new Color(0, 150, 200));
        gameLabel.setFont(new Font("Helvetica Rounded Condensed", Font.BOLD, 21));
        priceLabel.setFont(new Font("Helvetica LT Std", Font.PLAIN, 15));
        addButton.setFont(new Font("Helvetica", Font.BOLD, 15));
        addButton.setBackground(new Color(226, 104, 29));
        addButton.setForeground(Color.WHITE);
        gameLabel.setForeground(Color.WHITE);
        priceLabel.setForeground(Color.WHITE);

        // Create a new JPanel with FlowLayout and add the button to it
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
        buttonPanel.setBackground(new Color(255, 255, 255, 100));
        buttonPanel.add(addButton);

        // Add the components to the game panel
        gamePanel.add(gameLabel);
        gamePanel.add(priceLabel);
        gamePanel.add(buttonPanel); // Add the button panel instead of the button

        return gamePanel;
    }

}
