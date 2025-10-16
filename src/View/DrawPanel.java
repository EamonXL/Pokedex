package View;

import javax.swing.*;
import java.awt.*;
/**
 * The DrawPanel creates draws circles of a specified radius and color.
 *
 @author Eamon Challinor
 @version 0.1
 */
public class DrawPanel extends JPanel {
    /**
     * Radius of circle.
     */
    private final int radius;
    /**
     * Color of circle.
     */
    private final Color color;
    /**
     * Constructor for DrawPanel.
     *
     * @param radius circle radius.
     * @param color circle color.
     */
    public DrawPanel(int radius, Color color) {
        this.radius = radius;
        this.color = color;
        setOpaque(false);
        setPreferredSize(new Dimension(radius * 2 + 8, radius * 2 + 8));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        int cx = getWidth() / 2;
        int cy = getHeight() / 2;
        int diameter = radius * 2;

        g2.setColor(color);
        g2.fillOval(cx - radius, cy - radius, diameter, diameter);
    }
}