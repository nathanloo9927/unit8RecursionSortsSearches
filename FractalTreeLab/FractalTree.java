import java.awt.*;
import javax.swing.*;
import java.awt.geom.*;
public class FractalTree extends JPanel
{
   private final int PANEL_WIDTH = 750;
   private final int PANEL_HEIGHT = 750;
   
   private double angle = 48;
   private double scale = 0.6;
   
   private int current; //current order

   //-----------------------------------------------------------------
   //  Sets the initial fractal order to the value specified.
   //-----------------------------------------------------------------
   public FractalTree (int currentOrder)
   {
      current = currentOrder;
      setBackground (Color.black);
      setPreferredSize (new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
   }

   //-----------------------------------------------------------------
   //  Draws the fractal recursively. Base case is an order of 1 for
   //  which a simple straight line is drawn. Otherwise three
   //  intermediate points are computed, and each line segment is
   //  drawn as a fractal.
   //-----------------------------------------------------------------
   public void drawFractal (Graphics2D g2, double x, double y, double length, double angle, int order)
   {
      double angle1 = angle + this.angle;
      double angle2 = angle - this.angle;
      double angle3 = angle + 180;
      
      length *= scale;
      
      double endX1 = x - length * Math.sin(Math.toRadians(angle1));
      double endY1 = y - length * Math.cos(Math.toRadians(angle1));
      double endX2 = x - length * Math.sin(Math.toRadians(angle2));
      double endY2 = y - length * Math.cos(Math.toRadians(angle2));
      double endX3 = x - length * Math.sin(Math.toRadians(angle3));
      double endY3 = y - length * Math.cos(Math.toRadians(angle3));
      
      g2.draw(new Line2D.Double(x, y, endX1, endY1));
      g2.draw(new Line2D.Double(x, y, endX2, endY2));
      g2.draw(new Line2D.Double(x, y, endX3, endY3));
      if (order == 1) {g2.draw(new Line2D.Double(x, y, x, y - length));} else
      {
          drawFractal(g2, endX1, endY1, length, angle1, order - 1);
          drawFractal(g2, endX2, endY2, length, angle2, order - 1);
        }
      
   }

   //-----------------------------------------------------------------
   //  Performs the initial calls to the drawFractal method.
   //-----------------------------------------------------------------
   public void paintComponent (Graphics g)
   {
      super.paintComponent (g);
      Graphics2D g2 = (Graphics2D) g;
      g.setColor (Color.green);

      drawFractal (g2, 375.0, 400.0, 250.0, 0.0, 10);
   }

   //-----------------------------------------------------------------
   //  Sets the fractal order to the value specified.
   //-----------------------------------------------------------------
   public void setOrder (int order)
   {
      current = order;
   }

   //-----------------------------------------------------------------
   //  Returns the current order.
   //-----------------------------------------------------------------
   public int getOrder ()
   {
      return current;
   }
}
