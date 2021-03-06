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

public class MyReviewsFrame extends JDialog implements TravellerView {
	private GUITableModel tableModel;
	private JTable table;
	private String[] tableLabels;

	private JButton backButton;
	private JButton cancelRevButton;

	private JPanel contentPanel;
	private JPanel buttonsPanel;

	private JScrollPane scrollPanel;

	private static MyReviewsFrame instance = null;

	private MyReviewsFrame(Window owner, ActionListener actionListener,
			WindowFocusListener focusListener) {
		super(owner, "My Reviews");
		createComponents();
		initializeComponents();
		addComponentsToFrame();
		addActionListeners(actionListener);
		addWindowFocusListener(focusListener);
		setVisible(true);
	}

	public static MyReviewsFrame getInstance(Window owner,
			ActionListener actionListener, WindowFocusListener focusListener) {
		if (instance == null) {
			instance = new MyReviewsFrame(owner, actionListener, focusListener);
			instance.setVisible(true);
		}
		return instance;
	}

	public void createComponents() {
		tableLabels = new String[] { "Id", "Hotel", "Grade", "Comment" };
		this.tableModel = new GUITableModel(this.tableLabels, 0);
		this.table = new JTable(this.tableModel);
		this.table.setFillsViewportHeight(true);
		this.table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.scrollPanel = new JScrollPane(this.table);

		contentPanel = new JPanel(new BorderLayout());
		buttonsPanel = new JPanel(new FlowLayout());

		this.backButton = new JButton("Back");
		this.cancelRevButton = new JButton("Cancel review");

		scrollPanel
				.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPanel
				.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		// table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.getColumnModel().getColumn(0).setMaxWidth(20);
		table.getColumnModel().getColumn(1).setMaxWidth(100);
		table.getColumnModel().getColumn(2).setMaxWidth(20);
	}

	@Override
	public void initializeComponents() {
		setSize(new Dimension(500, 500));
		setLocationRelativeTo(null); // center of the screen
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setResizable(false);
		this.setName("MyReviewsFrame");
	}

	@Override
	public void addComponentsToFrame() {
		this.setContentPane(contentPanel);
		buttonsPanel.add(backButton);
		buttonsPanel.add(cancelRevButton);
		contentPanel.add(scrollPanel);
		contentPanel.add(buttonsPanel, BorderLayout.SOUTH);

	}

	@Override
	public void addActionListeners(ActionListener actionListener) {
		backButton.addActionListener(actionListener);
		cancelRevButton.addActionListener(actionListener);

	}

	public void dispose() {
		instance = null;
		super.dispose();
	}

	@Override
	public String[] getInput() {
		String[] input = new String[1];
		try {
			input[0] = (String) this.tableModel.getValueAt(
					this.table.getSelectedRow(), 0);
		} catch (Exception e) {
			input[0] = "";
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
		table.getColumnModel().getColumn(1).setMaxWidth(100);
		table.getColumnModel().getColumn(2).setMaxWidth(100);
	}
}
