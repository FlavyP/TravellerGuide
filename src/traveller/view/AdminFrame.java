package traveller.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Window;
import java.awt.event.ActionListener;
import java.awt.event.WindowFocusListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class AdminFrame extends JDialog implements TravellerView
{

   private JButton addButton;
   private JButton editButton;
   private JButton logOutButton;
   private JPanel panel;

   private static AdminFrame instance = null;

   private AdminFrame(Window owner, ActionListener actionListener,
         WindowFocusListener focusListener)
   {
      super(owner, "Admin");
      createComponents();
      initializeComponents();
      addComponentsToFrame();
      addActionListeners(actionListener);
      addWindowFocusListener(focusListener);
      setVisible(true);
   }

   public static AdminFrame getInstance(Window owner,
         ActionListener actionListener, WindowFocusListener focusListener)
   {
      if (instance == null)
      {
         instance = new AdminFrame(owner, actionListener, focusListener);
         instance.setVisible(true);
      }
      return instance;
   }

   @Override
   public void createComponents()
   {
      addButton = new JButton("Add Hotel");
      editButton = new JButton("Edit Hotel");
      logOutButton = new JButton("Log Out");
      panel = new JPanel(new GridLayout(3, 1));
      addButton.setFont(new Font("serif", Font.PLAIN, 24));
      editButton.setFont(new Font("serif", Font.PLAIN, 24));
      logOutButton.setFont(new Font("serif", Font.PLAIN, 24));

   }

   @Override
   public void initializeComponents()
   {
      setSize(new Dimension(500, 500));
      setLocationRelativeTo(null); // center of the screen
      setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
      setResizable(false);
      this.setName("AdminFrame");
   }

   @Override
   public void addComponentsToFrame()
   {
      panel.add(addButton);
      panel.add(editButton);
      panel.add(logOutButton);
      this.setContentPane(panel);
   }

   @Override
   public void addActionListeners(ActionListener actionListener)
   {
      addButton.addActionListener(actionListener);
      editButton.addActionListener(actionListener);
      logOutButton.addActionListener(actionListener);
   }

   @Override
   public String[] getInput()
   {
      // TODO Auto-generated method stub
      return null;
   }

   public void dispose()
   {
      instance = null;
      super.dispose();
   }

   @Override
   public void update(String[] update)
   {
      // TODO Auto-generated method stub

   }

   @Override
   public void update(String[][] update)
   {
      // TODO Auto-generated method stub

   }
}
