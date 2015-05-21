package traveller.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Window;
import java.awt.event.ActionListener;
import java.awt.event.WindowFocusListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class GetReviewsFrame extends JDialog implements View {
	private static GetReviewsFrame instance = null;

	private JPanel contentPanel;

	private JList<String> list;

	private JButton backButton;

	private GetReviewsFrame(Window owner, ActionListener actionListener,
			WindowFocusListener focusListener) {
		super(owner, "Get reviews");
		createComponents();
		initializeComponents();
		addComponentsToFrame();
		addActionListeners(actionListener);
		addWindowFocusListener(focusListener);
		setVisible(true);
	}

	public static GetReviewsFrame getInstance(Window owner,
			ActionListener actionListener, WindowFocusListener focusListener) {
		if (instance == null) {
			instance = new GetReviewsFrame(owner, actionListener, focusListener);
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
		contentPanel = new JPanel(new BorderLayout());
		list = new JList<String>();
		backButton = new JButton("Back");
	}

	@Override
	public void initializeComponents() {
		setSize(new Dimension(500, 500));
		setLocationRelativeTo(null); // center of the screen
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setName("GetReviewsFrame");
	}

	@Override
	public void addComponentsToFrame() {
		this.setContentPane(contentPanel);
		contentPanel.add(list, BorderLayout.CENTER);
		contentPanel.add(backButton, BorderLayout.SOUTH);
	}

	@Override
	public void addActionListeners(ActionListener actionListener) {
		backButton.addActionListener(actionListener);
	}

	@Override
	public String[] getInput() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(String[] update) {
		this.list.setListData(update);
	}

	@Override
	public void update(String[][] update) {
		// TODO Auto-generated method stub

	}
}
