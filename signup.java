
import java.awt.Color;
import java.awt.Font;
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.plaf.FontUIResource;

public class signup extends JFrame implements ActionListener {
    JPanel panel, rightPanel;
    ImageIcon imageicon;
    public JButton Loginbutton;
    JTextField loginfield;
    JPasswordField passwordField, Re_passwordField;
    JButton backbutton, signupbutton, back;
    JComboBox Role_combobox;
    String adminid = "admin", sellerid = "seller", customerid = "customer";
    String adminpass = "admin", sellerpass = "seller", customerpass = "customer";

    signup() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(900, 600);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setTitle("Mart Managment System");

        panel = new JPanel();
        rightPanel = new JPanel(); // RIGHT PANEL
        rightPanel.setLayout(null);
        rightPanel.setBounds(450, 0, 450, 600);
        rightPanel.setBackground(Color.GRAY);
        imageicon = new ImageIcon("SC2.png");
        // this.setIconImage(imageicon.getImage());
        panel.setLayout(null);
        JLabel welcomeLabel = new JLabel("WELCOME TO");
        JLabel label = new JLabel("   EZ MART");
        label.setIcon(imageicon);

        welcomeLabel.setBounds(0, 130, 400, 100);
        label.setBounds(50, 200, 350, 230);

        welcomeLabel.setAlignmentX(JLabel.CENTER);
        // label.setSize(50, 30);
        // label.setBackground(Color.BLACK);
        label.setForeground(Color.white);
        welcomeLabel.setForeground(Color.white);

        label.setFont(new FontUIResource("MV Boli", Font.ITALIC, 30));
        welcomeLabel.setFont(new FontUIResource("Playfair", Font.ITALIC, 30));
        welcomeLabel.setHorizontalTextPosition(JLabel.CENTER);
        welcomeLabel.setVerticalTextPosition(JLabel.TOP);

        label.setHorizontalTextPosition(JLabel.CENTER);
        label.setVerticalTextPosition(JLabel.BOTTOM);
        label.setHorizontalAlignment(JLabel.CENTER);
        welcomeLabel.setHorizontalAlignment(JLabel.CENTER);
        // // label.setBackground(Color.BLACK);
        // label.setOpaque(true);
        // // welcomeLabel.setBackground(Color.BLACK);
        // welcomeLabel.setOpaque(true);

        // label.setHorizontalTextPosition(JLabel.CENTER);
        // label.setVerticalTextPosition(JLabel.CENTER);

        label.setVerticalAlignment(JLabel.CENTER);
        label.setHorizontalAlignment(JLabel.LEFT);

        // setup for login--------------------------------

        JLabel loginlabel = new JLabel("Username ");
        loginlabel.setBounds(100, 120, 300, 300);
        loginlabel.setFont(new FontUIResource("Serif", Font.PLAIN, 16));
        loginlabel.setForeground(Color.black);

        loginfield = new JTextField("User");
        loginfield.setForeground(Color.white);
        loginfield.setBounds(200, 250, 150, 40);
        loginfield.setBackground(Color.BLACK);

        JLabel passwordlLabel = new JLabel("Password ");
        passwordlLabel.setBounds(100, 173, 300, 300);
        passwordlLabel.setFont(new FontUIResource("Serif", Font.PLAIN, 16));
        loginlabel.setForeground(Color.black);

        JLabel re_passwordlLabel = new JLabel("Password ");
        re_passwordlLabel.setBounds(100, 226, 300, 300);
        re_passwordlLabel.setFont(new FontUIResource("Serif", Font.PLAIN, 16));
        loginlabel.setForeground(Color.black);

        passwordField = new JPasswordField("done");
        passwordField.setEchoChar(('*'));
        passwordField.setForeground(Color.white);
        passwordField.setBounds(200, 300, 150, 40);
        passwordField.setBackground(Color.BLACK);

        Re_passwordField = new JPasswordField("nope");
        Re_passwordField.setEchoChar(('*'));
        Re_passwordField.setForeground(Color.white);
        Re_passwordField.setBounds(200, 350, 150, 40);
        Re_passwordField.setBackground(Color.BLACK);

        // Loginbutton = new JButton("Login");
        // Loginbutton.addActionListener(this);
        // Loginbutton.setBounds(100, 410, 100, 30);

        signupbutton = new JButton("Signup");
        signupbutton.addActionListener(this);
        signupbutton.setBounds(200, 410, 100, 30);

        back = new JButton();
        back.addActionListener(this);
        back.setBounds(0, 5, 35, 35);
        ImageIcon backimg = new ImageIcon("backimage.png");
        Image bgimg = backimg.getImage();
        Image newimg = bgimg.getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH);
        backimg = new ImageIcon(newimg);
        back.setIcon(backimg);

        // loginfield.setPreferredSize(new DimensionUIResource(150, 40));

        // passwordlLabel.setFont(new FontUIResource("MV Boli", Font.PLAIN, 20));

        JPasswordField passwordfield = new JPasswordField();
        passwordfield.setEchoChar('*');

        ImageIcon loginimage = new ImageIcon("signupimage.png");
        JLabel loginiconlabel = new JLabel();
        loginiconlabel.setBounds(125, 35, 200, 200);
        loginiconlabel.setIcon(loginimage);

        // passwordfield.setPreferredSize(new DimensionUIResource(150, 40));

        // JLabel Loginheading = new JLabel("LOGIN ");

        // Loginheading.setFont(new FontUIResource("Playfair", Font.BOLD, 20));
        // Loginheading.setPreferredSize(new DimensionUIResource(100, 40));

        // rightPanel.add(Loginheading);
        panel.add(back);
        rightPanel.add(re_passwordlLabel);
        rightPanel.add(Re_passwordField);
        rightPanel.add(signupbutton);
        // rightPanel.add(roleLabel);
        // rightPanel.add(Role_combobox);
        rightPanel.add(loginiconlabel);
        rightPanel.add(passwordlLabel);
        rightPanel.add(passwordField);
        rightPanel.add(loginlabel);
        rightPanel.add(loginfield);
        // rightPanel.add(Loginbutton);
        // rightPanel.add(backbutton);
        rightPanel.add(passwordfield);
        panel.setBounds(0, 0, 450, 600);
        panel.setBackground(Color.BLACK);
        // panel.setLayout(null);
        this.add(rightPanel);
        panel.add(label);
        panel.add(welcomeLabel);
        this.add(panel);
        this.setVisible(true);
    }
    // Actions=======================================================

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == back) {
            new Myframe();
            this.dispose();

        } else if (e.getSource() == signupbutton) {
            char[] y = passwordField.getPassword();
            String a = String.valueOf(y);
            char[] z = Re_passwordField.getPassword();
            String b = String.valueOf(z);
            checkSignup(loginfield.getText(), a, b);
        }

    }

    credentials c1 = new credentials();

    public void checkSignup(String x, String y, String z) {
        if ((x != "") && (y.equals(z))) {

            c1.writefile(x, y, z);
            JOptionPane.showMessageDialog(null, "Sign up Successfull", "User Registered", JOptionPane.PLAIN_MESSAGE);
            new Myframe();
            this.dispose();
        } else if (y.equalsIgnoreCase(x) == false) {
            JOptionPane.showMessageDialog(null, "Sign up Failed. Passwords Doesn't Match.", "Registeration Failed !",
                    JOptionPane.ERROR_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Sign up Failed. Please try again", "Registeration Failed !",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    // public void SignUpWork() {
    // rightPanel = new JPanel(); // RIGHT PANEL
    // rightPanel.setLayout(null);
    // rightPanel.setBounds(450, 0, 450, 600);
    // rightPanel.setBackground(Color.GREEN);
    // this.add(rightPanel);

    // System.out.println("YESSSS");
    // }
}
