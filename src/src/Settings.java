import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class Settings extends JPanel {
    public  Settings() {
        Font myFont = new Font("Roboto", Font.PLAIN, 12);
        this.setFont(myFont);
        this.setFocusable(true);

        // Defining components
        JPanel sliderPanel = new JPanel();
        GroupLayout sliderLayout = new GroupLayout(sliderPanel);
        JSlider slider = new JSlider(SwingConstants.HORIZONTAL, 8, 24, 8);
        JLabel sliderval = new JLabel("8");


        sliderLayout.setAutoCreateGaps(true);
        sliderLayout.setAutoCreateContainerGaps(true);
        sliderLayout.setHorizontalGroup(
                sliderLayout.createSequentialGroup()
                        .addComponent(slider)
                        .addComponent(sliderval)
                );

        // Edits
        slider.setPreferredSize(new Dimension(200, 30));



        JPanel passwordPanel = new JPanel();
        GroupLayout passwordLayout = new GroupLayout(passwordPanel);
        JLabel password = new JLabel();
        JButton btn = new JButton("YAY");

        passwordLayout.setAutoCreateGaps(true);
        passwordLayout.setAutoCreateContainerGaps(true);
        passwordLayout.setVerticalGroup(
                passwordLayout.createSequentialGroup()
                        .addComponent(btn)
                        .addComponent(password)
        );

        this.add(sliderPanel);
        this.add(passwordPanel);
        ChangeListener a = e -> {
            int length = slider.getValue();
            sliderval.setText(String.valueOf(length));
            password.setText(Generator.generate(length, true));
        };
        slider.addChangeListener(a);
    }
}
