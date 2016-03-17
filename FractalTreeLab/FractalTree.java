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
        limit = 0;
        scale = scaling;
        angle = Math.toRadians(angledeg);
    }
    public void drawFractal(Graphics2D g2, double x, double y, double length, double angle)
    {
        double angle1 = angle + this.angle;
        double angle2 = angle - this.angle;
        int endX1, endY1, endX2, endY2;
        length *= scale;
        if (limit == 9)
        {
            return;
        } else
        {
            endX1 = (int)(x - length*Math.sin(angle1));
            endY1 = (int)(y - length*Math.cos(angle1));
            endX2 = (int)(x + length*Math.sin(angle2));
            endY2 = (int)(y + length*Math.cos(angle2));
            
            Line2D.Double line1 = new Line2D.Double(x, y, endX1, endY1);
            Line2D.Double line2 = new Line2D.Double(x, y, endX2, endY2);
            g2.draw(line1);
            g2.draw(line2);
            
            limit++;
            drawFractal(g2, endX1, endY1, length, angle);
            repaint();
        }
    }
    public void paintComponent (Graphics g)
    {
        Graphics2D g2 = (Graphics2D) g;
        super.paintComponent(g2);
        g2.setColor(Color.green);
        drawFractal(g2, 200, 300, 100, 0);
    }
}