package experiment;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

import javax.swing.*;

public class experiment {
	private static JComponent accordionContentComponent;
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
		JFrame gameListFrame = createGameListFrame();
		createGenreAccordions(gameListFrame);
		gameListFrame.setVisible(true);
	}
	
	private static JFrame createGameListFrame() {
		JFrame gameListFrame = new JFrame("Beagle Games");
		gameListFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gameListFrame.setSize(400, 300);
		
		JScrollPane scrollPane = new JScrollPane();
		gameListFrame.getContentPane().add(scrollPane, BorderLayout.CENTER);
		
		JPanel contentPane = new JPanel();
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		scrollPane.setViewportView(contentPane);
		
		return gameListFrame;
	}
	
	private static void createGenreAccordions(JFrame frame) {
	    JPanel contentPane = new JPanel();
	    contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
	    JScrollPane scrollPane = new JScrollPane(contentPane);
	    frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
	    
	    // Declare the Map variable
	    Map<JToggleButton, JComponent> toggleMap = new HashMap<>();

	    for (String genre : genres) {
	        JPanel genreAccordion = new JPanel();
	        genreAccordion.setLayout(new BoxLayout(genreAccordion, BoxLayout.Y_AXIS));
	        genreAccordion.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));

	        JComponent accordionComponent = createAccordionHeader(genre, toggleMap);
	        genreAccordion.add(accordionComponent);

	        JComponent accordionContentComponent = createAccordionContent(genre);
	        toggleMap.put((JToggleButton)accordionComponent.getClientProperty("toggleButton"), accordionContentComponent);
	        genreAccordion.add(accordionContentComponent);

	        contentPane.add(genreAccordion);
	    }
	}
	
	private static JComponent createAccordionHeader(String genre, Map<JToggleButton, JComponent> toggleMap) {
	    JPanel accordionHeader = new JPanel();
	    accordionHeader.setLayout(new BoxLayout(accordionHeader, BoxLayout.X_AXIS));
	    accordionHeader.setBorder(BorderFactory.createEmptyBorder(0, 0, 5, 0));
	    accordionHeader.setBackground(new Color(0, 71, 145));
	    // accordionHeader.setOpaque(true);
	    accordionHeader.setMaximumSize(new Dimension(Integer.MAX_VALUE, 50));
	    
	    JLabel genreTitle = new JLabel(genre);
	    genreTitle.setVerticalAlignment(SwingConstants.BOTTOM);
	    genreTitle.setFont(new Font("Bebas Neue", Font.BOLD, 30));
	    genreTitle.setForeground(new Color(255, 255, 255));        
	    genreTitle.setOpaque(false);
	    
	    // Sets the toggle button to the right of the accordion header by adding space
	    Box headerBox = Box.createHorizontalBox();
	    headerBox.add(Box.createHorizontalGlue());
	    
	    accordionHeader.add(genreTitle, BorderLayout.WEST);
	    
	    JToggleButton accordionToggle = new RoundedToggleButton("-");
	    accordionToggle.setPreferredSize(new Dimension(30, 30));
	    accordionToggle.setSelected(true);
	    
	    accordionToggle.addActionListener(e -> {
	        toggleMap.get(accordionToggle).setVisible(accordionToggle.isSelected());
	        if (accordionToggle.isSelected()) {
	            accordionToggle.setText("-");
	        } else {
	            accordionToggle.setText("+");
	        }
	    });

	    accordionHeader.putClientProperty("toggleButton", accordionToggle); // add the toggleButton to the accordionHeader's client property
	    
	    accordionHeader.add(headerBox);
	    accordionHeader.add(accordionToggle);
	            
	    return accordionHeader;
	}

	
	private static JComponent createAccordionContent(String genre) {
	    JPanel genreContent = new JPanel();
	    genreContent.setLayout(new BoxLayout(genreContent, BoxLayout.Y_AXIS));
	    genreContent.setBackground(new Color(0, 135, 189, 0));
	    
	    // Declare accordionContentComponent inside the method

	    for (Object[] gameInfo : gamesAndPrice) {
	        String gameTitle = (String) gameInfo[0];
	        String gamePrice = (String) gameInfo[1];
	        String gameGenre = (String) gameInfo[2];

	        if (gameGenre.equals(genre)) {
	            JPanel gamePanel = createGamePanel(gameTitle, gamePrice);
	            genreContent.add(gamePanel);
	        }
	    }
	    
	    // Assign the accordionContentComponent variable
	    accordionContentComponent = genreContent;

	    return accordionContentComponent;
	}

	
	private static JPanel createGamePanel(String gameTitle, String gamePrice) {
		JPanel gameInfoPanel = new JPanel(new GridLayout(3, 1));
		JLabel gameLabel = new JLabel(gameTitle);
		JLabel priceLabel = new JLabel("P" + gamePrice);
		JButton addToCartButton = new RoundedButton("ADD TO CART");
		
		gameInfoPanel.setBackground(new Color(0, 150, 200));
		gameInfoPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 150));
        gameLabel.setFont(new Font("Helvetica Rounded Condensed", Font.BOLD, 21));
        priceLabel.setFont(new Font("Helvetica LT Std", Font.PLAIN, 15));
        addToCartButton.setFont(new Font("Helvetica", Font.BOLD, 15));
        addToCartButton.setBackground(new Color(226, 104, 29));
        addToCartButton.setForeground(Color.WHITE);
        gameLabel.setForeground(Color.WHITE);
        priceLabel.setForeground(Color.WHITE);

        // Create a new JPanel with FlowLayout and add the button to it
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
        buttonPanel.setBackground(new Color(255, 255, 255, 0));
        buttonPanel.add(addToCartButton);

        // Add the components to the game panel
        gameInfoPanel.add(gameLabel);
        gameInfoPanel.add(priceLabel);
        gameInfoPanel.add(buttonPanel); // Add the button panel instead of the button

        return gameInfoPanel;		
	}

}