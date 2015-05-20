package traveller.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SearchFrame1 extends JFrame implements View {

	private JComboBox<String> comboList;
	private JTextField searchName;
	private JButton searchButton;
	private JPanel contentPanel;

	public SearchFrame1() {
		super("Search1");
		createComponents();
		initializeComponents();
		addComponentsToFrame();
		setVisible(true);
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
		setSize(500, 500);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setName("Search1");

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

	public static void main(String[] args) {

		SearchFrame1 frame = new SearchFrame1();
	}

	@Override
	public String[] getInput() {
		String[] input = new String[2];
		input[0] = String.valueOf(this.comboList.getSelectedIndex());
		input[1] = searchName.getText();
		return input;
	}

}
