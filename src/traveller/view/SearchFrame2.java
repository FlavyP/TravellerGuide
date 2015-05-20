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
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class SearchFrame2 extends JDialog implements View {

	private JList<String> list;
	private JButton reserve;
	private JButton reviews;
	private JButton interestPoints;

	private JPanel contentPanel;
	private JPanel buttonsPanel;
	private JPanel listPanel;

	private static SearchFrame2 instance = null;

	public SearchFrame2(Window owner, ActionListener actionListener,
			WindowFocusListener focusListener) {
		super(owner, "Search");
		createComponents();
		initializeComponents();
		addComponentsToFrame();
		addActionListeners(actionListener);
		addWindowFocusListener(focusListener);
		setVisible(true);
	}

	public static SearchFrame2 getInstance(Window owner,
			ActionListener actionListener, WindowFocusListener focusListener) {
		if (instance == null) {
			instance = new SearchFrame2(owner, actionListener, focusListener);
			instance.setVisible(true);
		}
		return instance;
	}

	@Override
	public void createComponents() {
		String[] listHotels = { "Hotel1dshgfdf,jhkjsfhgkldfhgksfljhgldfkhdgdk",
				"Hotel2", "Hotel3", "Hotel4" };
		list = new JList<String>(listHotels);
		reserve = new JButton("Reserve");
		reviews = new JButton("Give Reviews");
		interestPoints = new JButton("Find interest points");
		contentPanel = new JPanel(new BorderLayout());
		buttonsPanel = new JPanel(new GridLayout(3, 1));
		listPanel = new JPanel(new GridLayout(1, 1));
	}

	@Override
	public void initializeComponents() {
		setSize(new Dimension(500, 500));
		setLocationRelativeTo(null); // center of the screen
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setName("SearchFrame2");

	}

	@Override
	public void addComponentsToFrame() {
		this.setContentPane(contentPanel);
		buttonsPanel.add(reserve);
		buttonsPanel.add(reviews);
		buttonsPanel.add(interestPoints);
		listPanel.add(new JScrollPane(list));
		contentPanel.add(listPanel);
		contentPanel.add(buttonsPanel, BorderLayout.EAST);

	}

	@Override
	public void addActionListeners(ActionListener actionListener) {
		reserve.addActionListener(actionListener);
		reviews.addActionListener(actionListener);
		interestPoints.addActionListener(actionListener);
	}

	public void dispose() {
		instance = null;
		super.dispose();
	}

	@Override
	public String[] getInput() {
		return null;
	}

	@Override
	public void update(String[] update) {
		// TODO Auto-generated method stub

	}
}
