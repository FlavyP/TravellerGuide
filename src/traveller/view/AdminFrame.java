package traveller.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Window;
import java.awt.event.ActionListener;
import java.awt.event.WindowFocusListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class AdminFrame extends JDialog implements View {
	
	private JButton addButton;
	private JButton editButton;
	private JButton logsButton;
	private JPanel panel;
	private JPanel panel1;
	private JPanel panel2;
	private JPanel panel3;
	
	private static AdminFrame instance = null;
    public AdminFrame(Window owner, ActionListener actionListener,
			WindowFocusListener focusListener) {
		super(owner, "Admin");
//		 super(owner, "Register", JDialog.DEFAULT_MODALITY_TYPE);
		createComponents();
		initializeComponents();
		addComponentsToFrame();
		addActionListeners(actionListener);
		addWindowFocusListener(focusListener);
		setVisible(true);
    }
	public static AdminFrame getInstance(Window owner,
			ActionListener actionListener, WindowFocusListener focusListener) {
		if (instance == null) {
			instance = new AdminFrame(owner, actionListener, focusListener);
			instance.setVisible(true);
		}
		return instance;
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
		setSize(new Dimension(500, 500));
		setLocationRelativeTo(null); // center of the screen
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setName("AdminFrame");	
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
	@Override
	public String[] getInput() {
		// TODO Auto-generated method stub
		return null;
	}
	public void dispose() {
		instance = null;
		super.dispose();
	}
}
