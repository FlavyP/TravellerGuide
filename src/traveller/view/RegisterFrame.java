package traveller.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.Window;
import java.awt.event.ActionListener;
import java.awt.event.WindowFocusListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class RegisterFrame extends JDialog implements View {
	private static RegisterFrame instance = null;
	private JLabel nameLabel;
	private JLabel emailLabel;
	private JLabel phoneNumberLabel;
	private JLabel addressLabel;
	private JLabel passLabel;

	private JTextField nameField;
	private JTextField emailField;
	private JTextField phoneNumberField;
	private JTextField addressField;
	private JPasswordField passField;

	private JPanel contentPanel;
	private JPanel buttonsPanel;
	private JPanel namePanel;
	private JPanel emailPanel;
	private JPanel phoneNumberPanel;
	private JPanel addressPanel;
	private JPanel passPanel;
	private JPanel all;

	private JButton cancelButton;
	private JButton registerButton;

	public RegisterFrame(Window owner, ActionListener actionListener,
			WindowFocusListener focusListener) {
		super(owner, "Register");
		// super(owner, "Register", JDialog.DEFAULT_MODALITY_TYPE);
		createComponents();
		initializeComponents();
		addComponentsToFrame();
		addActionListeners(actionListener);
		addWindowFocusListener(focusListener);
		setVisible(true);
	}

	// public static RegisterFrame getInstance() {
	// return instance;
	// }

	public static RegisterFrame getInstance(Window owner,
			ActionListener actionListener, WindowFocusListener focusListener) {
		if (instance == null) {
			instance = new RegisterFrame(owner, actionListener, focusListener);
			instance.setVisible(true);
		}
		return instance;
	}

	@Override
	public void createComponents() {
		cancelButton = new JButton("Cancel");
		registerButton = new JButton("Register");
		nameLabel = new JLabel("Name: ");
		emailLabel = new JLabel("Email: ");
		phoneNumberLabel = new JLabel("Phone number: ");
		addressLabel = new JLabel("Address: ");
		passLabel = new JLabel("Password: ");

		nameField = new JTextField(10);
		emailField = new JTextField(10);
		phoneNumberField = new JTextField(10);
		addressField = new JTextField(10);
		passField = new JPasswordField(10);

		contentPanel = new JPanel(new GridLayout(6, 1));
		namePanel = new JPanel(new FlowLayout());
		emailPanel = new JPanel(new FlowLayout());
		phoneNumberPanel = new JPanel(new FlowLayout());
		addressPanel = new JPanel(new FlowLayout());
		passPanel = new JPanel(new FlowLayout());
		buttonsPanel = new JPanel(new FlowLayout());
	}

	@Override
	public void initializeComponents() {
		setSize(new Dimension(500, 500));
		setLocationRelativeTo(null); // center of the screen
		// setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setName("RegisterFrame");
	}

	@Override
	public void addComponentsToFrame() {
		this.setContentPane(contentPanel);
		namePanel.add(nameLabel);
		namePanel.add(nameField);
		emailPanel.add(emailLabel);
		emailPanel.add(emailField);
		phoneNumberPanel.add(phoneNumberLabel);
		phoneNumberPanel.add(phoneNumberField);
		addressPanel.add(addressLabel);
		addressPanel.add(addressField);
		passPanel.add(passLabel);
		passPanel.add(passField);
		buttonsPanel.add(cancelButton);
		buttonsPanel.add(registerButton);

		contentPanel.add(namePanel);
		contentPanel.add(emailPanel);
		contentPanel.add(phoneNumberPanel);
		contentPanel.add(addressPanel);
		contentPanel.add(passPanel);
		contentPanel.add(buttonsPanel);
	}

	public void dispose() {
		instance = null;
		super.dispose();
	}

	@Override
	public void addActionListeners(ActionListener actionListener) {
		registerButton.addActionListener(actionListener);
		cancelButton.addActionListener(actionListener);
	}

	@Override
	public String[] getInput() {
		String[] input = new String[5];
		input[0] = nameField.getText();
		input[1] = emailField.getText();
		input[2] = phoneNumberField.getText();
		input[3] = addressField.getText();
		input[4] = new String(passField.getPassword());
		return input;
	}

	@Override
	public void update(String[] update) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(String[][] update) {
		// TODO Auto-generated method stub
		
	}
}
