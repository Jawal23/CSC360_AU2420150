import javax.swing.*;
import java.awt.*;

public class SimpleShapes extends JPanel {

    public void paint(Graphics g) {
        g.setColor(Color.BLUE);
        g.drawRect(50, 50, 150, 150); // rectangle

    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Simple Shapes");
        frame.setSize(400, 400);
        frame.add(new SimpleShapes());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}