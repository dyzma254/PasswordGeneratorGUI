import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Rejestracja {
    private JTextField nameField;
    private JLabel nameLabel;
    private JTextField passwordField;
    private JLabel passwordLabel;
    private JButton registerButton;
    private JLabel generatorLabel;

    public Rejestracja(String title) {


    }


    public static void main(String[] args){
        JFrame frame = new JFrame("Rejestracja");
        frame.setVisible(true);
    }
}
