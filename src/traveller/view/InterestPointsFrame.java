package traveller.view;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
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
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.event.CaretListener;
import javax.swing.table.TableColumn;

public class InterestPointsFrame extends JDialog implements View {
	private JPanel contentPanel;
	private JPanel ipPanel;
	private JPanel buttonsPanel;

	private JComboBox<String> comboBox;
	private String[] ip = { "cafe", "museum", "night_club", "restaurant",
			"shopping_mall" };
	private JLabel iplabel;
	private JButton getBtn;
	private JButton getDirectionsBtn;
	private JButton backButton;
	private JList<String> list;
	private JScrollPane scrollPane;

	private GUITableModel tableModel;
	private JTable table;
	private String[] tableLabels;

	private static InterestPointsFrame instance = null;

	private InterestPointsFrame(Window owner, ActionListener actionListener,
			WindowFocusListener focusListener) {
		super(owner, "Interest Points");
		createComponents();
		initializeComponents();
		addComponentsToFrame();
		addActionListeners(actionListener);
		addWindowFocusListener(focusListener);
		setVisible(true);
	}

	public static InterestPointsFrame getInstance(Window owner,
			ActionListener actionListener, WindowFocusListener focusListener) {
		if (instance == null) {
			instance = new InterestPointsFrame(owner, actionListener,
					focusListener);
			instance.setVisible(true);
		}
		return instance;
	}

	@Override
	public void createComponents() {

		iplabel = new JLabel("Type Of Interest Points: ");
		comboBox = new JComboBox<String>(ip);
		getBtn = new JButton("Get interest points");
		backButton = new JButton("Back");
		getDirectionsBtn = new JButton("Get directions");
		contentPanel = new JPanel(new BorderLayout());
		ipPanel = new JPanel(new FlowLayout());
		buttonsPanel = new JPanel(new FlowLayout());
		tableLabels = new String[] { "ID", "Name", "Address", "Rating" };
		this.tableModel = new GUITableModel(this.tableLabels, 0);
		this.table = new JTable(this.tableModel);
		this.table.setFillsViewportHeight(true);
		this.table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.scrollPane = new JScrollPane(this.table);
		scrollPane
				.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane
				.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
	}

	@Override
	public void initializeComponents() {
		setSize(new Dimension(500, 500));
		setLocationRelativeTo(null); // center of the screen
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setName("InterestPointsFrame");
	}

	@Override
	public void addComponentsToFrame() {
		this.setContentPane(contentPanel);

		ipPanel.add(iplabel);
		ipPanel.add(comboBox);
		ipPanel.add(scrollPane);
		buttonsPanel.add(getBtn);
		buttonsPanel.add(getDirectionsBtn);
		buttonsPanel.add(backButton);

		contentPanel.add(ipPanel, BorderLayout.NORTH);
		contentPanel.add(scrollPane, BorderLayout.CENTER);
		contentPanel.add(buttonsPanel, BorderLayout.SOUTH);
	}

	@Override
	public void addActionListeners(ActionListener actionListener) {

		getBtn.addActionListener(actionListener);
		getDirectionsBtn.addActionListener(actionListener);
		backButton.addActionListener(actionListener);
	}

	public void dispose() {
		instance = null;
		super.dispose();
	}

	@Override
	public String[] getInput() {
		String[] input = new String[2];
		input[0] = this.comboBox.getSelectedItem().toString();
		try {
			input[1] = (String) this.tableModel.getValueAt(
					this.table.getSelectedRow(), 0);
		} catch (ArrayIndexOutOfBoundsException e) {

		}
		return input;
	}

	@Override
	public void update(String[] update) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(String[][] update) {
		this.tableModel = new GUITableModel(update, this.tableLabels);
		this.table.setModel(this.tableModel);
		table.getColumnModel().getColumn(0).setMaxWidth(20);
		table.getColumnModel().getColumn(3).setMaxWidth(50);
	}
}
