package traveller.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Window;
import java.awt.event.ActionListener;
import java.awt.event.WindowFocusListener;
import java.util.Properties;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import traveller.model.MyDate;

public class ReserveFrame extends JDialog implements TravellerView {
   private static ReserveFrame instance = null;
   private JLabel checkInLabel;
   private JLabel checkOutLabel;
   private JLabel sRnLabel;
   private JLabel dRnLabel;
   private JLabel tRnLabel;
   private JLabel anLabel;
   private JLabel totalPriceLabel;

   private JTextField sRnField;
   private JTextField dRnField;
   private JTextField tRnField;
   private JTextField anField;
   private JTextArea totalPriceArea;

   private JPanel infoPanel;
   private JPanel contentPanel;
   private JPanel buttonsPanel;

   private JButton reserveButton;
   private JButton totalPriceButton;
   private JButton cancelButton;
   
   private UtilDateModel model;
   private UtilDateModel model2;
   private Properties p;
   private JDatePanelImpl datePanel;
   private JDatePickerImpl datePicker;
   private JDatePanelImpl datePanel2;
   private JDatePickerImpl datePicker2;

   private ReserveFrame(Window owner, ActionListener actionListener,
         WindowFocusListener focusListener) {
      super(owner, "Reserve");
      createComponents();
      initializeComponents();
      addComponentsToFrame();
      addActionListeners(actionListener);
      addWindowFocusListener(focusListener);
      setVisible(true);
   }

   public static ReserveFrame getInstance(Window owner,
         ActionListener actionListener, WindowFocusListener focusListener) {
      if (instance == null) {
         instance = new ReserveFrame(owner, actionListener, focusListener);
         instance.setVisible(true);
      }
      return instance;
   }

   public void dispose() {
      instance = null;
      super.dispose();
   }

   @Override
   public void createComponents() {
      checkInLabel = new JLabel("Chech in date: ");
      checkOutLabel = new JLabel("Check out date: ");
      sRnLabel = new JLabel("Number of single rooms: ");
      dRnLabel = new JLabel("Number of double rooms: ");
      tRnLabel = new JLabel("Number of triple rooms: ");
      anLabel = new JLabel("Number of apartments: ");
      totalPriceLabel = new JLabel("Total price: ");

      sRnField = new JTextField(10);
      dRnField = new JTextField(10);
      tRnField = new JTextField(10);
      anField = new JTextField(10);
      
      totalPriceArea = new JTextArea();
      totalPriceArea.setEditable(false);

      cancelButton = new JButton("Cancel");
      reserveButton = new JButton("Reserve");
      totalPriceButton = new JButton("Get total");
      
      infoPanel = new JPanel(new GridLayout(7, 2));
      contentPanel = new JPanel(new BorderLayout());
      buttonsPanel = new JPanel(new GridLayout(1, 3));
      
      model = new UtilDateModel();
      model.setDay(MyDate.today().getDay());
      model.setMonth(MyDate.today().getMonth() - 1);
      model.setYear(MyDate.today().getYear());
      model.setSelected(true);
      model2 = new UtilDateModel();
      p = new Properties();
      p.put("text.today", "Today");
      p.put("text.month", "Month");
      p.put("text.year", "Year");
      datePanel = new JDatePanelImpl(model, p);
      datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
      datePanel2 = new JDatePanelImpl(model2, p);
      datePicker2 = new JDatePickerImpl(datePanel2, new DateLabelFormatter());
   }

   @Override
   public void initializeComponents() {
      setSize(new Dimension(500, 500));
      setLocationRelativeTo(null); // center of the screen
      setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
      setResizable(false);
      this.setName("ReserveFrame");
   }

   @Override
   public void addComponentsToFrame() {
      this.setContentPane(contentPanel);
      infoPanel.add(checkInLabel);
      infoPanel.add(datePicker);
      infoPanel.add(checkOutLabel);
      infoPanel.add(datePicker2);
      infoPanel.add(sRnLabel);
      infoPanel.add(sRnField);
      infoPanel.add(dRnLabel);
      infoPanel.add(dRnField);
      infoPanel.add(tRnLabel);
      infoPanel.add(tRnField);
      infoPanel.add(anLabel);
      infoPanel.add(anField);
      infoPanel.add(totalPriceLabel);
      infoPanel.add(totalPriceArea);
      buttonsPanel.add(cancelButton);
      buttonsPanel.add(totalPriceButton);
      buttonsPanel.add(reserveButton);
      contentPanel.add(infoPanel, BorderLayout.CENTER);
      contentPanel.add(buttonsPanel, BorderLayout.SOUTH);
   }

   @Override
   public void addActionListeners(ActionListener actionListener) {
      reserveButton.addActionListener(actionListener);
      cancelButton.addActionListener(actionListener);
      totalPriceButton.addActionListener(actionListener);
   }

   @Override
   public String[] getInput() {
      String[] input = new String[12];
      input[2] = "" + datePicker.getModel().getDay();
      input[3] = "" + datePicker.getModel().getMonth();
      input[4] = "" + datePicker.getModel().getYear();
      input[5] = "" + datePicker2.getModel().getDay();
      input[6] = "" + datePicker2.getModel().getMonth();
      input[7] = "" + datePicker2.getModel().getYear();
      input[8] = sRnField.getText();
      input[9] = dRnField.getText();
      input[10] = tRnField.getText();
      input[11] = anField.getText();
      return input;
   }

   @Override
   public void update(String[] update) {
	   this.totalPriceArea.setText(update[0]);
   }

   @Override
   public void update(String[][] update) {
      // TODO Auto-generated method stub
      
   }

}
