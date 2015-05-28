package traveller.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ServerFrame extends JFrame {

		private JLabel messageLabel;

		private JPanel contentPanel;

		private static ServerFrame instance = null;

		private ServerFrame() {
			super("Server");
			createComponents();
			initializeComponents();
			addComponentsToFrame();
			setVisible(true);
		}

		public static ServerFrame getInstance() {
			if (instance == null) {
				instance = new ServerFrame();
				instance.setVisible(true);
			}
			return instance;
		}

		public void createComponents() {
			messageLabel = new JLabel("Server is running");
			messageLabel.setFont(new Font("serif", Font.PLAIN, 24));
			contentPanel = new JPanel(new FlowLayout());
		}

		public void initializeComponents() {
			setSize(500, 500);
			setLocationRelativeTo(null); // center of the screen
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setResizable(false);
		}
		
		public void addComponentsToFrame() {
			this.setContentPane(contentPanel);
			contentPanel.add(messageLabel);
		}
}