package traveller.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Window;
import java.awt.event.ActionListener;
import java.awt.event.WindowFocusListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

public class DirectionsFrame extends JDialog implements TravellerView
{
   private JPanel contentPanel;
   
   private JButton backButton;
   
   private JTextArea textArea;
   
   private JScrollPane scrollPane;
   
   private static DirectionsFrame instance = null;
   
   private DirectionsFrame(Window owner, ActionListener actionListener,
         WindowFocusListener focusListener) {
      super(owner, "Directions");
      createComponents();
      initializeComponents();
      addComponentsToFrame();
      addActionListeners(actionListener);
      addWindowFocusListener(focusListener);
      setVisible(true);
   }
   
   public static DirectionsFrame getInstance(Window owner,
         ActionListener actionListener, WindowFocusListener focusListener) {
      if (instance == null) {
         instance = new DirectionsFrame(owner, actionListener,
               focusListener);
         instance.setVisible(true);
      }
      return instance;
   }

   @Override
   public void createComponents()
   {
      contentPanel = new JPanel(new BorderLayout());
      backButton = new JButton("Back");
      textArea = new JTextArea();
      textArea.setEditable(false);
      scrollPane = new JScrollPane(textArea);
      scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
      scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
   }

   @Override
   public void initializeComponents()
   {
      setSize(new Dimension(500, 500));
      setLocationRelativeTo(null); // center of the screen
      setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
      setResizable(false);
      this.setName("DirectionsFrame");
      
   }

   @Override
   public void addComponentsToFrame()
   {this.setContentPane(contentPanel);
      contentPanel.add(scrollPane, BorderLayout.CENTER);
      contentPanel.add(backButton, BorderLayout.SOUTH);
   }

   @Override
   public void addActionListeners(ActionListener actionListener)
   {
      backButton.addActionListener(actionListener);
      
   }
   
   public void dispose() {
      instance = null;
      super.dispose();
   }

   @Override
   public String[] getInput()
   {
      // TODO Auto-generated method stub
      return null;
   }

   @Override
   public void update(String[] update)
   {
	   textArea.setText(update[0]);
   }

   @Override
   public void update(String[][] update)
   {
      // TODO Auto-generated method stub
      
   }
}
