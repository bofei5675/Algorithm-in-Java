package GuiDemo;

import java.awt.Color;
import java.awt.Dimension;

/*
* MouseEventDemo.java
*/

import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class MouseEventDemo extends JPanel implements MouseListener {
    BlankArea blankArea;
    JTextArea textArea;
    static final String NEWLINE = System.getProperty("line.separator");

    public static void main(String[] args) {
        /* Use an appropriate Look and Feel */
        try {
            //UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            //UIManager.setLookAndFeel("com.sun.java.swing.plaf.gtk.GTKLookAndFeel");
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
        } catch (UnsupportedLookAndFeelException ex) {
            ex.printStackTrace();
        } catch (IllegalAccessException ex) {
            ex.printStackTrace();
        } catch (InstantiationException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        /* Turn off metal's use of bold fonts */
        UIManager.put("swing.boldMetal", Boolean.FALSE);
        //Schedule a job for the event dispatch thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                createAndShowGUI();
            }
        });
    }

    /**
     * Create the GUI and show it. For thread safety, this method should be
     * invoked from the event dispatch thread.
     */
    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("MouseEventDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Create and set up the content pane.
        JComponent newContentPane = new MouseEventDemo();
        newContentPane.setOpaque(true); //content panes must be opaque
        frame.setContentPane(newContentPane);

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }

    public MouseEventDemo() {
        super(new GridLayout(0, 1));
        this.blankArea = new BlankArea(Color.YELLOW);
        this.add(this.blankArea);
        this.textArea = new JTextArea();
        this.textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(this.textArea);
        scrollPane.setVerticalScrollBarPolicy(
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setPreferredSize(new Dimension(200, 75));
        this.add(scrollPane);

        //Register for mouse events on blankArea and the panel.
        this.blankArea.addMouseListener(this);
        this.addMouseListener(this);
        this.setPreferredSize(new Dimension(450, 450));
        this.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    }

    void eventOutput(String eventDescription, MouseEvent e) {
        this.textArea.append(eventDescription + " detected on "
                + e.getComponent().getClass().getName() + "." + NEWLINE);
        this.textArea.setCaretPosition(this.textArea.getDocument().getLength());
    }

    @Override
    public void mousePressed(MouseEvent e) {
        this.eventOutput(
                "Mouse pressed (# of clicks: " + e.getClickCount() + ")", e);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        this.eventOutput(
                "Mouse released (# of clicks: " + e.getClickCount() + ")", e);
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        this.eventOutput("Mouse entered", e);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        this.eventOutput("Mouse exited", e);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        this.eventOutput(
                "Mouse clicked (# of clicks: " + e.getClickCount() + ")", e);
    }
}
