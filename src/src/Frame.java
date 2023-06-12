import javax.swing.*;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;

public class Frame {

    public static void copyButtonPressed(String pw) {
        StringSelection str = new StringSelection(pw);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(str, null);

    }

    public static void main(String[] args) {
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("Password Generator");
        window.setMinimumSize(new Dimension(450, 100));

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
        JCheckBox options = new JCheckBox("Symbols");
        JTextField password = new JTextField();
        JButton copyButton = new JButton("Copy");
        password.setMaximumSize(new Dimension(300, 30));

        // Edits
        slider.setMaximumSize(new Dimension(300, 30));
        slider.setMajorTickSpacing(4);
        slider.setMinorTickSpacing(1);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        copyButton.addActionListener(e -> copyButtonPressed(password.getText()));
        options.setPreferredSize(new Dimension(100, 20));

        layout.setHorizontalGroup(
                layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(slider)
                                .addComponent(password)
                        )
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(options)
                                .addComponent(copyButton)
                        )

        );

        layout.setVerticalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createParallelGroup()
                                .addComponent(slider)
                        )
                                .addComponent(options)
                        )
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addComponent(password)
                        .addComponent(copyButton)
                ));
        layout.setAutoCreateContainerGaps(true);
        layout.setAutoCreateGaps(true);
        window.pack();

        ChangeListener a = e -> {
            int length = slider.getValue();
            boolean symbs = options.isSelected();
            password.setText(Generator.generate(length, symbs));
        };
        slider.addChangeListener(a);

    }
}
