import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TreeViewer
{
    private final int WIDTH = 750;
    private final int HEIGHT = 750;

    private FractalTree drawing;
    private JPanel panel;
    private JFrame frame;

    //-----------------------------------------------------------------
    //  Sets up the components for the applet.
    //-----------------------------------------------------------------
    public static void main(String[] args)
    {
        TreeViewer viewer = new TreeViewer();
    }

    public TreeViewer()
    {
        drawing = new FractalTree (1);

        panel = new JPanel();
        panel.add (drawing);

        frame = new JFrame();
        frame.setTitle("Fractal Tree");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(WIDTH, HEIGHT);
        frame.add(panel);
        frame.setVisible(true);
        
        frame.repaint();
    }
}
