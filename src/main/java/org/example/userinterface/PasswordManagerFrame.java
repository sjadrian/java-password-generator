package org.example.userinterface;

import org.example.password.PasswordFactory;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.text.NumberFormatter;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PasswordManagerFrame extends JFrame {

    private JPanel mainPanel;
    private JButton generateButton;
    private JTextField textField;
    private JCheckBox upperCase;
    private JCheckBox lowerCase;
    private JCheckBox number;
    private JLabel heading;
    private JLabel passwordQuality;
    private JLabel entropy;
    private JSpinner spinner;
    private JSlider slider;
    private JLabel lengthLabel;
    private JProgressBar progressBar;
    private JButton copyButton;
    private JCheckBox symbol;

    PasswordFactory passwordFactory;

    public PasswordManagerFrame() {

        passwordFactory = new PasswordFactory();

        this.setContentPane(mainPanel);
        this.setTitle("Password Generator");
        this.setSize(680, 250);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        generateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                passwordFactory.setCondition(upperCase.isSelected(), lowerCase.isSelected(), number.isSelected(), symbol.isSelected(), slider.getValue());

                passwordFactory.generatePassword();
                String password = passwordFactory.getPassword();

                textField.setText(password);
                passwordQuality.setText("Password Quality: " + passwordFactory.getPasswordQuality());
                entropy.setText("Entropy: " + passwordFactory.getPasswordStrength() +" bit");
                progressBar.setValue((int) passwordFactory.getPasswordStrength());
            }
        });

        // checked all for default
        upperCase.setSelected(true);
        lowerCase.setSelected(true);
        number.setSelected(true);

        final JCheckBox[] boxes = new JCheckBox[3];
        boxes[0] = upperCase;
        boxes[1] = lowerCase;
        boxes[2] = number;

        ActionListener checkBoxListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean oneCheckBoxesChecked = false;

                for (int i = 0; i < 3; i++) {
                    if (boxes[i].isSelected()) {oneCheckBoxesChecked = true;}
                }
                generateButton.setEnabled(oneCheckBoxesChecked);
            }
        };

        for (int i = 0; i < 3; i++) {
            boxes[i].addActionListener(checkBoxListener);
        }

        // Spinner setting
        // from stack overflow
        JFormattedTextField txt = ((JSpinner.NumberEditor) spinner.getEditor()).getTextField();
        ((NumberFormatter) txt.getFormatter()).setAllowsInvalid(false);

        spinner.addChangeListener(new ChangeListener() {

            @Override
            public void stateChanged(ChangeEvent e) {
                slider.setValue((Integer) spinner.getValue());
            }
        });

        // Slider setting
        slider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                spinner.setValue(slider.getValue());
            }
        });

        copyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                // Source: https://stackoverflow.com/a/6713290/20468361
                String myString = textField.getText();
                StringSelection stringSelection = new StringSelection(myString);
                Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
                clipboard.setContents(stringSelection, null);
            }
        });

        progressBar.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {

                if (progressBar.getValue() >= 100) {
                    progressBar.setForeground(new Color(0x49be25));
                } else if (progressBar.getValue() >= 75) {
                    progressBar.setForeground(new Color(0x549A56));
                } else if (progressBar.getValue() >= 45) {
                    progressBar.setForeground(new Color(0xF1A30B));
                } else {
                    progressBar.setForeground(new Color(0xB73535));
                }
            }
        });
    }

    private void createUIComponents() {
        SpinnerNumberModel sm = new SpinnerNumberModel(15, 1, 120, 1);
        spinner = new JSpinner(sm);

        slider = new JSlider(1,120,15);
        progressBar = new JProgressBar(0, 200);
    }
}
