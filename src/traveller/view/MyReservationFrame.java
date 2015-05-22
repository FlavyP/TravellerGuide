package traveller.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Window;
import java.awt.event.ActionListener;
import java.awt.event.WindowFocusListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;

public class MyReservationFrame extends JDialog implements View
{
   private GUITableModel tableModel;
   private JTable table;
   private String[] tableLabels;

   private JButton backButton;
   private JButton cancelResButton;

   private JPanel contentPanel;
   private JPanel buttonsPanel;

   private JScrollPane scrollPanel;

   private static MyReservationFrame instance = null;

   private MyReservationFrame(Window owner, ActionListener actionListener,
         WindowFocusListener focusListener)
   {
      super(owner, "My Reservations");
      createComponents();
      initializeComponents();
      addComponentsToFrame();
      addActionListeners(actionListener);
      addWindowFocusListener(focusListener);
      setVisible(true);
   }

   public static MyReservationFrame getInstance(Window owner,
         ActionListener actionListener, WindowFocusListener focusListener)
   {
      if (instance == null)
      {
         instance = new MyReservationFrame(owner, actionListener, focusListener);
         instance.setVisible(true);
      }
      return instance;
   }

   public void createComponents()
   {
      tableLabels = new String[] { "Id", "Name", "City", "Address", "sRooms",
            "dRooms", "tRooms","Apartments",
            "totalPrice" };
      this.tableModel = new GUITableModel(this.tableLabels, 0);
      this.table = new JTable(this.tableModel);
      this.table.setFillsViewportHeight(true);
      this.table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
      this.scrollPanel = new JScrollPane(this.table);
      
      contentPanel = new JPanel(new BorderLayout());
      buttonsPanel = new JPanel(new FlowLayout());

      this.backButton = new JButton("Back");
      this.cancelResButton = new JButton("Cancel Reservation");

      scrollPanel
            .setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
      scrollPanel
            .setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
      table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

   }

   @Override
   public void initializeComponents()
   {
      setSize(new Dimension(500, 500));
      setLocationRelativeTo(null); // center of the screen
      setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
      this.setName("MyReservationFrame");
   }

   @Override
   public void addComponentsToFrame()
   {
      this.setContentPane(contentPanel);
      buttonsPanel.add(backButton);
      buttonsPanel.add(cancelResButton);
      contentPanel.add(scrollPanel);
      contentPanel.add(buttonsPanel, BorderLayout.SOUTH);

   }

   @Override
   public void addActionListeners(ActionListener actionListener)
   {
      backButton.addActionListener(actionListener);
      cancelResButton.addActionListener(actionListener);

   }
   
   public void dispose() {
      instance = null;
      super.dispose();
   }

   @Override
   public String[] getInput() {
      String[] input = new String[1];
      input[0] = (String) this.tableModel.getValueAt(this.table.getSelectedRow(), 0);
      return input;
   }

   @Override
   public void update(String[] update)
   {
      // TODO Auto-generated method stub

   }

   @Override
   public void update(String[][] update) {
      this.tableModel = new GUITableModel(update, this.tableLabels);
      this.table.setModel(this.tableModel);
   }
}
