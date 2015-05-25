package traveller.view;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.WindowFocusListener;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.CaretListener;

public class LogInFrame extends JFrame implements View {
	private JButton registerButton;
	private JButton logInButton;
	private JButton exitButton;

	private JLabel userLabel;
	private JLabel passLabel;

	private JTextField userField;
	private JPasswordField passField;

	private JPanel contentPanel;
	private JPanel userPanel;
	private JPanel passPanel;
	private JPanel buttonsPanel;
	private JPanel userPassPanel;

	private static LogInFrame instance = null;

	private LogInFrame(ActionListener actionListener, WindowFocusListener focusListener) {
		super("Traveller Guide");
		createComponents();
		initializeComponents();
		addComponentsToFrame();
		addActionListeners(actionListener);
		addWindowFocusListener(focusListener);
		setVisible(true);
	}

	public static LogInFrame getInstance(ActionListener actionListener, WindowFocusListener focusListener) {
		if (instance == null) {
			instance = new LogInFrame(actionListener, focusListener);
			instance.setVisible(true);
		}
		return instance;
	}
	
	public void showInUserField(String value) {
		userField.setText(value);
	}

	@Override
	public void createComponents() {
		registerButton = new JButton("Register");
		logInButton = new JButton("Log in");
		contentPanel = new JPanel(new BorderLayout());
		userPanel = new JPanel(new FlowLayout());
		passPanel = new JPanel(new FlowLayout());
		buttonsPanel = new JPanel(new FlowLayout());
		userLabel = new JLabel("Username: ");
		passLabel = new JLabel("Password: ");
		userField = new JTextField(10);
		passField = new JPasswordField(10);
	}

	@Override
	public void initializeComponents() {
		setSize(500, 500);
		setLocationRelativeTo(null); // center of the screen
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setName("LogInFrame");
	}
	
	public String[] getInput(){
		String[] input = new String[2];
		input[0] = userField.getText();
		String password = new String(passField.getPassword());
		input[1] = password;
		return input;
	}
	@Override
	public void addComponentsToFrame() {
		this.setContentPane(contentPanel);
		userPanel.add(userLabel);
		userPanel.add(userField);
		passPanel.add(passLabel);
		passPanel.add(passField);
		buttonsPanel.add(registerButton);
		buttonsPanel.add(logInButton);
		contentPanel.add(userPanel, BorderLayout.NORTH);
		contentPanel.add(passPanel, BorderLayout.CENTER);
		contentPanel.add(buttonsPanel, BorderLayout.SOUTH);
	}

	@Override
	public void addActionListeners(ActionListener actionListener) {
		registerButton.addActionListener(actionListener);
		logInButton.addActionListener(actionListener);
	}

	@Override
	public void update(String[] update) {
		if(update[0].equals("clear")){
			userField.setText("");
			passField.setText("");
		}
	}

	@Override
	public void update(String[][] update) {
		// TODO Auto-generated method stub
		
	}

}