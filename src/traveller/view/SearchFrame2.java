package traveller.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Window;
import java.awt.event.ActionListener;
import java.awt.event.WindowFocusListener;
import java.util.Enumeration;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.event.TableColumnModelListener;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

public class SearchFrame2 extends JDialog implements View {

	private GUITableModel tableModel;
	private JTable table;
	private String[] tableLabels;

	private JButton reserve;
	private JButton reviews;
	private JButton getReviews;
	private JButton interestPoints;
	private JButton backButton;

	private JPanel contentPanel;
	private JPanel buttonsPanel;
	private JPanel listPanel;

	private JScrollPane scrollPanel;

	private static SearchFrame2 instance = null;

	private SearchFrame2(Window owner, ActionListener actionListener,
			WindowFocusListener focusListener) {
		super(owner, "Search");
		createComponents();
		initializeComponents();
		addComponentsToFrame();
		addActionListeners(actionListener);
		addWindowFocusListener(focusListener);
		setVisible(true);
	}

	public static SearchFrame2 getInstance(Window owner,
			ActionListener actionListener, WindowFocusListener focusListener) {
		if (instance == null) {
			instance = new SearchFrame2(owner, actionListener, focusListener);
			instance.setVisible(true);
		}
		return instance;
	}

	@Override
	public void createComponents() {
		tableLabels = new String[] { "Id", "Name", "City", "Address", "sRooms",
				"sPrice", "dRooms", "dPrice", "tRooms", "tPrice", "Apartments",
				"aPrice" };
		this.tableModel = new GUITableModel(this.tableLabels, 0);
		this.table = new JTable(this.tableModel);
		this.table.setFillsViewportHeight(true);
		this.table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.scrollPanel = new JScrollPane(this.table);

		reserve = new JButton("Reserve");
		reviews = new JButton("Give Reviews");
		getReviews = new JButton("Get Reviews");
		interestPoints = new JButton("Find interest points");
		backButton = new JButton("Back");
		contentPanel = new JPanel(new BorderLayout());
		buttonsPanel = new JPanel(new GridLayout(5, 1));
		listPanel = new JPanel(new GridLayout(1, 1));
		scrollPanel
				.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPanel
				.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
	}

	@Override
	public void initializeComponents() {
		setSize(new Dimension(500, 500));
		setLocationRelativeTo(null); // center of the screen
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setName("SearchFrame2");

	}

	@Override
	public void addComponentsToFrame() {
		this.setContentPane(contentPanel);
		buttonsPanel.add(reserve);
		buttonsPanel.add(reviews);
		buttonsPanel.add(getReviews);
		buttonsPanel.add(interestPoints);
		buttonsPanel.add(backButton);
		contentPanel.add(scrollPanel);
		contentPanel.add(buttonsPanel, BorderLayout.EAST);

	}

	@Override
	public void addActionListeners(ActionListener actionListener) {
		reserve.addActionListener(actionListener);
		reviews.addActionListener(actionListener);
		getReviews.addActionListener(actionListener);
		interestPoints.addActionListener(actionListener);
		backButton.addActionListener(actionListener);
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
	public void update(String[] update) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(String[][] update) {
		this.tableModel = new GUITableModel(update, this.tableLabels);
		this.table.setModel(this.tableModel);
	}
}
