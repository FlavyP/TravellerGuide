package traveller.view;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Window;
import java.awt.event.ActionListener;
import java.awt.event.WindowFocusListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class EditHotelFrame extends JDialog implements View {
	private JButton hotelInfoButton;
	private JButton editHotelButton;
	private JButton clearButton;
	private JButton deleteButton;

	private JLabel hotelName;
	private JLabel hotelCity;
	private JLabel hotelAddress;
	private JLabel nrSingleRooms;
	private JLabel prSingleRooms;
	private JLabel nrDoubleRooms;
	private JLabel prDoubleRooms;
	private JLabel nrTripleRooms;
	private JLabel prTripleRooms;
	private JLabel nrApartments;
	private JLabel prApartments;

	private JTextField hotelInfoField;
	private JTextField hotelNameField;
	private JTextField hotelCityField;
	private JTextField hotelAddressField;
	private JTextField nrSingleRoomsField;
	private JTextField prSingleRoomsField;
	private JTextField nrDoubleRoomsField;
	private JTextField prDoubleRoomsField;
	private JTextField nrTripleRoomsField;
	private JTextField prTripleRoomsField;
	private JTextField nrApartmentsField;
	private JTextField prApartmentsField;

	private JPanel contentPanel;
	private JPanel firstPanel;
	private JPanel secondPanel;

	private static EditHotelFrame instance = null;

	public EditHotelFrame(Window owner, ActionListener actionListener,
			WindowFocusListener focusListener) {
		super(owner, "Edit hotel");
		createComponents();
		initializeComponents();
		addComponentsToFrame();
		addActionListeners(actionListener);
		addWindowFocusListener(focusListener);
		setVisible(true);
	}

	public static EditHotelFrame getInstance(Window owner,
			ActionListener actionListener, WindowFocusListener focusListener) {
		if (instance == null) {
			instance = new EditHotelFrame(owner, actionListener, focusListener);
			instance.setVisible(true);
		}
		return instance;
	}

	@Override
	public void createComponents() {
		hotelInfoButton = new JButton("Get info");
		editHotelButton = new JButton("Edit hotel");
		clearButton = new JButton("Clear");
		deleteButton = new JButton("Delete");
		hotelName = new JLabel("Name: ");
		hotelCity = new JLabel("City: ");
		hotelAddress = new JLabel("Address: ");
		nrSingleRooms = new JLabel("Single Rooms: ");
		prSingleRooms = new JLabel("Pr Single Rooms: ");
		nrDoubleRooms = new JLabel("Double Rooms: ");
		prDoubleRooms = new JLabel("Pr Double Rooms: ");
		nrTripleRooms = new JLabel("Triple Rooms: ");
		prTripleRooms = new JLabel("Pr Triple Rooms: ");
		nrApartments = new JLabel("Apartments: ");
		prApartments = new JLabel("Pr Aparments: ");
		hotelInfoField = new JTextField(10);
		hotelNameField = new JTextField(6);
		hotelCityField = new JTextField(6);
		hotelAddressField = new JTextField(6);
		nrSingleRoomsField = new JTextField(10);
		prSingleRoomsField = new JTextField(10);
		nrDoubleRoomsField = new JTextField(10);
		prDoubleRoomsField = new JTextField(10);
		nrTripleRoomsField = new JTextField(10);
		prTripleRoomsField = new JTextField(10);
		nrApartmentsField = new JTextField(10);
		prApartmentsField = new JTextField(10);
		contentPanel = new JPanel();
		firstPanel = new JPanel(new GridLayout(1, 6, 5, 1));
		secondPanel = new JPanel(new GridLayout(5, 4, 5, 1));
	}

	@Override
	public void initializeComponents() {
		setSize(new Dimension(500, 500));
		setLocationRelativeTo(null); // center of the screen
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setName("EditHotelFrame");
	}

	@Override
	public void addComponentsToFrame() {
		this.setContentPane(contentPanel);
		firstPanel.add(hotelName);
		firstPanel.add(hotelNameField);
		firstPanel.add(hotelCity);
		firstPanel.add(hotelCityField);
		firstPanel.add(hotelAddress);
		firstPanel.add(hotelAddressField);

		secondPanel.add(nrSingleRooms);
		secondPanel.add(nrSingleRoomsField);
		secondPanel.add(prSingleRooms);
		secondPanel.add(prSingleRoomsField);

		secondPanel.add(nrDoubleRooms);
		secondPanel.add(nrDoubleRoomsField);
		secondPanel.add(prDoubleRooms);
		secondPanel.add(prDoubleRoomsField);

		secondPanel.add(nrTripleRooms);
		secondPanel.add(nrTripleRoomsField);
		secondPanel.add(prTripleRooms);
		secondPanel.add(prTripleRoomsField);

		secondPanel.add(nrApartments);
		secondPanel.add(nrApartmentsField);
		secondPanel.add(prApartments);
		secondPanel.add(prApartmentsField);

		contentPanel.add(hotelInfoField);
		contentPanel.add(hotelInfoButton);
		contentPanel.add(firstPanel);
		contentPanel.add(secondPanel);
		contentPanel.add(editHotelButton);
		contentPanel.add(clearButton);
		contentPanel.add(deleteButton);
	}

	@Override
	public void addActionListeners(ActionListener actionListener) {
		hotelInfoButton.addActionListener(actionListener);
		editHotelButton.addActionListener(actionListener);
		clearButton.addActionListener(actionListener);
		deleteButton.addActionListener(actionListener);
	}

	public void dispose() {
		instance = null;
		super.dispose();
	}

	@Override
	public String[] getInput() {
		String[] input = new String[12];
		input[0] = hotelInfoField.getText();
		input[1] = hotelNameField.getText();
		input[2] = hotelCityField.getText();
		input[3] = hotelAddressField.getText();
		input[4] = nrSingleRoomsField.getText();
		input[5] = prSingleRoomsField.getText();
		input[6] = nrDoubleRoomsField.getText();
		input[7] = prDoubleRoomsField.getText();
		input[8] = nrTripleRoomsField.getText();
		input[9] = prTripleRoomsField.getText();
		input[10] = nrApartmentsField.getText();
		input[11] = prApartmentsField.getText();
		return input;
	}

	@Override
	public void update(String[] update) {
		if(update == null){
			hotelInfoField.setText("");
			hotelNameField.setText("");
			hotelCityField.setText("");
			hotelAddressField.setText("");
			nrSingleRoomsField.setText("");
			prSingleRoomsField.setText("");
			nrDoubleRoomsField.setText("");
			prDoubleRoomsField.setText("");
			nrTripleRoomsField.setText("");
			prTripleRoomsField.setText("");
			nrApartmentsField.setText("");
			prApartmentsField.setText("");
		}
		else{
			hotelNameField.setText(update[0]);
			hotelCityField.setText(update[1]);
			hotelAddressField.setText(update[2]);
			nrSingleRoomsField.setText(update[3]);
			prSingleRoomsField.setText(update[4]);
			nrDoubleRoomsField.setText(update[5]);
			prDoubleRoomsField.setText(update[6]);
			nrTripleRoomsField.setText(update[7]);
			prTripleRoomsField.setText(update[8]);
			nrApartmentsField.setText(update[9]);
			prApartmentsField.setText(update[10]);
		}
	}

}
