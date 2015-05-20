package traveller.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class AdminFrame extends JFrame implements View {
	
	private JButton addButton;
	private JButton editButton;
	private JButton logsButton;
	private JPanel panel;
	private JPanel panel1;
	private JPanel panel2;
	private JPanel panel3;
	
	
    public AdminFrame() {
    	super("Admin");
		createComponents();
		initializeComponents();
		addComponentsToFrame();
		setVisible(true);
	}
	@Override
	public void createComponents() {
		addButton = new JButton("Add Hotel");
		editButton = new JButton("Edit Hotel");
		logsButton = new JButton("Logs Hotel");
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
		this.setName("Admin");
		
	}
	@Override
	public void addComponentsToFrame() {
		panel1.add(addButton, BorderLayout.CENTER);
		panel2.add(editButton, BorderLayout.CENTER);
		panel3.add(logsButton, BorderLayout.CENTER);
		panel.add(panel1);
		panel.add(panel2);
		panel.add(panel3);
		this.setContentPane(panel);
	}
	@Override
	public void addActionListeners(ActionListener actionListener) {
	    addButton.addActionListener(actionListener);
	    editButton.addActionListener(actionListener);
	    logsButton.addActionListener(actionListener);
	}
	
	public static void main(String[] args) {
		AdminFrame admin = new AdminFrame();
	}

}
