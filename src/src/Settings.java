import javax.swing.*;
import java.awt.*;

public class Settings extends JPanel {
    public Settings() {
        Font myFont = new Font("Roboto", Font.PLAIN, 12);
        this.setFont(myFont);
        this.setFocusable(true);
        JSlider slider = new JSlider();
        slider.setPreferredSize(new Dimension(500, 20));
        this.add(slider);
    }
}
