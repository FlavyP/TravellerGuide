package traveller.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.WindowFocusListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class SearchFrame2 extends JFrame implements View {

	private JList<String> list;
	private JButton reserve;
	private JButton reviews;
	private JButton interestPoints;

	private JPanel contentPanel;
	private JPanel buttonsPanel;
	private JPanel listPanel;

	public SearchFrame2() {
		super("Search2");
		createComponents();
		initializeComponents();
		addComponentsToFrame();
		setVisible(true);
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
		listPanel = new JPanel(new GridLayout(1,1));
	}

	@Override
	public void initializeComponents() {
		setSize(500, 500);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setName("Search2");

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

	public static void main(String[] args) {

		SearchFrame2 search = new SearchFrame2();
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
