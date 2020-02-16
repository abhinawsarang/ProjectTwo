import javax.swing.*;
import java.awt.*;

/**
 * @author Aravind Thillai Villalan
 * @author Karandeep Singh Grewal
 * @since 01-29-2020
 */

public class BarRight extends JPanel {

    public void paintComponent(Graphics tempGraphics) {
        final Color GREEN = new Color(255, 255, 255, 240);
        tempGraphics.setColor(GREEN);
        tempGraphics.fillRect(0 , 0, 10,60);
//        this.setSize(100,100);
        this.setBounds(70,20,10,60);
    }
}