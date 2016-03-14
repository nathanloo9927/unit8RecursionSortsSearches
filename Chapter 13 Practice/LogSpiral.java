import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Arc2D;
import java.awt.geom.Rectangle2D;
import javax.swing.JPanel;
import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.awt.geom.*;
import java.awt.event.*;
public class LogSpiral extends JFrame
{
    public LogSpiral()
    {
        this.setTitle("Fibonacci Spiral");
        this.setSize(500,500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    public static void main(String[] args)
    {
        LogSpiralViewer frame = new LogSpiralViewer();
    }
    public class LogSpiralPanel extends JPanel
    {
        private final double GOLDEN_MEAN = (1 + Math.sqrt(5)) / 2;
        private Rectangle2D.Double rect;

        public void paintComponent(Graphics g)
        {
            /* Your code goes here.
            1. Compute the dimensions of the goldenRectangle (you can use getHeight() 
            to obtain the side size)
            2. Draw the golden rectangle
            3. Call the recursive helper method "recursiveDraw" which will draw 
            the spiral.
             */
            Graphics2D g2 = (Graphics2D) g;
            rect = new Rectangle2D.Double(20.0, 20 * GOLDEN_MEAN, 0, 0);
            g2.draw(rect);
            recursiveDraw(g2, rect.getX(), rect.getY(), rect.getHeight(), 90);
        }

        /**
        Method that recursively draws a logarithmic spiral.
        @param x The x-coordinate of the golden rectangle's upper-left corner  
        @param y The y-coordinate of the golden rectangle's upper-left corner
        @param side the smallest side size of the golden rectangle
        @param angle the angle (0, 90, 180 or 270) where the top of the 
        golden rectangle is located. For the outermost golden rectangle, 
        the angle is 90.
         */
        private void recursiveDraw(Graphics2D g2, double x, double y, double side, int angle)
        {
            Rectangle2D.Double square = new Rectangle2D.Double(side, side, x, y);
            drawArc(g2, x, y, side, angle);
            double newSide = newSide();
            recursiveDraw(g2, calculateNewX(x, angle, side, newSide), calculateNewY(y, angle, side, newSide), newSide, newAngle(angle));
        }

        private void drawArc(Graphics2D g2, double x, double y, double side, int angle)
        {
            double auxX = x;
            double auxY = y;
            if (angle == 0 || angle == 270 )
            {
                auxX = x - side;
            }
            if (angle == 270 || angle == 180)
            {
                auxY = y - side;
            }
            g2.draw( new Arc2D.Double(auxX, auxY, side * 2, side * 2, angle, 90, Arc2D.OPEN));
        } 

        private double newSide()
        {
            return rect.getWidth() - rect.getHeight();
        }

        private int newAngle(int angle)
        {
            angle += 90;
            if (angle >= 360)
            {
                angle = 0;
            }
            return angle;
        }

        private double calculateNewX(double x, double angle, double side, double newSide)
        {
            if (angle == 0)
                x = x + side - newSide;
            else if (angle == 90)
                x = x + side;
            else if (angle == 270)
                x = x - newSide;
            return x;
        }

        private double calculateNewY(double y, double angle, double side, double newSide)
        {
            if (angle == 0)
                y = y + side;
            else if (angle == 180)
                y = y - newSide;
            else if (angle == 270)
                y = y + side - newSide;
            return y;
        }
    }
}
