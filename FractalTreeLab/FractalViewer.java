import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.awt.geom.*;
import java.awt.event.*;
public class FractalViewer
{
    private JFrame frame;
    private JPanel panel;
    private FractalTree drawing;
    public static void main(String[] args)
    {
        FractalViewer fractal = new FractalViewer();
    }
    public FractalViewer()
    {
        drawing = new FractalTree(.85, 25.0);
        panel = new JPanel();
        panel.add(drawing);
        
        frame = new JFrame();
        frame.setTitle("Fractal Tree");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 500);
        frame.add(panel);
        frame.setVisible(true);
    }
}
