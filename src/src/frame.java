import javax.swing.*;
import java.awt.*;

public class frame {
    public static void main(String[] args) {
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("Password Generator");
        window.setPreferredSize(new Dimension(900, 500));

        Settings settings = new Settings();
        window.add(settings);
        window.pack();

        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }
}
