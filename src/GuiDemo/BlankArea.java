package GuiDemo;

import java.awt.Color;
import java.awt.Dimension;

/*
 * BlankArea.java is used by:
 *    MouseEventDemo.java.
 *    MouseMotionEventDemo.java
 */
import javax.swing.BorderFactory;
import javax.swing.JLabel;

public class BlankArea extends JLabel {
    Dimension minSize = new Dimension(100, 50);

    public BlankArea(Color color) {
        this.setBackground(color);
        this.setOpaque(true);
        this.setBorder(BorderFactory.createLineBorder(Color.black));
    }

    @Override
    public Dimension getMinimumSize() {
        return this.minSize;
    }

    @Override
    public Dimension getPreferredSize() {
        return this.minSize;
    }
}
