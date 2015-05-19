package traveller.view;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Window;
import java.awt.event.ActionListener;
import java.awt.event.WindowFocusListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ReserveFrame extends JDialog implements View {
	private static ReserveFrame instance = null;
	private JLabel checkInLabel;
	private JLabel checkOutLabel;
	private JLabel sRnLabel;
	private JLabel dRnLabel;
	private JLabel tRnLabel;
	private JLabel anLabel;

	private JTextField checkInField;
	private JTextField checkOutField;
	private JTextField sRnField;
	private JTextField dRnField;
	private JTextField tRnField;
	private JTextField anField;

	private JPanel contentPanel;
	private JPanel buttonsPanel;

	private JButton reserveButton;
	private JButton cancelButton;

	public ReserveFrame(Window owner, ActionListener actionListener,
			WindowFocusListener focusListener) {
		super(owner, "Reserve");
		createComponents();
		initializeComponents();
		addComponentsToFrame();
		addActionListeners(actionListener);
		addWindowFocusListener(focusListener);
		setVisible(true);
	}

	public static ReserveFrame getInstance(Window owner,
			ActionListener actionListener, WindowFocusListener focusListener) {
		if (instance == null) {
			instance = new ReserveFrame(owner, actionListener, focusListener);
			instance.setVisible(true);
		}
		return instance;
	}

	public void dispose() {
		instance = null;
		super.dispose();
	}

	@Override
	public void createComponents() {
		checkInLabel = new JLabel("Chech in date: ");
		checkOutLabel = new JLabel("Check out date: ");
		sRnLabel = new JLabel("Number of single rooms: ");
		dRnLabel = new JLabel("Number of double rooms: ");
		tRnLabel = new JLabel("Number of triple rooms: ");
		anLabel = new JLabel("Number of apartments: ");

		checkInField = new JTextField(10);
		checkOutField = new JTextField(10);
		sRnField = new JTextField(10);
		dRnField = new JTextField(10);
		tRnField = new JTextField(10);
		anField = new JTextField(10);

		cancelButton = new JButton("Cancel");
		reserveButton = new JButton("Reserve");
		
		contentPanel = new JPanel(new GridLayout(7, 2));
	}

	@Override
	public void initializeComponents() {
		setSize(new Dimension(500, 500));
		setLocationRelativeTo(null); // center of the screen
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setName("ReserveFrame");
	}

	@Override
	public void addComponentsToFrame() {
		this.setContentPane(contentPanel);
		contentPanel.add(checkInLabel);
		contentPanel.add(checkInField);
		contentPanel.add(checkOutLabel);
		contentPanel.add(checkOutField);
		contentPanel.add(sRnLabel);
		contentPanel.add(sRnField);
		contentPanel.add(dRnLabel);
		contentPanel.add(dRnField);
		contentPanel.add(tRnLabel);
		contentPanel.add(tRnField);
		contentPanel.add(anLabel);
		contentPanel.add(anField);
		contentPanel.add(cancelButton);
		contentPanel.add(reserveButton);
	}

	@Override
	public void addActionListeners(ActionListener actionListener) {
		reserveButton.addActionListener(actionListener);
		cancelButton.addActionListener(actionListener);
	}

}
