package traveller.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GuestFrame extends JFrame implements View {
	
	private JButton searchButton;
	private JButton myResButton;
	private JButton myRevButton;
	private JPanel panel;
	private JPanel panel1;
	private JPanel panel2;
	private JPanel panel3;
	
	
    public GuestFrame() {
    	super("Guest");
		createComponents();
		initializeComponents();
		addComponentsToFrame();
		setVisible(true);
	}
	@Override
	public void createComponents() {
		searchButton = new JButton("Search");
		myResButton = new JButton("My reservations");
		myRevButton = new JButton("My reviews");
		panel = new JPanel(new GridLayout(3,1));
		panel1 = new JPanel();
		panel2 = new JPanel();
		panel3 = new JPanel();
		
	}
	@Override
	public void initializeComponents() {
		setSize(400, 200);
		setLocationRelativeTo(null); 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setName("Guest");
		
	}
	@Override
	public void addComponentsToFrame() {
		panel1.add(searchButton, BorderLayout.CENTER);
		panel2.add(myResButton, BorderLayout.CENTER);
		panel3.add(myRevButton, BorderLayout.CENTER);
		panel.add(panel1);
		panel.add(panel2);
		panel.add(panel3);
		this.setContentPane(panel);
	}
	@Override
	public void addActionListeners(ActionListener actionListener) {
	    searchButton.addActionListener(actionListener);
	    myResButton.addActionListener(actionListener);
	    myRevButton.addActionListener(actionListener);
	}
	
	public static void main(String[] args) {
		GuestFrame admin = new GuestFrame();
	}
	@Override
	public String[] getInput() {
		// TODO Auto-generated method stub
		return null;
	}

}
