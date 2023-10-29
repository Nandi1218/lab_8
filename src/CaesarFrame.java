import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.*;

public class CaesarFrame extends JFrame {
    private boolean select = false;
    private JTextField jTextFieldUp = new JTextField(20);
    private JTextField jTextFieldDown = new JTextField(20);
    private JButton jButton = new JButton("Code!");
    private JComboBox<Object> jComboBox;

    CaesarFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("SwingLab");
        setSize(400, 110);
        setResizable(true);

        setLayout(new GridLayout(2, 1));
        JPanel up = new JPanel(new GridLayout(1, 3));
        JPanel down = new JPanel(new GridLayout(1, 2));
        add(up);
        add(down);

        FocusListener focusListener = new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                select = true;
            }

            @Override
            public void focusLost(FocusEvent e) {
                select = false;
            }
        };

        jTextFieldUp.addFocusListener(focusListener);
        DocumentListener documentListener = new DocumentListener() {

            @Override
            public void insertUpdate(DocumentEvent e) {
                if (select)
                    jTextFieldDown.setText(Main.caesarCode(jTextFieldUp.getText(), (Character) jComboBox.getSelectedItem()));
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                if (select)
                    jTextFieldDown.setText(Main.caesarCode(jTextFieldUp.getText(), (Character) jComboBox.getSelectedItem()));
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                if (select)
                    jTextFieldDown.setText(Main.caesarCode(jTextFieldUp.getText(), (Character) jComboBox.getSelectedItem()));
            }
        };
        DocumentListener dDocumentListener = new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                if (!select)
                    jTextFieldUp.setText(Main.dEcaesarCode(jTextFieldDown.getText(), (Character) jComboBox.getSelectedItem()));
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                if (!select)
                    jTextFieldUp.setText(Main.dEcaesarCode(jTextFieldDown.getText(), (Character) jComboBox.getSelectedItem()));
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                if (!select)
                    jTextFieldUp.setText(Main.dEcaesarCode(jTextFieldDown.getText(), (Character) jComboBox.getSelectedItem()));
            }
        };
        jTextFieldUp.getDocument().addDocumentListener(documentListener);
        jTextFieldDown.getDocument().addDocumentListener(dDocumentListener);
        Object[] obj = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
        jComboBox = new JComboBox<Object>(obj);
        jButton.addActionListener(new OkButtonActionListener());
        up.add(jComboBox);
        up.add(jTextFieldUp);
        up.add(jButton);
        down.add(new JLabel("Output"));
        down.add(jTextFieldDown);

        setVisible(true);
    }

    private class OkButtonActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            jTextFieldDown.setText(Main.caesarCode(jTextFieldUp.getText(), (Character) jComboBox.getSelectedItem()));
        }
    }
}
