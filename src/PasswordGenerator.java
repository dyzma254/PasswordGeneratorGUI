import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.JColorChooser;


public class PasswordGenerator extends JFrame{
    private JPanel mainWindow;
    private JLabel titleLabel;
    private JTextField passwordField;
    private JButton generujbtn;
    private JCheckBox wielkie_check;
    private JCheckBox cyfry_check;
    private JTextField ile_cyfr;
    private JLabel MinLabel;
    private JButton color;

    private int ile;
    private static final String LOWER = "abcdefghijklmnopqrstuvwxyz";
    private static final String UPPER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String SPECIAL = "0123456789!@#$%&*()_+-=[]|,./?><";

    private boolean useUPPER;
    private boolean useSPECIAL;
    public int getIle() {
        return ile;
    }

    public void setIle(int ile) {
        this.ile = ile;
    }

    public PasswordGenerator(String title){
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainWindow);
        this.pack();


        generujbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                useSPECIAL=cyfry_check.isSelected();
                useUPPER = wielkie_check.isSelected();
                StringBuilder password = new StringBuilder(8);
                Random random = new Random(System.nanoTime());
                // Build the password.
                List<String> charCategories = new ArrayList<>(4);
                charCategories.add(LOWER);

                if (useUPPER) {
                    charCategories.add(UPPER);
                }
                if (useSPECIAL) {
                    charCategories.add(SPECIAL);
                }
                else{
                    charCategories.add(LOWER);
                }
                setIle(Integer.valueOf(ile_cyfr.getText()));
                int dlugosc = getIle();

                for (int i = 0; i < dlugosc; i++) {
                    String charCategory = charCategories.get(random.nextInt(charCategories.size()));
                    int position = random.nextInt(charCategory.length());
                    password.append(charCategory.charAt(position));
                }

                String haslo = password.toString();
                if(haslo.matches(".*[ABCDEFGHIJKLMNOPQRSTUWYZ].*") && useUPPER) {
                    passwordField.setText(haslo);
                }
                if(haslo.matches(".*[0123456789!@#$%&*()_+=|,./?><].*") && useSPECIAL) {
                    passwordField.setText(haslo);
                }
                else if(!useUPPER && !useSPECIAL) { passwordField.setText(haslo);}


            }
        });
        ile_cyfr.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c)){
                    e.consume();
                }

            }
        });
        color.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color newColor = JColorChooser.showDialog(null, "Choose a color", Color.RED);
                mainWindow.setBackground(newColor);
            }
        });
    }
    public static void main(String[] args){
        JFrame frame = new PasswordGenerator("Password Generator");
        frame.setVisible(true);



    }


}
