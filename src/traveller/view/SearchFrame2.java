package traveller.view;


import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;





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
	private JPanel content;
	
	 public SearchFrame2() {
		super("Search2");
		createComponents();
		initializeComponents();
		addComponentsToFrame();
		
		setVisible(true);
	}
	@Override
	public void createComponents() {
		String[] listHotels = {"Hotel1dshgfdf,jhkjsfhgkldfhgksfljhgldfkhdgdk", "Hotel2", "Hotel3", "Hotel4"};
     list = new JList<String>(listHotels);
     reserve = new JButton("Reserve");
     reviews = new JButton("Give Reviews");
     interestPoints = new JButton("Find interest points");
     

		
	}
	@Override
	public void initializeComponents() {
		setSize(550, 200);
		setLocationRelativeTo(null); 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setName("Search2");
		
	}
	@Override
	public void addComponentsToFrame() {
		
		
		JPanel panel = new JPanel(new GridLayout(1, 3));
		JPanel panel1 = new JPanel();
	    panel1.add(list);
	   
	    
	    JPanel panel2 = new JPanel(new GridLayout(3, 1));
	    panel2.add(reserve);
	    panel2.add(reviews);
	    panel2.add(interestPoints);
	   
        
	    
	    panel.add(new JScrollPane(list), BorderLayout.CENTER);
	    panel.add(panel2, BorderLayout.EAST);
	    this.setContentPane(panel);
	    
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
}
