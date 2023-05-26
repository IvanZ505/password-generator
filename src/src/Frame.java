import javax.swing.*;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class Frame {
    public static void main(String[] args) {
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("Password Generator");
        window.setPreferredSize(new Dimension(450, 600));

        JPanel panel = new JPanel();
        window.add(panel);
        window.pack();
        GroupLayout layout = new GroupLayout(panel);
        panel.setLayout(layout);



        window.setLocationRelativeTo(null);
        window.setVisible(true);

        Font myFont = new Font("Roboto", Font.PLAIN, 12);
        window.setFont(myFont);
        window.setFocusable(true);

        // Defining components
        JSlider slider = new JSlider(SwingConstants.HORIZONTAL, 8, 24, 8);
        JLabel sliderval = new JLabel("8");
        JTextField password = new JTextField();
        password.setMaximumSize(new Dimension(window.getWidth(), 50));

        // Edits
        slider.setPreferredSize(new Dimension(200, 30));

        layout.setHorizontalGroup(
                layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(slider)
                                .addComponent(password)
                        )
                        .addComponent(sliderval)

        );

        layout.setVerticalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addComponent(slider)
                        .addComponent(sliderval))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addComponent(password)
                ));
        layout.setAutoCreateContainerGaps(true);
        layout.setAutoCreateGaps(true);
        window.pack();

        ChangeListener a = e -> {
            int length = slider.getValue();
            sliderval.setText(String.valueOf(length));
            password.setText(Generator.generate(length, true));
        };
        slider.addChangeListener(a);

    }
}
