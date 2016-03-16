import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.awt.geom.*;
import java.awt.event.*;
public class FractalTree extends JPanel
{
    private double scale;
    private double limit;
    private double angle;
    public FractalTree(double scaling, double angledeg)
    {
        setBackground(Color.black);
        setPreferredSize(new Dimension(400, 400));
        scale = scaling;
        angle = Math.toRadians(angledeg);
    }
    public void drawFractal(Graphics2D g2, double x, double y, double length, double angle)
    {
        if (limit == 1)
        {
            
        } else
        {
            
        }
    }
}