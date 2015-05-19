package traveller.view;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.WindowFocusListener;

import javax.swing.JButton;
import javax.swing.JComboBox;

import javax.swing.JFrame;
import javax.swing.JPanel;

import javax.swing.JTextField;



public class SearchFrame1 extends JFrame implements View{
	
		
	
	
	
	private JComboBox<String> comboList;
	private JTextField searchName;
	private JButton searchButton;
	private JPanel content;
	
	
	
	public SearchFrame1() {
		super("Search1");
		createComponents();
		initializeComponents();
		addComponentsToFrame();
	
		setVisible(true);
	
	}
	


	@Override
	public void createComponents() {
		String []  comboStrings = {"City", "Hotel", "Address"};
		 comboList = new JComboBox<String>(comboStrings);
		 searchName = new JTextField(20);
		 searchButton = new JButton("Search");
		
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


		
		JPanel panel = new JPanel();
		JPanel comboBoxPane = new JPanel();
		comboBoxPane.add(comboList);
		panel.add(comboBoxPane, BorderLayout.PAGE_START);
		panel.add(searchName);
		panel.add(searchButton, BorderLayout.PAGE_END);
		this.setContentPane(panel);
		
		
		
	}


	@Override
	public void addActionListeners(ActionListener actionListener) {
		searchButton.addActionListener(actionListener);
		
	}
	
	public static void main(String[] args) {
		
		SearchFrame1 frame = new SearchFrame1();
	}
	
	



}
