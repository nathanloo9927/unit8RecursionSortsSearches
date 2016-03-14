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
public class LogSpiralViewer extends JFrame
{
    public LogSpiralViewer()
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
}
