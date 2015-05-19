package traveller.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Window;
import java.awt.event.ActionListener;
import java.awt.event.WindowFocusListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class GiveReviewsFrame extends JDialog implements View {
	private static GiveReviewsFrame instance = null;
	
	private JLabel commentLabel;
	
	private JTextArea commentField;
	
	private JButton submitButton;
	private JButton cancelButton;
	
	private JPanel contentPanel;
	private JPanel commentPanel;
	private JPanel buttonsPanel;
	
	private JComboBox<String> comboBox;
	private String[] review = {"5","4","3","2","1"};
	
	public GiveReviewsFrame(Window owner, ActionListener actionListener,
			WindowFocusListener focusListener) {
		super(owner, "Give a review");
		createComponents();
		initializeComponents();
		addComponentsToFrame();
		addActionListeners(actionListener);
		addWindowFocusListener(focusListener);
		setVisible(true);
	}
	public static GiveReviewsFrame getInstance(Window owner,
			ActionListener actionListener, WindowFocusListener focusListener) {
		if (instance == null) {
			instance = new GiveReviewsFrame(owner, actionListener, focusListener);
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
		commentLabel = new JLabel("Comment: ");
		commentField = new JTextArea();
		submitButton = new JButton("Submit");
		cancelButton = new JButton("Cancel");
		comboBox = new JComboBox<String>(review);
		
		contentPanel = new JPanel(new BorderLayout());
		commentPanel = new JPanel(new GridLayout(1, 2));
		buttonsPanel = new JPanel(new GridLayout(1, 2));
	}

	@Override
	public void initializeComponents() {
		setSize(new Dimension(500, 250));
		setLocationRelativeTo(null); // center of the screen
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setName("GiveReviewsFrame");
	}

	@Override
	public void addComponentsToFrame() {
		this.setContentPane(contentPanel);
		commentPanel.add(commentLabel);
		commentPanel.add(commentField);
		buttonsPanel.add(cancelButton);
		buttonsPanel.add(submitButton);
		contentPanel.add(comboBox, BorderLayout.NORTH);
		contentPanel.add(commentPanel, BorderLayout.CENTER);
		contentPanel.add(buttonsPanel, BorderLayout.SOUTH);
	}

	@Override
	public void addActionListeners(ActionListener actionListener) {
		submitButton.addActionListener(actionListener);
		cancelButton.addActionListener(actionListener);
		comboBox.addActionListener(actionListener);
	}

}
