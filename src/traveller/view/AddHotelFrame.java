package traveller.view;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Window;
import java.awt.event.ActionListener;
import java.awt.event.WindowFocusListener;

import javax.swing.*;

public class AddHotelFrame extends JDialog implements View {
	private JButton addHotelButton;
	private JButton clearButton;
	private JButton cancelButton;

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

	private static AddHotelFrame instance = null;

	public AddHotelFrame(Window owner, ActionListener actionListener,
			WindowFocusListener focusListener) {
		super(owner, "Add hotel");
		// super(owner, "Register", JDialog.DEFAULT_MODALITY_TYPE);
		createComponents();
		initializeComponents();
		addComponentsToFrame();
		addActionListeners(actionListener);
		addWindowFocusListener(focusListener);
		setVisible(true);
	}

	public static AddHotelFrame getInstance(Window owner,
			ActionListener actionListener, WindowFocusListener focusListener) {
		if (instance == null) {
			instance = new AddHotelFrame(owner, actionListener, focusListener);
			instance.setVisible(true);
		}
		return instance;
	}

	@Override
	public void createComponents() {
		addHotelButton = new JButton("Add hotel");
		clearButton = new JButton("Clear");
		cancelButton = new JButton("Cancel");
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
		this.setName("AddHotelFrame");
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

		contentPanel.add(firstPanel);
		contentPanel.add(secondPanel);
		contentPanel.add(addHotelButton);
		contentPanel.add(clearButton);
		contentPanel.add(cancelButton);
		// contentPanel.setPreferredSize(new Dimension(500, 300));

	}

	@Override
	public void addActionListeners(ActionListener actionListener) {
		addHotelButton.addActionListener(actionListener);
		clearButton.addActionListener(actionListener);
		cancelButton.addActionListener(actionListener);
	}

	@Override
	public String[] getInput() {
		String[] input = new String[11];
		input[0] = hotelNameField.getText();
		input[1] = hotelCityField.getText();
		input[2] = hotelAddressField.getText();
		input[3] = nrSingleRoomsField.getText();
		input[4] = nrDoubleRoomsField.getText();
		input[5] = nrTripleRoomsField.getText();
		input[6] = nrApartmentsField.getText();
		input[7] = prSingleRoomsField.getText();
		input[8] = prDoubleRoomsField.getText();
		input[9] = prTripleRoomsField.getText();
		input[10] = prApartmentsField.getText();
		return input;
	}

	public void dispose() {
		instance = null;
		super.dispose();
	}
}
