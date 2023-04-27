package experiment;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class RoundedToggleButton extends JToggleButton {

    public RoundedToggleButton(String text) {
        super(text);

        // Set the font and color
        setFont(new Font("Arial", Font.BOLD, 15));
        setForeground(Color.BLACK);

        // Set the background color
        // setBackground(new Color(60, 60, 60));

        // Set the border
        Border roundedBorder = BorderFactory.createEmptyBorder(0, 0, 0, 0);
        Border compoundBorder = BorderFactory.createCompoundBorder(
                new RoundedBorder(10),
                roundedBorder
        );
        setBorder(compoundBorder);
    }

    private static class RoundedBorder implements Border {
        private int radius;

        public RoundedBorder(int radius) {
            this.radius = radius;
        }

        public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setColor(Color.WHITE);
            g2.drawRoundRect(x, y, width - 1, height - 1, radius, radius);
            g2.dispose();
        }

        public Insets getBorderInsets(Component c) {
            return new Insets(this.radius, this.radius, this.radius, this.radius);
        }

        public boolean isBorderOpaque() {
            return false;
        }
    }
}
