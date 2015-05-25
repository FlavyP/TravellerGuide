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

	private JButton cancelButton;
	private JButton registerButton;

	private RegisterFrame(Window owner, ActionListener actionListener,
			WindowFocusListener focusListener) {
		super(owner, "Register");
		createComponents();
		initializeComponents();
		addComponentsToFrame();
		addActionListeners(actionListener);
		addWindowFocusListener(focusListener);
		setVisible(true);
	}

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

		contentPanel = new JPanel(new GridLayout(6, 2));
	}

	@Override
	public void initializeComponents() {
		setSize(new Dimension(500, 500));
		setLocationRelativeTo(null); // center of the screen
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setName("RegisterFrame");
	}

	@Override
	public void addComponentsToFrame() {
		this.setContentPane(contentPanel);
		contentPanel.add(nameLabel);
		contentPanel.add(nameField);
		contentPanel.add(emailLabel);
		contentPanel.add(emailField);
		contentPanel.add(phoneNumberLabel);
		contentPanel.add(phoneNumberField);
		contentPanel.add(addressLabel);
		contentPanel.add(addressField);
		contentPanel.add(passLabel);
		contentPanel.add(passField);
		contentPanel.add(cancelButton);
		contentPanel.add(registerButton);
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
