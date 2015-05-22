package traveller.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Window;
import java.awt.event.ActionListener;
import java.awt.event.WindowFocusListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GuestFrame extends JDialog implements View {

	private JButton searchButton;
	private JButton myResButton;
	private JButton myRevButton;
	private JButton logOutButton;
	private JPanel panel;

	private static GuestFrame instance = null;

	public GuestFrame(Window owner, ActionListener actionListener,
			WindowFocusListener focusListener) {
		super(owner, "Guest");
		createComponents();
		initializeComponents();
		addComponentsToFrame();
		addActionListeners(actionListener);
		addWindowFocusListener(focusListener);
		setVisible(true);
	}

	public static GuestFrame getInstance(Window owner,
			ActionListener actionListener, WindowFocusListener focusListener) {
		if (instance == null) {
			instance = new GuestFrame(owner, actionListener, focusListener);
			instance.setVisible(true);
		}
		return instance;
	}

	@Override
	public void createComponents() {
		searchButton = new JButton("Search");
		myResButton = new JButton("My reservations");
		myRevButton = new JButton("My reviews");
		logOutButton = new JButton("Log Out");
		panel = new JPanel(new GridLayout(4, 1));
		
		searchButton.setFont(new Font("serif", Font.PLAIN, 24));
		myResButton.setFont(new Font("serif", Font.PLAIN, 24));
		myRevButton.setFont(new Font("serif", Font.PLAIN, 24));
		logOutButton.setFont(new Font("serif", Font.PLAIN, 24));

	}

	@Override
	public void initializeComponents() {
		setSize(new Dimension(500, 500));
		setLocationRelativeTo(null); // center of the screen
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setName("GuestFrame");

	}

	@Override
	public void addComponentsToFrame() {
		panel.add(searchButton);
		panel.add(myResButton);
		panel.add(myRevButton);
		panel.add(logOutButton);
		this.setContentPane(panel);
	}

	@Override
	public void addActionListeners(ActionListener actionListener) {
		searchButton.addActionListener(actionListener);
		myResButton.addActionListener(actionListener);
		myRevButton.addActionListener(actionListener);
		logOutButton.addActionListener(actionListener);
	}

	public void dispose() {
		instance = null;
		super.dispose();
	}

	@Override
	public String[] getInput() {
		// TODO Auto-generated method stub
		return null;
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
