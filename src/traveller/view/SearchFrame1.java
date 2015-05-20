package traveller.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Window;
import java.awt.event.ActionListener;
import java.awt.event.WindowFocusListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SearchFrame1 extends JDialog implements View {

	private JComboBox<String> comboList;
	private JTextField searchName;
	private JButton searchButton;
	private JPanel contentPanel;

	private static SearchFrame1 instance = null;

	public SearchFrame1(Window owner, ActionListener actionListener,
			WindowFocusListener focusListener) {
		super(owner, "Search");
		createComponents();
		initializeComponents();
		addComponentsToFrame();
		addActionListeners(actionListener);
		addWindowFocusListener(focusListener);
		setVisible(true);
	}

	public static SearchFrame1 getInstance(Window owner,
			ActionListener actionListener, WindowFocusListener focusListener) {
		if (instance == null) {
			instance = new SearchFrame1(owner, actionListener, focusListener);
			instance.setVisible(true);
		}
		return instance;
	}

	@Override
	public void createComponents() {
		String[] comboStrings = { "City", "Hotel", "Address" };
		comboList = new JComboBox<String>(comboStrings);
		searchName = new JTextField(20);
		searchButton = new JButton("Search");
		contentPanel = new JPanel(new FlowLayout());
	}

	@Override
	public void initializeComponents() {
		setSize(new Dimension(500, 500));
		setLocationRelativeTo(null); // center of the screen
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setName("SearchFrame1");

	}

	@Override
	public void addComponentsToFrame() {
		this.setContentPane(contentPanel);
		contentPanel.add(comboList, BorderLayout.PAGE_START);
		contentPanel.add(searchName, BorderLayout.CENTER);
		contentPanel.add(searchButton, BorderLayout.PAGE_END);

	}

	@Override
	public void addActionListeners(ActionListener actionListener) {
		searchButton.addActionListener(actionListener);

	}

	public void dispose() {
		instance = null;
		super.dispose();
	}

	@Override
	public String[] getInput() {
		String[] input = new String[2];
		input[0] = String.valueOf(this.comboList.getSelectedIndex());
		input[1] = searchName.getText();
		return input;
	}

	@Override
	public void update(String[] update) {
		// TODO Auto-generated method stub

	}

}
