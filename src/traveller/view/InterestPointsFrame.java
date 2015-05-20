package traveller.view;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.ActionListener;
import java.awt.event.WindowFocusListener;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.CaretListener;

public class InterestPointsFrame extends JFrame implements View {
   private JButton registerButton;
   private JButton logInButton;

   private JLabel userLabel;
   private JLabel passLabel;

   private JTextField userField;
   private JPasswordField passField;

   private JPanel contentPanel;
   private JPanel ipPanel;
   private JPanel buttonsPanel;
   
   private JComboBox<String> comboBox;
   private String[] ip = {"CAFE","MUSEUM","NIGHT_CLUB","RESTAURANT","SHOPPING_MALL"};
   private JLabel iplabel;
   private JButton getButton;

   private static InterestPointsFrame instance = null;

   public InterestPointsFrame(Window owner, ActionListener actionListener, WindowFocusListener focusListener) {
      super("Interest Points");
      createComponents();
      initializeComponents();
      addComponentsToFrame();
      addActionListeners(actionListener);
      addWindowFocusListener(focusListener);
      setVisible(true);
   }

// public static LogInFrame getInstance() {
//    return instance;
// }

   public static InterestPointsFrame getInstance(Window owner,
         ActionListener actionListener, WindowFocusListener focusListener) {
      if (instance == null) {
         instance = new InterestPointsFrame(owner, actionListener, focusListener);
         instance.setVisible(true);
      }
      return instance;
   }

   @Override
   public void createComponents() {
      
      iplabel = new JLabel("Type Of Interest Points: ");
      comboBox = new JComboBox<String>(ip);
      getButton = new JButton("GET");
      contentPanel = new JPanel(new BorderLayout());
      ipPanel = new JPanel(new FlowLayout());
      buttonsPanel = new JPanel(new FlowLayout());
   }

   @Override
   public void initializeComponents() {
      setSize(400, 200);
      setLocationRelativeTo(null); // center of the screen
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      this.setName("LogInFrame");
   }

   @Override
   public void addComponentsToFrame() {
      this.setContentPane(contentPanel);
      
      ipPanel.add(iplabel);
      ipPanel.add(comboBox);
      buttonsPanel.add(getButton);
      
      
      contentPanel.add(ipPanel, BorderLayout.NORTH);
      contentPanel.add(buttonsPanel, BorderLayout.SOUTH);
   }

   @Override
   public void addActionListeners(ActionListener actionListener) {
      
      getButton.addActionListener(actionListener);
      comboBox.addActionListener(actionListener);
      /*registerButton.addActionListener(actionListener);
      logInButton.addActionListener(actionListener);*/
   }
   
   

}