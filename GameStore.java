package experiment;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class GameStore {   
   public static void main(String[] args) {
      // Create the main window
      JFrame frame = new JFrame("Game Store");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setSize(400, 300);

      // Create the accordion panel
      JPanel accordionPanel = new JPanel();
      accordionPanel.setLayout(new BoxLayout(accordionPanel, BoxLayout.Y_AXIS));
      accordionPanel.setVisible(true); // set visibility to true

      // Create the toggle button for the accordion
      JToggleButton toggleButton = new RoundedToggleButton("-");
      toggleButton.setPreferredSize(new Dimension(30, 30));
      
      toggleButton.addActionListener(e -> {
         accordionPanel.setVisible(toggleButton.isSelected());
         if (toggleButton.isSelected()) {
            toggleButton.setText("-");
         } else {
            toggleButton.setText("+");
         }
      });

      // Create the header for the accordion panel
      JPanel accordionHeader = new JPanel(new BorderLayout());
      JLabel headerLabel = new JLabel("Action");
      headerLabel.setVerticalAlignment(SwingConstants.BOTTOM);
      accordionHeader.add(headerLabel, BorderLayout.WEST);
      headerLabel.setFont(new Font("Bebas Neue", Font.BOLD, 30));
      headerLabel.setForeground(new Color(255, 255, 255));
      accordionHeader.setBackground(new Color(0, 135, 189));
      
      accordionHeader.add(toggleButton, BorderLayout.EAST);

      // Create the game panels
      JPanel gamePanel1 = new JPanel(new GridLayout(3, 1));
      JLabel gameLabel1 = new JLabel("BioShock Infinite");
      JLabel priceLabel1 = new JLabel("$30.00");
      JButton addButton1 = new RoundedButton("Add to Cart");

      gamePanel1.setBackground(new Color (0, 150, 200));
      gameLabel1.setFont(new Font("Helvetica Rounded Condensed", Font.BOLD, 21));
      priceLabel1.setFont(new Font("Helvetica LT Std", Font.PLAIN, 15));
      gameLabel1.setForeground(Color.WHITE);
      priceLabel1.setForeground(Color.WHITE);

      // Create a new JPanel with FlowLayout and add the button to it
      JPanel buttonPanel1 = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
      buttonPanel1.setBackground(new Color(255, 255, 255, 0));
      buttonPanel1.add(addButton1);

      // Add the components to the game panel
      gamePanel1.add(gameLabel1);
      gamePanel1.add(priceLabel1);
      gamePanel1.add(buttonPanel1); // Add the button panel instead of the button

      JPanel gamePanel2 = new JPanel(new GridLayout(3, 1));
      JLabel gameLabel2 = new JLabel("The Last of Us Part I");
      JLabel priceLabel2 = new JLabel("$60.00");
      JButton addButton2 = new RoundedButton("Add to Cart");

      gamePanel2.setBackground(new Color (0, 150, 200));
      gameLabel2.setFont(new Font("Helvetica Rounded Condensed", Font.BOLD, 21));
      priceLabel2.setFont(new Font("Helvetica LT Std", Font.PLAIN, 15));
      gameLabel2.setForeground(Color.WHITE);
      priceLabel2.setForeground(Color.WHITE);

      // Create a new JPanel with FlowLayout and add the button to it
      JPanel buttonPanel2 = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
      buttonPanel2.setBackground(new Color(255, 255, 255, 0));
      buttonPanel2.add(addButton2);

      // Add the components to the game panel
      gamePanel2.add(gameLabel2);
      gamePanel2.add(priceLabel2);
      gamePanel2.add(buttonPanel2); // Add the button panel instead of the button

      
      addButton1.setHorizontalAlignment(AbstractButton.CENTER);
      addButton2.setHorizontalAlignment(AbstractButton.CENTER);

      // Add the game panels to the accordion panel
      accordionPanel.add(gamePanel1);
      accordionPanel.add(gamePanel2);

      // Add the accordion header and panel to the main window
      frame.add(accordionHeader, BorderLayout.NORTH);
      frame.add(accordionPanel, BorderLayout.CENTER);

      // Set the background color of the game panels
      gamePanel1.setBackground(new Color(0, 150, 200));
      gamePanel2.setBackground(new Color(0, 150, 200));

      // Show the window
      frame.setVisible(true);
   }
}
