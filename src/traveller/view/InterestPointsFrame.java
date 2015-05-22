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
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.CaretListener;

public class InterestPointsFrame extends JDialog implements View {
	private JPanel contentPanel;
	private JPanel ipPanel;
	private JPanel buttonsPanel;

	private JComboBox<String> comboBox;
	private String[] ip = { "CAFE", "MUSEUM", "NIGHT_CLUB", "RESTAURANT",
			"SHOPPING_MALL" };
	private JLabel iplabel;
	private JButton getBtn;
	private JButton getDirectionsBtn;
	private JList<String> list;
	private JScrollPane scrollPane;

	private static InterestPointsFrame instance = null;

	public InterestPointsFrame(Window owner, ActionListener actionListener,
			WindowFocusListener focusListener) {
		super(owner, "Interest Points");
		createComponents();
		initializeComponents();
		addComponentsToFrame();
		addActionListeners(actionListener);
		addWindowFocusListener(focusListener);
		setVisible(true);
	}
	public InterestPointsFrame() {
//		super(owner, "Interest Points");
		createComponents();
		initializeComponents();
		addComponentsToFrame();
//		addActionListeners(actionListener);
//		addWindowFocusListener(focusListener);
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
		getBtn = new JButton("GET");
		getDirectionsBtn = new JButton("GET DIRECTIONS");
		contentPanel = new JPanel(new BorderLayout());
		ipPanel = new JPanel(new FlowLayout());
		buttonsPanel = new JPanel(new FlowLayout());
		String[] array = { "sfsdgsd", "sdgsdgsd", "gdgdf", "gdfgdfgdf",
				"sdgsdfgsdg", "gdsgdgdf", "gdfgdfgdf", "gsdfgdfdfg",
				"sdgsdgsdgsdgsdgsdgsdgsdgsdgsdg" };
		list = new JList<String>(array);
		scrollPane = new JScrollPane();
		scrollPane.setViewportView(list);
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

		contentPanel.add(ipPanel, BorderLayout.NORTH);
		contentPanel.add(scrollPane, BorderLayout.CENTER);
		contentPanel.add(buttonsPanel, BorderLayout.SOUTH);
	}

	@Override
	public void addActionListeners(ActionListener actionListener) {

		getBtn.addActionListener(actionListener);
		getDirectionsBtn.addActionListener(actionListener);
	}

	public void dispose() {
		instance = null;
		super.dispose();
	}

	@Override
	public String[] getInput() {
		String[] input = new String[1];
		input[0] = String.valueOf(this.comboBox.getSelectedIndex());
		return input;
	}

	@Override
	public void update(String[] update) {
		// TODO Auto-generated method stub

	}
	public static void main(String[] args) {
		InterestPointsFrame frame = new InterestPointsFrame();
	}
	@Override
	public void update(String[][] update) {
		// TODO Auto-generated method stub
		
	}
}
