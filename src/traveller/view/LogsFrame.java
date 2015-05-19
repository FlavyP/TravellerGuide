package traveller.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class LogsFrame extends JFrame implements View {

	private JList<String> list;
	private JButton backButton;
	private JPanel panel;
	private JPanel panel1;
	
	
	 public LogsFrame() {
		 super("Logs");
			createComponents();
			initializeComponents();
			addComponentsToFrame();
			setVisible(true);
	}
	

	@Override
	public void createComponents() {
		String[] listLogs = {"log1", "log2", "log3", "log4", "log5"};
		list = new JList<String>(listLogs);
		backButton = new JButton("Back");
		panel = new JPanel(new BorderLayout());
		panel1 = new JPanel();
		
		
	}

	@Override
	public void initializeComponents() {
		setSize(500, 500);
		setLocationRelativeTo(null); 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setName("Logs");
		
	}

	@Override
	public void addComponentsToFrame() {
        panel1.add(backButton, BorderLayout.CENTER);
		panel.add(new JScrollPane(list)); 	
		panel.add(panel1, BorderLayout.SOUTH);
		this.setContentPane(panel);
		
	}

	@Override
	public void addActionListeners(ActionListener actionListener) {
		backButton.addActionListener(actionListener);
		
	}
	
	public static void main(String[] args) {
		LogsFrame logs = new LogsFrame();
	}
}
