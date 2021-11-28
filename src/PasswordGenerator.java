import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PasswordGenerator extends JFrame{
    private JPanel mainWindow;
    private JLabel titleLabel;
    private JTextField passwordField;
    private JButton generujbtn;
    private JCheckBox wielkie_check;
    private JCheckBox ukryj_check;
    private JCheckBox cyfry_check;
    private static final String LOWER = "abcdefghijklmnopqrstuvwxyz";
    private static final String UPPER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String SPECIAL = "0123456789!@#$%&*()_+-=[]|,./?><";

    private boolean useUPPER;
    private boolean useSPECIAL;





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

                if (useUPPER) {
                    charCategories.add(UPPER);
                }
                if (useSPECIAL) {
                    charCategories.add(SPECIAL);
                }
                else{
                    charCategories.add(LOWER);
                }
                for (int i = 0; i < 8; i++) {
                    String charCategory = charCategories.get(random.nextInt(charCategories.size()));
                    int position = random.nextInt(charCategory.length());
                    password.append(charCategory.charAt(position));
                }
                passwordField.setText(password.toString());
            }
        });
    }
    public static void main(String[] args){
        JFrame frame = new PasswordGenerator("Password Generator");
        frame.setVisible(true);
    }


}
